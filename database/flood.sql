# source d:/Java/db/create.sql; source d:/Java/db/flood.sql;

DELETE FROM users;
DELETE FROM moders;
DELETE FROM clients;
DELETE FROM requests;
DELETE FROM tariffs;
DELETE FROM credits;
DELETE FROM mail;
DELETE FROM payments;

#__________ СОЗДАНИЕ МОДЕРА _____________________________________________________
INSERT INTO users SET
	email = "df", #market@mail.ua
	password = "pass3",
	name = "market",
	access = 'marketer'
;

INSERT INTO moders SET
	user_id = (SELECT id FROM users WHERE email = "df")
;

INSERT INTO users SET
	email = "de", #manager@mail.ua
	password = "pass4",
	name = "nina",
	access = 'manager'
;	

INSERT INTO moders SET
	user_id = (SELECT id FROM users WHERE email = "de")
;

INSERT INTO users SET
	email = "da", #admin@mail.ua
	password = "pass5",
	name = "admin",
	access = 'admin'
;

INSERT INTO moders SET
	user_id = (SELECT id FROM users WHERE email = "da")
;

#_____________ СОЗДАНИЕ НОВОГО КЛИЕНТА __________________________________________________

INSERT INTO users SET
	email = "email@mail.ua",
	name = "Василь Боровий",
	password = "password1"
;

INSERT INTO clients SET 
	user_id = (SELECT id FROM users WHERE email = "email@mail.ua"),
	moder_id = 2,
	inn	= "1230456789",	
	address = "adress1",
	tel = 504050,
	income = 500.50,
	guarantee = true,
	create_date = NOW(),
	birthday = 1986,
	seniority = 5
;

INSERT INTO users SET
	email = "email@gmail.ua",
	password = "password2",
	name = "Микола Коваль"
;

INSERT INTO clients SET 
	user_id = (SELECT id FROM users WHERE email = "email@gmail.ua"),
	inn	= "1230486789",
	moder_id = 2,
	address = "adress2",
	tel = 504050,
	income = 700,
	guarantee = true,
	create_date = NOW(),
	birthday = 1978,
	seniority = 1
;

#____________ ДОБАВЛЕНИЕ КРЕДИТНОЙ ПРОГИ _______________________________________________
INSERT INTO tariffs SET 
	name = "Рубін",
	min_sum = 1000.05,
	max_sum = 3000,
	rate = 10,
	term_month = 3,
	condit = "conditions"	
;

INSERT INTO tariffs SET 
	name = "Малахіт",
	min_sum = 4000,
	max_sum = 6000,
	rate = 15,
	term_month = 4,
	condit = "conditions"	
;

#____________ СОЗДАНИЕ ЗАЯВКИ __________________________________________________________
INSERT INTO requests SET 
	client_id = 1,
	tariff_id = 2,
	sum = 5000.12,
	create_date = NOW()
;	

INSERT INTO requests SET 
	client_id = 1,
	tariff_id = 1,
	sum = 4000,
	create_date = NOW()
;

#____________ НОВЫЙ КРЕДИТ _____________________________________________________________
INSERT INTO credits SET 
	request_id = 1,
	percent = 250.01,
	date_app = NOW()
;

UPDATE requests SET
	status = 'approved'
	WHERE id = 1
;

#____________ ОПЛАТА КРЕДИТА ___________________________________________________________
INSERT INTO payments SET
	credit_id = 1,
	sum = 500,
	date = NOW()
;

#____________ СОЗДАНИЕ СООБЩЕНИЯ _______________________________________________________
INSERT INTO mail SET 
	client_id = 1,
	sent_time = NOW(),
	text = "message1"
;

INSERT INTO mail SET 
	client_id = 2,
	sent_time = NOW(),
	text = "message2"
;

INSERT INTO mail SET 
	client_id = 1,
	sent_time = NOW(),
	text = "message3",
	status = 'answer'
;

UPDATE mail SET
	status = 'question'
	WHERE id = 1
;

SELECT * FROM users;
SELECT * FROM moders;
SELECT * FROM clients;
SELECT * FROM requests;
SELECT * FROM tariffs;
SELECT * FROM credits;
SELECT * FROM mail;
SELECT * FROM payments;