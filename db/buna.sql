select * from accommodation;

select * from planinfo;

insert into planinfo values(1, 'hi', 'title', sysdate, sysdate+1,
                        'tag', sysdate, 0);

select * from v$version;

commit;

select * from spotdetail;
select * from planinfo;
select * from plandetail;

insert into spotdetail values('re01', 'restaurnt01');
insert into spotdetail values('re02', 'restaurnt02');
insert into spotdetail values('re03', 'restaurnt03');
insert into spotdetail values('re04', 'restaurnt04');
insert into spotdetail values('re05', 'restaurnt05');

insert into spotdetail values('ac01', 'accommodation01');
insert into spotdetail values('ac02', 'accommodation02');
insert into spotdetail values('ac03', 'accommodation03');
insert into spotdetail values('ac04', 'accommodation04');
insert into spotdetail values('ac05', 'accommodation05');

insert into spotdetail values('ev01','event01');
insert into spotdetail values('ev02','event02');
insert into spotdetail values('ev03','event03');
insert into spotdetail values('ev04','event04');
insert into spotdetail values('ev05','event05');

select * from restaurant;
insert into restaurant values('re05', 'restaurant',
                        'restaurnt05', 'reLocation05',
                        sysdate, sysdate+1, 'reImg05');

select * from accommodation;
insert into accommodation values('ac05', 'accommodation',
                            'accommodation05', 'accLocation05',
                            sysdate, sysdate+1, 'accImg05');

select * from event;
insert into event values('ev05', 'event05',
                        'evLocation05', sysdate, sysdate+1,
                        'evImg05', 'evURL05');

-- like 테이블 임의 작성
create table likeinfo (
	p_rownum	number(10)	NOT NULL,
	m_nick	VARCHAR2(50)	NOT NULL,
	l_age	NUMBER(4)	NOT NULL,
	m_gender	NUMBER(1)	NOT NULL
);
commit;
-- gender 0: 여자 1: 남자
drop table likeoverlap;

select rank() over(order by p_rownum)
    , p_rownum
    from likeoverlap;
select dense_rank() over(order by count(p_rownum)) from likeoverlap;
select min(p_rownum) from likeoverlap;

select count(p_rownum)
        , p_rownum
        from likeoverlap
    group by p_rownum
order by count(p_rownum) desc;

select * from likeoverlap;
select * from likeoverlap order by p_rownum;
select count(p_rownum),  p_rownum from likeinfo 
    group by p_rownum, m_gender
    having m_gender=1
order by count(p_rownum) desc;

select count(row_num), age, row_num from like_over 
    group by row_num, age
    having age=2
order by count(row_num) desc;

insert into likeoverlap values(3, '닉네임', 2, 0);
insert into likeoverlap values(1, '닉네임', 2, 1);



-- 결과 확인
select * from planInfo;
select * from taglist;
select * from plandetail;

drop table plandetail;
drop table planinfo;
drop table taglist;

select t_name from taglist where t_name = '#가을';