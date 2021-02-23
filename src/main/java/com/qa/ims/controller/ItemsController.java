package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemsDAO itemsDAO;
	private Utils utils;
	
	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
			
	}
	
	//Reads all items to the logger
	
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items Items : items) {
			LOGGER.info(Items);
		}
		return items;
		
	}

	// Allow a user to add an Item.
	
	@Override
	public Items create() {
		LOGGER.info("Please enter the product name");
		String productName = utils.getString();
		LOGGER.info("Please enter the price of the product");
		Double price = utils.getDouble();
		Items Items = itemsDAO.create(new Items(productName, price));
		LOGGER.info("Item added");
		return Items;
		
		
	}
	
	//Allows a user to update an Item.

	@Override
	public Items update() {
		LOGGER.info("Please enter the PID of the Item you would like to update. Remember - it starts at 100 and increments by 1.");
		Long pid = utils.getLong();
		LOGGER.info("Please enter the new product name.");
		String productName = utils.getString();
		LOGGER.info("Please enter the new price of the item.");
		Double price =  utils.getDouble();
		Items Items = itemsDAO.update(new Items(pid, productName, price));
		LOGGER.info("Item Updated");
		return Items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the PID of the Item you wish to remove.");
		Long pid = utils.getLong();
		LOGGER.info("Item deleted!");
		return itemsDAO.delete(pid);
	}
}
