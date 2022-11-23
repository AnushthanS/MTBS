-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `admininfo`
--

DROP TABLE IF EXISTS `admininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admininfo` (
  `username` varchar(30) DEFAULT NULL,
  `password` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admininfo`
--

LOCK TABLES `admininfo` WRITE;
/*!40000 ALTER TABLE `admininfo` DISABLE KEYS */;
INSERT INTO `admininfo` VALUES ('QWERT','qwert123'),('ASDFG','asdfg123'),('ZXCVB','zxcvb123');
/*!40000 ALTER TABLE `admininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookinginfo`
--

DROP TABLE IF EXISTS `bookinginfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookinginfo` (
  `username` varchar(30) DEFAULT NULL,
  `time_slot` text,
  `movie_id` int DEFAULT NULL,
  `theatre_id` int DEFAULT NULL,
  KEY `user_name_idx` (`username`),
  KEY `booking_idx` (`movie_id`,`theatre_id`),
  KEY `theatre_idx` (`theatre_id`),
  CONSTRAINT `user_name` FOREIGN KEY (`username`) REFERENCES `userinfo` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookinginfo`
--

LOCK TABLES `bookinginfo` WRITE;
/*!40000 ALTER TABLE `bookinginfo` DISABLE KEYS */;
INSERT INTO `bookinginfo` VALUES ('abcd@xyz.com','7:30 PM',1,101),('efgh@xyz.com','8:00 PM',2,102),('ijkl@xyz.com','9:15 PM',3,103);
/*!40000 ALTER TABLE `bookinginfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieinfo`
--

DROP TABLE IF EXISTS `movieinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movieinfo` (
  `movie_id` int NOT NULL,
  `movie_name` text,
  `rating` double DEFAULT NULL,
  `genre` text,
  `language` text,
  `theatre_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`theatre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieinfo`
--

LOCK TABLES `movieinfo` WRITE;
/*!40000 ALTER TABLE `movieinfo` DISABLE KEYS */;
INSERT INTO `movieinfo` VALUES (1,'godfather',8.9,'Crime Fiction','Eng',101),(1,'godfather',8.9,'Crime Fiction','Eng',102),(1,'godfather',8.9,'Crime Fiction','Eng',103),(1,'godfather',8.9,'Crime Fiction','Eng',201),(1,'godfather',8.9,'Crime Fiction','Eng',202),(1,'godfather',8.9,'Crime Fiction','Eng',203),(1,'godfather',8.9,'Crime Fiction','Eng',301),(1,'godfather',8.9,'Crime Fiction','Eng',302),(1,'godfather',8.9,'Crime Fiction','Eng',303),(1,'godfather',8.9,'Crime Fiction','Eng',401),(1,'godfather',8.9,'Crime Fiction','Eng',402),(1,'godfather',8.9,'Crime Fiction','Eng',403),(2,'avengers_end_game',8.5,'Action','Eng/Hin',101),(2,'avengers_end_game',8.5,'Action','Eng/Hin',102),(2,'avengers_end_game',8.5,'Action','Eng/Hin',103),(2,'avengers_end_game',8.5,'Action','Eng/Hin',201),(2,'avengers_end_game',8.5,'Action','Eng/Hin',202),(2,'avengers_end_game',8.5,'Action','Eng/Hin',203),(2,'avengers_end_game',8.5,'Action','Eng/Hin',301),(2,'avengers_end_game',8.5,'Action','Eng/Hin',302),(2,'avengers_end_game',8.5,'Action','Eng/Hin',303),(2,'avengers_end_game',8.5,'Action','Eng/Hin',401),(2,'avengers_end_game',8.5,'Action','Eng/Hin',402),(2,'avengers_end_game',8.5,'Action','Eng/Hin',403),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',101),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',102),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',103),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',201),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',202),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',203),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',301),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',302),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',303),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',401),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',402),(3,'black_panther_wakanda_forever',8.1,'Action','Eng/Hin',403);
/*!40000 ALTER TABLE `movieinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showinfo`
--

DROP TABLE IF EXISTS `showinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showinfo` (
  `theatre_id` int DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  `time` text,
  KEY `movie and theatre_idx` (`movie_id`),
  KEY `theatre_idx` (`theatre_id`),
  CONSTRAINT `movie` FOREIGN KEY (`movie_id`) REFERENCES `movieinfo` (`movie_id`),
  CONSTRAINT `theatre` FOREIGN KEY (`theatre_id`) REFERENCES `theatreinfo` (`theatre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showinfo`
--

LOCK TABLES `showinfo` WRITE;
/*!40000 ALTER TABLE `showinfo` DISABLE KEYS */;
INSERT INTO `showinfo` VALUES (101,1,'7:30 PM'),(102,2,'8:00 PM'),(103,3,'9:15 PM'),(201,1,'7:30 PM'),(202,2,'8:00 PM'),(203,3,'9:15 PM'),(301,1,'7:30 PM'),(302,2,'8:00 PM'),(303,3,'9:15 PM'),(401,1,'7:30 PM'),(402,2,'8:00 PM'),(403,3,'9:15 PM');
/*!40000 ALTER TABLE `showinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theatreinfo`
--

DROP TABLE IF EXISTS `theatreinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theatreinfo` (
  `location` text,
  `theatre_id` int NOT NULL,
  `theatre` text,
  `screen` int NOT NULL,
  `no_of_tickets` int DEFAULT NULL,
  PRIMARY KEY (`theatre_id`,`screen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatreinfo`
--

LOCK TABLES `theatreinfo` WRITE;
/*!40000 ALTER TABLE `theatreinfo` DISABLE KEYS */;
INSERT INTO `theatreinfo` VALUES ('Chennai',101,'PVR',1,300),('Chennai',101,'PVR',2,250),('Chennai',101,'PVR',3,200),('Chennai',102,'MEGAPLEX',1,300),('Chennai',102,'MEGAPLEX',2,250),('Chennai',102,'MEGAPLEX',3,200),('Chennai',103,'INOX',1,300),('Chennai',103,'INOX',2,250),('Chennai',103,'INOX',3,200),('Chennai',104,'MAYAJAAL',1,300),('Chennai',104,'MAYAJAAL',2,250),('Chennai',104,'MAYAJAAL',3,200),('Mumbai',201,'Carnival_Cinemas',1,300),('Mumbai',201,'Carnival_Cinemas',2,250),('Mumbai',201,'Carnival_Cinemas',3,200),('Mumbai',202,'Regal_Cinemas',1,300),('Mumbai',202,'Regal_Cinemas',2,249),('Mumbai',202,'Regal_Cinemas',3,200),('Mumbai',203,'Eros_Cinemas',1,300),('Mumbai',203,'Eros_Cinemas',2,249),('Mumbai',203,'Eros_Cinemas',3,200),('Mumbai',204,'Maxus_Cinemas',1,300),('Mumbai',204,'Maxus_Cinemas',2,250),('Mumbai',204,'Maxus_Cinemas',3,200),('Delhi',301,'Ritz_Cinemas',1,300),('Delhi',301,'Ritz_Cinemas',2,250),('Delhi',301,'Ritz_Cinemas',3,200),('Delhi',302,'Satyam_Cinemas',1,300),('Delhi',302,'Satyam_Cinemas',2,250),('Delhi',302,'Satyam_Cinemas',3,200),('Delhi',303,'Delite_Cinemas',1,300),('Delhi',303,'Delite_Cinemas',2,250),('Delhi',303,'Delite_Cinemas',3,200),('Delhi',304,'Us_Cinemas',1,300),('Delhi',304,'Us_Cinemas',2,250),('Delhi',304,'Us_Cinemas',3,200),('Kolkata',401,'Miraj_Cinemas',1,300),('Kolkata',401,'Miraj_Cinemas',2,250),('Kolkata',401,'Miraj_Cinemas',3,200),('Kolkata',402,'RDB_Cinemas',1,300),('Kolkata',402,'RDB_Cinemas',2,250),('Kolkata',402,'RDB_Cinemas',3,200),('Kolkata',403,'SVF_Cinemas',1,300),('Kolkata',403,'SVF_Cinemas',2,250),('Kolkata',403,'SVF_Cinemas',3,200),('Kolkata',404,'Minerva_Cinemas',1,300),('Kolkata',404,'Minerva_Cinemas',2,249),('Kolkata',404,'Minerva_Cinemas',3,200);
/*!40000 ALTER TABLE `theatreinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `name` text,
  `username` varchar(30) NOT NULL,
  `password` text,
  `phone_number` bigint DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('abcd','abcd@xyz.com','abcd123',9876543210),('efgh','efgh@xyz.com','efgh123',8976543210),('ijkl','ijkl@xyz.com','ijkl123',7984561230);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'project'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 13:58:23
