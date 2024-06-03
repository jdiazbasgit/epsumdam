-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 192.168.0.126    Database: empresas
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DESCRIPCION_UNIQUE` (`DESCRIPCION`)
) ENGINE=InnoDB AUTO_INCREMENT=1617 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (16,'Becario'),(17,'Intendente'),(15,'recepción'),(39,'victor milerurista 12222');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_laborales`
--

DROP TABLE IF EXISTS `datos_laborales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_laborales` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SALARIO` int NOT NULL,
  `CARGOS_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_DATOS_LABORALES_CARGOS1_idx` (`CARGOS_ID`),
  CONSTRAINT `fk_DATOS_LABORALES_CARGOS1` FOREIGN KEY (`CARGOS_ID`) REFERENCES `cargos` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_laborales`
--

LOCK TABLES `datos_laborales` WRITE;
/*!40000 ALTER TABLE `datos_laborales` DISABLE KEYS */;
INSERT INTO `datos_laborales` VALUES (1,5000,39),(2,70,16),(3,4000,17),(5,80,15);
/*!40000 ALTER TABLE `datos_laborales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_personales`
--

DROP TABLE IF EXISTS `datos_personales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_personales` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `HIJOS_ID` int NOT NULL,
  `ESTADOS_CIVILES_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_DATOS_PERSONALES_HIJOS1_idx` (`HIJOS_ID`),
  KEY `fk_DATOS_PERSONALES_ESTADOS_CIVILES1_idx` (`ESTADOS_CIVILES_ID`),
  CONSTRAINT `fk_DATOS_PERSONALES_ESTADOS_CIVILES1` FOREIGN KEY (`ESTADOS_CIVILES_ID`) REFERENCES `estados_civiles` (`ID`),
  CONSTRAINT `fk_DATOS_PERSONALES_HIJOS1` FOREIGN KEY (`HIJOS_ID`) REFERENCES `hijos` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_personales`
--

LOCK TABLES `datos_personales` WRITE;
/*!40000 ALTER TABLE `datos_personales` DISABLE KEYS */;
INSERT INTO `datos_personales` VALUES (1,1,1);
/*!40000 ALTER TABLE `datos_personales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `TELEFONO` varchar(9) NOT NULL,
  `EMPRESAS_ID` int NOT NULL,
  `DATOS_PERSONALES_ID` int NOT NULL,
  `DATOS_LABORALES_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`),
  KEY `fk_EMPLEADOS_EMPRESAS_idx` (`EMPRESAS_ID`),
  KEY `fk_EMPLEADOS_DATOS_PERSONALES1_idx` (`DATOS_PERSONALES_ID`),
  KEY `fk_EMPLEADOS_DATOS_LABORALES1_idx` (`DATOS_LABORALES_ID`),
  CONSTRAINT `fk_EMPLEADOS_DATOS_LABORALES1` FOREIGN KEY (`DATOS_LABORALES_ID`) REFERENCES `datos_laborales` (`ID`),
  CONSTRAINT `fk_EMPLEADOS_DATOS_PERSONALES1` FOREIGN KEY (`DATOS_PERSONALES_ID`) REFERENCES `datos_personales` (`ID`),
  CONSTRAINT `fk_EMPLEADOS_EMPRESAS` FOREIGN KEY (`EMPRESAS_ID`) REFERENCES `empresas` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'profe','dfg','dfg','dfg',1,1,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `CIF` varchar(9) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (1,'epsum','123456789'),(6,'asasfa','126234134'),(8,'12312','eqewe'),(9,'2wq4234','35234rqw'),(10,'12312','eqewe'),(51,'pepe77777','32423423'),(52,'pepe3','dadssd'),(53,'pepe634','42324512');
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados_civiles`
--

DROP TABLE IF EXISTS `estados_civiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estados_civiles` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DECRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados_civiles`
--

LOCK TABLES `estados_civiles` WRITE;
/*!40000 ALTER TABLE `estados_civiles` DISABLE KEYS */;
INSERT INTO `estados_civiles` VALUES (1,'solteros'),(21,'solterooooooo'),(22,'soltero y entero'),(24,'Casado pero disponible'),(27,'Domino`s Slave'),(29,'casado y con hijos'),(30,'casado y entero'),(31,'casado y con hijos'),(41,'solterooooooo'),(42,'soltero y entero'),(43,'solterooooooo'),(44,'soltero y entero'),(45,'solterooooooo'),(58,'MARCOOOOOSykikeeee'),(67,'PRUEBA TEST'),(81,'rodrigo2'),(82,'rodrigo3'),(84,'rodrigo12'),(86,'789654123'),(87,'nnnnnnn'),(88,'nnnnnnn'),(89,'nnnnnnn'),(92,'aaaa'),(93,'aaaaaaaaaaaa'),(94,'aaaaaaaaaaaa'),(95,'aaaaaaaaaaaa'),(97,'aaaaaaaaaaaa'),(99,'prueba'),(101,'kikeñooooooooooo'),(102,'kikeñooooooooooo'),(103,'kikeñooooooooooo'),(104,'a'),(109,'funciona'),(111,'asdlasndlasdñlasdñasjd'),(115,'asdasdasd'),(116,'asdlasndlasdñlasdñasjd'),(117,'zxsdfasf'),(120,'asdlasndlasdñlasdñasjd'),(129,'asdfagf'),(131,'CR7'),(133,'asdasd2222222222222222'),(135,'KIKE Y SU PAGINA WEB'),(136,'jajajajajjajajajajaja'),(137,'hola kike'),(138,'qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq'),(139,'FUNCIONA PROFE'),(140,'CON MODIFICAR EN CODIGO');
/*!40000 ALTER TABLE `estados_civiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hijos`
--

DROP TABLE IF EXISTS `hijos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hijos` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CHICOS` int NOT NULL DEFAULT '0',
  `CHICAS` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hijos`
--

LOCK TABLES `hijos` WRITE;
/*!40000 ALTER TABLE `hijos` DISABLE KEYS */;
INSERT INTO `hijos` VALUES (1,1,1),(2,0,2),(4,2,0),(5,1,2),(12,6,2),(22,4,3),(24,45,41);
/*!40000 ALTER TABLE `hijos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-30 11:26:25
