create database zj_decoraction;

use zj_decoraction;

create table user(
	id int UNSIGNED not null auto_increment  primary key ,
	username nvarchar(255) not null unique,
	password char(16) not null ,
	phoneNumber char(11) not null unique 
);
alter table user add column headImageUrl varchar(255) COMMENT'头像地址' ;


create table goodsType(
	id int UNSIGNED not null auto_increment primary key ,
	name nvarchar(255) not null unique
);


create table goodsTypeAttribute(
	id int UNSIGNED not null auto_increment primary key ,
	goodsTypeId int UNSIGNED not null,
	name nvarchar(255) not null comment '属性名称',
	inputMode int UNSIGNED not null,
	value nvarchar(255) ,
	selectMode int UNSIGNED not null
);

create table goodsCategory(
	id int UNSIGNED not null auto_increment primary key,
	categoryName nvarchar(255) not null,
	parentCategoryId INT UNSIGNED not null DEFAULT(0)

);



