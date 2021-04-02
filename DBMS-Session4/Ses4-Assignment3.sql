/*creating index for the most used column in these three tables*/
create index productId_index on  products(p_id);
create index order_index on orders(order_id,order_date);
create index category_index on SubCategories(subCatID,c_id);