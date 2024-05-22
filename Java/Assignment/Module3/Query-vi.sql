/* List the Empno, Ename, Sal, Exp of all emps working for Mgr 7369. */
SELECT Empno, Ename, Sal
FROM   emp
WHERE  mgr = 7369;