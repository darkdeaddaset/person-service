create or replace view clients as
    select t1.id,
           t3.last_name,
           t3.first_name,
           t2.city,
           t1.phone_number,
           t1.email,
           t3.birth_dt,
           t3.age,
           t3.sex
from contact as t1
left join address as t2 on t1.id = t2.contact_id
left join person_data as t3 on t1.id = t3.contact_id;