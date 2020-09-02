drop database if exists order_systeam;
create database order_systeam character set utf8mb4;

use order_systeam;

Create table Customer
( Cnum smallint primary key,
  Cname char(7),
  Ctel char (10),
  Caddr char(20),
  Ccom char(20),
  Listnum char(10)
);

Create table Goods
( Goodnum int primary key,
  Goodname char(10),
  Goodprice char(10),
  Goodstore char (10)
);


Create table Bill
( Billnum smallint primary key,
  Cnum smallint,
  Paynum char(10),
  PayMethod char(5),
  Foreign key (Cnum) references Customer(Cnum)
);

Create table List
(
    Listnum   smallint primary key,
    Billnum SMALLINT,
    Cnum smallint,
    Goodnum   int,
    Buynum       char(10),
    foreign key (Cnum) references Customer(Cnum),
    foreign key (Billnum) references Bill(Billnum),
    foreign key (Goodnum) references Goods(Goodnum)
);



insert into customer values (01,'张洪宝','123456','西安','西安工程大学','01');
insert into bill values (01,01,'10元','支付宝');
insert into goods values (01,'牙膏','10元','100');
insert into list values (01,01,01,01,'1');

alter table List add Good2num int;
update list set order_systeam.List.Good2num = 02;

alter table List add BuyGood2num int;
update list set order_systeam.List.BuyGood2num = 1;

