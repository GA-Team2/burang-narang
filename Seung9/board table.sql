CREATE TABLE board (
	b_ROWNUM	NUMBER		NOT NULL,
	b_TITLE	VARCHAR2(255)		NOT NULL,
    b_HASHNAME	VARCHAR2(30)		NOT NULL,
	b_HASHHIT	NUMBER		NOT NULL,
	b_REGDATE	DATE		NOT NULL,
	b_LIKE	NUMBER		NOT NULL
);


select count(b_rownum) from board;


select * from board;

select * from board;

commit;

drop table board;

insert into board values(55,'�ٴٺ������ٴ�','#�ٴ� #����',35,'2022-09-10',5);

