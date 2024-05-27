DELIMITER $$

USE `module3`$$

DROP PROCEDURE IF EXISTS `GetEmpNameDeptName`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEmpNameDeptName`(IN dno INT)
BEGIN
	SELECT 	M.Ename, M.job, D.Dname, D.Loc 
	FROM 	EMP AS M
	INNER JOIN Dept D
	ON M.Deptno = D.Deptno  ;
END$$

DELIMITER ;