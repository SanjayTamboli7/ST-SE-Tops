-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: menudb
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
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content_id` varchar(255) DEFAULT NULL,
  `display_order` int DEFAULT NULL,
  `level` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint DEFAULT NULL,
  `order_index` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgeupubdqncc1lpgf2cn4fqwbc` (`parent_id`),
  CONSTRAINT `FKgeupubdqncc1lpgf2cn4fqwbc` FOREIGN KEY (`parent_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'dashboard',1,0,'Dashboard',NULL,0),(2,NULL,2,0,'User Management',NULL,0),(3,NULL,3,0,'Reports',NULL,0),(4,NULL,4,0,'Configuration',NULL,0),(5,NULL,5,0,'Help',NULL,0),(6,NULL,1,1,'View Users',2,0),(7,NULL,2,1,'User Groups',2,0),(8,NULL,3,1,'Permissions',2,0),(9,NULL,4,1,'Access Control',2,0),(10,NULL,5,1,'Audit Logs',2,0),(11,NULL,1,1,'System Reports',3,0),(12,NULL,2,1,'User Reports',3,0),(13,NULL,3,1,'Performance Reports',3,0),(14,NULL,4,1,'Security Reports',3,0),(15,NULL,5,1,'Custom Reports',3,0),(16,NULL,1,1,'System Settings',4,0),(17,NULL,2,1,'Appearance',4,0),(18,NULL,3,1,'Notifications',4,0),(19,NULL,4,1,'Backup & Restore',4,0),(20,NULL,5,1,'Integrations',4,0),(21,NULL,1,1,'Documentation',5,0),(22,NULL,2,1,'FAQs',5,0),(23,NULL,3,1,'Support Tickets',5,0),(24,NULL,4,1,'Training Videos',5,0),(25,NULL,5,1,'Contact Support',5,0),(26,'all-users',1,2,'All Users',6,0),(27,'active-users',2,2,'Active Users',6,0),(28,'inactive-users',3,2,'Inactive Users',6,0),(29,'locked-users',4,2,'Locked Users',6,0),(30,'user-details',5,2,'User Details',6,0),(31,'users-by-department',1,3,'By Department',26,0),(32,'users-by-role',2,3,'By Role',26,0),(33,'users-by-location',3,3,'By Location',26,0),(34,'users-by-status',4,3,'By Status',26,0),(35,'users-by-access-level',5,3,'By Access Level',26,0),(36,'top-management-users',1,4,'Top Management',31,0),(37,'middle-management-users',2,4,'Middle Management',31,0),(38,'regular-staff-users',3,4,'Regular Staff',31,0),(39,'contractor-users',4,4,'Contractors',31,0),(40,'temporary-staff-users',5,4,'Temporary Staff',31,0),(41,'executive-level-form',1,5,'Executive Level',36,0),(42,'director-level-form',2,5,'Director Level',36,0),(43,'vp-level-form',3,5,'VP Level',36,0),(44,'c-suite-level-form',4,5,'C-Suite Level',36,0),(45,'board-level-form',5,5,'Board Level',36,0),(46,'dashboard',1,0,'Dashboard',NULL,0),(47,NULL,2,0,'User Management',NULL,0),(48,NULL,3,0,'Reports',NULL,0),(49,NULL,4,0,'Configuration',NULL,0),(50,NULL,5,0,'Help',NULL,0),(51,NULL,1,1,'View Users',2,0),(52,NULL,2,1,'User Groups',2,0),(53,NULL,3,1,'Permissions',2,0),(54,NULL,4,1,'Access Control',2,0),(55,NULL,5,1,'Audit Logs',2,0),(56,NULL,1,1,'System Reports',3,0),(57,NULL,2,1,'User Reports',3,0),(58,NULL,3,1,'Performance Reports',3,0),(59,NULL,4,1,'Security Reports',3,0),(60,NULL,5,1,'Custom Reports',3,0),(61,NULL,1,1,'System Settings',4,0),(62,NULL,2,1,'Appearance',4,0),(63,NULL,3,1,'Notifications',4,0),(64,NULL,4,1,'Backup & Restore',4,0),(65,NULL,5,1,'Integrations',4,0),(66,NULL,1,1,'Documentation',5,0),(67,NULL,2,1,'FAQs',5,0),(68,NULL,3,1,'Support Tickets',5,0),(69,NULL,4,1,'Training Videos',5,0),(70,NULL,5,1,'Contact Support',5,0),(71,'all-users',1,2,'All Users',6,0),(72,'active-users',2,2,'Active Users',6,0),(73,'inactive-users',3,2,'Inactive Users',6,0),(74,'locked-users',4,2,'Locked Users',6,0),(75,'user-details',5,2,'User Details',6,0),(76,'users-by-department',1,3,'By Department',26,0),(77,'users-by-role',2,3,'By Role',26,0),(78,'users-by-location',3,3,'By Location',26,0),(79,'users-by-status',4,3,'By Status',26,0),(80,'users-by-access-level',5,3,'By Access Level',26,0),(81,'top-management-users',1,4,'Top Management',31,0),(82,'middle-management-users',2,4,'Middle Management',31,0),(83,'regular-staff-users',3,4,'Regular Staff',31,0),(84,'contractor-users',4,4,'Contractors',31,0),(85,'temporary-staff-users',5,4,'Temporary Staff',31,0),(86,'executive-level-form',1,5,'Executive Level',36,0),(87,'director-level-form',2,5,'Director Level',36,0),(88,'vp-level-form',3,5,'VP Level',36,0),(89,'c-suite-level-form',4,5,'C-Suite Level',36,0),(90,'board-level-form',5,5,'Board Level',36,0),(91,'dashboard',1,0,'Dashboard',NULL,0),(92,NULL,2,0,'User Management',NULL,0),(93,NULL,3,0,'Reports',NULL,0),(94,NULL,4,0,'Configuration',NULL,0),(95,NULL,5,0,'Help',NULL,0),(96,NULL,1,1,'View Users',2,0),(97,NULL,2,1,'User Groups',2,0),(98,NULL,3,1,'Permissions',2,0),(99,NULL,4,1,'Access Control',2,0),(100,NULL,5,1,'Audit Logs',2,0),(101,NULL,1,1,'System Reports',3,0),(102,NULL,2,1,'User Reports',3,0),(103,NULL,3,1,'Performance Reports',3,0),(104,NULL,4,1,'Security Reports',3,0),(105,NULL,5,1,'Custom Reports',3,0),(106,NULL,1,1,'System Settings',4,0),(107,NULL,2,1,'Appearance',4,0),(108,NULL,3,1,'Notifications',4,0),(109,NULL,4,1,'Backup & Restore',4,0),(110,NULL,5,1,'Integrations',4,0),(111,NULL,1,1,'Documentation',5,0),(112,NULL,2,1,'FAQs',5,0),(113,NULL,3,1,'Support Tickets',5,0),(114,NULL,4,1,'Training Videos',5,0),(115,NULL,5,1,'Contact Support',5,0),(116,'all-users',1,2,'All Users',6,0),(117,'active-users',2,2,'Active Users',6,0),(118,'inactive-users',3,2,'Inactive Users',6,0),(119,'locked-users',4,2,'Locked Users',6,0),(120,'user-details',5,2,'User Details',6,0),(121,'users-by-department',1,3,'By Department',26,0),(122,'users-by-role',2,3,'By Role',26,0),(123,'users-by-location',3,3,'By Location',26,0),(124,'users-by-status',4,3,'By Status',26,0),(125,'users-by-access-level',5,3,'By Access Level',26,0),(126,'top-management-users',1,4,'Top Management',31,0),(127,'middle-management-users',2,4,'Middle Management',31,0),(128,'regular-staff-users',3,4,'Regular Staff',31,0),(129,'contractor-users',4,4,'Contractors',31,0),(130,'temporary-staff-users',5,4,'Temporary Staff',31,0),(131,'executive-level-form',1,5,'Executive Level',36,0),(132,'director-level-form',2,5,'Director Level',36,0),(133,'vp-level-form',3,5,'VP Level',36,0),(134,'c-suite-level-form',4,5,'C-Suite Level',36,0),(135,'board-level-form',5,5,'Board Level',36,0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-04 16:23:57
