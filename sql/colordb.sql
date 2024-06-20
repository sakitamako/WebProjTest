drop database if exists colordb;
create database colordb;
use colordb;

create table color(
color_id int primary key auto_increment,
color_name varchar(255),
color_number varchar(255));

insert into color values(1,"red","000");
insert into color values(2,"blue","111");
insert into color values(3,"white","222");

create table inquiry(
name varchar(255),
qtype varchar(255),
body varchar(255));
