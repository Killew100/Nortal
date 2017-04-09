select 'Oh no, an SQL just to keep Liquibase happy. ' ||
       '#hiddenErrors #worksOnMyMachine' from (values(0));

-- 6. Create view V_REVENUE_REPORT with three columns: revenue_year, mechanic, revenue

--    This view should sum up all REPAIR_JOB prices by year and Mechanic
--    For example one line returned by this view should look like this:
--    REVENUE_YEAR	MECHANIC	REVENUE
--    2012	        Mike	    263626.75


