-- select 'Oh no, an SQL just to keep Liquibase happy. ' ||
--         '#hiddenErrors #worksOnMyMachine' from (values(0));

-- 6. Create view V_REVENUE_REPORT with three columns: revenue_year, mechanic, revenue

--    This view should sum up all REPAIR_JOB prices by year and Mechanic
--    For example one line returned by this view should look like this:
--    REVENUE_YEAR	MECHANIC	REVENUE
--    2012	        Mike	    263626.75

CREATE VIEW V_REVENUE_REPORT AS
  SELECT YEAR(END_TIME) AS REVENUE_YEAR,WORK_LOG.MECHANIC, SUM(PRICE) AS REVENUE
  FROM REPAIR_JOB
  INNER JOIN WORK_LOG ON REPAIR_JOB.ID=WORK_LOG.REF_REPAIR_JOB
  GROUP BY YEAR(END_TIME), WORK_LOG.MECHANIC
  ORDER BY YEAR(END_TIME) DESC;