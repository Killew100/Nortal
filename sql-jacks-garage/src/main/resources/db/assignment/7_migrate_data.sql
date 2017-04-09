select 'Oh no, an SQL just to keep Liquibase happy. ' ||
       '#hiddenErrors #worksOnMyMachine' from (values(0));

-- 4. Migrate work log times from REPAIR_JOB table to WORK_LOG table

-- 5. Migrate parts from REPAIR_JOB table to the new SPARE_PART table

