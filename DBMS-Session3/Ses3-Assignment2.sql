/*
Count of products as per below price range
return the Count of products as per below price range:
Range in Rs.  Count
0 - 100
101 - 500
Above 500
*/
SELECT 
  CASE 
    WHEN price BETWEEN 0 AND 100 THEN '0-100'
    WHEN price BETWEEN 101 AND 500 THEN '101-500'
    else 'above 500'
  END AS `Range in rs`,
  count(1) AS `Count`
FROM products
GROUP BY `Range in rs`;



/*Display the Categories along with number of products under each category.*/
SELECT c.category_name,count(p.category_id) AS no_of_products
FROM Products p INNER JOIN ProductCategory c
ON p.category_id=c.c_id
GROUP BY c.c_id;

