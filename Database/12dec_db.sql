-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2023 at 07:07 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `12dec_db`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_user1` (`name` VARCHAR(30), `email_id` VARCHAR(30), `mobile_no` VARCHAR(10))   BEGIN
 insert into user1 (user_name, user_email_id, user_mobile_no) values (name, email_id, mobile_no);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PutData` ()   BEGIN
 insert into candidates (cand_id, cand_mobile, cand_address, cand_name)
 values (1, "9825434784", "Motera - Ahd", "Sanjay");
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PutData_1` (`id` INT(3), `mobile` VARCHAR(10), `address` VARCHAR(300), `name` VARCHAR(100))   BEGIN
 insert into candidates (cand_id, cand_mobile, cand_address, cand_name)
 values (id, mobile, address, name);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `StudentData` ()   Begin
 Insert into student (student_id, student_name, teacher_id_fk, marks)
 Values (10, "Mahesh", 1, 50);
End$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `candidates`
--

CREATE TABLE `candidates` (
  `cand_id` int(10) DEFAULT NULL,
  `cand_name` varchar(100) DEFAULT NULL,
  `cand_address` varchar(200) DEFAULT NULL,
  `cand_mobile` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `candidates`
--
DELIMITER $$
CREATE TRIGGER `Update_trigger` AFTER UPDATE ON `candidates` FOR EACH ROW BEGIN
    insert into test1 (id, name, action_performed) 
    values (new.cand_id, new.cand_name, "Record Updated");
    End
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `delete_trigger` AFTER DELETE ON `candidates` FOR EACH ROW BEGIN
    insert into test1 (id, name, action_performed) 
    values (old.cand_id, old.cand_name, "Record Deleted");
    End
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insert_trigger` AFTER INSERT ON `candidates` FOR EACH ROW BEGIN
    insert into test1 (id, name, action_performed) 
    values (new.cand_id, new.cand_name, "Record Inserted");
    End
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cate_id` int(10) NOT NULL,
  `cate_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cate_id`, `cate_name`) VALUES
(1, 'Men'),
(2, 'Women'),
(3, 'Kids'),
(7, 'Sports'),
(10, 'Sports');

--
-- Triggers `category`
--
DELIMITER $$
CREATE TRIGGER `insert_trigger1` AFTER INSERT ON `category` FOR EACH ROW BEGIN
    insert into subcategory (cate_id_fk, subcate_id, subcate_name) 
    values (new.cate_id, new.cate_id, new.cate_name);
    End
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeId` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `Salary` int(5) DEFAULT NULL,
  `Department` varchar(20) DEFAULT NULL,
  `Experience` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeId`, `Name`, `Gender`, `Salary`, `Department`, `Experience`) VALUES
(1, 'Student 1', 'M', 10000, 'HR', '1'),
(2, 'Student 2', 'M', 10000, 'HR', '1'),
(3, 'Student 3', 'F', 11000, 'Production', '2'),
(4, 'Student 4', 'F', 12000, 'Admin', '4');

-- --------------------------------------------------------

--
-- Table structure for table `sanjay`
--

CREATE TABLE `sanjay` (
  `order_id` int(11) NOT NULL,
  `prd_id` varchar(20) NOT NULL,
  `prd_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student` varchar(30) DEFAULT NULL,
  `percentage` int(3) DEFAULT NULL,
  `EmployeeID` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student`, `percentage`, `EmployeeID`) VALUES
('Isha Patel', 98, NULL),
('Harsh Das', 94, NULL),
('Rachit Shah', 93, NULL),
('Sumedha', 98, NULL),
('Rahat Ali', 98, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `subcategory`
--

CREATE TABLE `subcategory` (
  `Subcate_id` int(10) NOT NULL,
  `Subcate_name` varchar(100) DEFAULT NULL,
  `cate_id_fk` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subcategory`
--

INSERT INTO `subcategory` (`Subcate_id`, `Subcate_name`, `cate_id_fk`) VALUES
(1, 'Men\'s wear', 1),
(2, 'Men\'s wear', 1),
(3, 'Women\'s wear', 2),
(4, 'Kid\'s wear', 3),
(5, 'Men\'s wear', 1),
(6, '\'New Borne\'', NULL),
(7, '0', 7),
(10, 'Sports', 10);

-- --------------------------------------------------------

--
-- Table structure for table `tblcustomer`
--

CREATE TABLE `tblcustomer` (
  `Customer_id` int(3) NOT NULL,
  `First_name` varchar(25) DEFAULT NULL,
  `Last_name` varchar(25) DEFAULT NULL,
  `City` varchar(25) DEFAULT NULL,
  `State` varchar(25) DEFAULT NULL,
  `Zip` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblproduct`
--

CREATE TABLE `tblproduct` (
  `prd_id` int(3) NOT NULL,
  `prd_name` varchar(25) DEFAULT NULL,
  `Recommended_price` varchar(25) DEFAULT NULL,
  `category` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblsales`
--

CREATE TABLE `tblsales` (
  `Sales_id` int(4) NOT NULL,
  `Prod_id` int(3) DEFAULT NULL,
  `Cust_id` int(3) DEFAULT NULL,
  `Salesprice` varchar(25) DEFAULT NULL,
  `SalesDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `Teacher_id` int(10) NOT NULL,
  `Teacher_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`Teacher_id`, `Teacher_name`) VALUES
(1, 'Harsh Bhatt'),
(2, 'Mohan Shah');

-- --------------------------------------------------------

--
-- Table structure for table `test1`
--

CREATE TABLE `test1` (
  `ID` int(10) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `action_performed` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `test1`
--

INSERT INTO `test1` (`ID`, `name`, `date_time`, `action_performed`) VALUES
(4, 'Suresh', '2023-03-17 04:24:58', 'Record Inserted'),
(1, '0', '2023-03-17 04:29:27', 'Record Updated'),
(2, '0', '2023-03-17 04:29:27', 'Record Updated'),
(3, '0', '2023-03-17 04:29:27', 'Record Updated'),
(4, '0', '2023-03-17 04:29:27', 'Record Updated'),
(1, '0', '2023-03-17 04:53:54', 'Record Deleted'),
(2, '0', '2023-03-17 04:53:54', 'Record Deleted'),
(3, '0', '2023-03-17 04:53:54', 'Record Deleted'),
(4, '0', '2023-03-17 04:53:54', 'Record Deleted');

-- --------------------------------------------------------

--
-- Table structure for table `triggertbl`
--

CREATE TABLE `triggertbl` (
  `username` varchar(20) DEFAULT NULL,
  `action_performed` varchar(20) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `triggertbl`
--

INSERT INTO `triggertbl` (`username`, `action_performed`, `date_time`) VALUES
('Moxit', 'Record Inserted', '2023-04-04 05:14:28');

-- --------------------------------------------------------

--
-- Table structure for table `user1`
--

CREATE TABLE `user1` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `user_email_id` varchar(30) DEFAULT NULL,
  `user_mobile_no` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user1`
--

INSERT INTO `user1` (`user_id`, `user_name`, `user_email_id`, `user_mobile_no`) VALUES
(1, 'Moxit', 'moxit1@gmail.com', '1234567890');

--
-- Triggers `user1`
--
DELIMITER $$
CREATE TRIGGER `insert_trigger2` AFTER INSERT ON `user1` FOR EACH ROW BEGIN
 insert into triggerTbl ( username, action_performed ) values (new.user_name, 'Record Inserted');
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user2`
--

CREATE TABLE `user2` (
  `name` varchar(30) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `mobile_no` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user2`
--

INSERT INTO `user2` (`name`, `email_id`, `mobile_no`) VALUES
('Sanjay', 'sanjay123@gmail.com', '9825098250'),
('Raj', 'Raj123@gmail.com', '9825098251'),
('Moxit', 'Moxit123@gmail.com', '9825098252');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cate_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeId`);

--
-- Indexes for table `sanjay`
--
ALTER TABLE `sanjay`
  ADD PRIMARY KEY (`order_id`,`prd_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`Subcate_id`),
  ADD KEY `cate_id_fk` (`cate_id_fk`);

--
-- Indexes for table `tblcustomer`
--
ALTER TABLE `tblcustomer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `tblproduct`
--
ALTER TABLE `tblproduct`
  ADD PRIMARY KEY (`prd_id`);

--
-- Indexes for table `tblsales`
--
ALTER TABLE `tblsales`
  ADD PRIMARY KEY (`Sales_id`),
  ADD KEY `Prod_id` (`Prod_id`),
  ADD KEY `Cust_id` (`Cust_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`Teacher_id`);

--
-- Indexes for table `user1`
--
ALTER TABLE `user1`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cate_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `EmployeeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `subcategory`
--
ALTER TABLE `subcategory`
  MODIFY `Subcate_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tblcustomer`
--
ALTER TABLE `tblcustomer`
  MODIFY `Customer_id` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblproduct`
--
ALTER TABLE `tblproduct`
  MODIFY `prd_id` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblsales`
--
ALTER TABLE `tblsales`
  MODIFY `Sales_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `Teacher_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user1`
--
ALTER TABLE `user1`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeId`);

--
-- Constraints for table `subcategory`
--
ALTER TABLE `subcategory`
  ADD CONSTRAINT `subcategory_ibfk_1` FOREIGN KEY (`cate_id_fk`) REFERENCES `category` (`cate_id`);

--
-- Constraints for table `tblsales`
--
ALTER TABLE `tblsales`
  ADD CONSTRAINT `tblsales_ibfk_1` FOREIGN KEY (`Prod_id`) REFERENCES `tblproduct` (`prd_id`),
  ADD CONSTRAINT `tblsales_ibfk_2` FOREIGN KEY (`Cust_id`) REFERENCES `tblcustomer` (`Customer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
