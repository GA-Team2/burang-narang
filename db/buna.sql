select * from accommodation;

select * from planinfo;

insert into planinfo values(1, 'hi', 'title', sysdate, sysdate+1,
                        'tag', sysdate, 0);

select * from v$version;

commit;

select * from spotdetail;

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


