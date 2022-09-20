CREATE TABLE board (
	b_ROWNUM	NUMBER		NOT NULL,
	b_TITLE	VARCHAR2(255)		NOT NULL,
    b_HASHNAME	VARCHAR2(30)		NOT NULL,
	b_HASHHIT	NUMBER		NOT NULL,
	b_REGDATE	DATE		NOT NULL,
	b_LIKE	NUMBER		NOT NULL
);


select b.*
from (select * from board order by b_like desc) b
where rownum<=3;

select * from board order by b_like;

select 
    * 
from board
order by b_like desc;

select * from board;

commit;

drop table board;

select * from board order by b_rownum desc;

insert into board values(6,'333333123ddd','#����',35,'2022-09-10',6);
insert into board values(7,'33333cccddd','#��ddd��',35,'2022-09-10',7);
insert into board values(8,'33333ddd','#����',35,'2022-09-10',8);
insert into board values(9,'33333dvvsdd','#��ddd��',35,'2022-09-10',9);
insert into board values(10,'33333ddd','#����ddd',35,'2022-09-10',10);
insert into board values(11,'333da33ddd','#����',35,'2022-09-10',11);
insert into board values(12,'33333ffddd','#��asdf��',35,'2022-09-10',12);
insert into board values(13,'33333ddd','#����',35,'2022-09-10',13);
insert into board values(14,'3333da3ddd','#��asdf��',35,'2022-09-10',14);
insert into board values(15,'33333ddd','#����',35,'2022-09-10',15);
insert into board values(16,'3333dasf3ddd','#����',35,'2022-09-10',16);
insert into board values(17,'33333ddd','#��asdf��',35,'2022-09-10',17);

