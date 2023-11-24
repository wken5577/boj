-- 코드를 입력하세요
select * from (
select a.M MONTH, a.car_id CAR_ID, count(*) RECORDS from(
select MONTH(start_date) M, CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY where CAR_ID in(
select c.ci from(
SELECT car_id ci, count(*) r from CAR_RENTAL_COMPANY_RENTAL_HISTORY where START_DATE between '2022-08-01' and '2022-10-31' group by car_id having r >= 5) c) and START_DATE between '2022-08-01' and '2022-10-31'
) a group by a.M, a.car_id order by MONTH asc, CAR_ID desc) t where t.RECORDS > 0;


# select c.ci from(
# SELECT car_id ci, count(*) r from CAR_RENTAL_COMPANY_RENTAL_HISTORY where START_DATE between '2022-08-01' and '2022-10-31' group by car_id having r >= 5) c;


# SELECT * from CAR_RENTAL_COMPANY_RENTAL_HISTORY where START_DATE between '2022-10-01' and '2022-10-31' and car_id = 21;

