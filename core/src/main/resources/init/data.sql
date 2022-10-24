insert into medical_card (id, client_status, med_status, registry_dt, comment) values (1, 'M', null, '2022-12-12', 'bad');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (2, 'M', 'F', '2022-11-11', 'very bad');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (3, 'M', null, '2022-10-10', 'very good');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (4, 'M', 'F', '2022-09-09', 'good');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (5, 'M', 'F', '2022-08-08', 'normal');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (6, 'M', 'F', '2022-08-26', 'normal');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (7, 'M', null, '2022-07-07', 'good');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (8, 'M', 'F', '2022-06-06', 'good');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (9, 'M', 'F', '2022-05-05', 'very bad');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (10, 'M', 'F', '2022-04-04', 'very bad');
insert into medical_card (id, client_status, med_status, registry_dt, comment) values (11, 'M', null, '2022-06-03', 'very bad');


insert into contact (id, phone_number, email, profile_link) values (1, '59(64)718-89-59', 'zuppawenaubi-4913@yopmail.com', 'dasj');
insert into contact (id, phone_number, email, profile_link) values (2, '779(5860)014-18-48', 'xijukoumotri-3379@yopmail.com', 'dasda');
insert into contact (id, phone_number, email, profile_link) values (3, '0(4729)383-24-22', 'moffifriloinna-4676@yopmail.com', 'fgd');
insert into contact (id, phone_number, email, profile_link) values (4, '9(14)750-86-49', 'brifouteunneitre-7351@yopmail.com', 'roygoehgo');
insert into contact (id, phone_number, email, profile_link) values (5, '97(9426)210-14-25', 'yaddoureiddaullou-5800@yopmail.com', null);
insert into contact (id, phone_number, email, profile_link) values (6, '476(816)674-31-48', 'cefasoraugo-8025@yopmail.com', null);
insert into contact (id, phone_number, email, profile_link) values (7, '2(068)308-41-36', 'noutammeusegoi-8314@yopmail.com', null);
insert into contact (id, phone_number, email, profile_link) values (8, '014(7394)614-93-97', 'braulloureussuppa-7367@yopmail.com', 'fskgnl');
insert into contact (id, phone_number, email, profile_link) values (9, '13(812)216-44-21', 'kewusoiffoutre-2145@yopmail.com', 'dfnsif');
insert into contact (id, phone_number, email, profile_link) values (10, '46(19)698-73-71', 'feucrunnevippa-3051@yopmail.com', 'reugoer');
insert into contact (id, phone_number, email, profile_link) values (11, '01(1377)213-38-35', 'cattacrepeivo-7576@yopmail.com', null);

insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (1, 1, 1, 'A', CURRENT_TIMESTAMP, CURRENT_DATE);
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (2, 1, 2, 'B', CURRENT_TIMESTAMP, CURRENT_DATE);
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (3, 2, 2, 'C', CURRENT_TIMESTAMP, CURRENT_DATE);
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (4, 2, 1, 'A', CURRENT_TIMESTAMP, CURRENT_DATE);
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (5, 3, 3, 'B', CURRENT_TIMESTAMP, CURRENT_DATE);
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (6, 4, 1, 'C', CURRENT_TIMESTAMP, CURRENT_DATE);
insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values (7, 5, 4, 'A', CURRENT_TIMESTAMP, CURRENT_DATE);

insert into address (id, contact_id, country_id, city, index, street, building, flat) values (1, 1, 1, 'Moscow', 1000, 'Red Square','1', '1');
insert into address (id, contact_id, country_id, city, index, street, building, flat) values (2, 2, 1, 'Saint-Petersburg', 1001, 'Nevskogo', '1', '2');
insert into address (id, contact_id, country_id, city, index, street, building, flat) values (3, 3, 1, 'Kaliningrad', 1002, 'Old Germany', '1', '3');
insert into address (id, contact_id, country_id, city, index, street, building, flat) values (4, 4, 1, 'Yaroslavl', 1003, 'Lenina', '2', '4');
insert into address (id, contact_id, country_id, city, index, street, building, flat) values (5, 5, 1, 'Volgograd', 1004, 'Stalinskaya', '3', '5');
insert into address (id, contact_id, country_id, city, index, street, building, flat) values (6, 6, 1, 'N. Novgorod', 1005, 'Sormovscaya', '3', '6');
insert into address (id, contact_id, country_id, city, index, street, building, flat) values (7, 7, 1, 'Kazan', 1006, 'Kazanskaya', '2', '7');
insert into address (id, contact_id, country_id, city, index, street, building, flat) values (8, 8, 2, 'Alma-Ata', 2000, 'Lenina', '1', '8');

insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
    values ('1', 'Ivanov', 'Ivan', '2002-01-01', '18', 'M', 1, 1, null);
insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
    values ('2', 'Ivanova', 'Masha', '2002-02-02', '18', 'F', 2, 2, null);
insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
    values ('3', 'Fedorov', 'Fedor', '2002-03-03', '18', 'M', 3, 3, null);
insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
    values ('4', 'Fedorova', 'Darya', '2002-04-04', '18', 'F', 4, 4, null);
insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
    values ('5', 'Grishin', 'Ghisha', '2002-01-01', '18', 'M', 6, 6, null);
insert into person_data(id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id)
    values ('6', 'Grishina', 'Tatyana', '2002-01-01', '18', 'M', 7, 7, null);