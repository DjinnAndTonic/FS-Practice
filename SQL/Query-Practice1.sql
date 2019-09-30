/*Write a query to get Product name and quantity/unit.*/
Select ProductName, UnitsInStock
	From products
	
/*Write a query to get current Product list (Product ID and name).*/
Select ProductID, ProductName
	from products
	where discontinued = 0
	
/*Write a query to get discontinued Product list (Product ID and name)*/
Select ProductID, ProductName
	from products
	Where discontinued = 1

/*Write a query to get most and least expensive Product list (name and unit price)*/
Select productname, unitprice
	from products
	where unitprice = (Select min(unitPrice) from products)
	or unitprice = (Select max(unitprice) from products)

/*Write a query to get Product list (id, name, unit price) where current products cost less than $20*/
Select ProductID, ProductName, UnitPrice
	from products
	Where unitPrice < 20
	AND discontinued = 0

/*Write a query to get Product list (id, name, unit price) where products cost between $15 and $25*/
Select ProductID, ProductName, UnitPrice
	from products
	Where unitPrice between 15 and 25
	
/*Write a query to get Product list (name, unit price) of above average price*/
Select ProductName, UnitPrice
	from products
	Where unitPrice > (Select Avg(unitPrice) from products)

/*Write a query to get Product list (name, unit price) of ten most expensive products*/
Select ProductName, UnitPrice
	from products
	Order By UnitPrice DESC
	Limit 10

/*Write a query to count current and discontinued products*/
Select
	(Select Count(*)
		from products
		where discontinued = 0) as NumCurrentProducts,
	(Select Count(*)
		from products
		Where discontinued = 1)  as NumDiscontinuedProducts
	from products limit 1

/*Write a query to get Product list (name, units on order , units in stock) of stock is less than the quantity on order*/
Select ProductName, UnitsOnOrder, UnitsInStock
	from Products
	Where UnitsInStock < UnitsOnOrder