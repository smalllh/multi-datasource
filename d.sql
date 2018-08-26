/*
 Navicat Premium Data Transfer

 Source Server         : 本地Sql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : d

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 25/08/2018 23:33:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cost
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1760 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------
BEGIN;
INSERT INTO `cost` VALUES (1750, 100);
INSERT INTO `cost` VALUES (1751, 100);
INSERT INTO `cost` VALUES (1752, 100);
COMMIT;

-- ----------------------------
-- Table structure for other_datasource
-- ----------------------------
DROP TABLE IF EXISTS `other_datasource`;
CREATE TABLE `other_datasource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datasource_name` varchar(64) DEFAULT NULL,
  `database_ip` varchar(64) DEFAULT NULL,
  `database_port` varchar(64) DEFAULT NULL,
  `database_name` varchar(64) DEFAULT NULL,
  `database_username` varchar(64) DEFAULT NULL,
  `database_password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of other_datasource
-- ----------------------------
BEGIN;
INSERT INTO `other_datasource` VALUES (1, '动态切换', '127.0.0.1', '3306', 'd1', 'root', '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
