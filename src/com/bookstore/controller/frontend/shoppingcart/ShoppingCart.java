package com.bookstore.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.bookstore.entity.Book;

public class ShoppingCart {
	private Map<Book, Integer> cart = new HashMap<>();

	public void addItem(Book book) {
		if (cart.containsKey(book)) {
			Integer quantity = cart.get(book) + 1;
			cart.put(book, quantity);
		} else {
			cart.put(book, 1);
		}
	}
	
	public void removeItem(Book book) {
		cart.remove(book);
	}
	public int getTotalQuantity() {
		int total = 0;
		Iterator<Book> iterator = cart.keySet().iterator();
		
		while(iterator.hasNext()) {
			Book next = iterator.next();
			Integer quantity = cart.get(next);
			total+=quantity;
		}
		
		return total;
	}
	public float getAmount() {
		float total=0.0f;
		Iterator<Book> iterator = cart.keySet().iterator();
		
		while(iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = cart.get(book);
			double subtotal = quantity * book.getPrice();
			total+=subtotal;
		}
		return total;
	}
	public Map<Book,Integer> getItems(){
		return this.cart;
	}
	public int getTotalItems() {
		return cart.size();
	}
	public void clear() {
		cart.clear();
	}
	public void updateCart(int[] bookIds,int[] quantites) {
		for(int i=0;i<bookIds.length;i++) {
			Book key = new Book(bookIds[i]);
			Integer value = quantites[i];
			cart.put(key, value);
			
			
		}
	}
}
