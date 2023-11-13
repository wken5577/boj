-- 코드를 입력하세요
select count (p.NAME) from (SELECT distinct NAME from ANIMAL_INS where NAME is not null) p;
