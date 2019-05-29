package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewDAOTest {
	private static ReviewDAO reviewDAO; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDAO = new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDAO.close();
	}
	
	@Test
	public void testfindByCustomerAndBookNotFound() {
		Integer CustomerId = 123;
		Integer BookId =12;
		
		Review result = reviewDAO.findByCustomerAndBook(CustomerId, BookId);
		assertNull(result);
		
	}
	@Test
	public void testfindByCustomerAndBookFound() {
		Integer CustomerId = 123;
		Integer BookId =12;
		
		Review result = reviewDAO.findByCustomerAndBook(CustomerId, BookId);
		assertNotNull(result);
		
	}
	@Test
	public void testCreateReview() {
		Review review = new Review();
		Book book = new Book();
		book.setBookId(3);
		
		Customer customer = new Customer();
		customer.setCustomerId(6);
		
		review.setBook(book);
		review.setCustomer(customer);
		review.setComment("good explanation,best examples for understanding java");
		review.setHeadline("Best Book in the world for Php");
		review.setRating((float) 3.5);
		
		Review savedreview = reviewDAO.create(review);
		assertTrue(savedreview.getReviewId()>0);
		
	}

	@Test
	public void testGetObject() {
	Integer reviewId = 1;
	Review review = reviewDAO.get(reviewId);
	assertNotNull(review);
	}

	@Test
	public void testUpdateReview() {
		Integer reviewId = 1;
		Review review = reviewDAO.get(reviewId);
		review.setComment("This is awesome book for begginner!");
		
		Review updatereview = reviewDAO.update(review);
		assertEquals(review.getComment(), updatereview.getComment());
	}

	@Test
	public void testDeleteObject() {
		Integer reviewId = 2;
		reviewDAO.delete(reviewId);
		Review review = reviewDAO.get(reviewId);
		assertNull(review);
	}

	@Test
	public void testListAll() {
		List<Review>  list = reviewDAO.listAll();
		for(Review ll:list) {
			System.out.println("-->"+ll.getBook().getTitle()+"-->"+ll.getHeadline());
			
		}
		assertTrue(list.size()>0);
	}

	@Test
	public void testCount() {
		long totalreviews = reviewDAO.count();
		System.out.println("Total review -->"+totalreviews);
		assertTrue(totalreviews>0);
	}

}
