/* Any jobs of deptno 10 those that are not found in deptno 20.  */

SELECT 	M.empno, M.Ename, M.job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.Deptno
FROM 	EMP AS M
WHERE 	M.Deptno = 10 AND M.job NOT IN (SELECT C.job FROM emp AS C WHERE C.Deptno = 20)
