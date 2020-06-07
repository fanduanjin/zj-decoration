create database jd_decoraction;

use jd_decoraction;

create table user(
	id int UNSIGNED not null auto_increment  primary key ,
	username nvarchar(255) not null unique,
	password char(16) not null ,
	phoneNumber char(11) not null unique 
);
alter table user add column headImageUrl varchar(255) COMMENT'头像地址' ;



select * from user

insert user values(DEFAULT,'test','pass','13020254093');





