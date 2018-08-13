/*
Navicat MySQL Data Transfer

Source Server         : myconnection
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : graduate

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2017-03-10 22:43:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `uptime` datetime NOT NULL,
  `title` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', '2017-03-08 23:37:12', '1', '1', null);
INSERT INTO `message` VALUES ('2', 'xu', '2017-03-10 16:17:59', '1', '1', '1');
INSERT INTO `message` VALUES ('3', 'xu', '2017-03-10 16:18:13', '2', '2', '1');
INSERT INTO `message` VALUES ('4', 'xu', '2017-03-10 20:29:03', '1', '1', '1');
INSERT INTO `message` VALUES ('5', 'xu', '2017-03-10 21:21:50', '1', '1', '1');

-- ----------------------------
-- Table structure for `upfile`
-- ----------------------------
DROP TABLE IF EXISTS `upfile`;
CREATE TABLE `upfile` (
  `id` varchar(40) NOT NULL,
  `uuidname` varchar(100) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `savepath` varchar(255) NOT NULL,
  `uptime` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `username` varchar(40) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuidname` (`uuidname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upfile
-- ----------------------------
INSERT INTO `upfile` VALUES ('0361f10c-9c76-421e-b89c-3552d4259357', '0c2ce8bb-75fd-419d-b327-85a47659a5be.txt', 'New Text Document (2).txt', 'C:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\updown\\WEB-INF\\upload\\9\\5', '2017-03-09 20:11:03', '1', '1', '1');
INSERT INTO `upfile` VALUES ('3551cd4a-1d5f-46b5-a2fc-5659ac2a9889', '4c7aaa0c-cb27-46bb-bba0-0350ca26afe0.txt', 'New Text Document (2).txt', 'C:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\updown\\WEB-INF\\upload\\13\\14', '2017-03-09 20:17:07', '', '2', '2');
INSERT INTO `upfile` VALUES ('654043e6-6de6-4a8a-a313-f6ba7830a61c', '88b84e9e-3bdd-4c77-9297-b4a1cace0cda.txt', 'New Text Document (2).txt', 'C:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\updown\\WEB-INF\\upload\\0\\1', '2017-03-09 19:07:02', '1', '1', '1');
INSERT INTO `upfile` VALUES ('9f1305f8-c753-490f-a15b-ad125ff27cac', 'a84fc66e-1907-472d-ad37-e453a79a58ea.txt', 'New Text Document (3).txt', 'C:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\updown\\WEB-INF\\upload\\6\\1', '2017-03-09 19:07:22', '1', '2', '2');
INSERT INTO `upfile` VALUES ('ff6889b3-9e5f-43b8-83a2-d6444e912ea6', 'f0880c8e-5243-44a9-85f4-4ab940dec0d7.txt', 'New Text Document (3).txt', 'C:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\updown\\WEB-INF\\upload\\14\\5', '2017-03-09 19:56:43', '1', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `power` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '3', '3', '3', 'Jes', '计算机', '软件', '19950205');
INSERT INTO `user` VALUES ('7', '1', '1', '1', 'xu', '1', '1', '1');
INSERT INTO `user` VALUES ('9', '2', '2', '2', 'wu', 'cs', 'software', '20000101');
INSERT INTO `user` VALUES ('11', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `user` VALUES ('12', '5', '5', '3', '5', '5', '5', '5');
INSERT INTO `user` VALUES ('13', '5', '5', '3', '5', '5', '5', '5');
