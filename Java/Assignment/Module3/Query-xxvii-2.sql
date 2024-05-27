
/* Create trigger to insert data in emp_log table whenever any update of sal in EMP table. You can set action as ‘New Salary’. */
/* UPDATE emp SET sal = 810 WHERE empno = 7369 AND deptno = 20; */

DELIMITER $$

USE `module3`$$

DROP TRIGGER IF EXISTS `emp_log`$$

CREATE TRIGGER emp_log `emp_log`
AFTER UPDATE ON emp 
FOR EACH ROW
BEGIN
    IF Old.sal != New.sal THEN
        INSERT INTO emp_log VALUES (old.Empno, NOW(), NEW.Sal, "Salary update");
    END IF;

END$$

DELIMITER ;
