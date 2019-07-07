/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.14 : Database - wuliu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wuliu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wuliu`;

/*Table structure for table `airline` */

DROP TABLE IF EXISTS `airline`;

CREATE TABLE `airline` (
  `id` varchar(40) NOT NULL,
  `flightnum` varchar(40) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '0 自由\n            1 分析\n            3 正式\n            4 分析\n            5 正式作废',
  `transferpri` varchar(5) DEFAULT NULL,
  `directpri` varchar(5) DEFAULT NULL,
  `startcity` varchar(40) DEFAULT NULL,
  `startairport` varchar(40) DEFAULT NULL,
  `outcenter` varchar(40) DEFAULT NULL,
  `outpici` varchar(5) DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `tianshu` varchar(5) DEFAULT NULL,
  `inpici` varchar(40) DEFAULT NULL,
  `intcenter` varchar(40) DEFAULT NULL,
  `endcity` varchar(40) DEFAULT NULL,
  `endair` varchar(40) DEFAULT NULL,
  `transfepici` varchar(5) DEFAULT NULL,
  `transfercenter` varchar(40) DEFAULT NULL,
  `unitprice` double DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `inputperson` varchar(30) DEFAULT NULL,
  `inputtime` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `airline` */

insert  into `airline`(`id`,`flightnum`,`status`,`transferpri`,`directpri`,`startcity`,`startairport`,`outcenter`,`outpici`,`starttime`,`endtime`,`tianshu`,`inpici`,`intcenter`,`endcity`,`endair`,`transfepici`,`transfercenter`,`unitprice`,`mileage`,`inputperson`,`inputtime`) values ('air101','H13231','2','1','1','北京市','北京首都国际机场','北京市马驹桥转运中心','1','02:00:00','05:45:00','1','2','东莞沙田转运中心','湛江市','湛江机场',NULL,NULL,1518,1600,NULL,NULL),('air102','KN5895','2','1','1','北京市','北京首都国际机场','北京市马驹桥转运中心','1','02:00:00','05:30:00','1','1','广州白云转运中心','广州市','广州白云机场',NULL,NULL,1413,1458,NULL,NULL);

/*Table structure for table `busline` */

DROP TABLE IF EXISTS `busline`;

CREATE TABLE `busline` (
  `id` varchar(40) NOT NULL,
  `type` char(1) DEFAULT NULL COMMENT '0干线 2省内3市内',
  `directpri` varchar(5) DEFAULT NULL,
  `transferpri` varchar(5) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '0 自由\n            1 分析\n            3 正式\n            4 分析作废\n            5 正式作废',
  `startcity` varchar(40) DEFAULT NULL,
  `outcenter` varchar(40) DEFAULT NULL,
  `outpici` varchar(40) DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `tianshu` varchar(5) DEFAULT NULL,
  `unitprice` double DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `inpici` varchar(40) DEFAULT NULL,
  `intcenter` varchar(40) DEFAULT NULL,
  `endcity` varchar(40) DEFAULT NULL,
  `transferpici` varchar(40) DEFAULT NULL,
  `transfercenter` varchar(40) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `vol` double DEFAULT NULL,
  `inputperson` varchar(30) DEFAULT NULL,
  `inputtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `busline` */

insert  into `busline`(`id`,`type`,`directpri`,`transferpri`,`name`,`status`,`startcity`,`outcenter`,`outpici`,`starttime`,`endtime`,`tianshu`,`unitprice`,`mileage`,`inpici`,`intcenter`,`endcity`,`transferpici`,`transfercenter`,`weight`,`vol`,`inputperson`,`inputtime`) values ('bs101','0','1','1','北京-东莞','2','北京市','北京市马驹桥转运中心','3','02:00:00','08:00:00','1',1185,2168,'2','东莞沙田转运中心','东莞市',NULL,NULL,NULL,NULL,NULL,NULL),('bs102','1','1','1','东莞-江门','2','东莞市','东莞沙田转运中心','2','10:00:00','12:00:00','1',84,150,'4','江门市杜阮转运中心','江门市',NULL,NULL,NULL,NULL,NULL,NULL),('bs103','1','1','1','江门-湛江','2','江门市','江门市杜阮转运中心','4','14:00:00','19:00:00','1',145,354,'5','湛江市麻章转运中心','湛江市',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `chukubill` */

DROP TABLE IF EXISTS `chukubill`;

CREATE TABLE `chukubill` (
  `id` varchar(40) NOT NULL,
  `type` char(1) DEFAULT NULL COMMENT '市内物流交接单，长途物流交接单，派送清单，发货交接单',
  `lineresource` varchar(40) DEFAULT NULL COMMENT '系统根据配载默认出线路资源',
  `linedirection` varchar(40) DEFAULT NULL COMMENT '由线路资源决定',
  `transportway` varchar(40) DEFAULT NULL,
  `jiehuopeople` varchar(40) DEFAULT NULL,
  `jiaohuopeople` varchar(40) DEFAULT NULL,
  `jiaohuotime` datetime DEFAULT NULL,
  `jiaohuostation` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chukubill` */

/*Table structure for table `chukudetails` */

DROP TABLE IF EXISTS `chukudetails`;

CREATE TABLE `chukudetails` (
  `workorder_id` varchar(40) NOT NULL,
  `chukubill_id` varchar(40) NOT NULL,
  `combinebill_id` varchar(40) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `vol` double DEFAULT NULL,
  `scantime` datetime DEFAULT NULL,
  `productname` varchar(40) DEFAULT NULL,
  `shouhuopeople` varchar(40) DEFAULT NULL,
  `shouhuoaddress` varchar(255) DEFAULT NULL,
  `timelimit` int(11) DEFAULT NULL,
  `destination` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`workorder_id`,`chukubill_id`),
  KEY `FK_chukudetails_chukubill` (`chukubill_id`),
  CONSTRAINT `FK_chukudetails_chukubill` FOREIGN KEY (`chukubill_id`) REFERENCES `chukubill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chukudetails` */

/*Table structure for table `combinebill` */

DROP TABLE IF EXISTS `combinebill`;

CREATE TABLE `combinebill` (
  `id` varchar(40) NOT NULL,
  `combinepeople` varchar(40) DEFAULT NULL,
  `seal_id` varchar(40) DEFAULT NULL,
  `destination` varchar(40) DEFAULT NULL,
  `count_destination` varchar(40) DEFAULT NULL,
  `timelimit` int(11) DEFAULT NULL,
  `piaoshu` int(11) DEFAULT NULL,
  `jiangshu` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `vol` double DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '0已拆包、\n            1未拆包；保存默认值是未拆包',
  `peizai` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `combinebill` */

insert  into `combinebill`(`id`,`combinepeople`,`seal_id`,`destination`,`count_destination`,`timelimit`,`piaoshu`,`jiangshu`,`weight`,`vol`,`status`,`peizai`) values ('5FEB3418FA194FDCB96F301B115E8667','aaaaa','D7A2CDA1655947A7A362D2F87594C218','东莞市','东莞市',1,5,5,NULL,NULL,'0','');

/*Table structure for table `combinedetails` */

DROP TABLE IF EXISTS `combinedetails`;

CREATE TABLE `combinedetails` (
  `workorder_id` varchar(40) NOT NULL,
  `combineorder_id` varchar(40) DEFAULT NULL,
  `productname` varchar(40) DEFAULT NULL,
  `destination` varchar(40) DEFAULT NULL,
  `jianshu` int(11) DEFAULT NULL,
  `vol` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `timelimit` int(11) DEFAULT NULL,
  `peizai` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`workorder_id`),
  KEY `FK_combinedetails_combinebill` (`combineorder_id`),
  CONSTRAINT `FK_combinedetails_combinebill` FOREIGN KEY (`combineorder_id`) REFERENCES `combinebill` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `combinedetails` */

insert  into `combinedetails`(`workorder_id`,`combineorder_id`,`productname`,`destination`,`jianshu`,`vol`,`weight`,`timelimit`,`peizai`) values ('48C75DA22759481BB4BE9FA3AB770410','5FEB3418FA194FDCB96F301B115E8667','手机','广东省湛江市赤坎区岭南师范学院',1,NULL,NULL,NULL,'小心！'),('625B5D2968CA4D448CC42C6B60EF1A3C','5FEB3418FA194FDCB96F301B115E8667','发胶','广东省东莞市大安镇',1,NULL,NULL,NULL,''),('9685DEB69CCA432FB6FD04C36ADC7FFC','5FEB3418FA194FDCB96F301B115E8667','书','广东省茂名市',1,NULL,NULL,NULL,''),('B6196B96407545E7B1BDA8886367D755','5FEB3418FA194FDCB96F301B115E8667','电脑','广东省湛江市霞山区广东海洋大学',1,NULL,NULL,NULL,'保坏不保丢！'),('C412C73D4C84482FA090C7742D03AD62','5FEB3418FA194FDCB96F301B115E8667','牛肉干','广东省高州市荷花镇',1,NULL,NULL,NULL,'');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` varchar(40) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `decidedzone_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`name`,`station`,`telephone`,`address`,`decidedzone_id`) values ('1','李彦宏','百度','18476041285','中山街道',NULL),('2','宗庆后','哇哈哈','18476041283','南桥街道','DQ105'),('3','马化腾','腾讯','18476041286','寸金街道',NULL),('4','王小川','搜狗','18476041284','寸金街道','DQ105'),('5','曹国伟','新浪','18511111111','寸金街道',NULL),('6','柳传志','联想','13722222222','寸金街道',NULL),('7','任正非','华为','13733333333','寸金街道',NULL),('8','马云','阿里巴巴','13788888888','寸金街道',NULL);

/*Table structure for table `decidedzone` */

DROP TABLE IF EXISTS `decidedzone`;

CREATE TABLE `decidedzone` (
  `id` varchar(40) NOT NULL,
  `staff_id` varchar(40) NOT NULL,
  `region_id` varchar(40) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_3` (`region_id`),
  KEY `FK_decidedzone_staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `decidedzone` */

insert  into `decidedzone`(`id`,`staff_id`,`region_id`,`name`) values ('DQ101','2016344128','QY001','寸金街道'),('DQ102','2016344129','QY001','民主街道'),('DQ103','2016344130','QY001','中山街道'),('DQ104','2016344131','QY001','沙湾街道'),('DQ105','2016344132','QY001','调顺街道'),('DQ106','2016344133','QY001','南桥街道'),('DQ107','2016344134','QY001','北桥街道'),('DQ200','2016344135','QY002','解放街道'),('DQ201','2016344136','QY002','爱国街道'),('DQ202','2016344137','QY002','工农街道'),('DQ203','2016344138','QY002','友谊街道'),('DQ204','2016344139','QY002','新兴街道'),('DQ205','2016344140','QY002','海滨街道'),('DQ206','2016344141','QY002','建设街道'),('DQ207','2016344142','QY002','新园街道'),('DQ208','2016344143','QY002','东新街道'),('DQ209','2016344144','QY002','海头街道'),('DQ210','2016344145','QY002','乐华街道'),('QD108','2016344149','QY001','中华街道');

/*Table structure for table `deliveryunit` */

DROP TABLE IF EXISTS `deliveryunit`;

CREATE TABLE `deliveryunit` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `fuzepeople` varchar(40) DEFAULT NULL,
  `transfercenter` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `deliveryunit` */

insert  into `deliveryunit`(`id`,`name`,`address`,`fuzepeople`,`transfercenter`) values ('11','岭南师范学院','寸金路29号',NULL,'湛江市麻章转运中心'),('22','广东海洋大学','湖光岩',NULL,'湛江市麻章转运中心');

/*Table structure for table `fendanbill` */

DROP TABLE IF EXISTS `fendanbill`;

CREATE TABLE `fendanbill` (
  `workorder_id` varchar(40) NOT NULL,
  `transfercenter` varchar(40) NOT NULL,
  `deliveryunit_id` varchar(40) DEFAULT NULL,
  `timelimit` int(11) DEFAULT NULL,
  `inpici` varchar(5) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '未入库、 0\n            已入库、 1\n            已出库 2',
  `fendantime` datetime DEFAULT NULL,
  `fendanpeople` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`workorder_id`,`transfercenter`),
  KEY `FK_fendan_deliveryunit` (`deliveryunit_id`),
  CONSTRAINT `FK_fendan_deliveryunit` FOREIGN KEY (`deliveryunit_id`) REFERENCES `deliveryunit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fendanbill` */

/*Table structure for table `noticebill` */

DROP TABLE IF EXISTS `noticebill`;

CREATE TABLE `noticebill` (
  `id` varchar(40) NOT NULL,
  `staff_id` varchar(40) DEFAULT NULL,
  `user_id` varchar(30) DEFAULT NULL,
  `customer_name` varchar(30) DEFAULT NULL,
  `delegater` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `pickaddress` varchar(200) DEFAULT NULL,
  `arrivecity` varchar(20) DEFAULT NULL,
  `product` varchar(20) DEFAULT NULL,
  `pickdate` date DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `volume` varchar(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `ordertype` char(1) DEFAULT NULL COMMENT '0自动下单成功\n            1自动下单失败',
  `station` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_noticebill_staff` (`staff_id`),
  KEY `FK_noticebill_user` (`user_id`),
  CONSTRAINT `FK_noticebill_staff` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FK_noticebill_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `noticebill` */

insert  into `noticebill`(`id`,`staff_id`,`user_id`,`customer_name`,`delegater`,`telephone`,`pickaddress`,`arrivecity`,`product`,`pickdate`,`weight`,`volume`,`remark`,`ordertype`,`station`) values ('0437730099904B5EAFFBE8BA7BD3A8D5','2016344128','11','王小川','王小川','18476041284','寸金街道','陆丰','衣服','2019-06-05',5,'2','急急急','0','湛江市麻章转运中心'),('17E3A9126984456EA933EE5A1297B890','2016344128','11','宗庆后','宗庆后','18476041283','寸金街道','智能','','2019-06-05',NULL,'','','0','湛江市麻章转运中心'),('27D65423112B4208B3A6B90C903C55F2','2016344130','11','李彦宏','李彦宏','18476041285','中山街道','湛江','','2019-06-07',NULL,'','','0','湛江市麻章转运中心'),('389C5E6F7ABF454F8F79539F4AED2FEC','2016344128','44','马化腾','马化腾','18476041286','寸金街道','','','2019-06-19',NULL,'','','0',NULL),('4250E182CF0C43E5B813D64ADE939F56','2016344128','11','马化腾','马化腾','18476041286','寸金街道','湛江','','2019-06-05',NULL,'','1111','0','湛江市麻章转运中心'),('533489F0F40F4021B2670435D72822E9',NULL,'44','马化腾','马化腾','18476041286','xxxx街道','','',NULL,NULL,'','','1','湛江市麻章转运中心'),('92D5C8A62D3F46A3BA64FF59A2BE83E6','2016344128','11','李彦宏','李彦宏','18476041285','寸金街道','湛江','','2019-06-05',NULL,'','急急急','0','湛江市麻章转运中心'),('C6D314E19DAB480994A5796A316270AC','2016344149','44','马化腾','马化腾','18476041286','中华街道','','',NULL,NULL,'','','0',NULL),('D1FEDB5A70B74F72A6DABF5882C51C50','2016344128','11','宗庆后','宗庆后','18476041283','寸金街道','湛江','','2019-06-06',NULL,'','','0','湛江市麻章转运中心'),('D4FE6B20AD0C4C7A993036E8D6FABBFD',NULL,'44','马化腾','马化腾','18476041286','博社村','','',NULL,NULL,'','','1',NULL),('E9BFA04C161A47CB954AA9E88D6C6CE7','2016344128','44','马化腾','马化腾','18476041286','寸金街道','北京','','2019-06-17',NULL,'','急急急！','0','湛江市麻章转运中心');

/*Table structure for table `oceanline` */

DROP TABLE IF EXISTS `oceanline`;

CREATE TABLE `oceanline` (
  `id` varchar(40) NOT NULL,
  `route` varchar(40) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '0 自由\n            1 分析\n            3 正式\n            4 分析\n            5 正式作废',
  `transferpri` varchar(5) DEFAULT NULL,
  `directpri` varchar(5) DEFAULT NULL,
  `startcity` varchar(40) DEFAULT NULL,
  `startport` varchar(40) DEFAULT NULL,
  `outcenter` varchar(40) DEFAULT NULL,
  `outpici` varchar(5) DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `tianshu` varchar(5) DEFAULT NULL,
  `inpici` varchar(40) DEFAULT NULL,
  `intcenter` varchar(40) DEFAULT NULL,
  `endcity` varchar(40) DEFAULT NULL,
  `endport` varchar(40) DEFAULT NULL,
  `transfepici` varchar(5) DEFAULT NULL,
  `transfercenter` varchar(40) DEFAULT NULL,
  `unitprice` double DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `inputperson` varchar(30) DEFAULT NULL,
  `inputtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oceanline` */

insert  into `oceanline`(`id`,`route`,`status`,`transferpri`,`directpri`,`startcity`,`startport`,`outcenter`,`outpici`,`starttime`,`endtime`,`tianshu`,`inpici`,`intcenter`,`endcity`,`endport`,`transfepici`,`transfercenter`,`unitprice`,`mileage`,`inputperson`,`inputtime`) values ('oc101','O13231','2','1','1','北京市','北京北码头','北京市马驹桥转运中心','1','06:00:00','20:00:00','4','2','湛江市麻章转运中心','湛江市','湛江港口岸',NULL,NULL,566,1600,NULL,NULL);

/*Table structure for table `peizaiinfo` */

DROP TABLE IF EXISTS `peizaiinfo`;

CREATE TABLE `peizaiinfo` (
  `workorder_id` varchar(40) NOT NULL,
  `combine_id` varchar(40) DEFAULT NULL,
  `operateunit` varchar(40) NOT NULL,
  `peizaiway` char(1) DEFAULT NULL COMMENT '空，航空，铁路，干线物流，支线物流，海运',
  `line_id` varchar(40) DEFAULT NULL,
  `product` varchar(40) DEFAULT NULL,
  `jiangshu` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `endcity` varchar(40) DEFAULT NULL,
  `timelimit` int(11) DEFAULT NULL,
  `peizai` varchar(255) DEFAULT NULL,
  `shouhuopeople` varchar(40) DEFAULT NULL,
  `shouhuoaddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`workorder_id`,`operateunit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `peizaiinfo` */

/*Table structure for table `qianshoubill` */

DROP TABLE IF EXISTS `qianshoubill`;

CREATE TABLE `qianshoubill` (
  `workorder_id` varchar(40) NOT NULL,
  `qianshoupeople` varchar(40) DEFAULT NULL,
  `staff_id` varchar(40) DEFAULT NULL,
  `staffname` varchar(40) DEFAULT NULL,
  `deliveryunit` varchar(40) NOT NULL,
  `qianshoutime` datetime DEFAULT NULL,
  `type` char(1) DEFAULT NULL COMMENT '0正常签收\n            1取消签收',
  PRIMARY KEY (`workorder_id`,`deliveryunit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qianshoubill` */

insert  into `qianshoubill`(`workorder_id`,`qianshoupeople`,`staff_id`,`staffname`,`deliveryunit`,`qianshoutime`,`type`) values ('48C75DA22759481BB4BE9FA3AB770410','陈贤达',NULL,NULL,'岭南师范学院','2019-06-19 11:18:11','0'),('B6196B96407545E7B1BDA8886367D755','任柯年',NULL,NULL,'广东海洋大学','2019-06-19 11:18:39','0');

/*Table structure for table `railwayline` */

DROP TABLE IF EXISTS `railwayline`;

CREATE TABLE `railwayline` (
  `id` varchar(40) NOT NULL,
  `trainnum` varchar(40) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '0 自由\n            1 分析\n            3 正式\n            4 分析\n            5 正式作废',
  `transferpri` varchar(5) DEFAULT NULL,
  `directpri` varchar(5) DEFAULT NULL,
  `startcity` varchar(40) DEFAULT NULL,
  `startstation` varchar(40) DEFAULT NULL,
  `outcenter` varchar(40) DEFAULT NULL,
  `outpici` varchar(5) DEFAULT NULL,
  `checi` varchar(40) DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `tianshu` varchar(5) DEFAULT NULL,
  `inpici` varchar(40) DEFAULT NULL,
  `intcenter` varchar(40) DEFAULT NULL,
  `endcity` varchar(40) DEFAULT NULL,
  `endstation` varchar(40) DEFAULT NULL,
  `transfepici` varchar(5) DEFAULT NULL,
  `transfercenter` varchar(40) DEFAULT NULL,
  `unitprice` double DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `inputperson` varchar(30) DEFAULT NULL,
  `inputtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `railwayline` */

insert  into `railwayline`(`id`,`trainnum`,`status`,`transferpri`,`directpri`,`startcity`,`startstation`,`outcenter`,`outpici`,`checi`,`starttime`,`endtime`,`tianshu`,`inpici`,`intcenter`,`endcity`,`endstation`,`transfepici`,`transfercenter`,`unitprice`,`mileage`,`inputperson`,`inputtime`) values ('r101','Z201','2','1','1','北京市','北京西站','北京市马驹桥转运中心','2',NULL,'17:54:00','22:06:00','2','3','湛江市麻章转运中心','湛江市','湛江西站',NULL,NULL,300.5,1800,NULL,NULL),('r102','Z202','2','1','1','东莞市','东莞虎门站','东莞市沙田转运中心','3',NULL,'22:54:00','06:00:00','1','2','湛江市麻章转运中心','湛江市','湛江西站',NULL,NULL,60.5,500,NULL,NULL);

/*Table structure for table `region` */

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
  `id` varchar(40) NOT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `postcode` varchar(50) DEFAULT NULL,
  `shortcode` varchar(30) DEFAULT NULL,
  `citycode` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `region` */

insert  into `region`(`id`,`province`,`city`,`district`,`postcode`,`shortcode`,`citycode`) values ('QY001','广东省','湛江市','赤坎区','524033','GDZJCK','zhanjiang'),('QY002','广东省','湛江市','霞山区','524002','GDZJXS','zhanjiang'),('QY003','广东省','湛江市','坡头区','524057','GDZJPT','zhanjiang'),('QY005','广东省','湛江市','雷州市','524500','GDZJLZ','zhanjiang'),('QY006','广东省','湛江市','廉江市','524200','GDZJLJ','zhanjiang'),('QY007','广东省','湛江市','吴川市','524400','GDZJWC','zhanjiang'),('QY008','广东省','湛江市','徐闻县','524300','GDZJXW','zhanjiang'),('QY009','广东省','湛江市','遂溪县','524100','GDZJSX','zhanjiang');

/*Table structure for table `routebill` */

DROP TABLE IF EXISTS `routebill`;

CREATE TABLE `routebill` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `flag` char(1) DEFAULT NULL COMMENT '0 不应用\n            1 应用',
  `startprovince` varchar(40) DEFAULT NULL,
  `startcity` varchar(40) DEFAULT NULL,
  `startdistrict` varchar(40) DEFAULT NULL,
  `endprovince` varchar(40) DEFAULT NULL,
  `endcity` varchar(40) DEFAULT NULL,
  `enddistrict` varchar(40) DEFAULT NULL,
  `timelimit` varchar(5) DEFAULT NULL,
  `transfernode1` varchar(40) DEFAULT NULL,
  `transfernode2` varchar(40) DEFAULT NULL,
  `transfernode3` varchar(40) DEFAULT NULL,
  `transfernode4` varchar(40) DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `routeprice` double DEFAULT NULL,
  `priority` varchar(5) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `vol` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `routebill` */

insert  into `routebill`(`id`,`name`,`flag`,`startprovince`,`startcity`,`startdistrict`,`endprovince`,`endcity`,`enddistrict`,`timelimit`,`transfernode1`,`transfernode2`,`transfernode3`,`transfernode4`,`starttime`,`endtime`,`mileage`,`routeprice`,`priority`,`weight`,`vol`) values ('0A2EE9E1BE2D46E4A3F8D7D5495263B6','北京市-湛江市-O13231',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'4',NULL,NULL,NULL,NULL,'06:00:00','20:00:00',1600,566,NULL,0,0),('0EDAB7B8AB36406B91BB17A27FB62E4A','北京市-湛江市(起始：H13231)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1',NULL,NULL,NULL,NULL,'02:00:00','05:45:00',1600,1518,NULL,0,0),('245CAB9D99C0446996B9245B6B906A7A','北京市-湛江市-Z201',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'2',NULL,NULL,NULL,NULL,'17:54:00','22:06:00',1800,300.5,NULL,0,0),('2A338BAB858D44B9B0882EB1D3F62C0A','北京市-湛江市(起始：O13231)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'4',NULL,NULL,NULL,NULL,'06:00:00','20:00:00',1600,566,NULL,0,0),('31BAE05F0F7F4328A871275AE8C5A7DE','北京市-湛江市(起始：北京-东莞)','1',NULL,'北京市',NULL,NULL,'湛江市',NULL,'0','东莞市','江门市',NULL,NULL,'02:00:00','19:00:00',0,0,NULL,0,0),('3509EE15E1254980934372FE2D732C32','北京市-湛江市(起始：H13231)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1',NULL,NULL,NULL,NULL,'02:00:00','05:45:00',1600,1518,NULL,0,0),('3585037539D34385BF0C0B42856BB8F3','北京市-东莞市-111C9897A5B34B38BE4E02DCC0A260D6','1',NULL,'北京市',NULL,NULL,'东莞市',NULL,'0',NULL,NULL,NULL,NULL,'02:00:00','08:00:00',0,0,NULL,0,0),('3A47B1C9D2EE4615B4E2D8CB77F35D28','北京市-湛江市(起始：Z201)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'2',NULL,NULL,NULL,NULL,'17:54:00','22:06:00',1800,300.5,NULL,0,0),('3B27248878144835B80B73BB1293FA26','北京市-湛江市(起始：Z201)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'2',NULL,NULL,NULL,NULL,'17:54:00','22:06:00',1800,300.5,NULL,0,0),('56C6FFA4B5124368927F8A073E7E9D25','北京市-湛江市(起始：北京-东莞)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1','东莞市','江门市',NULL,NULL,'02:00:00','19:00:00',2672,1414,NULL,0,0),('6688F46710324620BCA1003F92BF7092','北京市-湛江市-北京-东莞',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1','东莞市',NULL,NULL,NULL,'02:00:00','06:00:00',2668,1245.5,NULL,0,0),('84EBE2E58CE648BA8AC3AC2CC107B8B1','北京市-湛江市(起始：O13231)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'4',NULL,NULL,NULL,NULL,'06:00:00','20:00:00',1600,566,NULL,0,0),('8A662772E0C1462B913BBCC4A1640002','北京市-湛江市-北京-东莞',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1','东莞市','江门市',NULL,NULL,'02:00:00','19:00:00',2672,1414,NULL,0,0),('9B606C258A28450EAB0E37AF4F905862','北京市-湛江市(起始：北京-东莞)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1','东莞市',NULL,NULL,NULL,'02:00:00','06:00:00',2668,1245.5,NULL,0,0),('BB4EB97AE7AF4FDF8385A638FECF2F73','北京市-湛江市(起始：北京-东莞)',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1','东莞市',NULL,NULL,NULL,'02:00:00','06:00:00',2668,1245.5,NULL,0,0),('F507825E5F1048D3914993C7D6F2A691','北京市-湛江市-H13231',NULL,NULL,'北京市',NULL,NULL,'湛江市',NULL,'1',NULL,NULL,NULL,NULL,'02:00:00','05:45:00',1600,1518,NULL,0,0);

/*Table structure for table `routelinebill` */

DROP TABLE IF EXISTS `routelinebill`;

CREATE TABLE `routelinebill` (
  `id` varchar(40) DEFAULT NULL,
  `routebill_id` varchar(40) DEFAULT NULL,
  `startstation` varchar(40) DEFAULT NULL,
  `endstation` varchar(40) DEFAULT NULL,
  `starttime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `pici` varchar(5) DEFAULT NULL,
  `linename` varchar(40) DEFAULT NULL,
  `lineprice` double DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `tianshu` varchar(5) DEFAULT NULL,
  KEY `FK_routeline_route` (`routebill_id`),
  CONSTRAINT `FK_routeline_route` FOREIGN KEY (`routebill_id`) REFERENCES `routebill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `routelinebill` */

/*Table structure for table `rukubill` */

DROP TABLE IF EXISTS `rukubill`;

CREATE TABLE `rukubill` (
  `id` varchar(40) NOT NULL,
  `jiehuotime` datetime DEFAULT NULL,
  `jiehuopeople` varchar(40) DEFAULT NULL,
  `jiehuostation` varchar(40) DEFAULT NULL,
  `fahuopeople` varchar(40) DEFAULT NULL,
  `fahuostation` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rukubill` */

/*Table structure for table `rukudetails` */

DROP TABLE IF EXISTS `rukudetails`;

CREATE TABLE `rukudetails` (
  `workorder_id` varchar(40) NOT NULL,
  `rukubill_id` varchar(40) NOT NULL,
  `combinebill_id` varchar(40) DEFAULT NULL COMMENT '工作单所属合包号',
  `weight` double DEFAULT NULL,
  `chukubill_id` varchar(40) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT '1中转入库，\n            2二次入库，\n            3初始入库，\n            4有货无单\n            ',
  PRIMARY KEY (`workorder_id`,`rukubill_id`),
  KEY `FK_rukudetails_rukubill` (`rukubill_id`),
  KEY `FK_rukudetails_chukubill` (`chukubill_id`),
  CONSTRAINT `FK_rukudetails_chukubill` FOREIGN KEY (`chukubill_id`) REFERENCES `chukubill` (`id`),
  CONSTRAINT `FK_rukudetails_rukubill` FOREIGN KEY (`rukubill_id`) REFERENCES `rukubill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rukudetails` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` varchar(40) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `haspda` char(2) DEFAULT NULL,
  `deltag` char(2) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`id`,`name`,`telephone`,`haspda`,`deltag`,`password`,`station`) values ('2016344127','赖增智','15767589823','1','0','1','岭南师范学院'),('2016344128','李坤','18211271078','1','1','1','岭南师范学院'),('2016344129','麦东鹏','18476473136','1','0','1','岭南师范学院'),('2016344130','曾庆奕','13071633962','1','0','1','岭南师范学院'),('2016344131','梁家浩','13266432673','1','0','1','岭南师范学院'),('2016344132','林显望','13430589952','1','0','1','岭南师范学院'),('2016344133','钟华振','13726908482','1','0','1','岭南师范学院'),('2016344134','黎清湖','13432851746','1','0','1','岭南师范学院'),('2016344135','胡广信','18476729436','1','0','1','岭南师范学院'),('2016344136','周键澎','15767587226','1','0','1','岭南师范学院'),('2016344143','任柯年','18476041285','1','1','123456','岭南师范学院'),('2016344149','陈贤达','18476041285','1','0','12345678','岭南师范学院');

/*Table structure for table `subarea` */

DROP TABLE IF EXISTS `subarea`;

CREATE TABLE `subarea` (
  `id` varchar(40) NOT NULL,
  `decidedzone_id` varchar(40) DEFAULT NULL,
  `region_id` varchar(40) DEFAULT NULL,
  `addresskey` varchar(100) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `startnum` varchar(30) DEFAULT NULL,
  `endnum` varchar(30) DEFAULT NULL,
  `single` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_subarea_decidedzone` (`decidedzone_id`),
  KEY `FK_subarea_region` (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `subarea` */

insert  into `subarea`(`id`,`decidedzone_id`,`region_id`,`addresskey`,`position`,`startnum`,`endnum`,`single`) values ('FQ100','DQ100','QY001','中华街道','南方六横路1-100','1','100','2'),('FQ101','DQ100','QY001','中华街道','前进路30-80','30','80','2'),('FQ102','DQ100','QY001','中华街道','南通路1-120','1','120','2'),('FQ200','DQ101','QY001','寸金街道','寸金路1-120','1','120','2'),('FQ201','DQ101','QY001','寸金街道','新华路1-120','1','120','2'),('FQ202','DQ101','QY001','寸金街道','九二一路1-120','1','120','2'),('FQ203','DQ101','QY001','寸金街道','拥军路1-120','1','120','2');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salary` double DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `station` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`salary`,`birthday`,`gender`,`station`,`telephone`,`remark`) values ('11','aaaaa','123456',NULL,NULL,NULL,'北京市马驹桥转运中心',NULL,NULL),('22','bbbbb','123456',NULL,NULL,NULL,'东莞沙田转运中心',NULL,NULL),('33','ccccc','123456',NULL,NULL,NULL,'江门市杜阮转运中心',NULL,NULL),('44','ddddd','123456',NULL,NULL,NULL,'湛江市麻章转运中心',NULL,NULL),('55','eeeee','123456',NULL,NULL,NULL,'岭南师范学院',NULL,NULL),('66','fffff','123456',NULL,NULL,NULL,'广东海洋大学',NULL,NULL);

/*Table structure for table `workbill` */

DROP TABLE IF EXISTS `workbill`;

CREATE TABLE `workbill` (
  `id` varchar(40) NOT NULL,
  `noticebill_id` varchar(40) DEFAULT NULL,
  `type` char(1) DEFAULT NULL COMMENT '新,type=1\n            追,type=2\n            销,type=3',
  `pickstate` char(1) DEFAULT NULL COMMENT '新单:没有确认货物状态的,pickstate=1\n            已通知:自动下单下发短信,pickstate=2\n            已确认:接到短信,回复收信确认信息,pickstate=3\n            已取件:已经取件成功,发回确认信息,生成工作单,pickstate=4\n            已取消:销单,pickstate=5\n            ',
  `buildtime` date DEFAULT NULL,
  `attachbilltimes` int(11) DEFAULT NULL COMMENT '新工单次数为0\n            每次追单自增',
  `remark` varchar(255) DEFAULT NULL,
  `staff_id` varchar(40) DEFAULT NULL,
  `pickaddress` varchar(255) DEFAULT NULL,
  `picktime` date DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4` (`staff_id`),
  KEY `FK_workbill_noticebill_fk` (`noticebill_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FK_workbill_noticebill_fk` FOREIGN KEY (`noticebill_id`) REFERENCES `noticebill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `workbill` */

insert  into `workbill`(`id`,`noticebill_id`,`type`,`pickstate`,`buildtime`,`attachbilltimes`,`remark`,`staff_id`,`pickaddress`,`picktime`,`station`) values ('1E974C4B03A247FF84AB7BC03A002A32','C6D314E19DAB480994A5796A316270AC','4','3','2019-06-19',2,'','2016344149','中华街道','2019-06-30','湛江市麻章转运中心'),('272CAB80C5594D288F0B43114C32AE4D','27D65423112B4208B3A6B90C903C55F2','4','3','2019-06-19',0,'','2016344128','寸金街道','2019-06-11','湛江市麻章转运中心'),('6B4D28C1A88348C5A7D47166F9E34588','0437730099904B5EAFFBE8BA7BD3A8D5','1','3','2019-06-08',0,'急急急','2016344149','中华街道','2019-06-05','湛江市麻章转运中心'),('9BCB4FF3200F48D9B5D2B537E98A5246','27D65423112B4208B3A6B90C903C55F2','1','3','2019-06-19',0,'','2016344133','中华街道','2019-06-11','湛江市麻章转运中心'),('A56FB8B9050C44F0BB5B04494426A03B','4250E182CF0C43E5B813D64ADE939F56','1','3','2019-06-08',0,'1111','2016344129','北桥街道','2019-06-05','湛江市麻章转运中心'),('B79CFC94479B4B1792A394BCA09DEBB3','389C5E6F7ABF454F8F79539F4AED2FEC','1','3','2019-06-19',0,'','2016344128','寸金街道','2019-06-19','湛江市麻章转运中心'),('CD21CA9969E04966A460D37744410181','D4FE6B20AD0C4C7A993036E8D6FABBFD','1','3','2019-06-19',0,'','2016344132','博社村',NULL,'湛江市麻章转运中心'),('D01D706E070B4D7FACC3B7809DDAE417','533489F0F40F4021B2670435D72822E9','1','3','2019-06-17',0,'','2016344128','xxxx街道',NULL,NULL);

/*Table structure for table `workorder` */

DROP TABLE IF EXISTS `workorder`;

CREATE TABLE `workorder` (
  `id` varchar(40) NOT NULL,
  `sendername` varchar(20) DEFAULT NULL,
  `senderphone` varchar(20) DEFAULT NULL,
  `senderaddr` varchar(200) DEFAULT NULL,
  `receivername` varchar(20) DEFAULT NULL,
  `receiverphone` varchar(20) DEFAULT NULL,
  `receiveraddr` varchar(200) DEFAULT NULL,
  `product` varchar(20) DEFAULT NULL,
  `state` char(1) DEFAULT NULL COMMENT '正在配送，state=1\n            申请取消签收，state=2\n            已签收，state=3\n            ',
  `num` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `floadreqr` varchar(255) DEFAULT NULL,
  `actlweit` double DEFAULT NULL,
  `vol` varchar(20) DEFAULT NULL,
  `managerCheck` char(1) DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `workorder` */

insert  into `workorder`(`id`,`sendername`,`senderphone`,`senderaddr`,`receivername`,`receiverphone`,`receiveraddr`,`product`,`state`,`num`,`weight`,`floadreqr`,`actlweit`,`vol`,`managerCheck`,`updatetime`,`station`) values ('48C75DA22759481BB4BE9FA3AB770410','张三','15917132891','北京市朝阳区','陈贤达','18476041286','广东省湛江市赤坎区岭南师范学院','手机','3',1,NULL,'小心！',NULL,'',NULL,'2019-06-14','北京市马驹桥转运中心'),('625B5D2968CA4D448CC42C6B60EF1A3C','钱七','15917132894','北京市大兴区','陈永亮','18476041289','广东省东莞市大安镇','发胶','1',1,NULL,'',NULL,'',NULL,'2019-06-14','北京市马驹桥转运中心'),('9685DEB69CCA432FB6FD04C36ADC7FFC','周八','15917132895','北京市丰台区','麦东鹏','18476041284','广东省茂名市','书','1',1,NULL,'',NULL,'',NULL,'2019-06-14','北京市马驹桥转运中心'),('B6196B96407545E7B1BDA8886367D755','李四','13715963754','北京市马驹桥101号','任柯年','18476041285','广东省湛江市霞山区广东海洋大学','电脑','3',1,NULL,'保坏不保丢！',NULL,'',NULL,'2019-06-14','北京市马驹桥转运中心'),('C412C73D4C84482FA090C7742D03AD62','赵六','15917132893','北京市西城区联想','白杰华','18476041288','广东省高州市荷花镇','牛肉干','1',1,NULL,'',NULL,'',NULL,'2019-06-14','北京市马驹桥转运中心'),('D73CD5DBA0E04C3680306BB3F388FE89','陈久','15917131896','北京市东城区华为','张建华','18476041283','广西省桂林','零食','0',2,NULL,'',NULL,'',NULL,'2019-06-14','北京市马驹桥转运中心');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
