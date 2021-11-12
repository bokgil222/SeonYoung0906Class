/* 메뉴 */
DROP TABLE menu 
	CASCADE CONSTRAINTS;

/* 메뉴 */
CREATE TABLE menu (
	mid NUMBER(6) CONSTRAINT mid_pk PRIMARY KEY NOT NULL, /* 메뉴번호 */
	mname VARCHAR(50) NOT NULL, /* 메뉴명 */
	mprice INTEGER NOT NULL, /* 메뉴가격 */
	mtype number(1) NOT NULL, /* 메뉴종류 */
    mcount INTEGER DEFAULT 1 NOT NULL /* 메뉴수량 */
);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (1, '불고기버거', 3500, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (2, '상하이버거', 4000, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (3, '후렌치후라이', 2000, 2);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (4, '치즈볼', 3000,  2);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (5, '아이스크림', 1000, 2);
insert into menu  (MID, MNAME, MPRICE, MTYPE) values (6, '쉐이크', 1000, 2);
insert into menu (MID, MNAME, MPRICE, MTYPE)values (7, '콜라', 1000, 3);
insert into menu values (8, '사이다', 1000, 3);
insert into menu values (9, '환타', 1000, 3);


select * from menu;
COMMIT;
rollback;
