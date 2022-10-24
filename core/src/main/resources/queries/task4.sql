insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
values ('50', 'Ivanov', 'Ivan', '2002-01-01', '18', 'M', 1, 1, null);
insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
values ('51', 'Ivanova', 'Masha', '2002-01-01', '18', 'F', 2, 2, null);
insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
values ('52', 'Fedorov', 'Fedor', '2002-01-01', '18', 'M', 3, 3, null);

delete from person_data
where id not in
      (
        select id from (
        select min(id) as id
        from person_data
        group by last_name, first_name) as res
    );