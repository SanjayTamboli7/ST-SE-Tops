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
-- Table structure for table `txngrndetails`
--

DROP TABLE IF EXISTS `txngrndetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `txngrndetails` (
  `grndetailid` int NOT NULL AUTO_INCREMENT,
  `grnid` int NOT NULL,
  `itemid` int NOT NULL,
  `orderedqty` int NOT NULL DEFAULT '0',
  `receivedqty` int NOT NULL DEFAULT '0',
  `acceptedqty` int NOT NULL DEFAULT '0',
  `rejectedqty` int NOT NULL DEFAULT '0',
  `batchno` varchar(50) DEFAULT NULL,
  `expirydate` date DEFAULT NULL,
  `podetailid` int DEFAULT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`grndetailid`),
  KEY `grnid` (`grnid`),
  KEY `itemid` (`itemid`),
  CONSTRAINT `txngrndetails_ibfk_1` FOREIGN KEY (`grnid`) REFERENCES `txngrnheader` (`grnid`),
  CONSTRAINT `txngrndetails_ibfk_2` FOREIGN KEY (`itemid`) REFERENCES `mstitem` (`itemid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txngrndetails`
--
-- ORDER BY:  `grndetailid`

LOCK TABLES `txngrndetails` WRITE;
/*!40000 ALTER TABLE `txngrndetails` DISABLE KEYS */;
INSERT INTO `txngrndetails` VALUES (1,1,1,50,45,43,2,'BATCH123','2025-12-31',4,15,'2025-05-24 16:05:36'),(2,2,1,50,45,43,2,'BATCH123','2025-12-31',4,15,'2025-05-24 16:05:37'),(3,3,1,50,45,43,2,'BATCH123','2025-12-31',4,15,'2025-05-24 16:05:38'),(4,4,1,50,45,43,2,'BATCH123','2025-12-31',4,15,'2025-05-24 16:05:39');
/*!40000 ALTER TABLE `txngrndetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-24 16:08:35
