INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`productName`, `price`) VALUES ('Coke', 1.50);
INSERT INTO `orders` (`oid`, `fk_cid`) VALUES (1, 1);
INSERT INTO `transactions` (`fk_oid`, `pid`, `quantity`) VALUES (1, 1, 1);