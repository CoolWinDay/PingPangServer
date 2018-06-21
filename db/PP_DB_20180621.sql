-- MySQL dump 10.13  Distrib 8.0.11, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: pingpang
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `pp_auditor`
--

DROP TABLE IF EXISTS `pp_auditor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pp_auditor` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) DEFAULT NULL,
  `venue_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `idcard` varchar(45) DEFAULT NULL,
  `introduce` varchar(45) DEFAULT NULL,
  `create_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pp_exam`
--

DROP TABLE IF EXISTS `pp_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pp_exam` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) DEFAULT NULL,
  `venue_id` int(11) DEFAULT NULL,
  `auditor_id` int(11) DEFAULT NULL,
  `examinee_id` int(11) DEFAULT NULL,
  `exam_grade` varchar(45) DEFAULT NULL,
  `exam_time` varchar(45) DEFAULT NULL,
  `create_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pp_examinee`
--

DROP TABLE IF EXISTS `pp_examinee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pp_examinee` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `idcard` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `create_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pp_image`
--

DROP TABLE IF EXISTS `pp_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pp_image` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `module` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `path` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pp_right`
--

DROP TABLE IF EXISTS `pp_right`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pp_right` (
  `kid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pp_user`
--

DROP TABLE IF EXISTS `pp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pp_user` (
  `user_id` varchar(45) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `login_token` varchar(45) DEFAULT NULL,
  `login_time` varchar(45) DEFAULT NULL,
  `user_right` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pp_venue`
--

DROP TABLE IF EXISTS `pp_venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pp_venue` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `charger` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `county` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `introduce` varchar(45) DEFAULT NULL,
  `create_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-21 14:08:07
