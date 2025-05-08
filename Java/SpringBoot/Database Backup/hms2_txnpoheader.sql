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
-- Table structure for table `txnpoheader`
--

DROP TABLE IF EXISTS `txnpoheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `txnpoheader` (
  `poid` int NOT NULL AUTO_INCREMENT,
  `supplierid` int NOT NULL,
  `podate` date NOT NULL,
  `deliverydate` date DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `totalAmount` float DEFAULT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`poid`),
  KEY `supplierid` (`supplierid`),
  CONSTRAINT `txnpoheader_ibfk_1` FOREIGN KEY (`supplierid`) REFERENCES `mstsupplier` (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txnpoheader`
--

LOCK TABLES `txnpoheader` WRITE;
/*!40000 ALTER TABLE `txnpoheader` DISABLE KEYS */;
INSERT INTO `txnpoheader` VALUES (3,2,'2025-05-06','2025-05-10','Pending',NULL,1,'2025-05-06 16:36:45'),(4,2,'2025-05-06','2025-05-10','Pending',NULL,1,'2025-05-06 16:40:16'),(5,2,'2025-05-06','2025-05-10','Hold',NULL,15,'2025-05-08 14:53:14'),(6,2,'2025-05-06','2025-05-10','Pending',NULL,1,'2025-05-06 16:41:06'),(7,2,'2025-05-06','2025-05-10','Pending',NULL,1,'2025-05-06 16:46:41'),(8,2,'2025-05-06','2025-05-10','Pending',NULL,1,'2025-05-06 16:47:20'),(10,2,'2025-05-06','2025-05-10','Pending',NULL,15,'2025-05-08 14:52:54'),(11,2,'2025-05-08',NULL,'Pending',NULL,15,'2025-05-08 14:50:30'),(12,2,'2025-05-08',NULL,'Pending',NULL,15,'2025-05-08 14:51:04');
/*!40000 ALTER TABLE `txnpoheader` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-08 21:01:09
