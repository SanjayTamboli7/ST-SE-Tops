/* List the Enames those are starting with ‘S’ and with five characters. */
SELECT	Ename
FROM 	Emp
WHERE 	`Ename` LIKE "S%" AND LENGTH(Ename) = 5;