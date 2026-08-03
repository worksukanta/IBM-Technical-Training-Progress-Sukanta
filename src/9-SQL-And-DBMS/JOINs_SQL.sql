SELECT 
    t1.emp_id, t1.name as Fullstack_Devs
FROM frontend_developers t1
inner JOIN backend_developers t2 ON t1.emp_id = t2.emp_id;
-- where t1.emp_id is not null and t2.emp_id is not null;

-- SELECT 
--   	t1.emp_id, t1.name as frontend_dev 
-- 	from frontend_developers t1
-- LEFT JOIN backend_developers t2 ON t1.emp_id = t2.emp_id
-- where t2.emp_id is null;

-- SELECT 
--   	t2.emp_id, t2.name as backend_dev 
-- 	from frontend_developers t1
-- RIGHT JOIN backend_developers t2 ON t1.emp_id = t2.emp_id
-- where t1.emp_id is null;

