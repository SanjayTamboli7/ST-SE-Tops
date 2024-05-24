/* List the Emps who’s Sal is same as FORD or SMITH in desc order of Sal. */

SELECT 	M.empno, M.Ename, M.job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.Deptno
FROM 	EMP AS M
WHERE 	M.sal IN (SELECT C.sal FROM emp AS C WHERE C.ename IN ("FORD", "SMITH"))
