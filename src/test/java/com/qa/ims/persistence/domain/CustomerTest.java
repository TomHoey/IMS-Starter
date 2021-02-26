package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	
	private Long id = 1L;
	private String firstName = "Jordan";
	private String surname = "Harrison";
	
	@Test
	public void customerConstructorOne() {
		Customer customer = new Customer();

		assertNotNull(customer);
	}

	@Test
    public void customerAllArgs() {
        String fName = "jordan";
        String lName = "harrison";
        Customer customer = new Customer(1L, fName, lName);
       
        assertNotNull(customer.getId());
        assertNotNull(customer.getFirstName());
        assertNotNull(customer.getSurname());
       
        assertEquals((Long)1L, customer.getId());
        assertEquals(fName, customer.getFirstName());
        assertEquals(lName, customer.getSurname());
    }

	@Test
	public void customerGetName() {
		String fName = "jordan";
		String lName = "harrison";
		Customer customer = new Customer(fName, lName);

		assertEquals(fName, customer.getFirstName());
		assertEquals(lName, customer.getSurname());
	}
	
	@Test
	public void testToString() { 
		Customer customerTest = new Customer (id, firstName, surname);
		String result = customerTest.toString();
		assertEquals("ID: " + id + " |" + " First Name: " + firstName + " |" + " Surname: " + surname, result);
		
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

}
