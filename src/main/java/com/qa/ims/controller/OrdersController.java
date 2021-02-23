package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Items;
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

	// Allows a user to create an order instance.

	@Override
	public Orders create() {
		LOGGER.info("Please enter your Customer ID");
		Long id = utils.getLong();
		Orders order = ordersDAO.update(new Orders(id));
		return order.getId();

		// When a customer creates an order, this ensures there are some items within
		// the order to begin with.

		boolean addItems = true;
		while (addItems) {
			LOGGER.info("Please enter the PID of the item you would like to add to the order.");
			Long pid = utils.getLong();
			LOGGER.info("How many of the items would you like to add to the order?");
			Long quantity = utils.getLong();		
			if (addItems = false) {
					break;
				} 
			Orders orders = ordersDAO.addItems(new Orders(pid, quantity));
			return order;

		}

	}

	// Allows a user to update an order to add items.

	@Override
	public Orders update() {
		LOGGER.info("Please enter the OID of the order you would like to update.");
		Long oid = utils.getLong();
		LOGGER.info("Please enter the PID of the item you would like to add to the order.");
		Long pid = utils.getLong();
		LOGGER.info("How many of the items would you like to add to the order?");
		Long quantity = utils.getLong();
		Orders order = ordersDAO.update(new Orders(oid, pid, quantity));
		LOGGER.info("Order Updated");
		return order;

	}

	// Allows a user to delete an item from an order.

	@Override
	public int delete() {
		LOGGER.info("Please enter the OID of the order you wish to remove items from.");
		Long oid = utils.getLong();
		LOGGER.info("Please enter the PID of the product you wish to remove from your order");
		Long pid = utils.getLong();
		return ordersDAO.delete(pid);
	}

}
