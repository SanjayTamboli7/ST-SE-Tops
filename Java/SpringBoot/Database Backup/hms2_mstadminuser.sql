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
-- Table structure for table `mstadminuser`
--

DROP TABLE IF EXISTS `mstadminuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstadminuser` (
  `auserid` int NOT NULL AUTO_INCREMENT,
  `ausername` varchar(255) DEFAULT NULL,
  `auseremailid` varchar(50) NOT NULL,
  `ausercontactno` varchar(255) DEFAULT NULL,
  `auserpassword` varchar(255) NOT NULL,
  `auserstatus` varchar(8) NOT NULL DEFAULT 'Active',
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`auserid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstadminuser`
--
-- ORDER BY:  `auserid`

LOCK TABLES `mstadminuser` WRITE;
/*!40000 ALTER TABLE `mstadminuser` DISABLE KEYS */;
INSERT INTO `mstadminuser` VALUES (1,'Sanjay-Gmail','sanjay.tamboli@gmail.com','8141234784','password','Active','2025-03-22 00:00:00'),(16,'Sanjay2-Gmail','sanjay2@gmail.com','9825434784','password','Inactive','2025-03-24 16:48:11'),(17,'Sanjay3-Gmail','sanjay3@gmail.com','8141234784','password','Active','2025-03-24 16:54:23'),(18,'Sanjay4-Gmail','sanjay4@gmail.com','9825434784','password','Inactive','2025-03-24 16:59:08'),(20,'Sanjay1-Gmail','sanjay1@gmail.com','8141234784','password','','2025-03-29 17:21:21'),(22,'Sanjay5-Gmail','sanjay5@gmail.com','9825434784','password','Active','2025-04-04 10:03:03'),(23,'Sanjay6-Gmail','sanjay6@gmail.com','8141234784','password','','2025-04-04 10:03:56'),(24,'Sanjay7-Gmail','sanjay7@gmail.com','9825434784','password','','2025-04-04 10:04:28'),(25,'Sanjay8-Gmail','sanjay8@gmail.com','8141234784','password','Inactive','2025-04-04 10:04:56'),(26,'Sanjay9-Gmail','sanjay9@gmail.com','9825434784','password','','2025-04-04 10:05:33'),(27,'Sanjay10-Gmail','sanjay10@gmail.com','8141234784','password','','2025-04-04 10:05:58'),(28,'Sanjay11-Gmail','sanjay11@gmail.com','9825434784','password','','2025-04-04 17:14:11');
/*!40000 ALTER TABLE `mstadminuser` ENABLE KEYS */;
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
