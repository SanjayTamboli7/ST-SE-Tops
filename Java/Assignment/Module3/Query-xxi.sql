/* List the emps whose names contains ‘A’. */

SELECT M.Empno, M.Ename, M.Job, M.Mgr, M.Hiredate, M.Sal, M.Comm, M.deptno
FROM emp M 
WHERE LOCATE( "A", M.Ename) > 0;
