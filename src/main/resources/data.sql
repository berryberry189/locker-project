-- 회원 테스트 데이터
INSERT INTO USER(USER_KEY, USER_ID, USER_NAME, USER_MOBILE) VALUES(1, 'userA', '회원1', '010-0000-1111');
INSERT INTO USER(USER_KEY, USER_ID, USER_NAME, USER_MOBILE) VALUES(2, 'userB', '회원2', '010-0000-2222');
INSERT INTO USER(USER_KEY, USER_ID, USER_NAME, USER_MOBILE) VALUES(3, 'userC', '회원3', '010-0000-3333');

-- 보관함 구역 테스트 데이터
INSERT INTO LOCKER_AREA(AREA_ID, AREA_NAME) VALUES (1,'강남구');
INSERT INTO LOCKER_AREA(AREA_ID, AREA_NAME) VALUES (2,'서초구');
INSERT INTO LOCKER_AREA(AREA_ID, AREA_NAME) VALUES (3,'송파구');
INSERT INTO LOCKER_AREA(AREA_ID, AREA_NAME) VALUES (4,'관악구');
INSERT INTO LOCKER_AREA(AREA_ID, AREA_NAME) VALUES (5,'동작구');


-- 보관함 테스트 테이터
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (1, 1, 'LARGE', 5000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (1, 2, 'MEDIUM', 3000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (1, 3, 'SMALL', 2000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (1, 4, 'LARGE', 5000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (1, 5, 'MEDIUM', 3000,'Y');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (1, 6, 'SMALL', 2000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (2, 1, 'LARGE', 5000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (2, 2, 'MEDIUM', 3000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (2, 3, 'SMALL', 2000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (3, 1, 'LARGE', 5000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (3, 2, 'MEDIUM', 3000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (3, 3, 'SMALL', 2000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (4, 1, 'LARGE', 5000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (4, 2, 'MEDIUM', 3000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (4, 3, 'SMALL', 2000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (5, 1, 'LARGE', 5000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (5, 2, 'MEDIUM', 3000,'N');
INSERT INTO LOCKER(AREA_ID, LOCKER_NO, LOCKER_TYPE, LOCKER_PRICE, USE_YN) VALUES (5, 3, 'SMALL', 2000,'N');


-- 대여 테스트 데이터
INSERT INTO LEND(LEND_ID, USER_KEY, AREA_ID, LOCKER_NO, LEND_HOUR, LEND_PRICE, LEND_STATUS, LEND_DATE)
         VALUES (1,  1,  1,  5,  6,  12000,  'LEND', '2021-07-14T21:20:01.101');
INSERT INTO LEND(LEND_ID, USER_KEY, AREA_ID, LOCKER_NO, LEND_HOUR, LEND_PRICE, LEND_STATUS, LEND_DATE)
         VALUES (2,  1,  1,  3,  2,  10000,  'LEND', '2021-07-15T21:20:01.101');
