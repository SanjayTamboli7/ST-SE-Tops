/* List the emps whose jobs same as SMITH or ALLEN.  */

SELECT 	M.empno, M.Ename, M.job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.Deptno
FROM 	EMP AS M
WHERE 	M.job IN (SELECT C.job FROM emp AS C WHERE C.ename IN ("ALLEN", "SMITH"))
