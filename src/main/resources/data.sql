
INSERT into UsersTable(username,password,email,enabled) values ('user','{noop}user','user@gmail.com',true);
INSERT into UsersTable(username,password,email,enabled) values ('admin','{noop}admin','admin@gmail.com',true);

INSERT into authorities values ('user','USER');
INSERT into authorities values ('admin','ADMIN');