CREATE TABLE `note`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT,
    `user_id`       int(11)     NOT NULL,
    `title`         varchar(50) NOT NULL,
    `description`   text        NOT NULL,
    `comment_count` int(11)     NOT NULL DEFAULT '0',
    `like_count`    int(255)    NOT NULL DEFAULT '0',
    `view_count`    int(255)    NOT NULL DEFAULT '0',
    `label`         varchar(255)         DEFAULT '',
    `create_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modified_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;