-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2020 at 11:45 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `creative_jewellers`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID_admin` int(11) NOT NULL,
  `IP` varchar(11) NOT NULL,
  `Ad_Email` varchar(255) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID_admin`, `IP`, `Ad_Email`, `Password`) VALUES
(1, '', 'Admin@gmail.com', 'admin123'),
(2, '', 'kadija@gmail.com', 'kadija');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `Pro_id` int(30) NOT NULL,
  `Ip_add` varchar(11) NOT NULL,
  `Quantity` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Category_id` int(11) NOT NULL,
  `Category_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Category_id`, `Category_name`) VALUES
(101, 'Ladies'),
(102, 'Gents'),
(103, 'Kids');

-- --------------------------------------------------------

--
-- Table structure for table `customer_message`
--

CREATE TABLE `customer_message` (
  `message_id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Contact_no` int(11) NOT NULL,
  `Message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_message`
--

INSERT INTO `customer_message` (`message_id`, `Name`, `Email`, `Contact_no`, `Message`) VALUES
(1, 'Nusra Noufer', 'nusra1noufer@gmail.com', 768307443, 'Hola!'),
(2, 'Rizma', 'rizma1noufer@gmail.com', 725366536, 'Nmasthe!');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_id` int(11) NOT NULL,
  `Customer_ip` varchar(10) NOT NULL,
  `Full_name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Name_on_card` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Credit_card_number` int(11) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Month_of_expiry` varchar(255) NOT NULL,
  `State` varchar(255) NOT NULL,
  `Zip` int(11) NOT NULL,
  `Year_of_expiry` varchar(255) NOT NULL,
  `Cvv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_id`, `Customer_ip`, `Full_name`, `Email`, `Name_on_card`, `Address`, `Credit_card_number`, `City`, `Month_of_expiry`, `State`, `Zip`, `Year_of_expiry`, `Cvv`) VALUES
(1, '::1', 'Nusra Noufer', 'nusra1noufer@gmail.com', 'Nusra Noufer', 'Mattegoda', 2147483647, 'Colombo', 'January', 'Colombo', 320, '2020', 123);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Product_id` int(50) NOT NULL,
  `Product_Category` int(50) NOT NULL,
  `Category` int(50) NOT NULL,
  `Product_image` text NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Description` varchar(225) NOT NULL,
  `Material` varchar(50) NOT NULL,
  `Karatage` varchar(50) NOT NULL,
  `Weight` varchar(50) NOT NULL,
  `Price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Product_id`, `Product_Category`, `Category`, `Product_image`, `Title`, `Description`, `Material`, `Karatage`, `Weight`, `Price`) VALUES
(1, 12, 101, 'PEARL BEAURY-159.jpg', 'PEARL BEAUTY', 'Tears with joy.', 'Rose gold', '18k', '30 g', 300000.00),
(2, 15, 102, 'BLACK STONE-130.jpg', 'BLACK STONE', 'Gold ring with a wonderful blackstone on top.', 'Yellow gold', '22k', '8 g', 60000.00),
(3, 13, 103, 'cute-teddy-bear-kids-gold-bracelet-135.png', 'TEDDY BEAR BRACE', 'Cute teddy bear bracelet for your princess to make her feel special.', 'Yellow gold', '22k', '10 g', 90000.00),
(4, 13, 101, 'LEAVE PRINCESS-143.jpg', 'LEAVE PRINCESS', 'This bracelet have designed by connecting leave shape small pieces  in to each piece.', 'Yellow gold', '22k', '16 g', 120000.00),
(5, 14, 102, 'CUPID SPOT-109.jpg', 'CUPID SPOT', 'Single piece earing for a rajput handsome.', 'Yellow gold', '22k', '1 g', 7000.00),
(6, 14, 101, 'DISTINCT-FLASH-102.jpg', 'DISTINCT FLASH', 'Wonderful set of earrings with a flashy look special for a queen who wants to shine.', 'Yellow gold', '22k', '6 g', 20000.00),
(7, 12, 101, 'FLORAL RAIN DROP-154.jpg', 'FLORAL RAIN DROP', 'Flower in a rain drop.', 'Rose gold', '18k', '27.61 g', 250000.00),
(8, 15, 101, 'CUBIC ZIRCONIA-126.jpg', 'CUBIC ZIRCONIA', 'Simple and elegant ring for a wonder women.', 'Rose gold', '18k', '5 g', 30000.00),
(9, 12, 103, 'TINKERBELL-160.jpg', 'TINKERBELL', 'Beauty with range.', 'Yellow gold', '22k', '10 g', 80000.00),
(10, 12, 102, 'Anchor necklace.jpg', 'ANCHOR', 'Handy necklace for a ship men.', 'Yellow gold', '22k', '9 g', 750000.00),
(11, 12, 102, 'bold cuban.jpg', 'BOLD CUBAN', 'Cuban necklace, shows your royalty', 'Yellow gold', '22k', '16 g', 120000.00),
(12, 12, 103, 'heart.jpg', 'HEART', 'heart shaped frame necklace.', 'White gold', '18k', '8 g', 60000.00),
(13, 12, 103, 'naming.jpg', 'NAMING NECKLACE', 'You can customize the font according to your desire.', 'Yellow gold', '22k', '10 g', 80000.00),
(14, 14, 101, 'LEAVE LOVE-104.jpg', 'LEAVE LOVE ', 'white gold stone embraced earing.', 'White gold', '18k', '12 g', 100000.00),
(15, 13, 102, 'ROYAL BAND-145.jpg', 'ROYAL BAND', 'High quality leather band with royalty masterpiece of gold', 'Yellow gold', '22k', '2 g', 25000.00),
(16, 15, 101, 'FLORA-123.jpg', 'FLORA', 'flower engraved white gold masterpiece.', 'White gold', '18k', '5 g', 40000.00),
(17, 14, 101, 'DUAL-RADIANCE-103.jpg', 'DUAL RADIANCE', 'gold master piece.', 'Yellow gold', '22k', '5 g', 30000.00);

-- --------------------------------------------------------

--
-- Table structure for table `product_category`
--

CREATE TABLE `product_category` (
  `Product_category_id` int(11) NOT NULL,
  `Product_Category_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`Product_category_id`, `Product_Category_name`) VALUES
(12, 'Necklace'),
(13, 'Bracelets'),
(14, 'Earings'),
(15, 'Rings\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `ID` int(11) NOT NULL,
  `Surname` varchar(225) NOT NULL,
  `First_name` varchar(225) NOT NULL,
  `Address` varchar(225) NOT NULL,
  `Contact_No` int(10) NOT NULL,
  `NIC_No` varchar(225) NOT NULL,
  `DOB` varchar(225) NOT NULL,
  `City` varchar(225) NOT NULL,
  `Zip_code` int(11) NOT NULL,
  `Country` varchar(225) NOT NULL,
  `Customer_ip` varchar(11) NOT NULL,
  `Email` varchar(225) NOT NULL,
  `Password` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`ID`, `Surname`, `First_name`, `Address`, `Contact_No`, `NIC_No`, `DOB`, `City`, `Zip_code`, `Country`, `Customer_ip`, `Email`, `Password`) VALUES
(5, 'Noufer', 'Nusra', 'Mattegoda', 768307443, '977530342v', '09.09.1997', 'Colombo', 320, 'Sri Lanka', '::1', 'nusra1noufer@gmail.com', 'kadija'),
(6, 'Noufer', 'Rizma', 'Mattegoda', 725366536, '200026536542', '09.05.2000', 'Colombo', 320, 'Sri Lanka', '::1', 'rizma1noufer@gmail.com', 'rizma'),
(7, 'Kakuluthotuwage', 'Nadeeshika', 'Moratuwa', 768406570, '200065478965', '02.01.2000', 'Colombo', 300, 'Sri Lanka', '::1', 'nadeeshika@gmail.com', 'nadee123'),
(8, 'Azmeer', 'Sharfa', 'Nawagampura', 774561478, '99564231568v', '30.06.1999', 'Colombo', 562, 'Sri Lanka', '::1', 'sharfaazmeer@gmail.com', 'sharfa');

-- --------------------------------------------------------

--
-- Table structure for table `subscribe`
--

CREATE TABLE `subscribe` (
  `id` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subscribe`
--

INSERT INTO `subscribe` (`id`, `Email`) VALUES
(1, 'nusra1noufer@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID_admin`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`Pro_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`Category_id`);

--
-- Indexes for table `customer_message`
--
ALTER TABLE `customer_message`
  ADD PRIMARY KEY (`message_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_id`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `subscribe`
--
ALTER TABLE `subscribe`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer_message`
--
ALTER TABLE `customer_message`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `Product_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `subscribe`
--
ALTER TABLE `subscribe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
