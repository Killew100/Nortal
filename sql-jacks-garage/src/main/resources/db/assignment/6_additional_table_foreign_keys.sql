 select 'Oh no, an SQL just to keep Liquibase happy. ' ||
        '#hiddenErrors #worksOnMyMachine' from (values(0));

-- 3. Add foreign keys
ALTER TABLE WORK_LOG
ADD CONSTRAINT fk_id FOREIGN KEY (REF_REPAIR_JOB) REFERENCES REPAIR_JOB(ID);

ALTER TABLE SPARE_PART
ADD CONSTRAINT fk_id2 FOREIGN KEY (REF_REPAIR_JOB) REFERENCES REPAIR_JOB(ID);
