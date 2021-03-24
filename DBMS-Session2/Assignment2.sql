/*Displays Id, Title, Category Title, Price of the products which are Active
and recently added products should be at top.*/
select p.p_id, p.product_Title, pc.category_name,p.price
from Products p, productCategory pc
where  p.category_id=pc.c_id and p.product_quantity>0

order by p.added_on desc;

/*Display the list of products which don't have any images.*/
select p.product_Title 
from Products p, Image i
where p.p_id=i.p_id;


/*Display all Id, Title and Parent Category Title for all the Categories listed, 
sorted by Parent Category Title and then Category Title.*/
select sc.subCatID,sc.categoryName , IFNULL(pc.category_name,"Top Category") as Parent_Category_Title
from SubCategories sc
left join ProductCategory as pc on pc.c_id= sc.c_id

order by pc.category_name desc,sc.categoryName desc;


/*Display Id, Title, Parent Category Title of all the leaf Categories
(categories which are not parent of any other category)*/
select s.subCatID,s.categoryName as sub_category_Title,pc.category_name as Parent_category_Title
from SubCategories s, ProductCategory pc
where s.c_id=pc.c_id; 



/*Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)*/
select product_Title,description,price
from Products,ProductCategory
where Products.category_id=ProductCategory.c_id and  ProductCategory.category_name="Mobile";


/*Display the list of Products whose Quantity on hand (Inventory) is under 10*/
select product_Title as Product
from Products
where product_quantity<10;


