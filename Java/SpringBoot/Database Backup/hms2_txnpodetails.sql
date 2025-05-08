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
  `rate` decimal(10,2) NOT NULL,
  `amount` decimal(12,2) NOT NULL,
  `prid` int DEFAULT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`podetailid`),
  KEY `poid` (`poid`),
  KEY `itemid` (`itemid`),
  KEY `prid` (`prid`),
  CONSTRAINT `txnpodetails_ibfk_1` FOREIGN KEY (`poid`) REFERENCES `txnpoheader` (`poid`),
  CONSTRAINT `txnpodetails_ibfk_2` FOREIGN KEY (`itemid`) REFERENCES `mstitem` (`itemid`),
  CONSTRAINT `txnpodetails_ibfk_3` FOREIGN KEY (`prid`) REFERENCES `txnpurchaserequest` (`prid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txnpodetails`
--

LOCK TABLES `txnpodetails` WRITE;
/*!40000 ALTER TABLE `txnpodetails` DISABLE KEYS */;
INSERT INTO `txnpodetails` VALUES (1,3,1,5,5.00,25.00,NULL,1,'2025-05-06 16:36:45'),(2,4,1,5,5.00,25.00,NULL,1,'2025-05-06 16:40:16'),(4,6,1,5,5.00,25.00,NULL,1,'2025-05-06 16:41:06'),(5,7,1,5,5.00,25.00,NULL,1,'2025-05-06 16:41:44'),(6,8,1,5,5.00,25.00,NULL,1,'2025-05-06 16:47:20');
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

-- Dump completed on 2025-05-08 21:01:08
