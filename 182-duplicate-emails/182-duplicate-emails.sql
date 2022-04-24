# Write your MySQL query statement below


# select Email
# from Person
# group by Email
# having count(*) > 1

# SELECT DISTINCT p1.Email
# FROM Person p1, Person p2
# WHERE p1.Email = p2.Email and p1.id != p2.id
# ;

SELECT DISTINCT p1.Email
FROM Person p1 join Person p2
ON p1.Email=p2.Email AND p1.Id <> p2.Id; 