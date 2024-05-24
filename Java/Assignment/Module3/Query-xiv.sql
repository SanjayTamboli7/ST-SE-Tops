/* List the Emps of Deptno 20 who’s Jobs are same as Deptno10. */

SELECT 	M.empno, M.Ename, M.job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.Deptno
FROM 	EMP AS M
WHERE 	M.DeptNo = 20 AND M.Job IN (SELECT C.job FROM emp AS C WHERE C.DeptNo = 10)
