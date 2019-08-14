CREATE DATABASE  IF NOT EXISTS `fps` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `fps`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: fps
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allotedgoods`
--

DROP TABLE IF EXISTS `allotedgoods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `allotedgoods` (
  `Dateb` date NOT NULL,
  `Aadharid` varchar(20) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Wheat` float DEFAULT NULL,
  `Rice` float DEFAULT NULL,
  `Sugar` float DEFAULT NULL,
  `Salt` float DEFAULT NULL,
  `Oil` float DEFAULT NULL,
  `Dals` float DEFAULT NULL,
  `Spices` float DEFAULT NULL,
  `Cost` float DEFAULT NULL,
  KEY `Aadharid` (`Aadharid`),
  CONSTRAINT `AllotedGoods_ibfk_1` FOREIGN KEY (`Aadharid`) REFERENCES `customer` (`aadharid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allotedgoods`
--

LOCK TABLES `allotedgoods` WRITE;
/*!40000 ALTER TABLE `allotedgoods` DISABLE KEYS */;
INSERT INTO `allotedgoods` VALUES ('2018-09-30','123456789044','Sadique Amin',1,1,1,1,1,1,1,117),('2018-09-30','123456789055','Sushant Rauniyar',10,5,3,1,5,4,1,945);
/*!40000 ALTER TABLE `allotedgoods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `Aadharid` varchar(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Gender` varchar(3) NOT NULL,
  `DOB` date DEFAULT NULL,
  `Mobno` varchar(15) NOT NULL,
  `City` varchar(10) NOT NULL,
  PRIMARY KEY (`Aadharid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('123456789012','Jay Naik','M',NULL,'8605901365','Pune'),('123456789025','Birendra Singh','M','2018-09-26','1593577410','Pune'),('123456789033','Arbaz Shaikh','M','1998-03-07','1478523691','Pune'),('123456789044','Sadique Amin','O','2018-09-30','1234567890','Mumbai'),('123456789055','Sushant Rauniyar','M','1995-12-21','1234567890','Delhi'),('708310921643','Manoj Nandha','M',NULL,'7345619090','Pune'),('708310922009','Piyush Lohokare','M',NULL,'8376619090','Pune'),('708310927089','Akash Misal','M',NULL,'8376699090','Pune');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_price`
--

DROP TABLE IF EXISTS `item_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item_price` (
  `Item_id` int(10) NOT NULL,
  `P1` float DEFAULT NULL,
  `P2` float DEFAULT NULL,
  `P3` float DEFAULT NULL,
  KEY `Item_id` (`Item_id`),
  CONSTRAINT `Item_Price_ibfk_1` FOREIGN KEY (`Item_id`) REFERENCES `items` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_price`
--

LOCK TABLES `item_price` WRITE;
/*!40000 ALTER TABLE `item_price` DISABLE KEYS */;
INSERT INTO `item_price` VALUES (101,8,18,25),(102,10,22,30),(103,15,35,40),(104,3,10,20),(105,40,65,90),(106,25,45,90),(107,16,35,50);
/*!40000 ALTER TABLE `item_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `items` (
  `Item_id` int(10) NOT NULL,
  `Item_name` varchar(30) NOT NULL,
  `Quantity` float DEFAULT NULL,
  PRIMARY KEY (`Item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (101,'Wheat',5967.6),(102,'Rice',322.9),(103,'Sugar',318),(104,'Salt',184),(105,'Oil',466),(106,'Dals',367),(107,'Spices',88);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginusers`
--

DROP TABLE IF EXISTS `loginusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loginusers` (
  `Aadharid` varchar(20) DEFAULT NULL,
  `Name` varchar(25) DEFAULT NULL,
  `Username` varchar(15) DEFAULT NULL,
  `Password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginusers`
--

LOCK TABLES `loginusers` WRITE;
/*!40000 ALTER TABLE `loginusers` DISABLE KEYS */;
INSERT INTO `loginusers` VALUES ('111111111111','Jay Naik','j7398','12345'),('222222222222','Manoj Nandha','manoj22','manoj22');
/*!40000 ALTER TABLE `loginusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salary` (
  `Aadharid` varchar(20) DEFAULT NULL,
  `Salary` bigint(20) DEFAULT NULL,
  `Status` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES ('123456789014',10000,'P1'),('123456789012',15000,'P2'),('123456789012',15000,'P2'),('123456789033',50000,'P3'),('123456789025',25000,'P2'),('123456789044',5000,'P1'),('123456789055',20000,'P2');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fps'
--

--
-- Dumping routines for database 'fps'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-30 21:04:29
