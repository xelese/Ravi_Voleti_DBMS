USE cs5200_fall2019_voleti;
select *
from person
         join developer d on person.id = d.id;

USE cs5200_fall2019_voleti;
select *
from person
         join developer d on person.id = d.id
where person.id = 34;

USE cs5200_fall2019_voleti;
select first_name
from developer
         join person p on developer.id = p.id
         join website_role wr on developer.id = wr.developer
where website = (select id from website where name = 'Twitter' and role not like 'owner');

USE cs5200_fall2019_voleti;
select username
from developer
         join person p on developer.id = p.id
         join page_role pr on developer.id = pr.developer
         join page p2 on pr.page = p2.id
where views < 300000
  and role = 'reviewer';

USE cs5200_fall2019_voleti;
select first_name
from person
where person.id = (select page_role.developer
                   from page_role
                            join page p on page_role.page = p.id
                            join website w on p.website = w.id
                            join widget w2 on p.id = w2.page
                   where role = 'writer'
                     and w.name = 'CNET'
                     and dtype = 'heading');








USE cs5200_fall2019_voleti;
select MIN(visits)
from website;

USE cs5200_fall2019_voleti;
select name
from website
where id = 678;

USE cs5200_fall2019_voleti;
select name
from website
where website.id = (select website
                    from page
                    where page.id = (select page
                                     from page_role
                                     where role = 'reviewer'
                                       and page_role.developer = 23
                                       and page = (select widget.page from widget where dtype = 'youtube'))
);

USE cs5200_fall2019_voleti;
select name
from website
         join website_role wr on website.id = wr.website
where role = 'owner'
  and wr.developer = 12;

USE cs5200_fall2019_voleti;
select name
from website
         join website_role wr on website.id = wr.website
where role = 'admin'
  and wr.developer = '34'
  and visits > 6000000;






USE cs5200_fall2019_voleti;
SELECT title
FROM page
WHERE (SELECT MAX(views) FROM page);

USE cs5200_fall2019_voleti;
SELECT title
FROM page
WHERE id = 234;

USE cs5200_fall2019_voleti;
SELECT title
FROM page
         join website w on page.website = w.id
         join website_role wr on w.id = wr.website
where wr.role = 'editor'
  and wr.developer = 12;

USE cs5200_fall2019_voleti;
SELECT SUM(views) as total_numer_of_views
FROM page
WHERE website = 567;

USE cs5200_fall2019_voleti;
SELECT avg(views) as average_number_of_views
FROM page
where website = 345;












USE cs5200_fall2019_voleti;
SELECT name FROM widget w
JOIN page p
ON p.id = page
WHERE p.id = 123 and p.website = 567;

USE cs5200_fall2019_voleti;
SELECT name FROM widget w
JOIN page p ON w.page = p.id
WHERE dtype = 'youtube' AND p.website = 456;

USE cs5200_fall2019_voleti;
SELECT name FROM widget w
JOIN page p ON w.page = p.id
JOIN page_role pr ON p.id = pr.page
WHERE w.dtype = 'image'
and pr.role = 'reviewer'
and pr.developer = 12;

USE cs5200_fall2019_voleti;
SELECT count(w.id) FROM widget w
JOIN page p
ON w.page = p.id
WHERE p.website = 345;










SELECT name FROM website w
JOIN website_priviledge wp
ON w.id = wp.website
WHERE priviledge = 'delete'
AND wp.developer = 23;

SELECT title FROM page p
INNER JOIN page_priviledge pp
ON p.id = pp.page
WHERE priviledge = 'create'
AND pp.developer = 34;
