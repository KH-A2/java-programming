CREATE TABLE T_MYBATIS (
       id NUMBER
     , name VARCHAR2(100)
     , today DATE
);

ALTER TABLE T_MYBATIS ADD CONSTRAINT T_MYBATIS_ID_PK PRIMARY KEY(id);

CREATE SEQUENCE SEQ_MYBATIS;

INSERT INTO T_MYBATIS VALUES (SEQ_MYBATIS.NEXTVAL, 'test', '2022-06-22');

SELECT * FROM T_MYBATIS;
DELETE FROM T_MYBATIS;


SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
     , SALARY
     , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE 1 = 1
   AND SALARY >= 10000
--   AND HIRE_DATE <= TO_DATE('1995/12/31')
--   AND HIRE_DATE >= TO_DATE('1995/01/01')
   
   AND HIRE_DATE BETWEEN TO_DATE('1990/01/01') AND TO_DATE('2000/12/31')
--   AND DEPARTMENT_ID = 80;
   AND DEPARTMENT_ID IN (80, 90, 100)
  
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 10000
 
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
     , SALARY
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('1990/01/01') AND TO_DATE('2000/12/31')
 
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
     , SALARY
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 80;


SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 10000
   AND HIRE_DATE BETWEEN TO_DATE('1990/01/01') AND TO_DATE('2000/12/31')
   
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 10000
   AND DEPARTMENT_ID = 80;
  
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
     , SALARY
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('1990/01/01') AND TO_DATE('2000/12/31')
   AND DEPARTMENT_ID = 80;



SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;


SELECT E.EMPLOYEE_ID
     , E.FIRST_NAME || ' ' || E.LAST_NAME AS EMPLOYEE_NAME
     , E.PHONE_NUMBER
     , E.COMMISSION_PCT 
     , E.SALARY
     , D.DEPARTMENT_ID
     , D.DEPARTMENT_NAME
     , J.JOB_ID
     , J.JOB_TITLE
     , J.MIN_SALARY
     , J.MAX_SALARY
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
 WHERE E.EMPLOYEE_ID = 100;

 
 
 
SELECT COUNT(*) AS TOTAL
     , D.DEPARTMENT_NAME AS DEPT_NAME
     , E.DEPARTMENT_ID AS DEPT_CODE
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
-- WHERE E.DEPARTMENT_ID = 80
-- WHERE E.DEPARTMENT_ID IN (80, 90, 100)
-- WHERE E.DEPARTMENT_ID BETWEEN 80 AND 100
 GROUP BY D.DEPARTMENT_NAME, E.DEPARTMENT_ID;
 

SELECT COUNT(*) FROM EMPLOYEES WHERE EMPLOYEE_ID = 99;

SELECT * FROM DEPARTMENTS WHERE MANAGER_ID = 100;

SELECT * FROM JOBS;
 
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
 
DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = 11;


SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'DEPARTMENTS';
 
 
 

SELECT *
  FROM (SELECT ROWNUM AS NUM
             , DEPARTMENT_ID
             , DEPARTMENT_NAME
             , MANAGER_ID
             , LOCATION_ID
          FROM DEPARTMENTS)
 WHERE NUM BETWEEN 10 AND 21;
 
 
 
 
 
SELECT E.EMPLOYEE_ID
     , CONCAT(E.FIRST_NAME, ' ' || E.LAST_NAME) AS EMPLOYEE_NAME
     , CONCAT(E.EMAIL, '@emp.com') AS EMAIL
     , J.JOB_TITLE AS JOB_NAME
     , E.JOB_ID
     , D.DEPARTMENT_NAME
     , E.DEPARTMENT_ID
  FROM EMPLOYEES E
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;


SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 254;

DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = 254;



CREATE TABLE PERMISSIONS (
       empid     NUMBER
     , tablename VARCHAR2(100)
     , pread     VARCHAR2(1) DEFAULT('Y') CHECK (pread IN ('Y', 'N'))
     , padd      VARCHAR2(1) DEFAULT('N') CHECK (padd IN ('Y', 'N'))
     , pupdate   VARCHAR2(1) DEFAULT('N') CHECK (pupdate IN ('Y', 'N'))
     , pdelete   VARCHAR2(1) DEFAULT('N') CHECK (pdelete IN ('Y', 'N'))
     , CONSTRAINT PERMISSIONS_EMPID_TABLENAME_PK PRIMARY KEY(empid, tablename)
);

DROP TABLE PERMISSIONS;

INSERT INTO PERMISSIONS(empid, tablename)
SELECT EMPLOYEE_ID AS empid
     , 'employees'
  FROM EMPLOYEES;
 
INSERT INTO PERMISSIONS(empid, tablename)
SELECT EMPLOYEE_ID AS empid
     , 'departments'
  FROM EMPLOYEES;
 
INSERT INTO PERMISSIONS(empid, tablename)
SELECT EMPLOYEE_ID AS empid
     , 'jobs'
  FROM EMPLOYEES;
 
INSERT INTO PERMISSIONS(empid, tablename)
SELECT EMPLOYEE_ID AS empid
     , 'permissions'
  FROM EMPLOYEES;
 
SELECT * FROM PERMISSIONS WHERE empid = 100;
UPDATE PERMISSIONS SET PREAD = 'N' WHERE TABLENAME != 'employees';
UPDATE PERMISSIONS
   SET PREAD = 'Y'
     , PADD = 'Y'
     , PUPDATE = 'Y'
     , PDELETE = 'Y'
 WHERE EMPID = 200;



SELECT * FROM EMPLOYEES;

SELECT * FROM DEPARTMENTS;


SELECT TRUE FROM DUAL;


DROP TABLE EMP_BOARDS CASCADE CONSTRAINTS;
DROP SEQUENCE EMP_BOARDS_SEQ;

CREATE TABLE EMP_BOARDS (
	   ID NUMBER NOT NULL
	 , TITLE VARCHAR2(100) NOT NULL
	 , CONTENT VARCHAR2(2000)
	 , EMPID NUMBER NOT NULL
	 , CREATEDATE DATE DEFAULT(SYSDATE)
	 , CONSTRAINT EMP_BOARDS_ID_PK PRIMARY KEY (ID)
	 , CONSTRAINT EMP_BOARDS_EMP_ID_FK FOREIGN KEY(EMPID) REFERENCES EMPLOYEES(EMPLOYEE_ID)
);

ALTER TABLE EMP_BOARDS ADD VIEW_CNT NUMBER DEFAULT(0);
ALTER TABLE EMP_BOARDS ADD "LIKE" NUMBER DEFAULT(0);

CREATE SEQUENCE EMP_BOARDS_SEQ NOCACHE;


CREATE TABLE UPLOADFILES (
       ID NUMBER                         -- 자동 증가 시퀸스
     , BID NUMBER                        -- 게시판 ID
     , FILENAME VARCHAR2(200) NOT NULL   -- 오리지널 파일명
     , UUIDNAME VARCHAR2(36) NOT NULL    -- 변경된 파일명
     , LOCATION VARCHAR2(500) NOT NULL   -- 실제 파일 위치
     , URL VARCHAR2(500) NOT NULL        -- 요청 URL 주소
     , FILESIZE NUMBER DEFAULT(0)        -- 파일크기(바이트)
     , CONSTRAINT UPLOADFILES_ID_PK PRIMARY KEY(ID)
     , CONSTRAINT UPLOADFILES_BID_FK FOREIGN KEY(BID) REFERENCES EMP_BOARDS(ID)
);
CREATE SEQUENCE UPLOADFILES_SEQ NOCACHE;

SELECT * FROM UPLOADFILES;
DROP TABLE UPLOADFILES;


CREATE TABLE EMP_BOARDS_STATISTICS (
       ID NUMBER PRIMARY KEY
     , EMPID NUMBER
     , BID NUMBER
     , ISVIEW VARCHAR2(1) CHECK(ISVIEW IN ('Y', 'N'))
     , LATEST_DATE1 DATE
     , ISLIKE VARCHAR2(1) CHECK(ISLIKE IN ('Y', 'N'))
     , LATEST_DATE2 DATE
     , CONSTRAINT EMP_BOARDS_STATISTICS_EMPID_FK FOREIGN KEY(EMPID) REFERENCES EMPLOYEES(EMPLOYEE_ID)
     , CONSTRAINT EMP_BOARDS_STATISTICS_BID_FK FOREIGN KEY(BID) REFERENCES EMP_BOARDS(ID)
);

CREATE SEQUENCE EMP_BOARDS_STATISTICS_SEQ NOCACHE;





DROP TABLE COMMENTS;

CREATE TABLE COMMENTS (
       ID NUMBER PRIMARY KEY
     , BID NUMBER
     , CONTENT VARCHAR2(1000) NOT NULL
     , EMPID NUMBER
     , CREATEDATE DATE DEFAULT(SYSDATE)
     , DELETED VARCHAR2(1) CHECK(DELETED IN ('Y', 'N'))
     , CONSTRAINT COMMENTS_BID_FK FOREIGN KEY(BID) REFERENCES EMP_BOARDS(ID)
     , CONSTRAINT COMMENTS_EMPID_FK FOREIGN KEY(EMPID) REFERENCES EMPLOYEES(EMPLOYEE_ID)
);

CREATE SEQUENCE COMMENTS_SEQ NOCACHE;


SELECT * FROM COMMENTS;

UPDATE COMMENTS
   SET DELETED = 'N';


SELECT * FROM EMP_BOARDS_STATISTICS;

DELETE FROM EMP_BOARDS_STATISTICS;

SELECT * FROM EMP_BOARDS;

SELECT * FROM EMPLOYEES;

SELECT * FROM PERMISSIONS;




SELECT * FROM EMP_BOARDS;
SELECT * FROM EMP_BOARDS_STATISTICS WHERE BID = 1;

DELETE FROM EMP_BOARDS WHERE ID = 1;

DELETE FROM EMP_BOARDS_STATISTICS WHERE BID = 1;














