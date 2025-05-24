-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: restapi
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
-- Table structure for table `mstadmin_user`
--

DROP TABLE IF EXISTS `mstadmin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstadmin_user` (
  `auser_id` int NOT NULL AUTO_INCREMENT,
  `auser_name` varchar(50) NOT NULL,
  `auser_email_id` varchar(50) NOT NULL,
  `auser_contact_no` varchar(10) NOT NULL,
  `auser_password` varchar(30) NOT NULL,
  `auser_status` tinyint(1) NOT NULL,
  `last_edit_date_time` datetime NOT NULL,
  PRIMARY KEY (`auser_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstadmin_user`
--
-- ORDER BY:  `auser_id`

LOCK TABLES `mstadmin_user` WRITE;
/*!40000 ALTER TABLE `mstadmin_user` DISABLE KEYS */;
INSERT INTO `mstadmin_user` VALUES (1,'Sanjay-gmail','Sanjay.tamboli@gmail.com','814213478','password',1,'2025-03-06 15:30:17'),(2,'Sanjay-hotmail','Sanjay_tamboli@hotmail.com','9825434784','password',0,'2025-03-06 15:45:56'),(3,'Sanjay-yahoo','Sanjay_tamboli@yahoo.com','8141234784','password',1,'2025-03-06 15:49:25'),(4,'user1gmail','user1@gmail.com','1234567890','password',1,'2025-03-06 17:21:42');
/*!40000 ALTER TABLE `mstadmin_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-24 16:08:39
