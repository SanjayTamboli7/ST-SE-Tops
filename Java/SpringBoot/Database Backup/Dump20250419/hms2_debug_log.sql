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
-- Table structure for table `debug_log`
--

DROP TABLE IF EXISTS `debug_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `debug_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `debug_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debug_log`
--

LOCK TABLES `debug_log` WRITE;
/*!40000 ALTER TABLE `debug_log` DISABLE KEYS */;
INSERT INTO `debug_log` VALUES (9,'sch_cursor CURSOR created. 42','2025-04-19 07:52:38'),(10,'sch_cursor CURSOR created. 55','2025-04-19 07:52:38'),(11,'After max scheduledate 72','2025-04-19 07:52:38'),(12,'Scheduledate is null. 76','2025-04-19 07:52:38'),(13,'Employees < 3 82','2025-04-19 07:52:38'),(14,'Employees < 3 92','2025-04-19 07:52:38'),(15,'Before insert statement 157 ','2025-04-19 07:52:38'),(16,'Before insert statement 157 ','2025-04-19 07:52:38'),(17,'Before insert statement 157 ','2025-04-19 07:52:38'),(18,'Before insert statement 157 ','2025-04-19 07:52:38'),(19,'Before insert statement 157 ','2025-04-19 07:52:38'),(20,'Before insert statement 157 ','2025-04-19 07:52:38'),(21,'sch_cursor CURSOR created. 42','2025-04-19 07:57:56'),(22,'sch_cursor CURSOR created. 55','2025-04-19 07:57:56'),(23,'After max scheduledate 72','2025-04-19 07:57:56'),(24,'Schedule till date is not null. 110','2025-04-19 07:57:56'),(25,'Schedule till date >= system date. 130','2025-04-19 07:57:56'),(26,'Before insert statement 157 ','2025-04-19 07:57:56'),(27,'sch_cursor CURSOR created. 42','2025-04-19 08:09:20'),(28,'sch_cursor CURSOR created. 55','2025-04-19 08:09:20'),(29,'After max scheduledate 72','2025-04-19 08:09:20'),(30,'Schedule till date is not null. 110','2025-04-19 08:09:20'),(31,'Schedule till date <= system date. 113','2025-04-19 08:09:20'),(32,'sch_cursor CURSOR created. 42','2025-04-19 08:18:22'),(33,'sch_cursor CURSOR created. 55','2025-04-19 08:18:22'),(34,'After max scheduledate 72','2025-04-19 08:18:22'),(35,'Schedule till date is not null. 110','2025-04-19 08:18:22'),(36,'Schedule till date <= system date. 113','2025-04-19 08:18:22'),(37,'Before insert statement 157 ','2025-04-19 08:18:22'),(38,'After max scheduledate 72','2025-04-19 08:18:22'),(39,'Scheduledate is null. 76','2025-04-19 08:18:22'),(40,'Employees < 3 82','2025-04-19 08:18:22'),(41,'Employees < 3 92','2025-04-19 08:18:22'),(42,'Before insert statement 157 ','2025-04-19 08:18:22');
/*!40000 ALTER TABLE `debug_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-19 13:52:44
