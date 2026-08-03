BEGIN; -- Start the transaction block

-- Step 1: Create the new order record
INSERT INTO orders (customer_id, order_date, total_amount, status)
VALUES (1, CURRENT_TIMESTAMP, 2499.50, 'Pending');

-- Step 2: Deduct 1 mouse from the product warehouse inventory stock
UPDATE product
SET stock_qty = stock_qty - 1
WHERE product_id = 2;

COMMIT; -- Permanently save both operations to the disk storage
