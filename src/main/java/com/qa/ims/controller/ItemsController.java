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

	
}
