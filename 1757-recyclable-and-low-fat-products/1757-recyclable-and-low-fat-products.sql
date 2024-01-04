# Write your MySQL query statement below



SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y'
ORDER BY product_id
DESC






# Products{
# product_id : int, 
# low_fats : enum
# }
