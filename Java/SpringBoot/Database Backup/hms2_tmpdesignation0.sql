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
-- Table structure for table `tmpdesignation`
--

DROP TABLE IF EXISTS `tmpdesignation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmpdesignation` (
  `designationid` int NOT NULL DEFAULT '0',
  `designationname` varchar(50) NOT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  `dutytype` varchar(7) NOT NULL DEFAULT 'General'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmpdesignation`
--

LOCK TABLES `tmpdesignation` WRITE;
/*!40000 ALTER TABLE `tmpdesignation` DISABLE KEYS */;
INSERT INTO `tmpdesignation` VALUES (2,'Doctor',1,'2025-04-05 17:13:18','General'),(3,'Anaesthetist',1,'2025-04-05 17:14:44','General'),(5,'Assistant Surgeon',1,'2025-04-05 00:00:00','General'),(6,'Blood Bank Technician',1,'2025-04-05 00:00:00','Shift'),(7,'Civil Surgeon',1,'2025-04-05 00:00:00','General'),(8,'Clerk',1,'2025-04-05 00:00:00','Shift'),(9,'Cook',1,'2025-04-05 00:00:00','Shift'),(10,'Dark Room Attendent',1,'2025-04-05 00:00:00','General'),(11,'Deputy Medical Suprintendent',1,'2025-04-05 00:00:00','General'),(13,'Dhobi',1,'2025-04-05 00:00:00','Shift'),(14,'Dietician',1,'2025-04-05 00:00:00','General'),(15,'Dispenser',1,'2025-04-05 00:00:00','Shift'),(16,'Dresser',1,'2025-04-05 00:00:00','Shift'),(17,'Driver',1,'2025-04-05 00:00:00','Shift'),(18,'General Physician',1,'2025-04-05 00:00:00','General'),(19,'Head Nurse',1,'2025-04-05 00:00:00','General'),(20,'Hospital Attendant',1,'2025-04-05 00:00:00','General'),(21,'House Physician',1,'2025-04-05 00:00:00','General'),(22,'Junior Superintendent',1,'2025-04-05 00:00:00','General'),(23,'Lab Attendent',1,'2025-04-05 00:00:00','General'),(24,'Laboratory Technician',1,'2025-04-05 00:00:00','Shift'),(25,'Medical Officer',1,'2025-04-05 00:00:00','General'),(26,'Medical Superintendent',1,'2025-04-05 00:00:00','General'),(27,'Nursing Assistant',1,'2025-04-05 00:00:00','Shift'),(28,'Nursing Staff',1,'2025-04-05 00:00:00','Shift'),(34,'Logistic',17,'2025-04-09 13:03:06','Shift');
/*!40000 ALTER TABLE `tmpdesignation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-26  4:48:09
