/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.33 : Database - bagevent_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bagevent_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bagevent_test`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `cellphone` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `salt` char(50) DEFAULT NULL COMMENT '加盐值',
  `state` bit(1) DEFAULT NULL COMMENT '状态0,1',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`email`,`cellphone`,`password`,`salt`,`state`,`create_time`) values (1,'qqq','jesse971223@gmail.com','18252039917','1dc568b64c0f67e7a86c89a12fa5bd5f','1dc568b64c0f67e7a86c89a12fa5bd5f','','2020-05-19 00:00:00'),(2,'aaa','18252039917@163.com','18252039916','1dc568b64c0f67e7a86c89a12fa5bd5f','1dc568b64c0f67e7a86c89a12fa5bd5f','','2020-05-19 00:00:00'),(3,'bbb','jesse971223@gmail.com','18252039919','1dc568b64c0f67e7a86c89a12fa5bd5f','1dc568b64c0f67e7a86c89a12fa5bd5f','','2020-05-19 00:00:00'),(7,'111','10849052@qq.com','18061241826','efd4ca0033a6c175f075ceed67f1e4b9','efd4ca0033a6c175f075ceed67f1e4b9','','2020-05-19 00:00:00'),(8,'222','10849052@qq.com','18252039918','eab8ceb14df4ffb950551ed66b578137','eab8ceb14df4ffb950551ed66b578137','','2020-05-19 15:10:35'),(9,'sssssss','ghhjgjh@ghg.com','3754858996','1dc568b64c0f67e7a86c89a12fa5bd5f','1dc568b64c0f67e7a86c89a12fa5bd5f','','2020-05-19 20:35:36'),(10,'qqq12','10849052@qq.com','12345678765','1dc568b64c0f67e7a86c89a12fa5bd5f','1dc568b64c0f67e7a86c89a12fa5bd5f','','2020-05-19 21:38:52');

/*Table structure for table `userloginlog` */

DROP TABLE IF EXISTS `userloginlog`;

CREATE TABLE `userloginlog` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `login_ip` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  KEY `fk_user` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4;

/*Data for the table `userloginlog` */

insert  into `userloginlog`(`login_id`,`user_id`,`login_time`,`login_ip`) values (1,1,'2020-05-19 16:25:42','0:0:0:0:0:0:0:1'),(37,1,'2020-05-19 19:12:05','0:0:0:0:0:0:0:1'),(38,1,'2020-05-19 19:12:42','0:0:0:0:0:0:0:1'),(39,1,'2020-05-19 19:18:03','0:0:0:0:0:0:0:1'),(40,1,'2020-05-19 19:21:39','127.0.0.1'),(41,1,'2020-05-19 19:24:23','0:0:0:0:0:0:0:1'),(42,1,'2020-05-19 19:25:33','127.0.0.1'),(43,1,'2020-05-19 19:28:06','0:0:0:0:0:0:0:1'),(44,1,'2020-05-19 19:31:00','0:0:0:0:0:0:0:1'),(45,1,'2020-05-19 19:33:58','0:0:0:0:0:0:0:1'),(46,1,'2020-05-19 19:40:37','0:0:0:0:0:0:0:1'),(47,1,'2020-05-19 19:41:42','0:0:0:0:0:0:0:1'),(48,1,'2020-05-19 19:46:42','0:0:0:0:0:0:0:1'),(49,1,'2020-05-19 19:47:30','0:0:0:0:0:0:0:1'),(50,1,'2020-05-19 19:48:44','0:0:0:0:0:0:0:1'),(51,1,'2020-05-19 19:49:27','127.0.0.1'),(52,1,'2020-05-19 19:59:03','0:0:0:0:0:0:0:1'),(53,1,'2020-05-19 20:00:02','0:0:0:0:0:0:0:1'),(54,1,'2020-05-19 20:02:26','0:0:0:0:0:0:0:1'),(55,1,'2020-05-19 20:04:16','127.0.0.1'),(56,1,'2020-05-19 20:05:33','0:0:0:0:0:0:0:1'),(57,1,'2020-05-19 20:11:05','0:0:0:0:0:0:0:1'),(58,1,'2020-05-19 20:16:40','0:0:0:0:0:0:0:1'),(59,1,'2020-05-19 20:17:41','0:0:0:0:0:0:0:1'),(60,9,'2020-05-19 20:35:43','127.0.0.1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
