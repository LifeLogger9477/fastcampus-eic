SET foreign_key_checks = 0;

drop table if exists products;

create table products
(
  product_id  INT             NOT NULL AUTO_INCREMENT, 
  name        VARCHAR(100)    NOT NULL, 
  description VARCHAR(200)    NULL, 
  price       DECIMAL(10, 2)  NOT NULL, 
  PRIMARY KEY (product_id)
);

drop table if exists orders;

create table orders
(
  order_id    INT             NOT NULL AUTO_INCREMENT,
  customer_id INT             NOT NULL,
  ordered_at  DATETIME        NOT NULL, 
  PRIMARY KEY (order_id)
);

drop table if exists order_items;

create table order_items
(
  order_item_id   INT   NOT NULL AUTO_INCREMENT,
  product_id      INT   NOT NULL,
  order_id        INT   NOT NULL,
  order_quantity  INT   NOT NULL,
  PRIMARY KEY (order_item_id), 
  FOREIGN KEY (order_item_id) REFERENCES orders (order_id)
);

drop table if exists customers;

create table customers
(
  customer_id     INT           NOT NULL AUTO_INCREMENT,
  name            VARCHAR(100)  NOT NULL,
  phone_number    VARCHAR(100)  NULL,
  address         VARCHAR(100)  NOT NULL,
  PRIMARY KEY (customer_id)
);