/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-09-10 17:52:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `flight`
-- ----------------------------
DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `id` int(11) NOT NULL,
  `fly_num` varchar(50) DEFAULT NULL,
  `des` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `fly_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of flight
-- ----------------------------
INSERT INTO `flight` VALUES ('1', '101', '北京', '2020-06-11');
INSERT INTO `flight` VALUES ('2', '152', '上海', '2020-06-19');
INSERT INTO `flight` VALUES ('3', '133', '深圳', '2020-06-25');
INSERT INTO `flight` VALUES ('4', '155', '南京', '2020-06-23');
