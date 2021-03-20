create table product
(
    product_id        integer not null
        constraint product_pkey
            primary key,
    product_name      varchar(50),
    product_max_price double precision
);

create table product_url
(
    product_url_id integer not null
        constraint product_url_pkey
            primary key,
    product_id     integer
        constraint product_url_product_id_fkey
            references product
);

