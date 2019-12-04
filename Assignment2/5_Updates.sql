USE cs5200_fall2019_voleti;
UPDATE phone
SET phone.phone = '333-444-5555'
WHERE phone.primary = '1'
  AND phone.person = 34;


USE cs5200_fall2019_voleti;
UPDATE widget
SET `order` = CASE
                  WHEN `order` = 2 THEN 1
                  WHEN `order` = 3 THEN 2
                  WHEN name = 'head345' THEN 3
                  ELSE `order` END
WHERE page = 345;


USE cs5200_fall2019_voleti;
UPDATE page
SET page.title = CONCAT('CNET - ', title)
WHERE page.website = 567;


USE cs5200_fall2019_voleti;
UPDATE page_role
SET developer = CASE
                    WHEN developer = 23 THEN 34
                    WHEN developer = 34 THEN 23
                    ELSE developer END
WHERE page = 123;
