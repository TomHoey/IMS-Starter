package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemsDAO dao;

	@InjectMocks
	ItemsController testItemController;

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");

	}

	@Test
	public void testCreate() {
		
		final String productName = "Coke";
		final Double price = 1.50;

		final Items created = new Items(productName, price);

		Mockito.when(utils.getString()).thenReturn(productName);
		Mockito.when(utils.getDouble()).thenReturn(price);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, testItemController.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);

	}

	@Test
	public void testReadAll() {
		List<Items> items = new ArrayList<>();
		items.add(new Items(1L, "Coke", 1.50));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, testItemController.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();

	}

	@Test
	public void testUpdate() {
		Items updated = new Items(1L, "Coke", 1.50);

		Mockito.when(utils.getLong()).thenReturn(1L);
		Mockito.when(utils.getString()).thenReturn(updated.getProductName());
		Mockito.when(utils.getDouble()).thenReturn(updated.getPrice());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.testItemController.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);

	}

	@Test
	public void testDelete() {
		final Long pid = 1L;

		Mockito.when(utils.getLong()).thenReturn(pid);
		Mockito.when(dao.delete(pid)).thenReturn(1);

		assertEquals(1, this.testItemController.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(pid);

	}

}
