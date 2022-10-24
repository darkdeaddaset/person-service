select * from person_data persons
order by persons
limit (select (count(*)/2)
       from person_data)