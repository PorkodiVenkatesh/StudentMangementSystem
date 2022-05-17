create database school;



create table student ( id int primary key, name varchar(30), class int, city varchar(30));

insert into student values (1, "porkodi", 12 , "chennai"), (2, "Aishwarya", 10, "nagpur"), (3, "nikhil", 12, "chennai"),
(4, "Rohit", 12, "Pune"), (5, "Sayali", 10, "chennai");

use school;
select * from student where id = 5;

insert into student values (9, "amit", 12 , "chennai");

