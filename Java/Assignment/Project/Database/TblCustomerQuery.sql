/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.1.44-community : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `crm`;

/*Table structure for table `tblcustomerquery` */

DROP TABLE IF EXISTS `tblcustomerquery`;

CREATE TABLE `tblcustomerquery` (
  `pkQueryID` int(5) NOT NULL AUTO_INCREMENT,
  `CustomerEmailID` varchar(30) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Suggestion` varchar(100) DEFAULT NULL,
  `Response` varchar(100) DEFAULT NULL,
  `fkResponseID` int(5) DEFAULT NULL,
  `fkRegID` int(5) DEFAULT NULL,
  `ResponseDate` date DEFAULT NULL,
  `CreatedDateTime` date DEFAULT NULL,
  `CreatedByIP` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`pkQueryID`),
  KEY `fkResponseID` (`fkResponseID`),
  KEY `fkRegID` (`fkRegID`),
  CONSTRAINT `tblcustomerquery_ibfk_1` FOREIGN KEY (`fkResponseID`) REFERENCES `tblregistration` (`pkRegID`),
  CONSTRAINT `tblcustomerquery_ibfk_2` FOREIGN KEY (`fkRegID`) REFERENCES `tblregistration` (`pkRegID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
