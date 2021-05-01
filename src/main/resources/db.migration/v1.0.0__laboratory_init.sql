/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : laboratory

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 01/05/2021 16:58:28
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `teacher_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `date`          varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `tell_number`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `laboratory_id` int(11) NULL DEFAULT NULL,
    `course_id`     int(11) NULL DEFAULT NULL,
    `class_id`      int(11) NULL DEFAULT NULL,
    `class_name`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `update_time`   datetime(0) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `desc`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info`
VALUES (1, '初2022级1班', NULL);
INSERT INTO `class_info`
VALUES (2, '初2022级2班', NULL);
INSERT INTO `class_info`
VALUES (3, '初2022级3班', NULL);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `id`          int(20) NOT NULL AUTO_INCREMENT,
    `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `course_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `desc`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course`
VALUES (1, '第一节', '8:00-8:40', NULL);
INSERT INTO `course`
VALUES (2, '第二节', '8:50-9:30', NULL);
INSERT INTO `course`
VALUES (3, '第三节', '10:00-10:40', NULL);
INSERT INTO `course`
VALUES (4, '第四节', '10:50-11:30', NULL);
INSERT INTO `course`
VALUES (5, '第五节', '11:40-12:05', NULL);
INSERT INTO `course`
VALUES (6, '第六节', '14:20-15:30', NULL);
INSERT INTO `course`
VALUES (7, '第七节', '15:10-15:50', NULL);
INSERT INTO `course`
VALUES (8, '第八节', '16:05-16:45', NULL);
INSERT INTO `course`
VALUES (9, '第九节', '16:55-17:35', NULL);

-- ----------------------------
-- Table structure for laboratory_info
-- ----------------------------
DROP TABLE IF EXISTS `laboratory_info`;
CREATE TABLE `laboratory_info`
(
    `id`              int(20) NOT NULL AUTO_INCREMENT,
    `laboratory_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `desc`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratory_info
-- ----------------------------
INSERT INTO `laboratory_info`
VALUES (1, '实验室203', NULL);
INSERT INTO `laboratory_info`
VALUES (2, '实验室204', NULL);
INSERT INTO `laboratory_info`
VALUES (3, '实验室206', NULL);

SET
FOREIGN_KEY_CHECKS = 1;
