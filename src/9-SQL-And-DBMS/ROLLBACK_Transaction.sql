BEGIN; -- Start the transaction block

-- Step 1: Create the new order record
INSERT INTO orders (customer_id, order_date, total_amount, status)
VALUES (2, CURRENT_TIMESTAMP, 7999.00, 'Pending');
INSERT INTO orders (customer_id, order_date, total_amount, status)
VALUES (2, CURRENT_TIMESTAMP, '9999.00', 'Pending');

-- Step 2: The system detects that headphones (ID 5) have a stock_qty of 0.
-- To prevent an invalid business state, we force a manual cancellation.

ROLLBACK; -- Aborts the transaction. The order row from Step 1 is erased completely.
