/*
 Navicat Premium Data Transfer

 Source Server         : 本地Sql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : d1

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 25/08/2018 23:33:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `happen_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of logs
-- ----------------------------
BEGIN;
INSERT INTO `logs` VALUES (18, '2018-08-25 23:30:04', 'java.lang.ArithmeticException: / by zero');
INSERT INTO `logs` VALUES (19, '2018-08-25 23:30:38', 'java.lang.ArithmeticException: / by zero');
INSERT INTO `logs` VALUES (20, '2018-08-25 23:31:07', 'java.lang.ArithmeticException: / by zero');
INSERT INTO `logs` VALUES (21, '2018-08-25 23:32:00', 'java.lang.ArithmeticException: / by zero');
INSERT INTO `logs` VALUES (22, '2018-08-25 23:32:07', 'java.lang.ArithmeticException: / by zero');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
