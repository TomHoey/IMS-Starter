Coverage: 66.3%
Inventory Management System

The product is designed to intake a customers first and last name and supply them with a customer ID. It is also designed to store products, providing each product with a unique PID (Product ID), a product name, and a price. Using these, the product is designed to create an order, linking the customers' ID to the order. Then, using that a uniquely generated Order ID that is linked to their Customer ID, they can add items to an order and received a Total Price for their order.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
To get this software up and running on your system you will need:
1) Eclipse IDE on Java version 14. The link can be found here https://www.eclipse.org/ide/ with the download button in top right.
2) You will then need Maven installed which can be found here https://maven.apache.org/download.cgi. It is recommended to install source zip, 3.6.3.
3) Lastly, you will also need a MySQL installed, it is personal preference whether you use the CMD to access it or the workbench. The link to download is here https://www.mysql.com/downloads/
```

### Installing
```
1) Have all of the above installed.
2) Fork this repository over to your own repository on Github
3) Using GitBash you can clone a copy of the repository down to your local machine.
4) Opening your Eclipse IDE, click file then open projects from file system.
5) Find where you cloned your local repository and select it to open it as a project on Eclipse.
6) You will then need to set up the database. Go to IMS-Starter - src/main/resources - db.properties. Changed the user and password to what you assigned your SQL when you installed it.
7) Then, using the SQL-Schema.sql in the same location as before, double click that to launch an instance within your SQL workbench (if you have it).

Hopefully you should have the project in Eclipse, and the Databases set up with the correct identifiers.
Now, in Eclipse, if you click on the IMS-Starter project - src/main/java - com.qa.ims, you should see a file called runner. Right click on this and run as a Java application.
This will prompt you with a console, in here you can enter the pathway you want.

For example - 
Welcome to the Inventory Management System!
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application

(SELECTION) - CUSTOMER

What would you like to do with customer:
CREATE: To save a new entity into the database 
READ: To read an entity from the database
SELECTONE: To read a singular entry from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection

(SELECTION) - READ

ID: 1 | First Name: Tom | Surname: Hoey
ID: 2 | First Name: Bill | Surname: Pipe
What would you like to do with customer:
CREATE: To save a new entity into the database 
READ: To read an entity from the database
SELECTONE: To read a singular entry from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
```

### Unit Tests 

```
Unit tests test each individual constructor, method or string within a given class. These work with class isolation so each class has its own set of unit tests run.

In order to run these, we can right click on the overall project file and click the 'coverage as' and then select 'junit test'. This will run the whole project and all junit tests within the project. This gives you a complete breakdown of all the tests that are running within the program and also the class names and individual methods being tested within them.

Alternatively, we can also test classes in isolation. Again, by opening up the project src/test/java folder, we can select which package we want to test, then further into that, which class we want to test. This is an individualised way of targetting classes for testing purposes that allows you to easily diagnose issues within a given class.

As part of the unit tests, I used Mockito. You can access Mockito by having the following dependencies within your POM file:
<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
			<version>3.7.7</version>
			<scope>test</scope>
		</dependency
  
 Using Mockito we can further test classes and methods by specifying parameters and verifying whether those parameters pass the tests.
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
