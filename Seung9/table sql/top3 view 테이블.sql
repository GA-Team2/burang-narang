
--wtopview, mtopview
CREATE OR REPLACE VIEW MtopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     , L.m_gender
     from(select * from likeinfo where m_gender=2) L, planinfo P
     where P.p_rownum = L.p_rownum
     order by p.p_like desc;

--allview
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


--boardview
CREATE OR REPLACE VIEW boardView 
as
select p_rownum,
       p_title,
       t_namelist,
       p_regdate,
       p_like
from planinfo;





select 
    p.p_rownum,
    p.p_title,
    p.t_namelist,
    p.p_like,
    to_char(sysdate,'yyyy')-m.m_birthyear age   
from memberinfo m, planinfo p
where m.m_nickname = p.m_nickname;