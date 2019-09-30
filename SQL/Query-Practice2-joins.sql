SELECT products.ProductID, products.ProductName, suppliers.companyName
FROM products
JOIN suppliers ON products.supplierID = suppliers.supplierid
	
SELECT products.productname, `order details`.orderid, customers.companyname
FROM products
JOIN `order details` ON products.ProductID = `order details`.productID
JOIN orders ON `order details`.orderID = orders.OrderID
JOIN customers ON orders.CustomerID = customers.CustomerID

select `order details`.orderid, customers.companyname, sum(`order details`.quantity) as TotalProductsOrdered
from `order details`
join orders on `order details`.orderID = orders.OrderID
join customers on orders.CustomerID = customers.CustomerID
group by orderid
