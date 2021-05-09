select city_name as cityName, floor(avg(revenue)) as revenue from
cities c JOIN revenue r on c.city_code = r.city_code
group by city_name;

