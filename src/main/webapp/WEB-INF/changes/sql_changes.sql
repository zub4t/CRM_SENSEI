
SET SQL_SAFE_UPDATES = 0;




-- --------------------------------------------------------
-- Anfitrião:                    127.0.0.1
-- Versão do servidor:           5.7.28-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Versão:              10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for crm
CREATE DATABASE IF NOT EXISTS `crm` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `crm`;

-- Dumping structure for table crm.assingment
CREATE TABLE IF NOT EXISTS `assingment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dsc` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table crm.assingment: ~2 rows (approximately)
DELETE FROM `assingment`;
/*!40000 ALTER TABLE `assingment` DISABLE KEYS */;
INSERT INTO `assingment` (`id`, `dsc`) VALUES
	(1, 'Levantamento 3D'),
	(2, 'Venda ');
/*!40000 ALTER TABLE `assingment` ENABLE KEYS */;

-- Dumping structure for table crm.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nme` varchar(255) NOT NULL,
  `tel` int(11) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table crm.employee: ~2 rows (approximately)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `nme`, `tel`, `email`, `salary`) VALUES
	(1, 'marco primo', 913648628, 'marcoaraujo96@gmail.com', 50.00),
	(2, 'pedro ferreirinha', 939668581, 'pedrompf99@gmail.com', 200.00);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table crm.main_menu
CREATE TABLE IF NOT EXISTS `main_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nme` varchar(255) NOT NULL,
  `lvl` int(3) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `main_menu_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `main_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table crm.main_menu: ~8 rows (approximately)
DELETE FROM `main_menu`;
/*!40000 ALTER TABLE `main_menu` DISABLE KEYS */;
INSERT INTO `main_menu` (`id`, `nme`, `lvl`, `parent_id`, `url`) VALUES
	(1, 'Gestão', 0, NULL, NULL),
	(2, 'funcionários ', 1, 1, '/management/employee/employee_psq.jsp'),
	(3, 'projetos', 1, 1, '/management/project/project_psq.jsp'),
	(11, 'intervenções', 0, NULL, NULL),
	(13, 'tarefas', 1, 1, '/management/assingment/assingment_psq.jsp'),
	(14, 'adicionar intervenções', 1, 11, '/interventions/interventions_psq.jsp'),
	(15, 'Relatorios', 0, NULL, NULL),
	(16, 'Rpt1', 1, 15, '/Rpt1');
/*!40000 ALTER TABLE `main_menu` ENABLE KEYS */;

-- Dumping structure for table crm.project
CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `n_process` varchar(50) DEFAULT NULL,
  `customer_nme` varchar(255) DEFAULT NULL,
  `expected_sale` decimal(10,2) DEFAULT NULL,
  `effective_sale` decimal(10,2) DEFAULT NULL,
  `effective_purchase` decimal(10,2) DEFAULT NULL,
  `honorary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table crm.project: ~1 rows (approximately)
DELETE FROM `project`;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`id`, `n_process`, `customer_nme`, `expected_sale`, `effective_sale`, `effective_purchase`, `honorary`) VALUES
	(1, '1025/22', 'Pedro', 120000.00, 125000.00, 50000.00, 3000.00);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;

-- Dumping structure for table crm.project_employee
CREATE TABLE IF NOT EXISTS `project_employee` (
  `project_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `assingment_id` int(11) NOT NULL,
  `spend_time` time DEFAULT NULL,
  `dsc` varchar(500) DEFAULT NULL,
  `dte` date DEFAULT NULL,
  KEY `project_id` (`project_id`),
  KEY `employee_id` (`employee_id`),
  KEY `assingment_id` (`assingment_id`),
  CONSTRAINT `project_employee_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_employee_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `project_employee_ibfk_3` FOREIGN KEY (`assingment_id`) REFERENCES `assingment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table crm.project_employee: ~2 rows (approximately)
DELETE FROM `project_employee`;
/*!40000 ALTER TABLE `project_employee` DISABLE KEYS */;
INSERT INTO `project_employee` (`project_id`, `employee_id`, `assingment_id`, `spend_time`, `dsc`, `dte`) VALUES
	(1, 2, 1, '22:40:00', 'teste e', '2020-11-30'),
	(1, 2, 2, '20:37:00', '20 horas O. O\r\n                    ', '2020-11-30');
/*!40000 ALTER TABLE `project_employee` ENABLE KEYS */;

-- Dumping structure for table crm.usr
CREATE TABLE IF NOT EXISTS `usr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usrnme` varchar(255) NOT NULL,
  `pass` varchar(150) DEFAULT NULL,
  KEY `id` (`id`),
  CONSTRAINT `usr_ibfk_1` FOREIGN KEY (`id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table crm.usr: ~2 rows (approximately)
DELETE FROM `usr`;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` (`id`, `usrnme`, `pass`) VALUES
	(1, 'sushll', 'admin'),
	(2, 'pedro', '21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;






drop table project_employee;

CREATE TABLE `project_employee` (
	id int not null auto_increment primary key,
  `project_id` int NOT NULL,
  `employee_id` int NOT NULL,
  `assingment_id` int NOT NULL,
  `spend_time` time DEFAULT NULL,
  `dsc` varchar(500) DEFAULT NULL,
  `dte` date DEFAULT NULL,
  KEY `project_id` (`project_id`),
  KEY `employee_id` (`employee_id`),
  KEY `assingment_id` (`assingment_id`),
  CONSTRAINT `project_employee_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_employee_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `project_employee_ibfk_3` FOREIGN KEY (`assingment_id`) REFERENCES `assingment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


UPDATE `crm`.`main_menu` SET `nme` = 'adicionar' WHERE (`id` = '14');

INSERT INTO `crm`.`main_menu` (`id`, `nme`, `lvl`, `parent_id`) VALUES ('17', 'menus', '1', '1');

ALTER TABLE `main_menu`
	ADD COLUMN `user_level` INT(3) NULL AFTER `url`;


UPDATE `crm`.`main_menu` SET `url`='/management/gestMenu/gestMenu_psq.jsp' WHERE  `id`=17;

ALTER TABLE `usr`
	CHANGE COLUMN `level` `level` INT(3) NOT NULL DEFAULT '0' AFTER `pass`;