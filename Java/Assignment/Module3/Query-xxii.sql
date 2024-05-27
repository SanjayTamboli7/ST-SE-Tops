
/* Find all the emps who earn the minimum Salary for each job wise in ascending order. */

SELECT M.Empno, M.Ename, M.Job, MIN(M.Sal)
FROM emp M 
GROUP BY M.Empno, M.Ename, M.Job