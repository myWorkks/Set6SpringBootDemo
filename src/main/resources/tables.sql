drop schema if exists product_ms;

create schema product_ms;

use product_ms;
drop table if exists product;
create table product(

product_id int primary key  auto_increment ,
product_name varchar(50),
product_quanity int,
product_price decimal(8,2),
discount_percent decimal(5,2),
product_description varchar(200),
brand_name varchar(30)

);

create table primary_key(
g_key varchar(50) primary key,
g_value int);
);