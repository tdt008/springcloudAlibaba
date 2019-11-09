DROP TABLE IF EXISTS `test_sys_base_area`;
CREATE TABLE `test_sys_base_area` (
  `id` bigint(12) NOT NULL,
  `pid` bigint(12) NOT NULL DEFAULT '0',
  `post_code` varchar(6) NOT NULL,
  `name` varchar(64) NOT NULL,
  `area_code` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;