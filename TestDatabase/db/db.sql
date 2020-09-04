drop database if exists order_systeam;
create database order_systeam character set utf8mb4;

use order_systeam;

Create table Customer
( Cnum int auto_increment PRIMARY KEY,
  Cname char(10),
  Ctel char (10),
  Caddr char(20),
  Ccom char(20)
);

Create table Goods
(
 Goodnum int auto_increment primary key,
  Goodname char(10),
  Goodprice int,
  Goodstore int


);




Create table Bill
( Billnum int auto_increment primary key,
  Cnum int ,
  Listnum int ,
  PayMethod char(10),
  Foreign key (Cnum) references Customer(Cnum)
);

Create table List
(
    Listnum   int auto_increment primary key,
    Billnum int,
    Cnum int,
    foreign key (Billnum) references Bill(Billnum),
    foreign key (Cnum) references Customer(Cnum)
);

Create table GoodsList
(
    GoodsListnum int auto_increment PRIMARY KEY,
    Goodnum int,
    BuyNum int,
    ListNum int,
    total int,
    foreign key (Goodnum) references Goods(Goodnum),
    foreign key (ListNum) references List(Listnum)
);


insert into customer(cname, ctel, caddr, ccom) values ('张洪宝','123456','西安','西安工程大学');
insert into bill(cnum, listnum,  paymethod) values (01,01,'支付宝');
insert into goods(goodname, goodprice, goodstore) values ('牙膏',10,100);

insert into customer(cname, ctel, caddr, ccom) values ('唐科','123456','西安','西安工程大学');
insert into bill values (02,02,02,'支付宝');
insert into goods values (02,'牙刷',15,100);

insert into List(Billnum, Cnum) VALUES (01,01);
insert into goodslist(goodnum, buynum,ListNum) VALUES (01,2,1);

insert into List(Billnum, Cnum) VALUES (02,01);
insert into goodslist(goodnum, buynum,ListNum) VALUES (02,2,1);






