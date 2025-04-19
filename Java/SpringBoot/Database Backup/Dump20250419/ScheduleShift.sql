DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ScheduleShift`(IN lastaddedit_by INT)
BEGIN
    -- Declare variables to hold data
    DECLARE user_id                INT;
    DECLARE designation_id         INT;
    DECLARE schedule_date          DATE;
    
    DECLARE shift1starttime        TIME;
    DECLARE shift1endtime          TIME;
    DECLARE shift2starttime        TIME;
    DECLARE shift2endtime          TIME;
    DECLARE shift3starttime        TIME;
    DECLARE shift3endtime          TIME;
    DECLARE genshiftstarttime      TIME;
    DECLARE genshiftendtime        TIME;
    
    DECLARE scheduletilldate       DATE;
    DECLARE nextscheduledate       DATE;
    DECLARE totemp                 INT;
    DECLARE vschuserid             INT;
    DECLARE currentshiftdate       DATE;
    DECLARE currentshiftstarttime  TIME;
    DECLARE nextshiftstarttime     TIME;  
    DECLARE nextshiftendtime	   TIME;  
    DECLARE leavecount			   INT;
    DECLARE loopforsixdays		   INT;
    DECLARE done                   INT DEFAULT FALSE;

    -- Declare the cursor
    DECLARE sch_cursor CURSOR FOR
        SELECT `ouserid`, `ouserdesignationid` 
        FROM `tmpotheruser` 
        WHERE `ouserdesignationid` IN (
            SELECT `designationid` 
            FROM `tmpdesignation` 
            WHERE `dutytype` = 'Shift'
        )
        ORDER BY `ouserid`;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    Insert into `debug_log` ( `message`, `debug_time`) values ('sch_cursor CURSOR created. 42', now());
    -- Declare handler to set 'done' to true when cursor is exhausted

    -- Assign shift time values
    SET shift1starttime = '07:00';
    SET shift1endtime   = '15:00';
    SET shift2starttime = '15:00';
    SET shift2endtime   = '23:00';
    SET shift3starttime = '23:00';
    SET shift3endtime   = '07:00';
    SET genshiftstarttime = '09:00';
    SET genshiftendtime   = '17:00';

    Insert into `debug_log` ( `message`, `debug_time`) values ('sch_cursor CURSOR created. 55', now());
    -- Open the cursor
    OPEN sch_cursor;

    -- Loop to fetch and process each row
    read_loop: LOOP
        FETCH sch_cursor INTO user_id, designation_id;

        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Get the latest scheduled date for the user
        SELECT MAX(`scheduledate`) INTO scheduletilldate 
        FROM `txnschedule` 
        WHERE `schuserid` = user_id;

		Insert into `debug_log` ( `message`, `debug_time`) values ('After max scheduledate 72', now());

        -- If no previous schedule, handle the assignment based on the number of employees in the shift
        IF scheduletilldate IS NULL THEN
			Insert into `debug_log` ( `message`, `debug_time`) values ('Scheduledate is null. 76', now());
            SELECT count(*) INTO totemp 
            FROM `txnschedule` 
            WHERE schdesignationid = designation_id;

            IF (totemp < 3) THEN
				Insert into `debug_log` ( `message`, `debug_time`) values ('Employees < 3 82', now());
                -- If there are 0, 1, or 2 employees in the shift, assign a new employee
                SELECT `schuserid`, MAX(`scheduledate`), MAX(`fromtime`) 
                INTO vschuserid, currentshiftdate, currentshiftstarttime 
                FROM `txnschedule` 
                WHERE schdesignationid = designation_id
                group by `schuserid`;

                -- If the current shift date is less than today, assign the next shift
                IF ( currentshiftdate is null or currentshiftdate < CURDATE()) THEN
					Insert into `debug_log` ( `message`, `debug_time`) values ('Employees < 3 92', now());
                    SET nextscheduledate = CURDATE() + 1;
                    IF currentshiftstarttime = shift1starttime THEN
                        SET nextshiftstarttime = shift2starttime;
                    ELSEIF currentshiftstarttime = shift2starttime THEN
                        SET nextshiftstarttime = shift3starttime;
                    ELSE
                        SET nextshiftstarttime = shift1starttime;
                        SET nextscheduledate = DATE_ADD(CURDATE(), INTERVAL 1 DAY);  -- Schedule for the next day
                    END IF;
                END IF;
            ELSE
				Insert into `debug_log` ( `message`, `debug_time`) values ('Employees are 2+ 104', now());
                -- If there are already 3 employees in the shift, assign to the general shift
                SET nextscheduledate = CURDATE();  -- General shift starts today
                SET nextshiftstarttime = genshiftstarttime;  -- Use general shift time
            END IF;
        ELSE
			Insert into `debug_log` ( `message`, `debug_time`) values ('Schedule till date is not null. 110', now());
            -- Calculate next scheduled date if the user already has a schedule
            IF (scheduletilldate <= CURDATE() or scheduletilldate >= CURDATE()) THEN
				Insert into `debug_log` ( `message`, `debug_time`) values ('Schedule till date <= system date. 113', now());
                SET nextscheduledate = scheduletilldate+1;
                SELECT `fromtime` INTO currentshiftstarttime 
                FROM `txnschedule`
                WHERE `schuserid` = user_id
                AND `scheduledate` = scheduletilldate;

                -- Determine next shift start time based on the current shift start time
                IF currentshiftstarttime = shift1starttime THEN
                    SET nextshiftstarttime = shift2starttime;
                ELSEIF currentshiftstarttime = shift2starttime THEN
                    SET nextshiftstarttime = shift3starttime;
                ELSE
                    SET nextshiftstarttime = shift1starttime;
                    SET nextscheduledate = DATE_ADD(scheduletilldate, INTERVAL 1 DAY);  -- Assign to the next day
                END IF;
			ELSE 
				Insert into `debug_log` ( `message`, `debug_time`) values ('Schedule till date >= system date. 130', now());
				-- Scheduletill date > current / system date
            END IF;
        END IF;
        
		IF nextshiftstarttime = shift1starttime THEN
			SET nextshiftendtime = shift1endtime;
		ELSE
			IF nextshiftstarttime = shift2starttime THEN
				SET nextshiftendtime = shift2endtime; 
			ELSE
				SET nextshiftendtime = shift3endtime;
			END IF;
		END IF;
        IF (nextshiftstarttime = genshiftstarttime) THEN  -- Use general shift time
                SET nextshiftendtime = genshiftendtime;  -- Use general shift time
        END IF;
        -- Check schedule date against leave data
		SET loopforsixdays = 1;
        day6loop: LOOP
			SELECT count(*) into leavecount from txnleave where `ouserid` = user_id and leaveappstatus = 'Approved' and
				   (nextscheduledate between leavefromdate and leavetodate);
			IF (leavecount = 0) then
				Insert into `debug_log` ( `message`, `debug_time`) values ('Before insert statement 157 ', now());
				INSERT INTO `txnschedule` (`schuserid`, `schdesignationid`, `scheduledate`, `fromtime`, `totime`, `lastaddeditby`, `lasteditdatetime`) 
				VALUES ( user_id, designation_id, nextscheduledate, nextshiftstarttime, nextshiftendtime, lastaddedit_by, now());
			-- ELSE
				-- Develop a logic to assign this schedule to other employee of same designation.
			END IF;
            SET nextscheduledate = nextscheduledate + 1;
			set loopforsixdays = loopforsixdays + 1;
            iF ( (loopforsixdays > 6) or (nextscheduledate >= (CURDATE()))) THEN
				LEAVE day6loop;
            END IF;
		END LOOP day6loop;
    END LOOP;

    -- Close the cursor
    CLOSE sch_cursor;
END$$
DELIMITER ;
