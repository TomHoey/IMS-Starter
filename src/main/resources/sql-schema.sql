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
    
Create TABLE IF NOT EXISTS `ims`.`Orders` (
    `oid` INT (20) NOT NULL AUTO_INCREMENT, 
    Primary key (`oid`),
    `fk_cid` int not null,
    constraint `fk_cid` foreign key (`fk_cid`) references Customers (`id`)
    );
    
Create TABLE IF NOT EXISTS `ims`.`Transactions` (
    `fk_oid` int NOT NULL,
    `pid` int NOT NULL,
    `quantity` int,
     Foreign Key (`fk_oid`) references `Orders` (`oid`),
     Foreign Key (`pid`) references`Items` (`pid`)
    );
    
ALTER TABLE `ims`.`Items` auto_increment = 100;
ALTER TABLE `ims`.`Orders` auto_increment = 1000;
