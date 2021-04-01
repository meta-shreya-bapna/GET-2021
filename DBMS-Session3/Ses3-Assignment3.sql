/*Display Shopper’s information along with number of orders he/she placed during last 60 days.*/
SELECT sh.shopper_id, sh.s_first_name, sh.s_last_name, COUNT(od.shopper_id) AS orders_in_last_30_days
FROM Shopper as sh INNER JOIN Orders as od
ON sh.shopper_id = od.shopper_id
WHERE od.order_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
GROUP BY od.shopper_id;


/*Display the top 2 Shoppers who generated maximum number of revenue in last 2 months.*/
SELECT sh.shopper_id, sh.s_first_name, sh.s_last_name,sum(od.total_price) as total_revenue
FROM Shopper as sh INNER JOIN Orders as od
ON sh.shopper_id = od.shopper_id
where od.order_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
and sh.shopper_id IN (select shopper_id from Orders
                    order by total_price desc)
group by od.shopper_id
limit 2;
                    

/*Display top 3 Products which are ordered most in last 60 days along with numbers.*/
SELECT p.p_id ,p.product_Title , COUNT(item.p_id) as product_count
FROM Products as p INNER JOIN Item_details as item
ON p.p_id = item.p_id
INNER JOIN Orders
ON item.order_id = Orders.order_id
WHERE Orders.order_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
GROUP BY item.p_id
ORDER BY product_count desc
LIMIT 3;



/*Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.*/
SELECT MONTHNAME(Orders.order_date) AS month , SUM(Orders.total_price) AS total_order
FROM Orders
WHERE Orders.order_date > (DATE_SUB(CURDATE(), INTERVAL 6 MONTH))
GROUP BY month(Orders.order_date);



/*Mark the products as Inactive which are not ordered in last 90 days.*/
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE Products 
ADD product_state varchar(8) DEFAULT "active"
AFTER description;

UPDATE Products as p
SET product_state = "inactive"
WHERE p.p_id IN 
    (SELECT Item_details.p_id
     FROM Orders INNER JOIN Item_details
     ON Orders.order_id= Item_details.order_id
     WHERE Orders.order_date < (DATE_SUB(CURDATE(), INTERVAL 3 MONTH))
    );

select product_Title, product_state from Products;

/*Given a category search keyword, display all the Products present in this category/categories. */
SELECT p.product_Title
FROM Products as p INNER JOIN ProductCategory as pc
ON p.category_id=pc.c_id
WHERE category_name = "Mobile";



/*Display top 3 Items which were cancelled most.*/
SELECT p.p_id , p.product_Title , COUNT(Item_details.item_cancelled) as cancel_count
FROM Products as p INNER JOIN Item_details
ON p.p_id = Item_details.p_id
WHERE Item_details.item_cancelled = true
GROUP BY Item_details.p_id
ORDER BY cancel_count DESC
LIMIT 3;