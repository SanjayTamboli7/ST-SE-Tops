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
-- Table structure for table `txnpoheader`
--

DROP TABLE IF EXISTS `txnpoheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `txnpoheader` (
  `poid` int NOT NULL AUTO_INCREMENT,
  `supplierid` int NOT NULL,
  `podate` date NOT NULL,
  `deliverydate` date DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `total_amount` float DEFAULT NULL,
  `lastaddeditby` int NOT NULL DEFAULT '1',
  `lasteditdatetime` datetime NOT NULL,
  PRIMARY KEY (`poid`),
  KEY `supplierid` (`supplierid`),
  CONSTRAINT `txnpoheader_ibfk_1` FOREIGN KEY (`supplierid`) REFERENCES `mstsupplier` (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txnpoheader`
--
-- ORDER BY:  `poid`

LOCK TABLES `txnpoheader` WRITE;
/*!40000 ALTER TABLE `txnpoheader` DISABLE KEYS */;
INSERT INTO `txnpoheader` VALUES (1,2,'2025-05-19',NULL,'Approve',500,15,'2025-05-19 11:12:55');
/*!40000 ALTER TABLE `txnpoheader` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_after_po_approve` AFTER UPDATE ON `txnpoheader` FOR EACH ROW BEGIN
  DECLARE varpoid INT;
  DECLARE varpodetailid INT;
  DECLARE varprid INT;
  DECLARE done INT DEFAULT FALSE;

  -- Cursor to get podetailid and prid for the current poid
  DECLARE podetail CURSOR FOR 
    SELECT podetailid, prid 
    FROM txnpodetails 
    WHERE poid = NEW.poid AND prid IS NOT NULL;

  -- Handler to set the 'done' flag when no more rows
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  IF NEW.status = 'Approve' AND OLD.status <> 'Approve' THEN
    SET varpoid = NEW.poid;

    OPEN podetail;
	Insert into `debug_log` (`message`) values ('Cursor opened');
    read_loop: LOOP
      FETCH podetail INTO varpodetailid, varprid;
	  Insert into `debug_log` (`message`) values ('After fetched');

      -- Check if fetch reached the end before updating
      IF done THEN
		Insert into `debug_log` (`message`) values ('Leaving loop');
        LEAVE read_loop;
      END IF;

      -- Only update if valid prid exists
      IF varprid IS NOT NULL THEN
		Insert into `debug_log` (`message`) values ('Before update');
        UPDATE txnpurchaserequest
        SET podetailid = varpodetailid
        WHERE prid = varprid;
		Insert into `debug_log` (`message`) values ('After update');
      END IF;

    END LOOP;

    CLOSE podetail;
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

-- Dump completed on 2025-05-20 11:11:45
