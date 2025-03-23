/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.1.44-community : Database - ms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ms` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ms`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customerid` int(10) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `mobno` varchar(10) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `city` varchar(35) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(15) NOT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`customerid`,`firstname`,`lastname`,`mobno`,`address`,`city`,`email`,`password`,`status`) values (1,'Sanjay','Tamboli','9825434784','A-903, Shivalay Height, Stadium Road, Motera, Sabarmati','Ahmedabad','sanjay.tamboli@gmail.com','pass123','Active'),(2,'Sanjay','Tamboli','9825434784','A-903, Shivalay Height, Stadium Road, Motera, Sabarmati','Ahmedabad','sanjay_tamboli@hotmail.com','pass123','Active');

/*Table structure for table `services` */

DROP TABLE IF EXISTS `services`;

CREATE TABLE `services` (
  `serviceid` int(10) NOT NULL AUTO_INCREMENT,
  `servicename` varchar(50) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `services` */

insert  into `services`(`serviceid`,`servicename`,`image`) values (1,'Electric services','ac1.jpg');

/*Table structure for table `subservices` */

DROP TABLE IF EXISTS `subservices`;

CREATE TABLE `subservices` (
  `subserviceid` int(10) NOT NULL AUTO_INCREMENT,
  `serviceid` int(10) DEFAULT NULL,
  `subname` varchar(100) DEFAULT NULL,
  `features` varchar(500) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`subserviceid`),
  KEY `serviceid` (`serviceid`),
  CONSTRAINT `subservices_ibfk_1` FOREIGN KEY (`serviceid`) REFERENCES `services` (`serviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `subservices` */

insert  into `subservices`(`subserviceid`,`serviceid`,`subname`,`features`,`price`) values (1,1,'Install geyser','Install geyser 1','3500');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
