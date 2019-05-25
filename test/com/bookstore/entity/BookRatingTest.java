package com.bookstore.entity;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class BookRatingTest {

	@Test
	public void testAverageRating() {
		Book book = new Book();
		
		Set<Review> reviews = new HashSet<>();
		Review r1 = new Review();
		r1.setRating((float) 4.5);
		
		reviews.add(r1);
		book.setReviews(reviews);
		float avgrating = book.getAverageRataing();
		
		assertEquals(5.0, avgrating,0.0);
		
	}
	@Test
	public void testAverageRating2() {
		Book book = new Book();
		float avgrating = book.getAverageRataing();
		assertEquals(5.0, avgrating,0.0);
		
	}
	@Test
	public void testAverageRating3() {
		Book book = new Book();
		Set<Review> reviews = new HashSet<>();
		
		Review r3 = new Review();
		r3.setRating(4);		
		reviews.add(r3);
		
		Review r4 = new Review();
		r4.setRating((float) 3.5);		
		reviews.add(r4);
		
		book.setReviews(reviews);
		
		float avgrating = book.getAverageRataing();
		assertEquals(5.0, avgrating,0.0);
		
	}
	@Test
	public void testRatingString1() {
		float avgrating =0.0f;
		Book book = new Book();
		String actual = book.getRatingString(avgrating);
		
		String expected = "off,off,off,off,off";
		
		assertEquals(expected,actual);
	
	}
	@Test
	public void testRatingString2() {
		float avgrating =5.0f;
		Book book = new Book();
		String actual = book.getRatingString(avgrating);
		
		String expected = "on,on,on,on,on";
		
		assertEquals(expected,actual);
	
	}
	@Test
	public void testRatingString3() {
		float avgrating =3.0f;
		Book book = new Book();
		String actual = book.getRatingString(avgrating);
		
		String expected = "on,on,on,off,off";
		
		assertEquals(expected,actual);
	
	}
	@Test
	public void testRatingString4() {
		float avgrating =4.5f;
		Book book = new Book();
		String actual = book.getRatingString(avgrating);
		
		String expected = "on,on,on,on,half";		
		assertEquals(expected,actual);
	
	}
}
