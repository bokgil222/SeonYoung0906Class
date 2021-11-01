-- 함수: 단일행 함수, 집합 함수

-- 단일행 함수: 숫자, 문자, 날짜, 변환

-- 숫자 함수
select abs(-15.5) from dual;
select FLOOR(35.73) "Floor" FROM DUAL;
select round(15.393) from dual;
select round(15.393, 2) from dual;
select round(15.393, -1) from dual;
select round(15.6789) from dual;
select round(15.6789, 2) from dual;
select round(15.6789, -1) from dual;
select mod(10, 3) from dual;

-- 문자 함수
select LOWER('MR. SCOTT MCMILLAN') "Lowercase" from dual;
select ename, lower(ename) from emp;
select concat('저는', '손흥민입니다.') from dual;
select ename || 'is a ' from emp;
select concat('나의 이름은 ', ename) from emp;
select LPAD('Page 1',15,'*') from dual; -- *********Page 1
select LPAD('Page 1',15,'*') from dual;
select rpad('001111-3', 14, '*') from dual;

select SUBSTR('ABCDEFG',3,4) from dual;
select SUBSTR('001212-3001234', 1, 8) from dual;
select substr(hiredate, 1, 2) from emp;

select rpad(SUBSTR('001212-3001234', 1, 8), 14,'*') from dual;
select rpad(substr(name,1,2),5,'*') from customer;
select * from customer;

select Ltrim('     =from=     ') from dual;
select Rtrim('     =from=     ') from dual;

select trim('+' from '+++++from+++++') as a from dual;
select trim(' ' from '     +++++from+++++     ') as a from dual;

select REPLACE('JACK and JUE','J','BL') from dual;
select replace('000-0000-0000', '-', '') from dual;


-- 날짜 함수
select sysdate from dual;
select sysdate-30 from dual;
select add_months(sysdate, 4) from dual;
select last_day(sysdate+10) from dual; -- 10월 29일에 10일을 더하면 11월이고 11월의 마지막 날 출력


-- 변환 함수
-- 날짜 -> 문자: to_char(원본, 패턴) -> 패턴은 출력 패턴을 의미
select to_char(sysdate, 'YYYY.MM.DD. day dy AM PM HH HH24:MI:ss') from dual;
-- 2021.10.29. 13:00
select to_char(sysdate, 'YYYY.MM.DD. HH24:MI') from dual;

-- 숫자 -> 문자: to_char(원본, 패턴)
select to_char(100000, '0000000') from dual;

-- 문자 -> 날짜: to_date(원본, 패턴)
select to_date('2021/10/29', 'YYYY/MM/DD') from dual;
select to_date('2021.10.25.', 'YYYY.MM.DD.') from dual;

select hiredate, to_char(hiredate, 'YYYY.MM.DD') from emp;

--2021.01.01~오늘 현재
select trunc(sysdate - to_date('2021-01-01', 'YYYY.MM.DD')) from dual;

select to_char(100000,'0,000,000') from dual;
--                     0100000
select to_char(100000,'9,999,999') from dual;

select to_char(100000.123,'L9,999,999.9') from dual;

select sal, to_char(sal*1200, 'L9,999,999') from emp;

-- 문자 -> 숫자 to_number(원본, 패턴)



