create table if not exists users
(
    id  bigserial
        primary key,
    login          varchar(255),
    password      varchar(255));

create table if not exists user_role
(
    user_id bigint not null
        constraint fk_user_role
            references users,
    roles   integer
);