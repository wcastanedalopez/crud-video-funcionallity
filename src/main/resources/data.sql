

INSERT INTO role (description, name) VALUES ('Admin role', 'ADMIN');
INSERT INTO role (description, name) VALUES ('Manager role', 'MANAGER');
INSERT INTO role (description, name) VALUES ('User role', 'USER');

INSERT INTO employees(name, last_name, cc, username, email, password) values ('Reycler', 'Iguaran', 1118802345 ,'riguaran', 'riguaranlopez@gmail.com', '1986');


INSERT INTO employed_roles(employed_id, role_id) values (1118802345, 1);
INSERT INTO employed_roles(employed_id, role_id) values (1118802345, 2);

--DELETE FROM role WHERE id = 8 OR id = 9;



