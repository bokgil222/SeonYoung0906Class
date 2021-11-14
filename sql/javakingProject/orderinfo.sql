
/* 주문정보 */
DROP TABLE orderinfo
	CASCADE CONSTRAINTS;

/* 주문정보 */
CREATE TABLE orderinfo (
	oid NUMBER(6) NOT NULL, /* 주문번호 */
	oprice INTEGER NOT NULL, /* 주문금액 */
	odate TIMESTAMP NOT NULL, /* 주문일자 */
	payment VARCHAR2(2) NOT NULL, /* 결제수단 */
	otype VARCHAR2(3) NOT NULL, /* 회원타입 */
	id NUMBER(6), /* 회원번호 */
	mid NUMBER(6) NOT NULL, /* 메뉴번호 */
	adressnum NUMBER(6) NOT NULL /* 주소번호 */
);

delete from delivery;    
select * from delivery;
COMMIT;

