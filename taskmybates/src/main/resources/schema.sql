create table employees
(
    id integer SERIAL PRIMARY KEY not null,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    address varchar(255) not null
);