package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
		customer.setCustomerId(7);
		
		order.setCustomer(customer);
		order.setRecipientName("Grauv Singh");
		order.setRecipientPhone("8234663246");
		order.setShippingAddress("345-A Block ariba Dubai");
		order.setTotal(654.4f);
		
		Set<OrderDetail> orderdetail = new HashSet<>();
		
		OrderDetail detail = new OrderDetail();
		Book b = new Book(14);
		detail.setBook(b);				
		detail.setQuantity(1);
		detail.setSubtotal(900.0f);
		detail.setBookOrder(order);
		
		orderdetail.add(detail);
		
		order.setOrderDetails(orderdetail);
		BookOrder savedOrder = orderDAO.create(order);
		assertTrue(savedOrder.getOrderId()>0);
		
	}

	@Test
	public void testGetObject() {
		Integer orderId = 6;
		BookOrder order = orderDAO.get(orderId);
		System.out.println(order.getRecipientName());
		assertEquals(1,order.getOrderDetails().size());
	}

	@Test
	public void testUpdateBookOrderShppingAddress() {
		Integer orderId = 7;
		BookOrder order = orderDAO.get(orderId);
		order.setShippingAddress("123 North Street Eroupe Russia");
		orderDAO.update(order);
		
		BookOrder updatedorder =orderDAO.get(orderId);
		
		assertEquals(order.getShippingAddress(),updatedorder.getShippingAddress() );
	}
	@Test
	public void testUpdateBookOrderOrderDetails() {
		Integer orderId = 6;
		BookOrder order = orderDAO.get(orderId);
		Iterator<OrderDetail> iterator = order.getOrderDetails().iterator(); 
		
		while(iterator.hasNext()) {
			OrderDetail orderdetail = iterator.next();
			if(orderdetail.getBook().getBookId() == 1) {
				orderdetail.setQuantity(3);
				orderdetail.setSubtotal(120);
			}
		}
		orderDAO.update(order);
		
		BookOrder updatedorder =orderDAO.get(orderId);
		iterator = order.getOrderDetails().iterator(); 
		int expectedQuantity = 3;
		float expectedSubtotal = 120;
		int actualQuantity = 0;
		float actualSubtotal = 0;
		while(iterator.hasNext()) {
			OrderDetail orderdetail = iterator.next();
			if(orderdetail.getBook().getBookId() == 1) {
				actualQuantity = orderdetail.getQuantity();
				actualSubtotal = orderdetail.getSubtotal();
				
			}
		}
		assertEquals(expectedQuantity,actualQuantity );
		assertEquals(expectedSubtotal,actualSubtotal,0.0f);
	}
	@Test
	public void testUpdateBookOrder() {
		Integer orderId = 6;
		BookOrder order = orderDAO.get(orderId);
		order.setTotal(67.45f);
		orderDAO.update(order);
	}
	@Test
	public void testDeleteObject() {
		int orderId = 3;
		orderDAO.delete(orderId);
		BookOrder bookorder = orderDAO.get(orderId);
		assertNull(bookorder);
	}

	@Test
	public void testListAll() {
		List<BookOrder> listorders = orderDAO.listAll();
		for(BookOrder b:listorders) {
			System.out.println(b.getOrderId()+" "+b.getRecipientName());
			for(OrderDetail detail:b.getOrderDetails()) {
				Book book = detail.getBook();
				int quantity = detail.getQuantity();
				float total = detail.getSubtotal();
				System.out.println("\t"+book.getTitle()+" -- "+quantity+" --"+total);
			}
			
		}
		assertTrue(listorders.size()>0);
	}

	@Test
	public void testCount() {
		long totalorders = orderDAO.count();
		assertEquals(4, totalorders);
		
	}

		
	public void testfindByCustomerNoOrders() {
		Integer customerId =99;
		List<BookOrder> result = orderDAO.listByCutsomer(customerId);
		assertTrue(result.isEmpty());
	}
	public void testfindByCustomerOrders() {
		Integer customerId = 1;
		List<BookOrder> result = orderDAO.listByCutsomer(customerId);
		assertTrue(result.size()>0);
	}
}
