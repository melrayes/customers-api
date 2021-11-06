create table if not exists countries
(
	id bigserial not null
		constraint countries_pkey
			primary key,
	name varchar(255),
	phone_regex varchar(255)
);


create table if not exists customers
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




