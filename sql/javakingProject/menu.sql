/* 메뉴 */
DROP TABLE menu 
	CASCADE CONSTRAINTS;

/* 메뉴 */
CREATE TABLE menu (
	mid NUMBER(6) CONSTRAINT mid_pk PRIMARY KEY NOT NULL, /* 메뉴번호 */
	mname VARCHAR(50) NOT NULL, /* 메뉴명 */
	mprice INTEGER NOT NULL, /* 메뉴가격 */
	mtype VARCHAR2(10) NOT NULL /* 메뉴종류 */
);
insert into menu values (1, '불고기버거', 3500, 10);
insert into menu values (2, '상하이버거', 4000, 10);
insert into menu values (3, '후렌치후라이', 2000, 20);
insert into menu values (4, '치즈볼', 3000, 20);
insert into menu values (5, '콜라', 1000, 30);
insert into menu values (6, '사이다', 1000, 30);
insert into menu values (7, '환타', 1000, 30);
insert into menu values (8, '아이스크림', 1000, 40);
insert into menu values (9, '쉐이크', 1000, 40);

select * from menu;
