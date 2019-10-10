CREATE TABLE `user`
(
    `id`            INT(11)      NOT NULL AUTO_INCREMENT,
    `account_id`    VARCHAR(100) NOT NULL DEFAULT '',
    `name`          VARCHAR(50)  NOT NULL DEFAULT '',
    `token`         CHAR(36)     NOT NULL,
    `create_time`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modified_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE `account_id` (account_id),
    UNIQUE `token` (`token`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;