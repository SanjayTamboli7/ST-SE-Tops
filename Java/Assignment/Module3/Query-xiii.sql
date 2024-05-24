/* List the Emps who are senior to their own MGRS.  */

SELECT 	M.empno, M.Ename, M.job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.Deptno
FROM 	EMP AS M
WHERE M.hiredate < (SELECT C.hiredate FROM emp AS C WHERE C.MGR IS NOT NULL AND C.Empno = M.MGr )
