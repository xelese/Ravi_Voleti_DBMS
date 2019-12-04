USE `cs5200_fall2019_voleti`;
CREATE OR REPLACE VIEW `developer_roles_and_privileges` AS
select DISTINCT first_name,
                last_name,
                username,
                email,
                w.name        as website_name,
                w.visits      as website_visits,
                w.updated     as website_last_update,
                wr.role       as website_role,
                wp.priviledge as website_priviledge,
                p.title       as page_title,
                p.views       as page_views,
                p.updated     as page_update,
                pr.role       as page_role,
                pp.priviledge as page_priviledge
from person
         join developer d on person.id = d.id
         join website w on d.id = w.developer
         join page p on w.id = p.website
         join website_role wr on w.id = wr.website
         join website_priviledge wp on w.id = wp.website
         join page_role pr on p.id = pr.page
         join page_priviledge pp on p.id = pp.page;
