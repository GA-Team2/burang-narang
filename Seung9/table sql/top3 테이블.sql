select count(p_rownum)
        , p_rownum
        from likeinfo
    group by p_rownum
order by count(p_rownum) desc;

Select count(p_rownum),  p_rownum from likeinfo 
    group by p_rownum, m_gender
    having m_gender=1
Order by count(p_rownum) desc;

select count(p_rownum), p_rownum from likeinfo 
    group by p_rownum, m_agerange
    having m_agerange=23
order by count(p_rownum) desc;


select * from likeinfo where m_gender=1;

select * from mtopview where rownum <=3;

select * from alltopview where rownum <=3;

SELECT B.* FROM (SELECT * FROM BOARDVIEW
			        ORDER BY P_LIKE DESC) B WHERE ROWNUM <= 3;

CREATE OR REPLACE VIEW WtopView 
as;
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     , L.m_gender
     from(select * from likeinfo where m_gender=2) L, planinfo P
     where P.p_rownum = L.p_rownum
     order by p.p_like desc;




CREATE OR REPLACE VIEW alltopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     , L.m_gender
     from(select * from likeinfo) L, planinfo P
     where P.p_rownum = L.p_rownum
     order by p.p_like desc;

select to_char(sysdate,'yyyy')-2020 from dual;

select * from memberinfo;

select 
    p.p_rownum,
    p.p_title,
    p.t_namelist,
    p.p_like,
    to_char(sysdate,'yyyy')-m.m_birthyear age   
from memberinfo m, planinfo p
where m.m_nickname = p.m_nickname;