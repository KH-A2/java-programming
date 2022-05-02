SELECT *
  FROM EMPLOYEES, DEPARTMENTS;
-- WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;

 SELECT *
  FROM DEPARTMENTS, EMPLOYEES;
 

SELECT *
  FROM EMPLOYEES
  JOIN DEPARTMENTS
 USING(DEPARTMENT_ID);

SELECT *
  FROM EMPLOYEES
  JOIN DEPARTMENTS
    ON (EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID);

SELECT *
  FROM EMPLOYEES
  LEFT JOIN DEPARTMENTS
 USING(DEPARTMENT_ID)
 WHERE EMPLOYEE_ID = 178;

SELECT *
  FROM EMPLOYEES
 RIGHT JOIN DEPARTMENTS
 USING(DEPARTMENT_ID);

SELECT *
  FROM EMPLOYEES
  FULL JOIN DEPARTMENTS
 USING(DEPARTMENT_ID);


SELECT *
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
  JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
 WHERE E.COMMISSION_PCT IS NOT NULL
   AND D.DEPARTMENT_ID = 80;
















