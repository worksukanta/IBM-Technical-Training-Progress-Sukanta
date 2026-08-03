-- 1. Insert Dummy Customers (Notice first/last names can be left NULL)
INSERT INTO customer (first_name, last_name, email) VALUES
('Aarav', 'Sharma', 'aarav.sharma@example.com'),
('Diya', 'Patel', 'diya.patel@example.com'),
(NULL, NULL, 'anonymous.shopper@example.com'),
('Rohan', 'Das', 'rohan.das@example.com'),
('Ananya', NULL, 'ananya.k@example.com');

-- 2. Insert Dummy Products
INSERT INTO product (product_name, sku, price, stock_qty) VALUES
('Wireless Mechanical Keyboard', 'KB-MECH-01', 4999.00, 50),
('Ergonomic Wireless Mouse', 'MS-ERGO-02', 2499.50, 120),
('UltraWide 27-inch Monitor', 'MN-27UW-03', 18999.00, 15),
('USB-C Multi-Port Hub', 'HB-USBC-04', 1599.00, 200),
('Noise Cancelling Headphones', 'HP-ANC-05', 7999.00, 0);

-- 3. Insert Dummy Orders (Linking to customer_id 1, 2, 4, and 5)
INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES
(1, '2026-08-01 10:15:00', 7498.50, 'Shipped'),
(2, '2026-08-02 14:30:00', 18999.00, 'Processing'),
(4, '2026-08-02 16:45:00', 1599.00, 'Pending'),
(5, '2026-08-03 09:00:00', 9598.00, 'Delivered');

-- 4. Insert Dummy Order Items (Linking orders to products with correct prices)
INSERT INTO order_item (order_id, product_id, quantity, price_per_unit) VALUES
-- Items for Order 1 (Total: 4999.00 + 2499.50 = 7498.50)
(1, 1, 1, 4999.00),
(1, 2, 1, 2499.50),

-- Items for Order 2 (Total: 18999.00)
(2, 3, 1, 18999.00),

-- Items for Order 3 (Total: 1599.00)
(3, 4, 1, 1599.00),

-- Items for Order 4 (Total: 1599.00 * 1 + 7999.00 * 1 = 9598.00)
(4, 4, 1, 1599.00),
(4, 5, 1, 7999.00);
