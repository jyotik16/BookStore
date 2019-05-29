package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Review;

public class BookServices {
	private BookDAO bookDAO;	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryDAO categoryDAO;
	private ReviewDAO reviewDAO;
	
	public BookServices( HttpServletRequest request,HttpServletResponse response) {
		super();
		bookDAO = new BookDAO();
		categoryDAO = new CategoryDAO();
		reviewDAO = new ReviewDAO();
		this.request = request;
		this.response = response;
	}
	public void listBooks() throws ServletException, IOException {
		listBooks(null);
	}
	
	public void listBooks(String message) throws ServletException, IOException {
		List<Book> listbooks = bookDAO.listAll();
		request.setAttribute("listbooks", listbooks);
		if(message!=null) {
			request.setAttribute("message", message);
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("book_list.jsp");
		rd.forward(request, response);
		
		
	}
	public void showBookNewForm() throws ServletException, IOException {
		List<Category> listcategory = categoryDAO.listAll();
		request.setAttribute("listcategory", listcategory);
		
		RequestDispatcher rd = request.getRequestDispatcher("book_form.jsp");
		rd.forward(request, response);
		
		
	}
	public void createBook() throws IllegalStateException, IOException, ServletException  {
		
		String title = request.getParameter("title");		
		Book exitbook = bookDAO.findByTitle(title);
		if(exitbook!=null) {
			String msg = "Could not create new book because this title * "+title+" * book already exits.";
			listBooks(msg);
			return;
			
		}
		Book newbook = new Book();
		readBookFields(newbook);
		
		Book createdbook = bookDAO.create(newbook);
		if(createdbook.getBookId()>0) {
			String msg = "A new Book has been created successfully.";
			
			listBooks(msg);
		}
	}
	public void readBookFields(Book book) throws IllegalStateException, IOException, ServletException{
		Integer Id = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");			
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String description = request.getParameter("description");
		Float price = Float.parseFloat(request.getParameter("price"));
		
		Category category = categoryDAO.get(Id);
		
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishdate = null;
		try {
		 publishdate = dateformat.parse(request.getParameter("publishdate"));
		} catch (ParseException e) {
			System.out.println("publish date in format(MM/dd/yyyy)");
			e.printStackTrace();
			
		}
		
		book.setAuthor(author);
		book.setTitle(title);
		book.setDescription(description);
		book.setPrice(price);
		book.setPublishDate(publishdate);
		book.setIsbn(isbn);
		book.setCategory(category);
		
		Part part = request.getPart("bookImage");
		if(part!=null && part.getSize()>0) {
			long size =part.getSize();
			byte[] ImageBytes = new byte[(int) size];
			InputStream inputstream = part.getInputStream();
			inputstream.read(ImageBytes);
			inputstream.close();
			book.setImage(ImageBytes);
			
		}
		
		System.out.println(Id+" "+title+" "+author+" "+isbn+" "+description+" "+price+" "+publishdate+" ");
		
		
	}
	
	public void editBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDAO.get(bookId);
		List<Category> listcategory = categoryDAO.listAll();
		
		request.setAttribute("book", book);
		request.setAttribute("listcategory", listcategory);
		
		RequestDispatcher rd = request.getRequestDispatcher("book_form.jsp");
		rd.forward(request, response);
		
	}
	
	public void updatebook() throws IllegalStateException, IOException, ServletException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		Book bookById = bookDAO.get(bookId);
		String title = request.getParameter("title");		
		Book bookByTitle = bookDAO.findByTitle(title);
	
		if(bookByTitle!=null && !bookById.equals(bookByTitle)) {
			String msg = "Could not update book because another book having same title * "+title+" * book already exits.";
			listBooks(msg);
			return;
			
		}
		readBookFields(bookById);
		bookDAO.update(bookById);
		listBooks("This book has been updated sucessfully!.");
		
	}
	
	public void deleteBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		System.out.println("book id = "+bookId);
		bookDAO.delete(bookId);
		System.out.println("book deleted whose id= "+bookId);
		listBooks("Book has been deleted successfully!.");
		
	}
	public void listBooksByCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		System.out.println("id = "+categoryId);
		List<Book> listbooks = bookDAO.listByCategory(categoryId);
		Category category = categoryDAO.get(categoryId);
				
		request.setAttribute("listbooks",listbooks);
		request.setAttribute("category",category);
			
		RequestDispatcher rd = request.getRequestDispatcher("frontend/books_list_by_category.jsp");
		rd.forward(request, response);
		
	}
	public void viewBookDetail() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDAO.get(bookId);
		Set<Review> Stars = book.getReviews();
		for(Review ss:Stars) {
			System.out.println(" key-->"+ss.getStars()+" headline "+ss.getHeadline());
		}
		
		request.setAttribute("book",book);
			
		RequestDispatcher rd = request.getRequestDispatcher("frontend/book_detail.jsp");
		rd.forward(request, response);
		
	}
	public void search() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Book> result = null;
		if(keyword.equals("")) {
			result = bookDAO.listAll();
			request.setAttribute("result", result);
			request.setAttribute("keyword", " ");
		}else {
			result = bookDAO.search(keyword);
			request.setAttribute("result", result);
			request.setAttribute("keyword", keyword);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("frontend/search_result.jsp");
		rd.forward(request, response);

		
	}
	
}
