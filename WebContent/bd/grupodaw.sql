-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: grupodaw
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
-- Table structure for table `tb_area`
--

DROP TABLE IF EXISTS `tb_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_area` (
  `id_area` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_area`
--

LOCK TABLES `tb_area` WRITE;
/*!40000 ALTER TABLE `tb_area` DISABLE KEYS */;
INSERT INTO `tb_area` VALUES (1,'Liquidación'),(2,'Comercial'),(3,'Post-Venta'),(4,'Sistemas');
/*!40000 ALTER TABLE `tb_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_area_has_tb_menu`
--

DROP TABLE IF EXISTS `tb_area_has_tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_area_has_tb_menu` (
  `tb_area_id_area` int(11) NOT NULL,
  `tb_menu_id_menu` int(11) NOT NULL,
  `ver` char(1) DEFAULT NULL,
  PRIMARY KEY (`tb_area_id_area`,`tb_menu_id_menu`),
  KEY `fk_tb_area_has_tb_menu_tb_area1` (`tb_area_id_area`),
  KEY `fk_tb_area_has_tb_menu_tb_menu1` (`tb_menu_id_menu`),
  CONSTRAINT `fk_tb_area_has_tb_menu_tb_area1` FOREIGN KEY (`tb_area_id_area`) REFERENCES `tb_area` (`id_area`),
  CONSTRAINT `fk_tb_area_has_tb_menu_tb_menu1` FOREIGN KEY (`tb_menu_id_menu`) REFERENCES `tb_menu` (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_area_has_tb_menu`
--

LOCK TABLES `tb_area_has_tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_area_has_tb_menu` DISABLE KEYS */;
INSERT INTO `tb_area_has_tb_menu` VALUES (1,1,'S'),(1,2,'S'),(1,3,'S'),(1,4,'N'),(1,5,'S'),(1,6,'N'),(1,7,'N'),(1,8,'S'),(1,9,'S'),(1,10,'S'),(1,11,'S'),(1,12,'N'),(1,14,'S'),(1,15,'S'),(1,16,'S'),(2,1,'S'),(2,2,'S'),(2,3,'N'),(2,4,'N'),(2,5,'S'),(2,6,'N'),(2,7,'S'),(2,8,'N'),(2,9,'N'),(2,10,'S'),(2,11,'S'),(2,12,'S'),(2,14,'S'),(2,15,'S'),(2,16,'S'),(3,1,'S'),(3,2,'N'),(3,3,'S'),(3,4,'N'),(3,5,'S'),(3,6,'N'),(3,7,'S'),(3,8,'S'),(3,9,'N'),(3,10,'S'),(3,11,'S'),(3,12,'S'),(3,14,'S'),(3,15,'S'),(3,16,'S'),(4,1,'S'),(4,2,'S'),(4,3,'S'),(4,4,'S'),(4,5,'S'),(4,6,'S'),(4,7,'S'),(4,8,'S'),(4,9,'S'),(4,10,'S'),(4,11,'S'),(4,12,'S'),(4,13,'S'),(4,14,'S'),(4,15,'S'),(4,16,'S');
/*!40000 ALTER TABLE `tb_area_has_tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_claseequipo`
--

DROP TABLE IF EXISTS `tb_claseequipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_claseequipo` (
  `id_claseEquipo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_claseEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_claseequipo`
--

LOCK TABLES `tb_claseequipo` WRITE;
/*!40000 ALTER TABLE `tb_claseequipo` DISABLE KEYS */;
INSERT INTO `tb_claseequipo` VALUES (1,'Excavadora'),(2,'Gruas'),(3,'Tractor'),(4,'Camion'),(5,'Compresores'),(6,'Vibradores'),(7,'Huinches'),(8,'Rompepavimentos'),(9,'Buses'),(10,'Microbuses'),(11,'Automovil');
/*!40000 ALTER TABLE `tb_claseequipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_cliente` (
  `id_cliente` varchar(11) NOT NULL,
  `razonsocial` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES ('1111111111','Empresa Demo S.A.','Av. Garcilaso de la Vega 339','3245899'),('1111111112','Inversiones Malok S.A.C','Av. Larco 102','3245866'),('1111111113','Fala Bem S.A.C','Av. Larco 205','2587412'),('12345654321','Empresa 2 SAC','Av Salaverry 1123','1111111'),('1238477999','test','test','test'),('9189999999','La Cantera SAC','Av. Procedes 123','1478524');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalleprefactura`
--

DROP TABLE IF EXISTS `tb_detalleprefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_detalleprefactura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tb_prefactura_id_prefactura` int(11) DEFAULT NULL,
  `item` int(11) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `precio_unitario` double DEFAULT NULL,
  `precio_total` double DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_detallePreFactura_tb_prefactura` (`tb_prefactura_id_prefactura`),
  CONSTRAINT `fk_tb_detallePreFactura_tb_prefactura` FOREIGN KEY (`tb_prefactura_id_prefactura`) REFERENCES `tb_prefactura` (`id_prefactura`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalleprefactura`
--

LOCK TABLES `tb_detalleprefactura` WRITE;
/*!40000 ALTER TABLE `tb_detalleprefactura` DISABLE KEYS */;
INSERT INTO `tb_detalleprefactura` VALUES (1,6,1,'Paquete 01',100,0,1,100),(2,6,2,'Paquete 02',300,0,3,900),(3,6,1,'Jhon ',50,0,5,250),(4,6,3,'Miguel',60,0,3,180),(5,7,1,'Paquete 01',100,0,1,100),(6,7,1,'Jhon ',50,0,2,100),(7,7,2,'Michael ',70,0,3,210),(8,8,1,'Paquete 01',100,0,1,100),(9,8,1,'Jhon ',50,0,0,0),(10,9,1,'Paquete 01',100,0,2,200),(11,9,4,'Paquete 04',165,0,2,330),(12,9,8,'eess',210,0,2,420),(13,9,1,'Jhon ',50,0,13,650),(14,9,3,'Miguel',60,0,7,420),(15,10,1,'Paquete 01',100,0,1,100),(16,11,1,'Paquete 01',100,0,2,200),(17,11,6,'Paquete 05',130,0,1,130),(18,12,1,'Paquete 01',100,0,2,200),(19,12,2,'Paquete 02',300,0,1,300),(20,13,8,'eess',210,0,1,210);
/*!40000 ALTER TABLE `tb_detalleprefactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_equipo`
--

DROP TABLE IF EXISTS `tb_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_equipo` (
  `nrotarjeta` varchar(11) NOT NULL,
  `nroserie` varchar(15) NOT NULL,
  `tb_claseEquipo_id_claseEquipo` int(11) DEFAULT NULL,
  `tb_cliente_id_cliente` varchar(11) DEFAULT NULL,
  `tb_modelo_id_modelo` int(11) NOT NULL,
  PRIMARY KEY (`nrotarjeta`),
  KEY `fk_tb_equipo_tb_claseEquipo` (`tb_claseEquipo_id_claseEquipo`),
  KEY `fk_tb_equipo_tb_cliente` (`tb_cliente_id_cliente`),
  KEY `fk_tb_equipo_tb_modelo1` (`tb_modelo_id_modelo`),
  CONSTRAINT `fk_tb_equipo_tb_claseEquipo` FOREIGN KEY (`tb_claseEquipo_id_claseEquipo`) REFERENCES `tb_claseequipo` (`id_claseequipo`),
  CONSTRAINT `fk_tb_equipo_tb_cliente` FOREIGN KEY (`tb_cliente_id_cliente`) REFERENCES `tb_cliente` (`id_cliente`),
  CONSTRAINT `fk_tb_equipo_tb_modelo1` FOREIGN KEY (`tb_modelo_id_modelo`) REFERENCES `tb_modelo` (`id_modelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_equipo`
--

LOCK TABLES `tb_equipo` WRITE;
/*!40000 ALTER TABLE `tb_equipo` DISABLE KEYS */;
INSERT INTO `tb_equipo` VALUES ('111111111','98653718212',1,'1111111111',1),('111111112','98653718213',1,'12345654321',1);
/*!40000 ALTER TABLE `tb_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_equipohorometro`
--

DROP TABLE IF EXISTS `tb_equipohorometro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_equipohorometro` (
  `id_horometro` int(11) NOT NULL,
  `horas` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `tb_equipo_nrotarjeta` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_horometro`),
  KEY `fk_tb_equipoHorometro_tb_equipo` (`tb_equipo_nrotarjeta`),
  CONSTRAINT `fk_tb_equipoHorometro_tb_equipo` FOREIGN KEY (`tb_equipo_nrotarjeta`) REFERENCES `tb_equipo` (`nrotarjeta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_equipohorometro`
--

LOCK TABLES `tb_equipohorometro` WRITE;
/*!40000 ALTER TABLE `tb_equipohorometro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_equipohorometro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_especialidades`
--

DROP TABLE IF EXISTS `tb_especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_especialidades` (
  `id_especialidad` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `costoDia` double DEFAULT NULL,
  PRIMARY KEY (`id_especialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_especialidades`
--

LOCK TABLES `tb_especialidades` WRITE;
/*!40000 ALTER TABLE `tb_especialidades` DISABLE KEYS */;
INSERT INTO `tb_especialidades` VALUES (1,'Mecanica',50),(2,'Electronica',70),(3,'Hidraulica',60);
/*!40000 ALTER TABLE `tb_especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_estado` (
  `idtb_estado` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idtb_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (1,'En Espera'),(2,'En Proceso'),(3,'Finalizada');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_marca`
--

DROP TABLE IF EXISTS `tb_marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_marca`
--

LOCK TABLES `tb_marca` WRITE;
/*!40000 ALTER TABLE `tb_marca` DISABLE KEYS */;
INSERT INTO `tb_marca` VALUES (1,'Caterpillar'),(2,'KOMATSU');
/*!40000 ALTER TABLE `tb_marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `nivel` char(3) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `action` varchar(45) DEFAULT NULL,
  `action2` varchar(100) DEFAULT NULL COMMENT 'Para menú dinámico Primefaces',
  `icono` varchar(45) DEFAULT NULL COMMENT 'Para menú dinámico Primefaces',
  `actionlistener` varchar(100) DEFAULT NULL COMMENT 'Para menú dinámico Primefaces',
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'1','Opciones','#','#',NULL,NULL),(2,'12','Solicitud de Servicio','solicitudes','#{solicitud.listarSoliccitudes}','ui-icon-star','#{menu.listSol}'),(3,'13','Orden de Trabajo','trabajos','#{formOrden.listarOrdenes}','ui-icon-star','#{menu.listOrd}'),(4,'14','Orden de Liquidacion','liquidaciones','#{formLiquidacion.listarLiquidaciones}','ui-icon-star','#{menu.listLiq}'),(5,'2','Tablas','#',NULL,NULL,NULL),(6,'21','Usuarios','usuarios','#{formUsuario.listarUsuarios}','ui-icon-person','#{menu.listUsu}'),(7,'22','Clientes','clientes','#{formCliente.listarClientes}','ui-icon-person','#{menu.listCli}'),(8,'11','Inicio','inicio','menuBlanco','ui-icon-home','#{menu.menuIni}'),(9,'23','Permisos','permisos','#{formPermiso.inicializar}','ui-icon-locked','#{menu.listPer}'),(10,'32','Cerrar Sesion','CerrarSession','#{login.CerrarSession}','ui-icon-close','#{menu.cerrarS}'),(11,'3','Sesion','#',NULL,NULL,NULL),(12,'31','Cambio de Contraseña','cambiaPwd','#{formUsuario.irAcambiarContraseña}','ui-icon-key','#{menu.cambioC}'),(13,'15','PreFactura','prefacturas','#{formPrefactura.listarPrefacturas}','ui-icon-star','#{menu.listPre}'),(14,'24','Paquetes','paquetes','#{formPaquete.listarPaquetes}',' ui-icon-folder-collapsed','#{menu.listPaq}'),(15,'4','Reportes','#',NULL,NULL,NULL),(16,'41','Reporte ','reportes','menuBlanco','ui-icon-document','#{menu.reporte}');
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_modelo`
--

DROP TABLE IF EXISTS `tb_modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_modelo` (
  `id_modelo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `tb_marca_id_marca` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_modelo`),
  KEY `fk_tb_modelo_tb_marca` (`tb_marca_id_marca`),
  CONSTRAINT `fk_tb_modelo_tb_marca` FOREIGN KEY (`tb_marca_id_marca`) REFERENCES `tb_marca` (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_modelo`
--

LOCK TABLES `tb_modelo` WRITE;
/*!40000 ALTER TABLE `tb_modelo` DISABLE KEYS */;
INSERT INTO `tb_modelo` VALUES (1,'416E',1),(2,'420E/420E IT',1),(3,'430E/430E IT',1),(4,'PC01-1',2),(5,'PC18MR-3',2),(6,'PC27MR-3',2);
/*!40000 ALTER TABLE `tb_modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ordenliquidacion`
--

DROP TABLE IF EXISTS `tb_ordenliquidacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_ordenliquidacion` (
  `id_liquidacion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `id_cliente` varchar(11) NOT NULL,
  `estado` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_liquidacion`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ordenliquidacion`
--

LOCK TABLES `tb_ordenliquidacion` WRITE;
/*!40000 ALTER TABLE `tb_ordenliquidacion` DISABLE KEYS */;
INSERT INTO `tb_ordenliquidacion` VALUES (-1,NULL,NULL,NULL,'9999999999',0),(2,'2010-07-01','Ricardo Barriga Palomino','admin','1111111111',1),(3,'2010-07-01','Ricardo Barriga Palomino','admin','1111111111',1),(4,'2010-07-01','Ricardo Barriga Palomino','admin','1111111111',0),(5,'2010-07-22','Ricardo Barriga Palomino','admin','12345654321',1),(6,'2010-07-30','Ricardo Barriga Palomino','admin','12345654321',1),(7,'2013-02-08','Ricardo Barriga Palomino','admin','1111111111',0),(8,'2020-07-19','Jose Toro Alcarraz','admin','1111111111',0),(9,'2020-07-19','Jose Toro Alcarraz','admin','1111111111',0),(10,'2020-07-31','Jose Toro Alcarraz','admin','1111111111',1),(11,'2020-07-31','Jose Toro Alcarraz','admin','1111111111',1),(12,'2020-07-31','Jose Toro Alcarraz','admin','1111111111',1),(13,'2020-07-31','Jose Toro Alcarraz','admin','12345654321',1),(14,'2020-08-01','Jose Toro Alcarraz','admin','12345654321',0);
/*!40000 ALTER TABLE `tb_ordenliquidacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ordentrabajo`
--

DROP TABLE IF EXISTS `tb_ordentrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_ordentrabajo` (
  `id_otrabajo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_termino` date DEFAULT NULL,
  `comentarios` varchar(200) DEFAULT NULL,
  `tb_solicitud_id_solicitud` int(11) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `id_oliquidacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_otrabajo`) USING BTREE,
  KEY `fk_tb_ordenTrabajo_tb_solicitud` (`tb_solicitud_id_solicitud`),
  KEY `FK_tb_ordentrabajo_2` (`id_oliquidacion`),
  CONSTRAINT `FK_tb_ordentrabajo_2` FOREIGN KEY (`id_oliquidacion`) REFERENCES `tb_ordenliquidacion` (`id_liquidacion`),
  CONSTRAINT `fk_tb_ordenTrabajo_tb_solicitud` FOREIGN KEY (`tb_solicitud_id_solicitud`) REFERENCES `tb_solicitud` (`id_solicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ordentrabajo`
--

LOCK TABLES `tb_ordentrabajo` WRITE;
/*!40000 ALTER TABLE `tb_ordentrabajo` DISABLE KEYS */;
INSERT INTO `tb_ordentrabajo` VALUES (1,'2010-01-01','2010-01-01','dsdsds',1,'admin',3),(2,'2010-06-02','2010-06-16','cdsfdfsdfds',2,'admin',3),(5,'2010-06-18','2010-06-24','dsfsfsf',4,'admin',4),(6,'2010-06-23','2010-06-23','ingreso de orden de trabajo',5,'admin',3),(9,'2010-06-23','2010-06-23','Prueba al 23 de junio',6,'admin',2),(10,'2010-06-23','2010-06-27','2da Prueba 23 de Junio',10,'admin',2),(11,'2010-06-24','2010-06-24','Ingreso de Orden de Trabajo edit',13,'admin',2),(12,'2010-07-22','2010-07-30','dsddsds',15,'admin',8),(13,'2010-07-22','2010-07-22','ksjhshdj',19,'admin',5),(14,'2010-07-29','2010-08-04','vfg',18,'admin',6),(17,'2010-07-30','2010-08-06','abc',17,'admin',6),(18,'2013-02-08','2013-04-08','Solucionar',26,'admin',7),(19,'2013-02-08','2013-04-08','Slucionar problema',27,'admin',8),(20,'2020-07-18','2020-07-19','comentario x',35,'admin',9),(21,'2020-07-19','2020-07-20','xxxx',20,'admin',13),(22,'2020-07-19','2020-07-22','xxx',29,'admin',10),(23,'2020-07-30','2020-07-31','xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx',44,'admin',11),(24,'2020-07-31','2020-08-01','Orden de trabajo registrada.',42,'admin',11),(25,'2020-07-31','2020-08-01','Orden de trabajo xxxx',36,'admin',12),(26,'2020-07-31','2020-08-01','xxxxxxxx',22,'admin',12),(27,'2020-07-31','2020-08-01','xxxx',41,'admin',12),(28,'2020-07-31','2020-08-01','xxxx',40,'admin',-1),(29,'2020-08-02','2020-08-03','xxx',39,'admin',-1),(30,'2020-08-01','2020-09-01','...',45,'admin',14);
/*!40000 ALTER TABLE `tb_ordentrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ordentrabajo_has_tb_tecnicos`
--

DROP TABLE IF EXISTS `tb_ordentrabajo_has_tb_tecnicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_ordentrabajo_has_tb_tecnicos` (
  `tb_ordenTrabajo_id_otrabajo` int(11) NOT NULL,
  `tb_tecnicos_id_tecnicos` int(11) NOT NULL,
  `dias` int(11) DEFAULT NULL,
  PRIMARY KEY (`tb_ordenTrabajo_id_otrabajo`,`tb_tecnicos_id_tecnicos`),
  KEY `fk_tb_ordenTrabajo_has_tb_tecnicos_tb_ordenTrabajo` (`tb_ordenTrabajo_id_otrabajo`),
  KEY `fk_tb_ordenTrabajo_has_tb_tecnicos_tb_tecnicos` (`tb_tecnicos_id_tecnicos`),
  CONSTRAINT `fk_tb_ordenTrabajo_has_tb_tecnicos_tb_ordenTrabajo` FOREIGN KEY (`tb_ordenTrabajo_id_otrabajo`) REFERENCES `tb_ordentrabajo` (`id_otrabajo`),
  CONSTRAINT `fk_tb_ordenTrabajo_has_tb_tecnicos_tb_tecnicos` FOREIGN KEY (`tb_tecnicos_id_tecnicos`) REFERENCES `tb_tecnicos` (`id_tecnicos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ordentrabajo_has_tb_tecnicos`
--

LOCK TABLES `tb_ordentrabajo_has_tb_tecnicos` WRITE;
/*!40000 ALTER TABLE `tb_ordentrabajo_has_tb_tecnicos` DISABLE KEYS */;
INSERT INTO `tb_ordentrabajo_has_tb_tecnicos` VALUES (6,1,2),(6,2,3),(9,3,3),(10,1,1),(11,1,4),(12,1,8),(13,1,0),(14,1,6),(17,1,7),(17,3,7),(18,1,59),(19,1,59),(20,1,1),(20,2,1),(21,1,1),(22,1,3),(23,1,1),(24,1,1),(26,1,1),(26,2,1),(27,1,1),(28,1,1),(29,1,1),(30,1,31);
/*!40000 ALTER TABLE `tb_ordentrabajo_has_tb_tecnicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetes`
--

DROP TABLE IF EXISTS `tb_paquetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetes` (
  `id_paquetes` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id_paquetes`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetes`
--

LOCK TABLES `tb_paquetes` WRITE;
/*!40000 ALTER TABLE `tb_paquetes` DISABLE KEYS */;
INSERT INTO `tb_paquetes` VALUES (1,'Paquete 01',4,'1','2',100),(2,'Paquete 02',5,'1','3',300),(4,'Paquete 04',5,'1','3',165),(6,'Paquete 05',4,'2','4',130),(7,'Paquete 6',6,'1','2',205),(8,'eess',4,'1','1',210),(17,'Bicedo',10,'1','1',80),(18,'Paquete de prueba',2,'2','4',160);
/*!40000 ALTER TABLE `tb_paquetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetes_has_tb_ordentrabajo`
--

DROP TABLE IF EXISTS `tb_paquetes_has_tb_ordentrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetes_has_tb_ordentrabajo` (
  `tb_paquetes_id_paquetes` int(11) NOT NULL,
  `tb_ordenTrabajo_id_otrabajo` int(11) NOT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`tb_paquetes_id_paquetes`,`tb_ordenTrabajo_id_otrabajo`),
  KEY `fk_tb_paquetes_has_tb_ordenTrabajo_tb_paquetes` (`tb_paquetes_id_paquetes`),
  KEY `fk_tb_paquetes_has_tb_ordenTrabajo_tb_ordenTrabajo` (`tb_ordenTrabajo_id_otrabajo`),
  CONSTRAINT `fk_tb_paquetes_has_tb_ordenTrabajo_tb_ordenTrabajo` FOREIGN KEY (`tb_ordenTrabajo_id_otrabajo`) REFERENCES `tb_ordentrabajo` (`id_otrabajo`),
  CONSTRAINT `fk_tb_paquetes_has_tb_ordenTrabajo_tb_paquetes` FOREIGN KEY (`tb_paquetes_id_paquetes`) REFERENCES `tb_paquetes` (`id_paquetes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetes_has_tb_ordentrabajo`
--

LOCK TABLES `tb_paquetes_has_tb_ordentrabajo` WRITE;
/*!40000 ALTER TABLE `tb_paquetes_has_tb_ordentrabajo` DISABLE KEYS */;
INSERT INTO `tb_paquetes_has_tb_ordentrabajo` VALUES (1,6,100),(1,11,100),(1,13,100),(1,14,100),(1,17,100),(1,18,100),(1,19,100),(1,20,100),(1,22,100),(1,23,100),(1,24,100),(1,26,100),(1,27,100),(1,28,100),(1,29,100),(1,30,100),(2,9,300),(2,10,300),(2,11,300),(2,19,300),(2,20,300),(2,26,300),(4,14,165),(4,17,165),(6,23,130),(7,12,205),(8,14,210),(8,17,210),(8,21,210);
/*!40000 ALTER TABLE `tb_paquetes_has_tb_ordentrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetes_has_tb_paquetesactividades`
--

DROP TABLE IF EXISTS `tb_paquetes_has_tb_paquetesactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetes_has_tb_paquetesactividades` (
  `tb_paquetes_id_paquetes` int(11) NOT NULL,
  `tb_paquetesActividades_id_actividades` int(11) NOT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`tb_paquetes_id_paquetes`,`tb_paquetesActividades_id_actividades`),
  KEY `fk_tb_paquetes_has_tb_paquetesActividades_tb_paquetes1` (`tb_paquetes_id_paquetes`),
  KEY `fk_tb_paquetes_has_tb_paquetesActividades_tb_paquetesActivida1` (`tb_paquetesActividades_id_actividades`),
  CONSTRAINT `fk_tb_paquetes_has_tb_paquetesActividades_tb_paquetes1` FOREIGN KEY (`tb_paquetes_id_paquetes`) REFERENCES `tb_paquetes` (`id_paquetes`),
  CONSTRAINT `fk_tb_paquetes_has_tb_paquetesActividades_tb_paquetesActivida1` FOREIGN KEY (`tb_paquetesActividades_id_actividades`) REFERENCES `tb_paquetesactividades` (`id_actividades`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetes_has_tb_paquetesactividades`
--

LOCK TABLES `tb_paquetes_has_tb_paquetesactividades` WRITE;
/*!40000 ALTER TABLE `tb_paquetes_has_tb_paquetesactividades` DISABLE KEYS */;
INSERT INTO `tb_paquetes_has_tb_paquetesactividades` VALUES (6,2,90),(17,1,50),(18,3,120);
/*!40000 ALTER TABLE `tb_paquetes_has_tb_paquetesactividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetes_has_tb_paquetesherramientas`
--

DROP TABLE IF EXISTS `tb_paquetes_has_tb_paquetesherramientas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetes_has_tb_paquetesherramientas` (
  `tb_paquetes_id_paquetes` int(11) NOT NULL,
  `tb_paquetesHerramientas_id_herramientas` int(11) NOT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`tb_paquetes_id_paquetes`,`tb_paquetesHerramientas_id_herramientas`),
  KEY `fk_tb_paquetes_has_tb_paquetesHerramientas_tb_paquetes1` (`tb_paquetes_id_paquetes`),
  KEY `fk_tb_paquetes_has_tb_paquetesHerramientas_tb_paquetesHerrami1` (`tb_paquetesHerramientas_id_herramientas`),
  CONSTRAINT `fk_tb_paquetes_has_tb_paquetesHerramientas_tb_paquetes1` FOREIGN KEY (`tb_paquetes_id_paquetes`) REFERENCES `tb_paquetes` (`id_paquetes`),
  CONSTRAINT `fk_tb_paquetes_has_tb_paquetesHerramientas_tb_paquetesHerrami1` FOREIGN KEY (`tb_paquetesHerramientas_id_herramientas`) REFERENCES `tb_paquetesherramientas` (`id_herramientas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetes_has_tb_paquetesherramientas`
--

LOCK TABLES `tb_paquetes_has_tb_paquetesherramientas` WRITE;
/*!40000 ALTER TABLE `tb_paquetes_has_tb_paquetesherramientas` DISABLE KEYS */;
INSERT INTO `tb_paquetes_has_tb_paquetesherramientas` VALUES (6,1,20),(17,1,20),(18,1,20);
/*!40000 ALTER TABLE `tb_paquetes_has_tb_paquetesherramientas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetes_has_tb_paquetesmateriales`
--

DROP TABLE IF EXISTS `tb_paquetes_has_tb_paquetesmateriales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetes_has_tb_paquetesmateriales` (
  `tb_paquetes_id_paquetes` int(11) NOT NULL,
  `tb_paquetesMateriales_id_materiales` int(11) NOT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`tb_paquetes_id_paquetes`,`tb_paquetesMateriales_id_materiales`),
  KEY `fk_tb_paquetes_has_tb_paquetesMateriales_tb_paquetes1` (`tb_paquetes_id_paquetes`),
  KEY `fk_tb_paquetes_has_tb_paquetesMateriales_tb_paquetesMateriales1` (`tb_paquetesMateriales_id_materiales`),
  CONSTRAINT `fk_tb_paquetes_has_tb_paquetesMateriales_tb_paquetes1` FOREIGN KEY (`tb_paquetes_id_paquetes`) REFERENCES `tb_paquetes` (`id_paquetes`),
  CONSTRAINT `fk_tb_paquetes_has_tb_paquetesMateriales_tb_paquetesMateriales1` FOREIGN KEY (`tb_paquetesMateriales_id_materiales`) REFERENCES `tb_paquetesmateriales` (`id_materiales`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetes_has_tb_paquetesmateriales`
--

LOCK TABLES `tb_paquetes_has_tb_paquetesmateriales` WRITE;
/*!40000 ALTER TABLE `tb_paquetes_has_tb_paquetesmateriales` DISABLE KEYS */;
INSERT INTO `tb_paquetes_has_tb_paquetesmateriales` VALUES (6,2,20),(17,1,10),(18,2,20);
/*!40000 ALTER TABLE `tb_paquetes_has_tb_paquetesmateriales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetesactividades`
--

DROP TABLE IF EXISTS `tb_paquetesactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetesactividades` (
  `id_actividades` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id_actividades`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetesactividades`
--

LOCK TABLES `tb_paquetesactividades` WRITE;
/*!40000 ALTER TABLE `tb_paquetesactividades` DISABLE KEYS */;
INSERT INTO `tb_paquetesactividades` VALUES (1,'Actividad 1',50),(2,'Actividad 2',90),(3,'Actividad 3',120);
/*!40000 ALTER TABLE `tb_paquetesactividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetesherramientas`
--

DROP TABLE IF EXISTS `tb_paquetesherramientas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetesherramientas` (
  `id_herramientas` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id_herramientas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetesherramientas`
--

LOCK TABLES `tb_paquetesherramientas` WRITE;
/*!40000 ALTER TABLE `tb_paquetesherramientas` DISABLE KEYS */;
INSERT INTO `tb_paquetesherramientas` VALUES (1,'Herramienta 1',20),(2,'Herramienta 2',30),(3,'Herramienta 3',25),(4,'Herramienta 4 ',15);
/*!40000 ALTER TABLE `tb_paquetesherramientas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_paquetesmateriales`
--

DROP TABLE IF EXISTS `tb_paquetesmateriales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_paquetesmateriales` (
  `id_materiales` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id_materiales`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_paquetesmateriales`
--

LOCK TABLES `tb_paquetesmateriales` WRITE;
/*!40000 ALTER TABLE `tb_paquetesmateriales` DISABLE KEYS */;
INSERT INTO `tb_paquetesmateriales` VALUES (1,'Material 1',10),(2,'Material 2',20),(3,'Material 3',15);
/*!40000 ALTER TABLE `tb_paquetesmateriales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_prefactura`
--

DROP TABLE IF EXISTS `tb_prefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_prefactura` (
  `id_prefactura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `tb_ordenLiquidacion_id_liquidacion` int(11) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `cliente` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `RUC` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_prefactura`),
  KEY `fk_tb_prefactura_tb_ordenLiquidacion1` (`tb_ordenLiquidacion_id_liquidacion`),
  CONSTRAINT `fk_tb_prefactura_tb_ordenLiquidacion1` FOREIGN KEY (`tb_ordenLiquidacion_id_liquidacion`) REFERENCES `tb_ordenliquidacion` (`id_liquidacion`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_prefactura`
--

LOCK TABLES `tb_prefactura` WRITE;
/*!40000 ALTER TABLE `tb_prefactura` DISABLE KEYS */;
INSERT INTO `tb_prefactura` VALUES (6,'2010-07-11',2,'admin','Empresa S.A.','abc 1234','1111111111'),(7,'2010-07-11',3,'admin','Empresa S.A.','abc 1234','1111111111'),(8,'2010-07-22',5,'admin','Empresa 2 SAC','Av Salaverry 1123','12345654321'),(9,'2010-07-30',6,'admin','Empresa 2 SAC','Av Salaverry 1123','12345654321'),(10,'2020-07-31',10,'admin','Empresa Demo S.A.','Av. Garcilaso de la Vega 339','1111111111'),(11,'2020-07-31',11,'admin','Empresa Demo S.A.','Av. Garcilaso de la Vega 339','1111111111'),(12,'2020-07-31',12,'admin','Empresa Demo S.A.','Av. Garcilaso de la Vega 339','1111111111'),(13,'2020-08-01',13,'admin','Empresa 2 SAC','Av Salaverry 1123','12345654321');
/*!40000 ALTER TABLE `tb_prefactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_solicitud`
--

DROP TABLE IF EXISTS `tb_solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_solicitud` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `des_problema` varchar(300) DEFAULT NULL,
  `Representante` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `horometro_actual` int(11) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  `tb_equipo_nrotarjeta` varchar(11) DEFAULT NULL,
  `telefono` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id_solicitud`),
  KEY `fk_tb_solicitud_tb_equipo` (`tb_equipo_nrotarjeta`),
  CONSTRAINT `fk_tb_solicitud_tb_equipo` FOREIGN KEY (`tb_equipo_nrotarjeta`) REFERENCES `tb_equipo` (`nrotarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_solicitud`
--

LOCK TABLES `tb_solicitud` WRITE;
/*!40000 ALTER TABLE `tb_solicitud` DISABLE KEYS */;
INSERT INTO `tb_solicitud` VALUES (1,'Motor fundido','Juan Perez','2010-06-16',1111,'2','111111111','3456777'),(2,'Motor fundido','Juan Perez','2010-06-16',34334,'2','111111111',''),(4,'Motor fundido','Juan Perez','2010-06-17',343322,'2','111111111',''),(5,'Motor fundido','Juan Perez','2010-06-17',341,'2','111111111',''),(6,'Motor fundido','Juan Perez','2010-06-17',33432,'2','111111111',''),(10,'Motor fundido','Juan Perez','2010-06-23',0,'2','111111111',''),(13,'Falla de frenos','Juan Perez','2010-06-24',12000,'2','111111111','23234444'),(15,'Falla de frenos','Juan Perez','2010-07-01',2,'2','111111111','1234'),(17,'Falló el sistema eléctrico','Pedro Quispe','2010-07-22',2343,'2','111111112','9887322'),(18,'Falló el sistema Hidraulico','Pedro Quispe','2010-07-20',213333,'2','111111112','7366882'),(19,'Motor fundido','Juan','2010-07-14',626377,'2','111111112','387811'),(20,'Motor fundido','Manuel Quispe','2013-02-01',0,'3','111111112','3212344'),(22,'Motor fundido','Carlos Soto','2013-02-04',1,'3','111111111','1234567'),(25,'Motor malogrado','Alex Soto','2013-02-05',0,'1','111111111','2123455'),(26,'problemas con el aceite','manuel miranda','2013-02-08',0,'2','111111111','2344455'),(27,'Motor en mal estado.','Carlos huamani','2013-02-08',1239,'2','111111111','234344'),(29,'xxx','koko','2020-07-17',12,'3','111111111','3214567'),(35,'ASASASASAS','jOSE','2020-07-18',10,'2','111111111','3333333'),(36,'problema','josel','2020-07-28',1,'3','111111111','993626712'),(37,'Hubo un problema con el motor, este se malogró','Elena Carrillo','2020-07-28',10,'1','111111112','3698521'),(38,'xxx','xxx','2020-07-29',1,'1','111111111','993626712'),(39,'xc','x','2020-07-29',1,'2','111111111','1'),(40,'xx','xx','2020-07-29',1,'2','111111111','993626712'),(41,'123','Maria','2020-07-29',1,'3','111111111','123'),(42,'1','1','2020-07-29',1,'3','111111111','1'),(44,'Motor fundido','María','2020-07-29',11,'3','111111111','1234567'),(45,'Cambio de motor','Mario Vargas','2020-08-01',10,'2','111111112','3698521');
/*!40000 ALTER TABLE `tb_solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_solicitud_has_tb_estado`
--

DROP TABLE IF EXISTS `tb_solicitud_has_tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_solicitud_has_tb_estado` (
  `tb_solicitud_id_solicitud` int(11) NOT NULL,
  `tb_estado_idtb_estado` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tb_solicitud_id_solicitud`,`tb_estado_idtb_estado`),
  KEY `fk_tb_solicitud_has_tb_estado_tb_solicitud1` (`tb_solicitud_id_solicitud`),
  KEY `fk_tb_solicitud_has_tb_estado_tb_estado1` (`tb_estado_idtb_estado`),
  CONSTRAINT `fk_tb_solicitud_has_tb_estado_tb_estado1` FOREIGN KEY (`tb_estado_idtb_estado`) REFERENCES `tb_estado` (`idtb_estado`),
  CONSTRAINT `fk_tb_solicitud_has_tb_estado_tb_solicitud1` FOREIGN KEY (`tb_solicitud_id_solicitud`) REFERENCES `tb_solicitud` (`id_solicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_solicitud_has_tb_estado`
--

LOCK TABLES `tb_solicitud_has_tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_solicitud_has_tb_estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_solicitud_has_tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tecnicos`
--

DROP TABLE IF EXISTS `tb_tecnicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_tecnicos` (
  `id_tecnicos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `ape_pat` varchar(45) DEFAULT NULL,
  `ape_mat` varchar(45) DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `disponible` char(1) DEFAULT NULL,
  `tb_especialidades_id_especialidad` int(11) DEFAULT NULL,
  `supervisor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_tecnicos`),
  KEY `fk_tb_tecnicos_tb_especialidades` (`tb_especialidades_id_especialidad`),
  KEY `fk_tb_tecnicos_tb_tecnicos` (`supervisor`),
  CONSTRAINT `fk_tb_tecnicos_tb_especialidades` FOREIGN KEY (`tb_especialidades_id_especialidad`) REFERENCES `tb_especialidades` (`id_especialidad`),
  CONSTRAINT `fk_tb_tecnicos_tb_tecnicos` FOREIGN KEY (`supervisor`) REFERENCES `tb_tecnicos` (`id_tecnicos`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tecnicos`
--

LOCK TABLES `tb_tecnicos` WRITE;
/*!40000 ALTER TABLE `tb_tecnicos` DISABLE KEYS */;
INSERT INTO `tb_tecnicos` VALUES (1,'Jhon ','Vasquez','Gonzales','2009-01-01','S',1,NULL),(2,'Michael ','Mendoza','Huamani','2009-01-01','S',2,NULL),(3,'Miguel','López','Alarcón','2009-01-01','S',3,NULL),(4,'Luis','Soto','Perales','2009-01-01','S',1,NULL),(5,'Mario','Rios','Vicente','2009-01-01','S',1,NULL),(6,'María','Mendoza','Amao','2009-01-01','S',2,NULL),(7,'Carla','Moreno','Romero','2009-01-01','N',2,NULL);
/*!40000 ALTER TABLE `tb_tecnicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `ape_pat` varchar(45) DEFAULT NULL,
  `ape_mat` varchar(45) DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `login` varchar(20) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `tb_area_id_area` int(11) DEFAULT NULL,
  `estado` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_usuario`),
  KEY `fk_tb_usuarios_tb_area` (`tb_area_id_area`),
  CONSTRAINT `fk_tb_usuarios_tb_area` FOREIGN KEY (`tb_area_id_area`) REFERENCES `tb_area` (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'Jose','Toro','Alcarraz','2010-01-01','admin','21232f297a57a5a743894a0e4a801fc3',4,0),(2,'Miguel','Flores','Altamirano','2010-02-02','mflores','143d42165dfaa0e4870b787d8d0cb125',2,0),(7,'Pedro','Ramos','Amao','2010-07-22','pramos','aadefb22a8261e73dba4214e64145b3d',2,1),(8,'Jhon','Loma','Perez','2010-01-19','jloma','fa95d4336482aa41dd6c6be4625bd64f',1,1),(22,'Mércia','Lima','Alburquerque','2013-07-24','mlima','82e07134a5c62681169510f92d91fd64',1,0),(23,'Gabriel','Miranda','Huertas','2013-07-24','gmiranda','a3db3d520aef57e1900251c62f4d5278',3,0),(24,'Gabriela','Farencena','Alcarraz','2020-07-24','gfarencena','e60497acfe2b4039cf7ee836cfd50308',2,1),(25,'Nestor','Toro','Alcarraz','2020-07-25','ntoro','d9fb85ca93530aa31c30da380b962e69',4,1),(26,'Gianfranco','Alcarraz','Huamán','2020-07-26','gfranco','67e6642b6dc20ce420bcff846553ae66',1,0),(27,'Roli','Artun','Soto','2020-07-26','roli','7c4225842469936a8050972de7e93972',2,0),(28,'Tatiana','Rojas','Huertas','2020-07-26','trojas','26dbbef5e13ee259b965556a5fb9119a',3,0);
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-02 15:25:26
