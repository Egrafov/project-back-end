Create database project;

CREATE TABLE products (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	category varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	price REAL,
	image_data BLOB
);

CREATE TABLE users (
	user_name VARCHAR(255) NOT NULL PRIMARY KEY,
	password VARCHAR(255),
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	phone VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	is_admin boolean NOT NULL
);

CREATE TABLE orders (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	order_date DATE NOT NULL,
	user_name VARCHAR(255),
	total_sum INTEGER NOT NULL,
	address varchar(255) NOT NULL,
	FOREIGN KEY (user_name) REFERENCES users (user_name)
);

CREATE TABLE inventory (
	product_id BIGINT PRIMARY KEY,
	available INTEGER DEFAULT 0,
	FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE order_products (
	order_id BIGINT,
	product_id BIGINT,
	quantity INTEGER NOT NULL,
	PRIMARY KEY (order_id, product_id),
	FOREIGN KEY (order_id) REFERENCES orders (id),
	FOREIGN KEY (product_id) REFERENCES products (id)
);

INSERT INTO
	products (category, name, description, price)
VALUES
	('Manicure', 'gel', 'gel polish', 12.4),
	('Manicure', 'gel', 'gel polish', 11),
	('Accesories', 'Brush', 'Brush for nails', 11.5),
	(
		'Accesories',
		'Accesories',
		'Accesories for Art',
		1.34
	);

INSERT INTO
	users (
		user_name,
		password,
		first_name,
		last_name,
		phone,
		address,
		is_admin
	)
VALUES
	('a', 'qqq', 'Eli', 'Cohen', '000', 'Haifa', true),
	('b', 'aaa', 'Li', 'Cohen', '001', 'TA', true),
	('c', 'zzz', 'Moshe', 'LEvi', '010', 'Ashkelon', false),
	(
		'd',
		'eee',
		'Israel',
		'Israeli',
		'001',
		'Nataniya',
		false
	);

INSERT INTO
	orders (order_date, user_name, total_sum, address)
VALUES
	('2023-06-22', 'a', 500, '123 Main St'),
	('2023-06-21', 'b', 750, '456 Elm St'),
	('2023-06-20', 'c', 1000, '789 Oak St');

INSERT INTO
	orders (order_date, user_name, total_sum, address)
VALUES
	('2023-06-22', 'a', 500, '123 Main St'),
	('2023-06-21', 'b', 750, '456 Elm St'),
	('2023-06-20', 'c', 1000, '789 Oak St');

INSERT INTO
	inventory (product_id, available)
VALUES
	(3, 22),
	(4, 12),
	(5, 22),
	(6, 32);

select
	*
from
	products;

select
	*
from
	order_products;

select
	*
from
	users;

select
	*
from
	inventory;

select
	*
from
	orders;

show tables;

drop table order_products;

drop table inventory;

drop table orders;

drop table products;

drop table users;

ALTER TABLE
	products CHANGE image_path image_data BLOB;

ALTER TABLE
	products
ADD
	COLUMN image VARCHAR(255);

INSERT INTO
	products (categories, description, price, image_path)
VALUES
	(
		'Manicure',
		"gel",
		19.99,
		'C:\Users\evgen\my-app\public\3.png'
	);

show keys
from
	inventory;

SELECT
	*
FROM
	inventory
	cross JOIN products ON inventory.product_id = products.id;

/* Inventory join with Products with empty rows*/
SELECT
	products.id,
	products.category,
	products.price,
	products.name,
	products.description,
	inventory.available
FROM
	products
	left JOIN inventory ON inventory.product_id = products.id;