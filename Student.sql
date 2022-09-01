CREATE DATABASE studentdb; 

USE studentdb;

CREATE TABLE student(
id int auto_increment not null primary key,
name varchar(50) not null,
age int not null,
sex varchar(20) not null,
birth varchar(50) not null,
address varchar(50) not null,
tel varchar(50) not null,
mail varchar(50) not null
);

show columns from student,
