--boardview
CREATE OR REPLACE VIEW boardView 
as
select p_rownum,
       p_title,
       t_namelist,
       p_regdate,
       p_like
from planinfo
where p_public = 1;

--mtopview
CREATE OR REPLACE VIEW MtopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     from(select * from memberinfo where m_gender=0) M, planinfo P
     where P.m_nickname = m.m_nickname
     and p_public = 1
     order by p.p_like desc;

--wtopview
CREATE OR REPLACE VIEW WtopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     from(select * from memberinfo where m_gender=1) M, planinfo P
     where P.m_nickname = m.m_nickname
     and p_public = 1
     order by p.p_like desc;

--allview  
CREATE OR REPLACE VIEW alltopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     from(select * from memberinfo) M, planinfo P
     where P.m_nickname = m.m_nickname
     and p_public = 1
     order by p.p_like desc;

-- ~20대 top3
CREATE OR REPLACE VIEW topView20
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 1 and 29
and p_public = 1
order by P.p_like desc;

--30대 top3
CREATE OR REPLACE VIEW topView30
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 30 and 39
and p_public = 1
order by P.p_like desc;

--40대 top3
CREATE OR REPLACE VIEW topView40
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 40 and 49
and p_public = 1
order by P.p_like desc;

--50~대 top3
CREATE OR REPLACE VIEW topView50
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 50 and 200
and p_public = 1
order by P.p_like desc;