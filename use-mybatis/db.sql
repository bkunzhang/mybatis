CREATE TABLE `bk_user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(20) NOT NULL,
	`age` SMALLINT NOT NULL DEFAULT 0,
	`xx_yy` VARCHAR(50) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `key1` (`username`)
)
COLLATE='utf8_general_ci'
;
