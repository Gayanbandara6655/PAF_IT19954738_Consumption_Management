-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:330
-- Generation Time: May 15, 2022 at 07:58 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `consumption`
--

-- --------------------------------------------------------

--
-- Table structure for table `consumption`
--

CREATE TABLE `consumption` (
  `TrackId` int(10) NOT NULL,
  `CusName` varchar(50) NOT NULL,
  `PeakHoursUnit` varchar(10) NOT NULL,
  `NormalHoursUnit` varchar(10) NOT NULL,
  `Month` varchar(15) NOT NULL,
  `AccNumber` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `consumption`
--

INSERT INTO `consumption` (`TrackId`, `CusName`, `PeakHoursUnit`, `NormalHoursUnit`, `Month`, `AccNumber`) VALUES
(1, 'gayan', '50', '60', 'may', '12345679'),
(2, 'gayan', '10', '20', 'august', '100');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consumption`
--
ALTER TABLE `consumption`
  ADD PRIMARY KEY (`TrackId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consumption`
--
ALTER TABLE `consumption`
  MODIFY `TrackId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
