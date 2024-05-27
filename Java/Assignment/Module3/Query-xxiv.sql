/* Create view v1 to select ename, job, dname, loc whose deptno are same. */

SELECT 	M.Ename, M.job, D.Dname, D.Loc 
FROM 	EMP AS M
INNER JOIN Dept D
ON M.Deptno = D.Deptno  
