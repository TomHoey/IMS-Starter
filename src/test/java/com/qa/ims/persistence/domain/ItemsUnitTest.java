package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemsUnitTest {

	private static Items testItems;
	
	private Long pid = (long) 1;
	private String productName = "Coke";
	private Double price = 1.50;

	@Before
	public void beforeEach() {
		testItems = null;
	}

	@Test
	public void ItemsConstructorOne() {
		Items testItems = new Items(pid, productName, price);
		assertNotNull(testItems);
	}

	@Test
	public void ItemsConstructorTwo() {
		testItems = new Items(productName, price);
		assertNotNull(testItems);
	}

	@Test
	public void testToString() {
		Items itemsTest = new Items(pid, productName, price);
		String result = itemsTest.toString();
		assertEquals("ProductID: " + pid + " |" + "Product: " + productName + " |" + "Price: £" + price, result);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Items.class).verify();
	}
}	
	
