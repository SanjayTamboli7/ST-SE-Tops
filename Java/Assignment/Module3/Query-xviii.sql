/* Find the highest sal of EMP table. */

SELECT M.Empno, M.Ename, M.Job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.deptno
FROM emp M 
WHERE Sal IN (SELECT MAX(C.Sal) FROM emp c) ;
