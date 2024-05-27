/* List the emps whose sal greater than Blake’s sal.  */

SELECT 	M.empno, M.Ename, M.job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.Deptno
FROM 	EMP AS M
WHERE 	M.sal > (SELECT C.sal FROM emp AS C WHERE C.ename = "Blake") 
