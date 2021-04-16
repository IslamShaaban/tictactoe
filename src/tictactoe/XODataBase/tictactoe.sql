CREATE DATABASE  IF NOT EXISTS `tictactoe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tictactoe`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: tictactoe
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `game_id` int NOT NULL AUTO_INCREMENT,
  `player1_name` varchar(45) DEFAULT NULL,
  `player2_name` varchar(45) DEFAULT NULL,
  `winner` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`game_id`),
  UNIQUE KEY `game_id_UNIQUE` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'islam','abdelhay','O'),(3,'shrook','marwa','X'),(4,'suzan','ali','O'),(5,'soha',NULL,NULL),(6,'soha',NULL,NULL),(7,'soha',NULL,NULL),(8,'soha',NULL,NULL),(9,'soha',NULL,NULL),(10,'soha',NULL,NULL),(11,'suzy',NULL,NULL),(12,'suzy',NULL,NULL),(13,'suzy',NULL,NULL),(14,'suzy',NULL,NULL),(15,'suzy',NULL,NULL),(16,NULL,'marwaaaa',NULL),(17,'suzy',NULL,NULL),(18,'suzy',NULL,NULL),(19,'suzy','marwaaaa',NULL),(20,'suzy','marwaaaa',NULL),(21,'suzy','marwaaaa',NULL),(22,'suzy','marwaaaa',NULL),(23,'suzy','marwaaaa',NULL),(24,'suzy','marwaaaa',NULL),(25,'suzy','marwaaaa',NULL),(26,'suzy','marwaaaa',NULL),(27,'suzy','marwaaaa',NULL),(28,'suzy','marwaaaa',NULL),(29,'suzy','marwaaaa',NULL),(30,'suzy','marwaaaa',NULL),(31,'suzy','marwaaaa',NULL),(32,'suzy','marwaaaa',NULL),(33,'suzy','marwaaaa',NULL),(34,'suzy','marwaaaa',NULL),(35,'suzy','marwaaaa',NULL),(36,'suzy','marwaaaa',NULL),(37,'suzy','marwaaaa',NULL),(38,'suzy','marwaaaa',NULL),(39,'suzy','marwaaaa',NULL),(40,'suzy','marwaaaa',NULL),(41,'suzy','marwaaaa',NULL),(42,'suzy','marwaaaa',NULL);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `steps`
--

DROP TABLE IF EXISTS `steps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `steps` (
  `steps_id` int NOT NULL AUTO_INCREMENT,
  `game_id` int DEFAULT NULL,
  `player_name` varchar(45) DEFAULT NULL,
  `player_ch` varchar(45) DEFAULT NULL,
  `player_steps` varchar(5) DEFAULT NULL,
  `first_player` tinyint NOT NULL,
  PRIMARY KEY (`steps_id`),
  UNIQUE KEY `steps_id_UNIQUE` (`steps_id`),
  KEY `game_id_idx` (`game_id`),
  CONSTRAINT `game_id` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `steps`
--

LOCK TABLES `steps` WRITE;
/*!40000 ALTER TABLE `steps` DISABLE KEYS */;
INSERT INTO `steps` VALUES (1,1,'shrook','x','1357',1),(2,1,'sara','o','2468',2),(3,NULL,'shrook','x','13579',1),(4,NULL,'shrook','x','13579',1),(6,20,'suzy','x','486',1),(7,20,'marwaaaa','o','123',1),(8,21,'suzy','x','486',1),(9,21,'marwaaaa','o','123',2),(10,22,'suzy','x','486',1),(11,22,'marwaaaa','o','123',2),(12,23,'suzy','x','486',1),(13,23,'marwaaaa','o','123',2),(14,24,'suzy','x','486',1),(15,24,'marwaaaa','o','123',2),(16,25,'suzy','x','486',1),(17,25,'marwaaaa','o','123',2),(18,26,'suzy','x','486',1),(19,26,'marwaaaa','o','123',2),(20,27,'suzy','x','486',1),(21,27,'marwaaaa','o','123',2),(22,28,'suzy','x','486',1),(23,28,'marwaaaa','o','123',2),(24,29,'suzy','x','486',1),(25,29,'marwaaaa','o','123',2),(26,30,'suzy','x','486',1),(27,30,'marwaaaa','o','123',2),(28,31,'suzy','x','486',1),(29,31,'marwaaaa','o','123',2),(30,32,'suzy','x','486',1),(31,32,'marwaaaa','o','123',2),(32,33,'suzy','x','486',1),(33,33,'marwaaaa','o','123',2),(34,34,'suzy','x','486',1),(35,34,'marwaaaa','o','123',2),(36,35,'suzy','x','486',1),(37,35,'marwaaaa','o','123',2),(38,36,'suzy','x','486',1),(39,36,'marwaaaa','o','123',2),(40,37,'suzy','x','486',1),(41,37,'marwaaaa','o','123',2),(42,38,'suzy','o','945',1),(43,38,'marwaaaa','x','1732',2),(44,39,'Rana','o','945',2),(45,39,'marwaaaa','x','1732',1),(46,40,'Rana','o','945',2),(47,40,'marwaaaa','x','1732',1),(48,41,'Rana','o','1267',2),(49,41,'marwaaaa','x','34589',1),(50,42,'Rana','o','936',2),(51,42,'marwaaaa','x','187',1);
/*!40000 ALTER TABLE `steps` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-18  1:25:29
