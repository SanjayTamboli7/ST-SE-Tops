/* List the emps who are either ‘CLERK’ or ‘ANALYST’ in the Desc order. */
SELECT	*
FROM 	Emp
WHERE	job IN ("CLERK", "ANALYST" )
ORDER BY job DESC 