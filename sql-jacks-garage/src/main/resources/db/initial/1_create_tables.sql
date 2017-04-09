create table REPAIR_JOB (
  id IDENTITY,
	start_time TIMESTAMP,
	end_time TIMESTAMP,
	parts VARCHAR(35),
	description VARCHAR(350),
	price DECIMAL(10,2)
);
