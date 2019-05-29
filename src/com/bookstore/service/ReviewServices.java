package com.bookstore.service;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewServices {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ReviewDAO reviewDAO;
	
	public ReviewServices( HttpServletRequest request,HttpServletResponse response) {
		super();
		
		reviewDAO  = new ReviewDAO();
		this.request = request;
		this.response = response;
	}
	public void listAllReview() throws ServletException, IOException{
		listAllReview(null);
				
	}
	public void listAllReview(String message) throws ServletException, IOException{
		List<Review> listreviews = reviewDAO.listAll();
		if(message!=null) {
			request.setAttribute("message",message);
		}
		request.setAttribute("listreviews", listreviews);
		forwardmethod("review_list.jsp");
				
	}
		public void forwardmethod(String path) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}
	public void edit_review() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		
		request.setAttribute("review", review);
		forwardmethod("review_form.jsp");
		
	}
	public void update_review() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review review = reviewDAO.get(reviewId);
		review.setHeadline(headline);
		review.setComment(comment);
		
		reviewDAO.update(review);
		
		String msg = "The Review has been updated successfully!.";
		listAllReview(msg);
		
	}
	public void delete_review() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		reviewDAO.delete(reviewId);
		String msg = "The Review has been deleted successfully!.";
		listAllReview(msg);
		
	}
	
	public void showReviewForm() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		Customer customer = (Customer)session.getAttribute("loggedCustomer");
		
		Review exitreview = reviewDAO.findByCustomerAndBook(customer.getCustomerId(),bookId);
		
		String targetPage = null;
		if(exitreview!=null) {
			request.setAttribute("review",exitreview);
			targetPage = "frontend/review_info.jsp";
			
		}else {
			targetPage="frontend/review_form.jsp";			
		}
		RequestDispatcher rd = request.getRequestDispatcher(targetPage);
		rd.forward(request, response);
		
	}
	public void submitReview() throws ServletException, IOException {
		Integer bookreviewId = Integer.parseInt(request.getParameter("bookId"));
		float rating = Float.parseFloat(request.getParameter("rating"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		Review review  = new Review();
		review.setComment(comment);
		review.setHeadline(headline);
		review.setRating(rating);
		
		Book book = new Book();
		book.setBookId(bookreviewId);
		
		review.setBook(book);
		
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		review.setCustomer(customer);
		reviewDAO.create(review);
					
		String targetPage="frontend/review_done.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(targetPage);
		rd.forward(request, response);
	}
}
