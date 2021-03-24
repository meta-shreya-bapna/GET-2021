/*
Insertion of data into Products_Table
*/
INSERT INTO Products(product_Title,description,category_id, price,discounted_price, product_quantity) VALUES
                ("Moto G","Trending Phone in moto series",1,15000,12000, 5),
                ("Panasonic LED","Jalega toh ujala badhega",2, 45000,43500,9),
                ("Womens Jeans","Fully Stretchable",3, 2000,1900, 10),
                ("Apple iPhone 12 Pro Max", "Latest by apple",1,70000,69900,2),
                ("HP EliteBook", "Gives real feel with touch",4,100500,100000,15),
                ("Mens T-Shirt", "High quality cloth",3,200,200,20),
                ("OnePlus 8Pro", "Attractive Features",1,50000,50000,3);

/*
Insertion of data into Admin_panel
*/
INSERT INTO Administrator(admin_name,admin_email, admin_password) values ("admin1", "1@gmail.com",123),
                                                                         ("admin2", "2@gmail.com",1234),
                                                                         ("admin3", "3@gmail.com",12345);

/*
Insertion of shopper's details into Shopper_Table
*/
INSERT INTO Shopper(s_first_name,s_last_name,s_email,s_contactNo) values ("Shreya","Bapna","shreya987@gmail.com",9999921212),
                                                                         ("Kavya","Bapna","kavi@gmail.com",9000000002),
                                                                         ("Dhruv","Patel","pateldhruv@gmail.com",8829921212),
                                                                         ("Muskan","Duggad","muskaaaan@gmail.com",8888888888);
                       
       
#select * from Products;

/*
Insertion of data into Parent_categorie i.e.,Product_Category
*/
INSERT INTO ProductCategory(c_id,category_name) values(1,"Mobile"),
                                                      (2,"Electronic"),
                                                      (3,"Clothes"),
                                                      (4,"Laptop");

/*
Insertion of data into Sub_category 
*/
INSERT INTO SubCategories(subCatID,categoryName,c_id) values (1,"Television",2),
                                                             (2,"Formal",3),
                                                             (3,"Home Furniture",Null),
                                                             (4,"Smart Phones",1),
                                                             (5,"Keypad",1),
                                                             (6,"Cosmetics",Null),
                                                             (7,"Men's Wear",3),
                                                             (8,"Kids Wear",3),
                                                             (9,"Vegetables and fruits",Null);

#select * from SubCategories;


/*
Insertion of orders into Order's_Table
*/
INSERT INTO Orders(order_id,shopper_id,total_price,total_products,order_date,order_status) values (1, 2, 140500.00,8, "2021-01-04 14:29:36","active"),
                                                                                                  (2, 4, 5000.00,2, "2021-03-23 11:13:36","active"),
                                                                                                  (3, 1, 10050.00,4, "2021-02-04 10:29:26","not active"),
                                                                                                  (4, 1, 50,1, "2021-03-01 02:00:10","not active"),
                                                                                                  (5, 2, 2000,2, "2020-11-30 18:19:20","active"),
                                                                                                  (6, 3, 400,1, "2020-12-12 10:10:20","active");



/*
Insertion of items details present in Orders_table into Item_details_Table
*/
INSERT INTO Item_details(p_id,order_id,item_shipped,item_cancelled,item_returned) values (2,1,true,false,false),
                                                                                        (3,2,true,true,true),
                                                                                        (1,3,false,true,false),
                                                                                        (6,3,true,false,false),
                                                                                        (7,5,false,true,true),
                                                                                        (4,4,true,true,false),
                                                                                        (5,6,true,true,true),
                                                                                        (4,3,true,true,true),
                                                                                        (1,5,false,false,false);

/*
Insertion of data into Image_Table
*/
INSERT INTO IMAGE(p_id,image) values (3,2394873904534650763405043650475),
                                     (1,039493484023274363723723);
                                     
/*
Insertion of data into Shipping_Address
*/
INSERT INTO Shipping_Address (shopper_id, house_no, street, landmark, city, state, country, pincode)  VALUES 
                 (1, '64-A', 'Lotus Pond Street', 'School', 'Ahemdabad', 'Gujarat', 'India', 622020),
                 (2, '740-C', 'Shastri Nagar', 'School', 'Bhilwara', 'Rajasthan', 'India', 311001),
                 (3, '74/20', 'Shipra Path', 'School', 'Jaipur', 'Rajasthan', 'India', 302020),
                 (4, '80', 'Green Lane', 'Public Park', 'Bangalore', 'Karnataka', 'India', 701020),
                 (3, '123-D', 'Raja Park', 'Restaurant', 'Jaipur', 'Rajasthan', 'India', 301020),
                 (2, '100/A', 'Bapu Nagar', 'Dairy', 'Bhilwara', 'Rajasthan', 'India', 311001);