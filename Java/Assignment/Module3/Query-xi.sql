/* List the emps whose Empno not starting with digit78. */
SELECT 	* 
FROM 	Emp
WHERE 	empno NOT LIKE "78%"