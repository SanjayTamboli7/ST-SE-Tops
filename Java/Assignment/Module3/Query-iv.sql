/* List the emps who joined before 1981. */
SELECT	*, YEAR(hiredate)
FROM 	emp 
WHERE YEAR(hiredate) < 1981;
