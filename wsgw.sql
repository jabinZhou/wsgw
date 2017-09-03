/*
SQLyog Ultimate v8.32 
MySQL - 5.6.21-log : Database - wsgw
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wsgw` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wsgw`;

/*Table structure for table `advertise` */

DROP TABLE IF EXISTS `advertise`;

CREATE TABLE `advertise` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `title` varchar(60) NOT NULL COMMENT '标题',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `advertise_ category _id` bigint(11) NOT NULL COMMENT '分类id',
  `url` varchar(255) NOT NULL COMMENT '地址',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `advertise` */

/*Table structure for table `advertise_category` */

DROP TABLE IF EXISTS `advertise_category`;

CREATE TABLE `advertise_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `parent_id` bigint(11) NOT NULL COMMENT '父类id',
  `parent_ids` varchar(255) NOT NULL COMMENT '父类ids',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `advertise_category` */

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `title` varchar(60) NOT NULL COMMENT '标题',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `banner_category_id` bigint(11) NOT NULL COMMENT '分类id',
  `url` varchar(255) NOT NULL COMMENT '地址',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `banner` */

/*Table structure for table `banner_category` */

DROP TABLE IF EXISTS `banner_category`;

CREATE TABLE `banner_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `parent_id` bigint(11) NOT NULL COMMENT '父类id',
  `parent_ids` varchar(255) NOT NULL COMMENT '父类ids',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `banner_category` */

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`province_id`,`city_name`,`description`) values (1,1,'温岭市','BYSocket 的家在温岭。');

/*Table structure for table `dict` */

DROP TABLE IF EXISTS `dict`;

CREATE TABLE `dict` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `name` varchar(30) NOT NULL COMMENT '字典显示名称',
  `value` varchar(30) NOT NULL COMMENT '字典的value',
  `key_type` varchar(30) NOT NULL COMMENT '字典的key',
  `sort` bigint(11) NOT NULL COMMENT '字典的排序',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dict` */

/*Table structure for table `follow` */

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `good_detail_id` bigint(11) DEFAULT NULL COMMENT '商品详情id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `follow` */

/*Table structure for table `good` */

DROP TABLE IF EXISTS `good`;

CREATE TABLE `good` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品Id主键',
  `title` varchar(60) NOT NULL COMMENT '商品标题',
  `name` varchar(30) NOT NULL COMMENT '商品名称',
  `good_category_type` bigint(11) NOT NULL COMMENT '商品分类',
  `good_image` varchar(255) NOT NULL COMMENT '商品缩略图',
  `status` varchar(2) NOT NULL COMMENT '商品状态',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `good` */

/*Table structure for table `good_activity` */

DROP TABLE IF EXISTS `good_activity`;

CREATE TABLE `good_activity` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品活动Id主键',
  `good_id` bigint(11) NOT NULL COMMENT '商品id',
  `activity_title` varchar(60) NOT NULL COMMENT '活动标题',
  `activity_price` decimal(21,0) NOT NULL COMMENT '商品活动价格',
  `activity_begin_date` datetime NOT NULL COMMENT '活动开始时间',
  `activity_end_date` datetime NOT NULL COMMENT '活动结束时间',
  `activity_status` varchar(2) NOT NULL COMMENT '商品活动状态',
  `activity_flag` varchar(1) DEFAULT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `good_activity` */

/*Table structure for table `good_activity_category` */

DROP TABLE IF EXISTS `good_activity_category`;

CREATE TABLE `good_activity_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `parent_id` bigint(11) NOT NULL COMMENT '父类id',
  `parent_ids` varchar(255) NOT NULL COMMENT '父类ids',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `good_activity_category` */

/*Table structure for table `good_category` */

DROP TABLE IF EXISTS `good_category`;

CREATE TABLE `good_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `parent_id` bigint(11) NOT NULL COMMENT '父类id',
  `parent_ids` varchar(255) NOT NULL COMMENT '父类ids',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `good_category` */

/*Table structure for table `good_detail` */

DROP TABLE IF EXISTS `good_detail`;

CREATE TABLE `good_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '商品详情Id主键',
  `good_id` bigint(11) NOT NULL COMMENT '商品id',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `good_images` varchar(1000) NOT NULL COMMENT '商品多图',
  `good_activity_id` bigint(11) DEFAULT NULL COMMENT '商品活动id',
  `good_detail` varchar(255) DEFAULT NULL COMMENT '商品详情图',
  `good_tag_price` decimal(21,0) NOT NULL COMMENT '商品标签价格',
  `good_market_price` decimal(21,0) NOT NULL COMMENT '商品上架价格',
  `market_status` varchar(2) NOT NULL COMMENT '商品上架状态',
  `market_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `good_detail` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `order_no` varchar(32) NOT NULL COMMENT '订单号',
  `good_id` bigint(11) NOT NULL COMMENT '商品id',
  `good_detail_id` bigint(11) NOT NULL COMMENT '商品详情id',
  `express_code` varchar(30) DEFAULT NULL COMMENT '快递编码',
  `status` varchar(2) NOT NULL COMMENT '状态',
  `remarks` varchar(255) NOT NULL COMMENT '备注',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `shop_car` */

DROP TABLE IF EXISTS `shop_car`;

CREATE TABLE `shop_car` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '购物车Id主键',
  `user_id` bigint(11) NOT NULL COMMENT '用户id',
  `good_id` bigint(11) NOT NULL COMMENT '商品id',
  `good_detail_id` bigint(11) NOT NULL COMMENT '商品详情id',
  `good_num` int(11) NOT NULL COMMENT '商品购买数量',
  `total_price` decimal(21,0) NOT NULL COMMENT '商品总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_car` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id主键',
  `name` varchar(30) NOT NULL COMMENT '用户名称',
  `user_type` varchar(2) NOT NULL COMMENT '用户类型 0一般 1超级',
  `phone` varchar(11) NOT NULL COMMENT '用户账户',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `status` varchar(2) NOT NULL COMMENT '用户状态',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id主键',
  `name` varchar(30) NOT NULL COMMENT '用户名称',
  `user_type` varchar(2) NOT NULL COMMENT '用户类型 0买家 1卖家',
  `phone` varchar(11) NOT NULL COMMENT '用户账户',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `good_category_type` bigint(11) DEFAULT NULL COMMENT '用户的分类 卖家才有',
  `status` varchar(2) NOT NULL COMMENT '用户状态',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`user_type`,`phone`,`password`,`good_category_type`,`status`,`create_date`,`update_date`,`del_flag`) values (1,'jabin','1','18825113545','123456',1,'1','2017-09-02 00:00:00','2017-09-02 00:00:00','0'),(2,'库','2','18825113546','123456',1,'1','2017-09-03 00:00:00','2017-09-03 00:00:00','0'),(3,'百','1','18825113547','123',1,'1','2017-09-03 00:00:00','2017-09-03 00:00:00','0'),(4,'的','1','18825113548','123456',1,'1','2017-09-03 00:00:00','2017-09-03 00:00:00','0');

/*Table structure for table `userss` */

DROP TABLE IF EXISTS `userss`;

CREATE TABLE `userss` (
  `id` bigint(1) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `userss` */

insert  into `userss`(`id`,`name`) values (1,'jabin'),(2,'sum'),(3,'lilei');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
