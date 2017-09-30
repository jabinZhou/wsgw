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
  `advertise_category_id` bigint(11) DEFAULT NULL COMMENT '分类id',
  `url` varchar(255) NOT NULL COMMENT '地址',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `advertise` */

insert  into `advertise`(`id`,`title`,`name`,`advertise_category_id`,`url`,`create_date`,`update_date`,`del_flag`) values (1,'第1幅图片','第一幅图片',1,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(2,'第2幅图片','第一幅图片',1,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(3,'第3幅图片','第一幅图片',1,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(4,'第4幅图片','第一幅图片',1,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(5,'第5幅图片','第一幅图片',1,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(6,'第6幅图片','第一幅图片',1,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(7,'第7幅图片','第一幅图片',1,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(8,'第8幅图片','第一幅图片',16,'1','2017-09-20 00:00:00','2017-09-25 23:04:28','0'),(9,'第9幅图片','第一幅图片',2,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(10,'第0幅图片','第一幅图片',2,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(11,'第一幅图片','第一幅图片',2,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(12,'第一幅图片','第一幅图片',2,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(13,'第一幅图片','第一幅图片',2,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(14,'第一幅图片','第一幅图片',2,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(15,'第一幅图片','第一幅图片',2,'1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(16,'标题','名称',0,'地址','2017-09-25 23:03:15','2017-09-25 23:04:13','1'),(17,'广告1','11',3,'11','2017-09-25 23:34:48','2017-09-25 23:35:06','0'),(18,'广告2','2',1,'2','2017-09-25 23:34:58','2017-09-25 23:35:14','0');

/*Table structure for table `advertise_category` */

DROP TABLE IF EXISTS `advertise_category`;

CREATE TABLE `advertise_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `parent_id` bigint(11) NOT NULL COMMENT '父类id',
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '父类ids',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `advertise_category` */

insert  into `advertise_category`(`id`,`name`,`parent_id`,`parent_ids`,`create_date`,`update_date`,`del_flag`) values (1,'首页广告',0,'0,1','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(2,'详情广告',0,'0,2','2017-09-20 00:00:00','2017-09-20 00:00:00','0'),(3,'登录页广告',0,'0,3','2017-09-24 00:00:00','2017-09-24 00:00:00','0'),(4,'首页第一排广告',0,'0,4','2017-09-24 00:00:00','2017-09-24 18:10:55','0'),(5,'首页第二排广告',1,'0,1,5','2017-09-24 00:00:00','2017-09-24 00:00:00','0'),(6,'详情第一排广告',2,'0,2,6','2017-09-24 00:00:00','2017-09-24 00:00:00','0'),(7,'详情第一排广告第一',6,'0,2,6,7','2017-09-24 00:00:00','2017-09-24 00:00:00','0'),(8,'啦啦',0,'0,8','2017-09-24 17:29:39','2017-09-24 17:29:39','0'),(9,'哈哈',0,'0,9','2017-09-24 17:30:35','2017-09-24 17:30:35','0'),(10,'苦苦',6,'0,2,6,10','2017-09-24 17:33:53','2017-09-24 17:56:54','0'),(11,'124654',8,'0,8,11','2017-09-24 17:35:27','2017-09-24 17:35:27','0'),(15,'一级',0,'0,15','2017-09-24 17:41:37','2017-09-24 17:41:37','0'),(16,'二级',15,'0,15,16','2017-09-24 17:41:49','2017-09-24 17:41:49','0'),(18,'11111',0,'0,18','2017-09-24 18:10:20','2017-09-24 18:10:20','0'),(19,'111110',0,'0,19','2017-09-24 18:10:32','2017-09-24 18:10:32','0');

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `title` varchar(60) NOT NULL COMMENT '标题',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `banner_category_id` bigint(11) DEFAULT NULL COMMENT '分类id',
  `url` varchar(255) NOT NULL COMMENT '地址',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `banner` */

insert  into `banner`(`id`,`title`,`name`,`banner_category_id`,`url`,`create_date`,`update_date`,`del_flag`) values (1,'1111','1111',1,'1','2017-07-25 00:00:00','2017-07-25 00:00:00','0'),(2,'222','222',2,'2','2017-07-25 00:00:00','2017-07-25 00:00:00','0'),(4,'4444','4444',0,'4','2017-07-25 00:00:00','2017-09-25 23:36:39','0'),(6,'啦啦法拉盛','爸爸',4,'手动阀','2017-09-25 23:30:44','2017-09-25 23:36:33','0'),(7,'速度发斯蒂芬','阿斯顿发生',1,'手动阀','2017-09-25 23:51:23','2017-09-25 23:51:31','0');

/*Table structure for table `banner_category` */

DROP TABLE IF EXISTS `banner_category`;

CREATE TABLE `banner_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'Id主键',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `parent_id` bigint(11) NOT NULL COMMENT '父类id',
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '父类ids',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `banner_category` */

insert  into `banner_category`(`id`,`name`,`parent_id`,`parent_ids`,`create_date`,`update_date`,`del_flag`) values (1,'111',2,'0,2,1','2017-07-25 00:00:00','2017-09-25 23:47:05','0'),(2,'222',0,'0,2','2017-07-25 00:00:00','2017-07-25 00:00:00','0'),(3,'333',2,'0,2,3','2017-07-25 00:00:00','2017-09-25 23:47:17','0'),(4,'444',1,'0,1,4','2017-07-25 00:00:00','2017-07-25 00:00:00','0'),(5,'5555',4,'0,1,4,5','2017-07-25 00:00:00','2017-09-25 23:47:40','0'),(6,'555',1,'0,1,6','2017-09-25 23:46:46','2017-09-25 23:46:56','0'),(7,'666',1,'0,2,1,7','2017-09-25 23:50:12','2017-09-26 23:25:47','0');

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
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '父类ids',
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
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '父类ids',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除　',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `good_category` */

insert  into `good_category`(`id`,`name`,`parent_id`,`parent_ids`,`create_date`,`update_date`,`del_flag`) values (1,'鞋子',0,'0,1','2017-09-18 00:00:00','2017-09-18 00:00:00','0'),(2,'口红',0,'0,2','2017-09-18 00:00:00','2017-09-18 00:00:00','0'),(3,'拉箱',0,'0,3','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(4,'包包',0,'0,4','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(5,'鞋子1',6,'0,1,5','2017-09-26 00:00:00','2017-09-26 23:36:33','0'),(6,'鞋子2',1,'0,1,6','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(7,'口红1',2,'0,2,7','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(8,'口红2',2,'0,2,8','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(9,'拉箱1',3,'0,3,9','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(10,'拉箱2',3,'0,3,10','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(11,'包包1',4,'0,4,11','2017-09-26 00:00:00','2017-09-26 00:00:00','0'),(12,'包包2',4,'0,4,12','2017-09-26 00:00:00','2017-09-26 00:00:00','0');

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
  `status` varchar(2) NOT NULL COMMENT '用户状态 0可用1不可用',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL COMMENT '删除标记1删除0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`name`,`user_type`,`phone`,`password`,`status`,`create_date`,`update_date`,`del_flag`) values (1,'我的','1','18825113545','123456','0','2017-09-17 00:00:00','2017-09-17 00:00:00','0'),(2,'你的1','0','18825151515','123456','1','2017-09-19 00:00:00','2017-09-17 22:24:39','0'),(3,'它的','1','12345678911','123456','1','2017-09-17 20:38:32','2017-09-17 21:12:19','0'),(4,'他的','0','18825413545','123456','1','2017-09-17 20:46:33','2017-09-17 21:12:01','0'),(5,'拉埃','1','18825111111','123456','0','2017-09-17 22:24:59','2017-09-17 22:24:59','0');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`user_type`,`phone`,`password`,`good_category_type`,`status`,`create_date`,`update_date`,`del_flag`) values (1,'jabin','1','18825113545','123456',2,'1','2017-09-02 00:00:00','2017-09-24 14:17:02','0'),(2,'库','0','18825113546','123456',NULL,'1','2017-09-03 00:00:00','2017-09-03 00:00:00','0'),(3,'百1','1','18825113547','123456',1,'1','2017-09-03 00:00:00','2017-09-24 14:19:36','0'),(4,'他','0','18825113549','1234567',NULL,'0','2017-09-03 00:00:00','2017-09-24 14:19:30','0'),(5,'我的买家','0','18825113599','123456',NULL,'0','2017-09-19 23:10:34','2017-09-24 13:57:51','0'),(6,'大是大非2','0','18181818118','123456',NULL,'0','2017-09-19 23:13:08','2017-09-24 13:56:10','0'),(7,'是的发送','0','12345678911','123456',NULL,'0','2017-09-19 23:15:42','2017-09-19 23:15:42','0'),(8,'ASDF','0','15151512222','123465',NULL,'0','2017-09-19 23:56:59','2017-09-20 00:00:06','0'),(9,'大是大非','0','18484887878','123456',NULL,'1','2017-09-20 00:00:27','2017-09-24 14:18:43','0'),(10,'沙发上','1','15151515151','123456',1,'0','2017-09-24 14:19:08','2017-09-24 14:19:08','0'),(11,'沙发斯蒂芬','0','15151548484','123456',NULL,'0','2017-09-24 14:19:23','2017-09-24 14:19:23','0');

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
