
create database if not exists vendor_customer;

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
    o_id            int auto_increment
        primary key,
    customer_id     int          null,
    status          varchar(255) null,
    vendor_name     varchar(255) null,
    vendor_id       int          null,
    quantity        int          null,
    price           decimal      null,
    product_name    varchar(255) null,
    feedback_status int          null
);

create table product
(
    product_id       int auto_increment
        primary key,
    vendor_id        int           null,
    name             varchar(255)  null,
    listed_price     decimal(8, 2) null,
    tag1             varchar(255)  null,
    tag2             varchar(255)  null,
    tag3             varchar(255)  null,
    product_quantity int           null
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

insert into customer values (12345,'23569874','6','123456');
insert into `order` values (1,12345,'unshipped','HKBU','12345','1','1999','Phone','0');
insert into `order` values (2,12345,'shipped','HKBU','12345','1','1999','Phone','1');
insert into `order` values (4,12345,'unshipped','HKBU','12345','1','1999','Phone','0');
insert into `order` values (5,12345,'unshipped','HKU','12359','2','6000','iPad','0');
insert into `order` values (6,12345,'unshipped','HKU','12359','1','1999','iPad','0');
insert into product values (1,'12345','Phone','2000','digital products','cost performance','fashion','1000');
insert into product values (1,'12359','iPad','3000','digital products','cost performance','fashion','996');
insert into vendor values (12345,'HKBU',1.1,'HongKong','123456');
insert into vendor values (12346,'zhongshan',1.0,'HongKong','12345');
insert into vendor values (12348,'Tsinghua',1.1,'HongKong','123456');
insert into vendor values (12359,'cityU',1.1,'HongKong','123456');
insert into vendor values (12347,'polyU',1.1,'HongKong','123456');



