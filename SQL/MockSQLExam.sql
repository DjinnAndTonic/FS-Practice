-- 1
Select orders.*
from orders
join users on orders.USER_ID = users.USER_ID
where users.FIRST_NAME = "Marion"

-- 2
Select *
from users
where not exists
	(select user_id from orders where orders.USER_ID = users.USER_ID)

Select users.*
from users
left join orders on users.user_id = orders.user_id
where orders.user_id is null

-- 3
Select name, price
from items
join order_items oi on items.ITEM_ID = oi.ITEM_ID
group by oi.item_id having count(oi.item_id) >= 2

-- 4
Select o.order_id, i.name, i.price, oi.quantity
from items i
join order_items oi on i.ITEM_ID = oi.ITEM_ID
join orders o on oi.ORDER_ID = o.ORDER_ID
join stores s on o.STORE_ID = s.STORE_ID
where s.CITY = "New York"
order by o.order_id ASC

-- 5
Select i.name as ITEM_NAME, sum(oi.QUANTITY * i.price) as REVENUE
from items i
join order_items oi on i.ITEM_ID = oi.ITEM_ID
group by i.item_id

-- 6
Select s.NAME, count(o.store_id) as ORDER_QUANTITY,
case
	when count(o.STORE_ID) > 3 then "High"
	when count(o.STORE_ID) >= 2 then "Medium"
	else "Low"
end as "SALES_FIGURE"
from orders o
join stores s on o.STORE_ID = s.STORE_ID
group by o.STORE_ID
order by ORDER_QUANTITY DESC
