DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ScheduleShift`(IN lastaddedit_by INT)
BEGIN
    -- Declare necessary variables
    DECLARE user_id INT;
    DECLARE designation_id INT;
    DECLARE scheduletilldate DATE;
    DECLARE shift1starttime TIME DEFAULT '07:00';
    DECLARE shift1endtime TIME DEFAULT '15:00';
    DECLARE shift2starttime TIME DEFAULT '15:00';
    DECLARE shift2endtime TIME DEFAULT '23:00';
    DECLARE shift3starttime TIME DEFAULT '23:00';
    DECLARE shift3endtime TIME DEFAULT '07:00';
    DECLARE genshiftstarttime TIME DEFAULT '09:00';
    DECLARE genshiftendtime TIME DEFAULT '17:00';
    DECLARE nextscheduledate DATE;
    DECLARE nextshiftstarttime TIME;
    DECLARE nextshiftendtime TIME;
    DECLARE user_schedule_count INT;
    DECLARE leavecount INT;
    DECLARE loopforsixdays INT;
    DECLARE done INT DEFAULT FALSE;

    -- Declare the cursor to loop through the users with 'Shift' duty type
    DECLARE sch_cursor CURSOR FOR
        SELECT `ouserid`, `ouserdesignationid`
        FROM `mstotheruser`
        WHERE `ouserdesignationid` IN (SELECT `designationid` FROM `mstdesignation` WHERE `dutytype` = 'Shift')
        ORDER BY `ouserid`;

    -- Declare handler for cursor exhaustion
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Open the cursor
    OPEN sch_cursor;

    -- Main loop to process each user
    read_loop: LOOP
        FETCH sch_cursor INTO user_id, designation_id;

        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Get the latest scheduled date for the user
        SELECT MAX(`scheduledate`) INTO scheduletilldate
        FROM `txnschedule`
        WHERE `schuserid` = user_id;

        -- If no previous schedule exists for the user
        IF scheduletilldate IS NULL THEN
            SET nextscheduledate = CURDATE(); -- Start scheduling from today
        ELSE
            SET nextscheduledate = DATE_ADD(scheduletilldate, INTERVAL 1 DAY); -- Next day
        END IF;

        -- Loop to schedule the user for 6 days
        SET loopforsixdays = 1;
        day6loop: LOOP
            -- Check if the user has approved leave for the current date
            SELECT COUNT(*) INTO leavecount
            FROM `txnleave`
            WHERE `ouserid` = user_id
              AND `leaveappstatus` = 'Approved'
              AND `nextscheduledate` BETWEEN `leavefromdate` AND `leavetodate`;

            -- If the user is on approved leave, skip this day
            IF leavecount > 0 THEN
                -- Skip the current scheduled day
                SET nextscheduledate = DATE_ADD(nextscheduledate, INTERVAL 1 DAY);
                ITERATE day6loop;  -- Skip to the next day
            ELSE
                -- Determine the number of employees already scheduled for the shift on `nextscheduledate`
                SELECT COUNT(*) INTO user_schedule_count
                FROM `txnschedule`
                WHERE `schdesignationid` = designation_id
                  AND `scheduledate` = nextscheduledate;

                -- If less than 3 employees are scheduled, assign to the shift
                IF user_schedule_count < 3 THEN
                    IF loopforsixdays <= 6 THEN
                        -- Assign to shift based on the loop day
                        IF user_schedule_count = 0 THEN
                            SET nextshiftstarttime = shift1starttime;
                            SET nextshiftendtime = shift1endtime;
                        ELSEIF user_schedule_count = 1 THEN
                            SET nextshiftstarttime = shift2starttime;
                            SET nextshiftendtime = shift2endtime;
                        ELSEIF user_schedule_count = 2 THEN
                            SET nextshiftstarttime = shift3starttime;
                            SET nextshiftendtime = shift3endtime;
                        END IF;

                        -- Insert the schedule for the user
                        INSERT INTO `txnschedule` (`schuserid`, `schdesignationid`, `scheduledate`, `fromtime`, `totime`, `lastaddeditby`, `lasteditdatetime`)
                        VALUES (user_id, designation_id, nextscheduledate, nextshiftstarttime, nextshiftendtime, lastaddedit_by, NOW());
                    END IF;
                ELSE
                    -- If 3 employees are already scheduled, assign to the general shift
                    SET nextshiftstarttime = genshiftstarttime;
                    SET nextshiftendtime = genshiftendtime;

                    -- Insert the schedule for the user
                    INSERT INTO `txnschedule` (`schuserid`, `schdesignationid`, `scheduledate`, `fromtime`, `totime`, `lastaddeditby`, `lasteditdatetime`)
                    VALUES (user_id, designation_id, nextscheduledate, nextshiftstarttime, nextshiftendtime, lastaddedit_by, NOW());
                END IF;

                -- Move to the next day and increment the loop counter
                SET nextscheduledate = DATE_ADD(nextscheduledate, INTERVAL 1 DAY);
                SET loopforsixdays = loopforsixdays + 1;

                -- If 6 days are completed, leave the loop
                IF loopforsixdays > 6 THEN
                    LEAVE day6loop;
                END IF;
            END IF;
        END LOOP day6loop;
    END LOOP read_loop;

    -- Close the cursor after processing
    CLOSE sch_cursor;
    
END$$
DELIMITER ;
