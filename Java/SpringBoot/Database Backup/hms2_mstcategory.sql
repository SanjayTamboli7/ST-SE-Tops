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
-- Table structure for table `mstcategory`
--

DROP TABLE IF EXISTS `mstcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstcategory` (
  `categoryid` int NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(100) DEFAULT NULL,
  `Description` text,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstcategory`
--
-- ORDER BY:  `categoryid`

LOCK TABLES `mstcategory` WRITE;
/*!40000 ALTER TABLE `mstcategory` DISABLE KEYS */;
INSERT INTO `mstcategory` VALUES (1,'Surgical Supplies','Sutures, bandages, gloves, needles, etc.',1,'2025-04-26 04:33:58'),(2,'Diagnostic Supplies','Gauze, swabs, test kits, etc.',1,'2025-04-26 04:33:58'),(3,'First Aid Supplies','Bandages, antiseptic wipes, etc.',1,'2025-04-26 04:33:58'),(4,'Lab Supplies','Test tubes, pipettes, reagents, etc.',1,'2025-04-26 04:33:58'),(5,'Inpatient Supplies','Bed linen, cleaning supplies, etc.',1,'2025-04-26 04:33:58'),(6,'Prescription Drugs','Categorized by class, dosage, etc.',1,'2025-04-26 04:33:58'),(7,'Over-the-Counter (OTC) Drugs','Pain relievers, cough medicines, etc.',1,'2025-04-26 04:33:58'),(8,'Vaccines','Specific to disease prevention',1,'2025-04-26 04:33:58'),(9,'Medical Equipment','Hospital beds, examination tables, monitors, etc.',1,'2025-04-26 04:33:58'),(10,'Diagnostic Equipment','X-ray machines, ECG machines, etc.',1,'2025-04-26 04:33:58'),(11,'Therapeutic Equipment','Oxygen concentrators, wheelchairs, etc.',1,'2025-04-26 04:33:58'),(12,'Laboratory Equipment','Microscopes, centrifuges, etc.',1,'2025-04-26 04:33:58'),(13,'Cleaning Supplies','Soap, detergents, disinfectants',1,'2025-04-26 04:33:58'),(14,'Food & Beverages','For patients and staff',1,'2025-04-26 04:33:58'),(15,'Paper Products','Towels, napkins, etc.',1,'2025-04-26 04:33:58'),(16,'Other','Medical waste bags, supplies for medical procedures',1,'2025-04-26 04:33:58'),(17,'Patient Supplies','Bedpans, urinal, etc.',1,'2025-04-26 04:33:58'),(18,'Personal Protective Equipment (PPE)','Masks, gowns, gloves, etc.',1,'2025-04-26 04:33:58'),(19,'Office Supplies','Pens, paper, staples, etc.',1,'2025-04-26 04:33:58');
/*!40000 ALTER TABLE `mstcategory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-25 16:45:51
