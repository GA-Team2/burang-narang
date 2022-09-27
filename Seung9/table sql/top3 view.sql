--boardview
CREATE OR REPLACE VIEW boardView 
as
select p_rownum,
       p_title,
       t_namelist,
       p_regdate,
       p_like,
       p_public
from planinfo
where p_public = 1;

--mtopview
CREATE OR REPLACE VIEW MtopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     , L.m_gender
     , p.p_public
     from(select * from likeinfo where m_gender=1) L, planinfo P
     where P.p_rownum = L.p_rownum
     and p_public = 1
     order by p.p_like desc;

--wtopview
CREATE OR REPLACE VIEW WtopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     , L.m_gender
     , p.p_public
     from(select * from likeinfo where m_gender=2) L, planinfo P
     where P.p_rownum = L.p_rownum
     and p_public = 1
     order by p.p_like desc;

--allview
CREATE OR REPLACE VIEW alltopView 
as
select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     , L.m_gender
     , p.p_public
     from(select * from likeinfo) L, planinfo P
     where P.p_rownum = L.p_rownum
     and p_public = 1
     order by p.p_like desc;

-- ~20대 top3
CREATE OR REPLACE VIEW topView20
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like,
    L.m_agerange,
    p.p_public
from likeinfo L, planinfo P
where P.p_rownum = L.p_rownum
and L.m_agerange between 1 and 2
and p_public = 1
order by P.p_like desc;

--30대 top3
CREATE OR REPLACE VIEW topView30
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like,
    L.m_agerange,
    p_public
from likeinfo L, planinfo P
where P.p_rownum = L.p_rownum
and L.m_agerange = 3
and p_public = 1
order by P.p_like desc;

--40대 top3
CREATE OR REPLACE VIEW topView40
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like,
    L.m_agerange,
    p_public
from likeinfo L, planinfo P
where P.p_rownum = L.p_rownum
and L.m_agerange = 4
and p_public = 1
order by P.p_like desc;

--50~대 top3
CREATE OR REPLACE VIEW topView50
as
select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like,
    L.m_agerange,
    p_public
from likeinfo L, planinfo P
where P.p_rownum = L.p_rownum
and L.m_agerange between 5 and 20
and p_public = 1
order by P.p_like desc;