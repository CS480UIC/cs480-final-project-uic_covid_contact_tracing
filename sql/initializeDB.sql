-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: uic_covid_contact_tracing
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `contact_information`
--

DROP TABLE IF EXISTS `contact_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_information` (
  `uin` int unsigned NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`uin`),
  UNIQUE KEY `uin` (`uin`),
  UNIQUE KEY `email_address` (`email_address`),
  UNIQUE KEY `phone_number` (`phone_number`),
  CONSTRAINT `contact_information_ibfk_1` FOREIGN KEY (`uin`) REFERENCES `student` (`uin`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_information`
--

LOCK TABLES `contact_information` WRITE;
/*!40000 ALTER TABLE `contact_information` DISABLE KEYS */;
INSERT INTO `contact_information` VALUES (647389410,'johndoe@uic.edu','3122134567','225 S Canal St, Chicago, IL 60606'),(648394052,'janedoe@uic.edu','773456123','1664 S Blue Island Ave, Chicago, IL 60608'),(674393028,'joejo2@uic.edu','6465789821','500 W Madison St, Chicago, IL 60661'),(674849301,'morristu8@uic.edu','3127690821','1035 W Randolph St, Chicago, IL 60607'),(687695021,'jreyes21@uic.edu','7738885400','1380 W Lake St, Chicago, IL 60607');
/*!40000 ALTER TABLE `contact_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `uin` int unsigned NOT NULL,
  `course_id` mediumint unsigned NOT NULL,
  `course_location` varchar(30) NOT NULL,
  PRIMARY KEY (`uin`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`uin`) REFERENCES `student` (`uin`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (647389410,12345,'AH_101'),(648394052,30210,'ARC_201'),(674393028,40512,'LH_302'),(674849301,67892,'SES_250'),(687695021,32489,'TH_120');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `covid_test`
--

DROP TABLE IF EXISTS `covid_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `covid_test` (
  `uin` int unsigned NOT NULL,
  `test_date` date NOT NULL,
  `result_date` date NOT NULL,
  `test_result` tinyint NOT NULL,
  PRIMARY KEY (`uin`,`test_date`),
  CONSTRAINT `covid_test_ibfk_1` FOREIGN KEY (`uin`) REFERENCES `student` (`uin`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `covid_test`
--

LOCK TABLES `covid_test` WRITE;
/*!40000 ALTER TABLE `covid_test` DISABLE KEYS */;
INSERT INTO `covid_test` VALUES (647389410,'2020-12-21','2020-12-24',1),(648394052,'2020-10-29','2020-11-01',0),(674393028,'2021-10-06','2021-10-10',0),(674849301,'2020-05-08','2020-05-07',1),(687695021,'2021-09-10','2021-09-12',0);
/*!40000 ALTER TABLE `covid_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `uin` int unsigned NOT NULL,
  `organization_id` mediumint unsigned NOT NULL,
  `organization_name` varchar(100) NOT NULL,
  PRIMARY KEY (`uin`,`organization_id`),
  CONSTRAINT `organization_ibfk_1` FOREIGN KEY (`uin`) REFERENCES `student` (`uin`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (647389410,25246,'Filipinos In Alliance'),(648394052,45482,'Alpha Kappa Delta Phi Sorority, Inc.'),(648394052,75932,'UIC Dental Club'),(674849301,25246,'Filipinos In Alliance'),(674849301,87592,'Vietnamese Student Association');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `uin` int unsigned NOT NULL,
  `vaccination_status` tinyint NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `student_living_status` tinyint NOT NULL,
  `student_major_name` varchar(30) DEFAULT NULL,
  `dorm_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`uin`),
  UNIQUE KEY `uin` (`uin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (647389410,2,'Ashley','Jensen',0,'Integrateds Health Sciences',NULL),(648394052,2,'Woodie','Larsen',0,'Biology',NULL),(674393028,2,'Delilah','Marx',1,'English','CTY'),(674849301,0,'Billy','Good',0,'Business Administration',NULL),(687695021,1,'Lyle','Levy',1,'Computer Science','JST');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_housing`
--

DROP TABLE IF EXISTS `student_housing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_housing` (
  `uin` int unsigned NOT NULL,
  `dorm_id` varchar(10) NOT NULL,
  `room_number` smallint unsigned NOT NULL,
  PRIMARY KEY (`uin`),
  UNIQUE KEY `uin` (`uin`),
  CONSTRAINT `student_housing_ibfk_1` FOREIGN KEY (`uin`) REFERENCES `student` (`uin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_housing`
--

LOCK TABLES `student_housing` WRITE;
/*!40000 ALTER TABLE `student_housing` DISABLE KEYS */;
INSERT INTO `student_housing` VALUES (647389410,'JST',120),(648394052,'JST',503),(674393028,'ARC',702),(674849301,'ARC',402),(687695021,'ARC',608);
/*!40000 ALTER TABLE `student_housing` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-10 20:32:13
