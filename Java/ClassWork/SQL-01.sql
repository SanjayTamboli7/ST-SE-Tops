CREATE DATABASE java;
USE java;

CREATE TABLE student(
sid 	INT(10) PRIMARY KEY AUTO_INCREMENT,
sname 	VARCHAR(25) NOT NULL,
city	VARCHAR(35));

INSERT INTO student (sname, city) VALUES ("Rahul", "S-Nagar");
INSERT INTO student (sname, city) VALUES ("Tops", "G-Nagar");
INSERT INTO student (sname, city) VALUES ("Tops", "H-Nagar");
INSERT INTO student (sname, city) VALUES ("Tops", "J-Nagar");

UPDATE student SET city = "Ahmedabad" WHERE sname = "Rahul";

DELETE FROM student WHERE sname = "Rahul" ;

SELECT * FROM student;
SELECT sname, city FROM student;
SELECT sname, city FROM student WHERE sname = "Tops" AND city = "G-Nagar" ;
SELECT sname, city FROM student WHERE city LIKE "%Nagar" ;
SELECT COUNT(*) FROM student;
SELECT MAX(sid) FROM student;
SELECT SUM(sid) FROM student;

