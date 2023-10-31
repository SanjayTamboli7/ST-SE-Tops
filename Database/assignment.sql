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
-- Database: `assignment`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cnm` int(3) NOT NULL,
  `cname` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `rating` int(3) NOT NULL,
  `sno` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cnm`, `cname`, `city`, `rating`, `sno`) VALUES
(201, 'Holfman', 'London', 100, 1001),
(201, 'Holfman', 'London', 100, 1001),
(202, 'Giovanne', 'Roe', 200, 1003),
(203, 'Liu', 'San Jose', 300, 1002),
(204, 'Grass', 'Barcelona', 100, 1002),
(206, 'Clemens', 'London', 300, 1007),
(207, 'Pereira', 'Roe', 100, 1004);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_ID` int(3) NOT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) NOT NULL,
  `Salary` int(7) NOT NULL,
  `Joining_date` datetime NOT NULL,
  `Department` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_ID`, `First_Name`, `Last_Name`, `Salary`, `Joining_date`, `Department`) VALUES
(1, 'John', 'Abraham', 1000000, '2013-01-01 00:00:00', 'Banking'),
(2, 'Michael', 'Clarke', 800000, '2013-01-01 00:00:00', 'Insurance'),
(3, 'Roy', 'Thomas', 700000, '2013-02-01 00:00:00', 'Banking'),
(4, 'Tom', 'Jose', 600000, '2013-02-01 00:00:00', 'Insurance'),
(5, 'Jerry', 'Pinto', 650000, '2013-02-01 00:00:00', 'Insurance'),
(6, 'Philip', 'Mathew', 750000, '2013-01-01 00:00:00', 'Services'),
(7, 'TestName1', '123', 650000, '2013-01-01 00:00:00', 'Services'),
(8, 'TestName2', 'Lname%', 600000, '2013-02-01 00:00:00', 'Insurance'),
(9, 'TestName3', 'TestName3', 900000, '2013-02-01 00:00:00', 'Banking');

--
-- Triggers `employee`
--
DELIMITER $$
CREATE TRIGGER `empoyee_insert` AFTER INSERT ON `employee` FOR EACH ROW BEGIN
    	INSERT INTO employee1(Emp_ID, First_Nm, Last_Nm, Sal, Joining_dt, Dept, Action_name) 
    	values (new.Employee_ID, new.First_Name, new.Last_Name, new.Salary, new.Joining_date, new.Department, 'Record Inserted');
    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `employee1`
--

CREATE TABLE `employee1` (
  `Emp_ID` int(3) NOT NULL,
  `First_Nm` varchar(30) NOT NULL,
  `Last_Nm` varchar(30) NOT NULL,
  `Sal` int(7) NOT NULL,
  `Joining_dt` datetime NOT NULL,
  `Dept` varchar(20) NOT NULL,
  `Action_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee1`
--

INSERT INTO `employee1` (`Emp_ID`, `First_Nm`, `Last_Nm`, `Sal`, `Joining_dt`, `Dept`, `Action_name`) VALUES
(9, 'TestName3', 'TestName3', 900000, '2013-02-01 00:00:00', 'Banking', 'Record Inserted');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `RollNo` int(4) NOT NULL,
  `S_code` varchar(10) NOT NULL,
  `Marks` varchar(10) NOT NULL,
  `P_code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`RollNo`, `S_code`, `Marks`, `P_code`) VALUES
(1, 'CS11', '50', 'CS'),
(1, 'CS12', '60', 'CS'),
(2, 'EC101', '66', 'EC'),
(2, 'EC101', '70', 'EC'),
(3, 'EC102', '45', 'EC'),
(3, 'EC102', '50', 'EC');

-- --------------------------------------------------------

--
-- Table structure for table `incentive`
--

CREATE TABLE `incentive` (
  `Employee_ref_ID` int(3) NOT NULL,
  `Incentive_date` date NOT NULL,
  `Incentive_amount` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `incentive`
--

INSERT INTO `incentive` (`Employee_ref_ID`, `Incentive_date`, `Incentive_amount`) VALUES
(1, '2013-02-01', 5000),
(2, '2013-02-01', 3000),
(3, '2013-02-01', 4000),
(1, '2013-01-01', 4500),
(2, '2013-01-01', 3500);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `FirstName` varchar(30) DEFAULT NULL,
  `LastName` varchar(30) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL,
  `Age` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`FirstName`, `LastName`, `Address`, `City`, `Age`) VALUES
('Mickey', 'Mouse', '123 Fantasy Way', 'Anheim', 73),
('Bat', 'Man', '321 Cavern Ave', 'Gotham', 54),
('Wonder', 'Woman', '987 Truth Way', 'Paradise', 39),
('donald', 'Duck', '555 Quack Street', 'Mallard', 65),
('Bugs', 'Bunny', '567 Carrot Street', 'Rascal', 58),
('Wiley', 'Coyote', '999 Acme Way', 'Canyon', 61),
('Cat', 'Woman', '234 Perrfect Street', 'Hairball', 32),
('Tweety', 'Bird', '543', 'Itotltaw', 28);

-- --------------------------------------------------------

--
-- Table structure for table `salesperson`
--

CREATE TABLE `salesperson` (
  `sno` int(3) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `comm` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salesperson`
--

INSERT INTO `salesperson` (`sno`, `sname`, `city`, `comm`) VALUES
(1001, 'Peel', 'London', '0'),
(1002, 'Serres', 'San Jose', '0'),
(1003, 'Axelrod', 'New York', '0'),
(1004, 'Motika', 'London', '0'),
(1007, 'Rafkin', 'Barcelona', '0');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `RollNo` int(4) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Branch` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`RollNo`, `Name`, `Branch`) VALUES
(1, 'Jay', 'Computer Science'),
(2, 'Suhani', 'Electronics & Commun'),
(3, 'Kirti', 'Electronics & Commun');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD KEY `sno` (`sno`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_ID`);

--
-- Indexes for table `employee1`
--
ALTER TABLE `employee1`
  ADD PRIMARY KEY (`Emp_ID`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD KEY `RollNo` (`RollNo`);

--
-- Indexes for table `incentive`
--
ALTER TABLE `incentive`
  ADD KEY `Employee_ref_ID` (`Employee_ref_ID`);

--
-- Indexes for table `salesperson`
--
ALTER TABLE `salesperson`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`RollNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Employee_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `employee1`
--
ALTER TABLE `employee1`
  MODIFY `Emp_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `RollNo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `salesperson` (`sno`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`RollNo`) REFERENCES `student` (`RollNo`);

--
-- Constraints for table `incentive`
--
ALTER TABLE `incentive`
  ADD CONSTRAINT `incentive_ibfk_1` FOREIGN KEY (`Employee_ref_ID`) REFERENCES `employee` (`Employee_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
