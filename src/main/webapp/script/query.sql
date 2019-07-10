select * from member;
select * from memberfile;
delete MEMBERFILE where num=5


select * from member, memberfile
where member.id = MEMBERFILE.id;

select * from member
join memberfile
using (id)

select M.id,M.name, F.fname 
  	from member M inner join memberfile F
  	on (M.id = F.id)
  	where M.id ='jh' and M.pw = 'jh'
  	
select * from notice;

select N.*, F.*
	from notice N inner join MEMBERFILE F
	on(N.id = F.id)
	where N.id ='jh' 