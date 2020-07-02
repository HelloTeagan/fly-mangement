CREATE TABLE `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fly_no` varchar(50) DEFAULT NULL,
  `des` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `fly_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


INSERT INTO `flight` VALUES (1, '111', '新郑', '2020-6-9');
INSERT INTO `flight` VALUES (2, '112', '武汉', '2020-6-8');
INSERT INTO `flight` VALUES (3, '113', '北京', '2020-6-10');
