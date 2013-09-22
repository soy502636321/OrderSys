/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50171
Source Host           : localhost:3306
Source Database       : order

Target Server Type    : MYSQL
Target Server Version : 50171
File Encoding         : 65001

Date: 2013-09-23 07:54:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `base_language`
-- ----------------------------
DROP TABLE IF EXISTS `base_language`;
CREATE TABLE `base_language` (
  `LANGUAGE_PID` varchar(50) NOT NULL,
  `LANGUAGE_NAME` varchar(100) DEFAULT NULL,
  `REMARK` longtext,
  PRIMARY KEY (`LANGUAGE_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_language
-- ----------------------------
INSERT INTO `base_language` VALUES ('ff80808140fcf97f0140fcf993110001', '中文', '中文');
INSERT INTO `base_language` VALUES ('ff80808140fcfa350140fcfa475d0001', '英文', '英文');

-- ----------------------------
-- Table structure for `base_master_file`
-- ----------------------------
DROP TABLE IF EXISTS `base_master_file`;
CREATE TABLE `base_master_file` (
  `MASTER_FILE_PID` varchar(50) NOT NULL,
  `MASTER_FILE_NAME` longtext,
  `MASTER_FILE_SIZE` bigint(20) DEFAULT NULL,
  `MASTER_FILE_LOCATION` longtext,
  `ORDER_PID` varchar(50) DEFAULT NULL,
  `OPER_TIME` date DEFAULT NULL,
  `DOWNLOAD_SIZE` bigint(20) DEFAULT NULL,
  `OPER_USER_PID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MASTER_FILE_PID`),
  KEY `FK224FE0CB1A374D98` (`ORDER_PID`),
  KEY `FK224FE0CB469B0283` (`OPER_USER_PID`),
  CONSTRAINT `FK224FE0CB1A374D98` FOREIGN KEY (`ORDER_PID`) REFERENCES `sys_order` (`ORDER_PID`),
  CONSTRAINT `FK224FE0CB469B0283` FOREIGN KEY (`OPER_USER_PID`) REFERENCES `sys_user` (`USER_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_master_file
-- ----------------------------
INSERT INTO `base_master_file` VALUES ('ff80808140fd190b0140fd191f3d0001', '测试文件.txt', '400', '电脑中', 'ff80808140fc7ed30140fc7ee7040001', '2013-09-17', '0', 'admin');

-- ----------------------------
-- Table structure for `base_organ`
-- ----------------------------
DROP TABLE IF EXISTS `base_organ`;
CREATE TABLE `base_organ` (
  `BASE_ORGAN_PID` varchar(50) NOT NULL,
  `ORGAN_NAME` varchar(50) DEFAULT NULL,
  `PRINCIPAL` varchar(50) DEFAULT NULL,
  `ORGAN_TEL` varchar(50) DEFAULT NULL,
  `ORGAN_FAX` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ORGAN_TYPE` varchar(50) DEFAULT NULL,
  `OPER_FRE` varchar(30) DEFAULT NULL,
  `CUST_FRE` varchar(30) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `PARENT_PID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BASE_ORGAN_PID`),
  KEY `FK36FADB037F0A0DD9` (`PARENT_PID`),
  CONSTRAINT `FK36FADB037F0A0DD9` FOREIGN KEY (`PARENT_PID`) REFERENCES `base_organ` (`BASE_ORGAN_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_organ
-- ----------------------------

-- ----------------------------
-- Table structure for `base_translated_file`
-- ----------------------------
DROP TABLE IF EXISTS `base_translated_file`;
CREATE TABLE `base_translated_file` (
  `TRANSLATED_FILE_PID` varchar(50) NOT NULL,
  `TRANSLATED_FILE_NAME` longtext,
  `TRANSLATED_FILE_SIZE` bigint(20) DEFAULT NULL,
  `TRANSLATED_FILE_LOCATION` longtext,
  `ORDER_PID` varchar(50) DEFAULT NULL,
  `FEEDBACK_PID` varchar(50) DEFAULT NULL,
  `OPER_TIME` date DEFAULT NULL,
  `DOWNLOAD_SIZE` bigint(20) DEFAULT NULL,
  `OPER_USER_PID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TRANSLATED_FILE_PID`),
  KEY `FK1D4AA9D71A374D98` (`ORDER_PID`),
  KEY `FK1D4AA9D7D5836A26` (`FEEDBACK_PID`),
  KEY `FK1D4AA9D7469B0283` (`OPER_USER_PID`),
  CONSTRAINT `FK1D4AA9D71A374D98` FOREIGN KEY (`ORDER_PID`) REFERENCES `sys_order` (`ORDER_PID`),
  CONSTRAINT `FK1D4AA9D7469B0283` FOREIGN KEY (`OPER_USER_PID`) REFERENCES `sys_user` (`USER_PID`),
  CONSTRAINT `FK1D4AA9D7D5836A26` FOREIGN KEY (`FEEDBACK_PID`) REFERENCES `sys_feedback` (`FEEDBACK_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_translated_file
-- ----------------------------

-- ----------------------------
-- Table structure for `config_sysfeedback_state`
-- ----------------------------
DROP TABLE IF EXISTS `config_sysfeedback_state`;
CREATE TABLE `config_sysfeedback_state` (
  `STATE_PID` varchar(50) NOT NULL,
  `STATE_NAME` varchar(100) DEFAULT NULL,
  `REMARK` longtext,
  PRIMARY KEY (`STATE_PID`),
  UNIQUE KEY `STATE_NAME` (`STATE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config_sysfeedback_state
-- ----------------------------
INSERT INTO `config_sysfeedback_state` VALUES ('8a80c97b4120a826014120a83cc30001', '新反馈', '客户增加，还未被业务员接受');
INSERT INTO `config_sysfeedback_state` VALUES ('8a80c97b4120a8b6014120a8cc410001', '处理中', '业务员接受，正在处理');
INSERT INTO `config_sysfeedback_state` VALUES ('8a80c97b4120aa73014120aa8c600001', '处理完', '业务员已经处理完成该反馈');

-- ----------------------------
-- Table structure for `config_sysorder_state`
-- ----------------------------
DROP TABLE IF EXISTS `config_sysorder_state`;
CREATE TABLE `config_sysorder_state` (
  `STATE_PID` varchar(50) NOT NULL,
  `STATE_NAME` varchar(150) DEFAULT NULL,
  `REMARK` longtext,
  PRIMARY KEY (`STATE_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config_sysorder_state
-- ----------------------------
INSERT INTO `config_sysorder_state` VALUES ('ff80808140fc325f0140fc3271290001', '新订单', '用户刚下单，还未被业务员接收的订单状态');
INSERT INTO `config_sysorder_state` VALUES ('ff80808140fc35f00140fc3600d80001', '已接受', '已被业务员接受，但是还未成交的订单状态');
INSERT INTO `config_sysorder_state` VALUES ('ff80808140fc38580140fc38694d0001', '已成交', '已成交的订单，但是还未完成');
INSERT INTO `config_sysorder_state` VALUES ('ff80808140fc3a780140fc3a88c20001', '已完成', '订单已经完成');
INSERT INTO `config_sysorder_state` VALUES ('ff80808140fc3b0d0140fc3b1e5a0001', '已作废', '订单已经作废');

-- ----------------------------
-- Table structure for `section_function`
-- ----------------------------
DROP TABLE IF EXISTS `section_function`;
CREATE TABLE `section_function` (
  `SECTION_PID` varchar(50) NOT NULL,
  `FUNCTION_PID` varchar(50) NOT NULL,
  PRIMARY KEY (`SECTION_PID`,`FUNCTION_PID`),
  KEY `FKC23C032D3D70D46` (`SECTION_PID`),
  KEY `FKC23C0328D84194C` (`FUNCTION_PID`),
  CONSTRAINT `FKC23C0328D84194C` FOREIGN KEY (`FUNCTION_PID`) REFERENCES `sys_function` (`FUNCTION_PID`),
  CONSTRAINT `FKC23C032D3D70D46` FOREIGN KEY (`SECTION_PID`) REFERENCES `sys_section` (`SECTION_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of section_function
-- ----------------------------

-- ----------------------------
-- Table structure for `section_organ`
-- ----------------------------
DROP TABLE IF EXISTS `section_organ`;
CREATE TABLE `section_organ` (
  `SECTION_PID` varchar(50) NOT NULL,
  `BASE_ORGAN_PID` varchar(50) NOT NULL,
  PRIMARY KEY (`SECTION_PID`,`BASE_ORGAN_PID`),
  KEY `FKDF9633F7D3D70D46` (`SECTION_PID`),
  KEY `FKDF9633F7BEC4FBD2` (`BASE_ORGAN_PID`),
  CONSTRAINT `FKDF9633F7BEC4FBD2` FOREIGN KEY (`BASE_ORGAN_PID`) REFERENCES `base_organ` (`BASE_ORGAN_PID`),
  CONSTRAINT `FKDF9633F7D3D70D46` FOREIGN KEY (`SECTION_PID`) REFERENCES `sys_section` (`SECTION_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of section_organ
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `sys_feedback`;
CREATE TABLE `sys_feedback` (
  `FEEDBACK_PID` varchar(50) NOT NULL,
  `ORDER_PID` varchar(50) DEFAULT NULL,
  `STATE_PID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FEEDBACK_PID`),
  KEY `FK9E8B7CD71A374D98` (`ORDER_PID`),
  KEY `FK9E8B7CD7592CDFBB` (`STATE_PID`),
  CONSTRAINT `FK9E8B7CD71A374D98` FOREIGN KEY (`ORDER_PID`) REFERENCES `sys_order` (`ORDER_PID`),
  CONSTRAINT `FK9E8B7CD7592CDFBB` FOREIGN KEY (`STATE_PID`) REFERENCES `config_sysfeedback_state` (`STATE_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_feedback
-- ----------------------------
INSERT INTO `sys_feedback` VALUES ('8a80c97b41219b290141219b4e970001', '8a80cd8e40fd2c8d0140fd2ca3170001', '8a80c97b4120a826014120a83cc30001');
INSERT INTO `sys_feedback` VALUES ('8a80cf0f413e4a7b01413e4aa7330001', '8a80cd8e40fd2c8d0140fd2ca3170001', '8a80c97b4120a8b6014120a8cc410001');
INSERT INTO `sys_feedback` VALUES ('8a80cf0f413e4b1601413e4b2fbc0001', '8a80cd8e40fd2c8d0140fd2ca3170001', '8a80c97b4120aa73014120aa8c600001');

-- ----------------------------
-- Table structure for `sys_function`
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `FUNCTION_PID` varchar(50) NOT NULL,
  `FUNCTION_NAME` varchar(50) DEFAULT NULL,
  `FUNCTION_URL` varchar(100) DEFAULT NULL,
  `FUNCTION_TYPE` varchar(10) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `PARENT_PID` varchar(50) DEFAULT NULL,
  `OPER_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`FUNCTION_PID`),
  KEY `FKFC45052A8B84F51E` (`PARENT_PID`),
  CONSTRAINT `FKFC45052A8B84F51E` FOREIGN KEY (`PARENT_PID`) REFERENCES `sys_function` (`FUNCTION_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_function
-- ----------------------------
INSERT INTO `sys_function` VALUES ('8a80c97b411f856e01411f8582eb0001', '系统管理', null, '01', '系统管理', null, '2013-09-22 10:53:13');
INSERT INTO `sys_function` VALUES ('8a80c97b411f8a4901411f8a5cdd0001', '用户管理', '/system/sysUserAction!query', '01', '系统管理》用户管理', '8a80c97b411f856e01411f8582eb0001', '2013-09-22 11:10:17');
INSERT INTO `sys_function` VALUES ('8a80c97b411f8ac601411f8ade130001', '语种管理', '/system/baseLanguageAction!query', '01', '系统管理》语种管理', '8a80c97b411f856e01411f8582eb0001', '2013-09-22 11:10:21');
INSERT INTO `sys_function` VALUES ('8a80c97b4120bee5014120befc9d0001', '反馈管理', null, '01', '反馈管理', null, '2013-09-15 16:32:26');
INSERT INTO `sys_function` VALUES ('8a80c97b4120c105014120c11c700001', '新反馈', '/sysFeedback/publicInitateSysFeedbackAction!query', '01', '反馈管理》新反馈', '8a80c97b4120bee5014120befc9d0001', '2013-09-23 16:35:25');
INSERT INTO `sys_function` VALUES ('8a80c97b4120c1a5014120c1bbfc0001', '处理中', '/sysFeedback/publicHandleSysFeedbackAction!query', '01', '反馈管理》处理中', '8a80c97b4120bee5014120befc9d0001', '2013-09-24 16:35:29');
INSERT INTO `sys_function` VALUES ('8a80c97b4120c22c014120c2431d0001', '处理完', '/sysFeedback/publicCompleteSysFeedbackAction!query', '01', '反馈管理》处理完', '8a80c97b4120bee5014120befc9d0001', '2013-09-25 16:35:32');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd36f50140fd3708870001', '已成交', '/sysOrder/publicTurnoverSysOrderAction!query', '01', '订单管理》已成交', 'ff80808140fbdead0140fbdebe480001', '2013-09-10 19:05:48');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd4aa90140fd4abe7c0001', '已完成', '/sysOrder/publicCompleteSysOrderAction!query', '01', '订单管理》已完成', 'ff80808140fbdead0140fbdebe480001', '2013-09-11 19:18:01');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd523c0140fd5251060001', '已作废', '/sysOrder/publicCancelSysOrderAction!query', '01', '订单管理》已作废', 'ff80808140fbdead0140fbdebe480001', '2013-09-12 19:26:19');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd569a0140fd56ad9a0001', '订单查看', null, '01', '订单查看', null, '2013-09-18 19:33:54');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd58e50140fd58f8d20001', '新订单', '/sysOrder/privateInitateSysOrderAction!query', '01', '订单查看》新订单', '8a80cd8e40fd569a0140fd56ad9a0001', '2013-09-15 19:33:36');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd657e0140fd65920a0001', '已接受', '/sysOrder/privateAcceptSysOrderAction!query', '01', '订单查看》已接受', '8a80cd8e40fd569a0140fd56ad9a0001', '2013-09-16 19:47:20');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd6c580140fd6c6c8e0001', '已成交', '/sysOrder/privateTurnoverSysOrderAction!query', '01', '订单查看》已成交', '8a80cd8e40fd569a0140fd56ad9a0001', '2013-09-17 20:00:17');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd71240140fd7137da0001', '已完成', '/sysOrder/privateCompleteSysOrderAction!query', '01', '订单查看》已完成', '8a80cd8e40fd569a0140fd56ad9a0001', '2013-09-18 20:00:25');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd78fc0140fd7910370001', '已作废', '/sysOrder/privateCancelSysOrderAction!query', '01', '订单查看》已作废', '8a80cd8e40fd569a0140fd56ad9a0001', '2013-09-19 20:08:49');
INSERT INTO `sys_function` VALUES ('8a80cd8e40fd7e410140fd7e54f80001', '查看指示', 'publicInitateSysOrderAction!findSysShow', '02', '订单管理》新订单》查看指示', 'ff80808140fc52030140fc5215420001', '2013-09-22 11:10:29');
INSERT INTO `sys_function` VALUES ('8a80cf0f413ea24301413ea25dba0001', '接受订单', 'publicInitateSysOrderAction!acceptSysOrder', '02', '订单管理》新订单》接受订单', 'ff80808140fc52030140fc5215420001', '2013-09-19 18:13:21');
INSERT INTO `sys_function` VALUES ('8a80cf0f413ea4ae01413ea4c7770001', '查看原文', 'publicInitateSysOrderAction!queryBaseMasterFile', '02', '订单管理》新订单》查看原文', 'ff80808140fc52030140fc5215420001', '2013-09-19 18:13:26');
INSERT INTO `sys_function` VALUES ('8a80cf0f413ea74301413ea75efa0001', '查看订单', 'publicInitateSysOrderAction!findSysOrder', '02', '订单管理》新订单》查看订单', 'ff80808140fc52030140fc5215420001', '2013-09-12 18:13:30');
INSERT INTO `sys_function` VALUES ('8a80cf0f413ffb8901413ffba4980001', '查看订单', 'publicAcceptSysOrderAction!acceptSysOrder', '02', '订单管理》已接受》查看订单', 'ff80808140fd20c80140fd20dada0001', '2013-09-26 18:13:38');
INSERT INTO `sys_function` VALUES ('8a80cf0f413ffe9a01413ffeb41b0001', '查看指示', 'publicAcceptSysOrderAction!findSysShow', '02', '订单管理》已接受》查看指示', 'ff80808140fd20c80140fd20dada0001', '2013-09-27 18:13:41');
INSERT INTO `sys_function` VALUES ('8a80cf0f41400102014140011a3d0001', '订单成交', 'publicAcceptSysOrderAction!turnoverSysOrder', '02', '订单管理》已接受》订单成交', 'ff80808140fd20c80140fd20dada0001', '2013-09-27 18:13:43');
INSERT INTO `sys_function` VALUES ('8a80cf0f414001a401414001bde00001', '作废订单', 'publicAcceptSysOrderAction!cancelSysOrder', '02', '订单管理》已接受》作废订单', 'ff80808140fd20c80140fd20dada0001', '2013-09-27 18:13:46');
INSERT INTO `sys_function` VALUES ('8a80cf0f414002120141400229aa0001', '查看原文', 'publicAcceptSysOrderAction!queryBaseMasterFile', '02', '订单管理》已接受》查看原文', 'ff80808140fd20c80140fd20dada0001', '2013-09-27 18:13:49');
INSERT INTO `sys_function` VALUES ('8a80cf0f41400a350141400a4c5e0001', '查看原文', 'publicTurnoverSysOrderAction!queryBaseMasterFile', '02', '订单管理》已成交》查看原文', '8a80cd8e40fd36f50140fd3708870001', null);
INSERT INTO `sys_function` VALUES ('8a80cf0f41400c5e0141400c75a60001', '查看订单', 'publicTurnoverSysOrderAction!findSysOrder', '02', '订单管理》已成交》查看订单', '8a80cd8e40fd36f50140fd3708870001', '2013-09-21 18:24:20');
INSERT INTO `sys_function` VALUES ('8a80cf0f41400e4e0141400e665a0001', '查看指示', 'publicTurnoverSysOrderAction!findSysShow', '02', '订单管理》已成交》查看指示', '8a80cd8e40fd36f50140fd3708870001', '2013-09-21 18:26:27');
INSERT INTO `sys_function` VALUES ('8a80cf0f41400f1e0141400f36ca0001', '订单完成', 'publicTurnoverSysOrderAction!completeSysOrder', '02', '订单管理》已成交》订单完成', '8a80cd8e40fd36f50140fd3708870001', '2013-09-21 18:27:20');
INSERT INTO `sys_function` VALUES ('8a80cf0f41402271014140228b080001', '查看订单', 'publicCompleteSysOrderAction!findSysOrder', '02', '订单管理》已完成》查看订单', '8a80cd8e40fd4aa90140fd4abe7c0001', '2013-09-21 18:48:27');
INSERT INTO `sys_function` VALUES ('8a80cf0f414022c101414022d8ca0001', '查看指示', 'publicCompleteSysOrderAction!findSysShow', '02', '订单管理》已完成》查看指示', '8a80cd8e40fd4aa90140fd4abe7c0001', '2013-09-21 18:48:47');
INSERT INTO `sys_function` VALUES ('8a80cf0f4140234f01414023674e0001', '查看原文', 'publicCompleteSysOrderAction!queryBaseMasterFile', '02', '订单管理》已完成》查看原文', '8a80cd8e40fd4aa90140fd4abe7c0001', '2013-09-21 18:49:24');
INSERT INTO `sys_function` VALUES ('8a80cf0f41402573014140258c9f0001', '查看订单', 'publicCancelSysOrderAction!findSysOrder', '02', '订单管理》已作废》查看订单', '8a80cd8e40fd523c0140fd5251060001', '2013-09-21 18:51:44');
INSERT INTO `sys_function` VALUES ('8a80cf0f414025d001414025e84c0001', '查看指示', 'publicCancelSysOrderAction!findSysShow', '02', '订单管理》已作废》查看指示', '8a80cd8e40fd523c0140fd5251060001', '2013-09-21 18:52:08');
INSERT INTO `sys_function` VALUES ('8a80cf0f41402620014140263ab20001', '恢复订单', 'publicCancelSysOrderAction!initateSysOrder', '02', '订单管理》已作废》恢复订单', '8a80cd8e40fd523c0140fd5251060001', '2013-09-21 18:52:29');
INSERT INTO `sys_function` VALUES ('8a80cf0f41402663014140267b740001', '查看原文', 'publicCancelSysOrderAction!queryBaseMasterFile', '02', '订单管理》已作废》查看原文', '8a80cd8e40fd523c0140fd5251060001', '2013-09-21 18:52:45');
INSERT INTO `sys_function` VALUES ('ff80808140fbdead0140fbdebe480001', '订单管理', '', '01', '订单管理', null, '2013-09-13 19:31:09');
INSERT INTO `sys_function` VALUES ('ff80808140fc52030140fc5215420001', '新订单', '/sysOrder/publicInitateSysOrderAction!query', '01', '订单管理》新订单', 'ff80808140fbdead0140fbdebe480001', '2013-09-08 19:05:40');
INSERT INTO `sys_function` VALUES ('ff80808140fd20c80140fd20dada0001', '已接受', '/sysOrder/publicAcceptSysOrderAction!query', '01', '订单管理》已接受', 'ff80808140fbdead0140fbdebe480001', '2013-09-09 19:05:44');
INSERT INTO `sys_function` VALUES ('ff808081413f895a01413f8978820001', '作废订单', 'publicInitateSysOrderAction!cancelSysOrder', '02', '订单管理》新订单》作废订单', 'ff80808140fc52030140fc5215420001', null);

-- ----------------------------
-- Table structure for `sys_order`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `ORDER_PID` varchar(50) NOT NULL,
  `ORDER_STATE_PID` varchar(50) DEFAULT NULL,
  `ORDER_NO` varchar(255) DEFAULT NULL,
  `OPER_TIME` datetime DEFAULT NULL,
  `OPER_USER_PID` varchar(50) DEFAULT NULL,
  `START_LANGUAGE_PID` varchar(50) DEFAULT NULL,
  `END_LANGUAGE_PID` varchar(50) DEFAULT NULL,
  `SUBMIT_TIME` datetime DEFAULT NULL,
  `SHOW_PID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ORDER_PID`),
  UNIQUE KEY `ORDER_NO` (`ORDER_NO`),
  UNIQUE KEY `SHOW_PID` (`SHOW_PID`),
  KEY `FKFCB9BF1CEEF1057D` (`ORDER_STATE_PID`),
  KEY `FKFCB9BF1C469B0283` (`OPER_USER_PID`),
  KEY `FKFCB9BF1CBF63E7CE` (`END_LANGUAGE_PID`),
  KEY `FKFCB9BF1C98E7DFA7` (`START_LANGUAGE_PID`),
  KEY `FKFCB9BF1CED6DB516` (`SHOW_PID`),
  CONSTRAINT `FKFCB9BF1C469B0283` FOREIGN KEY (`OPER_USER_PID`) REFERENCES `sys_user` (`USER_PID`),
  CONSTRAINT `FKFCB9BF1C98E7DFA7` FOREIGN KEY (`START_LANGUAGE_PID`) REFERENCES `base_language` (`LANGUAGE_PID`),
  CONSTRAINT `FKFCB9BF1CBF63E7CE` FOREIGN KEY (`END_LANGUAGE_PID`) REFERENCES `base_language` (`LANGUAGE_PID`),
  CONSTRAINT `FKFCB9BF1CED6DB516` FOREIGN KEY (`SHOW_PID`) REFERENCES `sys_show` (`SHOW_PID`),
  CONSTRAINT `FKFCB9BF1CEEF1057D` FOREIGN KEY (`ORDER_STATE_PID`) REFERENCES `config_sysorder_state` (`STATE_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES ('8a80cd8e40fd2c8d0140fd2ca3170001', 'ff80808140fc38580140fc38694d0001', '20130908-2', '2013-09-08 18:44:55', 'admin', 'ff80808140fcf97f0140fcf993110001', 'ff80808140fcfa350140fcfa475d0001', '2013-09-25 18:50:42', null);
INSERT INTO `sys_order` VALUES ('8a80cd8e40fd30ea0140fd30ff0e0001', 'ff80808140fc3a780140fc3a88c20001', '20130908-3', '2013-09-08 18:49:40', 'admin', 'ff80808140fcf97f0140fcf993110001', 'ff80808140fcfa350140fcfa475d0001', '2013-09-08 18:49:41', null);
INSERT INTO `sys_order` VALUES ('8a80cd8e40fd315e0140fd3172d70001', 'ff80808140fc3b0d0140fc3b1e5a0001', '20130908-4', '2013-09-08 18:50:10', 'admin', 'ff80808140fcf97f0140fcf993110001', 'ff80808140fcfa350140fcfa475d0001', '2013-09-08 18:50:11', null);
INSERT INTO `sys_order` VALUES ('8a80cd8e40fd31be0140fd31d3460001', 'ff80808140fc3b0d0140fc3b1e5a0001', '20130908-5', '2013-09-08 18:50:35', 'admin', 'ff80808140fcf97f0140fcf993110001', 'ff80808140fcfa350140fcfa475d0001', '2013-09-08 18:50:35', null);
INSERT INTO `sys_order` VALUES ('ff80808140fc7ed30140fc7ee7040001', 'ff80808140fc3a780140fc3a88c20001', '20130908-0', '2013-09-08 15:35:09', 'admin', 'ff80808140fcfa350140fcfa475d0001', 'ff80808140fcf97f0140fcf993110001', '2013-09-10 17:44:37', null);

-- ----------------------------
-- Table structure for `sys_section`
-- ----------------------------
DROP TABLE IF EXISTS `sys_section`;
CREATE TABLE `sys_section` (
  `SECTION_PID` varchar(50) NOT NULL,
  `SECTION_NAME` varchar(50) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`SECTION_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_section
-- ----------------------------
INSERT INTO `sys_section` VALUES ('ff80808140fbba8c0140fbba9b7d0001', '管理员', '拥有全部的权限');

-- ----------------------------
-- Table structure for `sys_show`
-- ----------------------------
DROP TABLE IF EXISTS `sys_show`;
CREATE TABLE `sys_show` (
  `SHOW_PID` varchar(50) NOT NULL,
  PRIMARY KEY (`SHOW_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_show
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_PID` varchar(50) NOT NULL,
  `SECTION_PID` varchar(50) DEFAULT NULL,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `USER_STATE` varchar(30) DEFAULT NULL,
  `FASTNESS_TEL` varchar(50) DEFAULT NULL,
  `MOBILE_TEL` varchar(50) DEFAULT NULL,
  `IP_AREA` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `EMAIL_PASSWORD` varchar(50) DEFAULT NULL,
  `EMAIL_FOOTER` varchar(255) DEFAULT NULL,
  `REMARK` varchar(100) DEFAULT NULL,
  `CUST_NO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`USER_PID`),
  KEY `FKA510FE1DD3D70D46` (`SECTION_PID`),
  CONSTRAINT `FKA510FE1DD3D70D46` FOREIGN KEY (`SECTION_PID`) REFERENCES `sys_section` (`SECTION_PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('admin', 'ff80808140fbba8c0140fbba9b7d0001', null, '$1$hqmis$SbJV5WUMpMkFs0IIs3SyJ/', '01', null, '15976812172', null, '502636321@qq.com', null, null, null, null);
INSERT INTO `sys_user` VALUES ('test-1', null, '测试帐号-2', null, null, null, null, null, null, null, null, '备注-2', null);
INSERT INTO `sys_user` VALUES ('test-4', 'ff80808140fbba8c0140fbba9b7d0001', '测试帐号-4', null, null, null, null, null, null, null, null, '备注-4', null);
