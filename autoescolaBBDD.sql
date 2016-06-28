CREATE DATABASE  IF NOT EXISTS `autoescola` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `autoescola`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: autoescola
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `alumne`
--

DROP TABLE IF EXISTS `alumne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumne` (
  `fk_persona` varchar(9) NOT NULL,
  `numIntents` int(10) unsigned zerofill NOT NULL,
  KEY `fk_persona_idx` (`fk_persona`),
  CONSTRAINT `fk_persona` FOREIGN KEY (`fk_persona`) REFERENCES `persona` (`nif`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumne`
--

LOCK TABLES `alumne` WRITE;
/*!40000 ALTER TABLE `alumne` DISABLE KEYS */;
INSERT INTO `alumne` VALUES ('43403565N',0000000000),('12344567F',0000000000),('22334455Y',0000000000),('33445566R',0000000000);
/*!40000 ALTER TABLE `alumne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carnet`
--

DROP TABLE IF EXISTS `carnet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carnet` (
  `id` int(11) NOT NULL,
  `tipus` varchar(5) NOT NULL,
  `descripcio` varchar(20) NOT NULL,
  `preuHora` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idCarnet_UNIQUE` (`id`),
  UNIQUE KEY `tipus_UNIQUE` (`tipus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carnet`
--

LOCK TABLES `carnet` WRITE;
/*!40000 ALTER TABLE `carnet` DISABLE KEYS */;
INSERT INTO `carnet` VALUES (12,'B1','coche',10.12),(13,'B-US','bus escolar',23.89),(23,'C2','camio',20.45),(56,'D8','bus',25.67);
/*!40000 ALTER TABLE `carnet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `codi` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `total` double NOT NULL,
  `fk_matricula` int(11) NOT NULL,
  PRIMARY KEY (`codi`),
  KEY `fk7_matricula_idx` (`fk_matricula`),
  CONSTRAINT `fk7_matricula` FOREIGN KEY (`fk_matricula`) REFERENCES `matricula` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (2,'2016-06-28 00:00:00',272.19,1);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_alumne` varchar(9) NOT NULL,
  `fk_carnet` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk2_alumne_idx` (`fk_alumne`),
  KEY `fk3_carnet_idx` (`fk_carnet`),
  CONSTRAINT `fk2_alumne` FOREIGN KEY (`fk_alumne`) REFERENCES `alumne` (`fk_persona`) ON UPDATE CASCADE,
  CONSTRAINT `fk3_carnet` FOREIGN KEY (`fk_carnet`) REFERENCES `carnet` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,'43403565N',23),(4,'12344567F',12),(5,'33445566R',23);
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `nif` varchar(9) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `cognoms` varchar(45) NOT NULL,
  `dataNaixement` date NOT NULL,
  PRIMARY KEY (`nif`),
  UNIQUE KEY `nif_UNIQUE` (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('12344567F','nom 12344567F','cognom 12344567F','2002-06-18'),('12345678Z','nom profe 12345678Z','cognoms profe 12345678Z','1984-06-17'),('22222222J','profe 2222','apellidos 2222','1992-04-05'),('22334455Y','nom alum. 223344','cognoms alum. 223344','1998-06-28'),('23233333K','profe 2323333K','cognom 232333K','1978-06-01'),('23456789D','nom del 2345','cognoms del 2345','1987-06-17'),('33333333P','profe 3333','apellidos 3333','1964-11-10'),('33445566R','dolores','fuertes de barriga','1995-06-28'),('34567890V','nom profe 34567890V','cognom 34567890V','1972-06-18'),('43403565N','pepe','martinez garcia','2016-06-18');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `practica`
--

DROP TABLE IF EXISTS `practica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `practica` (
  `codi` int(11) NOT NULL AUTO_INCREMENT,
  `fk_alumne` varchar(9) NOT NULL,
  `fk_professor` varchar(9) NOT NULL,
  `fk_vehicle` varchar(7) NOT NULL,
  `data` datetime NOT NULL,
  `horaInici` int(11) NOT NULL,
  PRIMARY KEY (`codi`),
  UNIQUE KEY `codi_UNIQUE` (`codi`),
  KEY `fk5_professor_idx` (`fk_professor`),
  KEY `fk6_vehicle_idx` (`fk_vehicle`),
  KEY `fk_4alumne_idx` (`fk_alumne`),
  CONSTRAINT `fk4_alumne` FOREIGN KEY (`fk_alumne`) REFERENCES `alumne` (`fk_persona`) ON UPDATE CASCADE,
  CONSTRAINT `fk5_professor` FOREIGN KEY (`fk_professor`) REFERENCES `professor` (`fk_persona`) ON UPDATE CASCADE,
  CONSTRAINT `fk6_vehicle` FOREIGN KEY (`fk_vehicle`) REFERENCES `vehicle` (`matricula`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practica`
--

LOCK TABLES `practica` WRITE;
/*!40000 ALTER TABLE `practica` DISABLE KEYS */;
INSERT INTO `practica` VALUES (1,'43403565N','23456789D','2345ZXC','2016-06-27 00:00:00',8),(2,'43403565N','23456789D','2345ZXC','2016-06-29 00:00:00',11),(3,'43403565N','23456789D','1234ASD','2016-06-29 00:00:00',12),(8,'12344567F','23233333K','4444ASD','2016-07-08 00:00:00',9),(9,'43403565N','22222222J','2345ZXC','2016-07-13 00:00:00',8),(10,'43403565N','22222222J','2345ZXC','2016-08-24 00:00:00',8),(11,'43403565N','22222222J','2345ZXC','2016-06-28 00:00:00',8),(13,'43403565N','22222222J','2345ZXC','2016-06-28 00:00:00',10),(14,'43403565N','22222222J','2345ZXC','2016-06-28 00:00:00',11),(15,'43403565N','22222222J','2345ZXC','2016-06-28 00:00:00',12),(16,'43403565N','22222222J','2345ZXC','2016-06-28 00:00:00',13),(17,'12344567F','23233333K','4444ASD','2016-06-28 00:00:00',8),(18,'43403565N','23456789D','1234ASD','2016-06-30 00:00:00',8);
/*!40000 ALTER TABLE `practica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `fk_persona` varchar(9) NOT NULL,
  `ensenyament` varchar(1) NOT NULL,
  `fk_carnet` int(11) NOT NULL,
  PRIMARY KEY (`fk_persona`),
  KEY `fk_carnet_idx` (`fk_carnet`),
  CONSTRAINT `fk8_persona` FOREIGN KEY (`fk_persona`) REFERENCES `persona` (`nif`) ON UPDATE CASCADE,
  CONSTRAINT `fk_carnet` FOREIGN KEY (`fk_carnet`) REFERENCES `carnet` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('12345678Z','T',12),('22222222J','P',23),('23233333K','P',12),('23456789D','P',23),('33333333P','T',12),('34567890V','T',23);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `matricula` varchar(7) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `fk_carnet` int(11) NOT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_carnet_idx` (`fk_carnet`),
  CONSTRAINT `fk_carnet_1` FOREIGN KEY (`fk_carnet`) REFERENCES `carnet` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('1111ZXC','seat','ibiza',23),('1234ASD','renault','clyo',23),('2222ZXC','seat','leon',23),('2233ASD','camion','remolque',56),('2345ZXC','seat','malaga',23),('3344ASD','bus','electric',13),('4444ASD','fiat','punto',12);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-28 15:01:13
