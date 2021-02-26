package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrdersUnitTest {
	
	private static Orders testOrders;
	
	
	private Long id = (long) 1;
	private Long fk_cid = (long) 1001;
	private Long pid = (long) 101;
	private Long quantity = (long) 3;
	private Double totalPrice = (double) (pid * quantity);
	
	@Before
	public void beforeEach() {
		testOrders = null;
	}
	
	@Test
	public void OrdersConstrutorOne() {
		Orders testOrders = new Orders(fk_cid);
		assertNotNull(testOrders);
	}
	
	@Test
	public void OrdersConstructorTwo() {
		Orders testOrders = new Orders(fk_cid, pid, quantity);
		assertNotNull(testOrders);
	}
	
	@Test
	public void OrdersContructorThree() { 
		Orders testOrders = new Orders(fk_cid, quantity);
		assertNotNull(testOrders);
	}
	
	@Test
	public void OrdersConstructorFour() {
		Orders testOrders = new Orders(pid, quantity, totalPrice);
		assertNotNull(testOrders);
	}
	
	@Test
	public void OrdersConstructorFive() {
		Orders testOrders = new Orders(id, fk_cid, pid, quantity, totalPrice);
		assertNotNull(testOrders);
	}
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Orders.class).verify();
	}

}
