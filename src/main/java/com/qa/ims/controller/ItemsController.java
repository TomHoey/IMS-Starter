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

	@Override
	public Items update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
}
