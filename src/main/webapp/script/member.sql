select * from files;

create table member(
	id varchar2(600),
	pw varchar2(600) not null,
	name varchar2(600) not null,
	email varchar2(1000) not null,
	grade number(8) default '3',
	constraint member_id_pk primary key (id)
)

create table memberfile(
	num number(8),
	id varchar2(600),
	fname varchar2(1000) not null,
	oname varchar2(1000) not null,
	constraint memberfile_num_pk primary key (num)
)

	constraint memberfile_id_fk foreign key (id) references member (id) on delete cascade
drop table memberfile