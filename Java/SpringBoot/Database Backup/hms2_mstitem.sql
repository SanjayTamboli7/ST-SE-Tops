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
-- Table structure for table `mstitem`
--

DROP TABLE IF EXISTS `mstitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mstitem` (
  `itemid` int NOT NULL AUTO_INCREMENT,
  `itemname` varchar(100) DEFAULT NULL,
  `itemcode` varchar(50) DEFAULT NULL,
  `categoryid` int DEFAULT NULL,
  `uomid` int DEFAULT NULL,
  `reorderlevel` int DEFAULT NULL,
  `maxstock` int DEFAULT NULL,
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`itemid`),
  UNIQUE KEY `itemcode` (`itemcode`),
  KEY `categoryid` (`categoryid`),
  KEY `uomid` (`uomid`),
  CONSTRAINT `mstitem_ibfk_1` FOREIGN KEY (`categoryid`) REFERENCES `mstcategory` (`categoryid`),
  CONSTRAINT `mstitem_ibfk_2` FOREIGN KEY (`uomid`) REFERENCES `mstuom` (`uomid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mstitem`
--
-- ORDER BY:  `itemid`

LOCK TABLES `mstitem` WRITE;
/*!40000 ALTER TABLE `mstitem` DISABLE KEYS */;
INSERT INTO `mstitem` VALUES (1,'Test Item 1','TI1',1,5,5,50,15,'2025-04-27 17:17:51'),(2,'Test Item 2','TI2',2,2,10,50,15,'2025-04-27 17:15:29'),(3,'Test Item 3','TI3',3,3,30,150,15,'2025-04-27 17:15:06'),(4,'Test Item 4','TI4',4,4,40,200,15,'2025-04-27 17:53:30');
/*!40000 ALTER TABLE `mstitem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-20 11:11:46
