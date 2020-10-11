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
	goodsTypeId int UNSIGNED ,
	name nvarchar(255) not null comment '属性名称',
	inputMode int UNSIGNED not null,
	value nvarchar(255) ,
	selectMode int UNSIGNED not null
);





select * from goodsTypeAttribute


insert goodsType values(DEFAULT,'T恤');
select * from goodsType
insert  goodsType          ( id,name )         values(default,'fdfsd');





select * from user
where phoneNumber like '%1336180%'

select count(*) from user;

insert user values(DEFAULT,'43434','sdf33f44','13758755633',null);

select id,username,password,phoneNumber from user LIMIT 1,2



