DROP TRIGGER IF EXISTS `cs5200_fall2019_voleti`.`website_role_AFTER_INSERT`;

DELIMITER $$
USE `cs5200_fall2019_voleti`$$
CREATE DEFINER = CURRENT_USER TRIGGER `cs5200_fall2019_voleti`.`website_role_AFTER_INSERT` AFTER INSERT ON `website_role` FOR EACH ROW
BEGIN
IF new.role like 'owner' THEN
INSERT INTO website_priviledge VALUES (NULL,'create', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'delete', new.developer, new.website);
END IF;

IF new.role like 'admin' THEN
INSERT INTO website_priviledge VALUES (NULL,'create', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'delete', new.developer, new.website);
END IF;

IF new.role like 'writer' THEN
INSERT INTO website_priviledge VALUES (NULL,'create', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
END IF;

IF new.role like 'editor' THEN
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
END IF;

IF new.role like 'reviewer' THEN
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
END IF;
END$$
DELIMITER ;











DROP TRIGGER IF EXISTS `cs5200_fall2019_voleti`.`website_role_AFTER_UPDATE`;

DELIMITER $$
USE `cs5200_fall2019_voleti`$$
CREATE DEFINER = CURRENT_USER TRIGGER `cs5200_fall2019_voleti`.`website_role_AFTER_UPDATE` AFTER UPDATE ON `website_role` FOR EACH ROW
BEGIN
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website;
IF new.role like 'owner' THEN
INSERT INTO website_priviledge VALUES (NULL,'create', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'delete', new.developer, new.website);
END IF;

IF new.role like 'admin' THEN
INSERT INTO website_priviledge VALUES (NULL,'create', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'delete', new.developer, new.website);
END IF;


IF new.role like 'writer' THEN
INSERT INTO website_priviledge VALUES (NULL,'create', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
END IF;

IF new.role like 'editor' THEN
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
INSERT INTO website_priviledge VALUES (NULL, 'update', new.developer, new.website);
END IF;

IF new.role like 'reviewer' THEN
INSERT INTO website_priviledge VALUES (NULL, 'read', new.developer, new.website);
END IF;
END$$
DELIMITER ;










DROP TRIGGER IF EXISTS `cs5200_fall2019_voleti`.`website_role_AFTER_DELETE`;

DELIMITER $$
USE `cs5200_fall2019_voleti`$$
CREATE DEFINER = CURRENT_USER TRIGGER `cs5200_fall2019_voleti`.`website_role_AFTER_DELETE` AFTER DELETE ON `website_role` FOR EACH ROW
BEGIN
IF OLD.role like 'owner' THEN
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'create';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'read';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'update';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'delete';
END IF;

IF OLD.role like 'admin' THEN
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'create';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'read';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'update';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'delete';
END IF;

IF OLD.role like 'writer' THEN
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'create';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'read';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'update';
END IF;

IF OLD.role like 'editor' THEN
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'read';
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'update';
END IF;

IF OLD.role like 'reviewer' THEN
DELETE FROM website_priviledge where developer = OLD.developer AND website = OLD.website AND priviledge = 'read';
END IF;
END$$
DELIMITER ;
