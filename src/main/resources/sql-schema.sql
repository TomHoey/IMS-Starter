DROP SCHEMA IF EXISTS `ims`;

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
    `price` double,
    PRIMARY KEY (`pid`)
    );
    
Create TABLE IF NOT EXISTS `ims`.`Order` (
	`id` int NOT NULL,
    `oid` INT NOT NULL AUTO_INCREMENT,
    Primary key (`oid`),
    Foreign key (`id`) references `Customers` (`id`)
    );
    
Create TABLE IF NOT EXISTS `ims`.`Transactions` (
	`id` int NOT NULL,
    `pid` int NOT NULL,
    `oid` int NOT NULL,
    `quantity` int,
    `Total` double,
	Foreign key (`id`) references `Customers` (`id`),
    Foreign Key (`pid`) references`Items` (`pid`),
    Foreign Key (`oid`) references `Order` (`oid`)
    );
    
ALTER TABLE `ims`.`Items` auto_increment = 100;
ALTER TABLE `ims`.`Order` auto_increment = 1000;
