DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Store;

CREATE TABLE Customer (
    id varchar(11),
    name varchar(255),
    surname varchar(255),
    loyaltyId varchar(255),
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
    dateHired varchar(255),
    activeEmployee tinyint(1)
);

CREATE TABLE Store (
    id varchar(11),
    name varchar(255),
    address varchar(255)
);