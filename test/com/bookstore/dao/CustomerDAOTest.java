package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;

public class CustomerDAOTest {
	private static CustomerDAO customerDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDAO.close();
	}

	@Test
	public void testListAll() {
		List<Customer> customerlist = customerDAO.listAll();
		assertFalse(customerlist.isEmpty());
		
	}
	@Test
	public void createCustomerTest() {
	Customer customer = new Customer();
	customer.setEmail("jyotik1608@gmail.com");
	customer.setFullname("jyotiKashyap");
	customer.setCity(" New delhi");
	customer.setAddress("2/47 Teliwara shahdra,delhi");
	customer.setCountry("India");
	customer.setPassword("12345");
	customer.setPhone("271367231");
	customer.setZipcode("110032");
	
	Customer savedcustomer  = customerDAO.create(customer);
	assertTrue(savedcustomer.getCustomerId() > 0);
	}

	@Test 
	public void getCustomerTest() {
		Integer customerId =1;
		Customer customer = customerDAO.get(customerId);
		assertNotNull(customer);
	}
	@Test 
	public void UpdateCustomerTest() {
		Integer customerId =1;
		Customer customer = customerDAO.get(customerId);
		String fullname = "tom tom";
		customer.setFullname(fullname);
		Customer updatedcustomer = customerDAO.update(customer);
		
		assertTrue(updatedcustomer.getFullname().equals(fullname));
		}
	
	@Test 
	public void testDeleteCustomer() {
		Integer customerId =1;
		customerDAO.delete(customerId);
		Customer customer = customerDAO.get(customerId);		
		assertNull(customer);
	}
	
	@Test
	public void testCount() {
		long totalcustomers = customerDAO.count();
		assertEquals(1, totalcustomers);
		
	}
	@Test
	public void testFindByEmail() {
		Customer customer = customerDAO.findByemail("jyotik1608@gmail.com");
		assertNotNull(customer);
		
	}
	@Test
	public void testcheckLogin() {
		Customer customer = customerDAO.checkLogin("jyotik1608@gmail.com","12345");
		assertNotNull(customer);
		
	}
}
