-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbproyecto2
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ap1` varchar(15) NOT NULL,
  `ap2` varchar(15) NOT NULL,
  `rfc` varchar(14) NOT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Roberto','Acevedo','Sanchez','ACSR981122','rob@gmail.com'),(2,'Diana','Santiago','Cabrera','SACD780607','dia@gmail.com'),(3,'Daniel','Acevedo','Salvador','ACSD011123','dan@gmail.com'),(4,'Natalia','Acevedo','Saavedra','ACSN160106','NAT@gmail.com'),(5,'Carmen','Gutierrez','Lopez','GULC981522','car@gmail.com'),(6,'Jose','Aguilar','Sanchez','AGSJ985474','jos@gmail.com'),(7,'Josefina','Acevedo','Gomez','ACGR915172','jose@gmail.com'),(8,'Rafael','Altamirano','Carrazco','ALCR942128','raf@gmail.com'),(9,'Gabriel','Acevedo','Benitez','ACBG987416','her@gmail.com'),(10,'Oscar','Arteaga','Lopez','ARLO154222','lou@gmail.com'),(11,'Bruno','Esteban','Antonio','ESAB154120','bru@gmail.com'),(12,'Bruno','Esteban','Ventura','ESVB024322','bruNO@gmail.com'),(13,'Jose','Martinez','Merida','MAMJ974230','jose@gmail.com'),(14,'Martha','Fragoso','Gutierrez','FRGM914210','mar@gmail.com'),(16,'Alfredo','Gatica','Galindo','GAGA931010','alfr@gmail.com'),(17,'Luis','Hernandez','Montero','HEML941278','luissi@gmail.com'),(18,'Claudia','Gonzales','Cabrero','GOCC954214','CLAU@gmail.com'),(19,'Heigi','Jung','Cook','JUCH962317','heig@gmail.com'),(20,'Maria','Lara','Muñoz','LAMM971222','mariaas@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colores`
--

DROP TABLE IF EXISTS `colores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colores` (
  `idcolor` int(11) NOT NULL,
  `color` varchar(15) NOT NULL,
  PRIMARY KEY (`idcolor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colores`
--

LOCK TABLES `colores` WRITE;
/*!40000 ALTER TABLE `colores` DISABLE KEYS */;
INSERT INTO `colores` VALUES (2,'ámbar'),(3,'azul'),(4,'beis'),(5,'blanco'),(6,'blanco marfil'),(7,'cafe'),(8,'caqui'),(9,'coral'),(10,'fucsia'),(11,'gris'),(12,'hueso'),(13,'lila'),(14,'magenta'),(16,'naranja'),(17,'negro'),(18,'dorado'),(19,'plata'),(20,'rojo');
/*!40000 ALTER TABLE `colores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_venta` (
  `iddetalle` int(11) NOT NULL,
  `costo_total` double NOT NULL,
  `cantidadproductos` int(11) NOT NULL,
  `idencabezado` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle`),
  KEY `encabezado_idx` (`idencabezado`),
  KEY `producto_idx` (`idproducto`),
  CONSTRAINT `encabezado` FOREIGN KEY (`idencabezado`) REFERENCES `encabezado_venta` (`idencabezado_venta`),
  CONSTRAINT `producto` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (1,8570,1,1,10),(2,13000,2,2,8),(3,46000,4,3,7),(4,63000,6,4,5),(5,94270,11,5,10),(6,3500,1,6,4),(7,44000,8,7,6),(8,30000,4,8,2),(9,17000,2,9,1),(10,28500,3,10,3),(11,57500,5,10,7);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encabezado_venta`
--

DROP TABLE IF EXISTS `encabezado_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encabezado_venta` (
  `idencabezado_venta` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idencabezado_venta`),
  KEY `cliente_idx` (`idcliente`),
  CONSTRAINT `cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encabezado_venta`
--

LOCK TABLES `encabezado_venta` WRITE;
/*!40000 ALTER TABLE `encabezado_venta` DISABLE KEYS */;
INSERT INTO `encabezado_venta` VALUES (1,20,'2016-04-21'),(2,19,'2016-05-27'),(3,17,'2016-07-24'),(4,16,'2016-08-30'),(5,14,'2016-10-10'),(6,13,'2016-11-01'),(7,10,'2016-12-05'),(8,5,'2016-04-09'),(9,3,'2016-01-04'),(10,2,'2016-03-17');
/*!40000 ALTER TABLE `encabezado_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estatus`
--

DROP TABLE IF EXISTS `estatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estatus` (
  `idstatus` int(11) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  PRIMARY KEY (`idstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estatus`
--

LOCK TABLES `estatus` WRITE;
/*!40000 ALTER TABLE `estatus` DISABLE KEYS */;
INSERT INTO `estatus` VALUES (1,'vendido'),(2,'disponible'),(3,'agotado'),(4,'apartado');
/*!40000 ALTER TABLE `estatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `herraje`
--

DROP TABLE IF EXISTS `herraje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `herraje` (
  `idherraje` int(11) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  PRIMARY KEY (`idherraje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `herraje`
--

LOCK TABLES `herraje` WRITE;
/*!40000 ALTER TABLE `herraje` DISABLE KEYS */;
INSERT INTO `herraje` VALUES (1,'cobre'),(2,'cobre brillante'),(3,'cobre latón'),(4,'niquel cobre'),(5,'niquel'),(6,'latón brillante'),(7,'latón estaño'),(8,'latón pavón'),(9,'niquel mate'),(10,'estaño satinado'),(11,'estaño pavón'),(12,'oro'),(13,'plata'),(14,'pavón');
/*!40000 ALTER TABLE `herraje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_cliente`
--

DROP TABLE IF EXISTS `log_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_cliente` (
  `idcliente_nueva` int(11) DEFAULT NULL,
  `idcliente_vieja` int(11) DEFAULT NULL,
  `nombre_nueva` varchar(50) DEFAULT NULL,
  `nombre_vieja` varchar(50) DEFAULT NULL,
  `ape1_nueva` varchar(15) DEFAULT NULL,
  `ape1_vieja` varchar(15) DEFAULT NULL,
  `ape2_nueva` varchar(15) DEFAULT NULL,
  `ape2_vieja` varchar(15) DEFAULT NULL,
  `rfc_nueva` varchar(12) DEFAULT NULL,
  `rfc_vieja` varchar(12) DEFAULT NULL,
  `correo_nueva` varchar(50) DEFAULT NULL,
  `correo_vieja` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_cliente`
--

LOCK TABLES `log_cliente` WRITE;
/*!40000 ALTER TABLE `log_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_colores`
--

DROP TABLE IF EXISTS `log_colores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_colores` (
  `idcolor_nueva` int(11) DEFAULT NULL,
  `idcolor_vieja` int(11) DEFAULT NULL,
  `color_nueva` varchar(15) DEFAULT NULL,
  `color_vieja` varchar(15) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `hora_fecha` datetime DEFAULT NULL,
  `momento` varchar(45) DEFAULT NULL,
  `eventol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_colores`
--

LOCK TABLES `log_colores` WRITE;
/*!40000 ALTER TABLE `log_colores` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_colores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_detalle_venta`
--

DROP TABLE IF EXISTS `log_detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_detalle_venta` (
  `iddetalle_nueva` int(11) DEFAULT NULL,
  `iddetalle_vieja` int(11) DEFAULT NULL,
  `idproducto_nueva` int(11) DEFAULT NULL,
  `idproducto_vieja` int(11) DEFAULT NULL,
  `costo_total_nueva` double DEFAULT NULL,
  `costo_total_vieja` double DEFAULT NULL,
  `cantidadproductos_nueva` int(11) DEFAULT NULL,
  `cantidadproductos_vieja` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_detalle_venta`
--

LOCK TABLES `log_detalle_venta` WRITE;
/*!40000 ALTER TABLE `log_detalle_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_encabezado_venta`
--

DROP TABLE IF EXISTS `log_encabezado_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_encabezado_venta` (
  `idencabezado_venta_nueva` int(11) DEFAULT NULL,
  `idencabezado_venta_vieja` int(11) DEFAULT NULL,
  `idcliente_nueva` int(11) DEFAULT NULL,
  `idcliente_vieja` int(11) DEFAULT NULL,
  `fecha_nueva` date DEFAULT NULL,
  `fecha_vieja` date DEFAULT NULL,
  `detalle_venta_nueva` int(11) DEFAULT NULL,
  `detalle_venta_vieja` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_encabezado_venta`
--

LOCK TABLES `log_encabezado_venta` WRITE;
/*!40000 ALTER TABLE `log_encabezado_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_encabezado_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_herraje`
--

DROP TABLE IF EXISTS `log_herraje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_herraje` (
  `idherraje_nueva` int(11) DEFAULT NULL,
  `idherraje_vieja` int(11) DEFAULT NULL,
  `tipo_nueva` varchar(15) DEFAULT NULL,
  `tipo_vieja` varchar(15) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `hora_fecha` datetime DEFAULT NULL,
  `momento` varchar(45) DEFAULT NULL,
  `evento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_herraje`
--

LOCK TABLES `log_herraje` WRITE;
/*!40000 ALTER TABLE `log_herraje` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_herraje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_material`
--

DROP TABLE IF EXISTS `log_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_material` (
  `idmaterial_nueva` int(11) DEFAULT NULL,
  `idmaterial_vieja` int(11) DEFAULT NULL,
  `tipo_nueva` varchar(25) DEFAULT NULL,
  `tipo_vieja` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_material`
--

LOCK TABLES `log_material` WRITE;
/*!40000 ALTER TABLE `log_material` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_medidas`
--

DROP TABLE IF EXISTS `log_medidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_medidas` (
  `idmedida_nueva` int(11) DEFAULT NULL,
  `idmedida_vieja` int(11) DEFAULT NULL,
  `ancho_nueva` int(11) DEFAULT NULL,
  `ancho_vieja` int(11) DEFAULT NULL,
  `alto_nueva` int(11) DEFAULT NULL,
  `alto_vieja` int(11) DEFAULT NULL,
  `fondo_nueva` int(11) DEFAULT NULL,
  `fondo_vieja` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_medidas`
--

LOCK TABLES `log_medidas` WRITE;
/*!40000 ALTER TABLE `log_medidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_medidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_modelo`
--

DROP TABLE IF EXISTS `log_modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_modelo` (
  `idmodelo_nueva` int(11) DEFAULT NULL,
  `idmodelo_vieja` int(11) DEFAULT NULL,
  `imagen_nueva` blob,
  `imagen_vieja` blob,
  `idcolor_nueva` int(11) DEFAULT NULL,
  `idcolor_vieja` int(11) DEFAULT NULL,
  `idmaterial_nueva` int(11) DEFAULT NULL,
  `idmaterial_vieja` int(11) DEFAULT NULL,
  `idmedidas_nueva` int(11) DEFAULT NULL,
  `idmedidas_vieja` int(11) DEFAULT NULL,
  `idherraje_nueva` int(11) DEFAULT NULL,
  `idherraje_vieja` int(11) DEFAULT NULL,
  `precio_nueva` double DEFAULT NULL,
  `precio_vieja` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_modelo`
--

LOCK TABLES `log_modelo` WRITE;
/*!40000 ALTER TABLE `log_modelo` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_producto`
--

DROP TABLE IF EXISTS `log_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_producto` (
  `idproducto_nueva` int(11) DEFAULT NULL,
  `idproducto_vieja` int(11) DEFAULT NULL,
  `idmodelo_nueva` int(11) DEFAULT NULL,
  `idmodelo_vieja` int(11) DEFAULT NULL,
  `p_venta_publico_nueva` double DEFAULT NULL,
  `p_venta_publico_vieja` double DEFAULT NULL,
  `productos_disponibles_nueva` int(11) DEFAULT NULL,
  `productos_disponibles_vieja` int(11) DEFAULT NULL,
  `descuento_nueva` int(11) DEFAULT NULL,
  `descuento_vieja` int(11) DEFAULT NULL,
  `idstatus_nueva` int(11) DEFAULT NULL,
  `idstatus_vieja` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_producto`
--

LOCK TABLES `log_producto` WRITE;
/*!40000 ALTER TABLE `log_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_status`
--

DROP TABLE IF EXISTS `log_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_status` (
  `idstatus_nueva` int(11) DEFAULT NULL,
  `idstatus_vieja` int(11) DEFAULT NULL,
  `tipo_nueva` varchar(15) DEFAULT NULL,
  `tipo_vieja` varchar(15) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `hora_fecha` datetime DEFAULT NULL,
  `momento` varchar(45) DEFAULT NULL,
  `evento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_status`
--

LOCK TABLES `log_status` WRITE;
/*!40000 ALTER TABLE `log_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `idmaterial` int(11) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  PRIMARY KEY (`idmaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'satén'),(2,'seda'),(3,'algodón'),(4,'piel'),(5,'sintetico'),(6,'bordado'),(7,'mezclilla'),(8,'plastico'),(9,'piel serpiente'),(10,'piel cocodrilo'),(11,'plumas');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medidas`
--

DROP TABLE IF EXISTS `medidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medidas` (
  `idmedida` int(11) NOT NULL,
  `ancho` int(11) NOT NULL,
  `alto` int(11) NOT NULL,
  `fondo` int(11) NOT NULL,
  PRIMARY KEY (`idmedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medidas`
--

LOCK TABLES `medidas` WRITE;
/*!40000 ALTER TABLE `medidas` DISABLE KEYS */;
INSERT INTO `medidas` VALUES (1,40,20,15),(2,55,42,30),(3,45,30,15),(4,35,25,16),(5,45,31,15),(6,27,21,5),(7,40,24,12),(8,55,21,10),(9,47,15,20),(10,60,40,30),(11,15,15,15),(12,53,23,13),(13,44,22,11),(14,40,20,10),(15,48,20,23);
/*!40000 ALTER TABLE `medidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modelo` (
  `idmodelo` int(11) NOT NULL,
  `imagen` longtext NOT NULL,
  `idcolor` int(11) NOT NULL,
  `idmaterial` int(11) NOT NULL,
  `idmedidas` int(11) NOT NULL,
  `idherraje` int(11) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idmodelo`),
  KEY `color_idx` (`idcolor`),
  KEY `material_idx` (`idmaterial`),
  KEY `medidas_idx` (`idmedidas`),
  KEY `herraje_idx` (`idherraje`),
  CONSTRAINT `color` FOREIGN KEY (`idcolor`) REFERENCES `colores` (`idcolor`),
  CONSTRAINT `herraje` FOREIGN KEY (`idherraje`) REFERENCES `herraje` (`idherraje`),
  CONSTRAINT `material` FOREIGN KEY (`idmaterial`) REFERENCES `material` (`idmaterial`),
  CONSTRAINT `medidas` FOREIGN KEY (`idmedidas`) REFERENCES `medidas` (`idmedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'D:\nPicturesproTallerolsaazul',20,10,5,3,8000),(2,'D:\nPicturesproTallerolsanegra',18,11,15,14,10000),(3,'D:\nPicturesproTallerolsarosa',16,8,13,12,6000),(4,'D:\nPicturesproTallercafecita',14,6,11,10,11000),(5,'D:\nPicturesproTallerdescarga',12,4,9,8,5000),(6,'D:\nPicturesproTaller\rosita',10,2,7,6,18000),(7,'D:\nPicturesproTallerolsaazul',8,1,5,4,3000),(8,'D:\nPicturesproTallerolsanegra',6,3,3,2,9000),(9,'D:\nPicturesproTallerolsarosa',4,5,1,1,7000),(10,'D:\nPicturesproTallercafecita',2,7,2,2,8000);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `idmodelo` int(11) NOT NULL,
  `p_venta_publico` double NOT NULL,
  `productos_disponibles` int(11) NOT NULL,
  `descuento` int(11) NOT NULL,
  `idstatus` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `modelo_idx` (`idmodelo`),
  KEY `status_idx` (`idstatus`),
  CONSTRAINT `modelo` FOREIGN KEY (`idmodelo`) REFERENCES `modelo` (`idmodelo`),
  CONSTRAINT `status` FOREIGN KEY (`idstatus`) REFERENCES `estatus` (`idstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,10,8500,50,10,2,'Bolsa Camaleon'),(2,9,7500,45,10,2,'Bolsa Gucci'),(3,8,9500,30,15,4,'Bolsa PE'),(4,7,3500,50,20,4,'Bolsa Tommy'),(5,6,10500,10,15,2,'Bolsa Adidas'),(6,5,5500,23,30,4,'Bolsa Nike'),(7,4,11500,12,12,2,'Bolsa Puma'),(8,3,6500,57,17,2,'Bolsa ITO'),(9,2,10520,60,15,2,'Bolsa TCNM'),(10,10,8570,14,7,2,'Bolsa Apple');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-12 12:46:27
