Use storefront;

/*Create a view displaying the order information (Id, Title, Price, Shopper’s name, 
Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.*/
CREATE OR REPLACE VIEW orders_in_past_60_days
	AS
		SELECT Orders.order_id, p.p_id,p.product_Title,p.price, sh.s_first_name, sh.s_last_name, sh.s_email, Orders.order_date, Orders.order_status, Item_details.item_shipped
		FROM Orders, Products as p,Shopper as sh, Item_details
    WHERE Orders.order_id=Item_details.order_id AND Item_details.p_id= p.p_id AND Orders.shopper_id=sh.shopper_id AND Orders.order_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))

    ORDER BY Item_details.order_id DESC;
    
        
        
SELECT * FROM orders_in_past_60_days;



/*Use the above view to display the Products(Items) which are in ‘shipped’ state.*/
SELECT product_Title
FROM orders_in_past_60_days 
WHERE item_shipped=true;



/*Use the above view to display the top 2 most selling products.*/
SELECT product_Title, COUNT(product_Title) AS quantity_sold
FROM orders_in_past_60_days
GROUP BY product_Title
ORDER BY quantity_Sold DESC
LIMIT 2;