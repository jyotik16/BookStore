package com.bookstore.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO() {
	}

	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setLastUpdateTime(new Date());
		return super.update(book);
	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
	}

	@Override
	public List<Book> listAll() {		
		return super.findWithNamedQuery("Book.findAll");
	}

	public Book findByTitle(String title) {
		List<Book> result = super.findWithNamedQuery("Book.findByTitle", "title", title);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}
	
	public List<Book> listByCategory(int categoryId) {
		return super.findWithNamedQuery("Book.findByCategory", "catId", categoryId);
	}
	
	public List<Book> search(String keyword) {
		return super.findWithNamedQuery("Book.search", "keyword", keyword);
	}
	
	public List<Book> listNewBooks() {		
		return super.findWithNamedQuery("Book.listNew", 0, 4);
	}
	public List<Book> listNewBooks(int maxresult) {		
		return super.findWithNamedQuery("Book.listNew", 0,  maxresult);
	}
	
	@Override
	public long count() {
		return super.countWithNamedQuery("Book.countAll");
	}
	
	public long countByCategory(int categoryId) {
		return super.countWithNamedQuery("Book.countByCategory", "catId", categoryId);
	}

	public List<Book> listBestSellingBooks() {
		return super.findWithNamedQuery("OrderDetail.bestSelling", 0, 4);
	}	
	
	public List<Book> listBestSellingBooks(int maxresult) {
		return super.findWithNamedQuery("OrderDetail.bestSelling", 0, maxresult);
	}
	public List<Book> listMostFavoredBooks() {
		List<Book> mostFavoredBooks = new ArrayList<>();
		
		List<Object[]> result = super.findWithNamedQueryObjects("Review.mostFavoredBooks", 0, 4);
		
		if (!result.isEmpty()) {
			for (Object[] elements : result) {
				Book book = (Book) elements[0];
				mostFavoredBooks.add(book);
				System.out.println("fav book=>"+book);
				
			}
		} 
		
		return mostFavoredBooks;
	}
	public List<Book> listMostFavoredBooks(int maxresult) {
		List<Book> mostFavoredBooks = new ArrayList<>();
		
		List<Object[]> result = super.findWithNamedQueryObjects("Review.mostFavoredBooks", 0, maxresult);
		
		if (!result.isEmpty()) {
			for (Object[] elements : result) {
				Book book = (Book) elements[0];
				mostFavoredBooks.add(book);
			}
		} 
		
		return mostFavoredBooks;
	}

	@Override
	public Category get(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
