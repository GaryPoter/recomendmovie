CREATE DATABASE  IF NOT EXISTS `moviedb(test)` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `moviedb(test)`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: moviedb(test)
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) NOT NULL,
  `movie_resouse_url` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `starring` varchar(45) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movie_image1_idx` (`image_url`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (24,'yyyjj','ccc',NULL,'ccc','ccc','ccc','333',2),(26,'sdd','dd','0','yy','tt','tt','77',1),(39,'666','666','0','66','66','中国（香港）','666',NULL),(40,'00gg','000','0','00','000','中国','00',1),(41,'tt','呀呀','0','丫丫','呀呀','日本','55',2),(44,'sdddd','dddd','0','ddd','tddt','英国','77',1),(45,'kk','k','0','k','k','中国','k',1),(46,'5kk','5','0','5','5','中国','5',3),(47,'1','1','0','1','1','中国','1',2),(48,'4tqmm','t',NULL,'t','t','中国','t',2),(50,'冉冉3 3','4444',NULL,'冉冉','大大','中国','22',2),(51,'2222','4444',NULL,'冉冉','发发','中国','222',1);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movietype`
--

DROP TABLE IF EXISTS `movietype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movietype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `type_id_UNIQUE` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movietype`
--

LOCK TABLES `movietype` WRITE;
/*!40000 ALTER TABLE `movietype` DISABLE KEYS */;
INSERT INTO `movietype` VALUES (1,'武打'),(2,'恐怖'),(3,'喜剧');
/*!40000 ALTER TABLE `movietype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表\nid\n用户名\nemail\n密码\n创建日期',
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'GaryPotter','1183111702@qq.com','hewei123'),(4,'南宫霸天','1037889020@qq.com','hewei123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_comment_movie`
--

DROP TABLE IF EXISTS `user_comment_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_comment_movie` (
  `id` bigint(20) NOT NULL COMMENT '用户评论打分表\nid\n用户id\n电影id\n评论内容 可为空\n评论时间\n评价',
  `user_id` bigint(20) NOT NULL,
  `movie_id` bigint(20) NOT NULL,
  `comment` tinytext,
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `score` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_has_movie_movie1_idx` (`movie_id`),
  KEY `fk_user_has_movie_user_idx` (`user_id`),
  CONSTRAINT `fk_user_has_movie_movie1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_movie_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_comment_movie`
--

LOCK TABLES `user_comment_movie` WRITE;
/*!40000 ALTER TABLE `user_comment_movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_comment_movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-12 15:37:11
