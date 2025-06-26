-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: hms2
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `txnpodetails`
--

DROP TABLE IF EXISTS `txnpodetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `txnpodetails` (
  `podetailid` int NOT NULL AUTO_INCREMENT,
  `poid` int NOT NULL,
  `itemid` int NOT NULL,
  `qty` int NOT NULL,
  `rate` float NOT NULL,
  `amount` float NOT NULL DEFAULT '0',
  `prid` int DEFAULT NULL,
  `lastaddeditby` int NOT NULL DEFAULT '1',
  `lasteditdatetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `grndetailid` int DEFAULT NULL,
  PRIMARY KEY (`podetailid`),
  KEY `poid` (`poid`),
  KEY `itemid` (`itemid`),
  KEY `prid` (`prid`),
  CONSTRAINT `txnpodetails_ibfk_1` FOREIGN KEY (`poid`) REFERENCES `txnpoheader` (`poid`),
  CONSTRAINT `txnpodetails_ibfk_2` FOREIGN KEY (`itemid`) REFERENCES `mstitem` (`itemid`),
  CONSTRAINT `txnpodetails_ibfk_3` FOREIGN KEY (`prid`) REFERENCES `txnpurchaserequest` (`prid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txnpodetails`
--
-- ORDER BY:  `podetailid`

LOCK TABLES `txnpodetails` WRITE;
/*!40000 ALTER TABLE `txnpodetails` DISABLE KEYS */;
INSERT INTO `txnpodetails` VALUES (1,1,1,10,10,100,1,15,'2025-05-19 11:12:55',NULL),(3,2,2,20,20,400,NULL,15,'2025-05-20 05:46:12',NULL),(4,3,1,10,10,100,NULL,15,'2025-05-20 07:27:23',NULL);
/*!40000 ALTER TABLE `txnpodetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-25 16:45:54
