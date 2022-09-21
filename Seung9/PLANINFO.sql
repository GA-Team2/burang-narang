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

select * from memberinfo;
select * from planinfo;

INSERT INTO PLANINFO VALUES(5, 'aaaa', '절거운 부산 여행', '2022-08-11', '2022-08-13', '#바다 #해운대 #조개구이 #먹고싶다', sysdate, '1',1);
INSERT INTO PLANINFO VALUES(4, 'bbbb', '행복한 부산 여행', '2022-11-10', '2022-11-10', '#어쩌구 #저쩌구 #맛집 #숙소 #카페', sysdate, '20',1);
INSERT INTO PLANINFO VALUES(1, 'cccc', '절거운 부산 여행', '2022-08-11', '2022-08-13', '#바다 #해운대 #조개구이 #먹고싶다', sysdate, '10',1);
INSERT INTO PLANINFO VALUES(2, 'dddd', '행복한 부산 여행', '2022-11-10', '2022-11-10', '#어쩌구 #저쩌구 #맛집 #숙소 #카페', sysdate, '20',1);
INSERT INTO PLANINFO VALUES(3, 'eeee', '재밌는 부산 여행', '2022-11-22', '2022-11-24', '#부산 #산 #바다', sysdate, '30',2);
INSERT INTO PLANINFO VALUES(7, 'ffff', '절거운 부산 여행', '2022-08-11', '2022-08-13', '#바다 #해운대 #조개구이 #먹고싶다', sysdate, '5',2);
INSERT INTO PLANINFO VALUES(8, 'gggg', '오금저리는 부산 여행', '2022-12-10', '2022-11-10', '#어쩌구맛집 #숙소 #카페', sysdate, '90',2);
INSERT INTO PLANINFO VALUES(9, 'hhhh', '아찔한 부산 여행', '2022-10-22', '2022-11-24', '#부산 #산 #강 바다', sysdate, '44',2);
INSERT INTO PLANINFO VALUES(10, 'iiii', '기분좋은 부산 여행', '2022-05-22', '2022-09-24', '#부산 #밥 #국 #빵', sysdate, '32',2);
INSERT INTO PLANINFO VALUES(11, 'jjjj', '무서운 부산 여행', '2022-07-22', '2022-11-24', '#부산 #라면 #김밥 #떡볶이', sysdate, '25',2);
INSERT INTO PLANINFO VALUES(12, 'kkkk', '부산 여행', '2022-07-22', '2022-11-24', '#부산 #라면 #김밥 #떡볶이', sysdate, '25',2);