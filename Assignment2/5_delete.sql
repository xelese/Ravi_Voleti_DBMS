USE cs5200_fall2019_voleti;
DELETE
FROM address
WHERE address.primary = '1'
  AND person = 12;

USE cs5200_fall2019_voleti;
DELETE
FROM widget
WHERE `order` = (select max(`order`))
  AND page = 345;

USE cs5200_fall2019_voleti;
delete
from page
where updated = (select max(updated))
  and website = 345;

set SQL_SAFE_UPDATES  = 0;
USE cs5200_fall2019_voleti;
delete w.*, wr.*
from website w
         JOIN website_role wr on w.id = wr.website
where w.name = 'CNET';