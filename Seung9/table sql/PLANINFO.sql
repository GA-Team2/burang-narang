select * from memberinfo;
select * from planinfo_test;

select *
  from planinfo_test
 where rownum<=3
order by p_rownum, p_like desc;


CREATE TABLE PLANINFO (
	P_ROWNUM	NUMBER	NOT NULL,
	M_NICKNAME	VARCHAR2(18)	NOT NULL,
	P_TITLE	VARCHAR2(255)	NOT NULL,
	P_FIRSTDATE	DATE	NOT NULL,
	P_LASTDATE	DATE	NOT NULL,
	T_NAMELIST	VARCHAR2(255)	NULL,
	P_REGDATE	DATE	NOT NULL,
	P_LIKE	NUMBER	NOT NULL
);

--view 테이블
CREATE OR REPLACE VIEW boardView 
AS
    SELECT p_rownum
         , p_title
         , t_namelist
         , p_regdate
         , p_like
      FROM planinfo
;

select * from boardView order by p_rownum asc;
select * from boardview order by p_like desc;
select * from boardView;

select b.*
from (select * from boardview order by p_like desc) b
where rownum<=3;

SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,
        P_REGDATE, P_LIKE FROM BOARDVIEW
        ORDER BY P_ROWNUM DESC;

SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,
        P_REGDATE, P_LIKE FROM BOARDVIEW
        ORDER BY P_LIKE DESC;

SELECT COUNT(P_ROWNUM) FROM BOARDVIEW;

select count(p_rownum) from boardview;

commit;
delete planinfo_test where p_rownum=4;
rollback;
INSERT INTO PLANINFO VALUES(5, 'gk', '절거운 부산 여행', '2022-08-11', '2022-08-13', '#바다 #해운대 #조개구이 #먹고싶다', sysdate, '1');
INSERT INTO PLANINFO VALUES(4, 'gk', '행복한 부산 여행', '2022-11-10', '2022-11-10', '#어쩌구 #저쩌구 #맛집 #숙소 #카페', sysdate, '20');
INSERT INTO PLANINFO VALUES(1, 'gk', '절거운 부산 여행', '2022-08-11', '2022-08-13', '#바다 #해운대 #조개구이 #먹고싶다', sysdate, '10');
INSERT INTO PLANINFO VALUES(2, 'gk', '행복한 부산 여행', '2022-11-10', '2022-11-10', '#어쩌구 #저쩌구 #맛집 #숙소 #카페', sysdate, '20');
INSERT INTO PLANINFO VALUES(3, '하', '재밌는 부산 여행', '2022-11-22', '2022-11-24', '#부산 #산 #바다', sysdate, '30');
INSERT INTO PLANINFO VALUES(7, 'gk', '절거운 부산 여행', '2022-08-11', '2022-08-13', '#바다 #해운대 #조개구이 #먹고싶다', sysdate, '5');
INSERT INTO PLANINFO VALUES(8, 'gk', '오금저리는 부산 여행', '2022-12-10', '2022-11-10', '#어쩌구맛집 #숙소 #카페', sysdate, '90');
INSERT INTO PLANINFO VALUES(9, '하', '아찔한 부산 여행', '2022-10-22', '2022-11-24', '#부산 #바다', sysdate, '50');