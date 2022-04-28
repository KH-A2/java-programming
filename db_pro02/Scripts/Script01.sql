/*
 * DDL
 *     - Data Definition Language : 데이터 정의어
 *     - 객체를 정의하기 위한 CREATE(생성), ALTER(수정), DROP(삭제) 구문이 있다.
 *     - 오라클 객체는 TABLE, VIEW, SEQUENCE, FUNCTION, PROCEDUAL, USER, .... 등이 있다.
 */

/*
 * CREATE TABLE 테이블명 (
 *     컬럼명 자료형(크기) [제약조건]
 *   , ...
 * );
 */

CREATE TABLE sample_t (
       u_id      NUMBER       -- PRIMARY KEY
     , jumin     CHAR(13)     -- UNIQUE
     , name      VARCHAR2(50) NOT NULL
     , age       NUMBER(3)    DEFAULT(0)
     , gender    CHAR(1)      CHECK(GENDER IN ('M', 'F'))
     , birth_day DATE         DEFAULT(SYSDATE)
     , ref_col   NUMBER       -- REFERENCES ref_t(r_id)
     , CONSTRAINT PK_U_ID PRIMARY KEY(u_id)
     , CONSTRAINT UK_JUMIN UNIQUE(jumin)
     , CONSTRAINT FK_REF_T_R_ID FOREIGN KEY(ref_col) REFERENCES ref_t(r_id)
);
CREATE TABLE ref_t (
       r_id NUMBER PRIMARY KEY
     , note VARCHAR2(100)
);
DROP TABLE sample_t;
DROP TABLE ref_t;

SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SAMPLE_T';
-- DESC SAMPLE_T;

COMMENT ON COLUMN sample_t.name IS '이름';
COMMENT ON COLUMN sample_t.age IS '나이';
COMMENT ON COLUMN sample_t.gender IS '성별(M:남자, F:여자)';
COMMENT ON COLUMN sample_t.birth_day IS '생년월일';

SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SAMPLE_T';






