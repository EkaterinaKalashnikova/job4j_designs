create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create
or replace procedure insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
language 'plpgsql'
as $$
BEGIN
insert into products (name, producer, count, price)
values (i_name, prod, i_count, i_price);
END
$$;

call insert_data('product_2', 'producer_2', 15, 32);

select * from products;

create
    or replace procedure update_data(u_count integer, tax float, u_id integer)
    language 'plpgsql'
as $$
BEGIN
    if u_count > 0 THEN
        update products
        set count = count - u_count
        where id = u_id;
    end if;
    if
        tax > 0 THEN
        update products
        set price = price + price * tax;
    end if;
END;
$$;

call update_data(10, 0, 1);

call insert_data('product_1', 'producer_1', 3, 50);
call insert_data('product_3', 'producer_3', 8, 115);
call insert_data('product_3', 'producer_3', 0, 12);

call update_data(0, 0.2, 0);

alter procedure update_data(u_count integer, tax float, u_id integer) rename to update;

drop procedure update_data(u_count integer, tax float, u_id integer);

delete from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

create
    or replace procedure delete_data(u_count integer, u_id integer)
    language 'plpgsql'
as $$
BEGIN
    if u_count == 0 THEN
        DELETE FROM products
        WHERE id = u_id;
        end if;
END;
$$;

call delete_data(0);