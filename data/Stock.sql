create table products (
     id serial primary key,
     name varchar(50),
     producer varchar(50),
     count integer default 0,
     price integer
);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

create trigger stand_trigger
    after insert
    on products
    for each row
    execute procedure stand();

create
or replace function stand()
    returns trigger as
$$
BEGIN
insert into history_of_price (name, price, date)
VALUES (NEW.name, NEW.price, localtimestamp);
return NEW;
END;
$$
LANGUAGE 'plpgsql';

insert into products (name, producer, count, price) VALUES ('перчатки', 'producer_1', 8, 12);
insert into products (name, producer, count, price) VALUES ('шапочка', 'producer_2', 3, 25);
insert into products (name, producer, count, price) VALUES ('курточка', 'producer_3', 10, 37);
insert into products (name, producer, count, price) VALUES ('платье', 'producer_4', 5, 50);
insert into products (name, producer, count, price) VALUES ('футболка', 'producer_5', 5, 20);
insert into products (name, producer, count, price) VALUES ('брюки', 'producer_6', 4, 45);

insert into history_of_price (price, name, date) VALUES (12, 'перчатки', localtimestamp);
insert into history_of_price (price, name, date) VALUES (25, 'шапочка', localtimestamp);
insert into history_of_price (price, name, date) VALUES (37, 'курточка', localtimestamp);
insert into history_of_price (price, name, date) VALUES (50, 'платье', localtimestamp);

create trigger taxa_trigger
    after insert
    on products
    referencing new table as
        inserted
    for each statement
execute procedure taxa();

create
    or replace function taxa()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.13
    where id = (select id from inserted);
    return new;
END;
$$
    LANGUAGE 'plpgsql';

alter table products disable trigger taxa_trigger;

create trigger pasting_trigger
    before insert
    on products
    for each row
execute procedure past();

create
    or replace function past()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.13;
    update history_of_price
    set price = price + price * 0.13;
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';

SELECT * FROM history_of_price;
SELECT * FROM products;
