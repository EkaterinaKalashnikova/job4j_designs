create table history_of_price (
                                  id    serial primary key,
                                  name  varchar(50),
                                  price integer,
                                  date  timestamp
);
create trigger taxa_trigger
    after insert
    on history_of_price
    referencing new table as
                    inserted
    for each statement
execute procedure taxa();

create
or replace function taxa()
    returns trigger as
$$
BEGIN
update history_of_price
set price = price + price * 0.13
where id = (select id from inserted);
return new;
END;
$$
LANGUAGE 'plpgsql';

create trigger taxis_trigger
    before insert
    on history_of_price
    for each row
    execute procedure taxis();

create
or replace function taxis()
    returns trigger as
$$
BEGIN
update products
set price = price + price * 0.13
    AND true;
return NEW;
END;
$$
LANGUAGE 'plpgsql';

create trigger bring_trigger
    after insert
    on history_of_price
    for each row
    execute procedure bring();

create
or replace function bring()
    returns trigger as
$$
BEGIN
update history_of_price
set price = price, name = name, "date" = date
    AND true;
return NEW;
END;
$$
LANGUAGE 'plpgsql';

insert into history_of_price (price, name, date)
VALUES ('12', 'перчатки', '2024-04-15T19:10:12.031Z');
insert into history_of_price (price, name, date)
VALUES ('25', 'шапочка', '2024-04-15T19:10:12.031Z');
insert into history_of_price (price, name, date)
VALUES ('37', 'курточка', '2024-04-15T19:10:12.031Z');
insert into history_of_price (price, name, date)
VALUES ('50', 'платье', '2024-04-15T19:10:12.031Z');