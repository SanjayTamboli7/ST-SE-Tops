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
-- Table structure for table `mstuom`
--

DROP TABLE IF EXISTS `mstuom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstuom` (
  `uomid` int NOT NULL AUTO_INCREMENT,
  `uomname` varchar(10) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`uomid`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstuom`
--
-- ORDER BY:  `uomid`

LOCK TABLES `mstuom` WRITE;
/*!40000 ALTER TABLE `mstuom` DISABLE KEYS */;
INSERT INTO `mstuom` VALUES (1,'B15','BAG 15',1,'2025-04-26 06:04:28'),(2,'B25','BAG 25',1,'2025-04-26 05:18:51'),(3,'B50','BAG 50',1,'2025-04-26 05:18:51'),(4,'BBL','Barrel - Liquid Measure',1,'2025-04-26 05:18:51'),(5,'BOX','Box',1,'2025-04-26 05:18:51'),(6,'BRL','BARREL',1,'2025-04-26 05:18:51'),(7,'BSD','Bushel - Dry Measure',1,'2025-04-26 05:18:51'),(8,'CAN','CAN',1,'2025-04-26 05:18:51'),(9,'CCM','Cubic Centimeters',1,'2025-04-26 05:18:51'),(10,'CDM','Cubic Decimeters',1,'2025-04-26 05:18:51'),(11,'CG','Centigrams',1,'2025-04-26 05:18:51'),(12,'CHN','Chain',1,'2025-04-26 05:18:51'),(13,'CL','Centiliters',1,'2025-04-26 05:18:51'),(14,'CM','Centimeters',1,'2025-04-26 05:18:51'),(15,'CMM','Cubic Millimeters',1,'2025-04-26 05:18:51'),(16,'CRT','CRATE',1,'2025-04-26 05:18:51'),(17,'CS','Case',1,'2025-04-26 05:18:51'),(18,'CUF','Cubic Feet',1,'2025-04-26 05:18:51'),(19,'CUI','Cubic Inches',1,'2025-04-26 05:18:51'),(20,'CUM','Cubic Meters',1,'2025-04-26 05:18:51'),(21,'CUY','Cubic Yards',1,'2025-04-26 05:18:51'),(22,'DAY','Days',1,'2025-04-26 05:18:51'),(23,'DG','Decigrams',1,'2025-04-26 05:18:51'),(24,'DL','Deciliters',1,'2025-04-26 05:18:51'),(25,'DM','Decimeters',1,'2025-04-26 05:18:51'),(26,'DOZ','Dozen',1,'2025-04-26 05:18:51'),(27,'DRA','Dram',1,'2025-04-26 05:18:51'),(28,'DRM','DRUM',1,'2025-04-26 05:18:51'),(29,'EA','Each',1,'2025-04-26 05:18:51'),(30,'FOZ','Fluid Ounce ',1,'2025-04-26 05:18:51'),(31,'FT','Feet',1,'2025-04-26 05:18:51'),(32,'G','Grams',1,'2025-04-26 05:18:51'),(33,'GAL','Gallon - US Liquid Measure',1,'2025-04-26 05:18:51'),(34,'GRP','Grains ',1,'2025-04-26 05:18:51'),(35,'GRS','Gross',1,'2025-04-26 05:18:51'),(36,'GRT','Grains - Troy',1,'2025-04-26 05:18:51'),(37,'HUN','Hundreds',1,'2025-04-26 05:18:51'),(38,'IN','Inches',1,'2025-04-26 05:18:51'),(39,'KG','Kilograms',1,'2025-04-26 05:18:51'),(40,'KGF','Kilograms of Force per CM',1,'2025-04-26 05:18:51'),(41,'KL','Kiloliters',1,'2025-04-26 05:18:51'),(42,'KM','Kilometers',1,'2025-04-26 05:18:51'),(43,'KWH','Kilowatt Hours',1,'2025-04-26 05:18:51'),(44,'L','Liters',1,'2025-04-26 05:18:51'),(45,'LBS','Pounds',1,'2025-04-26 05:18:51'),(46,'LBT','Pounds - Troy',1,'2025-04-26 05:18:51'),(47,'LNK','Link',1,'2025-04-26 05:18:51'),(48,'LOT','Batch Lot',1,'2025-04-26 05:18:51'),(49,'LT','Long Tons',1,'2025-04-26 05:18:51'),(50,'M','Meters',1,'2025-04-26 05:18:51'),(51,'MDY','Person Day',1,'2025-04-26 05:18:51'),(52,'MG','Milligrams',1,'2025-04-26 05:18:51'),(53,'MHR','Work Hour',1,'2025-04-26 05:18:51'),(54,'MIL','Miles',1,'2025-04-26 05:18:51'),(55,'ML','Milliliters',1,'2025-04-26 05:18:51'),(56,'MM','Millimeters',1,'2025-04-26 05:18:51'),(57,'MMO','Work Month',1,'2025-04-26 05:18:51'),(58,'MT','Metric Tons',1,'2025-04-26 05:18:51'),(59,'MWK','Work Week',1,'2025-04-26 05:18:51'),(60,'OZT','Ounces - Troy',1,'2025-04-26 05:18:51'),(61,'PK','Cello Pack',1,'2025-04-26 05:18:51'),(62,'PKD','Peck - Dry Measure',1,'2025-04-26 05:18:51'),(63,'PL','Pallet',1,'2025-04-26 05:18:51'),(64,'PTD','Pint - Dry Measure',1,'2025-04-26 05:18:51'),(65,'PTL','Pint - Liquid Measure',1,'2025-04-26 05:18:51'),(66,'PWT','Pennyweight - Troy',1,'2025-04-26 05:18:51'),(67,'QTD','Quart - Dry Measure',1,'2025-04-26 05:18:51'),(68,'QTL','Quart - Liquid Measure',1,'2025-04-26 05:18:51'),(69,'SCM','Square Centimeters',1,'2025-04-26 05:18:51'),(70,'SDM','Square Decimeters',1,'2025-04-26 05:18:51'),(71,'SF','Square Feet',1,'2025-04-26 05:18:51'),(72,'SHT','Short Ton',1,'2025-04-26 05:18:51'),(73,'SHW','Short Hundred Weight',1,'2025-04-26 05:18:51'),(74,'SLV','Sleeve',1,'2025-04-26 05:18:51'),(75,'SM','Square Meters',1,'2025-04-26 05:18:51'),(76,'SMM','Square Millimeters',1,'2025-04-26 05:18:51'),(77,'SQF','Square Feet',1,'2025-04-26 05:18:51'),(78,'SQI','Square Inches',1,'2025-04-26 05:18:51'),(79,'SQM','Square Miles',1,'2025-04-26 05:18:51'),(80,'SQY','Square Yards',1,'2025-04-26 05:18:51'),(81,'ST','Short Tons',1,'2025-04-26 05:18:51'),(82,'TON','Tons',1,'2025-04-26 05:18:51'),(83,'TRK','TRUCK LOAD',1,'2025-04-26 05:18:51'),(84,'TUB','TUB',1,'2025-04-26 05:18:51'),(85,'UNT','Units (generic)',1,'2025-04-26 05:18:51'),(86,'YD','Yard',1,'2025-04-26 05:18:51');
/*!40000 ALTER TABLE `mstuom` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-17 11:35:05
