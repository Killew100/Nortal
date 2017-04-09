update REPAIR_JOB set end_time = end_time + INTERVAL '1' HOUR;
update REPAIR_JOB set price = price / 4; -- Generated too high prices