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
-- Table structure for table `mstdesignation`
--

DROP TABLE IF EXISTS `mstdesignation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstdesignation` (
  `designationid` int NOT NULL AUTO_INCREMENT,
  `designationname` varchar(50) NOT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`designationid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstdesignation`
--

LOCK TABLES `mstdesignation` WRITE;
/*!40000 ALTER TABLE `mstdesignation` DISABLE KEYS */;
INSERT INTO `mstdesignation` VALUES (2,'Doctor',1,'2025-04-05 17:13:18'),(3,'Anaesthetist',1,'2025-04-05 17:14:44'),(5,'Assistant Surgeon',1,'2025-04-05 00:00:00'),(6,'Blood Bank Technician',1,'2025-04-05 00:00:00'),(7,'Civil Surgeon',1,'2025-04-05 00:00:00'),(8,'Clerk',1,'2025-04-05 00:00:00'),(9,'Cook',1,'2025-04-05 00:00:00'),(10,'Dark Room Attendent',1,'2025-04-05 00:00:00'),(11,'Deputy Medical Suprintendent',1,'2025-04-05 00:00:00'),(13,'Dhobi',1,'2025-04-05 00:00:00'),(14,'Dietician',1,'2025-04-05 00:00:00'),(15,'Dispenser',1,'2025-04-05 00:00:00'),(16,'Dresser',1,'2025-04-05 00:00:00'),(17,'Driver',1,'2025-04-05 00:00:00'),(18,'General Physician',1,'2025-04-05 00:00:00'),(19,'Head Nurse',1,'2025-04-05 00:00:00'),(20,'Hospital Attendant',1,'2025-04-05 00:00:00'),(21,'House Physician',1,'2025-04-05 00:00:00'),(22,'Junior Superintendent',1,'2025-04-05 00:00:00'),(23,'Lab Attendent',1,'2025-04-05 00:00:00'),(24,'Laboratory Technician',1,'2025-04-05 00:00:00'),(25,'Medical Officer',1,'2025-04-05 00:00:00'),(26,'Medical Superintendent',1,'2025-04-05 00:00:00'),(27,'Nursing Assistant',1,'2025-04-05 00:00:00'),(28,'Nursing Staff',1,'2025-04-05 00:00:00'),(34,'Logistic',1,'2025-04-16 16:29:00');
/*!40000 ALTER TABLE `mstdesignation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-16 17:51:56
