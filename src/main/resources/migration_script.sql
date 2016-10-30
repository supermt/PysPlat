-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: PysPlat2
-- Source Schemata: PysPlat
-- Created: Sun Oct 30 14:05:17 2016
-- Workbench Version: 6.3.4
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema PysPlat2
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `PysPlat2` ;
CREATE SCHEMA IF NOT EXISTS `PysPlat2` ;

-- ----------------------------------------------------------------------------
-- Table PysPlat2.Order
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `PysPlat2`.`Order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `userID` INT(11) NULL DEFAULT NULL COMMENT '',
  `target` VARCHAR(45) NOT NULL COMMENT '',
  `addtime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table PysPlat2.artical
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `PysPlat2`.`artical` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `title` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `content` VARCHAR(45) NOT NULL COMMENT '',
  `addtime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `enable` INT(11) NOT NULL DEFAULT '1' COMMENT '1-激活|2-禁用',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table PysPlat2.question
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `PysPlat2`.`question` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `question` TEXT NOT NULL COMMENT '',
  `optionA` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `optionB` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `optionC` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `optionD` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table PysPlat2.result
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `PysPlat2`.`result` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `userID` INT(11) UNSIGNED ZEROFILL NOT NULL COMMENT '',
  `questionID` INT(11) NOT NULL COMMENT '',
  `answer` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `questionid_idx` (`questionID` ASC)  COMMENT '',
  INDEX `FK_USER_RESULT` (`userID` ASC)  COMMENT '',
  CONSTRAINT `FK_QUESTION_RESULT`
    FOREIGN KEY (`questionID`)
    REFERENCES `PysPlat2`.`question` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_RESULT`
    FOREIGN KEY (`userID`)
    REFERENCES `PysPlat2`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table PysPlat2.user
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `PysPlat2`.`user` (
  `id` INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table PysPlat2.topic
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `PysPlat2`.`topic` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `userID` INT(11) NULL DEFAULT NULL COMMENT '发布用户的ID',
  `title` VARCHAR(255) NULL DEFAULT NULL COMMENT '帖子标题',
  `text` LONGTEXT NULL DEFAULT NULL COMMENT '帖子正文',
  `replyount` INT(255) NULL DEFAULT '0' COMMENT '回复数量',
  `viewsount` INT(255) NULL DEFAULT '0' COMMENT '查看次数',
  `addtime` TIMESTAMP NULL DEFAULT NULL COMMENT '发布时间',
  `enable` INT(255) NULL DEFAULT NULL COMMENT '状态：1--可见|2--不可见',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '粉丝团话题';

-- ----------------------------------------------------------------------------
-- Table PysPlat2.topicreply
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `PysPlat2`.`topicreply` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `topicid` INT(11) NULL DEFAULT NULL COMMENT '回复的话题ID',
  `userid` INT(11) NULL DEFAULT NULL COMMENT '回复者ID',
  `text` LONGTEXT NULL DEFAULT NULL COMMENT '回复正文',
  `addtime` DATETIME NULL DEFAULT NULL COMMENT '回复时间',
  `enable` INT(255) NULL DEFAULT NULL COMMENT '状态：1--可见|2--不可见（删除）',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '回帖表';
SET FOREIGN_KEY_CHECKS = 1;
