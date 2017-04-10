-- TODO: Should we remove this?
-- select 'Oh no, an SQL just to keep Liquibase happy. ' ||
--        '#hiddenErrors #worksOnMyMachine' from (values(0));

-- 1. Create table WORK_LOG
CREATE TABLE WORK_LOG (
  ID INTEGER,
  START_TIME TIMESTAMP,
  END_TIME TIMESTAMP,
  REF_REPAIR_JOB INTEGER,
  MECHANIC VARCHAR(50),
  DESCRIPTION VARCHAR(350)
);

-- 2. Create table SPARE_PART
CREATE TABLE SPARE_PART (
  ID INTEGER,
  REF_REPAIR_JOB INTEGER,
  NAME VARCHAR(350)
);

