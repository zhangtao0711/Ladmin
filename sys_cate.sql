/*
 Navicat Premium Data Transfer

 Source Server         : Mika
 Source Server Type    : MySQL
 Source Server Version : 100307
 Source Host           : localhost:3306
 Source Schema         : ladmin

 Target Server Type    : MySQL
 Target Server Version : 100307
 File Encoding         : 65001

 Date: 14/05/2020 19:07:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_cate
-- ----------------------------
DROP TABLE IF EXISTS `sys_cate`;
CREATE TABLE `sys_cate`  (
  `cate_id` int(11) NOT NULL,
  `cate_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`cate_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
