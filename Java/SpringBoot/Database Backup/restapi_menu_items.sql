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
-- Table structure for table `menu_items`
--

DROP TABLE IF EXISTS `menu_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `label` varchar(100) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `parent_id` bigint DEFAULT NULL,
  `position` int DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `menu_items_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `menu_items` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_items`
--
-- ORDER BY:  `id`

LOCK TABLES `menu_items` WRITE;
/*!40000 ALTER TABLE `menu_items` DISABLE KEYS */;
INSERT INTO `menu_items` VALUES (1,'Dashboard','/dashboard','dashboard',NULL,1,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(2,'Products','#','shopping-cart',NULL,2,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(3,'Customers','#','users',NULL,3,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(4,'Reports','#','bar-chart',NULL,4,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(5,'Settings','#','settings',NULL,5,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(6,'All Products','/products',NULL,2,1,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(7,'Categories','/products/categories',NULL,2,2,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(8,'Inventory','/products/inventory',NULL,2,3,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(9,'All Customers','/customers',NULL,3,1,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(10,'Customer Groups','/customers/groups',NULL,3,2,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(11,'Sales Report','/reports/sales',NULL,4,1,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(12,'Product Performance','/reports/products',NULL,4,2,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(13,'Advanced Reports','#',NULL,4,3,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(14,'User Management','/settings/users',NULL,5,1,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(15,'System Settings','/settings/system',NULL,5,2,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(16,'Customer Analysis','/reports/advanced/customers',NULL,13,1,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(17,'Inventory Analysis','/reports/advanced/inventory',NULL,13,2,1,'2025-03-08 08:15:53','2025-03-08 08:15:53'),(18,'Regional Breakdown','/reports/advanced/inventory/regional',NULL,17,1,1,'2025-03-08 08:15:53','2025-03-08 08:15:53');
/*!40000 ALTER TABLE `menu_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-17 11:35:07
