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
-- Table structure for table `mstotheruser`
--

DROP TABLE IF EXISTS `mstotheruser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstotheruser` (
  `ouserid` int NOT NULL AUTO_INCREMENT,
  `ousername` varchar(50) DEFAULT NULL,
  `ouseremailid` varchar(50) NOT NULL,
  `ousercontactno` varchar(255) DEFAULT NULL,
  `ouserdeptid` int NOT NULL,
  `ouserdesignationid` int NOT NULL,
  `ouserpassword` varchar(50) NOT NULL,
  `ouserstatus` varchar(8) NOT NULL DEFAULT 'Active',
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`ouserid`),
  KEY `ouserdeptid` (`ouserdeptid`),
  KEY `ouserdesignationid` (`ouserdesignationid`),
  CONSTRAINT `mstotheruser_ibfk_1` FOREIGN KEY (`ouserdeptid`) REFERENCES `mstdepartment` (`deptid`),
  CONSTRAINT `mstotheruser_ibfk_2` FOREIGN KEY (`ouserdesignationid`) REFERENCES `mstdesignation` (`designationid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstotheruser`
--

LOCK TABLES `mstotheruser` WRITE;
/*!40000 ALTER TABLE `mstotheruser` DISABLE KEYS */;
INSERT INTO `mstotheruser` VALUES (15,'Sanjay1-Gmail','sanjay1@gmail.com','8141234784',1,3,'password','Active',1,'2025-04-09 12:44:42'),(16,'Sanjay2-Gmail','sanjay2@gmail.com','9825434784',6,8,'password','Active',1,'2025-04-15 06:21:26');
/*!40000 ALTER TABLE `mstotheruser` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_otheruser_insert` AFTER INSERT ON `mstotheruser` FOR EACH ROW BEGIN
  INSERT INTO mstleavebalance (
    ouserid,
    casualeave,
    sickleave,
    privilegeleave,
    maternityleave,
    paternityleave,
    lastaddeditby,
    lasteditdatetime
  ) VALUES (
    NEW.ouserid,
    0, 0, 0, 0, 0,                     -- initialize leave balances to 0
    NEW.lastaddeditby,
    NEW.lasteditdatetime
  );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-19 13:52:44
