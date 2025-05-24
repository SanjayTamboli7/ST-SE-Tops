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
-- Table structure for table `mstholiday`
--

DROP TABLE IF EXISTS `mstholiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstholiday` (
  `holidaydate` date NOT NULL,
  `holidayname` varchar(50) NOT NULL,
  `holidaytype` varchar(10) DEFAULT NULL,
  `holidaydescription` varchar(255) DEFAULT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`holidaydate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstholiday`
--
-- ORDER BY:  `holidaydate`

LOCK TABLES `mstholiday` WRITE;
/*!40000 ALTER TABLE `mstholiday` DISABLE KEYS */;
INSERT INTO `mstholiday` VALUES ('2025-01-01','New Year Day','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-01-13','Lohri','Religious','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-01-14','Makar Sankranti / Pongal','Religious','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-01-26','Republic Day','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-02-03','Basant Panchami','Religious','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-02-12','Guru Ravidas Jayanti','Religious','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-02-19','Shivaji Jayanti','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-02-23','Swami Dayananda Saraswati Jayanti','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-02-25','Maha Shivaratri','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-03-12','Holika Dahan','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-03-15','Holi','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-03-28','Jamat-Ul-Vida','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-03-30','Chaitra Sukhladi','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-03-31','Id-ul- Fitr','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-04-06','Ram Navami','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-04-10','Mahavir Jayanti','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-04-15','Vaisakhi / Vishu / Meshadi','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-04-18','Good Friday','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-04-20','Easter Sunday','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-05-08','Guru Rabindranath Birthday','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-05-12','Buddha Purnima','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-06-07','Id-ul-Zuha (Bakrid)','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-06-27','Rath Yatra','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-07-06','Muharram','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-08-08','Raksha Bandhan','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-08-14','Janmashtami','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-08-15','Independence Day Parsi New Year','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-08-26','Ganesh Chaturthi','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-09-05','Onam','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-09-29','Maha Saptami','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-09-30','Maha Ashtami','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-10-02','Maha Navami','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-10-07','Maharishi Valmiki Birthday','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-10-10','Karaka Chaturthi','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-10-20','Diwali / Deepavali','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-10-22','Govardhan Puja','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-10-23','Bhai Duj','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-10-28','Pratihar Sashthi','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-11-05','Guru Nanak Birthday','National','Gazetted Holiday',1,'2025-04-10 00:00:00'),('2025-11-19','Guru Tegh Bahadur Martyrdom Day','National','Restricted Holiday',1,'2025-04-10 00:00:00'),('2025-12-25','Christmas Day','National','Gazetted Holiday',1,'2025-04-10 00:00:00');
/*!40000 ALTER TABLE `mstholiday` ENABLE KEYS */;
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
