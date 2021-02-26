
package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {

	private final ItemsDAO itemsDAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void outputTableTest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("Select * from items");) {
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testCreate() {
		Items created = new Items(2L, "Coke", 1.50);
		assertEquals(created, itemsDAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "Coke", 1.50));
		assertEquals(expected, itemsDAO.readAll());

	}

	@Test
	public void testReadLatest() {
		assertEquals(new Items(1L, "Coke", 1.50), itemsDAO.readLatest());

	}

	@Test
	public void testRead() {
		final long pid = 1L;
		assertEquals(new Items(pid, "Coke", 1.50), itemsDAO.read(pid));

	}

	@Test
	public void testUpdate() {
		Items updated = new Items(1L, "Coke", 1.50);
		assertEquals(updated, itemsDAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, itemsDAO.delete(1));
	}
	
	@Test
	public void testCreateExceptions() {
		assertNull(itemsDAO.create(null));
	}
	
	@Test
	public void testReadLatestExceptions() {
		itemsDAO.delete(1L);
		assertNull(itemsDAO.readLatest());	
	}
	
	@Test
	public void testReadExceptions() {
		itemsDAO.delete(1L);
		assertNull(itemsDAO.read(1L));	
	}
	
	@Test
	public void testUpdateException() {
        Items items = new Items();
        assertNull(itemsDAO.update(items));
    }
}
