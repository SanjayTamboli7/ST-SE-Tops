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
-- Table structure for table `txnleave`
--

DROP TABLE IF EXISTS `txnleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `txnleave` (
  `leaveappid` int NOT NULL AUTO_INCREMENT,
  `leaveappdate` date NOT NULL,
  `leaveapptype` varchar(9) NOT NULL,
  `leavefromdate` date NOT NULL,
  `leavetodate` date NOT NULL,
  `leavefullhalfflag` varchar(4) DEFAULT NULL,
  `leaveappremark` varchar(50) DEFAULT NULL,
  `leaveappstatus` varchar(9) NOT NULL DEFAULT 'Pending',
  `lastaddeditby` int NOT NULL,
  `lasteditdatetime` datetime NOT NULL,
  `ouserid` int DEFAULT NULL,
  PRIMARY KEY (`leaveappid`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txnleave`
--

LOCK TABLES `txnleave` WRITE;
/*!40000 ALTER TABLE `txnleave` DISABLE KEYS */;
INSERT INTO `txnleave` VALUES (5,'2024-03-01','Casual','2024-03-01','2024-03-03','Full','Casual leave for personal work','Rejected',15,'2025-04-12 16:39:11',NULL),(6,'2024-03-02','Sick','2024-03-02','2024-03-04','Half','Feeling unwell','Withdrawn',15,'2025-04-13 16:48:30',NULL),(7,'2024-03-03','Privilege','2024-03-03','2024-03-05','Full','Family function','Rejected',15,'2025-04-12 13:11:01',NULL),(8,'2024-03-04','Maternity','2024-03-04','2024-03-10','Full','Maternity leave request','Withdrawn',15,'2025-04-12 13:11:01',NULL),(9,'2024-03-05','Paternity','2024-03-05','2024-03-07','Half','Paternity leave for new baby','Withdrawn',15,'2025-04-13 17:02:17',NULL),(10,'2024-03-06','Casual','2024-03-06','2024-03-07','Full','Urgent personal matter','Withdrawn',15,'2025-04-13 17:21:15',NULL),(11,'2024-03-07','Sick','2024-03-07','2024-03-09','Full','Flu and fever','Rejected',15,'2025-04-12 13:11:01',NULL),(12,'2024-03-08','Privilege','2024-03-08','2024-03-10','Half','Outstation visit','Withdrawn',15,'2025-04-12 13:11:01',NULL),(13,'2024-03-09','Maternity','2024-03-09','2024-03-15','Full','Expected delivery date near','Withdrawn',15,'2025-04-14 12:07:02',NULL),(14,'2024-03-10','Paternity','2024-03-10','2024-03-12','Half','Baby born','Withdrawn',15,'2025-04-14 12:08:14',NULL),(15,'2024-03-11','Casual','2024-03-11','2024-03-13','Full','Family wedding','Rejected',15,'2025-04-12 13:11:01',NULL),(16,'2024-03-12','Sick','2024-03-12','2024-03-13','Half','Hospital visit','Withdrawn',15,'2025-04-12 13:11:01',NULL),(17,'2024-03-13','Privilege','2024-03-13','2024-03-14','Full','Long weekend plan','Approved',15,'2025-04-14 12:20:52',NULL),(18,'2024-03-14','Maternity','2024-03-14','2024-03-20','Full','Pregnancy care','Withdrawn',15,'2025-04-14 12:08:56',NULL),(19,'2024-03-15','Paternity','2024-03-15','2024-03-17','Full','Paternity leave','Rejected',15,'2025-04-12 13:11:01',NULL),(20,'2024-03-16','Casual','2024-03-16','2024-03-17','Half','Local festival','Withdrawn',15,'2025-04-12 13:11:01',NULL),(21,'2024-03-17','Sick','2024-03-17','2024-03-17','Half','Eye check-up','Approved',15,'2025-04-14 12:33:44',NULL),(22,'2024-03-18','Privilege','2024-03-18','2024-03-20','Full','Vacation','Withdrawn',15,'2025-04-13 17:22:31',NULL),(23,'2024-03-19','Maternity','2024-03-19','2024-03-25','Half','Final trimester rest','Rejected',15,'2025-04-12 13:11:01',NULL),(24,'2024-03-20','Paternity','2024-03-20','2024-03-22','Half','Time with newborn','Withdrawn',15,'2025-04-12 13:11:01',NULL),(25,'2024-03-21','Casual','2024-03-21','2024-03-23','Full','Short vacation','Approved',15,'2025-04-14 12:26:17',NULL),(26,'2024-03-22','Sick','2024-03-22','2024-03-24','Full','Health check','Withdrawn',15,'2025-04-13 17:21:59',NULL),(27,'2024-03-23','Privilege','2024-03-23','2024-03-24','Half','Home renovation','Rejected',15,'2025-04-12 13:11:01',NULL),(28,'2024-03-24','Maternity','2024-03-24','2024-03-30','Full','Hospital admission','Withdrawn',15,'2025-04-12 13:11:01',NULL),(29,'2024-03-25','Paternity','2024-03-25','2024-03-27','Full','Baby health support','Approved',15,'2025-04-14 12:28:40',NULL),(30,'2024-03-26','Casual','2024-03-26','2024-03-27','Half','Medical appointment','Withdrawn',15,'2025-04-13 17:04:46',NULL),(31,'2024-03-27','Sick','2024-03-27','2024-03-29','Full','Bed rest','Rejected',15,'2025-04-12 13:11:01',NULL),(32,'2024-03-28','Privilege','2024-03-28','2024-03-30','Half','Hometown visit','Withdrawn',15,'2025-04-12 13:11:01',NULL),(33,'2024-03-29','Maternity','2024-03-29','2024-04-05','Full','Routine scan','Approved',15,'2025-04-14 12:28:14',NULL),(34,'2024-03-30','Paternity','2024-03-30','2024-04-01','Half','Post-birth help','Withdrawn',15,'2025-04-14 12:09:25',NULL),(35,'2024-03-31','Casual','2024-03-31','2024-04-02','Full','Bank work','Rejected',15,'2025-04-12 13:11:01',NULL),(36,'2024-04-01','Sick','2024-04-01','2024-04-03','Full','Back pain','Withdrawn',15,'2025-04-12 13:11:01',NULL),(37,'2024-04-02','Privilege','2024-04-02','2024-04-04','Half','Legal work','Approved',15,'2025-04-14 12:31:39',NULL),(38,'2024-04-03','Maternity','2024-04-03','2024-04-09','Full','Regular appointment','Withdrawn',15,'2025-04-13 17:23:04',NULL),(39,'2024-04-04','Paternity','2024-04-04','2024-04-06','Full','Family time','Rejected',15,'2025-04-12 13:11:01',NULL),(40,'2024-04-05','Casual','2024-04-05','2024-04-06','Half','Other personal matter','Withdrawn',15,'2025-04-12 13:11:01',NULL),(41,'2024-04-06','Sick','2024-04-06','2024-04-08','Full','Minor surgery','Approved',15,'2025-04-14 12:26:40',NULL),(42,'2024-04-07','Privilege','2024-04-07','2024-04-09','Full','Spiritual retreat','Withdrawn',15,'2025-04-14 12:09:50',NULL),(43,'2024-04-08','Maternity','2024-04-08','2024-04-14','Half','Delivery care','Rejected',15,'2025-04-12 13:11:01',NULL),(44,'2024-04-09','Paternity','2024-04-09','2024-04-11','Half','Home support','Withdrawn',15,'2025-04-12 13:11:01',NULL),(45,'2024-04-10','Casual','2024-04-10','2024-04-10','Half','Family need','Approved',15,'2025-04-14 12:32:57',NULL),(46,'2024-04-11','Sick','2024-04-11','2024-04-13','Full','Fever','Withdrawn',15,'2025-04-13 17:04:06',NULL),(47,'2024-04-12','Privilege','2024-04-12','2024-04-14','Half','Short trip','Rejected',15,'2025-04-12 13:11:01',NULL),(48,'2024-04-13','Maternity','2024-04-13','2024-04-19','Full','Delivery phase','Withdrawn',15,'2025-04-12 13:11:01',NULL),(49,'2024-04-14','Paternity','2024-04-14','2024-04-14','Half','Support system','Approved',15,'2025-04-14 12:34:34',NULL),(50,'2024-04-15','Casual','2024-04-15','2024-04-17','Half','Special event','Withdrawn',15,'2025-04-13 16:46:21',NULL),(51,'2024-04-16','Sick','2024-04-16','2024-04-18','Full','Fatigue','Rejected',15,'2025-04-12 13:11:01',NULL),(52,'2024-04-17','Privilege','2024-04-17','2024-04-19','Full','Unwind','Withdrawn',15,'2025-04-12 13:11:01',NULL),(53,'2024-04-18','Maternity','2024-04-18','2024-04-24','Half','Final days','Approved',15,'2025-04-14 12:32:11',NULL),(54,'2024-04-19','Privilege','2024-04-20','2024-04-21','Full','New baby celebration','Approved',15,'2025-04-14 12:27:11',NULL),(56,'2025-04-13','Casual','2025-04-13','2025-04-13','Half',NULL,'Approved',1,'2025-04-14 12:11:42',NULL),(57,'2025-04-15','Casual','2025-04-17','2025-04-17','Full','This is test data.','Pending',15,'2025-04-15 16:18:19',NULL),(58,'2025-04-18','Casual','2025-04-19','2025-04-19','Full',' This is testing data.','Pending',16,'2025-04-18 16:27:31',NULL),(59,'2025-04-18','Casual','2025-04-20','2025-04-20','Full','This is testing data for 20-Apr-2025.','Pending',16,'2025-04-18 16:45:27',16);
/*!40000 ALTER TABLE `txnleave` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_set_ouserid_before_insert` BEFORE INSERT ON `txnleave` FOR EACH ROW BEGIN
    -- Set ouserid to lastaddeditby before inserting
    SET NEW.ouserid = NEW.lastaddeditby;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_update_leave_balance` AFTER UPDATE ON `txnleave` FOR EACH ROW BEGIN
  DECLARE days_diff decimal(6,2);

  -- Only proceed if the status has changed
  IF NEW.leaveappstatus <> OLD.leaveappstatus THEN

    -- Calculate leave days for FULL leaves (inclusive of both dates)
    IF NEW.leavefullhalfflag = 'Full' THEN
      SET days_diff = DATEDIFF(NEW.leavetodate, NEW.leavefromdate) + 1;
    ELSE
      SET days_diff = 0.5;
    END IF;

    -- Approved leaves - Decrement balance
    IF NEW.leaveappstatus = 'Approved' THEN
      CASE NEW.leaveapptype
        WHEN 'Casual' THEN
          UPDATE mstleavebalance
          SET casualleave = casualleave - days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Sick' THEN
          UPDATE mstleavebalance
          SET sickleave = sickleave - days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Privilege' THEN
          UPDATE mstleavebalance
          SET privilegeleave = privilegeleave - days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Maternity' THEN
          UPDATE mstleavebalance
          SET maternityleave = maternityleave - days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Paternity' THEN
          UPDATE mstleavebalance
          SET paternityleave = paternityleave - days_diff
          WHERE ouserid = NEW.lastaddeditby;
      END CASE;

    -- Withdrawn leaves - Increment balance
    ELSEIF NEW.leaveappstatus = 'Withdrawn' and OLD.leaveappstatus = 'Approved' THEN
      CASE NEW.leaveapptype
        WHEN 'Casual' THEN
          UPDATE mstleavebalance
          SET casualleave = casualleave + days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Sick' THEN
          UPDATE mstleavebalance
          SET sickleave = sickleave + days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Privilege' THEN
          UPDATE mstleavebalance
          SET privilegeleave = privilegeleave + days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Maternity' THEN
          UPDATE mstleavebalance
          SET maternityleave = maternityleave + days_diff
          WHERE ouserid = NEW.lastaddeditby;
        WHEN 'Paternity' THEN
          UPDATE mstleavebalance
          SET paternityleave = paternityleave + days_diff
          WHERE ouserid = NEW.lastaddeditby;
      END CASE;
    END IF;

  END IF;
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

-- Dump completed on 2025-05-08 21:01:10
