/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.1.44-community : Database - module4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`module4` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `module4`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `book_id_UNIQUE` (`book_id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`book_id`,`title`,`author`,`price`) values (1,'Thinking in Java','Bruce Eckel',25.69),(2,'Effective Java','Joshua Block',27.88),(3,'Head First Java','Kathy Sierra & Bert Bates',23.99),(4,'Java Generics and Collection','Naftalin Philip Wadler',32.56),(5,'The Passionage Programmer','Chad Fowler',41.99),(6,'The Art of Computer Programming','donald E Knuth',199),(7,'Code Complete','Steve McConnell',38.42);

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `Empno` int(4) NOT NULL,
  `Ename` varchar(10) DEFAULT NULL,
  `Job` varchar(9) DEFAULT NULL,
  `Mgr` int(4) DEFAULT NULL,
  `Hiredate` date DEFAULT NULL,
  `Sal` decimal(7,2) DEFAULT NULL,
  `Comm` decimal(7,2) DEFAULT NULL,
  `Deptno` int(2) DEFAULT NULL,
  PRIMARY KEY (`Empno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `emp` */

insert  into `emp`(`Empno`,`Ename`,`Job`,`Mgr`,`Hiredate`,`Sal`,`Comm`,`Deptno`) values (7369,'SMITH','CLERK',7902,'1980-12-17',810.00,NULL,20),(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600.00,300.00,30),(7521,'WARD','SALESMAN',7698,'1981-02-22',1250.00,500.00,30),(7566,'JONES','MANAGER',7839,'1981-04-02',2975.00,NULL,20),(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250.00,1400.00,30),(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850.00,NULL,30),(7782,'CLARK','MANAGER',7839,'1981-06-09',2450.00,NULL,10),(7788,'SCOTT','ANALYST',7566,'1987-06-11',3000.00,NULL,20),(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000.00,NULL,10),(7844,'TURNER','SALESMAN',7698,'1981-08-09',1500.00,0.00,30),(7876,'ADAMS','CLERK',7788,'1987-07-13',1100.00,NULL,20),(7900,'JAMES','CLERK',7698,'1981-03-12',950.00,NULL,30),(7902,'FORD','ANALYST',7566,'1981-03-12',3000.00,NULL,20),(7934,'MILLER','CLERK',7782,'1982-01-23',1300.00,NULL,10);

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `register` */

insert  into `register`(`id`,`name`,`password`,`email`,`sex`,`country`) values (3,'Sanjay Tamboli','password','sanjay.tamboli@hotmail.com','male','India'),(4,'SanjayR','password','sanjay.tamboli@rediffmail.com','male','India');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `mobile` int(10) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`id`,`fname`,`lname`,`email`,`mobile`,`gender`,`password`) values (2,'Sanjay','Tamboli','sanjay.tamboli@gmail.com',12345,'Male','pass123');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UserID` int(3) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`UserID`,`fname`,`lname`,`email`,`mobile`) values (1,'Sanjay1','Tamboli1','sanjay_tamboli@hotmail.com','8141234781'),(2,'Sanjay2','Tamboli2','sanjay_tamboli@gmail.com','8141234782'),(3,'Sanjay3','Tamboli3','sanjay_tamboli@yahoo.com','8141234783'),(4,'Sanjay4','Tamboli','sanjay_tamboli@rediffmail.com','8141234784'),(5,'Sanjay5','Tamboli5','sanjay_tamboli@rediffmail.com','8141234784'),(6,'Sanjay6','Tamboli6','sanjay_tamboli@lycos.com','8141234784');

/*Table structure for table `usermessage` */

DROP TABLE IF EXISTS `usermessage`;

CREATE TABLE `usermessage` (
  `MsgId` int(5) NOT NULL AUTO_INCREMENT,
  `FromUser` varchar(60) DEFAULT NULL,
  `ToUser` varchar(60) DEFAULT NULL,
  `MsgDetail` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`MsgId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `usermessage` */

insert  into `usermessage`(`MsgId`,`FromUser`,`ToUser`,`MsgDetail`) values (1,'Sanjay 1','Sanjay 2','From 1 to 2'),(2,'Sanjay 2','Sanjay 1','From 2 to 1'),(3,'Sanjay 2','Sanjay 4','From 2 to 4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
