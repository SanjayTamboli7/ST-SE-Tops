/* List the Empno, Ename, Sal, Daily sal of all emps in the asc order of Annsal. */
SELECT	Empno, Ename, Sal "Salary", (Sal/365) "Daily Sal"
FROM 	emp 
ORDER BY sal;
