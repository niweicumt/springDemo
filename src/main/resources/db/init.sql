CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` char(64) NOT NULL COMMENT '用户号',
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1514165 DEFAULT CHARSET=utf8
;

INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (1,'niwei-test',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (2,'12345667891',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (3,'12345667892',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (4,'12345667893',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (2976,'a5af702b955f04375e16339a5843f5c0e2a24679',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (19024,'ad47eb4b4d27ad912cf10f1dc67a9cb48b423fc1',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (23342,'2b1b8923192390dd08dd17b062dfc0f93cb35080',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (93519,'93519',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (127832,'127832',NULL);
INSERT INTO `t_user` (`id`,`user_no`,`account_id`) VALUES (130861,'130861',NULL);


CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `point` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1246416 DEFAULT CHARSET=utf8 COMMENT='账户表'
;

INSERT INTO `t_account` (`id`,`point`) VALUES (1,250);
INSERT INTO `t_account` (`id`,`point`) VALUES (2,100);
INSERT INTO `t_account` (`id`,`point`) VALUES (3,10000);
INSERT INTO `t_account` (`id`,`point`) VALUES (4,10000);
INSERT INTO `t_account` (`id`,`point`) VALUES (5,10000);
INSERT INTO `t_account` (`id`,`point`) VALUES (6,100);
INSERT INTO `t_account` (`id`,`point`) VALUES (7,100);
INSERT INTO `t_account` (`id`,`point`) VALUES (8,100);
INSERT INTO `t_account` (`id`,`point`) VALUES (9,100);
INSERT INTO `t_account` (`id`,`point`) VALUES (10,100);


