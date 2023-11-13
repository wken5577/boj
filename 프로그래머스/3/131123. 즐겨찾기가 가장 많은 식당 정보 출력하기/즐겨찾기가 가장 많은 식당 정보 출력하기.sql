-- 코드를 입력하세요

select p.FOOD_TYPE, p.REST_ID, p.REST_NAME, p.FAVORITES from (
SELECT 
        FOOD_TYPE, 
        REST_ID, 
        REST_NAME, 
        FAVORITES ,
        ROW_NUMBER() OVER(PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC) AS RN
    FROM 
        REST_INFO
)p where RN = 1 order by FOOD_TYPE desc;