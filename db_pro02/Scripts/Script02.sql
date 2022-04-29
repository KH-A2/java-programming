/*
 * 지출내역서(가계부)를 위한 테이블을 만들어 본다.
 *     - 테이블 이름은 지출내역서_T 라고 한다.
 *     - 날짜, 입금액, 출금액, 비고 를 저장할 수 있는 컬럼 필요하다.
 *     - 비고의 경우 한글 150자 까지 저장 가능해야 한다.
 */
CREATE TABLE 지출내역서_T (
       날짜 DATE
     , 입금액 NUMBER
     , 출금액 NUMBER
     , 비고 VARCHAR2(450)
);

/*
 * 위에서 만든 지출내역서에 다음의 컬럼 정보를 추가 및 수정 한다.
 *     - 행 데이터를 식별하기 위한 식별자용 컬럼을 추가 이 컬럼 이름은 ACCOUNT_ID 로 한다.
 *     - 비고의 데이터 저장 크기를 기존보다 2배 늘린다.
 *     - 지출내역 항목을 구분하기 위한 ACCOUNT_TYPE 컬럼을 추가하고
 *       해당 컬럼은 FK 로 만든다.
 *     - ACCOUNT_TYPE 컬럼이 참조하는 테이블은 "지출내역구분_T" 라는 테이블로 만들어 둔다.
 *     - 지출내역구분 테이블에는 식별자용 컬럼, 구분명 컬럼이 있어야 한다.
 */
ALTER TABLE 지출내역서_T ADD ACCOUNT_ID NUMBER CONSTRAINT PK_지출내역서_T_ACCOUNT_ID PRIMARY KEY;
ALTER TABLE 지출내역서_T MODIFY 비고 VARCHAR2(900);

CREATE TABLE 지출내역구분_T (
       구분ID NUMBER CONSTRAINT PK_지출내역구분_구분ID PRIMARY KEY
     , 구분명 VARCHAR2(100)
);

ALTER TABLE 지출내역서_T ADD ACCOUNT_TYPE NUMBER CONSTRAINT FK_지출내역서_T_ACCOUNT_TYPE REFERENCES 지출내역구분_T(구분ID);


SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME LIKE '지출내역%';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE '지출내역%';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE '지출내역%';



INSERT INTO 지출내역구분_T VALUES(1, '은행예금');
INSERT INTO 지출내역구분_T VALUES(2, '은행적금');
INSERT INTO 지출내역구분_T(구분ID, 구분명) VALUES(3, '교통비');
INSERT INTO 지출내역구분_T(구분명, 구분ID) VALUES('통신비', 4);


CREATE TABLE 지출내역구분_COPY (
       구분ID NUMBER CONSTRAINT PK_지출내역구분_COPY_구분ID PRIMARY KEY
     , 구분명 VARCHAR2(100)
);

INSERT INTO 지출내역구분_COPY (
       SELECT 구분ID, 구분명
         FROM 지출내역구분_T
);

SELECT * FROM 지출내역구분_COPY;
DELETE FROM 지출내역구분_COPY;

CREATE TABLE 지출내역구분_COPY2
    AS SELECT 구분명 FROM 지출내역구분_T
        WHERE 1 = 0;

INSERT ALL
  INTO 지출내역구분_COPY VALUES(idx, name)
  INTO 지출내역구분_COPY2 VALUES(name)
SELECT 구분ID AS idx, 구분명 AS name
  FROM 지출내역구분_T;

SELECT * FROM 지출내역구분_COPY;
SELECT * FROM 지출내역구분_COPY2;
DELETE FROM 지출내역구분_COPY;
DELETE FROM 지출내역구분_COPY2;

