DELIMITER $$

CREATE PROCEDURE cs1(IN lastaddedit_by INT)
BEGIN
	-- Declare variables to hold data
	DECLARE user_id 	INT;
	DECLARE designation_id	INT;
  	DECLARE schedule_date 	DATE;
  	DECLARE from_time	DATE;
  	DECLARE to_time 	DATE;
  	DECLARE shift1starttime	VARCHAR(5) DEFAULT `07:00`;
   	DECLARE shift1endtime	VARCHAR(5) DEFAULT `15:00`;
  	DECLARE shift2starttime	VARCHAR(5) DEFAULT `15:00`;
  	DECLARE shift2endtime	VARCHAR(5) DEFAULT `23:00`;
  	DECLARE shift3starttime	VARCHAR(5) DEFAULT `23:00`;
  	DECLARE shift3endtime	VARCHAR(5) DEFAULT `07:00`;

	-- Cursor control variable
	DECLARE done INT DEFAULT FALSE;

	-- Declare the cursor
    	DECLARE sch_cursor CURSOR FOR
        SELECT `ouserid`, `ouserdesignationid` from `tmpotheruser` where ouserdesignationid in (select `designationid` from `tmpdesignation` where `dutytype` = 'Shift')
        order by `ouserid`;

        -- Declare handler to set 'done' to true when cursor is exhausted
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

        -- Open the cursor
        OPEN sch_cursor;

        -- Loop to fetch and process each row
        read_loop: LOOP
        	FETCH sch_cursor INTO user_id, designation_id;
        
        	IF done THEN
            		LEAVE read_loop;
        	END IF;

		-- Insert the employee data into the log table
		-- INSERT INTO employee_log (employee_id, employee_name, department_id)
        	-- VALUES (emp_id, emp_name, dept_id);
    	END LOOP;

	-- Close the cursor
	CLOSE sch_cursor;
END$$

DELIMITER ;
