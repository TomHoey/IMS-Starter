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

import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrdersDAO dao;

	@Mock
	private CustomerDAO custDao;

	@InjectMocks
	OrdersController testOrdersController;

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");

	}

	@Test
	public void testCreate() {
		final Orders created = new Orders(1L, 1L, 1L);

		Mockito.when(utils.getLong()).thenReturn(1L);
		Mockito.when(utils.getLong()).thenReturn(1L);
		Mockito.when(utils.getString()).thenReturn("no");
		Mockito.when(dao.create(Mockito.any())).thenReturn(created);

		assertEquals(created, testOrdersController.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		

	}
	@Test
	public void testRead() {
		final long fk_oid = 1L;
		assertEquals(new Orders(fk_oid, 1L), dao.read(fk_oid));

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
		final Long oid = 1L;
		final Long pid = 1L;

		Mockito.when(utils.getLong()).thenReturn(oid);
		Mockito.when(utils.getLong()).thenReturn(pid);
		Mockito.when(dao.delete(pid)).thenReturn(1);

		assertEquals(1L, this.testOrdersController.delete());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(pid);

	}
}
