create table if not exists  countries
(
	id bigserial not null
		constraint countries_pkey
			primary key,
	name varchar(255),
	phone_regex varchar(255)
);


create table if not exists   customers
(
	id bigserial not null
		constraint customers_pkey
			primary key,
	contact_phone varchar(255),
	name varchar(255),
	country_id bigint
		constraint fk7b7p2myt0y31l4nyj1p7sk0b1
			references countries
);

create index if not exists  customers_country_id_index
	on customers (country_id);

create sequence if not exists hibernate_sequence;

INSERT INTO countries (name, phone_regex)
VALUES ('Cameroon', '\(237\)\ ?[2368]\d{7,8}$'),
       ('Ethiopia', '\(251\)\ ?[1-59]\d{8}$'),
       ('Morocco', '\(212\)\ ?[5-9]\d{8}$'),
       ('Mozambique', '\(258\)\ ?[28]\d{7,8}$'),
       ('Uganda', '\(256\)\ ?\d{9}$');

INSERT INTO customers (id, name, contact_phone)
values (0, 'Walid Hammadi', '(212) 6007989253'),
       (1, 'Yosaf Karrouch', '(212) 698054317'),
       (2, 'Younes Boutikyad', '(212) 6546545369'),
       (3, 'Houda Houda', '(212) 6617344445'),
       (4, 'Chouf Malo', '(212) 691933626'),
       (5, 'soufiane fritisse', '(212) 633963130'),
       (6, 'Nada Sofie', '(212) 654642448'),
       (7, 'Edunildo Gomes Alberto', '(258) 847651504'),
       (8, 'Walla s Singz Junior', '(258) 846565883'),
       (9, 'sevilton sylvestre', '(258) 849181828'),
       (10, 'Tanvi Sachdeva', '(258) 84330678235'),
       (11, 'Florencio Samuel', '(258) 847602609'),
       (12, 'Solo Dolo', '(258) 042423566'),
       (13, 'Pedro B 173', '(258) 823747618'),
       (14, 'Ezequiel Fenias', '(258) 848826725'),
       (15, 'JACKSON NELLY', '(256) 775069443'),
       (16, 'Kiwanuka Budallah', '(256) 7503O6263'),
       (17, 'VINEET SETH', '(256) 704244430'),
       (18, 'Jokkene Richard', '(256) 7734127498'),
       (19, 'Ogwal David', '(256) 7771031454'),
       (20, 'pt shop 0901 Ultimo', '(256) 3142345678'),
       (21, 'Daniel Makori', '(256) 714660221'),
       (22, 'shop23 sales', '(251) 9773199405'),
       (23, 'Filimon Embaye', '(251) 914701723'),
       (24, 'ABRAHAM NEGASH', '(251) 911203317'),
       (25, 'ZEKARIAS KEBEDE', '(251) 9119454961'),
       (26, 'EPHREM KINFE', '(251) 914148181'),
       (27, 'Karim Niki', '(251) 966002259'),
       (28, 'Frehiwot Teka', '(251) 988200000'),
       (29, 'Fanetahune Abaia', '(251) 924418461'),
       (30, 'Yonatan Tekelay', '(251) 911168450'),
       (31, 'EMILE CHRISTIAN KOUKOU DIKANDA HONORE', '(237) 697151594'),
       (32, 'MICHAEL MICHAEL', '(237) 677046616'),
       (33, 'ARREYMANYOR ROLAND TABOT', '(237) 6A0311634'),
       (34, 'LOUIS PARFAIT OMBES NTSO', '(237) 673122155'),
       (35, 'JOSEPH FELICIEN NOMO', '(237) 695539786'),
       (36, 'SUGAR STARRK BARRAGAN', '(237) 6780009592'),
       (37, 'WILLIAM KEMFANG', '(237) 6622284920'),
       (38, 'THOMAS WILFRIED LOMO LOMO', '(237) 696443597'),
       (39, 'Dominique mekontchou', '(237) 691816558'),
       (40, 'Nelson Nelson', '(237) 699209115');

update customers customer
set country_id =(select country.id from countries country where customer.contact_phone ~ country.phone_regex)
where customer.id >= 0;

ALTER SEQUENCE customers_id_seq RESTART 41;