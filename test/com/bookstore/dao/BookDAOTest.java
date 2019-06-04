package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest {
private static BookDAO bookDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDAO = new BookDAO();		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookDAO.close();
		
	}
	@Test
	public void testcreateBook() throws ParseException, IOException {
		Book exitbook = new Book();
		Category category = new Category("Java Core");
		category.setCategoryId(1);
		exitbook.setCategory(category);
		exitbook.setTitle("Just Java 2 (6th Edition)");
		exitbook.setAuthor("Peter van der Linden");
		exitbook.setDescription("An international bestseller for eight years, Just Java™ 2 is the complete, accessible Java tutorial for working programmers at all levels. Fully updated and revised, this sixth edition is more than an engaging overview of Java 2 Standard Edition (J2SE 1.5) and its libraries: it’s also a practical introduction to today’s best enterprise and server-side programming techniques");
		exitbook.setPrice(7.78f);
		exitbook.setIsbn("0131482114");
		
		DateFormat dateformate = new SimpleDateFormat("MM/dd/yyyy");
		Date publishdate = dateformate.parse("05/28/2008");
		exitbook.setPublishDate(publishdate);
		
		String imagePath ="H:\\HB_JSP\\Books\\just java.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		exitbook.setImage(imageBytes);
		
		Book createdBook = bookDAO.create(exitbook);
		assertTrue(createdBook.getBookId()>0);
		
	}
	@Test
	public void testupdateBook() throws ParseException, IOException {
		Book exitbook = new Book();
		Category category = new Category("Javascript");
		category.setCategoryId(8);
		exitbook.setCategory(category);
		exitbook.setTitle("Eloquent JavaScript, 3rd Edition");
		exitbook.setAuthor(" Marijn Haverbeke ");
		exitbook.setDescription("JavaScript lies at the heart of almost every modern web application, from social apps like Twitter to browser-based game frameworks like Phaser and Babylon. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.");
		exitbook.setPrice(23.31f);
		exitbook.setIsbn("0131482114");
		
		DateFormat dateformate = new SimpleDateFormat("MM/dd/yyyy");
		Date publishdate = dateformate.parse("04/28/2018");
		exitbook.setPublishDate(publishdate);
		
		String imagePath ="H:\\HB_JSP\\Books\\javascript1.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		exitbook.setImage(imageBytes);
		
		Book updatedbook = bookDAO.update(exitbook);
		assertEquals(exitbook.getCategory().getCategoryId(),updatedbook.getCategory().getCategoryId());
		
		
	}
	
	@Test
	public void testDeleteBook() {
		Integer bookId = 100;
		bookDAO.delete(bookId);
		assertTrue(true);
		
	}
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId = 100;
		bookDAO.delete(bookId);
		assertTrue(true);
		
	}
	@Test
	public void testGetBookSuccess() {
		Integer bookId = 1;
		Book book =bookDAO.get(bookId);
		assertNotNull(book);
		
	}
	@Test
	public void testGetBookFail() {
		Integer bookId = 100;
		Book book = bookDAO.get(bookId);
		assertNull(book);
	}
	@Test
	public void testlistAll() {
		List<Book> listbooks = bookDAO.listAll();
		for(Book bb:listbooks) {
			System.out.println(bb.getAuthor()+"--->"+bb.getTitle());
		}
		assertTrue(listbooks.size()>0);
	}
	@Test
	public void testfindByTitleNotExit() {
		String title = "Thinking in java";
		Book book = bookDAO.findByTitle(title);
		System.out.println("this book not exit "+book.getTitle());
		assertNull(book);
	}
	@Test
	public void testfindByTitleExit() {
		String title = "Just Java 2 (6th Edition)";
		Book book = bookDAO.findByTitle(title);
		System.out.println("this book exit "+book.getTitle());
		assertNotNull(book);
	}
	@Test
	public void testCount() {
		long totalBooks = bookDAO.count();
		assertTrue(totalBooks>0);
	}
	@Test
	public void testlistByCategory() {
		
		int categoryId =1;
		List<Book> list = bookDAO.listByCategory(categoryId);
		assertTrue(list.size()>0);
		
	}
	@Test
	public void testlistNewBooks() {
		List<Book> list = bookDAO.listNewBooks();
		for(Book abook:list) {
			System.out.println(abook.getTitle()+"--->"+abook.getPublishDate());
		}
		assertEquals(4,list.size());
	}
	
	@Test
	public void testSearchBookInTitle() {
		String keyword = "Java";
		List<Book> list = bookDAO.search(keyword);
		for(Book bb:list) {
			System.out.println(bb.getTitle());
		}
		assertEquals(7,list.size());
		
	}
	@Test
	public void testSearchBookInAuthor() {
		String keyword = "Brian";
		List<Book> list = bookDAO.search(keyword);
		for(Book bb:list) {
			System.out.println(bb.getAuthor());
		}
		assertEquals(1,list.size());
		
	}
	@Test
	public void testSearchBookInDescription() {
		String keyword = "Are you looking for a deeper understanding";
		List<Book> list = bookDAO.search(keyword);
		for(Book bb:list) {
			System.out.println(bb.getAuthor());
		}
		assertEquals(1,list.size());
		
	}
	@Test
	public void testCountByCategory() {
		int categoryId =1;
		 long numOfBooks = bookDAO.countByCategory(categoryId);
		assertTrue(numOfBooks >0);
	}
	@Test
	public void testListBestSellingBooks() {
		List<Book> topBestSellingBooks = bookDAO.listBestSellingBooks();
		
		for (Book book : topBestSellingBooks) {
			System.out.println(book.getTitle());
		}
		
		assertEquals(4, topBestSellingBooks.size());
	}
	
	@Test
	public void testListMostFavoredBooks() {
		List<Book> topFavoredBooks = bookDAO.listMostFavoredBooks();

		for (Book book : topFavoredBooks) {
			System.out.println(book.getTitle());
		}
		
		assertEquals(4, topFavoredBooks.size());
	}

}
