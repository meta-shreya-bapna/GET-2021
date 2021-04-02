/*
 retrieve average sales of each product in a month
 @param-month and year
*/
delimiter $$
create procedure avg_sale(month int,year int)
    begin
select 
    od.p_id, p.product_Title, count(od.p_id)/30
from
    Orders o,
    Item_details od,
    Products p
where
    o.order_id = od.order_id and od.p_id = p.p_id and extract(MONTH from o.order_date) = month and extract(YEAR from o.order_date) = year group by od.p_id;
    end$$

delimiter ;
/*
call the procedure
*/
call avg_sale(3,2021);



/*
retrieve table having order detail with status for a given period
@param - start_date and end_date in 'YYYY-MM-DD' format
*/
delimiter $$
create procedure order_details(start_date date,end_date date)
begin
select p.p_id,p.product_Title,case when od.item_shipped = true then 'shipped'
when od.item_cancelled = true then 'cancelled'
when od.item_returned = true then 'returned'
else 'processed'
end as status from Orders o,Item_details od,Products p where o.order_id = od.order_id and p.p_id = od.p_id and case
when start_date > end_date then date(o.order_date) between start_date-DAY(start_date)+1 and end_date
else date(o.order_date) between start_date and end_date
end;
end$$
delimiter ;



/*
call the procedure
*/
call order_details('2021-02-01','2021-03-17');