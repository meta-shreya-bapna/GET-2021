create database Storefront;
use Storefront;


/*Commands to create all tables*/
CREATE TABLE Products(
p_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
product_Title VARCHAR(100),
description VARCHAR(200),
category_id INT NOT NULL,
price DOUBLE,
discounted_price DOUBLE,
product_quantity INT
);

CREATE TABLE Administrator(
admin_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
admin_name CHAR(25),
admin_email VARCHAR(50) unique,
admin_password VARCHAR(15)
);

CREATE TABLE Orders(
order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
shopper_id INT,
total_price DOUBLE,
total_products INT,
order_date DATETIME NOT NULL,
order_status VARCHAR(25) NOT NULL,
FOREIGN KEY(shopper_id) REFERENCES Shopper(shopper_id)
);

CREATE TABLE Item_details(
p_id INT,
order_id INT,
item_shipped bool,
item_cancelled bool,
item_returned bool,
FOREIGN KEY(p_id) REFERENCES Products(p_id),
FOREIGN KEY(order_id) REFERENCES Orders(order_id)
);

CREATE TABLE Shopper(
shopper_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
s_first_name VARCHAR(100),
s_last_name VARCHAR(100),
s_email VARCHAR(100) unique,
s_contactNo BIGINT(10) NOT NULL unique
);

CREATE TABLE ProductCategory(
c_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(100)
);

create table SubCategories(
    subCatID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    categoryName varchar(100),
    c_id int,
    FOREIGN KEY(c_id) REFERENCES ProductCategory(c_id)
);

CREATE TABLE IMAGE(
image__id INT NOT NULL PRIMARY KEY Auto_Increment,
p_id INT,
image BLOB,
FOREIGN KEY(p_id) REFERENCES Products(p_id)
);

CREATE TABLE Shipping_Address(
shopper_id INT NOT NULL,
house_no VARCHAR(20),
street VARCHAR(100),
landmark VARCHAR(100),
city VARCHAR(100),
state VARCHAR(100),
country VARCHAR(100),
pincode INT,
FOREIGN KEY(shopper_id) REFERENCES Shopper(shopper_id)
);


/*setting constraint check false before deletion of products table because it has child tables,
and after deleting set contraint to true again*/
set FOREIGN_KEY_CHECKS = 0;
DROP TABLE Products;
set FOREIGN_KEY_CHECKS = 1;


/*once again creating products table*/
CREATE TABLE Products(
p_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
product_Title VARCHAR(100),
description VARCHAR(200),
category_id INT NOT NULL,
price DOUBLE,
discounted_price DOUBLE,
product_quantity INT,
added_on DATETIME
);

