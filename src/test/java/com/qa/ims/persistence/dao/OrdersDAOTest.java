package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {
	
	private final OrdersDAO DAO = new OrdersDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Orders created = new Orders(2L, 1L);
		assertEquals(created, DAO.create(created));
		
	}
	
	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1L, 1L));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadOne() {
		final long fk_oid = 1L;
		assertEquals(new Orders(fk_oid, 1L), DAO.read(fk_oid));
	}
	
	@Test
	public void testUpdate() {
		final Orders updated = new Orders (1L, 1L, 1L);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(0L,DAO.delete(1L));
	}
}
