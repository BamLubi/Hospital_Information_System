/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : 127.0.0.1:3306
 Source Schema         : cloud_his

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 08/09/2020 22:53:56
*/

create database `cloud-his` default CHARACTER SET utf8 COLLATE utf8_general_ci;
use `cloud-his`;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for depart_info
-- ----------------------------
DROP TABLE IF EXISTS `depart_info`;
CREATE TABLE `depart_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `depart_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depart_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depart_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门种类： 1：医疗部门 2:化检部门 3：管理部门',
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of depart_info
-- ----------------------------
INSERT INTO `depart_info` VALUES ('1', '皮肤科', 'pfk', '1', '2020-09-08 22:10:09', '0');
INSERT INTO `depart_info` VALUES ('2', '激光科', 'jgk', '1', '2020-09-08 22:10:30', '0');
INSERT INTO `depart_info` VALUES ('3', '过敏免疫科', 'gmmyk', '1', '2020-09-08 22:11:00', '0');
INSERT INTO `depart_info` VALUES ('4', '财务科', 'cwk', '3', '2020-09-08 22:11:21', '0');
INSERT INTO `depart_info` VALUES ('5', '血常规科', 'xcgk', '2', '2020-09-08 22:11:44', '0');

-- ----------------------------
-- Table structure for doctor_schedule
-- ----------------------------
DROP TABLE IF EXISTS `doctor_schedule`;
CREATE TABLE `doctor_schedule`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `doctor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生id',
  `doctor_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `depart_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门id',
  `level` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '号级别：0 普通 1专家',
  `schedule_day` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值班时间：1-7 周日至周六',
  `schedule_date` date NULL DEFAULT NULL COMMENT '值班日期',
  `remain_am` int(11) NULL DEFAULT 50 COMMENT '上午剩余号',
  `remain_pm` int(11) NULL DEFAULT 50 COMMENT '下午剩余号',
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医生排班表，需要通过计划任务每天定时更新' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of doctor_schedule
-- ----------------------------
INSERT INTO `doctor_schedule` VALUES ('1', '2', '鹿晗', '1', '1', '3', '2020-09-15', 50, 50, '2020-09-08 22:41:53', '0');
INSERT INTO `doctor_schedule` VALUES ('10', '3', '吴亦凡', '2', '1', '6', '2020-09-18', 50, 50, '2020-09-08 22:50:26', '0');
INSERT INTO `doctor_schedule` VALUES ('2', '2', '鹿晗', '1', '1', '5', '2020-09-17', 50, 50, '2020-09-08 22:42:30', '0');
INSERT INTO `doctor_schedule` VALUES ('3', '1', '张艺兴', '1', '0', '7', '2020-09-19', 50, 50, '2020-09-08 22:43:56', '0');
INSERT INTO `doctor_schedule` VALUES ('4', '1', '张艺兴', '1', '0', '2', '2020-09-14', 50, 50, '2020-09-15 22:44:13', '0');
INSERT INTO `doctor_schedule` VALUES ('5', '1', '张艺兴', '1', '0', '3', '2020-09-15', 50, 50, '2020-09-08 22:44:35', '0');
INSERT INTO `doctor_schedule` VALUES ('6', '1', '张艺兴', '1', '0', '4', '2020-09-16', 50, 50, '2020-09-08 22:45:13', '0');
INSERT INTO `doctor_schedule` VALUES ('7', '1', '张艺兴', '1', '0', '5', '2020-09-17', 50, 50, '2020-09-08 22:45:47', '0');
INSERT INTO `doctor_schedule` VALUES ('8', '1', '张艺兴', '1', '0', '6', '2020-09-18', 50, 50, '2020-09-08 22:46:47', '0');
INSERT INTO `doctor_schedule` VALUES ('9', '3', '吴亦凡', '2', '0', '5', '2020-09-17', 50, 50, '2020-09-08 22:49:43', '0');

-- ----------------------------
-- Table structure for drug_info
-- ----------------------------
DROP TABLE IF EXISTS `drug_info`;
CREATE TABLE `drug_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `drug_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drug_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品描述',
  `stocks` int(11) NULL DEFAULT NULL COMMENT '库存数量',
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of drug_info
-- ----------------------------
INSERT INTO `drug_info` VALUES ('1', '0001', '复方维A酸软膏', '瓶', 22, '[成分]xxx', 100, '2020-09-08 22:14:11', '0');
INSERT INTO `drug_info` VALUES ('2', '0002', '复方咪康唑软膏', '瓶', 30, '[性状]xxx', 100, '2020-09-08 22:16:14', '0');

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depart_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `job_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位：d：医生 n:护士 c：普通医工',
  `doctor_rank` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生职称：住院医师、主治医师、副主任医师、主任医师等',
  `introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '医生简介',
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医院人员信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES ('1', '张艺兴', '1', '13913913339', 22, 'd', '主任医师', '主治过敏性皮炎', '2020-09-08 22:17:56', '0');
INSERT INTO `employee_info` VALUES ('2', '鹿晗', '1', '13813813338', 24, 'd', '副主任医师', '中西医结合诊治痤疮', '2020-09-08 22:19:24', '0');
INSERT INTO `employee_info` VALUES ('3', '吴亦凡', '2', '1361361336', 28, 'd', '主治医师', '擅长激光美容', '2020-09-08 22:20:10', '0');
INSERT INTO `employee_info` VALUES ('4', '大鹏', '5', '13413413334', 31, 'd', '主治医师', NULL, '2020-09-08 22:21:43', '0');
INSERT INTO `employee_info` VALUES ('5', '林有有', '4', '1321321332', 22, 'c', NULL, NULL, '2020-09-08 22:22:45', '0');

-- ----------------------------
-- Table structure for patient_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '就诊卡号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'f:男 m:女',
  `identity` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `age` int(11) NULL DEFAULT NULL,
  `phone_num` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '患者就诊信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of patient_info
-- ----------------------------
INSERT INTO `patient_info` VALUES ('1', '赵千里', 'm', '32011219880404001X', 32, '15915911159', '2020-09-08 22:26:02', '0');
INSERT INTO `patient_info` VALUES ('2', '赵宁', 'f', '32011319850413002X', 35, '15715715557', '2020-09-08 22:26:35', '0');
INSERT INTO `patient_info` VALUES ('3', '志昊', 'm', '32012220010101003X', 40, '13888888888', '2020-09-08 22:27:07', '0');

-- ----------------------------
-- Table structure for pres_details
-- ----------------------------
DROP TABLE IF EXISTS `pres_details`;
CREATE TABLE `pres_details`  (
  `drug_info_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '药品id',
  `pres_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '处方id',
  `drug_count` int(11) NULL DEFAULT NULL COMMENT '开具的数量',
  PRIMARY KEY (`drug_info_id`, `pres_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '处方详情表，关联药品信息表和处方表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pres_details
-- ----------------------------
INSERT INTO `pres_details` VALUES ('1', '100000030433', 2);
INSERT INTO `pres_details` VALUES ('1', '100000032111', 2);
INSERT INTO `pres_details` VALUES ('2', '100000030433', 1);

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `mr_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '关联的病历表',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '病情描述',
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '医嘱',
  `update_time` datetime NULL DEFAULT NULL,
  `drug_fee` double NULL DEFAULT NULL COMMENT '处方费用',
  `pres_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处方状态：0：未付款，1：暂存 2：付款 3 已发药',
  `charge_time` datetime NULL DEFAULT NULL COMMENT '付款时间',
  `receive_time` datetime NULL DEFAULT NULL COMMENT '发药时间',
  `doctor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开处方的医生id',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '处方表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES ('100000030433', '100000003145', '典型牛皮癣症状', '复方A每天两次，早晚各一次', '2020-09-08 22:31:40', 74, '0', NULL, NULL, '2', '0');
INSERT INTO `prescription` VALUES ('100000032111', '100000030326', '过敏性皮炎', '复方A每天两次，早晚各一次', '2020-09-08 22:32:12', 44, '2', '2020-09-08 22:32:32', NULL, '1', '0');

-- ----------------------------
-- Table structure for register_info
-- ----------------------------
DROP TABLE IF EXISTS `register_info`;
CREATE TABLE `register_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '采用雪花算法生成id',
  `patient_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联就诊卡号',
  `doctor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生id',
  `depart_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊科室id',
  `charge_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '挂号状态：0：未付款，1：暂存 2：付款',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员工id，如果自行操作，无',
  `register_fee` double NULL DEFAULT NULL COMMENT '挂号费用',
  `charge_time` datetime NULL DEFAULT NULL COMMENT '付款时间',
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '挂号信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of register_info
-- ----------------------------
INSERT INTO `register_info` VALUES ('100000003145', '1', '2', '1', '2', '5', 100, '2020-09-08 22:38:33', '2020-09-08 22:38:37', '0');
INSERT INTO `register_info` VALUES ('100000030326', '2', '1', '1', '2', '5', 12, '2020-09-08 22:38:35', '2020-09-08 22:38:39', '0');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employee_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联员工id',
  `update_time` datetime NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'zhangyixing', '$2a$10$/do3a/z2lWZfMEXytQTywe0b4EGp1ZLXd7RlD6EWek0ddZfLKHYJi', '1', '2020-09-08 22:24:22', '0');
INSERT INTO `user_info` VALUES ('2', 'luhan', '$2a$10$/do3a/z2lWZfMEXytQTywe0b4EGp1ZLXd7RlD6EWek0ddZfLKHYJi', '2', '2020-09-08 22:24:23', '0');
INSERT INTO `user_info` VALUES ('3', 'kriswu', '$2a$10$/do3a/z2lWZfMEXytQTywe0b4EGp1ZLXd7RlD6EWek0ddZfLKHYJi', '3', '2020-09-08 22:24:58', '0');
INSERT INTO `user_info` VALUES ('5', 'liyouyou', '$2a$10$/do3a/z2lWZfMEXytQTywe0b4EGp1ZLXd7RlD6EWek0ddZfLKHYJi', '5', '2020-09-08 22:23:32', '0');

SET FOREIGN_KEY_CHECKS = 1;
