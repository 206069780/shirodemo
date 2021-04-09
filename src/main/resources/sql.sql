USE DB_shiro;

DROP TABLE IF EXISTS user_table;

CREATE TABLE user_table(
                           id int AUTO_INCREMENT PRIMARY KEY ,
                           usernmae varchar(255) ,
                           passwd varchar(225),
                           perms varchar(225),
                           role varchar(225)
);

insert user_table(usernmae, passwd, perms, role) VALUES ('root','root','root','root'),('admin','admin','admin','admin')