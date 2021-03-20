create table manufacturer
(
    manufacturer_id   serial not null
        constraint manufacturer_pkey primary key,
    manufacturer_name varchar(50)
);

create table product
(
    product_id              serial not null
        constraint product_pkey primary key,
    product_name            varchar(50),
    product_max_price       double precision,
    product_manufacturer_id integer
        constraint product_manufacturer_id_fkey references manufacturer (manufacturer_id)
);

create table product_url
(
    product_url_id  serial not null
        constraint product_url_pkey primary key,
    product_url_uri varchar(100),
    product_url_product_id      integer
        constraint product_url_product_id_fkey references product (product_id)
);
