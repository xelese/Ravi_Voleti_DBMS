INSERT INTO `cs5200_fall2019_voleti`.`person`
(`id`,
`first_name`,
`last_name`,
`username`,
`password`,
`email`,
`dob`)
VALUES
(12,
'Alice',
'Wonder',
'alice',
'alice',
'alice@wonder.com',
null);

INSERT INTO `cs5200_fall2019_voleti`.`person`
(`id`,
`first_name`,
`last_name`,
`username`,
`password`,
`email`,
`dob`)
VALUES
(23,
'Bob',
'Marley',
'bob',
'bob',
'bob@marley.com',
null);

INSERT INTO `cs5200_fall2019_voleti`.`person`
(`id`,
`first_name`,
`last_name`,
`username`,
`password`,
`email`,
`dob`)
VALUES
(34,
'Charles',
'Garcia',
'charlie',
'charlie',
'chuch@garcia.com',
null);

INSERT INTO `cs5200_fall2019_voleti`.`person`
(`id`,
`first_name`,
`last_name`,
`username`,
`password`,
`email`,
`dob`)
VALUES
(45,
'Dan',
'Martin',
'dan',
'dan',
'dan@martin.com',
null);

INSERT INTO `cs5200_fall2019_voleti`.`person`
(`id`,
`first_name`,
`last_name`,
`username`,
`password`,
`email`,
`dob`)
VALUES
(56,
'Ed',
'Karaz',
'ed',
'ed',
'ed@kar.com',
null);

INSERT INTO `cs5200_fall2019_voleti`.`developer`
(`id`,
`developer_key`)
VALUES
(12,
'4321rewq');

INSERT INTO `cs5200_fall2019_voleti`.`developer`
(`id`,
`developer_key`)
VALUES
(23,
'5432trew');

INSERT INTO `cs5200_fall2019_voleti`.`developer`
(`id`,
`developer_key`)
VALUES
(34,
'6543ytre');

INSERT INTO `cs5200_fall2019_voleti`.`user`
(`id`,
`user_agreement`)
VALUES
(45,
null);

INSERT INTO `cs5200_fall2019_voleti`.`user`
(`id`,
`user_agreement`)
VALUES
(56,
null);

INSERT INTO `cs5200_fall2019_voleti`.`website`
(`id`,
`name`,
`description`,
`created`,
`updated`,
`visits`,
`developer`)
VALUES
(123,
'Facebook',
'an online social media and social networking service',
'2019-10-02',
'2019-10-02',
1234234,
12);

INSERT INTO `cs5200_fall2019_voleti`.`website`
(`id`,
`name`,
`description`,
`created`,
`updated`,
`visits`,
`developer`)
VALUES
(234,
'Twitter',
'an online news and social networking service',
'2019-10-02',
'2019-10-02',
4321543,
23);

INSERT INTO `cs5200_fall2019_voleti`.`website`
(`id`,
`name`,
`description`,
`created`,
`updated`,
`visits`,
`developer`)
VALUES
(345,
'Wikipedia',
'a free online encyclopedia',
'2019-10-02',
'2019-10-02',
3456654,
34);

INSERT INTO `cs5200_fall2019_voleti`.`website`
(`id`,
`name`,
`description`,
`created`,
`updated`,
`visits`,
`developer`)
VALUES
(456,
'CNN',
'an American basic cable and satellite television news channel',
'2019-10-02',
'2019-10-02',
6543345,
12);

INSERT INTO `cs5200_fall2019_voleti`.`website`
(`id`,
`name`,
`description`,
`created`,
`updated`,
`visits`,
`developer`)
VALUES
(567,
'CNET',
'an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics',
'2019-10-02',
'2019-10-02',
5433455,
23);

INSERT INTO `cs5200_fall2019_voleti`.`website`
(`id`,
`name`,
`description`,
`created`,
`updated`,
`visits`,
`developer`)
VALUES
(678,
'Gizmodo',
'a design, technology, science and science fiction website that also writes articles on politics',
'2019-10-02',
'2019-10-02',
5433455,
34);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'owner',
12,
123);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'editor',
23,
123);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'admin',
34,
123);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'owner',
23,
234);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'editor',
34,
234);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'admin',
12,
234);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'owner',
34,
345);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'editor',
12,
345);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'admin',
23,
345);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'owner',
12,
456);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'editor',
23,
456);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'admin',
34,
456);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'owner',
23,
567);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'editor',
34,
567);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'admin',
12,
567);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'owner',
34,
678);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'editor',
12,
678);

INSERT INTO `cs5200_fall2019_voleti`.`website_role`
(`id`,
`role`,
`developer`,
`website`)
VALUES
(Null,
'admin',
23,
678);

INSERT INTO `cs5200_fall2019_voleti`.`page`
(`id`,
`title`,
`description`,
`created`,
`updated`,
`views`,
`website`)
VALUES
(123,
'HOME',
'Landing Page',
'2019-09-04',
'2019-10-02',
123434,
567);

INSERT INTO `cs5200_fall2019_voleti`.`page`
(`id`,
`title`,
`description`,
`created`,
`updated`,
`views`,
`website`)
VALUES
(234,
'About',
'Website description',
'2019-09-04',
'2019-10-02',
234545,
678);

INSERT INTO `cs5200_fall2019_voleti`.`page`
(`id`,
`title`,
`description`,
`created`,
`updated`,
`views`,
`website`)
VALUES
(345,
'Contact',
'Addresses, phones, and contact info',
'2019-09-04',
'2019-10-02',
345656,
345);

INSERT INTO `cs5200_fall2019_voleti`.`page`
(`id`,
`title`,
`description`,
`created`,
`updated`,
`views`,
`website`)
VALUES
(456,
'Preferences',
'Where users can configure their preferences',
'2019-09-04',
'2019-10-02',
456776,
456);

INSERT INTO `cs5200_fall2019_voleti`.`page`
(`id`,
`title`,
`description`,
`created`,
`updated`,
`views`,
`website`)
VALUES
(567,
'Profile',
'Users can configure their personal information',
'2019-09-04',
'2019-10-02',
567878,
567);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'editor',
123,
12);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'reviewer',
123,
23);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'writer',
123,
34);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'editor',
234,
23);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'reviewer',
234,
34);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'writer',
234,
12);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'editor',
345,
34);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'reviewer',
345,
12);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'writer',
345,
23);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'editor',
456,
12);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'reviewer',
456,
23);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'writer',
456,
34);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'editor',
567,
23);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'reviewer',
567,
34);

INSERT INTO `cs5200_fall2019_voleti`.`page_role`
(`id`,
`role`,
`page`,
`developer`)
VALUES
(Null,
'writer',
567,
12);

INSERT INTO `cs5200_fall2019_voleti`.`widget`
(`id`,
`name`,
`width`,
`height`,
`css_class`,
`css_style`,
`text`,
`order`,
`youtube_url`,
`youtube_shareble`,
`youtube_expandable`,
`image_source`,
`heading_size`,
`html`,
`page`,
`dtype`)
VALUES
(123,
'head123',
null,
null,
null,
null,
'Welcome',
0,
null,
null,
null,
null,
2,
null,
123,
'heading');

INSERT INTO `cs5200_fall2019_voleti`.`widget`
(`id`,
`name`,
`width`,
`height`,
`css_class`,
`css_style`,
`text`,
`order`,
`youtube_url`,
`youtube_shareble`,
`youtube_expandable`,
`image_source`,
`heading_size`,
`html`,
`page`,
`dtype`)
VALUES
(234,
'post234',
null,
null,
null,
null,
'<p>Lorem</p>',
0,
null,
null,
null,
null,
2,
null,
234,
'html');

INSERT INTO `cs5200_fall2019_voleti`.`widget`
(`id`,
`name`,
`width`,
`height`,
`css_class`,
`css_style`,
`text`,
`order`,
`youtube_url`,
`youtube_shareble`,
`youtube_expandable`,
`image_source`,
`heading_size`,
`html`,
`page`,
`dtype`)
VALUES
(345,
'head345',
null,
null,
null,
null,
'Hi',
1,
null,
null,
null,
null,
2,
null,
345,
'heading');

INSERT INTO `cs5200_fall2019_voleti`.`widget`
(`id`,
`name`,
`width`,
`height`,
`css_class`,
`css_style`,
`text`,
`order`,
`youtube_url`,
`youtube_shareble`,
`youtube_expandable`,
`image_source`,
`heading_size`,
`html`,
`page`,
`dtype`)
VALUES
(456,
'intro456',
null,
null,
null,
null,
'<h1>Hi</h1>',
2,
null,
null,
null,
null,
2,
null,
345,
'html');

INSERT INTO `cs5200_fall2019_voleti`.`widget`
(`id`,
`name`,
`width`,
`height`,
`css_class`,
`css_style`,
`text`,
`order`,
`youtube_url`,
`youtube_shareble`,
`youtube_expandable`,
`image_source`,
`heading_size`,
`html`,
`page`,
`dtype`)
VALUES
(567,
'image345',
50,
100,
null,
null,
null,
3,
null,
null,
null,
'/img/567.png',
2,
null,
345,
'image');

INSERT INTO `cs5200_fall2019_voleti`.`widget`
(`id`,
`name`,
`width`,
`height`,
`css_class`,
`css_style`,
`text`,
`order`,
`youtube_url`,
`youtube_shareble`,
`youtube_expandable`,
`image_source`,
`heading_size`,
`html`,
`page`,
`dtype`)
VALUES
(678,
'video456',
400,
300,
null,
null,
null,
0,
'https://youtu.be/h67VX51QXiQ',
true,
true,
null,
2,
null,
456,
'youtube');

INSERT INTO `cs5200_fall2019_voleti`.`phone`
(`id`,
`phone`,
`primary`,
`person`)
VALUES
(null,
'123-234-3456',
true,
12);

INSERT INTO `cs5200_fall2019_voleti`.`phone`
(`id`,
`phone`,
`primary`,
`person`)
VALUES
(null,
'234-345-4566',
false,
12);

INSERT INTO `cs5200_fall2019_voleti`.`phone`
(`id`,
`phone`,
`primary`,
`person`)
VALUES
(null,
'345-456-5677',
true,
23);

INSERT INTO `cs5200_fall2019_voleti`.`phone`
(`id`,
`phone`,
`primary`,
`person`)
VALUES
(null,
'321-432-5435',
true,
34);

INSERT INTO `cs5200_fall2019_voleti`.`phone`
(`id`,
`phone`,
`primary`,
`person`)
VALUES
(null,
'432-432-5433',
false,
34);

INSERT INTO `cs5200_fall2019_voleti`.`phone`
(`id`,
`phone`,
`primary`,
`person`)
VALUES
(null,
'543-543-6544',
false,
34);

INSERT INTO `cs5200_fall2019_voleti`.`address`
(`id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`,
`person`)
VALUES
(null,
'123 Adam St.',
null,
'Alton',
null,
'01234',
true,
12);

INSERT INTO `cs5200_fall2019_voleti`.`address`
(`id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`,
`person`)
VALUES
(null,
'234 Birch St.',
null,
'Boston',
null,
'02345',
false,
12);




INSERT INTO `cs5200_fall2019_voleti`.`address`
(`id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`,
`person`)
VALUES
(null,
'345 Charles St.',
null,
'Chelms',
null,
'03455',
true,
23);

INSERT INTO `cs5200_fall2019_voleti`.`address`
(`id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`,
`person`)
VALUES
(null,
'456 Down St.',
null,
'Dalton',
null,
'04566',
false,
23);

INSERT INTO `cs5200_fall2019_voleti`.`address`
(`id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`,
`person`)
VALUES
(null,
'543 East St.',
null,
'Everett',
null,
'01112',
false,
23);

INSERT INTO `cs5200_fall2019_voleti`.`address`
(`id`,
`street1`,
`street2`,
`city`,
`state`,
`zip`,
`primary`,
`person`)
VALUES
(null,
'654 Frank St.',
null,
'Foulton',
null,
'04322',
true,
34);
