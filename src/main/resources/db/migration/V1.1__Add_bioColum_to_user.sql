ALTER TABLE `user`
ADD COLUMN `bio` varchar(255) NULL DEFAULT '' AFTER `modified_time`;