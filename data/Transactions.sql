create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

insert into products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price)
VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price)
VALUES ('product_3', 'producer_3', 8, 115);

select * from products;
delete from products;

insert into products (name, count, price) VALUES ('product_4', 11, 64);
delete from products where price = 115;
update products set price = 75 where name = 'product_1';

select sum(count) from products;
update products set count = 26 where name = 'product_1';
select sum(count) from products;
update products set count = 26 where name = 'product_2';