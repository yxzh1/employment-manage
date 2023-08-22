/*
 Navicat Premium Data Transfer

 Source Server         : yuan
 Source Server Type    : MySQL
 Source Server Version : 50540 (5.5.40)
 Source Host           : localhost:3306
 Source Schema         : employee_management

 Target Server Type    : MySQL
 Target Server Version : 50540 (5.5.40)
 File Encoding         : 65001

 Date: 22/08/2023 10:18:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地址类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (101, '重庆', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `address` VALUES (102, '上海', '2022-07-22 09:08:55', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `address` VALUES (103, '深圳', '2022-07-22 10:37:37', '2022-07-22 19:41:02', 1, 0);
INSERT INTO `address` VALUES (104, '北京', '2022-07-22 19:41:37', '2022-07-26 14:47:33', 1, 0);
INSERT INTO `address` VALUES (105, '武汉', '2023-04-20 16:53:05', '2023-04-20 16:53:23', 1, 0);
INSERT INTO `address` VALUES (106, '南京', '2023-04-20 16:54:05', '2023-04-20 16:54:05', 1, 0);

-- ----------------------------
-- Table structure for depart
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES (101, '已就业', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `depart` VALUES (102, '灵活就业', '2022-07-22 09:08:55', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `depart` VALUES (103, '找工作中', '2022-07-22 10:37:37', '2022-07-22 19:41:02', 1, 0);
INSERT INTO `depart` VALUES (104, '考研', '2022-07-22 19:41:37', '2022-07-26 14:47:33', 1, 0);
INSERT INTO `depart` VALUES (105, '考公', '2022-07-24 10:32:20', '2022-07-24 10:50:43', 1, 0);
INSERT INTO `depart` VALUES (106, '自主创业', '2022-07-24 14:57:27', '2022-07-24 14:57:33', 1, 0);
INSERT INTO `depart` VALUES (107, '测试', '2023-04-20 15:28:45', '2023-04-20 15:28:45', 1, 0);

-- ----------------------------
-- Table structure for emp_intention
-- ----------------------------
DROP TABLE IF EXISTS `emp_intention`;
CREATE TABLE `emp_intention`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '就业信息ID',
  `student` int(11) NULL DEFAULT 0 COMMENT '学生',
  `enterprise_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就业单位',
  `enterprise_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位地址',
  `enterprise_type` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '就业岗位',
  `enterprise_time` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '就业时间',
  `enterprise_person` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '单位联系人',
  `enterprise_phone` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '联系人电话',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  `emp_intentiontid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emp_intention
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise_information
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_information`;
CREATE TABLE `enterprise_information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业信息ID',
  `enterprise_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `business_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业地址',
  `enterprise_industry` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业行业',
  `company_profile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业简介',
  `person_in_charge` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examine_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已通过' COMMENT '审核状态',
  `role` int(5) NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  `enterprise_usersid` int(11) NULL DEFAULT NULL,
  `enterprise_addressid` int(11) NULL DEFAULT NULL COMMENT '关联地址id',
  `enterprise_industryid` int(11) NULL DEFAULT NULL COMMENT '关联行业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of enterprise_information
-- ----------------------------
INSERT INTO `enterprise_information` VALUES (101, 'wqw', '上海', '房地产', 'xxxxx', 'xxx', '已通过', 4, '2022-07-20 20:44:01', '2023-05-26 21:07:02', 16, 0, 101, 102, 102);
INSERT INTO `enterprise_information` VALUES (102, '腾讯', '深圳', '互联网', 'xxxxx', 'xxx', '已通过', 4, '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0, 102, 103, 101);
INSERT INTO `enterprise_information` VALUES (103, '字节', '重庆', '互联网', 'xxxxx', 'xxx', '已通过', 4, '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0, 103, 101, 101);
INSERT INTO `enterprise_information` VALUES (104, '米哈游', '上海', '游戏', 'xxxxx', 'xxx', '已通过', 4, '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0, 104, 102, 105);
INSERT INTO `enterprise_information` VALUES (105, '巨能集团', '重庆', '互联网', NULL, NULL, '已通过', 4, '2023-04-15 11:20:01', '2023-04-15 11:20:01', 1, 0, NULL, 101, 101);
INSERT INTO `enterprise_information` VALUES (106, '大扫除的身份', '重庆', '互联网', NULL, NULL, '已通过', 4, '2023-04-15 12:36:40', '2023-04-15 12:36:40', 1, 0, NULL, 101, 101);
INSERT INTO `enterprise_information` VALUES (107, '黑褐色', '深圳', '房地产', NULL, NULL, '已通过', 4, '2023-04-19 13:50:31', '2023-04-19 13:50:50', 2, 0, NULL, 103, 102);

-- ----------------------------
-- Table structure for enterprise_users
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_users`;
CREATE TABLE `enterprise_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业用户ID',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `role` int(5) NULL DEFAULT NULL,
  `examine_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已通过' COMMENT '审核状态',
  `createtime` datetime NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  `enterprise_usersid` int(11) NOT NULL DEFAULT 0 COMMENT '关联enterprise_information表id',
  `enterprise_addressid` int(11) NULL DEFAULT NULL COMMENT '关联地址id',
  `enterprise_industryid` int(11) NULL DEFAULT NULL COMMENT '关联行业id',
  `enterprise_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of enterprise_users
-- ----------------------------
INSERT INTO `enterprise_users` VALUES (1, '田深元', '123456', 25, 1, '74185296310', '1977-05-22', 4, '已通过', '2022-07-22 09:08:55', '2023-05-26 21:07:02', 19, 0, 101, 102, 102, 'wqw');
INSERT INTO `enterprise_users` VALUES (2, '邓元良', '123456', 24, 1, '5552355555', '1978-07-16', 4, '已通过', '2022-07-22 16:57:57', '2022-07-24 14:54:09', 1, 0, 102, 101, 102, '万客');
INSERT INTO `enterprise_users` VALUES (3, '田六', '123456', 21, 1, '1112221111', '1988-07-16', 4, '已通过', '2022-07-22 19:36:50', '2022-07-23 11:01:42', 1, 0, 103, 102, 102, '易额');
INSERT INTO `enterprise_users` VALUES (4, 'ytr', '123456', 23, 1, '44555544444', '1986-07-16', 4, '已通过', '2022-07-23 10:45:24', '2022-07-24 16:17:24', 1, 0, 104, 101, 101, '世纪');
INSERT INTO `enterprise_users` VALUES (5, '贾阔', 'asdfg', 22, 0, '13124131314', NULL, 4, '已通过', '2023-04-14 01:21:14', '2023-04-14 01:21:14', 1, 0, 105, 101, 101, '天涯集团');
INSERT INTO `enterprise_users` VALUES (6, '爱丽丝', '123456', 22, 0, '13668131314', NULL, 4, '已通过', '2023-04-15 11:20:02', '2023-04-15 11:20:02', 1, 0, 105, 101, 101, '巨能集团');
INSERT INTO `enterprise_users` VALUES (7, '维生素', 'ujmikol', 56, 1, '13124243014', NULL, 4, '已通过', '2023-04-15 12:36:40', '2023-04-15 12:36:40', 1, 0, 106, 101, 101, '大扫除的身份');
INSERT INTO `enterprise_users` VALUES (8, '函数事', 'qwert', 37, 1, '13746531314', NULL, 4, '已通过', '2023-04-19 13:50:31', '2023-04-19 13:50:50', 2, 0, 107, 103, 102, '黑褐色');

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '行业类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of industry
-- ----------------------------
INSERT INTO `industry` VALUES (101, '互联网', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `industry` VALUES (102, '房地产', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `industry` VALUES (103, '医疗', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `industry` VALUES (104, '金融', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `industry` VALUES (105, '游戏', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `industry` VALUES (106, '教育培训', '2022-07-20 20:44:01', '2022-07-22 19:25:09', 1, 0);
INSERT INTO `industry` VALUES (107, '健身', '2023-04-20 17:16:36', '2023-04-20 17:21:21', 2, 0);

-- ----------------------------
-- Table structure for interview_information
-- ----------------------------
DROP TABLE IF EXISTS `interview_information`;
CREATE TABLE `interview_information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '面试信息ID',
  `student` int(11) NULL DEFAULT 0 COMMENT '学生',
  `enterprise_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `enterprise_industry` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业行业',
  `person_in_charge` int(11) NULL DEFAULT 0 COMMENT '负责人',
  `invitation_information` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '邀请信息',
  `examine_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已通过' COMMENT '审核状态',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  `studentid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of interview_information
-- ----------------------------

-- ----------------------------
-- Table structure for notice_announcement
-- ----------------------------
DROP TABLE IF EXISTS `notice_announcement`;
CREATE TABLE `notice_announcement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知公告ID',
  `announcement_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `announcement_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告编号',
  `release_time` date NULL DEFAULT NULL COMMENT '发布时间',
  `announcement_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `examine_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已通过' COMMENT '审核状态',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice_announcement
-- ----------------------------

-- ----------------------------
-- Table structure for recruitment_information
-- ----------------------------
DROP TABLE IF EXISTS `recruitment_information`;
CREATE TABLE `recruitment_information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '招聘信息ID',
  `enterprise_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `business_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业地址',
  `enterprise_industry` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业行业',
  `phone` int(11) NULL DEFAULT NULL COMMENT '联系电话',
  `person_in_charge` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '负责人',
  `company_profile` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业简介',
  `professional_requirements` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业要求',
  `educational_requirements` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历要求',
  `age_requirements` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄要求',
  `recruitment_occupation` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '招聘职业',
  `compensation_and_benefits` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '薪酬福利',
  `character` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性格',
  `graduation_school_requirements` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业学校要求',
  `certificate_requirements` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书要求',
  `occupational_category` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业类别',
  `type_of_work` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作类型',
  `working_province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作省份',
  `working_years` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作年限',
  `a_monthly_salary` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月薪',
  `is_it_wrapped` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否包住',
  `working_hours` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作时间',
  `job_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '职业描述',
  `hits` int(11) NOT NULL DEFAULT 0 COMMENT '点击数',
  `examine_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已通过' COMMENT '审核状态',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  `reid` int(11) NULL DEFAULT NULL COMMENT '关联enterpri_users表id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '招聘信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of recruitment_information
-- ----------------------------
INSERT INTO `recruitment_information` VALUES (1, 'wqw', NULL, NULL, NULL, '田深元', NULL, '计算机类', '本科', NULL, 'AI训练师', '3000-4200', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2022-07-22 09:08:55', '2023-05-26 16:05:07', 8, 0, 1);
INSERT INTO `recruitment_information` VALUES (2, '万客', NULL, NULL, NULL, '邓元良', NULL, '不限', '大专以上', NULL, '客服', '3500-5000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2022-07-22 16:57:57', '2023-04-25 11:20:37', 1, 0, 2);
INSERT INTO `recruitment_information` VALUES (3, '易额', NULL, NULL, NULL, '田七', NULL, '计算机类', '本科', NULL, 'Java开发', '6000-7000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2022-07-22 19:36:50', '2023-04-25 11:20:37', 1, 0, 3);
INSERT INTO `recruitment_information` VALUES (4, '腾讯', NULL, NULL, NULL, 'ytr', NULL, '计算机科学与技术', '本科', NULL, 'Java工程师', '5000-6000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-04-25 01:46:47', '2023-04-25 11:20:37', 1, 0, 8);
INSERT INTO `recruitment_information` VALUES (5, '巨能集团', NULL, NULL, NULL, '爱丽丝', NULL, '软件工程', '本科', NULL, 'AI训练师', '3000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-04-25 10:20:57', '2023-04-27 16:49:37', 11, 0, 6);
INSERT INTO `recruitment_information` VALUES (7, '蛇皮集团', NULL, NULL, NULL, '李华', NULL, '英语', '本科', NULL, '翻译助理', '8000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-04-25 11:50:00', '2023-04-25 11:50:00', 1, 0, 8);
INSERT INTO `recruitment_information` VALUES (8, '巨能集团', NULL, NULL, NULL, '爱丽丝', NULL, '不限', '本科', NULL, '行政助理', '4500', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-04-27 16:56:01', '2023-04-27 16:56:01', 1, 0, 6);
INSERT INTO `recruitment_information` VALUES (9, '神盾1', NULL, NULL, NULL, '田六', NULL, '计算机科学与技术', '本科', NULL, 'JAVA工程师', '3000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-05-26 19:52:01', '2023-05-26 19:52:12', 2, 1, 2);
INSERT INTO `recruitment_information` VALUES (10, '二万五千', NULL, NULL, NULL, '田深元', NULL, '不限', '本科', NULL, 'JAVA工程师2额', '5000-6000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-05-26 19:54:15', '2023-05-26 19:54:28', 2, 0, 1);
INSERT INTO `recruitment_information` VALUES (11, 'whz', NULL, NULL, NULL, '田深元', NULL, '计算机科学与技术', '本科', NULL, 'JAVAdsfs', '3000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-05-26 20:59:35', '2023-05-26 20:59:43', 2, 1, 1);
INSERT INTO `recruitment_information` VALUES (12, 'wqw', NULL, NULL, NULL, '田深元', NULL, '不限', '本科', NULL, 'JAVA工程师', '4230', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '已通过', '2023-05-26 21:05:31', '2023-05-26 21:05:45', 2, 1, 1);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, '管理员', 'emp:*,dep:*,role:*,etp:*,address:*,industry:*,sch:*,zpx:*,admin:list');
INSERT INTO `roles` VALUES (2, '辅导员', 'emp:*,etp:*,zpx:*,admin:list,dep:*,address:*,industry:*,sch:list,sch:toUpdate,sch:update');
INSERT INTO `roles` VALUES (3, '学生', 'emp:list,emp:toUpdate,emp:update,zpx:list');
INSERT INTO `roles` VALUES (4, '企业', 'etp:list,etp:toUpdate,etp:update,zpx:list,zpx:toAdd,zpx:toUpdate,zpx:update,zpx:delete,zpx:upload');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `major` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `nation` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `education` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `graduation_school` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业学校',
  `id_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `awards` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '获奖情况',
  `employment_intention` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就业意向',
  `social_practice` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '社会实践',
  `examine_state` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '已通过' COMMENT '审核状态',
  `role` int(5) NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  `studentid` int(11) NOT NULL DEFAULT 0 COMMENT '关联depart就业类型id',
  `enterprise_usersid` int(11) NOT NULL COMMENT '关联enterprise_information表id',
  `enterprise_addressid` int(11) NULL DEFAULT NULL COMMENT '关联地址id',
  `enterprise_industryid` int(11) NULL DEFAULT NULL COMMENT '关联行业id',
  `enterprise_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (3, '林思雨', '123456', 23, 0, '12345678910', '1999-08-18', '英语', '', '', '', '', '', '已就业', '', '已通过', 3, '2022-07-20 20:40:20', '2023-05-26 21:08:49', 5, 0, 101, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (4, '周若芳', '123456', 26, 0, '74185296310', '1997-05-22', '软件工程', '', '', '', '', '', '已就业', '', '已通过', 3, '2022-07-22 09:08:55', '2023-04-20 15:29:12', 4, 0, 107, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (5, '罗安国', '123456', 24, 1, '55555555555', '1998-07-16', '计算机科学与技术', '', '', '', '', '', '已就业', '', '已通过', 3, '2022-07-22 16:57:57', '2022-07-24 14:54:09', 3, 0, 102, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (6, '田七', '123456', 21, 1, '11111111111', '1998-07-16', '计算机科学与技术', '', '', '', '', '', '已就业', '', '已通过', 3, '2022-07-22 19:36:50', '2022-07-23 11:01:42', 3, 0, 103, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (7, 'summer', '123456', 23, 1, '44444444444', '1998-07-16', '英语', '', '', '', '', '', '未就业', '', '已通过', 3, '2022-07-23 10:45:24', '2022-07-24 16:17:24', 16, 0, 105, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (8, '张三', '123456', 20, 0, '12345678910', '2022-01-16', '数字媒体技术', '', '', '', '', '', '未就业', '', '已通过', 3, '2022-07-23 10:58:25', '2022-07-24 10:15:01', 8, 0, 101, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (9, '刘二', '123456', 25, 0, '33333333333', '1997-10-20', '软件工程', '', '', '', '', '', '未就业', '', '已通过', 3, '2022-07-23 11:00:29', '2022-07-24 14:53:52', 2, 0, 102, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (10, '郑一', '123456', 23, 0, '11111111111', '2000-12-25', '软件工程', '', '', '', '', '', '已就业', '', '已通过', 3, '2022-07-23 11:01:22', '2023-04-25 14:23:50', 2, 0, 103, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (11, '马九', '123456', 24, 0, '12345678910', '1998-04-19', '软件工程', '', '', '', '', '', '已就业', '', '已通过', 3, '2022-07-23 11:02:27', '2022-07-26 14:44:20', 9, 0, 105, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (13, '孔十', '123456', 23, 1, '11111111111', '1999-11-14', '软件工程', '', '', '', '', '', '未就业', '', '已通过', 3, '2022-07-24 10:31:08', '2022-07-24 14:52:22', 3, 0, 106, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (16, '董十一', '123456', 25, 0, '22222222222', '1997-06-16', '数字媒体技术', '', '', '', '', '', '未就业', '', '已通过', 3, '2022-07-24 14:53:33', '2022-07-26 15:00:43', 3, 0, 101, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (17, '孙十二', '123456', 20, 0, '77777777777', '2022-01-01', '数字媒体技术', '', '', '', '', '', '未就业', '', '已通过', 3, '2022-07-24 14:55:39', '2022-07-24 14:55:39', 1, 0, 101, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (18, '车瑜理', '123456', 22, 0, '88888888888', '2000-03-15', '财务管理', '', '', '', '', '', '未就业', '', '已通过', 3, '2022-07-24 14:56:40', '2022-07-24 14:56:40', 1, 0, 102, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (19, '罗椅行五', '123', 22, 1, '1311313131', '1999-10-10', '数据科学与大数据技术', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '已通过', 3, '2023-04-09 22:48:57', '2023-04-09 22:48:57', 1, 0, 103, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (20, '张丽', 'qwert', 22, 0, '13113131314', '1999-10-10', '数据科学与大数据技术', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '已通过', 3, '2023-04-14 00:03:14', '2023-04-14 00:03:14', 1, 0, 101, 0, NULL, NULL, NULL);
INSERT INTO `students` VALUES (21, '舒兴', 'asdfg', 22, 0, '13654131314', '2001-02-10', '数据科学与大数据技术', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '已通过', 3, '2023-04-14 00:37:03', '2023-04-14 00:37:03', 1, 0, 103, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `major` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(5) NULL DEFAULT NULL,
  `teacherid` int(11) NULL DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 1,
  `deleted` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES (1, 'admin', '123456', 26, 1, '软件工程', 1, NULL, '15603861638', NULL, '2022-07-22 09:08:55', '2023-04-20 15:29:12', 1, 0);
INSERT INTO `teachers` VALUES (2, '王有才', '123456', 28, 1, '计算机科学与技术', 2, NULL, '18297643153', NULL, '2022-07-22 09:08:55', '2023-04-20 15:29:12', 1, 0);
INSERT INTO `teachers` VALUES (3, '罗椅行', '123456', 23, 0, '软件工程', 2, NULL, '19286119934', NULL, '2023-04-23 22:44:56', '2023-04-26 18:19:47', 3, 0);
INSERT INTO `teachers` VALUES (4, '李长青', '123456', 26, 1, '数据科学与大数据技术', 2, NULL, '15083415055', NULL, '2023-04-23 22:44:56', '2023-04-26 18:19:47', 1, 0);
INSERT INTO `teachers` VALUES (5, '罗说', '1234567211', 23221, 1, '软件工程', 2, NULL, '18323523899', NULL, '2023-05-26 19:53:12', '2023-05-26 19:53:28', 2, 1);
INSERT INTO `teachers` VALUES (6, 'koin', '123', 24, 1, '软件工程', 3, NULL, '13124131314', NULL, '2023-05-26 21:00:18', '2023-05-26 21:00:24', 2, 1);
INSERT INTO `teachers` VALUES (7, '袁紫雄', '123456', 24, 1, '软件工程', 2, NULL, '19112869934', NULL, '2023-05-26 21:06:21', '2023-05-26 21:06:27', 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
