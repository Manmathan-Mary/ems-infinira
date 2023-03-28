CREATE TYPE enum_marital_status AS ENUM('single','married');
CREATE TYPE enum_blood_group AS ENUM('opos','apos','bpos','abpos','oneg','aneg','bneg','abneg');
CREATE TYPE enum_gender AS ENUM('male','female','transgender');

CREATE TABLE IF NOT EXISTS employee (
	emp_id SERIAL ,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	mobile_no VARCHAR(20) UNIQUE NOT NULL,
	middle_name VARCHAR(50) ,
	salary INTEGER NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL ,
	designation VARCHAR(50) NOT NULL,
	department_id SMALLINT ,
	date_of_birth DATE,
	date_of_hire DATE,
	date_of_leaving DATE,
	status VARCHAR(20),
	manager_id INTEGER,
	marital_status enum_marital_status ,
	differently_abled boolean,
	passport_no VARCHAR(10) UNIQUE NOT NULL,
	blood_group enum_blood_group,
	gender enum_gender NOT NULL,
	tax_id VARCHAR(20) UNIQUE NOT NULL,
	national_id VARCHAR(20) UNIQUE NOT NULL,
	address1 VARCHAR(50) NOT NULL,
	address2 VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	country VARCHAR(30) NOT NULL,
	postal_code VARCHAR(10) NOT NULL,
	date_of_creation TIMESTAMPTZ DEFAULT now() NOT NULL,
	last_update TIMESTAMPTZ DEFAULT now() NOT NULL ,
	CONSTRAINT pk_empid PRIMARY KEY(emp_id)
);

