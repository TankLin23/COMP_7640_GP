create table customer
(
    customer_id      int auto_increment
        primary key,
    contact_number   varchar(20)  null,
    shipping_details varchar(255) null,
    password         varchar(10)  null
);

create table `order`
(
    o_id        int auto_increment
        primary key,
    customer_id int          null,
    o_date      date         null,
    status      varchar(255) null
);

create table orderitem
(
    order_item_id int auto_increment
        primary key,
    order_id      int null,
    product_id    int null,
    quantity      int null
);

create table product
(
    product_id   int auto_increment
        primary key,
    vendor_id    int           null,
    name         varchar(255)  null,
    listed_price decimal(8, 2) null,
    tag1         varchar(255)  null,
    tag2         varchar(255)  null,
    tag3         varchar(255)  null
);

create table vendor
(
    vendor_id             int auto_increment
        primary key,
    business_name         varchar(255)  null,
    feedback_score        decimal(4, 2) null,
    geographical_presence varchar(255)  null,
    password              varchar(10)   not null
);


