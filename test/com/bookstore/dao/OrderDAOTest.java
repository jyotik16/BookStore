package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;


public class OrderDAOTest {

	private static OrderDAO orderDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderDAO = new OrderDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderDAO.close();
	}

	@Test
	public void testCreateBookOrder() {
		BookOrder order = new BookOrder();
		Customer customer = new Customer();
		customer.setCustomerId(1);
		
		order.setCustomer(customer);
		order.setRecipientName("Jyoti Kashyap");
		order.setRecipientPhone("8800728520");
		order.setShippingAddress("3-D street New York USA");
		
		Set<OrderDetail> orderdetail = new HashSet<>();
		
		OrderDetail detail = new OrderDetail();
		Book b= new Book();
		detail.setBook(b);				
		detail.setQuantity(3);
		detail.setSubtotal(50.0f);
		detail.setBookOrder(order);
		
		orderdetail.add(detail);
		
		order.setOrderDetails(orderdetail);
		BookOrder savedOrder = orderDAO.create(order);
		assertTrue(savedOrder!=null && savedOrder.getOrderDetails().size()>0);
		
	}

	@Test
	public void testGetObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBookOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCategory() {
		fail("Not yet implemented");
	}

}
