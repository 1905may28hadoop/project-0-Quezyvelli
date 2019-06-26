DROP TABLE bank_customers CASCADE CONSTRAINTS;
CREATE TABLE bank_customers(
	cust_id NUMBER(7) PRIMARY KEY,
	cust_name VARCHAR2(200)UNIQUE,
	birth_date NUMBER(20) NOT NULL,
	mobile_no VARCHAR2(200),
	account_id NUMBER(6)
	
);
DROP TABLE customer_account CASCADE CONSTRAINTS;
CREATE TABLE customer_account(
	account_id NUMBER(6) PRIMARY KEY,
	account_type VARCHAR2(200),
	account_balance NUMBER NOT NULL,
	cust_id NUMBER(7),
	
	-- you can also CONSTRAINTS
	CONSTRAINT bank_customers_fk FOREIGN KEY(cust_id) REFERENCES bank_customers(cust_id)
);

SELECT * FROM customer_account;

INSERT INTO bank_customers VALUES(6195349,'Dillon Newton', 1960-12-18, '(799)-841-1417', 23);
INSERT INTO bank_customers VALUES(6295350,'Maja Hodges', 1968-01-16, '(390)-265-8884',34);
INSERT INTO bank_customers VALUES(6395351,'Daria Lucero', 1984-01-30, '(777)-559-2118',45);
INSERT INTO bank_customers VALUES(6495352,'Caius Bright', 2003-03-28, '(285)-399-5134',56);
INSERT INTO bank_customers VALUES(6595353,'Lawrence Amos', 1980-08-05, '(923)-777-2209',67);
INSERT INTO bank_customers VALUES(6695354,'Shahid Craft', 1986-01-15, '(664)-575-9633',78);
INSERT INTO bank_customers VALUES(6795355,'Mandeep Sawyer', 1946-06-28, '(958)-447-7950',89);
INSERT INTO bank_customers VALUES(6895356,'Yannis Rigby', 1952-06-21, '(690)-555-9158',90);
INSERT INTO bank_customers VALUES(6995357,'Nabeela Esquivel', 1982-04-08, '(618)-742-5481',01);
INSERT INTO bank_customers VALUES(6095358,'Lilly-Mae Sheppard', 1987-08-23, '(398)-484-6014',12);
SELECT * FROM bank_customers;
SELECT * FROM customer_account;

INSERT INTO customer_account VALUES(23,'Checking Account',7400,6195349);
INSERT INTO customer_account VALUES(34,'Checking Account',4500,6295350);
INSERT INTO customer_account VALUES(45,'Checking Account',3200,6395351);
INSERT INTO customer_account VALUES(56,'Checking Account',216.92,6495352);
INSERT INTO customer_account VALUES(67,'Checking Account',56400,6595353);
INSERT INTO customer_account VALUES(78,'Checking Account',15600,6695354);
INSERT INTO customer_account VALUES(89,'Checking Account',240.00,6795355);
INSERT INTO customer_account VALUES(90,'Checking Account',2400,6895356);
INSERT INTO customer_account VALUES(01,'Checking Account',62400,6995357);
INSERT INTO customer_account VALUES(12,'Checking Account',1085,6095358);
SELECT * FROM customer_account;
