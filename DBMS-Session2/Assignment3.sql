#Display Recent 3 Orders placed (Id, Order Date, Order Total).
select order_id,order_date,total_price as order_total
from Orders
order by order_date desc
Limit 3;


#Display 3 most expensive Orders
select order_id,total_price as order_total
from Orders
order by total_price desc
Limit 3;


/*Display all the Orders which are placed more than 10 days old 
and one or more items from those orders are still not shipped.*/
select p.product_Title as product_name, o.order_id
from Products p, Orders o, Item_details item
where p.p_id=item.p_id and item.order_id=o.order_id and DATEDIFF( curdate(),o.order_date)>10 and item.item_shipped=false;


/*Display list of shopper which haven't ordered anything since last month.*/
select distinct(shopper_id), s_first_name,s_last_name
from Shopper 
where shopper_id NOT IN
(select shopper_id from Orders  
 where DATEDIFF(curdate(),order_date)<30);


/*Display list of shopper along with orders placed by them in last 15 days.*/
select s.s_first_name,s.s_last_name,o.order_id,o.total_price,o.total_products
from Shopper s,Orders o
where s.shopper_id=o.shopper_id and DATEDIFF(curdate(),o.order_date)<15;


/*Display list of order items which are in “shipped” state for particular Order Id (i.e.: 3))*/
select p.product_Title as product_name
from Products p, Item_details item
where p.p_id=item.p_id and item.order_id=3 and item.item_shipped=true;


/*Display list of order items along with order placed date which fall between Rs 100 to Rs 6000 price.*/
select p.product_Title as product_name, o.order_date as Order_date
from Products p, Orders o, Item_details det
where p.p_id=det.p_id and o.order_id=det.order_id and p.price between 100 and 6000;