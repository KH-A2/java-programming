SELECT 'Hello Local, Docker' FROM DUAL;

-- ������ �н����� �����ϴ� ���
CREATE USER puser1 IDENTIFIED BY puser1;

-- ������ ������ ���� �ο�
GRANT RESOURCE, CONNECT TO puser1;
GRANT INSERT ANY TABLE, UPDATE ANY TABLE
    , DELETE ANY TABLE, CREATE VIEW
   TO puser1;