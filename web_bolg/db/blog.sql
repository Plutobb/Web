DROP DATABASE IF EXISTS blogdemo;
CREATE DATABASE blogdemo DEFAULT CHARSET utf8mb4;

USE blogdemo;

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id          int PRIMARY KEY AUTO_INCREMENT,
    name        varchar(20),
    create_time timestamp
);

DROP TABLE IF EXISTS article;
CREATE TABLE article
(
    id          int PRIMARY KEY AUTO_INCREMENT,
    title       varchar(50) NOT NULL,
    content     mediumtext  NOT NULL,
    user_id     int,
    create_time timestamp,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

insert into user(name, create_time) VALUES ('abc', CURRENT_TIMESTAMP);

insert into article(title, content, user_id, create_time) VALUES ('标题1', '内容1', 1, CURRENT_TIMESTAMP);
insert into article(title, content, user_id, create_time) VALUES ('标题2', '内容2', 1, CURRENT_TIMESTAMP);
insert into article(title, content, user_id, create_time) VALUES ('标题3', '内容3', 1, CURRENT_TIMESTAMP);