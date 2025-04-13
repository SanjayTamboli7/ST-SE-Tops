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
  PRIMARY KEY (`leaveappid`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txnleave`
--

LOCK TABLES `txnleave` WRITE;
/*!40000 ALTER TABLE `txnleave` DISABLE KEYS */;
INSERT INTO `txnleave` VALUES (5,'2024-03-01','Casual','2024-03-01','2024-03-03','Full','Casual leave for personal work','Rejected',15,'2025-04-12 16:39:11'),(6,'2024-03-02','Sick','2024-03-02','2024-03-04','Half','Feeling unwell','Withdrawn',15,'2025-04-13 16:48:30'),(7,'2024-03-03','Privilege','2024-03-03','2024-03-05','Full','Family function','Rejected',15,'2025-04-12 13:11:01'),(8,'2024-03-04','Maternity','2024-03-04','2024-03-10','Full','Maternity leave request','Withdrawn',15,'2025-04-12 13:11:01'),(9,'2024-03-05','Paternity','2024-03-05','2024-03-07','Half','Paternity leave for new baby','Withdrawn',15,'2025-04-13 17:02:17'),(10,'2024-03-06','Casual','2024-03-06','2024-03-07','Full','Urgent personal matter','Withdrawn',15,'2025-04-13 17:21:15'),(11,'2024-03-07','Sick','2024-03-07','2024-03-09','Full','Flu and fever','Rejected',15,'2025-04-12 13:11:01'),(12,'2024-03-08','Privilege','2024-03-08','2024-03-10','Half','Outstation visit','Withdrawn',15,'2025-04-12 13:11:01'),(13,'2024-03-09','Maternity','2024-03-09','2024-03-15','Full','Expected delivery date near','Approved',15,'2025-04-13 16:03:01'),(14,'2024-03-10','Paternity','2024-03-10','2024-03-12','Half','Baby born','Approved',15,'2025-04-12 13:11:01'),(15,'2024-03-11','Casual','2024-03-11','2024-03-13','Full','Family wedding','Rejected',15,'2025-04-12 13:11:01'),(16,'2024-03-12','Sick','2024-03-12','2024-03-13','Half','Hospital visit','Withdrawn',15,'2025-04-12 13:11:01'),(17,'2024-03-13','Privilege','2024-03-13','2024-03-14','Full','Long weekend plan','Pending',15,'2025-04-12 13:11:01'),(18,'2024-03-14','Maternity','2024-03-14','2024-03-20','Full','Pregnancy care','Approved',15,'2025-04-12 13:11:01'),(19,'2024-03-15','Paternity','2024-03-15','2024-03-17','Full','Paternity leave','Rejected',15,'2025-04-12 13:11:01'),(20,'2024-03-16','Casual','2024-03-16','2024-03-17','Half','Local festival','Withdrawn',15,'2025-04-12 13:11:01'),(21,'2024-03-17','Sick','2024-03-17','2024-03-19','Full','Eye check-up','Pending',15,'2025-04-12 13:11:01'),(22,'2024-03-18','Privilege','2024-03-18','2024-03-20','Full','Vacation','Withdrawn',15,'2025-04-13 17:22:31'),(23,'2024-03-19','Maternity','2024-03-19','2024-03-25','Half','Final trimester rest','Rejected',15,'2025-04-12 13:11:01'),(24,'2024-03-20','Paternity','2024-03-20','2024-03-22','Half','Time with newborn','Withdrawn',15,'2025-04-12 13:11:01'),(25,'2024-03-21','Casual','2024-03-21','2024-03-23','Full','Short vacation','Pending',15,'2025-04-12 13:11:01'),(26,'2024-03-22','Sick','2024-03-22','2024-03-24','Full','Health check','Withdrawn',15,'2025-04-13 17:21:59'),(27,'2024-03-23','Privilege','2024-03-23','2024-03-24','Half','Home renovation','Rejected',15,'2025-04-12 13:11:01'),(28,'2024-03-24','Maternity','2024-03-24','2024-03-30','Full','Hospital admission','Withdrawn',15,'2025-04-12 13:11:01'),(29,'2024-03-25','Paternity','2024-03-25','2024-03-27','Full','Baby health support','Pending',15,'2025-04-12 13:11:01'),(30,'2024-03-26','Casual','2024-03-26','2024-03-27','Half','Medical appointment','Withdrawn',15,'2025-04-13 17:04:46'),(31,'2024-03-27','Sick','2024-03-27','2024-03-29','Full','Bed rest','Rejected',15,'2025-04-12 13:11:01'),(32,'2024-03-28','Privilege','2024-03-28','2024-03-30','Half','Hometown visit','Withdrawn',15,'2025-04-12 13:11:01'),(33,'2024-03-29','Maternity','2024-03-29','2024-04-05','Full','Routine scan','Pending',15,'2025-04-12 13:11:01'),(34,'2024-03-30','Paternity','2024-03-30','2024-04-01','Half','Post-birth help','Approved',15,'2025-04-12 13:11:01'),(35,'2024-03-31','Casual','2024-03-31','2024-04-02','Full','Bank work','Rejected',15,'2025-04-12 13:11:01'),(36,'2024-04-01','Sick','2024-04-01','2024-04-03','Full','Back pain','Withdrawn',15,'2025-04-12 13:11:01'),(37,'2024-04-02','Privilege','2024-04-02','2024-04-04','Half','Legal work','Pending',15,'2025-04-12 13:11:01'),(38,'2024-04-03','Maternity','2024-04-03','2024-04-09','Full','Regular appointment','Withdrawn',15,'2025-04-13 17:23:04'),(39,'2024-04-04','Paternity','2024-04-04','2024-04-06','Full','Family time','Rejected',15,'2025-04-12 13:11:01'),(40,'2024-04-05','Casual','2024-04-05','2024-04-06','Half','Other personal matter','Withdrawn',15,'2025-04-12 13:11:01'),(41,'2024-04-06','Sick','2024-04-06','2024-04-08','Full','Minor surgery','Pending',15,'2025-04-12 13:11:01'),(42,'2024-04-07','Privilege','2024-04-07','2024-04-09','Full','Spiritual retreat','Approved',15,'2025-04-12 13:11:01'),(43,'2024-04-08','Maternity','2024-04-08','2024-04-14','Half','Delivery care','Rejected',15,'2025-04-12 13:11:01'),(44,'2024-04-09','Paternity','2024-04-09','2024-04-11','Half','Home support','Withdrawn',15,'2025-04-12 13:11:01'),(45,'2024-04-10','Casual','2024-04-10','2024-04-12','Full','Family need','Pending',15,'2025-04-12 13:11:01'),(46,'2024-04-11','Sick','2024-04-11','2024-04-13','Full','Fever','Withdrawn',15,'2025-04-13 17:04:06'),(47,'2024-04-12','Privilege','2024-04-12','2024-04-14','Half','Short trip','Rejected',15,'2025-04-12 13:11:01'),(48,'2024-04-13','Maternity','2024-04-13','2024-04-19','Full','Delivery phase','Withdrawn',15,'2025-04-12 13:11:01'),(49,'2024-04-14','Paternity','2024-04-14','2024-04-16','Full','Support system','Pending',15,'2025-04-12 13:11:01'),(50,'2024-04-15','Casual','2024-04-15','2024-04-17','Half','Special event','Withdrawn',15,'2025-04-13 16:46:21'),(51,'2024-04-16','Sick','2024-04-16','2024-04-18','Full','Fatigue','Rejected',15,'2025-04-12 13:11:01'),(52,'2024-04-17','Privilege','2024-04-17','2024-04-19','Full','Unwind','Withdrawn',15,'2025-04-12 13:11:01'),(53,'2024-04-18','Maternity','2024-04-18','2024-04-24','Half','Final days','Pending',15,'2025-04-12 13:11:01'),(54,'2024-04-19','Privilege','2024-04-20','2024-04-21','Full','New baby celebration','Pending',15,'2025-04-12 13:12:52'),(56,'2025-04-13','Casual','2025-04-13','2025-04-13','Half',NULL,'Pending',1,'2025-04-13 17:29:09');
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_update_leave_balance` AFTER UPDATE ON `txnleave` FOR EACH ROW BEGIN
  DECLARE days_diff INT;

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

-- Dump completed on 2025-04-13 18:12:09
