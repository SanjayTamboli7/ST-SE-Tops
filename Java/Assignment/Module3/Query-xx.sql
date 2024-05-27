/* Find the total sal given to the MGR. */

SELECT 	SUM(M.Sal)
FROM 	EMP AS M
WHERE 	M.Empno IN (SELECT C.Mgr FROM emp AS C)
