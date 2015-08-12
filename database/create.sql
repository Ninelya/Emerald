# cd c:\xampp\mysql\bin
# mysql -u root
# source d:/Java/db/create.sql;

DROP DATABASE IF EXISTS emerald;
CREATE DATABASE emerald  DEFAULT CHARACTER SET utf8;

USE emerald;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS moders;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS tariffs;
DROP TABLE IF EXISTS credits;
DROP TABLE IF EXISTS mail;
DROP TABLE IF EXISTS payments;

#___________ ТАБЛИЦА ДОСТУПА ______________________________
CREATE TABLE IF NOT EXISTS users
(
	id			INT unsigned NOT NULL auto_increment,			
	email		VARCHAR(255) NOT NULL UNIQUE,		
	password	VARCHAR(255) NOT NULL,
	name		VARCHAR(255) NOT NULL,
	access 		ENUM('client', 'manager', 'marketer', 'admin') NOT NULL DEFAULT 'client',
	
	PRIMARY KEY (id)
);

#___________ ТАБЛИЦА МОДЕРАТОРОВ ____________________________
CREATE TABLE IF NOT EXISTS moders
(
	id			INT unsigned NOT NULL auto_increment,			
	user_id		INT unsigned,		

	FOREIGN KEY (user_id) 
		REFERENCES users (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (id),
	UNIQUE INDEX (user_id)
);

#_______ ТАБЛИЦА КЛИЕНТОВ _________________________________
CREATE TABLE IF NOT EXISTS clients
(
	id			INT unsigned NOT NULL auto_increment,
	moder_id	INT unsigned,
	user_id		INT unsigned NOT NULL,
	inn			CHAR(10) NOT NULL UNIQUE,
	address		VARCHAR(255) NOT NULL,
	tel			INT unsigned NOT NULL,
	income		DECIMAL(10,2) unsigned NOT NULL,
	guarantee	BOOL NOT NULL DEFAULT false,
	create_date	TIMESTAMP NOT NULL,
	birthday	INT NOT NULL,
	seniority	INT unsigned NOT NULL,
	is_student  BOOL NOT NULL DEFAULT false,
	
	FOREIGN KEY (user_id) 
		REFERENCES users (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	FOREIGN KEY (moder_id) 
		REFERENCES moders (id)
		ON DELETE SET NULL
		ON UPDATE CASCADE,
	PRIMARY KEY (id),
	UNIQUE INDEX (user_id)
);

#___________ ТАБЛИЦА ТАРИФОВ ___________________
CREATE TABLE IF NOT EXISTS tariffs
(
	id			INT unsigned NOT NULL auto_increment,
	name		VARCHAR(255) NOT NULL,
	min_sum		DECIMAL(10,2) unsigned NOT NULL,
	max_sum		DECIMAL(10,2) unsigned NOT NULL,
	rate		INT unsigned NOT NULL,
	term_month	INT unsigned NOT NULL,		
	condit		LONGTEXT,
	is_active	BOOL NOT NULL DEFAULT TRUE,

	PRIMARY KEY (id)
);

#___________ ТАБЛИЦА ЗАЯВОК _______________________________
CREATE TABLE IF NOT EXISTS requests
(
	id			INT unsigned NOT NULL auto_increment,
	client_id	INT unsigned NOT NULL,
	tariff_id	INT unsigned,
	sum			DECIMAL(10,2) unsigned NOT NULL,
	status		ENUM('pending', 'approved', 'denied') NOT NULL DEFAULT 'pending',
	create_date	TIMESTAMP NOT NULL,
	deny_reason	LONGTEXT,
	
	FOREIGN KEY (client_id) 
		REFERENCES clients (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	FOREIGN KEY (tariff_id) 
		REFERENCES tariffs (id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	PRIMARY KEY (id),
	UNIQUE INDEX (client_id, tariff_id)
);

#___________ ТАБЛИЦА КРЕДИТНОЙ ИСТОРИИ ____________________
CREATE TABLE IF NOT EXISTS credits
(
	id			INT unsigned NOT NULL auto_increment,
	request_id	INT unsigned NOT NULL,
	payed_off	BOOL NOT NULL DEFAULT false,
	date_app	TIMESTAMP NOT NULL,
	date_payed	TIMESTAMP,
	percent		DECIMAL(10,2) NOT NULL DEFAULT 0,

	
	FOREIGN KEY (request_id) 
		REFERENCES requests (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (id),
	UNIQUE INDEX (request_id)
);

#___________ ТАБЛИЦА ПОЧТЫ ________________________________
CREATE TABLE IF NOT EXISTS mail
(
	id			INT unsigned NOT NULL auto_increment,
	client_id	INT unsigned NOT NULL,
	sent_time	TIMESTAMP NOT NULL,
	status		ENUM('pending', 'question', 'answer') NOT NULL DEFAULT 'pending',
	text		LONGTEXT NOT NULL,
	
	FOREIGN KEY (client_id) 
		REFERENCES clients (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (id)
);

#___________ ТАБЛИЦА ОПЛАТЫ _______________________________
CREATE TABLE IF NOT EXISTS payments
(
	id			INT unsigned NOT NULL auto_increment,
	credit_id	INT unsigned NOT NULL,
	sum			DECIMAL(10,2) unsigned NOT NULL,
	date		TIMESTAMP NOT NULL,
	penalty		DECIMAL(10,2) unsigned NOT NULL DEFAULT 0,
	
	
	FOREIGN KEY (credit_id) 
		REFERENCES credits (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	PRIMARY KEY (id)
);

#EXPLAIN users;
#EXPLAIN moders;
#EXPLAIN clients;
#EXPLAIN requests;
#EXPLAIN tariffs;
#EXPLAIN credits;
#EXPLAIN mail;
#EXPLAIN payments;