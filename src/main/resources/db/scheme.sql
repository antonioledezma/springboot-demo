-- initial schema.
create database if not exists data;
use data;

drop table if exists note;
create table note(
	id bigint(20) primary key not null auto_increment,
	title varchar(128),
	text varchar(1024),
	folder_id bigint(20)
);

drop table if exists folder;
create table folder(
	id bigint(20) primary key not null auto_increment,
	title varchar(128)
);