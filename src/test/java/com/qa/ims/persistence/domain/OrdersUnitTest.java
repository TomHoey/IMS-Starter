package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrdersUnitTest {
	
	private static Orders testOrders;
	
	private Long oid;
	private Long fk_cid;
	private Long fk_oid;
	private ArrayList<Long> pid;
	private ArrayList<Long> quantity;
	private ArrayList<Double> totalPrice;
	
	@Before
	public void beforeEach() {
		testOrders = null;
	}
	
	@Test
	public void  testOrdersArray() {
		Orders testOrders = new Orders();
		assertNotNull(testOrders);
	}

	
	@Test
	public void OrdersConstrutorOne() {
		Orders testOrders = new Orders(oid);
		assertNotNull(testOrders);
	}
	
	@Test
	public void OrdersConstructorTwo() {
		Orders testOrders = new Orders(oid, fk_cid);
		assertNotNull(testOrders);
	}
	
	@Test
	public void OrdersContructorThree() { 
		Orders testOrders = new Orders(fk_oid, pid, quantity);
		assertNotNull(testOrders);
	}
	
	@Test
	public void testToString () {
		Orders testOrders = new Orders(oid, fk_cid);
		String result = testOrders.toString();
		assertEquals("OID: " + oid + " |" + "CID: " + fk_cid, result);

	}
	
	/* @Test
	public void testTooString () {
		Orders testOrders = new Orders (fk_oid, pid, quantity);
		String result = testOrders.TransactionsString();
		assertEquals("\n pid " + pid + " quantity " + quantity+ " Total_Price " + totalPrice, result); 
	} */
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Orders.class).verify();
	}

}
