/*
Navicat MySQL Data Transfer

Source Server         : super
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : super

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2017-05-05 21:06:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `sal` decimal(24,6) default NULL,
  `age` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
