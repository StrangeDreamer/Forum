/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.24 : Database - forum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`forum` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `forum`;

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topicId` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topicId` (`topicId`),
  KEY `userid` (`userid`),
  CONSTRAINT `information_ibfk_1` FOREIGN KEY (`topicId`) REFERENCES `topic` (`id`),
  CONSTRAINT `information_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `information` */

insert  into `information`(`id`,`topicId`,`userid`,`content`) values (4,2,2,'存盘 Ctrl+s(肯定知道) 注释代码 Ctrl+/ 取消注释 Ctrl+\\(Eclipse3已经都合并到Ctrl+/了) 代码辅助 Alt+/ 快速修复 Ctrl+1 '),(5,2,3,'切换窗口 Ctrl+f6 <可改为ctrl+tab方便> ctrl+shift+M 导入未引用的包 ctrl+w 关闭单个窗口 F3 跳转到类、变量的声明 '),(6,2,1,'F11 运行上次程序 Ctrl + F11 调试上次程序 Alt + 回下一个编辑点 ctrl+shift+T 查找工程中的类'),(7,1,3,'3.查询指定列SQL>SELECT empmo, ename, mgr FROM emp;'),(14,1,2,'查询指定行SQL>SELECT * FROM emp WHERE job=\'CLERK\';<img alt=\"吐舌头\" src=\"xheditor/xheditor_emot/default/tongue.gif\" />'),(16,1,4,' 使用like操作符（%，_）SQL>SELECT * FROM emp WHERE ename like \'S__T%\';'),(17,1,3,'查询字段内容为空/非空的语句SQL>SELECT * FROM emp WHERE mgr IS/IS NOT NULL;<img alt=\"快哭了\" src=\"xheditor/xheditor_emot/default/fastcry.gif\" />'),(20,1,1,'使用逻辑操作符号SQL>SELECT * FROM emp WHERE (sal>500 or job=\'MANAGE\') and ename like \'J%\';<img alt=\"哭\" src=\"xheditor/xheditor_emot/default/cry.gif\" />'),(21,2,2,'Ctrl+Q 定位到最后编辑的地方 Ctrl+L 定位在某行 (对于程序超过100的人就有福音了) Ctrl+M 最大化当前的Edit或View (再按则反之) '),(22,1,1,'将查询结果按字段的值进行排序SQL>SELECT * FROM emp ORDER BY deptno, sal DESC; (按部门升序，并按薪酬降序)'),(23,1,1,'<img alt=\"敲打\" src=\"xheditor/xheditor_emot/default/knock.gif\" /><img alt=\"可怜\" src=\"xheditor/xheditor_emot/default/cute.gif\" />'),(24,2,2,'电子vf');

/*Table structure for table `messages` */

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `sendtime` date NOT NULL,
  `content` varchar(230) DEFAULT NULL,
  `senderid` int(12) DEFAULT NULL,
  `receiverid` int(12) DEFAULT NULL,
  `isread` tinyint(1) NOT NULL DEFAULT '0',
  `isdeletedbysender` tinyint(1) NOT NULL DEFAULT '0',
  `isdeletedbyreceiver` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `senderid` (`senderid`),
  KEY `receiverid` (`receiverid`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`senderid`) REFERENCES `user` (`id`),
  CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`receiverid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `messages` */

insert  into `messages`(`id`,`title`,`sendtime`,`content`,`senderid`,`receiverid`,`isread`,`isdeletedbysender`,`isdeletedbyreceiver`) values (1,'欢迎各位坛友光临','2017-07-01','大家相互学习，相互交流，分享经验，请多多关照！',1,2,1,0,0),(2,'清空session的方法','2017-07-06','请问一下清空session的方法，谢谢。',4,1,0,0,0),(3,'欢迎坛友光临','2017-07-01','欢迎大家',3,1,1,0,0),(4,'广州旅行指导','2017-07-05','欢迎来到广州，有许多景点可以游玩',2,1,1,0,0),(6,'Re:欢迎来到开发者论坛','2017-07-06','大家可以相互交流',1,3,0,0,0),(7,'Re:Hi,交个朋友吧','2017-07-06','请多多关照',1,4,0,0,0),(8,'Re:欢迎坛友光临','2017-07-06','王锦123',1,3,0,0,0),(9,'请教一个问题','2017-07-02','qwrqr',2,1,1,0,0),(10,'常用的Mysql数据库操作语句大全','2017-07-07','速动资产',2,3,0,0,0),(11,'欢迎各位坛友光临','2017-07-07','发行的合法',2,1,0,0,0);

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `userId` int(11) NOT NULL,
  `date` date NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `topic` */

insert  into `topic`(`id`,`title`,`userId`,`date`,`content`) values (1,'常用的Mysql数据库操作语句大全',1,'2017-07-03','>CREATE DATABASE db_name;　　//db_name为数据库名<img alt=\"偷笑\" src=\"xheditor/xheditor_emot/default/titter.gif\" />'),(2,'myeclipse快捷键用法',2,'2017-07-05','myeclipse有比较多的快捷键--了解一些编程速度更快'),(3,'Form表单中method=\"post/get\'的区别',1,'2017-07-04','Form提供了两种数据传输的方式——get和post。虽然它们都是数据的提交方式，但是在实际传输时确有很大的不同，并且可能会对数据产生严重的影响。虽然为了方便的得到变量值，Web容器已经屏蔽了二者的一些差异，但是了解二者的差异在以后的编程也会很有帮助的。'),(4,'jQuery 基础教程',3,'2017-07-03','jQuery 是一个 JavaScript 库,极大地简化了 JavaScript 编程。jQuery 很容易学习。'),(5,'	正则表达式学习',4,'2017-07-02','http://www.runoob.com/regexp/regexp-tutorial.html'),(7,'解决数据库中文乱码问题',1,'2017-07-05','request.setCharacterEncoding(\"utf-8\");'),(15,'阿哥vfda',2,'2017-07-07','啊三分得手');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'徐超','123'),(2,'王锦','123'),(3,'张刘倩','123'),(4,'曹阳','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
