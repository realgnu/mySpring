CREATE TABLE TBL_USER
(
    USER_NO           NUMBER NOT NULL,
    USER_ID           VARCHAR2(100),
	USER_PW           VARCHAR2(500),
    NAME              VARCHAR2(200)
)
;
CREATE TABLE TBL_AUTH
(
    AUTH_NO           NUMBER NOT NULL
	AUTH_NAME         VARCHAR2(100)
)
;
CREATE TABLE TBL_USER_AUTH
(
    USER_NO           NUMBER NOT NULL
	AUTH_NO           NUMBER NOT NULL
)
;

insert into TBL_USER (USER_NO, USER_ID, USER_PW, NAME) values ( 1, 'a11111@yopmail.com', '1111', 'John');
insert into TBL_USER (USER_NO, USER_ID, USER_PW, NAME) values ( 2, 'a22222@yopmail.com', '2222', 'Tom');
insert into TBL_USER (USER_NO, USER_ID, USER_PW, NAME) values ( 3, 'a33333@yopmail.com', '3333', 'Amie');

insert into TBL_AUTH (AUTH_NO, AUTH_NAME) values (1, 'AUTH 1');
insert into TBL_AUTH (AUTH_NO, AUTH_NAME) values (2, 'AUTH 2');
insert into TBL_AUTH (AUTH_NO, AUTH_NAME) values (3, 'AUTH 3');

insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 1, 1);
insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 2, 2);
insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 3, 3);

SELECT USER_ID AS USERNAME,
    USER_PW AS PASSWORD,
    NAME
FROM TBL_USER
WHERE USER_ID = #{username}
;

SELECT C.AUTH_NAME
FROM TBL_USER A,
    TBL_USER_AUTH B,
    TBL_AUTH C
WHERE A.USER_ID = #{username}
AND A.USER_NO = B.USER_NO,
AND B.AUTH_NO = C.AUTH_NAME
;

update tbl_user 
set user_pw = '1111'
;
commit;