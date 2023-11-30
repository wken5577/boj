-- 코드를 입력하세요

select d.FLAVOR from (
select c.FLAVOR, max(c.total) as total from 
(
select a.FLAVOR, a.july_sum + a.half_sum as total from (
SELECT july.FLAVOR, sum(july.TOTAL_ORDER) as july_sum, sum(FIRST_HALF.TOTAL_ORDER) as half_sum from july 
    left join FIRST_HALF on july.SHIPMENT_ID = FIRST_HALF.SHIPMENT_ID group by july.FLAVOR ) a
union
select b.FLAVOR, b.july_sum + b.half_sum as total from (
SELECT july.FLAVOR, sum(july.TOTAL_ORDER) as july_sum, sum(FIRST_HALF.TOTAL_ORDER) as half_sum from july 
    right join FIRST_HALF on july.SHIPMENT_ID = FIRST_HALF.SHIPMENT_ID group by july.FLAVOR ) b 
)c group by c.FLAVOR 
)d order by d.total desc limit 3;


    
# select * from july;