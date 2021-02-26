package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class OrderControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private OrdersDAO dao;
	
	@InjectMocks
	OrdersController testOrdersController;
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		
	}
	
	@Test
	public void testCreate() {
		final Long oid = 1L, fk_cid = 1L;
		final Orders created = new Orders(oid, fk_cid);
		
		Mockito.when(utils.getLong()).thenReturn(oid);
		Mockito.when(utils.getLong()).thenReturn(fk_cid);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, testOrdersController.create());
		
		Mockito.verify(utils,Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
		
	}
	
	@Test
	public void testRead() {
		
	}

	@Test
	public void testReadAll() {
		List<Orders> orders = new ArrayList<>();
		orders.add(new Orders(1L, 1L));
		
		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(orders, testOrdersController.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
		
	}
	
	@Test
	public void testUpdate() {
		Orders updated = new Orders(1L, 1L, 1L);
		
		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getPid(), updated.getQuantity());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.testOrdersController.update());

		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);

		
	}
	
	@Test
	public void testDelete() {
		
	}
}
