package com.bookstore.controller.frontend.shoppingcart;

import static org.junit.Assert.*;
import java.util.Map;


import org.junit.BeforeClass;
import org.junit.Test;
import com.bookstore.entity.Book;

public class ShoppingCartTest {
	private static ShoppingCart cart;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cart = new ShoppingCart();	
		Book book = new Book(1);
		book.setBookId(1);	
		book.setPrice(10);
		cart.addItem(book);
		cart.addItem(book);
	}

	@Test
	public void testAddItem() {
		
		Map<Book,Integer> items = cart.getItems();
		int quantity = items.get( new Book(1));
		
		assertEquals(2, quantity);
	}
	@Test
	public void testRemoveItem() {
		
		cart.removeItem(new Book(1));
		assertTrue(cart.getItems().isEmpty());	
		}
	@Test
	public void testRemoveItem2() {
		Book book2 = new Book(2);
		cart.addItem(book2);
		cart.removeItem(new Book(2));
		assertNull(cart.getItems().get(book2));	
	}
	@Test
	public void testGetTotalQuantity() {
		Book book3 = new Book(3);
		cart.addItem(book3);
		cart.addItem(book3);
		cart.addItem(book3);
		
		assertEquals(5,cart.getTotalQuantity());
	}
	
	@Test
	public void textGetTotalAmount() {
		ShoppingCart  cart = new ShoppingCart();		
		assertEquals(0.0f,cart.getAmount(),0.0f);
		
	}
	@Test
	public void textGetTotalAmount2() {
				
		assertEquals(20.0f,cart.getAmount(),0.0f);
		
	}
	@Test
	public void textclear() {
		cart.clear();
		assertEquals(0,cart.getTotalQuantity());
				
	}
	@Test
	public void textUpadate() {
		ShoppingCart cart = new ShoppingCart();
		Book b1 = new Book(1);
		Book b2 = new Book(2);
		
		cart.addItem(b1);
		cart.addItem(b2);
		int[] bookIds = {1,2};
		int[] quantities = {3,4};
		
		cart.updateCart(bookIds, quantities);
		assertEquals(7,cart.getTotalQuantity());
				
	}
	
}
