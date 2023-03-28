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
	last_update TIMESTAMPTZ DEFAULT now() NOT NULL,
	CONSTRAINT pk_empid PRIMARY KEY(emp_id)
);

INSERT INTO employee(first_name,last_name,mobile_no,middle_name,salary,email,designation,department_id,date_of_birth,
	date_of_hire,date_of_leaving,status,manager_id,marital_status,differently_abled,passport_no,blood_group,gender,tax_id,national_id,
	address1,address2,city,state,country,postal_code)
	VALUES
	('Manmathan','Marie','+919677800108','Thompson',15000,'thompsonms198@gmail.com','software engineer',12,'1996-02-16','2022-06-01',
	'2025-06-01','active',12,'single',FALSE,'123456','apos','male','cpmpm1532j','201005083964','2-6-135,Rock Street','Uthamapalayam','Theni',
	'Tamil Nadu','India','625533'),
	('Marie','Selvam','+918300268265','Marimuthu',8000,'marieselvam@gmail.com','Agriculture',130,'1960-02-16','1980-06-01',
	'2022-06-01','inactive',12,'married',FALSE,'1234556','opos','female','cpmmpm1532j','201004563964','2-6-135,Rock Street','Uthamapalayam','Theni',
	'Tamil Nadu','India','625533'),
	('Amuthamozhi','Thompson','+918300258265','Selvam',80000,'amuthamozhithompson@gmail.com','Data scientist',132,'2020-05-05','2045-02-02',
	'2048-05-01','inactive',12,'married',FALSE,'123456232','opos','female','cpmpm1532565j','2010045636904','2-6-135,Rock Street','Uthamapalayam','Theni',
	'Tamil Nadu','India','625533');
	
	
	
	
	
	
	INSERT INTO employee(first_name,last_name,mobile_no,middle_name,salary,email,designation,department_id,date_of_birth,
	date_of_hire,date_of_leaving,status,manager_id,marital_status,differently_abled,passport_no,blood_group,gender,tax_id,national_id,
	address1,address2,city,state,country,postal_code)
	VALUES
	('Amuthamozhi','Thompson','+918300258265','Selvam',80000,'amuthamozhithompson@gmail.com','Data scientist',132,'2020-05-05','2045-02-02',
	'2048-05-01','inactive',12,'married',FALSE,'123456232','opos','female','cpmpm1532565j','2010045636904','2-6-135,Rock Street','Uthamapalayam','Theni',
	'Tamil Nadu','India','625533');
