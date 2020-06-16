drop database if exists blogdemo;
create database blogdemo default charset utf8mb4;

use blogdemo;



drop table IF EXISTS user;
create table user(
    id int primary key auto_increment,
    name varchar(20),
    create_time timestamp
);

drop table IF EXISTS article;
create table article(
                        id int primary key auto_increment,
                        title varchar(50) not null,
                        content mediumtext not null,
                        user_id int,
                        create_time timestamp,
                        foreign key(user_id) references user(id)
);

insert into user (name, create_time) VALUES ('亚索',CURRENT_TIMESTAMP);
insert into user (name, create_time) VALUES ('诺手',CURRENT_TIMESTAMP);

insert into article(title, content, user_id, create_time) VALUES ('疾风剑豪','亚索',1,CURRENT_TIMESTAMP);
insert into article(title, content, user_id, create_time) VALUES ('放逐之刃','瑞文',1,CURRENT_TIMESTAMP);
insert into article(title, content, user_id, create_time) VALUES ('诺克萨斯','诺克萨斯之手',2,CURRENT_TIMESTAMP);

