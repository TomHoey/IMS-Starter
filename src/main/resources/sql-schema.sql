drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`Customers` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`Items` (
	`pid` INT NOT NULL AUTO_INCREMENT,
    `productName` VARCHAR(40) NOT NULL,
    `price` float,
    PRIMARY KEY (`pid`)
    );
    
Create TABLE IF NOT EXISTS `ims`.`Order` (
	`oid` INT NOT NULL AUTO_INCREMENT,
    `productName` varchar(40),
    `Sub_Total` float not null,
    `Tax` float,
    Primary key (`oid`)
    );
    
Create TABLE IF NOT EXISTS `ims`.`Transactions` (
	`id` int NOT NULL PRIMARY KEY,
    `pid` int NOT NULL,
    `oid` int NOT NULL,
    `Quantity` int,
    `Price` float,
    Foreign Key (`pid`) references`Items` (`pid`),
    Foreign Key (`oid`) references `Order` (`oid`)
    );
    
ALTER TABLE `ims`.`Items` auto_increment = 100;
ALTER TABLE `ims`.`Order` auto_increment = 1000;