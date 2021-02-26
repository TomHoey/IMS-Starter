package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class ItemsControllerTest {
	
	private static ItemsController testItemController;
	private static ItemsDAO dao;
	private static Utils utils;
	
	private Long pid = (long) 101;
	private String productName = "Coke";
	private Double price = 1.50;

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");

	}
	
	@BeforeEach
	public void beforeEach() {
		testItemController = null;
		
	}
	
	@Test
	public void testCreate() {
		final Items created = new Items(pid, productName, price);
		assertEquals(created, testItemController.create());
	

	}
	
	@Test
	public void testReadAll() {
		List<Items> items = new ArrayList<>();
		items.add(new Items(pid, productName, price));
		assertEquals(items, testItemController.readAll());
			
		}
				
	

	
	@Test
	public void testUpdate() {
		
		
	}
	
	@Test
	public void testDelete() {
		
	}

}
