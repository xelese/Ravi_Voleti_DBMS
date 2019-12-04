DROP DATABASE IF EXISTS `cs5200_fall2019_voleti`;

CREATE DATABASE `cs5200_fall2019_voleti`;
USE `cs5200_fall2019_voleti`;

CREATE TABLE `person`
(
    `id`         int(11)     NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) NOT NULL,
    `last_name`  varchar(45) NOT NULL,
    `username`   varchar(45) NOT NULL,
    `password`   varchar(45) NOT NULL,
    `email`      varchar(45) DEFAULT NULL,
    `dob`        date,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


CREATE TABLE `user`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `user_agreement` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `user_person_generalization` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


CREATE TABLE `developer`
(
    `id`            INT(11)     NOT NULL AUTO_INCREMENT,
    `developer_key` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `developer_person_generalization` FOREIGN KEY (`id`)
        REFERENCES `person` (`id`)
        ON UPDATE NO ACTION
) ENGINE = INNODB
  DEFAULT CHARSET = LATIN1;

CREATE TABLE `website`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `name`        varchar(45) NOT NULL,
    `description` varchar(150) DEFAULT NULL,
    `created`     date        NOT NULL,
    `updated`     date        NOT NULL,
    `visits`      int(11)     NOT NULL,
    `developer`   int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `developer_idx` (`developer`),
    CONSTRAINT `developer_self_generalization` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `page`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `title`       varchar(45) NOT NULL,
    `description` varchar(100) DEFAULT NULL,
    `created`     date        NOT NULL,
    `updated`     date        NOT NULL,
    `views`       int(11)     NOT NULL,
    `website`     int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `website_idx` (`website`),
    CONSTRAINT `website_self_generalization` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


CREATE TABLE `type_of_widget`
(
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

INSERT INTO `cs5200_fall2019_voleti`.`type_of_widget`
    (`name`)
VALUES ('heading');

INSERT INTO `cs5200_fall2019_voleti`.`type_of_widget`
    (`name`)
VALUES ('html');

INSERT INTO `cs5200_fall2019_voleti`.`type_of_widget`
    (`name`)
VALUES ('youtube');

INSERT INTO `cs5200_fall2019_voleti`.`type_of_widget`
    (`name`)
VALUES ('image');

CREATE TABLE `widget`
(
    `id`                 int(11)     NOT NULL AUTO_INCREMENT,
    `name`               varchar(45) NOT NULL,
    `width`              int(11)     DEFAULT NULL,
    `height`             int(11)     DEFAULT NULL,
    `css_class`          varchar(45) DEFAULT NULL,
    `css_style`          varchar(45) DEFAULT NULL,
    `text`               varchar(45) DEFAULT NULL,
    `order`              int(11)     NOT NULL,
    `youtube_url`        varchar(45) DEFAULT NULL,
    `youtube_shareble`   tinyint(4)  DEFAULT NULL,
    `youtube_expandable` tinyint(4)  DEFAULT NULL,
    `image_source`       varchar(45) DEFAULT NULL,
    `heading_size`       int(5)      DEFAULT 2,
    `html`               varchar(45) DEFAULT NULL,
    `page`               int(11)     DEFAULT NULL,
    `dtype`              varchar(45) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `page_idx` (`page`),
    KEY `dtype_idx` (`dtype`),
    CONSTRAINT `page_self_generalization` FOREIGN KEY (`page`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT `dtype_type_of_widget_generalization` FOREIGN KEY (`dtype`) REFERENCES `type_of_widget` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `phone`
(
    `id`      int(11)     NOT NULL AUTO_INCREMENT,
    `phone`   varchar(45) NOT NULL,
    `primary` tinyint(1)  NOT NULL,
    `person`  int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `person_idx` (`person`),
    CONSTRAINT `phone_person_generalization` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `address`
(
    `id`      int(11)     NOT NULL AUTO_INCREMENT,
    `street1` varchar(45) NOT NULL,
    `street2` varchar(45) DEFAULT NULL,
    `city`    varchar(45) NOT NULL,
    `state`   varchar(45) DEFAULT NULL,
    `zip`     varchar(45) NOT NULL,
    `primary` tinyint(1)  NOT NULL,
    `person`  int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `person_idx` (`person`),
    CONSTRAINT `address_person_generalization` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `priviledge`
(
    `name` varchar(10) NOT NULL,
    PRIMARY KEY (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

INSERT INTO `cs5200_fall2019_voleti`.`priviledge`
    (`name`)
VALUES ('create');

INSERT INTO `cs5200_fall2019_voleti`.`priviledge`
    (`name`)
VALUES ('read');

INSERT INTO `cs5200_fall2019_voleti`.`priviledge`
    (`name`)
VALUES ('update');

INSERT INTO `cs5200_fall2019_voleti`.`priviledge`
    (`name`)
VALUES ('delete');


CREATE TABLE `role`
(
    `name` varchar(10) NOT NULL,
    PRIMARY KEY (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

INSERT INTO `cs5200_fall2019_voleti`.`role`
    (`name`)
VALUES ('owner');

INSERT INTO `cs5200_fall2019_voleti`.`role`
    (`name`)
VALUES ('admin');

INSERT INTO `cs5200_fall2019_voleti`.`role`
    (`name`)
VALUES ('writer');

INSERT INTO `cs5200_fall2019_voleti`.`role`
    (`name`)
VALUES ('editor');

INSERT INTO `cs5200_fall2019_voleti`.`role`
    (`name`)
VALUES ('reviewer');

CREATE TABLE `website_priviledge`
(
    `id`         int(11)     NOT NULL AUTO_INCREMENT,
    `priviledge` varchar(45) NOT NULL,
    `developer`  int(11)     NOT NULL,
    `website`    int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `priviledge_idx` (`priviledge`),
    KEY `website_idx` (`website`),
    KEY `developer_idx` (`developer`),
    CONSTRAINT `website_priviledge_developer_self_generalization` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `website_priviledge_self_generalization` FOREIGN KEY (`priviledge`) REFERENCES `priviledge` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `web` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `website_role`
(
    `id`        int(11)     NOT NULL AUTO_INCREMENT,
    `role`      varchar(45) NOT NULL,
    `developer` int(11)     NOT NULL,
    `website`   int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `web_role_idx` (`role`),
    KEY `web_role_developer_idx` (`developer`),
    KEY `web_role_website_idx` (`website`),
    CONSTRAINT `website_role_self_generalization` FOREIGN KEY (`role`) REFERENCES `role` (`name`) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT `web_role_developer_self_generalization` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `web_role_website_self_generalization` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `page_priviledge`
(
    `id`         int(11)     NOT NULL AUTO_INCREMENT,
    `priviledge` varchar(45) NOT NULL,
    `page`       int(11)     NOT NULL,
    `developer`  int(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `page_priviledge_idx` (`priviledge`),
    KEY `page_developer_idx` (`developer`),
    KEY `page_idx` (`page`),
    CONSTRAINT `page_priviledge_self_generalization` FOREIGN KEY (`priviledge`) REFERENCES `priviledge` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `page_priviledge_developer_self_generalization` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `page_priviledge_page_self_generalization` FOREIGN KEY (`page`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE `page_role`
(
    `id`        INT(11)     NOT NULL AUTO_INCREMENT,
    `role`      VARCHAR(45) NOT NULL,
    `page`      INT(11)     NOT NULL,
    `developer` INT(11)     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `page_role_idx` (`role`),
    KEY `page_role_page_idx` (`page`),
    KEY `page_role_developer_idx` (`developer`),
    CONSTRAINT `page_role_self_generalization` FOREIGN KEY (`role`)
        REFERENCES `role` (`name`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `page_role_developer_generalization` FOREIGN KEY (`developer`)
        REFERENCES `developer` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `page_role_page_generalization` FOREIGN KEY (`page`)
        REFERENCES `page` (`id`)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB
  DEFAULT CHARSET = LATIN1;