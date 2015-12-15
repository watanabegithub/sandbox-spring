create table product (
    product_code int(5),
    product_name varchar(50),
    price int(10),

    primary key (product_code)
);

create table purchase (
    purchase_code int(5),
    purchase_date date,
    purchaser varchar(50),

    primary key (purchase_code)
);

create table purchase_detail (
    seq int(5) not null auto_increment,
    purchase_code int(5),
    product_code int(5),
    purchase_count int(5),

    primary key (seq),
    foreign key(purchase_code)
        references purchase(purchase_code),
    foreign key(product_code)
        references product(product_code)
);

create unique index purchase_detail_key1
    on purchase_detail (
        purchase_code,
        product_code
);
