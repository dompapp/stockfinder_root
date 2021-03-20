insert into manufacturer(manufacturer_name) values('AMD');

insert into product(product_name, product_max_price, product_manufacturer_id) values('Ryzen 9 5900X', 550.00, 1);
insert into product(product_name, product_max_price, product_manufacturer_id) values('Ryzen 9 5950X', 700.00, 1);

insert into product_url(product_url_uri, product_url_product_id) values('https://www.amd.com/en/direct-buy/5450881500/at', 1);
insert into product_url(product_url_uri, product_url_product_id) values('https://www.amd.com/en/direct-buy/5450881400/at', 2);



-- create table product_url
-- (
--     product_url_id integer not null
--         constraint product_url_pkey primary key,
--     product_id     integer
--         constraint product_url_product_id_fkey references product (product_id)
-- );