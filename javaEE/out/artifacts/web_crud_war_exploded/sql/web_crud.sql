/*
SQLyog Ultimate v8.32 
MySQL - 5.5.27 : Database - web_crud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`web_crud` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `web_crud`;

/*Table structure for table `t_orders` */

DROP TABLE IF EXISTS `t_orders`;

CREATE TABLE `t_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordernum` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ordername` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `orderprices` double DEFAULT NULL,
  `ordercount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_orders` */

insert  into `t_orders`(`id`,`ordernum`,`ordername`,`orderprices`,`ordercount`) values (3,'Rng','12',1,1),(5,'34','34.0',34,0),(6,'34','34.0',34,0),(7,'1','1',1,1);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`) values (1,'admin','admin'),(2,'tom','tom');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
