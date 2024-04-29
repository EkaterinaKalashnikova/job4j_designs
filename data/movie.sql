create table customers
(
    id    serial primary key,
    name  varchar(50),
    address varchar(70),
    ordered_films varchar(100),
    gender varchar(10)
);

insert into customers (name, address, ordered_films, gender)
VALUES ('Ольга Егорова', '1й Казанский пер. 14', 'Пираты карибского моря; Матрица:Революция', 'женский');
insert into customers (name, address, ordered_films, gender)
VALUES ('Иванов Сергей', 'ул. Центральная 40 кв. 74', 'Человек, который изменил все; Интерстеллар', 'мужской');
insert into customers (name, address, ordered_films, gender)
VALUES ('Иванов Сергей', 'ул. Ленина 7 кв. 130', 'Матрица:Революция', 'мужской');

select * from customers;

create table orders
(
    id serial primary key,
    ordered_films varchar(100),
    address varchar(70)
);

create table full_name
(
    id serial primary key,
    name varchar(50),
    gender varchar(10),
    orders_id int references orders(id) unique
);

insert into orders (ordered_films, address)
VALUES ('Пираты карибского моря', '1й Казанский пер. 14');
insert into orders (ordered_films, address)
VALUES ('Матрица:Революция', '1й Казанский пер. 14');
insert into orders (ordered_films, address)
VALUES ('Матрица:Революция', 'ул. Ленина 7 кв. 130');
insert into orders (ordered_films, address)
VALUES ('Интерстеллар', 'ул. Центральная 40 кв. 74');
insert into orders (ordered_films, address)
VALUES ('Человек, который изменил все', 'ул. Центральная 40 кв. 74');

insert into full_name (name, gender, orders_id)
VALUES ('Ольга Егорова', 'женский', 1);
insert into full_name (name, gender, orders_id)
VALUES ('Ольга Егорова', 'женский', 2);
insert into full_name (name, gender, orders_id)
VALUES ('Иванов Сергей', 'мужской', 3);
insert into full_name (name, gender, orders_id)
VALUES ('Иванов Сергей', 'мужской', 4);
insert into full_name (name, gender, orders_id)
VALUES ('Иванов Сергей', 'мужской', 5);

select * from orders;
select * from full_name;

