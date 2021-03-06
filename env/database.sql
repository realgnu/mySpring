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
    AUTH_NO           NUMBER NOT NULL,
    AUTH_NAME         VARCHAR2(100)
)
;
CREATE TABLE TBL_USER_AUTH
(
    USER_NO           NUMBER NOT NULL,
    AUTH_NO           NUMBER NOT NULL
)
;
CREATE TABLE TBL_AUTH_MENU
(
    MENU_NO           NUMBER NOT NULL,
    AUTH_NO           NUMBER NOT NULL
)
;
CREATE TABLE TBL_MENU
(
    MENU_NO        NUMBER NOT NULL,
    HIGH_MENU_NO   NUMBER,
    MENU_DEPTH_NO  NUMBER,
    MENU_DEPTH_ORD NUMBER,
    MENU_TYPE      VARCHAR2(1),
    MENU_NAME      VARCHAR2(200),
    MENU_DESC      VARCHAR2(500),
    URI            VARCHAR2(500)
)
;

delete from TBL_USER;
insert into TBL_USER (USER_NO, USER_ID, USER_PW, NAME) values ( 1, 'a@a.com', '$2a$10$IAi7jL7fop4YgE54MZ2hSuUYk02NmGKB1dSmEwk35EDbPQSeokDu6', 'Admin');
insert into TBL_USER (USER_NO, USER_ID, USER_PW, NAME) values ( 2, 'u@a.com', '$2a$10$IAi7jL7fop4YgE54MZ2hSuUYk02NmGKB1dSmEwk35EDbPQSeokDu6', 'User');

DELETE FROM TBL_AUTH;
insert into TBL_AUTH (AUTH_NO, AUTH_NAME) values (1, 'ADMIN');
insert into TBL_AUTH (AUTH_NO, AUTH_NAME) values (2, 'USER');
insert into TBL_AUTH (AUTH_NO, AUTH_NAME) values (3, 'DASHBOARD');

DELETE FROM TBL_USER_AUTH;
insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 1, 1);
insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 1, 2);
insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 1, 3);
insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 2, 2);
insert into TBL_USER_AUTH (USER_NO, AUTH_NO) values ( 2, 3);

DELETE FROM TBL_MENU;
INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
VALUES (0, -1, 0, 1, 'R', 'Top', 'Top Dummy', null);
INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
VALUES (1, 0, 1, 1, 'R', 'Dashboard', 'Dashboard', null);
INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
  VALUES (2, 1, 2, 1, 'R', 'Dashboard', 'Dashboard', '/dashboard.do');
  INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
VALUES (11, 0, 1, 2, 'R', 'Admin', 'Admin', null);
INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
  VALUES (12, 11, 2, 1, 'R', 'Member', 'Member', '/member/getUserList.do');
  INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
    VALUES (13, 12, 3, 1, 'R', 'Member List', 'Member List', '/member/getUserList.do');
    INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
    VALUES (14, 12, 3, 2, 'R', 'Member Detail', 'Member Detail', '/member/getUserDetail.do');
    INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
VALUES (21, 0, 1, 3, 'R', 'Community', 'Community', null);
INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
  VALUES (22, 21, 2, 1, 'R', 'Community1', 'Community1', '/community1/getList.do');
  INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
    VALUES (23, 21, 3, 1, 'R', 'Commnuity1 List', 'Commnuity1 List', '/community1/getList.do');
    INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
    VALUES (24, 21, 3, 2, 'R', 'Community1 Detail', 'Community1 Detail', '/community1/getDetail.do');
    INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
  VALUES (32, 21, 2, 1, 'R', 'Community2', 'Community2', '/community2/getList.do');
  INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
    VALUES (33, 32, 3, 1, 'R', 'Commnuity2 List', 'Commnuity2 List', '/community2/getList.do');
    INSERT INTO TBL_MENU (MENU_NO, HIGH_MENU_NO, MENU_DEPTH_NO, MENU_DEPTH_ORD, MENU_TYPE, MENU_NAME, MENU_DESC, URI)
    VALUES (34, 32, 3, 2, 'R', 'Community2 Detail', 'Community2 Detail', '/community2/getDetail.do');

DELETE FROM TBL_AUTH_MENU;
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (1, 3);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (2, 3);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (11, 1);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (12, 1);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (13, 1);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (14, 1);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (21, 2);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (22, 2);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (23, 2);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (24, 2);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (32, 2);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (33, 2);
INSERT INTO TBL_AUTH_MENU (MENU_NO, AUTH_NO) VALUES (34, 2);


commit;