DROP TRIGGER IF EXISTS `cs5200_fall2019_voleti`.`page_role_AFTER_INSERT`;

DELIMITER $$
USE `cs5200_fall2019_voleti`$$
CREATE DEFINER = CURRENT_USER TRIGGER `cs5200_fall2019_voleti`.`page_role_AFTER_INSERT` AFTER INSERT ON `page_role` FOR EACH ROW
BEGIN
IF new.role like 'owner' THEN
INSERT INTO page_priviledge VALUES (NULL,'create',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'delete',new.page, new.developer);
END IF;

IF new.role like 'admin' THEN
INSERT INTO page_priviledge VALUES (NULL,'create',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'delete',new.page, new.developer);
END IF;

IF new.role like 'writer' THEN
INSERT INTO page_priviledge VALUES (NULL,'create',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
END IF;

IF new.role like 'editor' THEN
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
END IF;

IF new.role like 'reviewer' THEN
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
END IF;
END$$
DELIMITER ;









DROP TRIGGER IF EXISTS `cs5200_fall2019_voleti`.`page_role_AFTER_UPDATE`;

DELIMITER $$
USE `cs5200_fall2019_voleti`$$
CREATE DEFINER = CURRENT_USER TRIGGER `cs5200_fall2019_voleti`.`page_role_AFTER_UPDATE` AFTER UPDATE ON `page_role` FOR EACH ROW
BEGIN
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page;
IF new.role like 'owner' THEN
INSERT INTO page_priviledge VALUES (NULL,'create',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'delete',new.page, new.developer);
END IF;

IF new.role like 'admin' THEN
INSERT INTO page_priviledge VALUES (NULL,'create',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'delete',new.page, new.developer);
END IF;


IF new.role like 'writer' THEN
INSERT INTO page_priviledge VALUES (NULL,'create',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
END IF;

IF new.role like 'editor' THEN
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
INSERT INTO page_priviledge VALUES (NULL, 'update',new.page, new.developer);
END IF;

IF new.role like 'reviewer' THEN
INSERT INTO page_priviledge VALUES (NULL, 'read',new.page, new.developer);
END IF;
END$$
DELIMITER ;















DROP TRIGGER IF EXISTS `cs5200_fall2019_voleti`.`page_role_AFTER_DELETE`;

DELIMITER $$
USE `cs5200_fall2019_voleti`$$
CREATE DEFINER = CURRENT_USER TRIGGER `cs5200_fall2019_voleti`.`page_role_AFTER_DELETE` AFTER DELETE ON `page_role` FOR EACH ROW
BEGIN
IF OLD.role like 'owner' THEN
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'create';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'read';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'update';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'delete';
END IF;

IF OLD.role like 'admin' THEN
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'create';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'read';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'update';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'delete';
END IF;

IF OLD.role like 'writer' THEN
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'create';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'read';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'update';
END IF;

IF OLD.role like 'editor' THEN
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'read';
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'update';
END IF;

IF OLD.role like 'reviewer' THEN
DELETE FROM page_priviledge where developer = OLD.developer AND page = OLD.page AND priviledge = 'read';
END IF;
END$$
DELIMITER ;

