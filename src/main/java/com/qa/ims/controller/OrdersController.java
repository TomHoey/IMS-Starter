package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	// Reads all orders to the Logger.

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Orders read() {
		LOGGER.info("Please enter the OID of the order you wish to view.");
		Long fk_oid = utils.getLong();
		Orders transactions = ordersDAO.read(fk_oid);
		LOGGER.info(transactions);
		return transactions;
	}

	// Allows a user to create an order instance.

	@Override
	public Orders create() {
		LOGGER.info("Please enter your Customer ID");
		Long oid = utils.getLong();
		Orders order = ordersDAO.create(new Orders(oid));
		// return order here maybe?

		// When a customer creates an order, this ensures there are some items within
		// the order to begin with.

		
		// Need this to then jump onto that order and add items to it.
		String addItemstoOrder;

		do {

			LOGGER.info("Please enter the PID of the item you would like to add to the order.");
			utils.getLong();
			LOGGER.info("How many of the items would you like to add to the order?");
			utils.getLong();
			LOGGER.info("Do you want to add items to your order?");
			addItemstoOrder = utils.getString();
			ordersDAO.addItems(order);
		} while (addItemstoOrder.equals("yes")); 
			LOGGER.info("Your order has been updated");
		return order;
	}

	// Allows a user to update an order to add items.

	@Override
	public Orders update() {
		LOGGER.info("Please enter the OID of the order you would like to update.");
		Long fk_oid = utils.getLong();
		LOGGER.info("Please enter the PID of the item you would like to add to the order.");
		Long pid = utils.getLong();
		LOGGER.info("How many of the items would you like to add to the order?");
		Long quantity = utils.getLong();
		Orders order = ordersDAO.update(new Orders(fk_oid, pid, quantity));
		LOGGER.info("Order Updated");
		return order;

	}

	// Allows a user to delete an item from an order.

	@Override
	public int delete() {
		LOGGER.info("Please enter the OID of the order you wish to remove items from.");
		utils.getLong();
		LOGGER.info("Please enter the PID of the product you wish to remove from your order");
		Long pid = utils.getLong();
		return ordersDAO.delete(pid);
	}

}
