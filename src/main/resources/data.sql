insert into BLOGGER (id,age,name) VALUES (1,52, 'Sanko');
insert into BLOGGER (id,age,name) VALUES (2,77, 'Marikanéni');
insert into BLOGGER (id,age,name) VALUES (3,65, 'Sanyibá');
insert into STORY (id, content, title, posted, blogger_id) VALUES (1,'várgokat kell ültetni Sanyibánál', 'virág ültetés story', '2025-01-20', (select id From BLOGGER where name = 'Sanko'));
insert into STORY (id, content, title, posted, blogger_id) VALUES (2,'várgokat kell ültetni Sanyibánál2', 'virág ültetés story', '2025-01-20', (select id From BLOGGER where name = 'Sanko'));
insert into STORY (id, content, title, posted, blogger_id) VALUES (3,'igyunk egyet fajinul a végén', 'virág ültetés story', '2025-01-20', (select id From BLOGGER where name = 'Sanyibá'));
insert into STORY (id, content, title, posted, blogger_id) VALUES (4,'meg az elején is', 'virág ültetés story', CURRENT_DATE(), (select id From BLOGGER where name = 'Sanyibá'));
insert into STORY (id, content, title, posted, blogger_id) VALUES (5,'welcome', 'welcome', CURRENT_DATE(), (select id From BLOGGER where name = 'Sanyibá'));