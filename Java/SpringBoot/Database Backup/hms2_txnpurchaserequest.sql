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
-- Table structure for table `txnpurchaserequest`
--

DROP TABLE IF EXISTS `txnpurchaserequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `txnpurchaserequest` (
  `prid` int NOT NULL AUTO_INCREMENT,
  `requestedby` int NOT NULL,
  `itemid` int NOT NULL,
  `qty` int NOT NULL,
  `requestdate` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `podetailid` int DEFAULT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`prid`),
  KEY `itemid` (`itemid`),
  KEY `txnpurchaserequest_ibfk_2` (`podetailid`),
  CONSTRAINT `txnpurchaserequest_ibfk_1` FOREIGN KEY (`itemid`) REFERENCES `mstitem` (`itemid`),
  CONSTRAINT `txnpurchaserequest_ibfk_2` FOREIGN KEY (`podetailid`) REFERENCES `txnpodetails` (`podetailid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txnpurchaserequest`
--

LOCK TABLES `txnpurchaserequest` WRITE;
/*!40000 ALTER TABLE `txnpurchaserequest` DISABLE KEYS */;
INSERT INTO `txnpurchaserequest` VALUES (3,15,1,10,'2025-05-01','Approve',NULL,1,'2025-05-01 17:36:22'),(4,16,1,21,'2025-05-01','Pending',NULL,15,'2025-05-01 19:00:59'),(6,16,3,23,'2025-05-01','Reject',NULL,15,'2025-05-01 19:14:12'),(7,16,4,24,'2025-05-01','Approve',NULL,15,'2025-05-01 19:14:07'),(8,15,3,13,'2025-05-01','Pending',NULL,15,'2025-05-01 19:11:39'),(9,15,4,14,'2025-05-01','Pending',NULL,15,'2025-05-01 19:16:00'),(10,15,2,12,'2025-05-01','Pending',NULL,15,'2025-05-01 19:26:50'),(12,15,1,12,'2025-05-03','Pending',NULL,15,'2025-05-03 15:43:18');
/*!40000 ALTER TABLE `txnpurchaserequest` ENABLE KEYS */;
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
