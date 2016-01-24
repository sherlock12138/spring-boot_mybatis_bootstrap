/*
Navicat MySQL Data Transfer

Source Server         : topview
Source Server Version : 50516
Source Host           : 10.21.23.141:3306
Source Database       : ele

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2016-01-20 08:15:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('001', '上思县水利电业有限公司', '广西上思供电公司');

-- ----------------------------
-- Table structure for `control_mearsure_current`
-- ----------------------------
DROP TABLE IF EXISTS `control_mearsure_current`;
CREATE TABLE `control_mearsure_current` (
  `id` varchar(32) NOT NULL,
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `phase` varchar(1) NOT NULL,
  `value` int(6) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7` (`switch_id`) USING BTREE,
  CONSTRAINT `fk_004` FOREIGN KEY (`switch_id`) REFERENCES `control_mearsure_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of control_mearsure_current
-- ----------------------------
INSERT INTO `control_mearsure_current` VALUES ('001', '2015-08-05 09:58:05', 'A', '12', '03');
INSERT INTO `control_mearsure_current` VALUES ('002', '2015-08-05 09:58:07', 'A', '14', '03');
INSERT INTO `control_mearsure_current` VALUES ('003', '2015-08-05 09:58:08', 'A', '16', '03');
INSERT INTO `control_mearsure_current` VALUES ('004', '2015-08-05 09:58:11', 'B', '11', '03');
INSERT INTO `control_mearsure_current` VALUES ('005', '2015-08-05 09:57:48', 'A', '17', '03');
INSERT INTO `control_mearsure_current` VALUES ('006', '2015-08-08 14:26:22', 'B', '11', '03');
INSERT INTO `control_mearsure_current` VALUES ('007', '2015-08-08 14:26:23', 'B', '13', '03');
INSERT INTO `control_mearsure_current` VALUES ('008', '2015-08-08 14:26:24', 'B', '14', '03');
INSERT INTO `control_mearsure_current` VALUES ('009', '2015-08-08 14:26:25', 'C', '11', '03');
INSERT INTO `control_mearsure_current` VALUES ('010', '2015-08-08 14:26:26', 'C', '14', '03');
INSERT INTO `control_mearsure_current` VALUES ('011', '2015-08-08 14:26:27', 'C', '12', '03');
INSERT INTO `control_mearsure_current` VALUES ('012', '2015-08-08 14:26:29', 'C', '13', '03');
INSERT INTO `control_mearsure_current` VALUES ('0674389ef60d4a24b6425c5af8d29523', '2015-08-12 11:23:53', 'A', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('079284069a07496095209e0abc3bc495', '2015-11-21 20:32:13', 'C', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('0a1cf643798a4d47acb5241b208cd78b', '2015-11-21 19:15:35', 'A', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('1187726744a34fb3821a64190833b9d3', '2015-08-12 20:24:48', 'C', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('2d9d8794647a4f0380fcbdcb71e04afe', '2015-11-21 19:04:49', 'B', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('32e8f18f8f4747fdbdee389a1dea0371', '2015-08-12 11:23:53', 'C', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('41d4f5d7bea240e6b29ec4a0da28e9de', '2015-11-21 20:36:47', 'C', '499', '03');
INSERT INTO `control_mearsure_current` VALUES ('54d9b4c46c0345ee86d24828b39f440d', '2015-11-21 19:04:49', 'C', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('70eb2050db64475ebc018bc8243286c5', '2015-11-21 19:15:35', 'C', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('84f53e8470db470bad3128bab6f1aeeb', '2015-11-21 20:32:13', 'B', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('8bc80b6100464b8dbc992ecf942893b1', '2015-11-21 19:15:35', 'B', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('be442acf6c8f42d297a01c9f1ec21413', '2015-11-21 20:36:47', 'B', '499', '03');
INSERT INTO `control_mearsure_current` VALUES ('bfae80786b9641f9b78bdc9578b0e607', '2015-08-12 11:23:53', 'B', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('c2f6533e0f034f16945ecc609b941c59', '2015-11-21 19:04:49', 'A', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('c459e69438e74e789276610b3a7b8419', '2015-08-12 20:24:48', 'A', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('d148553f9e604d9e94036725efee7642', '2015-11-21 20:32:13', 'A', '0', '03');
INSERT INTO `control_mearsure_current` VALUES ('e9a0d37034624fe2b769544638de47ec', '2015-11-21 20:36:47', 'A', '499', '03');
INSERT INTO `control_mearsure_current` VALUES ('f897ad041b8940c091f290a47ca38df4', '2015-08-12 20:24:48', 'B', '0', '03');

-- ----------------------------
-- Table structure for `control_mearsure_hitch_event`
-- ----------------------------
DROP TABLE IF EXISTS `control_mearsure_hitch_event`;
CREATE TABLE `control_mearsure_hitch_event` (
  `id` varchar(32) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  `hitch_reason` varchar(32) NOT NULL,
  `hitch_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `FK_11` (`switch_id`) USING BTREE,
  CONSTRAINT `fk_005` FOREIGN KEY (`switch_id`) REFERENCES `control_mearsure_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of control_mearsure_hitch_event
-- ----------------------------
INSERT INTO `control_mearsure_hitch_event` VALUES ('01d978a399be47b3b7648e69709a81af', '03', '03', '2015-11-21 20:09:09');
INSERT INTO `control_mearsure_hitch_event` VALUES ('21dcca79d983417d9a869546532d787f', '03', '01', '1999-11-30 01:00:00');
INSERT INTO `control_mearsure_hitch_event` VALUES ('4a2520d205b14ae9874d4d2c127945d4', '03', '04', '2001-09-03 01:04:00');
INSERT INTO `control_mearsure_hitch_event` VALUES ('4ea700e0d2e74cc9a12a18885d9a11f8', '03', '03', '2015-11-21 20:18:07');
INSERT INTO `control_mearsure_hitch_event` VALUES ('7e8ac1350c86427c8969455bdc0e7d38', '03', '11', '2004-04-25 07:22:59');
INSERT INTO `control_mearsure_hitch_event` VALUES ('e7542db6a85b4d558463caaaf93acaf4', '03', '03', '2015-11-21 20:09:13');
INSERT INTO `control_mearsure_hitch_event` VALUES ('f052142210d1488f85cf4ad9c6195a13', '03', '01', '2001-01-01 01:01:00');
INSERT INTO `control_mearsure_hitch_event` VALUES ('f962459d1ef1446c8f683320c2d0074f', '03', '01', '2015-11-21 20:06:33');

-- ----------------------------
-- Table structure for `control_mearsure_switch`
-- ----------------------------
DROP TABLE IF EXISTS `control_mearsure_switch`;
CREATE TABLE `control_mearsure_switch` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `sim_number` varchar(20) NOT NULL,
  `device_number` varchar(30) NOT NULL,
  `longitude` float(6,3) NOT NULL,
  `latitude` float(6,3) NOT NULL,
  `inline_index` int(3) NOT NULL,
  `line_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1` (`line_id`) USING BTREE,
  CONSTRAINT `control_mearsure_switch_ibfk_1` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of control_mearsure_switch
-- ----------------------------
INSERT INTO `control_mearsure_switch` VALUES ('03', '那思分段开关', '000000000001', '123', '002', '116.500', '39.915', '0', '02');
INSERT INTO `control_mearsure_switch` VALUES ('108387', '团结东路开关', '', '123', '002', '116.404', '40.000', '0', '02');
INSERT INTO `control_mearsure_switch` VALUES ('330804', '华林分段开关', '', '123', '003', '115.660', '40.000', '0', '03');
INSERT INTO `control_mearsure_switch` VALUES ('567436', '城南分段开关', '', '123', '004', '115.660', '39.915', '0', '04');
INSERT INTO `control_mearsure_switch` VALUES ('625175', '叫安智能开关', '', '123', '005', '114.500', '40.500', '0', '05');
INSERT INTO `control_mearsure_switch` VALUES ('64771', '叫安分段开关', '', '123', '006', '116.400', '40.500', '0', '05');
INSERT INTO `control_mearsure_switch` VALUES ('679281', '中华支线分段开关', '', '123', '007', '114.500', '39.900', '0', '06');

-- ----------------------------
-- Table structure for `control_mearsure_voltage`
-- ----------------------------
DROP TABLE IF EXISTS `control_mearsure_voltage`;
CREATE TABLE `control_mearsure_voltage` (
  `id` varchar(32) NOT NULL,
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `phase` varchar(1) NOT NULL,
  `value` int(6) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6` (`switch_id`) USING BTREE,
  CONSTRAINT `fk_006` FOREIGN KEY (`switch_id`) REFERENCES `control_mearsure_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of control_mearsure_voltage
-- ----------------------------
INSERT INTO `control_mearsure_voltage` VALUES ('001', '2015-08-05 09:54:28', 'A', '220', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('002', '2015-08-06 09:54:29', 'A', '230', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('003', '2015-08-05 09:54:31', 'B', '255', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('004', '2015-08-05 09:54:32', 'B', '235', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('005', '2015-08-05 09:54:41', 'C', '230', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('006', '2015-08-05 09:56:43', 'A', '240', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('007', '2015-08-05 09:56:46', 'C', '210', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('008', '2015-08-05 09:56:50', 'B', '222', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('009', '2015-08-05 09:56:54', 'A', '244', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('010', '2015-08-05 09:56:57', 'B', '233', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('011', '2015-08-05 09:57:00', 'C', '212', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('012', '2015-08-05 09:57:06', 'C', '235', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('026f05bf3410487ea212d65ff38062f2', '2015-11-21 20:36:44', 'C', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('02e5938b2b13481fafb686c626bff947', '2015-08-12 17:21:24', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('02e7d0a26f324e4399ac8893ffa5d666', '2015-08-10 02:13:31', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('038cb9358e12400db7e738b961858c71', '2015-08-12 17:33:24', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('03e9c2c5787549749709f6d20bc93315', '2015-08-12 17:34:08', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0500ebab3cfb4949817fc525f247880f', '2015-08-12 11:17:05', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('054c1edc1eb1485ebabd6e47ebb12943', '2015-08-11 02:07:02', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0657bd15bdcc45039d6971d99e14dd0e', '2015-08-12 17:33:56', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0666cb38aac748c1b6f729c38d200c30', '2015-08-12 17:33:38', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('06aa50abc55a43209228b2a80a77fa4d', '2015-08-12 17:33:38', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('07c0f00f0ba346deba291768bec9e1d9', '2015-08-12 17:34:05', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('08234aff6ca0476fabe5caa3fdf1e9b6', '2015-08-12 17:33:43', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0927bdbb2db64514b2394a8eea9e3d54', '2015-08-09 12:43:58', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0ab8298e7ac64a10b235b8f55fdb7867', '2015-08-11 02:05:55', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0addb922b6bf4169892c0f7ff2c7b647', '2015-08-12 17:34:03', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0bff3f0325cf420187e23b477cbd1a54', '2015-08-12 17:33:27', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0cb8a270aeee4561b0194cbfd84028b2', '2015-08-10 02:36:33', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0cfa7a78cd7d41a5af9b6dbb5e3cbd0e', '2015-08-10 02:35:59', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0d3b3d92056e43f09a2489ead1f3d29c', '2015-08-12 17:34:01', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0d76d6f2b32c4276be4439e486068eae', '2015-08-12 17:21:22', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0e301d33b3a3495a8ef3345e5de20468', '2015-08-12 17:33:19', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0e9e2e737b0e4e9e889c8772edf9e703', '2015-08-10 21:55:45', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0eacc063cf5847feb00858ce5c09a6e7', '2015-08-11 02:20:25', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0f2a1fc1f1984530aa7126516fd3c86e', '2015-08-10 00:37:09', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0f5557457355490ba9f02c2783ee28e9', '2015-08-10 21:21:06', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('0fb39e48d46d489aabe0d85d9485657d', '2015-08-09 12:40:24', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('115f4561560244059313162a1f5e3683', '2015-08-12 17:33:50', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('129b186d13e642a28e297c5b155694bf', '2015-08-09 12:43:58', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('12b2ea181b1e4a5ca238c577c65ebd84', '2015-08-12 17:33:17', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('13ab44c324244457ac8629d8c41e1915', '2015-08-12 17:33:32', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1444861a47de45339b6ffa0a7133c3f8', '2015-08-12 17:21:48', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('155efde9ca6c46898a066c390346fb68', '2015-08-11 17:59:45', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('157f249d2dd5464bac3d9bd37fe13b95', '2015-08-10 02:15:33', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('166207350edc4d879145625ace669c5a', '2015-08-11 02:14:36', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1713b790251e45cc931e1c6374d0ff6a', '2015-08-11 02:12:51', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('175bbd77155948608787fcea7e786760', '2015-08-12 17:34:01', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('17878d36372b49158bbb1a8fb3b5cae1', '2015-08-12 17:21:15', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('17c0b6e94c38459abce9663c4f7c9742', '2015-08-12 17:21:39', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('17d7e261f98248afbabd0cd916a16c1b', '2015-08-12 11:19:08', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1985e7c461504f3ea3a189628ee87ab6', '2015-08-12 17:33:42', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1aa0f44f843e43bab6b7df8aae1fc0ba', '2015-08-10 21:37:31', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1ca938bf627940fda80971657879a292', '2015-08-12 17:33:56', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1d16f5e347b84095b792cdb0d54d1246', '2015-08-10 21:38:30', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1d53de266c3c4647a0172829dcdf4932', '2015-08-10 02:12:17', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1d791a9e7bcc4485ae8675e543746510', '2015-08-11 17:59:47', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('1ea248204e9e4e1e9b019b1c45fdfe30', '2015-08-09 15:06:03', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('20e8c47db4184ebda6a22a5c730a20cc', '2015-08-10 21:21:06', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('21539c4d8c10409182a46978a95c0e6f', '2015-08-12 17:33:55', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('21da7c275ee549e8810541ab0882eb5b', '2015-08-12 17:33:31', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('221d357ab98c44ecb3bdd857a6e7b39a', '2015-08-10 21:21:06', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('229352c5c2db485d8b6e270ff5bec34d', '2015-08-12 17:20:59', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('23cce697c01c4c6a8c71d3fde6e3e433', '2015-08-12 17:33:53', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('258d954740404f4d910e1c42701a0607', '2015-08-10 02:35:13', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('260ce624d07b483aa077e02e49f23dc8', '2015-08-12 17:33:35', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('2618a9f0516d4929b63a0ea7f51dfd95', '2015-08-12 17:33:52', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('276e8a42998a4e98a2ceca6067cf3772', '2015-08-09 12:34:57', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('27e6f6df304e4ec598f83c9e11b7f01c', '2015-08-10 02:29:58', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('28844f673b104720b09b175451fde228', '2015-08-11 02:03:23', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('28ddc408637944ce948bc211fbde41e8', '2015-08-12 17:34:03', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('2a7b1ff1203244f7838d25eace265014', '2015-08-12 17:33:47', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('2a8b888b553747958b4d20cd92015be4', '2015-08-12 17:33:45', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('2acc7364c9da49a8aa9950a0ae93fe6a', '2015-08-12 17:33:49', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('2ecfa7dd146a4d2dba1d6485802b00ce', '2015-08-11 02:05:55', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('2efb0a765c4c416b99284759eb6e7e3f', '2015-08-10 02:39:33', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3139795d232c420cbfd0853e2ed85366', '2015-08-12 17:34:05', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('335fae61639a46d48e0f5fa025b5e2cf', '2015-08-12 17:21:24', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3503ea1c76044b1781f7fd6e5f89340f', '2015-08-12 17:33:28', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3517977935684ba0ad42a9720b3e7ac9', '2015-08-12 17:21:22', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('35ffb11dfe1c42feb6615c10f114678f', '2015-08-12 17:33:54', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3726cc4d8e104cbe8f299cb5e238ff1a', '2015-11-21 19:15:35', 'B', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3782ce457125424483d1cc81f205bc05', '2015-08-12 17:33:59', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('37cf41ce738349c2993fef66da3d4083', '2015-08-09 12:41:21', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('39bb360ba5e244ee994bf7278b0d67df', '2015-08-10 00:37:09', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3ae5cae4a41549ea88a649424c7581b3', '2015-08-10 00:37:09', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3b0cab5e80594684be984f3af7ba9407', '2015-08-10 02:39:33', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3b48a28dbc5d46b8bf5d6bf691946189', '2015-08-12 17:33:16', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3cb168254783454abe5c66399ab4b989', '2015-08-10 02:05:10', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3cbf43b530ba4b459528d3ed07c1afa2', '2015-08-11 17:59:45', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3d4c273cdcd54146ae2c16569a130858', '2015-08-09 15:06:03', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3e778cf5573246e6b38d64bbd54eb444', '2015-08-11 17:59:46', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3f60ec2a0a254734a3178fc3ffaba951', '2015-08-10 21:56:00', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3f6e978ce04447539c22771a194248d8', '2015-08-10 02:35:13', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3fc19161cc224fca96d2176e90c1fce0', '2015-08-12 17:33:33', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('3fecdc2fe17d472581c806f0631283de', '2015-08-12 17:21:23', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4000b3e6a0b348feab3d6550232887da', '2015-08-10 02:35:49', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('400207cf853843ad948b272d1b988ac6', '2015-08-10 02:35:59', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('40088aed4d9d4f178cc702436a020f6f', '2015-08-12 17:33:20', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('404a6e77b05a4ae6b4ead8baa7ba786f', '2015-08-10 21:59:22', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('40ce21a4653f47039c6d5c605c9b6dbb', '2015-08-09 12:40:07', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('40e01dd36ba94c0188fc3d24a71f939a', '2015-08-12 17:34:09', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4322e6ebe5ff4dfe876c97021b0ef295', '2015-08-10 00:35:19', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4370f355848b4256882d573d5814163b', '2015-08-12 17:21:22', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('45012d52835f48fe947ddbe0a326bbbd', '2015-08-12 17:21:48', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('45d3d5bf1a40438c8ec709020d2b8844', '2015-08-12 11:19:08', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('47a1129b99c34d1793753ec8730ccb5c', '2015-08-10 21:59:22', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('47d62cf9b158400d975e6a582ee118cf', '2015-08-12 17:34:04', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('492870e21ccf45fda578b02889540030', '2015-08-10 02:36:23', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4a2cf46957e345e58b330c515a47deaf', '2015-08-11 17:59:46', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4ac31b52ce13451a89b5ce0e2fad432d', '2015-08-10 21:37:31', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4bde3a219cef4e4b800759c5055ca879', '2015-08-12 17:33:57', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4c0101e6020a40d895178d4c4992409b', '2015-08-12 17:34:07', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4d503727d6bf4613810ed8f4c5847241', '2015-08-12 17:33:17', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4dac19fef7cf447799f3c407984bc7c0', '2015-08-12 17:21:15', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4df45c42d9c3420cb1e6bde022e35188', '2015-08-11 02:16:58', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4e3d9d570d984ea9bab0422209584c78', '2015-08-10 02:36:27', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4f03e091ec0d4728828288b58b3fe0df', '2015-08-11 02:12:51', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('4f5d7d3b616e48008ce045788aabd6fa', '2015-08-11 17:59:48', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5011b2ba96aa4ccebe74ae035eab072e', '2015-08-10 02:39:33', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('50ca3fac535944b68bd155d30cd6512e', '2015-08-12 17:33:39', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('50f6d08d81464a9882e82be4042a5d0c', '2015-08-10 02:33:26', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('50fbf3d4c2994895adfe76e7717200b2', '2015-08-12 17:33:30', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5127459853b240939b514ca0287efb40', '2015-08-11 02:07:02', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('522c4117ab6f473797ce759c9fcc0765', '2015-08-09 12:41:25', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('52b8bc36d32d44bcbfedafbc49b3ed73', '2015-08-12 17:33:37', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('53fbd05e240e458aa393cd9858c38a0c', '2015-08-12 17:33:50', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5442934fa569412db51e7c788eda5ba9', '2015-08-10 02:39:45', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('54e66c6d110343978a8ed407f827ac8f', '2015-08-12 17:21:22', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('55ea2081fcb34d398c420047d8615492', '2015-08-12 17:33:21', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('571a9ae4e4e74dd5b2a3203f0b8be3ad', '2015-08-12 17:21:48', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('575d9c570d214e48a570c72c64ca7543', '2015-08-10 21:40:59', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('575eeeb4cd5d471c834e90f11fde4521', '2015-08-09 12:40:24', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('57ac6ff1a43e433d85f4493527a3f116', '2015-08-10 00:40:20', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('57c6f727f2914b419393807dd90e6d83', '2015-08-10 02:15:33', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('58549cf497c74595953934c69bd07a6d', '2015-08-10 02:13:31', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('598b70eefcf14734b4e757ee2baca757', '2015-08-12 17:21:15', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5abc937b1d0b4d308b64d083f85a22ee', '2015-08-10 02:05:10', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5b4ca08334ac4e08a41d38496a29a838', '2015-08-11 02:05:55', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5c686b511d4a40c68de6fb358980c239', '2015-08-12 17:33:17', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5cb3363f065d49e19e8d54e8c260de42', '2015-08-12 17:33:36', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('5fa5c56aa71c4c87949469e6cedbebce', '2015-08-11 02:20:25', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6038007359bb498faf0abd496af2ce99', '2015-08-12 17:33:33', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('604d464eb1ea41ddbd588750bb937c26', '2015-08-10 21:37:31', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6051aa1d0d3d4a54b126399ba33913c2', '2015-08-10 02:29:58', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('60d14d695577407e8a7af8fa4f678236', '2015-08-12 17:21:23', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6210d1c7b28940448c52be041be600aa', '2015-08-09 12:41:32', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('625fd3a7c36e4c589a1580808027794b', '2015-08-09 12:34:57', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6268b8dc754b4cfb849fda947dae08a4', '2015-08-12 11:19:08', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('62a441a0d1a34e3e8a7be1e3380985b7', '2015-08-10 02:36:27', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('62c118c87947425b802d08cf40ee0068', '2015-08-12 17:33:46', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('63d6ee2474d1499cac252750b98eaaac', '2015-08-10 21:56:00', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6452a32056cb4e5d8566981d4739fc53', '2015-11-21 20:36:44', 'A', '2202', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('652123120abd48468358821ab0c6c449', '2015-08-09 12:43:49', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('652a6391bb8b4609a24fc29d715379e0', '2015-08-10 02:49:16', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('655307fb1ed44422a52a7f05d768debb', '2015-08-11 02:14:36', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('658132af9fc74cb88d1901fbf24f98c1', '2015-08-09 12:43:49', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6628c2cd0b49477c8970b361ed8f830e', '2015-08-10 21:38:29', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('66d2cbf4fcd14335a3acdfb89712c5ec', '2015-08-12 17:21:15', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('67a240f6ee224baca9ba6f0e870dc1d1', '2015-08-10 02:35:59', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('68b12c2996b44cc7910a4532ffddc684', '2015-08-09 15:05:54', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6a01bad3a2ea44cd859f2451c2c04c72', '2015-08-10 00:35:19', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6a0ac180cdf54464856b6a6af68233fe', '2015-08-12 17:33:35', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6b4013d9586e408a8dd783cd94c0cca6', '2015-08-12 11:17:05', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6baf00f586ca42a69866f06a6c4487e2', '2015-08-10 02:35:59', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6ece6cf64cc14c98ab99b7cd363e880a', '2015-08-12 17:20:59', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6f4a3a23e3224faeb9dd42636e4caaae', '2015-11-21 20:36:44', 'B', '2202', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6f61bfa5f8e5403ab7dba4271b113c6b', '2015-08-12 17:33:53', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6faabaab90cb41a493112b6f8cede1ff', '2015-08-12 17:33:53', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('6fd7af5e8c244b929ad2cd8fbe54f228', '2015-08-09 12:41:25', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7079abf31bc44472a01d3fe1b8ea1d86', '2015-08-11 02:04:26', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('710e2cddf6be4b5a8b1c523e8e4113d1', '2015-08-09 12:40:30', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('725fc8cb289e4642a82ca1477c609a56', '2015-08-12 17:34:04', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('72618cff8c8f4788ba2aa6ec756334cb', '2015-08-11 02:03:23', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('737afac406324a8dbecf13451b12eac7', '2015-08-12 17:33:35', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7439cf4132244157afa12c7db3521bbb', '2015-08-12 17:20:58', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('745cb88ad4254ecf8124ee5f630e5c51', '2015-08-09 12:34:57', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('746102d282834f168ca6d2f243109c56', '2015-08-12 17:34:06', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7467881eb08945cc9c528b1d18928d33', '2015-08-10 21:38:30', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('75ae8d174c6c41639a0c1e2f11c714e9', '2015-08-11 02:26:25', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('763c6122849d40a3a80ddd1e494f85a5', '2015-08-12 17:33:26', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('76ad73f8f14e4826b3931f822fdb784d', '2015-08-12 17:21:39', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('76d3597348f14c4bb24c02b3430c66dc', '2015-08-10 21:55:45', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('76dcd21b473d4689a1e8417267c59ce9', '2015-08-12 17:33:40', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('77518cb57c71417e970427af4a25373c', '2015-08-10 21:53:59', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('77ca4076839f4fd398101d768084bd2b', '2015-08-10 21:40:59', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('78c07f8d56584d58a234fc4f1e70d374', '2015-08-10 02:39:45', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('78e1a27bb695448cbbe1b79a34ca2d57', '2015-08-12 17:21:39', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('79310400b5cf4092b937242b20abe766', '2015-08-12 17:34:02', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7a58c7b8bcd3416d8325a65a9c51a5c0', '2015-08-11 17:59:48', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7a65f633f5cd4bc9be3794fb013235f5', '2015-08-09 12:43:58', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7bf5a2f33a034554bbbcca4dbe565609', '2015-08-12 17:20:58', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7d038fe76ae84b65ae944eddd6dc6ecf', '2015-08-12 17:34:04', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7d7b270377e441e883c798d0dc417630', '2015-08-10 02:35:59', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7d80317df6f84d7da4731b7226dd4290', '2015-08-10 02:49:16', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('7e51aa56ac5141f2bba81cba70d404a3', '2015-08-09 12:35:01', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8046d6ce94a04f05b4d2646952868c36', '2015-08-12 17:33:58', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8058c239d76241cb8d2c8429cb6be5cb', '2015-08-12 17:33:42', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('80cf8652154d4cb1a519ea0f635058ef', '2015-08-12 17:34:06', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('80de27b8de5f460b9cf32fa2da27ff65', '2015-08-10 21:55:45', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8111f99af6ce4607b6a66c927885be5b', '2015-08-12 17:33:16', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8123387be29241318fb2d9a2657daf40', '2015-08-09 15:05:54', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8131bf9d3761408485b1a6d89b968dea', '2015-08-12 17:34:06', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8284eab242d843d18375a42ec8b494c4', '2015-08-12 17:33:34', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8343774fa315440ebc6ce0c6ef001ad3', '2015-11-21 20:32:08', 'C', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('83a73d395acb42f49ec35cde090a0933', '2015-08-10 02:35:13', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('84423fbac6df44f091c532bf42de9969', '2015-08-12 17:33:26', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('84465243c0d3432f96af3c5036b582fd', '2015-08-11 17:59:47', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('846f7632d05145039ef2d6c5f52667d6', '2015-08-09 12:40:30', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('84a098fc8f404acd8e461bcec6895d06', '2015-08-12 17:34:09', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('852c4e6b54834050bee67cd8191c6c78', '2015-11-21 19:04:48', 'A', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('85554963d32f40c5998914702a46d1c9', '2015-08-12 11:17:17', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8612faad40204753ab8acfcc251d1a14', '2015-08-12 17:33:54', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('86d3410f2cdb48af9c71f161fdf0fb9c', '2015-08-12 17:33:50', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('87702a582697494e9918f435cae749b1', '2015-08-12 17:33:20', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('87e582ac7dc04394a9b33a2089d789eb', '2015-11-21 19:15:35', 'C', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('885e6f020dc947c0a960c0d543d1d532', '2015-08-12 17:33:28', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('889c082c431f492e86c1fb997b3295cf', '2015-08-12 17:33:58', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('890dce6cfba643b5880ce0bb69c96f57', '2015-08-12 17:33:34', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8960db57ea4e43a1a493089d9397e5d9', '2015-08-12 17:21:23', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('89918157a7d44cf190a6d38c2139d277', '2015-11-21 19:04:48', 'B', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('89c11e63bc6346eb861cdacfe30fe580', '2015-08-12 17:33:49', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8ae3d4a01d5d48ccb6675fada36a155e', '2015-08-12 17:33:24', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8e835fbf0dd948628587bb8ea6977dc5', '2015-08-12 17:33:29', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8f9624c42c12497c87b85ca0f3f29054', '2015-08-12 17:34:00', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('8ffe2eef4b204368adeafe64d111d299', '2015-08-12 17:33:37', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('900ad3b6e5844fd9a6906d322855f98f', '2015-08-10 02:34:04', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('904bcb67852b417486af163bde96430a', '2015-08-12 17:33:52', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9058c7d4289f417fafd40567f3ac0416', '2015-08-12 17:33:45', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9265e86d0ee04c66a3e082a456ccacbd', '2015-08-12 17:33:45', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('92e191aed9124393aa01f6991290177f', '2015-08-12 17:33:37', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9345aa7412924d7996ce3767b08e65dd', '2015-08-12 17:21:22', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9415027a19014b849e10521988ee1d32', '2015-08-12 17:33:19', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('953c2d98a10c495d91453417d8ae189a', '2015-08-12 17:34:08', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('960dde62c09a438e9735b60d1a25692c', '2015-08-12 17:33:49', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('967f9992735e4786a4a5ca7342ba44d7', '2015-08-12 17:33:39', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('97648c5263f94ed6ba092062fe250196', '2015-08-12 17:33:55', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('981cc36c82c04380b4cb1f48ddfe93da', '2015-08-12 17:33:42', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9dd4e256ecf84789bdae9420a916cc3c', '2015-08-12 17:20:19', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9e5c4c33b6964fe392fabf58d3984e28', '2015-08-09 12:40:30', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9efa92edecbb43ddb24bd1e1d897e5c7', '2015-08-12 17:34:05', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9f7b8c3024eb4a938365a22084750aa8', '2015-08-12 17:34:00', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('9f9a3d043ba14f609ee5ecdffb04f895', '2015-08-09 12:35:01', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a0e113f382174d50b1414e43ee0ff128', '2015-08-09 12:40:24', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a0e35e64a3374a058c30ad80d0bf1ad6', '2015-08-09 12:41:21', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a1d1ea1522ae486ebe68e17a5e63a4da', '2015-08-11 02:20:25', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a210974abbe44c7e8e1f1ad739ca0502', '2015-08-12 17:33:22', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a2a5fc681a4c401588ba1be157a1b8cb', '2015-08-12 17:34:02', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a32aa483fdfb406e8fe6dd0eb9007533', '2015-08-10 21:38:30', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a417ce3feb8d40f4865710d894e36824', '2015-08-12 17:33:33', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a4a01a6ce03e4575b363d589cabab847', '2015-08-12 17:34:03', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a4c98d5c79c64802aa76355b126effec', '2015-08-11 02:04:26', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a4f3c07afa9946cfbf183a25eb096da9', '2015-08-09 12:41:21', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a59952df99be481aaed1380b6ac7a899', '2015-08-12 17:21:39', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a5b3008d369549dda5c8550b44d40182', '2015-08-10 02:33:26', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a5ffd597ffc946ab9bc2785d3b9687d6', '2015-08-10 02:15:33', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a6967f929d204aeea245436862f24d07', '2015-08-12 17:20:59', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a70e680ce50e4c9b819a76956cebc722', '2015-08-12 17:33:43', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a744cce55e19428fad95104f9ba764cb', '2015-08-12 17:33:48', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a7e6bb39502a4ddab6191034f6a51ce7', '2015-08-12 17:33:18', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a84a1481d05d4565b41fea0c1c210d8c', '2015-08-09 12:41:25', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('a9ba397ab3a54776959b9a0e10ce8624', '2015-08-12 17:21:39', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('aa95eb54f5ab4dfdb63100900b2818af', '2015-08-12 17:33:22', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('acc80a524a8b4942bcb8fb48ced21919', '2015-08-10 02:05:10', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('adaf81d16cad416c9c439780ab288559', '2015-08-10 02:34:04', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ae664127eee04edc9a58e3af98117570', '2015-08-12 17:33:58', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('aeb3b59623324585a9f5865ec8a12105', '2015-08-10 02:35:49', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('aec233cf1ac24408a129f23ab686496b', '2015-08-11 02:04:26', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('af3a120dc8af417e9d6634e34191f686', '2015-08-12 17:33:32', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('af5ce986e3b9400381f579f97232f1bb', '2015-08-11 02:16:58', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('afb87d4e901d443490345d4a770408af', '2015-08-09 12:35:01', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b00d8c411ea843f1b39c483bbb758406', '2015-08-12 17:34:01', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b072cae7e53f413fa311a0292c5b7bf6', '2015-08-12 17:33:32', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b0936758a55342a7bcba5dcf024303e6', '2015-08-09 15:06:03', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b09f922dce4c4770a13d833deaeb6323', '2015-08-11 02:02:08', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b0ce412b34c84066a8c71577f945b914', '2015-08-10 02:13:31', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b28d9fe504854aeeab2ce8aa4657a767', '2015-08-12 17:20:58', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b2a9283a9eab4bf38a476598e18b98c7', '2015-08-12 11:17:05', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b3b7ddeffae64bd4939c4099295c9137', '2015-08-09 12:40:07', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b3d251448e304d08a5f2bcd4a171e280', '2015-08-12 17:33:27', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b42aac92044f4918b567648dfff661c6', '2015-08-12 17:33:52', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b574faf67e52452a84685afe96108b91', '2015-08-12 17:33:44', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b645dea90dad449c9423215ec81a3dc0', '2015-08-10 00:40:20', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b6951a56054f49f69835235927863739', '2015-08-10 21:40:59', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b6e032beb3c34f83b44b350a508c5cd7', '2015-08-10 02:29:58', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b77b9bccb0b84552bc37e3cb81e62585', '2015-08-10 02:39:45', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b80ed22a65514fd1948797b0bee354fa', '2015-08-12 17:33:19', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b81923ea42ee4943b740ca057d10ab03', '2015-08-12 17:33:57', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b966742452bf4c70a84c4982f520a0f3', '2015-11-21 19:15:35', 'A', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('b996dcc54cc44fbea41cd8e51ede2683', '2015-08-12 17:34:07', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bac11b185c7b499ab8869b3609236ca6', '2015-08-10 02:36:23', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bac7d5f1c2464d0bad3b1b3297d142e3', '2015-08-10 21:38:29', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bbbd0ab8948c4acd8455ae8403f596ff', '2015-08-10 02:36:23', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bc4c373e22804906b641c72beda281bb', '2015-08-12 17:33:44', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bc8716b9bdd943ee8cb7ad00fa3d72c7', '2015-08-12 17:33:46', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bc909445c9ea4d8d930bf0088d554169', '2015-08-12 17:33:48', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bd195ebfa289445b921f7d76bbb838ff', '2015-08-12 17:33:27', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bdd3b413b5914e6aab9c94eeea4635ba', '2015-08-12 17:33:48', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('be38a6af4e2a445986e1509b1d94983a', '2015-08-11 02:26:25', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('be95142469e74c29acae5f561815f642', '2015-08-12 17:33:23', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bed5a7c06d624589b1405053af47c9a2', '2015-08-11 17:59:48', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('befc3dce3fb74697b086afb6cbed65c9', '2015-08-11 17:59:45', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bf4e71897ee74800a2a76e7d213ea675', '2015-08-12 17:33:54', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('bf6b24fb39de4eedba2bdd756fe0fac2', '2015-08-09 12:40:31', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c03f208c23bf4e2eb4a66bf731483a23', '2015-08-12 17:33:23', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c042927b2cef4383b6bba8874baa0250', '2015-08-10 02:35:49', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c065fbc5123343c398158bbec006449f', '2015-08-10 00:40:20', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c1027a72842142d085eb5e4484c1eb4c', '2015-08-12 17:34:02', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c3849dd2765842629b465540b61f60fd', '2015-08-12 17:33:34', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c3ff37fb79a24bf0bf7995b940e76efe', '2015-08-10 21:56:00', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c5d0f534308c42cb8b37cd5aaa048c98', '2015-08-12 17:33:47', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c655990369a14402928d21850879327c', '2015-08-10 21:59:22', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c9048632fc6c4fc4adda867af797cb4c', '2015-08-10 02:36:33', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c90e6e0ce3cf440f87d0b255ef71ebde', '2015-08-09 12:41:32', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('c9a07c6b6b3242e8981512392dbee9ab', '2015-08-12 17:33:46', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('cbef21e5ef034ed09a5cbbd22a3f0168', '2015-08-09 12:43:49', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ce61f87cec8a4da0aba633b849fde921', '2015-08-12 17:33:59', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ce88bee621d04ea28ba8a963bc50572f', '2015-08-12 17:33:43', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('cf05a61f7c5245f098c26bff1a7ae8e6', '2015-08-12 17:33:23', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d046a8303dc7456aa987f0c2d854785d', '2015-08-11 17:59:46', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d09aae0c28ec4019affb85f702bbb1db', '2015-08-11 02:26:25', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d120d5e0688d45e2ae58bd183cd01ec5', '2015-08-12 17:33:31', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d25e8c77a55a4df09fb7227af2a97d32', '2015-08-12 17:21:24', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d2fd3c9974a24d1f86f56e2797343979', '2015-08-12 17:33:57', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d42b4d917fca4c0e87f19230fdb5d1bf', '2015-08-12 17:33:36', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d45803458ad5410e85bb4f17faa9961c', '2015-08-12 11:17:17', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d5b21e3757204ec0aaf05c32cfea6b4f', '2015-08-10 00:35:19', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d5bc0f774f5542d79a0cc3ab3f07c110', '2015-08-11 02:02:08', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d6160d0e1ebe4f7e879c28bef63dfcb6', '2015-08-12 17:20:19', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d806d9e40d2445a0aa09a3c592d22b28', '2015-08-10 02:36:33', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d814ad81d8b44bfca4457f5033b0714a', '2015-08-10 21:53:59', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d841b96395a04216a3f2eec980c35ad7', '2015-08-10 02:49:16', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('d897aa3d8ea24a6c964b14abf7872792', '2015-08-12 17:33:38', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('da676621b820441fb56fe3fbd24693e3', '2015-08-10 02:35:59', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('daba7798927940cbaca55d05ec268be9', '2015-11-21 20:32:08', 'B', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('daea3c914f2049b897041d1d0cf522b9', '2015-08-09 15:05:54', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('db4e51fa01c548199b03458a18f64b58', '2015-08-12 17:21:15', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('de83018700ff43e891acb4a1d213b5f8', '2015-08-11 02:02:08', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('df22461b866547a68b822860f9d17616', '2015-08-11 02:12:51', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('dfecdb601461435791e5e8db038d3c38', '2015-08-12 17:33:44', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e005db0aa24d4f8db6deaa96dc2f27f0', '2015-08-12 17:34:07', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e01e7caa6f524cc2a4053ae125600d12', '2015-08-12 17:33:21', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e03f21d0edb542b68201ecc92198aac2', '2015-08-12 17:21:22', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e08ad620b9ee47c59f777db50cc68e44', '2015-08-10 02:36:27', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e0bd8a237e604e55aff69ca6614a12aa', '2015-08-12 17:33:29', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e19201d551bc45ee87c3d9dbe12636da', '2015-08-12 17:33:22', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e204c41a351f40f18f4106d478f0e1e1', '2015-08-12 17:33:40', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e23f8f1b7aad4c2a8372bfb44b70c582', '2015-08-12 17:33:55', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e3b7d4cd87174f71af6603b1fbb6b497', '2015-08-12 17:33:18', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e4939c2a900940f7b4001e48f59fcdad', '2015-08-12 11:17:17', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e6ea52953b4c43ada3934e9e81eb247d', '2015-08-12 17:34:08', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e7396127f84c4338b06767a5eea07855', '2015-08-09 12:40:31', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e7c2a21178b34c9fba9e913bd9558f3a', '2015-08-12 17:33:56', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e8421dcc33994d3cbc50d7da3c2a812f', '2015-08-11 02:03:23', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e86ce1a09e4b45b2a635f389ab228e9f', '2015-11-21 19:04:48', 'C', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e8bf8e38ba5a44639aff5263c9d5477c', '2015-08-12 17:34:09', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('e92ee23b653f444eacbf769d5ac04433', '2015-08-10 02:12:17', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ea23ec970ce14ccea5a8ee5fd4177f48', '2015-08-11 17:59:47', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ea48ed5a018e4104b90f5896a417a1dd', '2015-08-10 02:12:17', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ea689e51570f437d9ef45125a599d46d', '2015-08-11 02:07:02', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('eaa4223b74e1452aac81328a72746381', '2015-08-11 02:14:36', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('eafeff93dcc34efc859a2f58fda6e0ba', '2015-08-12 17:33:40', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ecd236d72f8a4addb4a1612b7ac44a35', '2015-08-10 21:53:59', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ed4c78f2c97c48d0a2f9bda2d1ccb6d5', '2015-08-10 21:16:00', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f053578c3e11426eb9343bb7a6b1a9bb', '2015-08-12 17:20:19', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f06b4159380e434b9f998b191b39c180', '2015-08-10 21:38:29', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f0e1317954004ebcbc07833af6e22045', '2015-08-12 17:33:31', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f11093eb32b342faa291f2b35e4b78bb', '2015-08-12 17:33:20', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f120e34fe6a643f3af3d22a2c94df982', '2015-08-10 21:16:00', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f1499b67768f473a9d1fae1b4ecc6af5', '2015-08-12 17:33:21', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f1ecb7b853364690ab170449f477fe86', '2015-08-10 02:33:26', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f27bfa3c51b24a6a88315a20080528eb', '2015-08-12 17:33:18', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f2e1b1273d22425d9ee91170e4521a9c', '2015-08-10 02:34:04', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f404c64fb1cc498f8909ca8b71668458', '2015-11-21 20:32:08', 'A', '0', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f499df1baa9d48f0a84c4d656b46bc4a', '2015-08-12 17:33:39', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f4c9a55fd73249d895db2e20a6e5811c', '2015-08-12 17:33:26', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f50809f39b1849679a583bc8ad4e2259', '2015-08-12 17:21:15', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f57a49f4c3274dbf94a527fba35d37ed', '2015-08-12 17:33:29', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f5b8af5114cb4986a0e2d90c64a27b28', '2015-08-12 17:33:30', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f6c1af586d4c49af9dfb443aaf521bb9', '2015-08-10 21:16:00', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f7108518b27e48dba3fa8c2ee68c4767', '2015-08-12 17:21:39', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f76238231c6e47d88cf7e80c139a5e3c', '2015-08-12 17:33:24', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f797c97b63a84445995058db78554167', '2015-08-12 17:33:47', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f9612f9fecb848c0acfc96fa0c26f444', '2015-08-09 12:40:07', 'A', '2432', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('f983f9adc5d6421993a9644031fa9a7d', '2015-08-12 17:33:28', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('fa3520bf3fc942509eb135189de37b6a', '2015-08-12 17:33:36', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('faccf42115ea4e92b0024b707b56c586', '2015-08-12 17:33:30', 'B', '2373', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('fc498c70f9ce4fbf9d95f08e20dfc1fc', '2015-08-11 02:16:58', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('fc4d027d49bf4c0d9c8e0bed3651145e', '2015-08-12 17:34:00', 'A', '2390', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('fc84451a12fc422997c2f6bd3db8edba', '2015-08-09 12:41:32', 'B', '2412', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('fc9879c1fade469990fa586c47229cc0', '2015-08-12 17:33:59', 'C', '2379', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('fce76e1e9619407ba893c47d43ddd751', '2015-08-09 12:40:31', 'C', '2419', '03');
INSERT INTO `control_mearsure_voltage` VALUES ('ff624db5a7be4579bcea5fe4be438813', '2015-08-12 17:33:16', 'B', '2373', '03');

-- ----------------------------
-- Table structure for `high_voltage_current`
-- ----------------------------
DROP TABLE IF EXISTS `high_voltage_current`;
CREATE TABLE `high_voltage_current` (
  `id` varchar(32) NOT NULL,
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `phase` varchar(1) NOT NULL,
  `value` int(6) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7` (`switch_id`) USING BTREE,
  CONSTRAINT `fk_001` FOREIGN KEY (`switch_id`) REFERENCES `high_voltage_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of high_voltage_current
-- ----------------------------
INSERT INTO `high_voltage_current` VALUES ('001', '2015-08-05 09:58:05', 'A', '12', '03');
INSERT INTO `high_voltage_current` VALUES ('002', '2015-08-05 09:58:07', 'A', '14', '03');
INSERT INTO `high_voltage_current` VALUES ('003', '2015-08-05 09:58:08', 'A', '16', '03');
INSERT INTO `high_voltage_current` VALUES ('004', '2015-08-05 09:58:11', 'B', '11', '03');
INSERT INTO `high_voltage_current` VALUES ('005', '2015-08-05 09:57:48', 'A', '17', '03');
INSERT INTO `high_voltage_current` VALUES ('006', '2015-08-08 14:26:22', 'B', '11', '03');
INSERT INTO `high_voltage_current` VALUES ('007', '2015-08-08 14:26:23', 'B', '13', '03');
INSERT INTO `high_voltage_current` VALUES ('008', '2015-08-08 14:26:24', 'B', '14', '03');
INSERT INTO `high_voltage_current` VALUES ('009', '2015-08-08 14:26:25', 'C', '11', '03');
INSERT INTO `high_voltage_current` VALUES ('010', '2015-08-08 14:26:26', 'C', '14', '03');
INSERT INTO `high_voltage_current` VALUES ('011', '2015-08-08 14:26:27', 'C', '12', '03');
INSERT INTO `high_voltage_current` VALUES ('012', '2015-08-08 14:26:29', 'C', '13', '03');
INSERT INTO `high_voltage_current` VALUES ('0674389ef60d4a24b6425c5af8d29523', '2015-08-12 11:23:53', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('06e0e3c2019a46fcbf14826169ffe8e5', '2015-11-22 17:13:23', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('1187726744a34fb3821a64190833b9d3', '2015-08-12 20:24:48', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('1272ca7b79a746f79e9ea9e636271f97', '2015-11-27 21:03:00', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('18e957d596a8400c8609cfec1213f35e', '2015-11-21 23:23:15', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('297b3a33cec8443aa85d55e5b2026b08', '2015-11-22 17:13:23', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('2a49fef2db004bc9a42c1d3034072a1a', '2015-11-21 20:53:42', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('32e8f18f8f4747fdbdee389a1dea0371', '2015-08-12 11:23:53', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('484f51eb4a034987a2b18502d25f5e96', '2015-11-21 23:19:45', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('4d9a33e7a08c4a5fb79ae3ea221cf942', '2015-11-21 23:21:50', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('4dd1826e245b45dfb076c87458b5433b', '2015-11-21 23:19:45', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('53ca4ab2c5174fd5b3a572b6e43e48d0', '2015-11-21 23:21:50', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('598ef30a277c4a1a84837b5838412569', '2015-11-21 20:53:42', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('5fd6847a8d914edfa1f69a3e1e4ab98f', '2015-11-21 23:23:15', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('6de5240d6296414fb7d6bdc42a6f229d', '2015-11-21 23:21:50', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('6fd796d292e6479cae8517b05c1c45c6', '2015-11-21 20:51:20', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('7c40f6ef61fa40aa8940f04d4c5fc3a0', '2015-11-21 20:51:20', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('93752d6341744f1aaddd3581aee63195', '2015-11-22 17:13:23', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('a47822d33af449f180081a07a71afed3', '2015-11-21 20:51:20', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('b6c0f0cdc2d44a0a87617d33e882ee32', '2015-11-21 23:19:45', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('b9b084725f5047c4a00e9e3220475de9', '2015-11-21 20:56:28', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('bfae80786b9641f9b78bdc9578b0e607', '2015-08-12 11:23:53', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('c459e69438e74e789276610b3a7b8419', '2015-08-12 20:24:48', 'A', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('d2c1538313dc4c2eb523de21131ba511', '2015-11-21 23:23:15', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('d53c1fab39b7454f927ed9da258b055f', '2015-11-21 20:56:28', 'C', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('d72d3abbd5dd43adb882cb5544259d32', '2015-11-21 20:56:28', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('f897ad041b8940c091f290a47ca38df4', '2015-08-12 20:24:48', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('f93e66cca61e49619e362cae9652b26b', '2015-11-21 20:53:42', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('fb1e22a8dc7c4230a7caaab52d71e48b', '2015-11-27 21:03:00', 'B', '0', '03');
INSERT INTO `high_voltage_current` VALUES ('fd0f734e64444307ab118f414a485ca4', '2015-11-27 21:03:00', 'A', '0', '03');

-- ----------------------------
-- Table structure for `high_voltage_hitch_event`
-- ----------------------------
DROP TABLE IF EXISTS `high_voltage_hitch_event`;
CREATE TABLE `high_voltage_hitch_event` (
  `id` varchar(32) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  `hitch_reason` int(2) NOT NULL,
  `hitch_phase` varchar(1) NOT NULL,
  `hitch_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `FK_11` (`switch_id`) USING BTREE,
  CONSTRAINT `fk_002` FOREIGN KEY (`switch_id`) REFERENCES `high_voltage_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of high_voltage_hitch_event
-- ----------------------------
INSERT INTO `high_voltage_hitch_event` VALUES ('1', '108387', '0', 'A', '2016-01-05 06:47:06');

-- ----------------------------
-- Table structure for `high_voltage_switch`
-- ----------------------------
DROP TABLE IF EXISTS `high_voltage_switch`;
CREATE TABLE `high_voltage_switch` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `sim_number` varchar(20) NOT NULL,
  `device_number` varchar(30) NOT NULL,
  `longitude` float(6,3) NOT NULL,
  `latitude` float(6,3) NOT NULL,
  `inline_index` int(3) NOT NULL,
  `line_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1` (`line_id`) USING BTREE,
  CONSTRAINT `high_voltage_switch_ibfk_1` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of high_voltage_switch
-- ----------------------------
INSERT INTO `high_voltage_switch` VALUES ('03', '那思分段开关', '0001', '123', '002', '116.600', '39.915', '0', '02');
INSERT INTO `high_voltage_switch` VALUES ('07d87b3326064efbae661bb99595ee2f', '城南分段开关', '', '123', '004', '115.660', '39.915', '0', '04');
INSERT INTO `high_voltage_switch` VALUES ('108387', '团结东路开关', '119', '123', '002', '116.430', '40.000', '0', '02');
INSERT INTO `high_voltage_switch` VALUES ('15ba766213304621bfd5803f9e8d1dca', '中华支线分段开关', '007a', '123', '007', '114.500', '39.900', '0', '04');
INSERT INTO `high_voltage_switch` VALUES ('330804', '华林分段开关', '', '123', '003', '115.660', '40.000', '0', '03');
INSERT INTO `high_voltage_switch` VALUES ('4b284e9d11884188b38694d25c5ed416', '那思分段开关', '0001', '123', '002', '116.600', '39.915', '0', '04');
INSERT INTO `high_voltage_switch` VALUES ('538d46c376384b05af1a554cb7fd6964', '叫安分段开关', '', '123', '006', '116.400', '40.500', '0', '04');
INSERT INTO `high_voltage_switch` VALUES ('625175', '叫安智能开关', '', '123', '005', '114.500', '40.500', '0', '05');
INSERT INTO `high_voltage_switch` VALUES ('64771', '叫安分段开关', '', '123', '006', '116.400', '40.500', '0', '05');
INSERT INTO `high_voltage_switch` VALUES ('679281', '中华支线分段开关', '007a', '123', '007', '114.500', '39.900', '0', '06');
INSERT INTO `high_voltage_switch` VALUES ('af7469f900734f2695e585f38408a437', '华林分段开关', '', '123', '003', '115.660', '40.000', '0', '04');
INSERT INTO `high_voltage_switch` VALUES ('afeb04ed10e1482e9a7a87cb48284e0e', '团结东路开关', '119', '123', '002', '116.430', '40.000', '0', '04');
INSERT INTO `high_voltage_switch` VALUES ('d57c0cff072a46fca99f34e416cf27ec', '叫安智能开关', '', '123', '005', '114.500', '40.500', '0', '04');

-- ----------------------------
-- Table structure for `high_voltage_voltage`
-- ----------------------------
DROP TABLE IF EXISTS `high_voltage_voltage`;
CREATE TABLE `high_voltage_voltage` (
  `id` varchar(32) NOT NULL,
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `phase` varchar(2) NOT NULL,
  `value` int(6) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6` (`switch_id`) USING BTREE,
  CONSTRAINT `fk_003` FOREIGN KEY (`switch_id`) REFERENCES `high_voltage_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of high_voltage_voltage
-- ----------------------------
INSERT INTO `high_voltage_voltage` VALUES ('001', '2015-08-05 09:54:28', 'A', '220', '03');
INSERT INTO `high_voltage_voltage` VALUES ('002', '2015-08-06 09:54:29', 'A', '230', '03');
INSERT INTO `high_voltage_voltage` VALUES ('003', '2015-08-05 09:54:31', 'B', '255', '03');
INSERT INTO `high_voltage_voltage` VALUES ('004', '2015-08-05 09:54:32', 'B', '235', '03');
INSERT INTO `high_voltage_voltage` VALUES ('005', '2015-08-05 09:54:41', 'C', '230', '03');
INSERT INTO `high_voltage_voltage` VALUES ('006', '2015-08-05 09:56:43', 'A', '240', '03');
INSERT INTO `high_voltage_voltage` VALUES ('007', '2015-08-05 09:56:46', 'C', '210', '03');
INSERT INTO `high_voltage_voltage` VALUES ('008', '2015-08-05 09:56:50', 'B', '222', '03');
INSERT INTO `high_voltage_voltage` VALUES ('009', '2015-08-05 09:56:54', 'A', '244', '03');
INSERT INTO `high_voltage_voltage` VALUES ('010', '2015-08-05 09:56:57', 'B', '233', '03');
INSERT INTO `high_voltage_voltage` VALUES ('011', '2015-08-05 09:57:00', 'C', '212', '03');
INSERT INTO `high_voltage_voltage` VALUES ('012', '2015-08-05 09:57:06', 'C', '235', '03');
INSERT INTO `high_voltage_voltage` VALUES ('02e5938b2b13481fafb686c626bff947', '2015-08-12 17:21:24', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('02e7d0a26f324e4399ac8893ffa5d666', '2015-08-10 02:13:31', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('038cb9358e12400db7e738b961858c71', '2015-08-12 17:33:24', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('03e9c2c5787549749709f6d20bc93315', '2015-08-12 17:34:08', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0500ebab3cfb4949817fc525f247880f', '2015-08-12 11:17:05', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('054c1edc1eb1485ebabd6e47ebb12943', '2015-08-11 02:07:02', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('05653b411189438f8baacf3296cb11b8', '2015-11-21 20:51:19', 'B', '0', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0657bd15bdcc45039d6971d99e14dd0e', '2015-08-12 17:33:56', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0666cb38aac748c1b6f729c38d200c30', '2015-08-12 17:33:38', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('06aa50abc55a43209228b2a80a77fa4d', '2015-08-12 17:33:38', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('07aa740e5699400d9851d665464428a2', '2015-11-22 17:13:22', 'AB', '136', '03');
INSERT INTO `high_voltage_voltage` VALUES ('07c0f00f0ba346deba291768bec9e1d9', '2015-08-12 17:34:05', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('08234aff6ca0476fabe5caa3fdf1e9b6', '2015-08-12 17:33:43', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0927bdbb2db64514b2394a8eea9e3d54', '2015-08-09 12:43:58', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0ab8298e7ac64a10b235b8f55fdb7867', '2015-08-11 02:05:55', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0addb922b6bf4169892c0f7ff2c7b647', '2015-08-12 17:34:03', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0bff3f0325cf420187e23b477cbd1a54', '2015-08-12 17:33:27', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0cb8a270aeee4561b0194cbfd84028b2', '2015-08-10 02:36:33', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0cfa7a78cd7d41a5af9b6dbb5e3cbd0e', '2015-08-10 02:35:59', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0d3b3d92056e43f09a2489ead1f3d29c', '2015-08-12 17:34:01', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0d76d6f2b32c4276be4439e486068eae', '2015-08-12 17:21:22', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0e301d33b3a3495a8ef3345e5de20468', '2015-08-12 17:33:19', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0e9e2e737b0e4e9e889c8772edf9e703', '2015-08-10 21:55:45', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0eacc063cf5847feb00858ce5c09a6e7', '2015-08-11 02:20:25', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0f2a1fc1f1984530aa7126516fd3c86e', '2015-08-10 00:37:09', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0f5557457355490ba9f02c2783ee28e9', '2015-08-10 21:21:06', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('0fb39e48d46d489aabe0d85d9485657d', '2015-08-09 12:40:24', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('115f4561560244059313162a1f5e3683', '2015-08-12 17:33:50', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('129b186d13e642a28e297c5b155694bf', '2015-08-09 12:43:58', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('12b2ea181b1e4a5ca238c577c65ebd84', '2015-08-12 17:33:17', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('13945f5424854a4280095c73615018f7', '2015-11-22 17:13:22', 'BC', '0', '03');
INSERT INTO `high_voltage_voltage` VALUES ('13ab44c324244457ac8629d8c41e1915', '2015-08-12 17:33:32', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1444861a47de45339b6ffa0a7133c3f8', '2015-08-12 17:21:48', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('155efde9ca6c46898a066c390346fb68', '2015-08-11 17:59:45', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('157f249d2dd5464bac3d9bd37fe13b95', '2015-08-10 02:15:33', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('166207350edc4d879145625ace669c5a', '2015-08-11 02:14:36', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1713b790251e45cc931e1c6374d0ff6a', '2015-08-11 02:12:51', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('175bbd77155948608787fcea7e786760', '2015-08-12 17:34:01', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('17878d36372b49158bbb1a8fb3b5cae1', '2015-08-12 17:21:15', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('17c0b6e94c38459abce9663c4f7c9742', '2015-08-12 17:21:39', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('17d7e261f98248afbabd0cd916a16c1b', '2015-08-12 11:19:08', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1985e7c461504f3ea3a189628ee87ab6', '2015-08-12 17:33:42', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1aa0f44f843e43bab6b7df8aae1fc0ba', '2015-08-10 21:37:31', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1ca938bf627940fda80971657879a292', '2015-08-12 17:33:56', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1d16f5e347b84095b792cdb0d54d1246', '2015-08-10 21:38:30', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1d53de266c3c4647a0172829dcdf4932', '2015-08-10 02:12:17', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1d791a9e7bcc4485ae8675e543746510', '2015-08-11 17:59:47', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('1ea248204e9e4e1e9b019b1c45fdfe30', '2015-08-09 15:06:03', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('20e8c47db4184ebda6a22a5c730a20cc', '2015-08-10 21:21:06', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('21539c4d8c10409182a46978a95c0e6f', '2015-08-12 17:33:55', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('21da7c275ee549e8810541ab0882eb5b', '2015-08-12 17:33:31', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('221d357ab98c44ecb3bdd857a6e7b39a', '2015-08-10 21:21:06', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('229352c5c2db485d8b6e270ff5bec34d', '2015-08-12 17:20:59', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('23cce697c01c4c6a8c71d3fde6e3e433', '2015-08-12 17:33:53', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('258d954740404f4d910e1c42701a0607', '2015-08-10 02:35:13', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('260ce624d07b483aa077e02e49f23dc8', '2015-08-12 17:33:35', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('2618a9f0516d4929b63a0ea7f51dfd95', '2015-08-12 17:33:52', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('276e8a42998a4e98a2ceca6067cf3772', '2015-08-09 12:34:57', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('27e6f6df304e4ec598f83c9e11b7f01c', '2015-08-10 02:29:58', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('28844f673b104720b09b175451fde228', '2015-08-11 02:03:23', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('28ddc408637944ce948bc211fbde41e8', '2015-08-12 17:34:03', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('2a7b1ff1203244f7838d25eace265014', '2015-08-12 17:33:47', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('2a8b888b553747958b4d20cd92015be4', '2015-08-12 17:33:45', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('2acc7364c9da49a8aa9950a0ae93fe6a', '2015-08-12 17:33:49', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('2ecfa7dd146a4d2dba1d6485802b00ce', '2015-08-11 02:05:55', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('2efb0a765c4c416b99284759eb6e7e3f', '2015-08-10 02:39:33', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3139795d232c420cbfd0853e2ed85366', '2015-08-12 17:34:05', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('318ec3ddf37449e5bad430b0e834d98a', '2015-11-21 23:21:50', 'B', '100', '03');
INSERT INTO `high_voltage_voltage` VALUES ('335fae61639a46d48e0f5fa025b5e2cf', '2015-08-12 17:21:24', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3503ea1c76044b1781f7fd6e5f89340f', '2015-08-12 17:33:28', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3517977935684ba0ad42a9720b3e7ac9', '2015-08-12 17:21:22', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('35ffb11dfe1c42feb6615c10f114678f', '2015-08-12 17:33:54', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3782ce457125424483d1cc81f205bc05', '2015-08-12 17:33:59', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('37cf41ce738349c2993fef66da3d4083', '2015-08-09 12:41:21', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('39bb360ba5e244ee994bf7278b0d67df', '2015-08-10 00:37:09', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3ae5cae4a41549ea88a649424c7581b3', '2015-08-10 00:37:09', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3b0cab5e80594684be984f3af7ba9407', '2015-08-10 02:39:33', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3b48a28dbc5d46b8bf5d6bf691946189', '2015-08-12 17:33:16', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3cb168254783454abe5c66399ab4b989', '2015-08-10 02:05:10', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3cbf43b530ba4b459528d3ed07c1afa2', '2015-08-11 17:59:45', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3d4c273cdcd54146ae2c16569a130858', '2015-08-09 15:06:03', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3e778cf5573246e6b38d64bbd54eb444', '2015-08-11 17:59:46', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3f60ec2a0a254734a3178fc3ffaba951', '2015-08-10 21:56:00', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3f6e978ce04447539c22771a194248d8', '2015-08-10 02:35:13', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3fc19161cc224fca96d2176e90c1fce0', '2015-08-12 17:33:33', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('3fecdc2fe17d472581c806f0631283de', '2015-08-12 17:21:23', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4000b3e6a0b348feab3d6550232887da', '2015-08-10 02:35:49', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('400207cf853843ad948b272d1b988ac6', '2015-08-10 02:35:59', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('40088aed4d9d4f178cc702436a020f6f', '2015-08-12 17:33:20', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('404a6e77b05a4ae6b4ead8baa7ba786f', '2015-08-10 21:59:22', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('40ce21a4653f47039c6d5c605c9b6dbb', '2015-08-09 12:40:07', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('40e01dd36ba94c0188fc3d24a71f939a', '2015-08-12 17:34:09', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4322e6ebe5ff4dfe876c97021b0ef295', '2015-08-10 00:35:19', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4370f355848b4256882d573d5814163b', '2015-08-12 17:21:22', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('45012d52835f48fe947ddbe0a326bbbd', '2015-08-12 17:21:48', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('45d3d5bf1a40438c8ec709020d2b8844', '2015-08-12 11:19:08', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('47a1129b99c34d1793753ec8730ccb5c', '2015-08-10 21:59:22', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('47d62cf9b158400d975e6a582ee118cf', '2015-08-12 17:34:04', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('488622e3fbe94ad89a5fec8bc76ce6d4', '2015-11-21 23:19:45', 'A', '100', '03');
INSERT INTO `high_voltage_voltage` VALUES ('492870e21ccf45fda578b02889540030', '2015-08-10 02:36:23', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4a2cf46957e345e58b330c515a47deaf', '2015-08-11 17:59:46', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4ac31b52ce13451a89b5ce0e2fad432d', '2015-08-10 21:37:31', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4bde3a219cef4e4b800759c5055ca879', '2015-08-12 17:33:57', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4c0101e6020a40d895178d4c4992409b', '2015-08-12 17:34:07', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4d503727d6bf4613810ed8f4c5847241', '2015-08-12 17:33:17', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4dac19fef7cf447799f3c407984bc7c0', '2015-08-12 17:21:15', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4df45c42d9c3420cb1e6bde022e35188', '2015-08-11 02:16:58', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4e3d9d570d984ea9bab0422209584c78', '2015-08-10 02:36:27', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4f03e091ec0d4728828288b58b3fe0df', '2015-08-11 02:12:51', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('4f5d7d3b616e48008ce045788aabd6fa', '2015-08-11 17:59:48', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5011b2ba96aa4ccebe74ae035eab072e', '2015-08-10 02:39:33', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('50ca3fac535944b68bd155d30cd6512e', '2015-08-12 17:33:39', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('50f6d08d81464a9882e82be4042a5d0c', '2015-08-10 02:33:26', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('50fbf3d4c2994895adfe76e7717200b2', '2015-08-12 17:33:30', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5127459853b240939b514ca0287efb40', '2015-08-11 02:07:02', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('522c4117ab6f473797ce759c9fcc0765', '2015-08-09 12:41:25', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('52b8bc36d32d44bcbfedafbc49b3ed73', '2015-08-12 17:33:37', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('53fbd05e240e458aa393cd9858c38a0c', '2015-08-12 17:33:50', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5442934fa569412db51e7c788eda5ba9', '2015-08-10 02:39:45', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('54e66c6d110343978a8ed407f827ac8f', '2015-08-12 17:21:22', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('55847862b4a541829fcbec138c06d152', '2015-11-21 20:53:41', 'B', '0', '03');
INSERT INTO `high_voltage_voltage` VALUES ('55ea2081fcb34d398c420047d8615492', '2015-08-12 17:33:21', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('571a9ae4e4e74dd5b2a3203f0b8be3ad', '2015-08-12 17:21:48', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('575d9c570d214e48a570c72c64ca7543', '2015-08-10 21:40:59', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('575eeeb4cd5d471c834e90f11fde4521', '2015-08-09 12:40:24', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('57ac6ff1a43e433d85f4493527a3f116', '2015-08-10 00:40:20', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('57c6f727f2914b419393807dd90e6d83', '2015-08-10 02:15:33', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('58549cf497c74595953934c69bd07a6d', '2015-08-10 02:13:31', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('598b70eefcf14734b4e757ee2baca757', '2015-08-12 17:21:15', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5abc937b1d0b4d308b64d083f85a22ee', '2015-08-10 02:05:10', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5b4ca08334ac4e08a41d38496a29a838', '2015-08-11 02:05:55', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5c686b511d4a40c68de6fb358980c239', '2015-08-12 17:33:17', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5cb3363f065d49e19e8d54e8c260de42', '2015-08-12 17:33:36', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('5fa5c56aa71c4c87949469e6cedbebce', '2015-08-11 02:20:25', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6038007359bb498faf0abd496af2ce99', '2015-08-12 17:33:33', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('604d464eb1ea41ddbd588750bb937c26', '2015-08-10 21:37:31', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6051aa1d0d3d4a54b126399ba33913c2', '2015-08-10 02:29:58', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('60d14d695577407e8a7af8fa4f678236', '2015-08-12 17:21:23', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6210d1c7b28940448c52be041be600aa', '2015-08-09 12:41:32', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('625fd3a7c36e4c589a1580808027794b', '2015-08-09 12:34:57', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6268b8dc754b4cfb849fda947dae08a4', '2015-08-12 11:19:08', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('62a441a0d1a34e3e8a7be1e3380985b7', '2015-08-10 02:36:27', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('62c118c87947425b802d08cf40ee0068', '2015-08-12 17:33:46', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('63d6ee2474d1499cac252750b98eaaac', '2015-08-10 21:56:00', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('652123120abd48468358821ab0c6c449', '2015-08-09 12:43:49', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('652a6391bb8b4609a24fc29d715379e0', '2015-08-10 02:49:16', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('655307fb1ed44422a52a7f05d768debb', '2015-08-11 02:14:36', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('658132af9fc74cb88d1901fbf24f98c1', '2015-08-09 12:43:49', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6628c2cd0b49477c8970b361ed8f830e', '2015-08-10 21:38:29', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('66d2cbf4fcd14335a3acdfb89712c5ec', '2015-08-12 17:21:15', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('67a240f6ee224baca9ba6f0e870dc1d1', '2015-08-10 02:35:59', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('68b12c2996b44cc7910a4532ffddc684', '2015-08-09 15:05:54', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6a01bad3a2ea44cd859f2451c2c04c72', '2015-08-10 00:35:19', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6a0ac180cdf54464856b6a6af68233fe', '2015-08-12 17:33:35', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6a151338130142ed9637813319205a5d', '2015-11-21 23:23:15', 'A', '136', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6b4013d9586e408a8dd783cd94c0cca6', '2015-08-12 11:17:05', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6baf00f586ca42a69866f06a6c4487e2', '2015-08-10 02:35:59', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6ece6cf64cc14c98ab99b7cd363e880a', '2015-08-12 17:20:59', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6f61bfa5f8e5403ab7dba4271b113c6b', '2015-08-12 17:33:53', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6faabaab90cb41a493112b6f8cede1ff', '2015-08-12 17:33:53', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('6fd7af5e8c244b929ad2cd8fbe54f228', '2015-08-09 12:41:25', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7079abf31bc44472a01d3fe1b8ea1d86', '2015-08-11 02:04:26', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('710e2cddf6be4b5a8b1c523e8e4113d1', '2015-08-09 12:40:30', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('725fc8cb289e4642a82ca1477c609a56', '2015-08-12 17:34:04', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('72618cff8c8f4788ba2aa6ec756334cb', '2015-08-11 02:03:23', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('737afac406324a8dbecf13451b12eac7', '2015-08-12 17:33:35', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7439cf4132244157afa12c7db3521bbb', '2015-08-12 17:20:58', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('745cb88ad4254ecf8124ee5f630e5c51', '2015-08-09 12:34:57', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('746102d282834f168ca6d2f243109c56', '2015-08-12 17:34:06', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7467881eb08945cc9c528b1d18928d33', '2015-08-10 21:38:30', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('749bf718d0974f15b128ec704a85c4cb', '2015-11-21 23:19:45', 'B', '100', '03');
INSERT INTO `high_voltage_voltage` VALUES ('75ae8d174c6c41639a0c1e2f11c714e9', '2015-08-11 02:26:25', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('763c6122849d40a3a80ddd1e494f85a5', '2015-08-12 17:33:26', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('76ad73f8f14e4826b3931f822fdb784d', '2015-08-12 17:21:39', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('76d3597348f14c4bb24c02b3430c66dc', '2015-08-10 21:55:45', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('76dcd21b473d4689a1e8417267c59ce9', '2015-08-12 17:33:40', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('77518cb57c71417e970427af4a25373c', '2015-08-10 21:53:59', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('77ca4076839f4fd398101d768084bd2b', '2015-08-10 21:40:59', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('78c07f8d56584d58a234fc4f1e70d374', '2015-08-10 02:39:45', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('78e1a27bb695448cbbe1b79a34ca2d57', '2015-08-12 17:21:39', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('79310400b5cf4092b937242b20abe766', '2015-08-12 17:34:02', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7a58c7b8bcd3416d8325a65a9c51a5c0', '2015-08-11 17:59:48', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7a65f633f5cd4bc9be3794fb013235f5', '2015-08-09 12:43:58', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7bf5a2f33a034554bbbcca4dbe565609', '2015-08-12 17:20:58', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7c2a90f2fffb4b0798446b0c32d272c8', '2015-11-27 21:03:00', 'BC', '0', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7d038fe76ae84b65ae944eddd6dc6ecf', '2015-08-12 17:34:04', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7d7b270377e441e883c798d0dc417630', '2015-08-10 02:35:59', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7d80317df6f84d7da4731b7226dd4290', '2015-08-10 02:49:16', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('7e51aa56ac5141f2bba81cba70d404a3', '2015-08-09 12:35:01', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8046d6ce94a04f05b4d2646952868c36', '2015-08-12 17:33:58', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8058c239d76241cb8d2c8429cb6be5cb', '2015-08-12 17:33:42', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('80cf8652154d4cb1a519ea0f635058ef', '2015-08-12 17:34:06', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('80de27b8de5f460b9cf32fa2da27ff65', '2015-08-10 21:55:45', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8111f99af6ce4607b6a66c927885be5b', '2015-08-12 17:33:16', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8123387be29241318fb2d9a2657daf40', '2015-08-09 15:05:54', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8131bf9d3761408485b1a6d89b968dea', '2015-08-12 17:34:06', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8284eab242d843d18375a42ec8b494c4', '2015-08-12 17:33:34', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('83a73d395acb42f49ec35cde090a0933', '2015-08-10 02:35:13', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('84423fbac6df44f091c532bf42de9969', '2015-08-12 17:33:26', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('84465243c0d3432f96af3c5036b582fd', '2015-08-11 17:59:47', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('846f7632d05145039ef2d6c5f52667d6', '2015-08-09 12:40:30', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('84a098fc8f404acd8e461bcec6895d06', '2015-08-12 17:34:09', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('85554963d32f40c5998914702a46d1c9', '2015-08-12 11:17:17', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8612faad40204753ab8acfcc251d1a14', '2015-08-12 17:33:54', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('86d3410f2cdb48af9c71f161fdf0fb9c', '2015-08-12 17:33:50', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('87702a582697494e9918f435cae749b1', '2015-08-12 17:33:20', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('885e6f020dc947c0a960c0d543d1d532', '2015-08-12 17:33:28', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('889c082c431f492e86c1fb997b3295cf', '2015-08-12 17:33:58', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('890dce6cfba643b5880ce0bb69c96f57', '2015-08-12 17:33:34', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8960db57ea4e43a1a493089d9397e5d9', '2015-08-12 17:21:23', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('89c11e63bc6346eb861cdacfe30fe580', '2015-08-12 17:33:49', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8ae3d4a01d5d48ccb6675fada36a155e', '2015-08-12 17:33:24', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8e835fbf0dd948628587bb8ea6977dc5', '2015-08-12 17:33:29', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8f9624c42c12497c87b85ca0f3f29054', '2015-08-12 17:34:00', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('8ffe2eef4b204368adeafe64d111d299', '2015-08-12 17:33:37', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('900ad3b6e5844fd9a6906d322855f98f', '2015-08-10 02:34:04', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('904bcb67852b417486af163bde96430a', '2015-08-12 17:33:52', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9058c7d4289f417fafd40567f3ac0416', '2015-08-12 17:33:45', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('921a39fb8f47462fa1c5bb636879ff33', '2015-11-21 23:23:15', 'B', '0', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9265e86d0ee04c66a3e082a456ccacbd', '2015-08-12 17:33:45', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('92e191aed9124393aa01f6991290177f', '2015-08-12 17:33:37', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9345aa7412924d7996ce3767b08e65dd', '2015-08-12 17:21:22', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9415027a19014b849e10521988ee1d32', '2015-08-12 17:33:19', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('953c2d98a10c495d91453417d8ae189a', '2015-08-12 17:34:08', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('960dde62c09a438e9735b60d1a25692c', '2015-08-12 17:33:49', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('967f9992735e4786a4a5ca7342ba44d7', '2015-08-12 17:33:39', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('970ff2d2426e498ea5fb67ec35b339bb', '2015-11-21 20:51:19', 'A', '236', '03');
INSERT INTO `high_voltage_voltage` VALUES ('97648c5263f94ed6ba092062fe250196', '2015-08-12 17:33:55', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('981cc36c82c04380b4cb1f48ddfe93da', '2015-08-12 17:33:42', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9dd4e256ecf84789bdae9420a916cc3c', '2015-08-12 17:20:19', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9e5c4c33b6964fe392fabf58d3984e28', '2015-08-09 12:40:30', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9efa92edecbb43ddb24bd1e1d897e5c7', '2015-08-12 17:34:05', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9f7b8c3024eb4a938365a22084750aa8', '2015-08-12 17:34:00', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('9f9a3d043ba14f609ee5ecdffb04f895', '2015-08-09 12:35:01', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a0e113f382174d50b1414e43ee0ff128', '2015-08-09 12:40:24', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a0e35e64a3374a058c30ad80d0bf1ad6', '2015-08-09 12:41:21', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a1d1ea1522ae486ebe68e17a5e63a4da', '2015-08-11 02:20:25', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a210974abbe44c7e8e1f1ad739ca0502', '2015-08-12 17:33:22', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a2a5fc681a4c401588ba1be157a1b8cb', '2015-08-12 17:34:02', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a32aa483fdfb406e8fe6dd0eb9007533', '2015-08-10 21:38:30', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a417ce3feb8d40f4865710d894e36824', '2015-08-12 17:33:33', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a4a01a6ce03e4575b363d589cabab847', '2015-08-12 17:34:03', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a4c98d5c79c64802aa76355b126effec', '2015-08-11 02:04:26', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a4f3c07afa9946cfbf183a25eb096da9', '2015-08-09 12:41:21', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a59952df99be481aaed1380b6ac7a899', '2015-08-12 17:21:39', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a5b3008d369549dda5c8550b44d40182', '2015-08-10 02:33:26', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a5ffd597ffc946ab9bc2785d3b9687d6', '2015-08-10 02:15:33', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a6967f929d204aeea245436862f24d07', '2015-08-12 17:20:59', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a70e680ce50e4c9b819a76956cebc722', '2015-08-12 17:33:43', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a744cce55e19428fad95104f9ba764cb', '2015-08-12 17:33:48', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a7e6bb39502a4ddab6191034f6a51ce7', '2015-08-12 17:33:18', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a84a1481d05d4565b41fea0c1c210d8c', '2015-08-09 12:41:25', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a9ba397ab3a54776959b9a0e10ce8624', '2015-08-12 17:21:39', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('a9fb5dcb5d524b208e8e876906b20abd', '2015-11-21 20:53:41', 'A', '236', '03');
INSERT INTO `high_voltage_voltage` VALUES ('aa95eb54f5ab4dfdb63100900b2818af', '2015-08-12 17:33:22', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('acc80a524a8b4942bcb8fb48ced21919', '2015-08-10 02:05:10', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('adaf81d16cad416c9c439780ab288559', '2015-08-10 02:34:04', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ae664127eee04edc9a58e3af98117570', '2015-08-12 17:33:58', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('aeb3b59623324585a9f5865ec8a12105', '2015-08-10 02:35:49', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('aec233cf1ac24408a129f23ab686496b', '2015-08-11 02:04:26', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('af3a120dc8af417e9d6634e34191f686', '2015-08-12 17:33:32', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('af5ce986e3b9400381f579f97232f1bb', '2015-08-11 02:16:58', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('afb87d4e901d443490345d4a770408af', '2015-08-09 12:35:01', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b00d8c411ea843f1b39c483bbb758406', '2015-08-12 17:34:01', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b072cae7e53f413fa311a0292c5b7bf6', '2015-08-12 17:33:32', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b0936758a55342a7bcba5dcf024303e6', '2015-08-09 15:06:03', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b09f922dce4c4770a13d833deaeb6323', '2015-08-11 02:02:08', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b0ce412b34c84066a8c71577f945b914', '2015-08-10 02:13:31', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b28d9fe504854aeeab2ce8aa4657a767', '2015-08-12 17:20:58', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b2a9283a9eab4bf38a476598e18b98c7', '2015-08-12 11:17:05', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b3b7ddeffae64bd4939c4099295c9137', '2015-08-09 12:40:07', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b3d251448e304d08a5f2bcd4a171e280', '2015-08-12 17:33:27', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b42aac92044f4918b567648dfff661c6', '2015-08-12 17:33:52', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b574faf67e52452a84685afe96108b91', '2015-08-12 17:33:44', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b645dea90dad449c9423215ec81a3dc0', '2015-08-10 00:40:20', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b6951a56054f49f69835235927863739', '2015-08-10 21:40:59', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b6e032beb3c34f83b44b350a508c5cd7', '2015-08-10 02:29:58', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b77b9bccb0b84552bc37e3cb81e62585', '2015-08-10 02:39:45', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b80ed22a65514fd1948797b0bee354fa', '2015-08-12 17:33:19', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b81923ea42ee4943b740ca057d10ab03', '2015-08-12 17:33:57', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('b996dcc54cc44fbea41cd8e51ede2683', '2015-08-12 17:34:07', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bac11b185c7b499ab8869b3609236ca6', '2015-08-10 02:36:23', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bac7d5f1c2464d0bad3b1b3297d142e3', '2015-08-10 21:38:29', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bbbd0ab8948c4acd8455ae8403f596ff', '2015-08-10 02:36:23', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bc4c373e22804906b641c72beda281bb', '2015-08-12 17:33:44', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bc8716b9bdd943ee8cb7ad00fa3d72c7', '2015-08-12 17:33:46', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bc909445c9ea4d8d930bf0088d554169', '2015-08-12 17:33:48', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bd195ebfa289445b921f7d76bbb838ff', '2015-08-12 17:33:27', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bdd3b413b5914e6aab9c94eeea4635ba', '2015-08-12 17:33:48', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('be38a6af4e2a445986e1509b1d94983a', '2015-08-11 02:26:25', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('be95142469e74c29acae5f561815f642', '2015-08-12 17:33:23', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bed5a7c06d624589b1405053af47c9a2', '2015-08-11 17:59:48', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('befc3dce3fb74697b086afb6cbed65c9', '2015-08-11 17:59:45', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bf4e71897ee74800a2a76e7d213ea675', '2015-08-12 17:33:54', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bf6b24fb39de4eedba2bdd756fe0fac2', '2015-08-09 12:40:31', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('bf8c4ed5f13d4b0a9c642809e3151f79', '2015-11-27 21:03:00', 'AB', '236', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c03f208c23bf4e2eb4a66bf731483a23', '2015-08-12 17:33:23', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c042927b2cef4383b6bba8874baa0250', '2015-08-10 02:35:49', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c065fbc5123343c398158bbec006449f', '2015-08-10 00:40:20', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c1027a72842142d085eb5e4484c1eb4c', '2015-08-12 17:34:02', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c3849dd2765842629b465540b61f60fd', '2015-08-12 17:33:34', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c3ff37fb79a24bf0bf7995b940e76efe', '2015-08-10 21:56:00', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c5d0f534308c42cb8b37cd5aaa048c98', '2015-08-12 17:33:47', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c655990369a14402928d21850879327c', '2015-08-10 21:59:22', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c9048632fc6c4fc4adda867af797cb4c', '2015-08-10 02:36:33', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c90e6e0ce3cf440f87d0b255ef71ebde', '2015-08-09 12:41:32', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('c9a07c6b6b3242e8981512392dbee9ab', '2015-08-12 17:33:46', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('cbef21e5ef034ed09a5cbbd22a3f0168', '2015-08-09 12:43:49', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ce61f87cec8a4da0aba633b849fde921', '2015-08-12 17:33:59', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ce88bee621d04ea28ba8a963bc50572f', '2015-08-12 17:33:43', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('cf05a61f7c5245f098c26bff1a7ae8e6', '2015-08-12 17:33:23', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d046a8303dc7456aa987f0c2d854785d', '2015-08-11 17:59:46', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d09aae0c28ec4019affb85f702bbb1db', '2015-08-11 02:26:25', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d120d5e0688d45e2ae58bd183cd01ec5', '2015-08-12 17:33:31', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d25e8c77a55a4df09fb7227af2a97d32', '2015-08-12 17:21:24', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d2a3e4f7d33c4d2681ab420257eb733e', '2015-11-21 20:56:28', 'B', '0', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d2fd3c9974a24d1f86f56e2797343979', '2015-08-12 17:33:57', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d42b4d917fca4c0e87f19230fdb5d1bf', '2015-08-12 17:33:36', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d45803458ad5410e85bb4f17faa9961c', '2015-08-12 11:17:17', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d5b21e3757204ec0aaf05c32cfea6b4f', '2015-08-10 00:35:19', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d5bc0f774f5542d79a0cc3ab3f07c110', '2015-08-11 02:02:08', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d6160d0e1ebe4f7e879c28bef63dfcb6', '2015-08-12 17:20:19', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d806d9e40d2445a0aa09a3c592d22b28', '2015-08-10 02:36:33', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d814ad81d8b44bfca4457f5033b0714a', '2015-08-10 21:53:59', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d841b96395a04216a3f2eec980c35ad7', '2015-08-10 02:49:16', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('d897aa3d8ea24a6c964b14abf7872792', '2015-08-12 17:33:38', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('da676621b820441fb56fe3fbd24693e3', '2015-08-10 02:35:59', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('daea3c914f2049b897041d1d0cf522b9', '2015-08-09 15:05:54', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('db4e51fa01c548199b03458a18f64b58', '2015-08-12 17:21:15', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('de83018700ff43e891acb4a1d213b5f8', '2015-08-11 02:02:08', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('df22461b866547a68b822860f9d17616', '2015-08-11 02:12:51', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('dfecdb601461435791e5e8db038d3c38', '2015-08-12 17:33:44', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e005db0aa24d4f8db6deaa96dc2f27f0', '2015-08-12 17:34:07', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e01e7caa6f524cc2a4053ae125600d12', '2015-08-12 17:33:21', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e03f21d0edb542b68201ecc92198aac2', '2015-08-12 17:21:22', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e08ad620b9ee47c59f777db50cc68e44', '2015-08-10 02:36:27', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e0bd8a237e604e55aff69ca6614a12aa', '2015-08-12 17:33:29', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e19201d551bc45ee87c3d9dbe12636da', '2015-08-12 17:33:22', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e204c41a351f40f18f4106d478f0e1e1', '2015-08-12 17:33:40', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e23f8f1b7aad4c2a8372bfb44b70c582', '2015-08-12 17:33:55', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e3b7d4cd87174f71af6603b1fbb6b497', '2015-08-12 17:33:18', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e4939c2a900940f7b4001e48f59fcdad', '2015-08-12 11:17:17', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e6ea52953b4c43ada3934e9e81eb247d', '2015-08-12 17:34:08', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e7396127f84c4338b06767a5eea07855', '2015-08-09 12:40:31', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e7c2a21178b34c9fba9e913bd9558f3a', '2015-08-12 17:33:56', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e8421dcc33994d3cbc50d7da3c2a812f', '2015-08-11 02:03:23', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e8bf8e38ba5a44639aff5263c9d5477c', '2015-08-12 17:34:09', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('e92ee23b653f444eacbf769d5ac04433', '2015-08-10 02:12:17', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ea23ec970ce14ccea5a8ee5fd4177f48', '2015-08-11 17:59:47', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ea48ed5a018e4104b90f5896a417a1dd', '2015-08-10 02:12:17', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ea689e51570f437d9ef45125a599d46d', '2015-08-11 02:07:02', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('eaa4223b74e1452aac81328a72746381', '2015-08-11 02:14:36', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('eafeff93dcc34efc859a2f58fda6e0ba', '2015-08-12 17:33:40', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ecd236d72f8a4addb4a1612b7ac44a35', '2015-08-10 21:53:59', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ed4c78f2c97c48d0a2f9bda2d1ccb6d5', '2015-08-10 21:16:00', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('edb9b709d54d40a5a6ace4fc06baff57', '2015-11-21 23:21:50', 'A', '100', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f053578c3e11426eb9343bb7a6b1a9bb', '2015-08-12 17:20:19', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f06b4159380e434b9f998b191b39c180', '2015-08-10 21:38:29', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f0e1317954004ebcbc07833af6e22045', '2015-08-12 17:33:31', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f11093eb32b342faa291f2b35e4b78bb', '2015-08-12 17:33:20', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f120e34fe6a643f3af3d22a2c94df982', '2015-08-10 21:16:00', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f1499b67768f473a9d1fae1b4ecc6af5', '2015-08-12 17:33:21', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f1ecb7b853364690ab170449f477fe86', '2015-08-10 02:33:26', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f27bfa3c51b24a6a88315a20080528eb', '2015-08-12 17:33:18', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f2e1b1273d22425d9ee91170e4521a9c', '2015-08-10 02:34:04', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f499df1baa9d48f0a84c4d656b46bc4a', '2015-08-12 17:33:39', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f4c9a55fd73249d895db2e20a6e5811c', '2015-08-12 17:33:26', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f50809f39b1849679a583bc8ad4e2259', '2015-08-12 17:21:15', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f57a49f4c3274dbf94a527fba35d37ed', '2015-08-12 17:33:29', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f5b8af5114cb4986a0e2d90c64a27b28', '2015-08-12 17:33:30', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f6c1af586d4c49af9dfb443aaf521bb9', '2015-08-10 21:16:00', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f7108518b27e48dba3fa8c2ee68c4767', '2015-08-12 17:21:39', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f76238231c6e47d88cf7e80c139a5e3c', '2015-08-12 17:33:24', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f797c97b63a84445995058db78554167', '2015-08-12 17:33:47', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f8b3b03fa9c849f584c8292a3b9de27b', '2015-11-21 20:56:28', 'A', '240', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f9612f9fecb848c0acfc96fa0c26f444', '2015-08-09 12:40:07', 'A', '2432', '03');
INSERT INTO `high_voltage_voltage` VALUES ('f983f9adc5d6421993a9644031fa9a7d', '2015-08-12 17:33:28', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('fa3520bf3fc942509eb135189de37b6a', '2015-08-12 17:33:36', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('faccf42115ea4e92b0024b707b56c586', '2015-08-12 17:33:30', 'B', '2373', '03');
INSERT INTO `high_voltage_voltage` VALUES ('fc498c70f9ce4fbf9d95f08e20dfc1fc', '2015-08-11 02:16:58', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('fc4d027d49bf4c0d9c8e0bed3651145e', '2015-08-12 17:34:00', 'A', '2390', '03');
INSERT INTO `high_voltage_voltage` VALUES ('fc84451a12fc422997c2f6bd3db8edba', '2015-08-09 12:41:32', 'B', '2412', '03');
INSERT INTO `high_voltage_voltage` VALUES ('fc9879c1fade469990fa586c47229cc0', '2015-08-12 17:33:59', 'C', '2379', '03');
INSERT INTO `high_voltage_voltage` VALUES ('fce76e1e9619407ba893c47d43ddd751', '2015-08-09 12:40:31', 'C', '2419', '03');
INSERT INTO `high_voltage_voltage` VALUES ('ff624db5a7be4579bcea5fe4be438813', '2015-08-12 17:33:16', 'B', '2373', '03');

-- ----------------------------
-- Table structure for `line`
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `substation_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_10` (`substation_id`) USING BTREE,
  CONSTRAINT `line_ibfk_1` FOREIGN KEY (`substation_id`) REFERENCES `substation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('02', '县城一线', '002');
INSERT INTO `line` VALUES ('03', '华林二线', '002');
INSERT INTO `line` VALUES ('04', '城南线', '001');
INSERT INTO `line` VALUES ('05', '叫安线', '001');
INSERT INTO `line` VALUES ('06', '中华线', '001');

-- ----------------------------
-- Table structure for `low_voltage_current`
-- ----------------------------
DROP TABLE IF EXISTS `low_voltage_current`;
CREATE TABLE `low_voltage_current` (
  `id` varchar(32) NOT NULL,
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `phase` varchar(1) NOT NULL,
  `value` int(6) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7` (`switch_id`) USING BTREE,
  CONSTRAINT `low_voltage_current_ibfk_1` FOREIGN KEY (`switch_id`) REFERENCES `low_voltage_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of low_voltage_current
-- ----------------------------
INSERT INTO `low_voltage_current` VALUES ('001', '2015-08-05 09:58:05', 'A', '12', '03');
INSERT INTO `low_voltage_current` VALUES ('002', '2015-08-05 09:58:07', 'A', '14', '03');
INSERT INTO `low_voltage_current` VALUES ('003', '2015-08-05 09:58:08', 'A', '16', '03');
INSERT INTO `low_voltage_current` VALUES ('004', '2015-08-05 09:58:11', 'B', '11', '03');
INSERT INTO `low_voltage_current` VALUES ('005', '2015-08-05 09:57:48', 'A', '17', '03');
INSERT INTO `low_voltage_current` VALUES ('006', '2015-08-08 14:26:22', 'B', '11', '03');
INSERT INTO `low_voltage_current` VALUES ('007', '2015-08-08 14:26:23', 'B', '13', '03');
INSERT INTO `low_voltage_current` VALUES ('008', '2015-08-08 14:26:24', 'B', '14', '03');
INSERT INTO `low_voltage_current` VALUES ('009', '2015-08-08 14:26:25', 'C', '11', '03');
INSERT INTO `low_voltage_current` VALUES ('010', '2015-08-08 14:26:26', 'C', '14', '03');
INSERT INTO `low_voltage_current` VALUES ('011', '2015-08-08 14:26:27', 'C', '12', '03');
INSERT INTO `low_voltage_current` VALUES ('012', '2015-08-08 14:26:29', 'C', '13', '03');
INSERT INTO `low_voltage_current` VALUES ('0674389ef60d4a24b6425c5af8d29523', '2015-08-12 11:23:53', 'A', '0', '03');
INSERT INTO `low_voltage_current` VALUES ('1187726744a34fb3821a64190833b9d3', '2015-08-12 20:24:48', 'C', '0', '03');
INSERT INTO `low_voltage_current` VALUES ('32e8f18f8f4747fdbdee389a1dea0371', '2015-08-12 11:23:53', 'C', '0', '03');
INSERT INTO `low_voltage_current` VALUES ('bfae80786b9641f9b78bdc9578b0e607', '2015-08-12 11:23:53', 'B', '0', '03');
INSERT INTO `low_voltage_current` VALUES ('c459e69438e74e789276610b3a7b8419', '2015-08-12 20:24:48', 'A', '0', '03');
INSERT INTO `low_voltage_current` VALUES ('f897ad041b8940c091f290a47ca38df4', '2015-08-12 20:24:48', 'B', '0', '03');

-- ----------------------------
-- Table structure for `low_voltage_hitch_event`
-- ----------------------------
DROP TABLE IF EXISTS `low_voltage_hitch_event`;
CREATE TABLE `low_voltage_hitch_event` (
  `id` varchar(32) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  `hitch_reason` int(2) NOT NULL,
  `hitch_phase` varchar(1) NOT NULL,
  `hitch_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `residual_current` int(4) NOT NULL,
  `behitch_a_phase_voltage` int(4) NOT NULL,
  `behitch_b_phase_voltage` int(4) NOT NULL,
  `behitch_c_phase_voltage` int(4) NOT NULL,
  `behitch_a_phase_current` int(6) NOT NULL,
  `behitch_b_phase_current` int(6) NOT NULL,
  `behitch_c_phase_current` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_11` (`switch_id`) USING BTREE,
  CONSTRAINT `low_voltage_hitch_event_ibfk_1` FOREIGN KEY (`switch_id`) REFERENCES `low_voltage_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of low_voltage_hitch_event
-- ----------------------------
INSERT INTO `low_voltage_hitch_event` VALUES ('7e8ac1350c86427c8969455bdc0e7d38', '03', '11', 'A', '2004-04-25 07:22:59', '0', '2395', '2387', '2405', '0', '0', '0');
INSERT INTO `low_voltage_hitch_event` VALUES ('cb19c79c15ac4297a1f33e4a0cd84d18', '03', '12', 'A', '2004-04-22 23:01:00', '0', '2377', '2370', '2389', '0', '0', '0');

-- ----------------------------
-- Table structure for `low_voltage_switch`
-- ----------------------------
DROP TABLE IF EXISTS `low_voltage_switch`;
CREATE TABLE `low_voltage_switch` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `sim_number` varchar(20) NOT NULL,
  `device_number` varchar(30) NOT NULL,
  `longitude` float(6,3) NOT NULL,
  `latitude` float(6,3) NOT NULL,
  `inline_index` int(3) NOT NULL,
  `status` varchar(1) NOT NULL,
  `line_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1` (`line_id`) USING BTREE,
  CONSTRAINT `low_voltage_switch_ibfk_1` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of low_voltage_switch
-- ----------------------------
INSERT INTO `low_voltage_switch` VALUES ('02cdd30a96d647789c10682a033de7e8', '华林分段开关', '', '123', '003', '115.680', '40.000', '0', '1', '04');
INSERT INTO `low_voltage_switch` VALUES ('03', '那思分段开关', '000000000001', '123', '002', '116.400', '39.915', '7', '1', '02');
INSERT INTO `low_voltage_switch` VALUES ('0e45aca26dc941299aefa59b6fcdb955', '叫安分段开关', '', '123', '006', '116.400', '40.500', '1', '0', '04');
INSERT INTO `low_voltage_switch` VALUES ('0ecade2e083a4bfd9c04d547b8f9a0b4', '团结东路开关', '119', '123', '002', '116.430', '40.000', '2', '0', '04');
INSERT INTO `low_voltage_switch` VALUES ('61ca503152f94bd48735154ff83fc96c', '中华支线分段开关', '007a', '123', '007', '114.500', '39.900', '5', '0', '04');
INSERT INTO `low_voltage_switch` VALUES ('941318d5562e453f8a4fac68bc2d1dfb', '团结东路开关', '119', '123', '002', '116.430', '40.000', '8', '0', '03');
INSERT INTO `low_voltage_switch` VALUES ('95b7275313dc4baa986897c19486f676', '叫安智能开关', '', '123', '005', '114.500', '40.500', '9', '0', '03');
INSERT INTO `low_voltage_switch` VALUES ('e9a962a93f4e4188be5a9fa63054025f', '城南分段开关', '', '123', '004', '115.660', '39.915', '0', '0', '04');

-- ----------------------------
-- Table structure for `low_voltage_voltage`
-- ----------------------------
DROP TABLE IF EXISTS `low_voltage_voltage`;
CREATE TABLE `low_voltage_voltage` (
  `id` varchar(32) NOT NULL,
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `phase` varchar(1) NOT NULL,
  `value` int(6) NOT NULL,
  `switch_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6` (`switch_id`) USING BTREE,
  CONSTRAINT `low_voltage_voltage_ibfk_1` FOREIGN KEY (`switch_id`) REFERENCES `low_voltage_switch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of low_voltage_voltage
-- ----------------------------
INSERT INTO `low_voltage_voltage` VALUES ('010', '2016-01-08 09:56:57', 'B', '233', '03');
INSERT INTO `low_voltage_voltage` VALUES ('011', '2016-01-08 09:56:57', 'C', '212', '03');
INSERT INTO `low_voltage_voltage` VALUES ('012', '2016-01-08 09:56:57', 'C', '235', '03');
INSERT INTO `low_voltage_voltage` VALUES ('02e5938b2b13481fafb686c626bff947', '2016-01-08 09:56:57', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('02e7d0a26f324e4399ac8893ffa5d666', '2016-01-08 09:56:57', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('038cb9358e12400db7e738b961858c71', '2016-01-08 09:56:57', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('03e9c2c5787549749709f6d20bc93315', '2016-01-08 09:56:57', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0500ebab3cfb4949817fc525f247880f', '2015-08-12 11:17:05', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('054c1edc1eb1485ebabd6e47ebb12943', '2015-08-11 02:07:02', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0657bd15bdcc45039d6971d99e14dd0e', '2015-08-12 17:33:56', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0666cb38aac748c1b6f729c38d200c30', '2015-08-12 17:33:38', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('06aa50abc55a43209228b2a80a77fa4d', '2015-08-12 17:33:38', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('07c0f00f0ba346deba291768bec9e1d9', '2015-08-12 17:34:05', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('08234aff6ca0476fabe5caa3fdf1e9b6', '2015-08-12 17:33:43', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0927bdbb2db64514b2394a8eea9e3d54', '2015-08-09 12:43:58', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0ab8298e7ac64a10b235b8f55fdb7867', '2015-08-11 02:05:55', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0addb922b6bf4169892c0f7ff2c7b647', '2015-08-12 17:34:03', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0bff3f0325cf420187e23b477cbd1a54', '2015-08-12 17:33:27', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0cb8a270aeee4561b0194cbfd84028b2', '2015-08-10 02:36:33', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0cfa7a78cd7d41a5af9b6dbb5e3cbd0e', '2015-08-10 02:35:59', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0d3b3d92056e43f09a2489ead1f3d29c', '2015-08-12 17:34:01', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0d76d6f2b32c4276be4439e486068eae', '2015-08-12 17:21:22', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0e301d33b3a3495a8ef3345e5de20468', '2015-08-12 17:33:19', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0e9e2e737b0e4e9e889c8772edf9e703', '2015-08-10 21:55:45', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0eacc063cf5847feb00858ce5c09a6e7', '2015-08-11 02:20:25', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0f2a1fc1f1984530aa7126516fd3c86e', '2015-08-10 00:37:09', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0f5557457355490ba9f02c2783ee28e9', '2015-08-10 21:21:06', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('0fb39e48d46d489aabe0d85d9485657d', '2015-08-09 12:40:24', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('115f4561560244059313162a1f5e3683', '2015-08-12 17:33:50', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('129b186d13e642a28e297c5b155694bf', '2015-08-09 12:43:58', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('12b2ea181b1e4a5ca238c577c65ebd84', '2015-08-12 17:33:17', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('13ab44c324244457ac8629d8c41e1915', '2015-08-12 17:33:32', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1444861a47de45339b6ffa0a7133c3f8', '2015-08-12 17:21:48', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('155efde9ca6c46898a066c390346fb68', '2015-08-11 17:59:45', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('157f249d2dd5464bac3d9bd37fe13b95', '2015-08-10 02:15:33', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('166207350edc4d879145625ace669c5a', '2015-08-11 02:14:36', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1713b790251e45cc931e1c6374d0ff6a', '2015-08-11 02:12:51', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('175bbd77155948608787fcea7e786760', '2015-08-12 17:34:01', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('17878d36372b49158bbb1a8fb3b5cae1', '2015-08-12 17:21:15', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('17c0b6e94c38459abce9663c4f7c9742', '2015-08-12 17:21:39', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('17d7e261f98248afbabd0cd916a16c1b', '2015-08-12 11:19:08', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1985e7c461504f3ea3a189628ee87ab6', '2015-08-12 17:33:42', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1aa0f44f843e43bab6b7df8aae1fc0ba', '2015-08-10 21:37:31', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1ca938bf627940fda80971657879a292', '2015-08-12 17:33:56', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1d16f5e347b84095b792cdb0d54d1246', '2015-08-10 21:38:30', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1d53de266c3c4647a0172829dcdf4932', '2015-08-10 02:12:17', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1d791a9e7bcc4485ae8675e543746510', '2015-08-11 17:59:47', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('1ea248204e9e4e1e9b019b1c45fdfe30', '2015-08-09 15:06:03', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('20e8c47db4184ebda6a22a5c730a20cc', '2015-08-10 21:21:06', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('21539c4d8c10409182a46978a95c0e6f', '2015-08-12 17:33:55', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('21da7c275ee549e8810541ab0882eb5b', '2015-08-12 17:33:31', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('221d357ab98c44ecb3bdd857a6e7b39a', '2015-08-10 21:21:06', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('229352c5c2db485d8b6e270ff5bec34d', '2015-08-12 17:20:59', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('23cce697c01c4c6a8c71d3fde6e3e433', '2015-08-12 17:33:53', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('258d954740404f4d910e1c42701a0607', '2015-08-10 02:35:13', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('260ce624d07b483aa077e02e49f23dc8', '2015-08-12 17:33:35', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('2618a9f0516d4929b63a0ea7f51dfd95', '2015-08-12 17:33:52', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('276e8a42998a4e98a2ceca6067cf3772', '2015-08-09 12:34:57', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('27e6f6df304e4ec598f83c9e11b7f01c', '2015-08-10 02:29:58', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('28844f673b104720b09b175451fde228', '2015-08-11 02:03:23', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('28ddc408637944ce948bc211fbde41e8', '2015-08-12 17:34:03', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('2a7b1ff1203244f7838d25eace265014', '2015-08-12 17:33:47', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('2a8b888b553747958b4d20cd92015be4', '2015-08-12 17:33:45', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('2acc7364c9da49a8aa9950a0ae93fe6a', '2015-08-12 17:33:49', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('2ecfa7dd146a4d2dba1d6485802b00ce', '2015-08-11 02:05:55', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('2efb0a765c4c416b99284759eb6e7e3f', '2015-08-10 02:39:33', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3139795d232c420cbfd0853e2ed85366', '2015-08-12 17:34:05', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('335fae61639a46d48e0f5fa025b5e2cf', '2015-08-12 17:21:24', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3503ea1c76044b1781f7fd6e5f89340f', '2015-08-12 17:33:28', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3517977935684ba0ad42a9720b3e7ac9', '2015-08-12 17:21:22', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('35ffb11dfe1c42feb6615c10f114678f', '2015-08-12 17:33:54', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3782ce457125424483d1cc81f205bc05', '2015-08-12 17:33:59', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('37cf41ce738349c2993fef66da3d4083', '2015-08-09 12:41:21', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('39bb360ba5e244ee994bf7278b0d67df', '2015-08-10 00:37:09', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3ae5cae4a41549ea88a649424c7581b3', '2015-08-10 00:37:09', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3b0cab5e80594684be984f3af7ba9407', '2015-08-10 02:39:33', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3b48a28dbc5d46b8bf5d6bf691946189', '2015-08-12 17:33:16', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3cb168254783454abe5c66399ab4b989', '2015-08-10 02:05:10', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3cbf43b530ba4b459528d3ed07c1afa2', '2015-08-11 17:59:45', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3d4c273cdcd54146ae2c16569a130858', '2015-08-09 15:06:03', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3e778cf5573246e6b38d64bbd54eb444', '2015-08-11 17:59:46', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3f60ec2a0a254734a3178fc3ffaba951', '2015-08-10 21:56:00', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3f6e978ce04447539c22771a194248d8', '2015-08-10 02:35:13', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3fc19161cc224fca96d2176e90c1fce0', '2015-08-12 17:33:33', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('3fecdc2fe17d472581c806f0631283de', '2015-08-12 17:21:23', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4000b3e6a0b348feab3d6550232887da', '2015-08-10 02:35:49', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('400207cf853843ad948b272d1b988ac6', '2015-08-10 02:35:59', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('40088aed4d9d4f178cc702436a020f6f', '2015-08-12 17:33:20', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('404a6e77b05a4ae6b4ead8baa7ba786f', '2015-08-10 21:59:22', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('40ce21a4653f47039c6d5c605c9b6dbb', '2015-08-09 12:40:07', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('40e01dd36ba94c0188fc3d24a71f939a', '2015-08-12 17:34:09', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4322e6ebe5ff4dfe876c97021b0ef295', '2015-08-10 00:35:19', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4370f355848b4256882d573d5814163b', '2015-08-12 17:21:22', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('45012d52835f48fe947ddbe0a326bbbd', '2015-08-12 17:21:48', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('45d3d5bf1a40438c8ec709020d2b8844', '2015-08-12 11:19:08', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('47a1129b99c34d1793753ec8730ccb5c', '2015-08-10 21:59:22', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('47d62cf9b158400d975e6a582ee118cf', '2015-08-12 17:34:04', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('492870e21ccf45fda578b02889540030', '2015-08-10 02:36:23', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4a2cf46957e345e58b330c515a47deaf', '2015-08-11 17:59:46', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4ac31b52ce13451a89b5ce0e2fad432d', '2015-08-10 21:37:31', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4bde3a219cef4e4b800759c5055ca879', '2015-08-12 17:33:57', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4c0101e6020a40d895178d4c4992409b', '2015-08-12 17:34:07', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4d503727d6bf4613810ed8f4c5847241', '2015-08-12 17:33:17', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4dac19fef7cf447799f3c407984bc7c0', '2015-08-12 17:21:15', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4df45c42d9c3420cb1e6bde022e35188', '2015-08-11 02:16:58', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4e3d9d570d984ea9bab0422209584c78', '2015-08-10 02:36:27', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4f03e091ec0d4728828288b58b3fe0df', '2015-08-11 02:12:51', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('4f5d7d3b616e48008ce045788aabd6fa', '2015-08-11 17:59:48', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5011b2ba96aa4ccebe74ae035eab072e', '2015-08-10 02:39:33', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('50ca3fac535944b68bd155d30cd6512e', '2015-08-12 17:33:39', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('50f6d08d81464a9882e82be4042a5d0c', '2015-08-10 02:33:26', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('50fbf3d4c2994895adfe76e7717200b2', '2015-08-12 17:33:30', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5127459853b240939b514ca0287efb40', '2015-08-11 02:07:02', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('522c4117ab6f473797ce759c9fcc0765', '2015-08-09 12:41:25', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('52b8bc36d32d44bcbfedafbc49b3ed73', '2015-08-12 17:33:37', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('53fbd05e240e458aa393cd9858c38a0c', '2015-08-12 17:33:50', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5442934fa569412db51e7c788eda5ba9', '2015-08-10 02:39:45', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('54e66c6d110343978a8ed407f827ac8f', '2015-08-12 17:21:22', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('55ea2081fcb34d398c420047d8615492', '2015-08-12 17:33:21', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('571a9ae4e4e74dd5b2a3203f0b8be3ad', '2015-08-12 17:21:48', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('575d9c570d214e48a570c72c64ca7543', '2015-08-10 21:40:59', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('575eeeb4cd5d471c834e90f11fde4521', '2015-08-09 12:40:24', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('57ac6ff1a43e433d85f4493527a3f116', '2015-08-10 00:40:20', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('57c6f727f2914b419393807dd90e6d83', '2015-08-10 02:15:33', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('58549cf497c74595953934c69bd07a6d', '2015-08-10 02:13:31', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('598b70eefcf14734b4e757ee2baca757', '2015-08-12 17:21:15', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5abc937b1d0b4d308b64d083f85a22ee', '2015-08-10 02:05:10', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5b4ca08334ac4e08a41d38496a29a838', '2015-08-11 02:05:55', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5c686b511d4a40c68de6fb358980c239', '2015-08-12 17:33:17', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5cb3363f065d49e19e8d54e8c260de42', '2015-08-12 17:33:36', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('5fa5c56aa71c4c87949469e6cedbebce', '2015-08-11 02:20:25', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6038007359bb498faf0abd496af2ce99', '2015-08-12 17:33:33', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('604d464eb1ea41ddbd588750bb937c26', '2015-08-10 21:37:31', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6051aa1d0d3d4a54b126399ba33913c2', '2015-08-10 02:29:58', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('60d14d695577407e8a7af8fa4f678236', '2015-08-12 17:21:23', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6210d1c7b28940448c52be041be600aa', '2015-08-09 12:41:32', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('625fd3a7c36e4c589a1580808027794b', '2015-08-09 12:34:57', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6268b8dc754b4cfb849fda947dae08a4', '2015-08-12 11:19:08', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('62a441a0d1a34e3e8a7be1e3380985b7', '2015-08-10 02:36:27', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('62c118c87947425b802d08cf40ee0068', '2015-08-12 17:33:46', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('63d6ee2474d1499cac252750b98eaaac', '2015-08-10 21:56:00', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('652123120abd48468358821ab0c6c449', '2015-08-09 12:43:49', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('652a6391bb8b4609a24fc29d715379e0', '2015-08-10 02:49:16', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('655307fb1ed44422a52a7f05d768debb', '2015-08-11 02:14:36', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('658132af9fc74cb88d1901fbf24f98c1', '2015-08-09 12:43:49', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6628c2cd0b49477c8970b361ed8f830e', '2015-08-10 21:38:29', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('66d2cbf4fcd14335a3acdfb89712c5ec', '2015-08-12 17:21:15', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('67a240f6ee224baca9ba6f0e870dc1d1', '2015-08-10 02:35:59', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('68b12c2996b44cc7910a4532ffddc684', '2015-08-09 15:05:54', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6a01bad3a2ea44cd859f2451c2c04c72', '2015-08-10 00:35:19', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6a0ac180cdf54464856b6a6af68233fe', '2015-08-12 17:33:35', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6b4013d9586e408a8dd783cd94c0cca6', '2015-08-12 11:17:05', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6baf00f586ca42a69866f06a6c4487e2', '2015-08-10 02:35:59', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6ece6cf64cc14c98ab99b7cd363e880a', '2015-08-12 17:20:59', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6f61bfa5f8e5403ab7dba4271b113c6b', '2015-08-12 17:33:53', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6faabaab90cb41a493112b6f8cede1ff', '2015-08-12 17:33:53', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('6fd7af5e8c244b929ad2cd8fbe54f228', '2015-08-09 12:41:25', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7079abf31bc44472a01d3fe1b8ea1d86', '2015-08-11 02:04:26', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('710e2cddf6be4b5a8b1c523e8e4113d1', '2015-08-09 12:40:30', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('725fc8cb289e4642a82ca1477c609a56', '2015-08-12 17:34:04', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('72618cff8c8f4788ba2aa6ec756334cb', '2015-08-11 02:03:23', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('737afac406324a8dbecf13451b12eac7', '2015-08-12 17:33:35', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7439cf4132244157afa12c7db3521bbb', '2015-08-12 17:20:58', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('745cb88ad4254ecf8124ee5f630e5c51', '2015-08-09 12:34:57', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('746102d282834f168ca6d2f243109c56', '2015-08-12 17:34:06', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7467881eb08945cc9c528b1d18928d33', '2015-08-10 21:38:30', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('75ae8d174c6c41639a0c1e2f11c714e9', '2015-08-11 02:26:25', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('763c6122849d40a3a80ddd1e494f85a5', '2015-08-12 17:33:26', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('76ad73f8f14e4826b3931f822fdb784d', '2015-08-12 17:21:39', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('76d3597348f14c4bb24c02b3430c66dc', '2015-08-10 21:55:45', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('76dcd21b473d4689a1e8417267c59ce9', '2015-08-12 17:33:40', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('77518cb57c71417e970427af4a25373c', '2015-08-10 21:53:59', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('77ca4076839f4fd398101d768084bd2b', '2015-08-10 21:40:59', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('78c07f8d56584d58a234fc4f1e70d374', '2015-08-10 02:39:45', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('78e1a27bb695448cbbe1b79a34ca2d57', '2015-08-12 17:21:39', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('79310400b5cf4092b937242b20abe766', '2015-08-12 17:34:02', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7a58c7b8bcd3416d8325a65a9c51a5c0', '2015-08-11 17:59:48', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7a65f633f5cd4bc9be3794fb013235f5', '2015-08-09 12:43:58', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7bf5a2f33a034554bbbcca4dbe565609', '2015-08-12 17:20:58', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7d038fe76ae84b65ae944eddd6dc6ecf', '2015-08-12 17:34:04', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7d7b270377e441e883c798d0dc417630', '2015-08-10 02:35:59', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7d80317df6f84d7da4731b7226dd4290', '2015-08-10 02:49:16', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('7e51aa56ac5141f2bba81cba70d404a3', '2015-08-09 12:35:01', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8046d6ce94a04f05b4d2646952868c36', '2015-08-12 17:33:58', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8058c239d76241cb8d2c8429cb6be5cb', '2015-08-12 17:33:42', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('80cf8652154d4cb1a519ea0f635058ef', '2015-08-12 17:34:06', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('80de27b8de5f460b9cf32fa2da27ff65', '2015-08-10 21:55:45', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8111f99af6ce4607b6a66c927885be5b', '2015-08-12 17:33:16', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8123387be29241318fb2d9a2657daf40', '2015-08-09 15:05:54', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8131bf9d3761408485b1a6d89b968dea', '2015-08-12 17:34:06', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8284eab242d843d18375a42ec8b494c4', '2015-08-12 17:33:34', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('83a73d395acb42f49ec35cde090a0933', '2015-08-10 02:35:13', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('84423fbac6df44f091c532bf42de9969', '2015-08-12 17:33:26', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('84465243c0d3432f96af3c5036b582fd', '2015-08-11 17:59:47', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('846f7632d05145039ef2d6c5f52667d6', '2015-08-09 12:40:30', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('84a098fc8f404acd8e461bcec6895d06', '2015-08-12 17:34:09', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('85554963d32f40c5998914702a46d1c9', '2015-08-12 11:17:17', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8612faad40204753ab8acfcc251d1a14', '2015-08-12 17:33:54', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('86d3410f2cdb48af9c71f161fdf0fb9c', '2015-08-12 17:33:50', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('87702a582697494e9918f435cae749b1', '2015-08-12 17:33:20', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('885e6f020dc947c0a960c0d543d1d532', '2015-08-12 17:33:28', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('889c082c431f492e86c1fb997b3295cf', '2015-08-12 17:33:58', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('890dce6cfba643b5880ce0bb69c96f57', '2015-08-12 17:33:34', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8960db57ea4e43a1a493089d9397e5d9', '2015-08-12 17:21:23', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('89c11e63bc6346eb861cdacfe30fe580', '2015-08-12 17:33:49', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8ae3d4a01d5d48ccb6675fada36a155e', '2015-08-12 17:33:24', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8e835fbf0dd948628587bb8ea6977dc5', '2015-08-12 17:33:29', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8f9624c42c12497c87b85ca0f3f29054', '2015-08-12 17:34:00', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('8ffe2eef4b204368adeafe64d111d299', '2015-08-12 17:33:37', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('900ad3b6e5844fd9a6906d322855f98f', '2015-08-10 02:34:04', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('904bcb67852b417486af163bde96430a', '2015-08-12 17:33:52', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9058c7d4289f417fafd40567f3ac0416', '2015-08-12 17:33:45', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9265e86d0ee04c66a3e082a456ccacbd', '2015-08-12 17:33:45', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('92e191aed9124393aa01f6991290177f', '2015-08-12 17:33:37', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9345aa7412924d7996ce3767b08e65dd', '2015-08-12 17:21:22', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9415027a19014b849e10521988ee1d32', '2015-08-12 17:33:19', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('953c2d98a10c495d91453417d8ae189a', '2015-08-12 17:34:08', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('960dde62c09a438e9735b60d1a25692c', '2015-08-12 17:33:49', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('967f9992735e4786a4a5ca7342ba44d7', '2015-08-12 17:33:39', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('97648c5263f94ed6ba092062fe250196', '2015-08-12 17:33:55', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('981cc36c82c04380b4cb1f48ddfe93da', '2015-08-12 17:33:42', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9dd4e256ecf84789bdae9420a916cc3c', '2015-08-12 17:20:19', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9e5c4c33b6964fe392fabf58d3984e28', '2015-08-09 12:40:30', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9efa92edecbb43ddb24bd1e1d897e5c7', '2015-08-12 17:34:05', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9f7b8c3024eb4a938365a22084750aa8', '2015-08-12 17:34:00', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('9f9a3d043ba14f609ee5ecdffb04f895', '2015-08-09 12:35:01', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a0e113f382174d50b1414e43ee0ff128', '2015-08-09 12:40:24', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a0e35e64a3374a058c30ad80d0bf1ad6', '2015-08-09 12:41:21', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a1d1ea1522ae486ebe68e17a5e63a4da', '2015-08-11 02:20:25', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a210974abbe44c7e8e1f1ad739ca0502', '2015-08-12 17:33:22', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a2a5fc681a4c401588ba1be157a1b8cb', '2015-08-12 17:34:02', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a32aa483fdfb406e8fe6dd0eb9007533', '2015-08-10 21:38:30', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a417ce3feb8d40f4865710d894e36824', '2015-08-12 17:33:33', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a4a01a6ce03e4575b363d589cabab847', '2015-08-12 17:34:03', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a4c98d5c79c64802aa76355b126effec', '2015-08-11 02:04:26', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a4f3c07afa9946cfbf183a25eb096da9', '2015-08-09 12:41:21', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a59952df99be481aaed1380b6ac7a899', '2015-08-12 17:21:39', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a5b3008d369549dda5c8550b44d40182', '2015-08-10 02:33:26', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a5ffd597ffc946ab9bc2785d3b9687d6', '2015-08-10 02:15:33', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a6967f929d204aeea245436862f24d07', '2015-08-12 17:20:59', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a70e680ce50e4c9b819a76956cebc722', '2015-08-12 17:33:43', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a744cce55e19428fad95104f9ba764cb', '2015-08-12 17:33:48', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a7e6bb39502a4ddab6191034f6a51ce7', '2015-08-12 17:33:18', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a84a1481d05d4565b41fea0c1c210d8c', '2015-08-09 12:41:25', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('a9ba397ab3a54776959b9a0e10ce8624', '2015-08-12 17:21:39', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('aa95eb54f5ab4dfdb63100900b2818af', '2015-08-12 17:33:22', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('acc80a524a8b4942bcb8fb48ced21919', '2015-08-10 02:05:10', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('adaf81d16cad416c9c439780ab288559', '2015-08-10 02:34:04', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ae664127eee04edc9a58e3af98117570', '2015-08-12 17:33:58', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('aeb3b59623324585a9f5865ec8a12105', '2015-08-10 02:35:49', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('aec233cf1ac24408a129f23ab686496b', '2015-08-11 02:04:26', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('af3a120dc8af417e9d6634e34191f686', '2015-08-12 17:33:32', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('af5ce986e3b9400381f579f97232f1bb', '2015-08-11 02:16:58', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('afb87d4e901d443490345d4a770408af', '2015-08-09 12:35:01', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b00d8c411ea843f1b39c483bbb758406', '2015-08-12 17:34:01', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b072cae7e53f413fa311a0292c5b7bf6', '2015-08-12 17:33:32', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b0936758a55342a7bcba5dcf024303e6', '2015-08-09 15:06:03', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b09f922dce4c4770a13d833deaeb6323', '2015-08-11 02:02:08', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b0ce412b34c84066a8c71577f945b914', '2015-08-10 02:13:31', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b28d9fe504854aeeab2ce8aa4657a767', '2015-08-12 17:20:58', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b2a9283a9eab4bf38a476598e18b98c7', '2015-08-12 11:17:05', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b3b7ddeffae64bd4939c4099295c9137', '2015-08-09 12:40:07', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b3d251448e304d08a5f2bcd4a171e280', '2015-08-12 17:33:27', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b42aac92044f4918b567648dfff661c6', '2015-08-12 17:33:52', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b574faf67e52452a84685afe96108b91', '2015-08-12 17:33:44', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b645dea90dad449c9423215ec81a3dc0', '2015-08-10 00:40:20', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b6951a56054f49f69835235927863739', '2015-08-10 21:40:59', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b6e032beb3c34f83b44b350a508c5cd7', '2015-08-10 02:29:58', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b77b9bccb0b84552bc37e3cb81e62585', '2015-08-10 02:39:45', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b80ed22a65514fd1948797b0bee354fa', '2015-08-12 17:33:19', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b81923ea42ee4943b740ca057d10ab03', '2015-08-12 17:33:57', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('b996dcc54cc44fbea41cd8e51ede2683', '2015-08-12 17:34:07', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bac11b185c7b499ab8869b3609236ca6', '2015-08-10 02:36:23', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bac7d5f1c2464d0bad3b1b3297d142e3', '2015-08-10 21:38:29', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bbbd0ab8948c4acd8455ae8403f596ff', '2015-08-10 02:36:23', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bc4c373e22804906b641c72beda281bb', '2015-08-12 17:33:44', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bc8716b9bdd943ee8cb7ad00fa3d72c7', '2015-08-12 17:33:46', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bc909445c9ea4d8d930bf0088d554169', '2015-08-12 17:33:48', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bd195ebfa289445b921f7d76bbb838ff', '2015-08-12 17:33:27', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bdd3b413b5914e6aab9c94eeea4635ba', '2015-08-12 17:33:48', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('be38a6af4e2a445986e1509b1d94983a', '2015-08-11 02:26:25', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('be95142469e74c29acae5f561815f642', '2015-08-12 17:33:23', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bed5a7c06d624589b1405053af47c9a2', '2015-08-11 17:59:48', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('befc3dce3fb74697b086afb6cbed65c9', '2015-08-11 17:59:45', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bf4e71897ee74800a2a76e7d213ea675', '2015-08-12 17:33:54', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('bf6b24fb39de4eedba2bdd756fe0fac2', '2015-08-09 12:40:31', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c03f208c23bf4e2eb4a66bf731483a23', '2015-08-12 17:33:23', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c042927b2cef4383b6bba8874baa0250', '2015-08-10 02:35:49', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c065fbc5123343c398158bbec006449f', '2015-08-10 00:40:20', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c1027a72842142d085eb5e4484c1eb4c', '2015-08-12 17:34:02', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c3849dd2765842629b465540b61f60fd', '2015-08-12 17:33:34', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c3ff37fb79a24bf0bf7995b940e76efe', '2015-08-10 21:56:00', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c5d0f534308c42cb8b37cd5aaa048c98', '2015-08-12 17:33:47', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c655990369a14402928d21850879327c', '2015-08-10 21:59:22', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c9048632fc6c4fc4adda867af797cb4c', '2015-08-10 02:36:33', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c90e6e0ce3cf440f87d0b255ef71ebde', '2015-08-09 12:41:32', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('c9a07c6b6b3242e8981512392dbee9ab', '2015-08-12 17:33:46', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('cbef21e5ef034ed09a5cbbd22a3f0168', '2015-08-09 12:43:49', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ce61f87cec8a4da0aba633b849fde921', '2015-08-12 17:33:59', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ce88bee621d04ea28ba8a963bc50572f', '2015-08-12 17:33:43', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('cf05a61f7c5245f098c26bff1a7ae8e6', '2015-08-12 17:33:23', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d046a8303dc7456aa987f0c2d854785d', '2015-08-11 17:59:46', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d09aae0c28ec4019affb85f702bbb1db', '2015-08-11 02:26:25', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d120d5e0688d45e2ae58bd183cd01ec5', '2015-08-12 17:33:31', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d25e8c77a55a4df09fb7227af2a97d32', '2015-08-12 17:21:24', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d2fd3c9974a24d1f86f56e2797343979', '2015-08-12 17:33:57', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d42b4d917fca4c0e87f19230fdb5d1bf', '2015-08-12 17:33:36', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d45803458ad5410e85bb4f17faa9961c', '2015-08-12 11:17:17', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d5b21e3757204ec0aaf05c32cfea6b4f', '2015-08-10 00:35:19', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d5bc0f774f5542d79a0cc3ab3f07c110', '2015-08-11 02:02:08', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d6160d0e1ebe4f7e879c28bef63dfcb6', '2015-08-12 17:20:19', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d806d9e40d2445a0aa09a3c592d22b28', '2015-08-10 02:36:33', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d814ad81d8b44bfca4457f5033b0714a', '2015-08-10 21:53:59', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d841b96395a04216a3f2eec980c35ad7', '2015-08-10 02:49:16', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('d897aa3d8ea24a6c964b14abf7872792', '2015-08-12 17:33:38', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('da676621b820441fb56fe3fbd24693e3', '2015-08-10 02:35:59', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('daea3c914f2049b897041d1d0cf522b9', '2015-08-09 15:05:54', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('db4e51fa01c548199b03458a18f64b58', '2015-08-12 17:21:15', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('de83018700ff43e891acb4a1d213b5f8', '2015-08-11 02:02:08', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('df22461b866547a68b822860f9d17616', '2015-08-11 02:12:51', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('dfecdb601461435791e5e8db038d3c38', '2015-08-12 17:33:44', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e005db0aa24d4f8db6deaa96dc2f27f0', '2015-08-12 17:34:07', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e01e7caa6f524cc2a4053ae125600d12', '2015-08-12 17:33:21', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e03f21d0edb542b68201ecc92198aac2', '2015-08-12 17:21:22', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e08ad620b9ee47c59f777db50cc68e44', '2015-08-10 02:36:27', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e0bd8a237e604e55aff69ca6614a12aa', '2015-08-12 17:33:29', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e19201d551bc45ee87c3d9dbe12636da', '2015-08-12 17:33:22', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e204c41a351f40f18f4106d478f0e1e1', '2015-08-12 17:33:40', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e23f8f1b7aad4c2a8372bfb44b70c582', '2015-08-12 17:33:55', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e3b7d4cd87174f71af6603b1fbb6b497', '2015-08-12 17:33:18', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e4939c2a900940f7b4001e48f59fcdad', '2015-08-12 11:17:17', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e6ea52953b4c43ada3934e9e81eb247d', '2015-08-12 17:34:08', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e7396127f84c4338b06767a5eea07855', '2015-08-09 12:40:31', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e7c2a21178b34c9fba9e913bd9558f3a', '2015-08-12 17:33:56', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e8421dcc33994d3cbc50d7da3c2a812f', '2015-08-11 02:03:23', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e8bf8e38ba5a44639aff5263c9d5477c', '2015-08-12 17:34:09', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('e92ee23b653f444eacbf769d5ac04433', '2015-08-10 02:12:17', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ea23ec970ce14ccea5a8ee5fd4177f48', '2015-08-11 17:59:47', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ea48ed5a018e4104b90f5896a417a1dd', '2015-08-10 02:12:17', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ea689e51570f437d9ef45125a599d46d', '2015-08-11 02:07:02', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('eaa4223b74e1452aac81328a72746381', '2015-08-11 02:14:36', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('eafeff93dcc34efc859a2f58fda6e0ba', '2015-08-12 17:33:40', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ecd236d72f8a4addb4a1612b7ac44a35', '2015-08-10 21:53:59', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ed4c78f2c97c48d0a2f9bda2d1ccb6d5', '2015-08-10 21:16:00', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f053578c3e11426eb9343bb7a6b1a9bb', '2015-08-12 17:20:19', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f06b4159380e434b9f998b191b39c180', '2015-08-10 21:38:29', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f0e1317954004ebcbc07833af6e22045', '2015-08-12 17:33:31', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f11093eb32b342faa291f2b35e4b78bb', '2015-08-12 17:33:20', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f120e34fe6a643f3af3d22a2c94df982', '2015-08-10 21:16:00', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f1499b67768f473a9d1fae1b4ecc6af5', '2015-08-12 17:33:21', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f1ecb7b853364690ab170449f477fe86', '2015-08-10 02:33:26', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f27bfa3c51b24a6a88315a20080528eb', '2015-08-12 17:33:18', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f2e1b1273d22425d9ee91170e4521a9c', '2015-08-10 02:34:04', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f499df1baa9d48f0a84c4d656b46bc4a', '2015-08-12 17:33:39', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f4c9a55fd73249d895db2e20a6e5811c', '2015-08-12 17:33:26', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f50809f39b1849679a583bc8ad4e2259', '2015-08-12 17:21:15', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f57a49f4c3274dbf94a527fba35d37ed', '2015-08-12 17:33:29', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f5b8af5114cb4986a0e2d90c64a27b28', '2015-08-12 17:33:30', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f6c1af586d4c49af9dfb443aaf521bb9', '2015-08-10 21:16:00', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f7108518b27e48dba3fa8c2ee68c4767', '2015-08-12 17:21:39', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f76238231c6e47d88cf7e80c139a5e3c', '2015-08-12 17:33:24', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f797c97b63a84445995058db78554167', '2015-08-12 17:33:47', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f9612f9fecb848c0acfc96fa0c26f444', '2015-08-09 12:40:07', 'A', '2432', '03');
INSERT INTO `low_voltage_voltage` VALUES ('f983f9adc5d6421993a9644031fa9a7d', '2015-08-12 17:33:28', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('fa3520bf3fc942509eb135189de37b6a', '2015-08-12 17:33:36', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('faccf42115ea4e92b0024b707b56c586', '2015-08-12 17:33:30', 'B', '2373', '03');
INSERT INTO `low_voltage_voltage` VALUES ('fc498c70f9ce4fbf9d95f08e20dfc1fc', '2015-08-11 02:16:58', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('fc4d027d49bf4c0d9c8e0bed3651145e', '2015-08-12 17:34:00', 'A', '2390', '03');
INSERT INTO `low_voltage_voltage` VALUES ('fc84451a12fc422997c2f6bd3db8edba', '2015-08-09 12:41:32', 'B', '2412', '03');
INSERT INTO `low_voltage_voltage` VALUES ('fc9879c1fade469990fa586c47229cc0', '2015-08-12 17:33:59', 'C', '2379', '03');
INSERT INTO `low_voltage_voltage` VALUES ('fce76e1e9619407ba893c47d43ddd751', '2015-08-09 12:40:31', 'C', '2419', '03');
INSERT INTO `low_voltage_voltage` VALUES ('ff624db5a7be4579bcea5fe4be438813', '2015-08-12 17:33:16', 'B', '2373', '03');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `text` varchar(10) NOT NULL,
  `imgUrl` varchar(60) DEFAULT NULL,
  `iconCls` varchar(20) DEFAULT NULL,
  `className` varchar(30) DEFAULT NULL,
  `leaf` int(1) NOT NULL,
  `sort` int(11) NOT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('0', null, '区域管理', 'resources/images/menu_area.png', 'menu_admin', null, '0', '1');
INSERT INTO `module` VALUES ('1', null, '学校管理', 'resources/images/menu_school.png', 'menu_admin', null, '0', '2');
INSERT INTO `module` VALUES ('2', null, '学生管理', 'resources/images/menu_stu.png', 'menu_admin', null, '0', '3');
INSERT INTO `module` VALUES ('3', null, '教师管理', 'resources/images/menu_tea.png', 'menu_admin', null, '0', '4');
INSERT INTO `module` VALUES ('4', null, '开课&考试', 'resources/images/menu_score.png', 'menu_admin', null, '0', '5');
INSERT INTO `module` VALUES ('5', null, '时光影音', 'resources/images/menu_mutimedia.png', 'menu_admin', null, '0', '6');
INSERT INTO `module` VALUES ('6', null, '新闻管理', 'resources/images/menu_news.png', 'menu_admin', null, '0', '7');
INSERT INTO `module` VALUES ('7', null, '信息推送', 'resources/images/menu_message.png', 'menu_admin', null, '0', '8');
INSERT INTO `module` VALUES ('8', null, '系统管理', 'resources/images/menu_role.png', 'menu_admin', null, '0', '9');
INSERT INTO `module` VALUES ('appraisemgr', '2', '评价管理', null, 'menu_groups', 'appraisemgr', '1', '2');
INSERT INTO `module` VALUES ('areamgr', '0', '区域管理', null, 'menu_profile', 'areamgr', '1', '1');
INSERT INTO `module` VALUES ('arrangemodule', '8', '模块分配', null, 'menu_users', 'arrangemodule', '1', '3');
INSERT INTO `module` VALUES ('arrangerole', '8', '角色分配', null, 'menu_users', 'arrangerole', '1', '2');
INSERT INTO `module` VALUES ('btnpermission', '8', '按钮权限分配', null, 'menu_users', 'btnpermission', '1', '4');
INSERT INTO `module` VALUES ('checkphoto', '5', '照片审核', null, 'menu_groups', 'checkphoto', '1', '6');
INSERT INTO `module` VALUES ('classalbum', '5', '班级相册', null, 'menu_groups', 'albummgr', '1', '5');
INSERT INTO `module` VALUES ('classlib', '5', '班级视频库', null, 'menu_users', 'videolibmgr', '1', '4');
INSERT INTO `module` VALUES ('classnews', '6', '年级新闻', null, 'menu_users', 'newsmgr', '1', '2');
INSERT INTO `module` VALUES ('coursemgr', '1', '学科&课程', null, 'menu_profile', 'coursemgr', '1', '2');
INSERT INTO `module` VALUES ('departmgr', '3', '部门管理', null, 'menu_profile', 'departmgr', '1', '1');
INSERT INTO `module` VALUES ('exammgr', '4', '考试&成绩', null, 'menu_profile', 'exammgr', '1', '2');
INSERT INTO `module` VALUES ('grademgr', '1', '年级&班级', null, 'menu_profile', 'grademgr', '1', '3');
INSERT INTO `module` VALUES ('healthmgr', '2', '健康管理', null, 'menu_groups', 'healthmgr', '1', '3');
INSERT INTO `module` VALUES ('introduce', '1', '校园简介', null, 'menu_groups', 'schoolsummy', '1', '1');
INSERT INTO `module` VALUES ('learningcenter', '5', '学习园地', null, 'menu_users', 'learningcenter', '1', '7');
INSERT INTO `module` VALUES ('msglist', '7', '推送记录', null, 'menu_users', 'msglist', '1', '2');
INSERT INTO `module` VALUES ('myclass', '2', '我的班级', null, 'menu_profile', 'myclass', '1', '1');
INSERT INTO `module` VALUES ('positionmgr', '3', '职位管理', null, 'menu_groups', 'positionmgr', '1', '2');
INSERT INTO `module` VALUES ('publishnews', '0', '教育热讯', null, 'menu_profile', 'publishnews', '1', '3');
INSERT INTO `module` VALUES ('pushpanel', '7', '消息推送', null, 'menu_groups', 'pushpanel', '1', '1');
INSERT INTO `module` VALUES ('rolemgr', '8', '角色管理', null, 'menu_users', 'rolemgr', '1', '1');
INSERT INTO `module` VALUES ('schollalbum', '5', '校园相册', null, 'menu_groups', 'albummgr', '1', '2');
INSERT INTO `module` VALUES ('schoollib', '5', '校园视频库', null, 'menu_users', 'videolibmgr', '1', '1');
INSERT INTO `module` VALUES ('schoolmgr', '0', '学校注册', null, 'menu_groups', 'schoolmgr', '1', '2');
INSERT INTO `module` VALUES ('schoolnews', '6', '校园新闻', null, 'menu_profile', 'newsmgr', '1', '1');
INSERT INTO `module` VALUES ('showselectedcurricula', '4', '我的课程', null, 'menu_profile', 'showselectedcurricula', '1', '1');
INSERT INTO `module` VALUES ('teachermgr', '3', '教师管理', null, 'menu_profile', 'teachermgr', '1', '3');
INSERT INTO `module` VALUES ('viewPager', '5', '轮播相册', null, 'menu_groups', 'photomgr', '1', '3');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(32) NOT NULL,
  `module_id` varchar(32) NOT NULL,
  `permission` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permissions_permission` (`permission`) USING BTREE,
  KEY `FK_007` (`module_id`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('acceptPhoto', 'checkphoto', '通过照片审核', '通过照片审核', '0');
INSERT INTO `permission` VALUES ('addAlbum', 'classalbum', '增加班级相册', '增加班级相册', '0');
INSERT INTO `permission` VALUES ('addAlbumSchool', 'schollalbum', '增加校园相册', '增加校园相册', '0');
INSERT INTO `permission` VALUES ('addAppraise', 'appraisemgr', '增加评价', '增加评价', '0');
INSERT INTO `permission` VALUES ('addDepartment', 'departmgr', '增加部门', '增加部门', '0');
INSERT INTO `permission` VALUES ('addExam', 'showselectedcurricula', '开设考试', '给课程开设考试', '0');
INSERT INTO `permission` VALUES ('addGrade', 'grademgr', '增加年级', '增加年级，比如一年级', '0');
INSERT INTO `permission` VALUES ('addIntroSchool', 'introduce', '增加校园简介', '增加校园简介', '0');
INSERT INTO `permission` VALUES ('addPosition', 'positionmgr', '添加职位', '添加某个职位', '0');
INSERT INTO `permission` VALUES ('addResource', 'learningcenter', '增加资源', '为学习园地增加资源', '0');
INSERT INTO `permission` VALUES ('addRole', 'rolemgr', '增加角色', '增加角色', '0');
INSERT INTO `permission` VALUES ('addSchool', 'schoolmgr', '增加学校', '增加学校', '0');
INSERT INTO `permission` VALUES ('addSelect', 'showselectedcurricula', '增加选课', '增加选课', '0');
INSERT INTO `permission` VALUES ('addSubject', 'coursemgr', ' 增加学科', '增加学科，比如语文', '0');
INSERT INTO `permission` VALUES ('addTeacher', 'teachermgr', '添加老师', '添加老师信息', '0');
INSERT INTO `permission` VALUES ('addVideoLib', 'classlib', '增加视频库', '增加班级视频库', '0');
INSERT INTO `permission` VALUES ('addVideoLibSchool', 'schoollib', '增加校园视频库', '增加校园视频库', '0');
INSERT INTO `permission` VALUES ('arrangeBtnPermission', 'btnpermission', '按钮权限分配', '细化到按钮的权限', '0');
INSERT INTO `permission` VALUES ('arrangeModule', 'arrangemodule', '分配模块', '给角色分配对应的模块', '0');
INSERT INTO `permission` VALUES ('arrangePosition', 'positionmgr', '分配职位', '给老师分配职位', '0');
INSERT INTO `permission` VALUES ('arrangeRole', 'arrangerole', '分配角色', '给用户分配对应的角色', '0');
INSERT INTO `permission` VALUES ('deleteAlbum', 'classalbum', '删除班级相册', '删除班级相册', '0');
INSERT INTO `permission` VALUES ('deleteAlbumSchool', 'schollalbum', '删除校园相册', '删除校园相册', '0');
INSERT INTO `permission` VALUES ('deleteAppraise', 'appraisemgr', '删除评价', '删除评价', '0');
INSERT INTO `permission` VALUES ('deleteDepartment', 'departmgr', '删除部门', '删除部门', '0');
INSERT INTO `permission` VALUES ('deleteExam', 'exammgr', '删除考试', '删除考试', '0');
INSERT INTO `permission` VALUES ('deleteGrade', 'grademgr', '删除年级', '删除年级信息', '0');
INSERT INTO `permission` VALUES ('deleteHealth', 'healthmgr', '删除健康', '删除学生的健康信息', '0');
INSERT INTO `permission` VALUES ('deleteNewsClass', 'classnews', '删除班级新闻', '删除班级新闻', '0');
INSERT INTO `permission` VALUES ('deleteNewsSchool', 'schoolnews', '删除校园新闻', '删除校园新闻', '0');
INSERT INTO `permission` VALUES ('deletePhoto', 'checkphoto', '删除照片', '删除照片', '0');
INSERT INTO `permission` VALUES ('deletePhotos', 'viewPager', '删除照片们', '删除照片', '0');
INSERT INTO `permission` VALUES ('deletePosition', 'positionmgr', '删除职位', '删除职位', '0');
INSERT INTO `permission` VALUES ('deleteResource', 'learningcenter', '删除资源', '为学习园地删除资源', '0');
INSERT INTO `permission` VALUES ('deleteRole', 'rolemgr', '删除角色', '删除角色', '0');
INSERT INTO `permission` VALUES ('deleteSchool', 'schoolmgr', '删除学校', '删除学校', '0');
INSERT INTO `permission` VALUES ('deleteSelect', 'showselectedcurricula', '删除选课', '删除选课', '0');
INSERT INTO `permission` VALUES ('deleteStudent', 'myclass', '删除学生', '删除学生', '0');
INSERT INTO `permission` VALUES ('deleteSubject', 'coursemgr', '删除学科', '删除学科，比如数学', '0');
INSERT INTO `permission` VALUES ('deleteTeacher', 'teachermgr', '删除老师', '删除老师信息', '0');
INSERT INTO `permission` VALUES ('deleteVideoLib', 'classlib', '删除视频库', '删除班级视频库', '0');
INSERT INTO `permission` VALUES ('deleteVideoLibSchool', 'schoollib', '删除校园视频库', '删除校园视频库', '0');
INSERT INTO `permission` VALUES ('doPublishNews', 'publishnews', '预览和发布教育热讯', '预览和发布教育热讯', '0');
INSERT INTO `permission` VALUES ('doPush', 'pushpanel', '消息推送', '给家长和教师推送信息', '0');
INSERT INTO `permission` VALUES ('doResource', 'learningcenter', '查看或下载资源', '查看或下载资源', '0');
INSERT INTO `permission` VALUES ('downloadHealth', 'healthmgr', '下载健康', '下载学生的健康Excel表格', '0');
INSERT INTO `permission` VALUES ('downloadStudent', 'myclass', '下载学生', '下载学生信息Excel', '0');
INSERT INTO `permission` VALUES ('downloadTeacher', 'teachermgr', '下载老师', '下载老师信息Excel', '0');
INSERT INTO `permission` VALUES ('editAppraise', 'appraisemgr', '修改评价', '修改评价', '0');
INSERT INTO `permission` VALUES ('editDepartment', 'departmgr', '编辑部门', '编辑部门', '0');
INSERT INTO `permission` VALUES ('editDepartmentMember', 'departmgr', '编辑部门人员', '编辑部门人员', '0');
INSERT INTO `permission` VALUES ('editExam', 'exammgr', '修改考试', '修改考试', '0');
INSERT INTO `permission` VALUES ('editGrade', 'grademgr', '编辑年级', '编辑年级信息', '0');
INSERT INTO `permission` VALUES ('editHealth', 'healthmgr', '编辑健康', '编辑学生的健康信息', '0');
INSERT INTO `permission` VALUES ('editPhoto', 'checkphoto', '修改照片', '修改照片的信息', '0');
INSERT INTO `permission` VALUES ('editPosition', 'positionmgr', '编辑职位', '编辑职位', '0');
INSERT INTO `permission` VALUES ('editRole', 'rolemgr', '修改角色', '修改角色', '0');
INSERT INTO `permission` VALUES ('editSchool', 'schoolmgr', '编辑学校', '编辑学校', '0');
INSERT INTO `permission` VALUES ('editStudent', 'myclass', '修改学生', '修改学生的信息', '0');
INSERT INTO `permission` VALUES ('editSubject', 'coursemgr', '编辑学科', '编辑学科，比如英语', '0');
INSERT INTO `permission` VALUES ('editTeacher', 'teachermgr', '编辑老师', '编辑老师信息', '0');
INSERT INTO `permission` VALUES ('editVideoLib', 'classlib', '编辑视频库', '编辑班级视频库', '0');
INSERT INTO `permission` VALUES ('editVideoLibSchool', 'schoollib', '编辑校园视频库', '编辑校园视频库', '0');
INSERT INTO `permission` VALUES ('getTeacherInPosition', 'positionmgr', '获取职位下的老师', '获取某职位下的所有老师', '0');
INSERT INTO `permission` VALUES ('openAlbumClass', 'classalbum', '打开班级相册', '打开班级相册', '0');
INSERT INTO `permission` VALUES ('openAlbumSchool', 'schollalbum', '打开校园相册', '打开校园相册', '0');
INSERT INTO `permission` VALUES ('openVideoLibClass', 'classlib', '打开班级视频库', '打开班级视频库', '0');
INSERT INTO `permission` VALUES ('openVideoLibSchool', 'schoollib', ' 打开校园视频库', '打开校园视频库', '0');
INSERT INTO `permission` VALUES ('publishNews', 'schoolnews', '发表校园新闻', '发表校园新闻', '0');
INSERT INTO `permission` VALUES ('publishNewsClass', 'classnews', '发布班级新闻', '发布班级新闻', '0');
INSERT INTO `permission` VALUES ('queryPush', 'msglist', '查询推送记录', '查询推送记录', '0');
INSERT INTO `permission` VALUES ('readSchoolIntro', 'schoolmgr', '查看校园简介', '查看校园简介', '0');
INSERT INTO `permission` VALUES ('seeClass', 'grademgr', '查看相关班级', '查看某年级下的所有班级', '0');
INSERT INTO `permission` VALUES ('seeCourse', 'coursemgr', '查看相关课程', '查看某学科的相关课程', '0');
INSERT INTO `permission` VALUES ('seeEduHotNews', 'areamgr', '查看教育热讯', '查看学校的教育热讯', '0');
INSERT INTO `permission` VALUES ('seeExamScore', 'exammgr', '查看考试的成绩', '查看某次考试的相关成绩', '0');
INSERT INTO `permission` VALUES ('seeNewsClass', 'classnews', '查看班级新闻', '查看班级新闻', '0');
INSERT INTO `permission` VALUES ('seeNewsSchool', 'schoolnews', '查看校园新闻', '查看校园新闻', '0');
INSERT INTO `permission` VALUES ('uploadHealth', 'healthmgr', '上传健康', '上传学生的健康Excel表格', '0');
INSERT INTO `permission` VALUES ('uploadPhoto', 'viewPager', '上传照片', '上传照片', '0');
INSERT INTO `permission` VALUES ('uploadStudent', 'myclass', '上传学生', '上传学生信息Excel', '0');
INSERT INTO `permission` VALUES ('uploadTeacher', 'teachermgr', '上传老师', '上传老师信息Excel', '0');
INSERT INTO `permission` VALUES ('viewPost', 'myclass', '查看班级帖子', '查看班级帖子', '0');
INSERT INTO `permission` VALUES ('viewSyllabus', 'myclass', '查看课程表', '查看课程表', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `role` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('000', '超级管理员', '超级管理员，拥有所有权限', '6');
INSERT INTO `role` VALUES ('002', 'SUBJECT_MANAGER', '学科负责人', '2');
INSERT INTO `role` VALUES ('003', 'CURRICULA_MANAGER', '课程负责人', '2');
INSERT INTO `role` VALUES ('004', 'MONITOR', '级长', '2');
INSERT INTO `role` VALUES ('005', '班主任', '班主任老师', '0');
INSERT INTO `role` VALUES ('006', '教师', '在校任职教师', '0');
INSERT INTO `role` VALUES ('7cc0199c8ce84fb0bc181007cee6f8a5', '学校管理员', '学校信息录入者，管理学校相关模块', '0');

-- ----------------------------
-- Table structure for `role_module`
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `module_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`,`role_id`,`module_id`),
  KEY `FK_003` (`role_id`),
  KEY `FK_004` (`module_id`),
  CONSTRAINT `role_module_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_module_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_module
-- ----------------------------
INSERT INTO `role_module` VALUES ('070e0f8a5cdc483fbf24492e6b9890f4', '000', 'coursemgr');
INSERT INTO `role_module` VALUES ('08385ab2360f4e699420ac7e5f098fd0', '000', 'departmgr');
INSERT INTO `role_module` VALUES ('08385ab2360f4e699420ac7e5f0tt55e', '000', 'schoolmgr');
INSERT INTO `role_module` VALUES ('11155653647843de929a9c75ccf8808c', '000', '1');
INSERT INTO `role_module` VALUES ('116e98d8a0304194ac26fad6a3053825', '000', 'introduce');
INSERT INTO `role_module` VALUES ('13ef3eaea67c486eb783c0aa3af904c7', '000', 'arrangerole');
INSERT INTO `role_module` VALUES ('14bf4b33777740c9a133c1a7079e6d25', '000', '2');
INSERT INTO `role_module` VALUES ('15bedfedafdf44a18f2f3174bc2e7dbb', '000', '6');
INSERT INTO `role_module` VALUES ('19569511f5ef4e649be5908f3a37dee7', '000', 'myclass');
INSERT INTO `role_module` VALUES ('1ada6c925bc14f1a86ad6fcdecffa6e6', '000', 'exammgr');
INSERT INTO `role_module` VALUES ('23033ed7fe324656ab2c824e8428336d', '000', 'grademgr');
INSERT INTO `role_module` VALUES ('231b9a0f076840799e4dc0f4d102cd2a', '000', 'showselectedcurricula');
INSERT INTO `role_module` VALUES ('292909e0ed604d2096400ab4f4726f81', '000', 'healthmgr');
INSERT INTO `role_module` VALUES ('2f515ab86da0481cbed3e87d99c7372e', '000', 'pushpanel');
INSERT INTO `role_module` VALUES ('30c039960d8b402e975ce77402fe744f', '000', '5');
INSERT INTO `role_module` VALUES ('3659e2f65ec34cb4b87622b7ed1b4fff', '000', 'classnews');
INSERT INTO `role_module` VALUES ('4de51ed1c2d24d1da9485aa855a1aecc', '000', '7');
INSERT INTO `role_module` VALUES ('5132bbe51e2e4f09aeabde359f96b866', '000', 'teachermgr');
INSERT INTO `role_module` VALUES ('616938af7f2447aea8619d0d9f2ce0a8', '000', '8');
INSERT INTO `role_module` VALUES ('61c14a8b5da44ded9cc640dad5a0ff7f', '000', '3');
INSERT INTO `role_module` VALUES ('7976b5b6e85f41d3afe824122b48ff72', '000', 'positionmgr');
INSERT INTO `role_module` VALUES ('79e2c9303320427090002981d318a3a0', '000', 'msglist');
INSERT INTO `role_module` VALUES ('833e5c8c33124a36bccd6cf9973ae456', '000', 'publishnews');
INSERT INTO `role_module` VALUES ('89a0b8bcf6324ea78b94ce12d57062c6', '000', '0');
INSERT INTO `role_module` VALUES ('8f80e50ed60b40c58acb37344b5132ee', '000', 'arrangemodule');
INSERT INTO `role_module` VALUES ('990bcf2b20f7488b8d1f511174c4d26b', '000', 'classalbum');
INSERT INTO `role_module` VALUES ('9ab88813e876469c84cf948898dded91', '000', 'classlib');
INSERT INTO `role_module` VALUES ('a083e4de82b8422eb7b3124435c2c6e9', '000', 'areamgr');
INSERT INTO `role_module` VALUES ('a0a1c67890864ec6ae23e34beb2f089c', '000', '4');
INSERT INTO `role_module` VALUES ('b2d488ea09ef43e78a6f03e5e4d05d4b', '000', 'schoollib');
INSERT INTO `role_module` VALUES ('d0b7f4a72fdf4f84897a8a5f8608ed6c', '000', 'learningcenter');
INSERT INTO `role_module` VALUES ('d3d9e86e3df34474af3f965614c73efc', '000', 'checkphoto');
INSERT INTO `role_module` VALUES ('d6e5f9f1d0e241caa1986b9ed327c20b', '000', 'schollalbum');
INSERT INTO `role_module` VALUES ('dc0c6b9c69df47609d4280cd29fa972b', '000', 'appraisemgr');
INSERT INTO `role_module` VALUES ('e1f51ad2368b4c97a744032de7ed7cd3', '000', 'btnpermission');
INSERT INTO `role_module` VALUES ('e1fd5647cfc3446db219d8bfdf9e6de4', '000', 'rolemgr');
INSERT INTO `role_module` VALUES ('e5ed5302c1744d0098ff318831cce080', '000', 'schoolnews');
INSERT INTO `role_module` VALUES ('f5e37f5b02e542559ea824da677d91de', '000', 'viewPager');
INSERT INTO `role_module` VALUES ('506d167fe99a40fb9bb803c6558bb894', '002', '3');
INSERT INTO `role_module` VALUES ('74ebdb927621441eab8d73f0a509d215', '002', '0');
INSERT INTO `role_module` VALUES ('ca543820cdc34f16a4c68dc858233942', '002', 'grademgr');
INSERT INTO `role_module` VALUES ('0a9835b04f474b7f87bea72e0b8b7d33', '005', 'pushpanel');
INSERT INTO `role_module` VALUES ('28fc1f4cd87949dfa30f233bfe8be80b', '005', 'myclass');
INSERT INTO `role_module` VALUES ('451d9155204342a88d5b0327da9a4a4b', '005', 'classalbum');
INSERT INTO `role_module` VALUES ('69c573297a504ffeb6d13f2b47fec70a', '005', 'appraisemgr');
INSERT INTO `role_module` VALUES ('863bb82f4db24476ab2ee6c8529fb60f', '005', '2');
INSERT INTO `role_module` VALUES ('8c464b3c775f4a4ead5dfc3e5fa3e2d9', '005', 'classlib');
INSERT INTO `role_module` VALUES ('a6e9ef1c756742c9a793a888a6970305', '005', '7');
INSERT INTO `role_module` VALUES ('b184f5068353492b9999ae3330739f6a', '005', 'showselectedcurricula');
INSERT INTO `role_module` VALUES ('beaa2ee64a2e4e67b775caffa0f8a9fd', '005', 'exammgr');
INSERT INTO `role_module` VALUES ('ca19ec9ae2164c12bcc9a8b716a00b49', '005', 'healthmgr');
INSERT INTO `role_module` VALUES ('d4775b7ac5e2458eb7f78e3aaf1d3121', '005', '5');
INSERT INTO `role_module` VALUES ('dcaad7b158de4ef18202460f36e86fb3', '005', '4');
INSERT INTO `role_module` VALUES ('ea2cf680959b43929fa65ea05d2efdf8', '005', 'checkphoto');
INSERT INTO `role_module` VALUES ('07731c3b0f634d89be31991c480f7811', '006', 'checkphoto');
INSERT INTO `role_module` VALUES ('083ea75c9c694da6a43e882b9793db86', '006', 'appraisemgr');
INSERT INTO `role_module` VALUES ('1c05533aa08c4eac8664c8740f54281d', '006', 'classlib');
INSERT INTO `role_module` VALUES ('1f9301446c6b485b99bed3e32ba575ad', '006', 'exammgr');
INSERT INTO `role_module` VALUES ('3738231d64de4963afb2be658bf42982', '006', 'classalbum');
INSERT INTO `role_module` VALUES ('52473b97aa2141d7937c904dd758893c', '006', 'showselectedcurricula');
INSERT INTO `role_module` VALUES ('59446685f4a1424c948209a1d75e6b64', '006', '4');
INSERT INTO `role_module` VALUES ('6df650c73be942878d454e8f5825475c', '006', '7');
INSERT INTO `role_module` VALUES ('9973629d207240cfb8b26728a60765f1', '006', 'myclass');
INSERT INTO `role_module` VALUES ('a47f418f82f64b28bd744a1fd7e89cf2', '006', 'healthmgr');
INSERT INTO `role_module` VALUES ('c5153733d6d2419ea12328dc94fa770e', '006', 'pushpanel');
INSERT INTO `role_module` VALUES ('d562be203079437a91e86210517307b9', '006', '5');
INSERT INTO `role_module` VALUES ('fc00d78e346e4773bb572aa64fa91b86', '006', '2');
INSERT INTO `role_module` VALUES ('0efc13f743454ec3a3fd22f905fadade', '7cc0199c8ce84fb0bc181007cee6f8a5', 'arrangerole');
INSERT INTO `role_module` VALUES ('275bc3d4f7f54b37914a299bf1d7d0fc', '7cc0199c8ce84fb0bc181007cee6f8a5', 'schollalbum');
INSERT INTO `role_module` VALUES ('2d86c22b66734b6f900fda3445bafd03', '7cc0199c8ce84fb0bc181007cee6f8a5', 'positionmgr');
INSERT INTO `role_module` VALUES ('2e6cad1d3c75421a83430fe49cb06f74', '7cc0199c8ce84fb0bc181007cee6f8a5', '5');
INSERT INTO `role_module` VALUES ('30179f0ce1a64c93ba3f7c69fdef52ee', '7cc0199c8ce84fb0bc181007cee6f8a5', 'introduce');
INSERT INTO `role_module` VALUES ('31c6ba1d58ab49cba961e0f588573bbb', '7cc0199c8ce84fb0bc181007cee6f8a5', 'showselectedcurricula');
INSERT INTO `role_module` VALUES ('36ac7bf4ce8f4487981ebc3582481a6e', '7cc0199c8ce84fb0bc181007cee6f8a5', 'learningcenter');
INSERT INTO `role_module` VALUES ('37f2fba75c31495aa00e409bd349c623', '7cc0199c8ce84fb0bc181007cee6f8a5', '7');
INSERT INTO `role_module` VALUES ('3c6a501cc7df4993886ef31f03cbed90', '7cc0199c8ce84fb0bc181007cee6f8a5', 'exammgr');
INSERT INTO `role_module` VALUES ('4014aadb3fbc47af8362eebc66a068dd', '7cc0199c8ce84fb0bc181007cee6f8a5', '1');
INSERT INTO `role_module` VALUES ('451fbd33612a432d9d4934f34190f1dc', '7cc0199c8ce84fb0bc181007cee6f8a5', 'grademgr');
INSERT INTO `role_module` VALUES ('4cd7fe591394459bb7c8a32f19fd19b9', '7cc0199c8ce84fb0bc181007cee6f8a5', 'schoolnews');
INSERT INTO `role_module` VALUES ('558d4298f5fe4632b4425e89a3fa5a9c', '7cc0199c8ce84fb0bc181007cee6f8a5', 'pushpanel');
INSERT INTO `role_module` VALUES ('615315ae89c8405ea4cdada55de4b22a', '7cc0199c8ce84fb0bc181007cee6f8a5', 'viewPager');
INSERT INTO `role_module` VALUES ('639bd60f9a114a0ca86f55ad5a1f84bc', '7cc0199c8ce84fb0bc181007cee6f8a5', 'rolemgr');
INSERT INTO `role_module` VALUES ('741234f70dea445c9b5d109a03280655', '7cc0199c8ce84fb0bc181007cee6f8a5', 'arrangemodule');
INSERT INTO `role_module` VALUES ('7a81071c2e644f93adc95d0a3eed9f40', '7cc0199c8ce84fb0bc181007cee6f8a5', 'teachermgr');
INSERT INTO `role_module` VALUES ('9c017dc3394d4d26a79120049902c33a', '7cc0199c8ce84fb0bc181007cee6f8a5', '6');
INSERT INTO `role_module` VALUES ('a9c08b829a364db2951ad59c0e6394cc', '7cc0199c8ce84fb0bc181007cee6f8a5', '3');
INSERT INTO `role_module` VALUES ('ab27c33a44fa47a49b916036871828ad', '7cc0199c8ce84fb0bc181007cee6f8a5', 'coursemgr');
INSERT INTO `role_module` VALUES ('b63cbaa7ddfe4b83b7e2b5bc5ca15515', '7cc0199c8ce84fb0bc181007cee6f8a5', '4');
INSERT INTO `role_module` VALUES ('c36b617b17434d79a72467ec9cc7881e', '7cc0199c8ce84fb0bc181007cee6f8a5', 'btnpermission');
INSERT INTO `role_module` VALUES ('d1c8eab4262f4bb09f8c0eede42c5bbd', '7cc0199c8ce84fb0bc181007cee6f8a5', '8');
INSERT INTO `role_module` VALUES ('dbc0e2d88c4545b680404b5fb56918fb', '7cc0199c8ce84fb0bc181007cee6f8a5', 'classnews');
INSERT INTO `role_module` VALUES ('e9bc51e8cb0a44f2ac5c31774d3485ee', '7cc0199c8ce84fb0bc181007cee6f8a5', 'schoollib');
INSERT INTO `role_module` VALUES ('fbc49ee1d77d455bb907bc0410e633b2', '7cc0199c8ce84fb0bc181007cee6f8a5', 'departmgr');

-- ----------------------------
-- Table structure for `role_module_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_module_permission`;
CREATE TABLE `role_module_permission` (
  `role_module_id` varchar(32) NOT NULL DEFAULT '0',
  `permission_id` varchar(32) NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_module_id`,`permission_id`),
  KEY `FK_64` (`permission_id`) USING BTREE,
  CONSTRAINT `role_module_permission_ibfk_1` FOREIGN KEY (`role_module_id`) REFERENCES `role_module` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_module_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_module_permission
-- ----------------------------
INSERT INTO `role_module_permission` VALUES ('07731c3b0f634d89be31991c480f7811', 'acceptPhoto');
INSERT INTO `role_module_permission` VALUES ('d3d9e86e3df34474af3f965614c73efc', 'acceptPhoto');
INSERT INTO `role_module_permission` VALUES ('ea2cf680959b43929fa65ea05d2efdf8', 'acceptPhoto');
INSERT INTO `role_module_permission` VALUES ('3738231d64de4963afb2be658bf42982', 'addAlbum');
INSERT INTO `role_module_permission` VALUES ('451d9155204342a88d5b0327da9a4a4b', 'addAlbum');
INSERT INTO `role_module_permission` VALUES ('990bcf2b20f7488b8d1f511174c4d26b', 'addAlbum');
INSERT INTO `role_module_permission` VALUES ('275bc3d4f7f54b37914a299bf1d7d0fc', 'addAlbumSchool');
INSERT INTO `role_module_permission` VALUES ('d6e5f9f1d0e241caa1986b9ed327c20b', 'addAlbumSchool');
INSERT INTO `role_module_permission` VALUES ('083ea75c9c694da6a43e882b9793db86', 'addAppraise');
INSERT INTO `role_module_permission` VALUES ('69c573297a504ffeb6d13f2b47fec70a', 'addAppraise');
INSERT INTO `role_module_permission` VALUES ('dc0c6b9c69df47609d4280cd29fa972b', 'addAppraise');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f098fd0', 'addDepartment');
INSERT INTO `role_module_permission` VALUES ('fbc49ee1d77d455bb907bc0410e633b2', 'addDepartment');
INSERT INTO `role_module_permission` VALUES ('231b9a0f076840799e4dc0f4d102cd2a', 'addExam');
INSERT INTO `role_module_permission` VALUES ('31c6ba1d58ab49cba961e0f588573bbb', 'addExam');
INSERT INTO `role_module_permission` VALUES ('52473b97aa2141d7937c904dd758893c', 'addExam');
INSERT INTO `role_module_permission` VALUES ('b184f5068353492b9999ae3330739f6a', 'addExam');
INSERT INTO `role_module_permission` VALUES ('23033ed7fe324656ab2c824e8428336d', 'addGrade');
INSERT INTO `role_module_permission` VALUES ('451fbd33612a432d9d4934f34190f1dc', 'addGrade');
INSERT INTO `role_module_permission` VALUES ('116e98d8a0304194ac26fad6a3053825', 'addIntroSchool');
INSERT INTO `role_module_permission` VALUES ('30179f0ce1a64c93ba3f7c69fdef52ee', 'addIntroSchool');
INSERT INTO `role_module_permission` VALUES ('2d86c22b66734b6f900fda3445bafd03', 'addPosition');
INSERT INTO `role_module_permission` VALUES ('7976b5b6e85f41d3afe824122b48ff72', 'addPosition');
INSERT INTO `role_module_permission` VALUES ('36ac7bf4ce8f4487981ebc3582481a6e', 'addResource');
INSERT INTO `role_module_permission` VALUES ('d0b7f4a72fdf4f84897a8a5f8608ed6c', 'addResource');
INSERT INTO `role_module_permission` VALUES ('639bd60f9a114a0ca86f55ad5a1f84bc', 'addRole');
INSERT INTO `role_module_permission` VALUES ('e1fd5647cfc3446db219d8bfdf9e6de4', 'addRole');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f0tt55e', 'addSchool');
INSERT INTO `role_module_permission` VALUES ('231b9a0f076840799e4dc0f4d102cd2a', 'addSelect');
INSERT INTO `role_module_permission` VALUES ('31c6ba1d58ab49cba961e0f588573bbb', 'addSelect');
INSERT INTO `role_module_permission` VALUES ('b184f5068353492b9999ae3330739f6a', 'addSelect');
INSERT INTO `role_module_permission` VALUES ('070e0f8a5cdc483fbf24492e6b9890f4', 'addSubject');
INSERT INTO `role_module_permission` VALUES ('ab27c33a44fa47a49b916036871828ad', 'addSubject');
INSERT INTO `role_module_permission` VALUES ('5132bbe51e2e4f09aeabde359f96b866', 'addTeacher');
INSERT INTO `role_module_permission` VALUES ('7a81071c2e644f93adc95d0a3eed9f40', 'addTeacher');
INSERT INTO `role_module_permission` VALUES ('1c05533aa08c4eac8664c8740f54281d', 'addVideoLib');
INSERT INTO `role_module_permission` VALUES ('8c464b3c775f4a4ead5dfc3e5fa3e2d9', 'addVideoLib');
INSERT INTO `role_module_permission` VALUES ('9ab88813e876469c84cf948898dded91', 'addVideoLib');
INSERT INTO `role_module_permission` VALUES ('b2d488ea09ef43e78a6f03e5e4d05d4b', 'addVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('e9bc51e8cb0a44f2ac5c31774d3485ee', 'addVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('c36b617b17434d79a72467ec9cc7881e', 'arrangeBtnPermission');
INSERT INTO `role_module_permission` VALUES ('e1f51ad2368b4c97a744032de7ed7cd3', 'arrangeBtnPermission');
INSERT INTO `role_module_permission` VALUES ('741234f70dea445c9b5d109a03280655', 'arrangeModule');
INSERT INTO `role_module_permission` VALUES ('8f80e50ed60b40c58acb37344b5132ee', 'arrangeModule');
INSERT INTO `role_module_permission` VALUES ('2d86c22b66734b6f900fda3445bafd03', 'arrangePosition');
INSERT INTO `role_module_permission` VALUES ('7976b5b6e85f41d3afe824122b48ff72', 'arrangePosition');
INSERT INTO `role_module_permission` VALUES ('0efc13f743454ec3a3fd22f905fadade', 'arrangeRole');
INSERT INTO `role_module_permission` VALUES ('13ef3eaea67c486eb783c0aa3af904c7', 'arrangeRole');
INSERT INTO `role_module_permission` VALUES ('3738231d64de4963afb2be658bf42982', 'deleteAlbum');
INSERT INTO `role_module_permission` VALUES ('451d9155204342a88d5b0327da9a4a4b', 'deleteAlbum');
INSERT INTO `role_module_permission` VALUES ('990bcf2b20f7488b8d1f511174c4d26b', 'deleteAlbum');
INSERT INTO `role_module_permission` VALUES ('275bc3d4f7f54b37914a299bf1d7d0fc', 'deleteAlbumSchool');
INSERT INTO `role_module_permission` VALUES ('d6e5f9f1d0e241caa1986b9ed327c20b', 'deleteAlbumSchool');
INSERT INTO `role_module_permission` VALUES ('69c573297a504ffeb6d13f2b47fec70a', 'deleteAppraise');
INSERT INTO `role_module_permission` VALUES ('dc0c6b9c69df47609d4280cd29fa972b', 'deleteAppraise');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f098fd0', 'deleteDepartment');
INSERT INTO `role_module_permission` VALUES ('fbc49ee1d77d455bb907bc0410e633b2', 'deleteDepartment');
INSERT INTO `role_module_permission` VALUES ('1ada6c925bc14f1a86ad6fcdecffa6e6', 'deleteExam');
INSERT INTO `role_module_permission` VALUES ('1f9301446c6b485b99bed3e32ba575ad', 'deleteExam');
INSERT INTO `role_module_permission` VALUES ('3c6a501cc7df4993886ef31f03cbed90', 'deleteExam');
INSERT INTO `role_module_permission` VALUES ('23033ed7fe324656ab2c824e8428336d', 'deleteGrade');
INSERT INTO `role_module_permission` VALUES ('451fbd33612a432d9d4934f34190f1dc', 'deleteGrade');
INSERT INTO `role_module_permission` VALUES ('292909e0ed604d2096400ab4f4726f81', 'deleteHealth');
INSERT INTO `role_module_permission` VALUES ('ca19ec9ae2164c12bcc9a8b716a00b49', 'deleteHealth');
INSERT INTO `role_module_permission` VALUES ('3659e2f65ec34cb4b87622b7ed1b4fff', 'deleteNewsClass');
INSERT INTO `role_module_permission` VALUES ('dbc0e2d88c4545b680404b5fb56918fb', 'deleteNewsClass');
INSERT INTO `role_module_permission` VALUES ('4cd7fe591394459bb7c8a32f19fd19b9', 'deleteNewsSchool');
INSERT INTO `role_module_permission` VALUES ('e5ed5302c1744d0098ff318831cce080', 'deleteNewsSchool');
INSERT INTO `role_module_permission` VALUES ('07731c3b0f634d89be31991c480f7811', 'deletePhoto');
INSERT INTO `role_module_permission` VALUES ('d3d9e86e3df34474af3f965614c73efc', 'deletePhoto');
INSERT INTO `role_module_permission` VALUES ('ea2cf680959b43929fa65ea05d2efdf8', 'deletePhoto');
INSERT INTO `role_module_permission` VALUES ('615315ae89c8405ea4cdada55de4b22a', 'deletePhotos');
INSERT INTO `role_module_permission` VALUES ('f5e37f5b02e542559ea824da677d91de', 'deletePhotos');
INSERT INTO `role_module_permission` VALUES ('2d86c22b66734b6f900fda3445bafd03', 'deletePosition');
INSERT INTO `role_module_permission` VALUES ('7976b5b6e85f41d3afe824122b48ff72', 'deletePosition');
INSERT INTO `role_module_permission` VALUES ('36ac7bf4ce8f4487981ebc3582481a6e', 'deleteResource');
INSERT INTO `role_module_permission` VALUES ('d0b7f4a72fdf4f84897a8a5f8608ed6c', 'deleteResource');
INSERT INTO `role_module_permission` VALUES ('639bd60f9a114a0ca86f55ad5a1f84bc', 'deleteRole');
INSERT INTO `role_module_permission` VALUES ('e1fd5647cfc3446db219d8bfdf9e6de4', 'deleteRole');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f0tt55e', 'deleteSchool');
INSERT INTO `role_module_permission` VALUES ('231b9a0f076840799e4dc0f4d102cd2a', 'deleteSelect');
INSERT INTO `role_module_permission` VALUES ('31c6ba1d58ab49cba961e0f588573bbb', 'deleteSelect');
INSERT INTO `role_module_permission` VALUES ('b184f5068353492b9999ae3330739f6a', 'deleteSelect');
INSERT INTO `role_module_permission` VALUES ('19569511f5ef4e649be5908f3a37dee7', 'deleteStudent');
INSERT INTO `role_module_permission` VALUES ('070e0f8a5cdc483fbf24492e6b9890f4', 'deleteSubject');
INSERT INTO `role_module_permission` VALUES ('ab27c33a44fa47a49b916036871828ad', 'deleteSubject');
INSERT INTO `role_module_permission` VALUES ('5132bbe51e2e4f09aeabde359f96b866', 'deleteTeacher');
INSERT INTO `role_module_permission` VALUES ('7a81071c2e644f93adc95d0a3eed9f40', 'deleteTeacher');
INSERT INTO `role_module_permission` VALUES ('1c05533aa08c4eac8664c8740f54281d', 'deleteVideoLib');
INSERT INTO `role_module_permission` VALUES ('8c464b3c775f4a4ead5dfc3e5fa3e2d9', 'deleteVideoLib');
INSERT INTO `role_module_permission` VALUES ('9ab88813e876469c84cf948898dded91', 'deleteVideoLib');
INSERT INTO `role_module_permission` VALUES ('b2d488ea09ef43e78a6f03e5e4d05d4b', 'deleteVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('e9bc51e8cb0a44f2ac5c31774d3485ee', 'deleteVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('833e5c8c33124a36bccd6cf9973ae456', 'doPublishNews');
INSERT INTO `role_module_permission` VALUES ('2f515ab86da0481cbed3e87d99c7372e', 'doPush');
INSERT INTO `role_module_permission` VALUES ('558d4298f5fe4632b4425e89a3fa5a9c', 'doPush');
INSERT INTO `role_module_permission` VALUES ('c5153733d6d2419ea12328dc94fa770e', 'doPush');
INSERT INTO `role_module_permission` VALUES ('36ac7bf4ce8f4487981ebc3582481a6e', 'doResource');
INSERT INTO `role_module_permission` VALUES ('d0b7f4a72fdf4f84897a8a5f8608ed6c', 'doResource');
INSERT INTO `role_module_permission` VALUES ('292909e0ed604d2096400ab4f4726f81', 'downloadHealth');
INSERT INTO `role_module_permission` VALUES ('a47f418f82f64b28bd744a1fd7e89cf2', 'downloadHealth');
INSERT INTO `role_module_permission` VALUES ('ca19ec9ae2164c12bcc9a8b716a00b49', 'downloadHealth');
INSERT INTO `role_module_permission` VALUES ('19569511f5ef4e649be5908f3a37dee7', 'downloadStudent');
INSERT INTO `role_module_permission` VALUES ('28fc1f4cd87949dfa30f233bfe8be80b', 'downloadStudent');
INSERT INTO `role_module_permission` VALUES ('9973629d207240cfb8b26728a60765f1', 'downloadStudent');
INSERT INTO `role_module_permission` VALUES ('5132bbe51e2e4f09aeabde359f96b866', 'downloadTeacher');
INSERT INTO `role_module_permission` VALUES ('7a81071c2e644f93adc95d0a3eed9f40', 'downloadTeacher');
INSERT INTO `role_module_permission` VALUES ('083ea75c9c694da6a43e882b9793db86', 'editAppraise');
INSERT INTO `role_module_permission` VALUES ('69c573297a504ffeb6d13f2b47fec70a', 'editAppraise');
INSERT INTO `role_module_permission` VALUES ('dc0c6b9c69df47609d4280cd29fa972b', 'editAppraise');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f098fd0', 'editDepartment');
INSERT INTO `role_module_permission` VALUES ('fbc49ee1d77d455bb907bc0410e633b2', 'editDepartment');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f098fd0', 'editDepartmentMember');
INSERT INTO `role_module_permission` VALUES ('fbc49ee1d77d455bb907bc0410e633b2', 'editDepartmentMember');
INSERT INTO `role_module_permission` VALUES ('1ada6c925bc14f1a86ad6fcdecffa6e6', 'editExam');
INSERT INTO `role_module_permission` VALUES ('1f9301446c6b485b99bed3e32ba575ad', 'editExam');
INSERT INTO `role_module_permission` VALUES ('3c6a501cc7df4993886ef31f03cbed90', 'editExam');
INSERT INTO `role_module_permission` VALUES ('23033ed7fe324656ab2c824e8428336d', 'editGrade');
INSERT INTO `role_module_permission` VALUES ('451fbd33612a432d9d4934f34190f1dc', 'editGrade');
INSERT INTO `role_module_permission` VALUES ('292909e0ed604d2096400ab4f4726f81', 'editHealth');
INSERT INTO `role_module_permission` VALUES ('ca19ec9ae2164c12bcc9a8b716a00b49', 'editHealth');
INSERT INTO `role_module_permission` VALUES ('07731c3b0f634d89be31991c480f7811', 'editPhoto');
INSERT INTO `role_module_permission` VALUES ('d3d9e86e3df34474af3f965614c73efc', 'editPhoto');
INSERT INTO `role_module_permission` VALUES ('ea2cf680959b43929fa65ea05d2efdf8', 'editPhoto');
INSERT INTO `role_module_permission` VALUES ('2d86c22b66734b6f900fda3445bafd03', 'editPosition');
INSERT INTO `role_module_permission` VALUES ('7976b5b6e85f41d3afe824122b48ff72', 'editPosition');
INSERT INTO `role_module_permission` VALUES ('639bd60f9a114a0ca86f55ad5a1f84bc', 'editRole');
INSERT INTO `role_module_permission` VALUES ('e1fd5647cfc3446db219d8bfdf9e6de4', 'editRole');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f0tt55e', 'editSchool');
INSERT INTO `role_module_permission` VALUES ('19569511f5ef4e649be5908f3a37dee7', 'editStudent');
INSERT INTO `role_module_permission` VALUES ('28fc1f4cd87949dfa30f233bfe8be80b', 'editStudent');
INSERT INTO `role_module_permission` VALUES ('070e0f8a5cdc483fbf24492e6b9890f4', 'editSubject');
INSERT INTO `role_module_permission` VALUES ('ab27c33a44fa47a49b916036871828ad', 'editSubject');
INSERT INTO `role_module_permission` VALUES ('5132bbe51e2e4f09aeabde359f96b866', 'editTeacher');
INSERT INTO `role_module_permission` VALUES ('7a81071c2e644f93adc95d0a3eed9f40', 'editTeacher');
INSERT INTO `role_module_permission` VALUES ('1c05533aa08c4eac8664c8740f54281d', 'editVideoLib');
INSERT INTO `role_module_permission` VALUES ('8c464b3c775f4a4ead5dfc3e5fa3e2d9', 'editVideoLib');
INSERT INTO `role_module_permission` VALUES ('9ab88813e876469c84cf948898dded91', 'editVideoLib');
INSERT INTO `role_module_permission` VALUES ('b2d488ea09ef43e78a6f03e5e4d05d4b', 'editVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('e9bc51e8cb0a44f2ac5c31774d3485ee', 'editVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('2d86c22b66734b6f900fda3445bafd03', 'getTeacherInPosition');
INSERT INTO `role_module_permission` VALUES ('7976b5b6e85f41d3afe824122b48ff72', 'getTeacherInPosition');
INSERT INTO `role_module_permission` VALUES ('3738231d64de4963afb2be658bf42982', 'openAlbumClass');
INSERT INTO `role_module_permission` VALUES ('451d9155204342a88d5b0327da9a4a4b', 'openAlbumClass');
INSERT INTO `role_module_permission` VALUES ('990bcf2b20f7488b8d1f511174c4d26b', 'openAlbumClass');
INSERT INTO `role_module_permission` VALUES ('275bc3d4f7f54b37914a299bf1d7d0fc', 'openAlbumSchool');
INSERT INTO `role_module_permission` VALUES ('d6e5f9f1d0e241caa1986b9ed327c20b', 'openAlbumSchool');
INSERT INTO `role_module_permission` VALUES ('1c05533aa08c4eac8664c8740f54281d', 'openVideoLibClass');
INSERT INTO `role_module_permission` VALUES ('8c464b3c775f4a4ead5dfc3e5fa3e2d9', 'openVideoLibClass');
INSERT INTO `role_module_permission` VALUES ('9ab88813e876469c84cf948898dded91', 'openVideoLibClass');
INSERT INTO `role_module_permission` VALUES ('b2d488ea09ef43e78a6f03e5e4d05d4b', 'openVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('e9bc51e8cb0a44f2ac5c31774d3485ee', 'openVideoLibSchool');
INSERT INTO `role_module_permission` VALUES ('4cd7fe591394459bb7c8a32f19fd19b9', 'publishNews');
INSERT INTO `role_module_permission` VALUES ('e5ed5302c1744d0098ff318831cce080', 'publishNews');
INSERT INTO `role_module_permission` VALUES ('3659e2f65ec34cb4b87622b7ed1b4fff', 'publishNewsClass');
INSERT INTO `role_module_permission` VALUES ('dbc0e2d88c4545b680404b5fb56918fb', 'publishNewsClass');
INSERT INTO `role_module_permission` VALUES ('79e2c9303320427090002981d318a3a0', 'queryPush');
INSERT INTO `role_module_permission` VALUES ('08385ab2360f4e699420ac7e5f0tt55e', 'readSchoolIntro');
INSERT INTO `role_module_permission` VALUES ('23033ed7fe324656ab2c824e8428336d', 'seeClass');
INSERT INTO `role_module_permission` VALUES ('451fbd33612a432d9d4934f34190f1dc', 'seeClass');
INSERT INTO `role_module_permission` VALUES ('070e0f8a5cdc483fbf24492e6b9890f4', 'seeCourse');
INSERT INTO `role_module_permission` VALUES ('ab27c33a44fa47a49b916036871828ad', 'seeCourse');
INSERT INTO `role_module_permission` VALUES ('a083e4de82b8422eb7b3124435c2c6e9', 'seeEduHotNews');
INSERT INTO `role_module_permission` VALUES ('1ada6c925bc14f1a86ad6fcdecffa6e6', 'seeExamScore');
INSERT INTO `role_module_permission` VALUES ('1f9301446c6b485b99bed3e32ba575ad', 'seeExamScore');
INSERT INTO `role_module_permission` VALUES ('3c6a501cc7df4993886ef31f03cbed90', 'seeExamScore');
INSERT INTO `role_module_permission` VALUES ('3659e2f65ec34cb4b87622b7ed1b4fff', 'seeNewsClass');
INSERT INTO `role_module_permission` VALUES ('dbc0e2d88c4545b680404b5fb56918fb', 'seeNewsClass');
INSERT INTO `role_module_permission` VALUES ('4cd7fe591394459bb7c8a32f19fd19b9', 'seeNewsSchool');
INSERT INTO `role_module_permission` VALUES ('e5ed5302c1744d0098ff318831cce080', 'seeNewsSchool');
INSERT INTO `role_module_permission` VALUES ('292909e0ed604d2096400ab4f4726f81', 'uploadHealth');
INSERT INTO `role_module_permission` VALUES ('ca19ec9ae2164c12bcc9a8b716a00b49', 'uploadHealth');
INSERT INTO `role_module_permission` VALUES ('615315ae89c8405ea4cdada55de4b22a', 'uploadPhoto');
INSERT INTO `role_module_permission` VALUES ('f5e37f5b02e542559ea824da677d91de', 'uploadPhoto');
INSERT INTO `role_module_permission` VALUES ('19569511f5ef4e649be5908f3a37dee7', 'uploadStudent');
INSERT INTO `role_module_permission` VALUES ('28fc1f4cd87949dfa30f233bfe8be80b', 'uploadStudent');
INSERT INTO `role_module_permission` VALUES ('5132bbe51e2e4f09aeabde359f96b866', 'uploadTeacher');
INSERT INTO `role_module_permission` VALUES ('7a81071c2e644f93adc95d0a3eed9f40', 'uploadTeacher');
INSERT INTO `role_module_permission` VALUES ('19569511f5ef4e649be5908f3a37dee7', 'viewPost');
INSERT INTO `role_module_permission` VALUES ('19569511f5ef4e649be5908f3a37dee7', 'viewSyllabus');
INSERT INTO `role_module_permission` VALUES ('28fc1f4cd87949dfa30f233bfe8be80b', 'viewSyllabus');
INSERT INTO `role_module_permission` VALUES ('9973629d207240cfb8b26728a60765f1', 'viewSyllabus');

-- ----------------------------
-- Table structure for `substation`
-- ----------------------------
DROP TABLE IF EXISTS `substation`;
CREATE TABLE `substation` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `company_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8` (`company_id`) USING BTREE,
  CONSTRAINT `substation_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of substation
-- ----------------------------
INSERT INTO `substation` VALUES ('001', '三华变电站', '001');
INSERT INTO `substation` VALUES ('002', '城西变电站', '001');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  `control_code` varchar(32) NOT NULL,
  `company_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_007` (`company_id`),
  CONSTRAINT `fk_007` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', '007', '123', '12345', '001');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(32) NOT NULL DEFAULT '0',
  `role_id` varchar(32) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_61` (`user_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
