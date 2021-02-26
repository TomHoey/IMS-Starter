DROP TABLE IF EXISTS `Transactions`;
DROP TABLE IF EXISTS `Orders`;
DROP TABLE IF EXISTS `Items`;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `Items` (
	`pid` INT NOT NULL AUTO_INCREMENT,
    `productName` VARCHAR(40) NOT NULL,
    `price` double,
    PRIMARY KEY (`pid`)
    );
    
Create TABLE IF NOT EXISTS `Orders` (
    `oid` INT (20) NOT NULL AUTO_INCREMENT, 
    Primary key (`id`),
    `fk_cid` int not null,
    foreign key (`fk_cid`) references Customers (`id`) On DELETE CASCADE
    );
    
Create TABLE IF NOT EXISTS `Transactions` (
    `fk_oid` int NOT NULL,
    `pid` int NOT NULL,
    `quantity` int,
     Foreign Key (`fk_oid`) references `Orders` (`oid`) on DELETE CASCADE,
     Foreign Key (`pid`) references`Items` (`pid`) on DELETE CASCADE
    );
    
);