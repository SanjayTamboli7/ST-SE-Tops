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
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstotheruser`
--
-- ORDER BY:  `ouserid`

LOCK TABLES `mstotheruser` WRITE;
/*!40000 ALTER TABLE `mstotheruser` DISABLE KEYS */;
INSERT INTO `mstotheruser` VALUES (15,'Sanjay1-Gmail','sanjay1@gmail.com','8141234784',1,3,'password','Active',1,'2025-04-09 12:44:42'),(16,'Sanjay2-Gmail','sanjay2@gmail.com','9825434784',6,8,'password','Active',1,'2025-04-15 06:21:26'),(17,'User 17','user17@example.com','9876543210',1,2,'password','Active',1,'2025-04-20 13:19:16'),(18,'User 18','user18@example.com','9876543211',1,3,'password','Active',1,'2025-04-20 13:19:16'),(19,'User 19','user19@example.com','9876543212',1,34,'password','Active',1,'2025-04-20 13:19:16'),(20,'User 20','user20@example.com','9876543213',1,5,'password','Active',1,'2025-04-20 13:19:16'),(21,'User 21','user21@example.com','9876543214',1,6,'password','Active',1,'2025-04-20 13:19:16'),(22,'User 22','user22@example.com','9876543215',6,7,'password','Active',1,'2025-04-20 13:21:59'),(23,'User 23','user23@example.com','9876543216',6,8,'password','Active',1,'2025-04-20 13:21:59'),(24,'User 24','user24@example.com','9876543217',6,9,'password','Active',1,'2025-04-20 13:21:59'),(25,'User 25','user25@example.com','9876543218',6,10,'password','Active',1,'2025-04-20 13:21:59'),(26,'User 26','user26@example.com','9876543219',6,11,'password','Active',1,'2025-04-20 13:21:59'),(27,'User 27','user27@example.com','9876543220',11,34,'password','Active',1,'2025-04-20 13:22:19'),(28,'User 28','user28@example.com','9876543221',11,13,'password','Active',1,'2025-04-20 13:22:19'),(29,'User 29','user29@example.com','9876543222',11,14,'password','Active',1,'2025-04-20 13:22:19'),(30,'User 30','user30@example.com','9876543223',11,15,'password','Active',1,'2025-04-20 13:22:19'),(31,'User 31','user31example.com','9876543210',11,2,'password','Active',1,'2025-04-20 13:22:19'),(32,'User 32','user32@example.com','9876543211',12,3,'password','Active',1,'2025-04-20 13:22:42'),(33,'User 33','user33@example.com','9876543212',12,34,'password','Active',1,'2025-04-20 13:22:42'),(34,'User 34','user34@example.com','9876543213',12,5,'password','Active',1,'2025-04-20 13:22:42'),(35,'User 35','user35@example.com','9876543214',12,6,'password','Active',1,'2025-04-20 13:22:42'),(36,'User 36','user36@example.com','9876543215',12,7,'password','Active',1,'2025-04-20 13:22:42'),(37,'User 37','user37@example.com','9876543216',13,8,'password','Active',1,'2025-04-20 13:22:58'),(38,'User 38','user38@example.com','9876543217',13,9,'password','Active',1,'2025-04-20 13:22:58'),(39,'User 39','user39@example.com','9876543218',13,10,'password','Active',1,'2025-04-20 13:22:58'),(40,'User 40','user40@example.com','9876543219',13,11,'password','Active',1,'2025-04-20 13:22:58'),(41,'User 41','user41@example.com','9876543220',13,34,'password','Active',1,'2025-04-20 13:22:58'),(42,'User 42','user42@example.com','9876543221',14,13,'password','Active',1,'2025-04-20 13:23:17'),(43,'User 43','user43@example.com','9876543222',14,14,'password','Active',1,'2025-04-20 13:23:17'),(44,'User 44','user44@example.com','9876543223',14,15,'password','Active',1,'2025-04-20 13:23:17'),(45,'User 45','user45@example.com','9876543223',14,15,'password','Active',1,'2025-04-20 13:23:17'),(46,'User 46','user46@example.com','9876543223',14,15,'password','Active',1,'2025-04-20 13:23:17'),(47,'User 47','user47@example.com','9876543216',24,8,'password','Active',1,'2025-04-20 13:23:37'),(48,'User 48','user48@example.com','9876543217',24,9,'password','Active',1,'2025-04-20 13:23:37'),(49,'User 49','user49@example.com','9876543218',24,10,'password','Active',1,'2025-04-20 13:23:37'),(50,'User 50','user50@example.com','9876543219',24,11,'password','Active',1,'2025-04-20 13:23:37'),(51,'User 51','user51@example.com','9876543220',24,34,'password','Active',1,'2025-04-20 13:23:37'),(52,'User 52','user52@example.com','9876543221',1,13,'password','Active',1,'2025-04-20 13:23:53'),(53,'User 53','user53@example.com','9876543222',1,14,'password','Active',1,'2025-04-20 13:23:53'),(54,'User 54','user54@example.com','9876543223',1,15,'password','Active',1,'2025-04-20 13:23:53'),(55,'User 55','user55@example.com','9876543223',1,15,'password','Active',1,'2025-04-20 13:23:53'),(56,'User 56','user56@example.com','9876543223',1,15,'password','Active',1,'2025-04-20 13:23:53'),(57,'User 57','user57@example.com','9876543216',6,8,'password','Active',1,'2025-04-20 13:24:24'),(58,'User 58','user58@example.com','9876543217',6,9,'password','Active',1,'2025-04-20 13:24:24'),(59,'User 59','user59@example.com','9876543218',6,10,'password','Active',1,'2025-04-20 13:24:24'),(60,'User 60','user60@example.com','9876543219',6,11,'password','Active',1,'2025-04-20 13:24:24'),(61,'User 61','user61@example.com','9876543220',6,34,'password','Active',1,'2025-04-20 13:24:24'),(62,'User 62','user62@example.com','9876543221',11,13,'password','Active',1,'2025-04-20 13:24:44'),(63,'User 63','user63@example.com','9876543222',11,14,'password','Active',1,'2025-04-20 13:24:44'),(64,'User 64','user64@example.com','9876543223',11,15,'password','Active',1,'2025-04-20 13:24:44'),(65,'User 65','user65@example.com','9876543223',11,15,'password','Active',1,'2025-04-20 13:24:44'),(66,'User 66','user66@example.com','9876543223',11,15,'password','Active',1,'2025-04-20 13:24:44'),(67,'User 67','user67@example.com','9876543216',12,8,'password','Active',1,'2025-04-20 13:25:27'),(68,'User 68','user68@example.com','9876543217',12,9,'password','Active',1,'2025-04-20 13:25:42'),(69,'User 69','user69@example.com','9876543218',12,10,'password','Active',1,'2025-04-20 13:25:56'),(70,'User 70','user70@example.com','9876543219',12,11,'password','Active',1,'2025-04-20 13:26:09'),(71,'User 71','user71@example.com','9876543220',12,11,'password','Active',1,'2025-04-20 13:27:42'),(72,'User 72','user72@example.com','9876543221',13,13,'password','Active',1,'2025-04-20 13:28:49'),(73,'User 73','user73@example.com','9876543222',13,14,'password','Active',1,'2025-04-20 13:28:49'),(74,'User 74','user74@example.com','9876543223',13,15,'password','Active',1,'2025-04-20 13:28:49'),(75,'User 75','user75@example.com','9876543223',13,15,'password','Active',1,'2025-04-20 13:28:49'),(76,'User 76','user76@example.com','9876543223',13,15,'password','Active',1,'2025-04-20 13:28:49'),(77,'User 77','user77@xample.com','9876543216',14,8,'password','Active',1,'2025-04-20 13:28:49'),(78,'User 78','user78@example.com','9876543217',14,9,'password','Active',1,'2025-04-20 13:28:49'),(79,'User 79','user79@example.com','9876543218',14,10,'password','Active',1,'2025-04-20 13:28:49'),(80,'User 80','user80@example.com','9876543219',14,11,'password','Active',1,'2025-04-20 13:28:49'),(81,'User 81','user81@example.com','9876543220',14,34,'password','Active',1,'2025-04-20 13:28:49'),(82,'User 82','user82@example.com','9876543221',24,13,'password','Active',1,'2025-04-20 13:28:49'),(83,'User 83','user83@example.com','9876543222',24,14,'password','Active',1,'2025-04-20 13:28:49'),(84,'User 84','user84@example.com','9876543223',24,15,'password','Active',1,'2025-04-20 13:28:49'),(85,'User 85','user85@example.com','9876543223',24,15,'password','Active',1,'2025-04-20 13:28:49'),(86,'User 86','user86@example.com','9876543223',24,15,'password','Active',1,'2025-04-20 13:28:49'),(87,'User 87','user87@example.com','9876543216',1,8,'password','Active',1,'2025-04-20 13:28:49'),(88,'User 88','user88@example.com','9876543217',1,9,'password','Active',1,'2025-04-20 13:28:49'),(89,'User 89','user89@example.com','9876543218',1,10,'password','Active',1,'2025-04-20 13:28:49'),(90,'User 90','user90@example.com','9876543219',1,11,'password','Active',1,'2025-04-20 13:28:49'),(91,'User 91','user91@example.com','9876543220',1,34,'password','Active',1,'2025-04-20 13:28:49'),(92,'User 92','user92@example.com','9876543221',6,13,'password','Active',1,'2025-04-20 13:28:49'),(93,'User 93','user93@example.com','9876543222',6,14,'password','Active',1,'2025-04-20 13:28:49'),(94,'User 94','user94@example.com','9876543223',6,15,'password','Active',1,'2025-04-20 13:28:49'),(95,'User 95','user95@example.com','9876543223',6,15,'password','Active',1,'2025-04-20 13:28:49'),(96,'User 96','user96@example.com','9876543223',6,15,'password','Active',1,'2025-04-20 13:28:49'),(97,'User 97','user97@example.com','9876543216',11,8,'password','Active',1,'2025-04-20 13:28:49'),(98,'User 98','user98@example.com','9876543217',11,9,'password','Active',1,'2025-04-20 13:28:49'),(99,'User 99','user99@example.com','9876543218',11,10,'password','Active',1,'2025-04-20 13:28:49'),(100,'User 100','user100@example.com','9876543219',11,11,'password','Active',1,'2025-04-20 13:28:49'),(101,'User 101','user101@example.com','9876543220',11,34,'password','Active',1,'2025-04-20 13:28:49'),(102,'User 102','user102@example.com','9876543221',12,13,'password','Active',1,'2025-04-20 13:28:49'),(103,'User 103','user103@example.com','9876543222',12,14,'password','Active',1,'2025-04-20 13:28:49'),(104,'User 104','user104@example.com','9876543223',12,15,'password','Active',1,'2025-04-20 13:28:49'),(105,'User 105','user105@example.com','9876543223',12,15,'password','Active',1,'2025-04-20 13:28:49'),(106,'User 106','user106@example.com','9876543223',12,15,'password','Active',1,'2025-04-20 13:28:49'),(107,'User 107','user107@example.com','9876543216',13,8,'password','Active',1,'2025-04-20 13:28:49'),(108,'User 108','user108@example.com','9876543217',13,9,'password','Active',1,'2025-04-20 13:28:49'),(109,'User 109','user109@example.com','9876543218',13,10,'password','Active',1,'2025-04-20 13:28:49'),(110,'User 110','user110@example.com','9876543219',13,11,'password','Active',1,'2025-04-20 13:28:49'),(111,'User 111','user111@example.com','9876543220',13,34,'password','Active',1,'2025-04-20 13:28:49'),(112,'User 112','user112@example.com','9876543221',14,13,'password','Active',1,'2025-04-20 13:28:49'),(113,'User 113','user113@example.com','9876543222',14,14,'password','Active',1,'2025-04-20 13:28:49'),(114,'User 114','user114@example.com','9876543223',14,15,'password','Active',1,'2025-04-20 13:28:49'),(115,'User 115','user115@example.com','9876543223',14,15,'password','Active',1,'2025-04-20 13:28:49'),(116,'User 116','user116@example.com','9876543223',14,15,'password','Active',1,'2025-04-20 13:28:49'),(117,'User 117','user117@example.com','9876543216',24,8,'password','Active',1,'2025-04-20 13:28:49'),(118,'User 118','user118@example.com','9876543217',24,9,'password','Active',1,'2025-04-20 13:28:49'),(119,'User 119','user119@example.com','9876543218',24,10,'password','Active',1,'2025-04-20 13:28:49'),(120,'User 120','user120@example.com','9876543219',24,11,'password','Active',1,'2025-04-20 13:28:49'),(121,'User 121','user121@example.com','9876543220',24,34,'password','Active',1,'2025-04-20 13:28:49'),(122,'User 122','user122@example.com','9876543221',1,13,'password','Active',1,'2025-04-20 13:28:49'),(123,'User 123','user123@example.com','9876543222',1,14,'password','Active',1,'2025-04-20 13:28:49'),(124,'User 124','user124@example.com','9876543223',1,15,'password','Active',1,'2025-04-20 13:28:49'),(125,'User 125','user125@example.com','9876543223',1,15,'password','Active',1,'2025-04-20 13:28:49'),(126,'User 126','user126@example.com','9876543223',1,15,'password','Active',1,'2025-04-20 13:28:49'),(127,'User 127','user127@example.com','9876543216',6,8,'password','Active',1,'2025-04-20 13:28:49'),(128,'User 128','user128@example.com','9876543217',6,9,'password','Active',1,'2025-04-20 13:28:49'),(129,'User 129','user129@example.com','9876543218',6,10,'password','Active',1,'2025-04-20 13:28:49'),(130,'User 130','user130@example.com','9876543219',6,11,'password','Active',1,'2025-04-20 13:28:49'),(131,'User 131','user131@example.com','9876543220',6,34,'password','Active',1,'2025-04-20 13:28:49'),(132,'User 132','user132@example.com','9876543221',11,13,'password','Active',1,'2025-04-20 13:28:49'),(133,'User 133','user133@example.com','9876543222',11,14,'password','Active',1,'2025-04-20 13:28:49'),(134,'User 134','user134@example.com','9876543223',11,15,'password','Active',1,'2025-04-20 13:28:49'),(135,'User 135','user135@example.com','9876543223',11,15,'password','Active',1,'2025-04-20 13:28:49'),(136,'User 136','user136@example.com','9876543223',11,15,'password','Active',1,'2025-04-20 13:28:49'),(137,'User 137','user137@example.com','9876543216',12,8,'password','Active',1,'2025-04-20 13:28:49'),(138,'User 138','user138@example.com','9876543217',12,9,'password','Active',1,'2025-04-20 13:28:49'),(139,'User 139','user139@example.com','9876543218',12,10,'password','Active',1,'2025-04-20 13:28:49'),(140,'User 140','user140@example.com','9876543219',12,11,'password','Active',1,'2025-04-20 13:28:49'),(141,'User 141','user141@example.com','9876543220',12,34,'password','Active',1,'2025-04-20 13:28:49'),(142,'User 142','user142@example.com','9876543221',13,13,'password','Active',1,'2025-04-20 13:28:49'),(143,'User 143','user143@example.com','9876543222',13,14,'password','Active',1,'2025-04-20 13:28:49'),(144,'User 144','user144@example.com','9876543223',13,15,'password','Active',1,'2025-04-20 13:28:49'),(145,'User 145','user145@example.com','9876543223',13,15,'password','Active',1,'2025-04-20 13:28:49'),(146,'User 146','user146@example.com','9876543223',13,15,'password','Active',1,'2025-04-20 13:28:49');
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
    casualleave,
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

-- Dump completed on 2025-05-24 16:08:35
