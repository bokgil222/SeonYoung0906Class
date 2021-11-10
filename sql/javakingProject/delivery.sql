/* 배달정보 */
DROP TABLE delivery 
	CASCADE CONSTRAINTS;

/* 배달정보 */
CREATE TABLE delivery (
	adressnum NUMBER(6) NOT NULL, /* 주소번호 */
	dname VARCHAR(50) NOT NULL, /* 이름 */
	daddr VARCHAR2(60) NOT NULL, /* 주소 */
	dphn VARCHAR(30) NOT NULL /* 전화번호 */
);

insert into delivery values (1, '김영희', '주소길이 어디까지 되는지 테스트 1', '010-1234-1111');
insert into delivery values (2, '김철수', '주소길이 어디까지 되는지 테스트 22', '010-1234-2222');
insert into delivery values (3, '김비트', '주소길이 어디까지 되는지 테스트 333', '0107-123455-333333');
insert into delivery values (4, '김복길', '주소길이 어디까지 되는지 테스트 4444', '010-1234-44444');
insert into delivery values (2, '김철수', '주소길이 어디까지 되는지 테스트중입니다.', '010-12345-555555');
insert into delivery values (2, '김철수', '주소길이 어디까지 되는지 테스트 22', '010-1234-2222');
insert into delivery values (6, '김철수', '주소길이 어디까지 되는지 테스트중입니다몇동', '010-1234-2222');

delete from delivery;
select * from delivery;
