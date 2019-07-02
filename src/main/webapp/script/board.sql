create table files(
	fnum number(8) constraint files_fnum_pk primary key,
	num number(8) not null,
	fname varchar2(2000),
	oname varchar2(2000)
)
select * from files