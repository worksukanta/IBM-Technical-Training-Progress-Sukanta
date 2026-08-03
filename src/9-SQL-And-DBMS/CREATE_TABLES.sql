-- customer_id: INT [PK]
-- first_name: VARCHAR(50)
-- last_name: VARCHAR(50)
-- email: VARCHAR(100)
-- created_atORDERS
CREATE TABLE customer (
    customer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);


-- ORDERS
-- order_id: INT [PK]
-- customer_id: INT [FK]
-- order_date: DATETIME
-- total_amount: DECIMAL
-- status: VARCHAR(20)
create table orders (
	order_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	customer_id int references customer(customer_id),
	order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	total_amount DECIMAL(10, 2) NOT NULL,
	status VARCHAR(20) NOT NULL
);

-- Product_id: INT [PK]
-- product_name: VARCHAR(100)
-- sku: VARCHAR(50)
-- price: DECIMAL(10,2)
-- stock_qty: INT
CREATE TABLE product(
	product_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	product_name VARCHAR(100) NOT NULL,
	sku VARCHAR(50) UNIQUE NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	stock_qty INT NOT NULL
);

-- order_item_id: INT [PK]
-- order_id: INT [FK]
-- product_id: INT [FK]
-- quantity: INT
-- price_per_unit: DECIMAL
CREATE TABLE order_item(
	order_item_id INT GENERATED ALWAYS AS IDENTITY,
	order_id INT REFERENCES orders(order_id),
	product_id INT REFERENCES product(product_id),
	quantity INT NOT NULL,
	price_per_unit DECIMAL(10,2) NOT NULL
);



