use test_schema_vikrant;
create table if not exists EMPLOYEE (
EMP_ID varchar(10) NOT NULL PRIMARY KEY,
EMP_NAME varchar(256) NOT NULL
);