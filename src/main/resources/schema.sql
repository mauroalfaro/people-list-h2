DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Store;

CREATE TABLE Customer (
    id varchar(11),
    name varchar(255),
    surname varchar(255),
    loyalty_id varchar(255),
    address varchar(255),
    phone varchar(255),
    email varchar(255)
);

CREATE TABLE Employee (
    id varchar(11),
    name varchar(255),
    surname varchar(255),
    address varchar(255),
    phone varchar(255),
    email varchar(255),
    date_hired varchar(255),
    is_active_employee tinyint(1)
);

CREATE TABLE Store (
    id varchar(11),
    name varchar(255),
    address varchar(255)
);