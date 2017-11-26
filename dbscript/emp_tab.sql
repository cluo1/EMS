--drop table emp
create table emp
(
	id integer  not null auto_increment,
	name varchar(50),
	sal decimal(24,6),
	age int,
	primary key (id)
)