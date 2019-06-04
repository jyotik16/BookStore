package com.bookstore.service;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.Review;
import static com.bookstore.service.CommonUtitlity.*;
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
		request.setAttribute("listreviews", listreviews);
		forwardToPage("review_list.jsp", message, request, response);	
				
	}
				
	public void editReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		
		if (review != null) {		
			request.setAttribute("review", review);		
			forwardToPage("review_form.jsp", request, response);
		} else {
			String message = "Could not find review with ID " + reviewId;
			showMessageBackend(message, request, response);
		}
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
		Review review = reviewDAO.get(reviewId);
		if (review != null) {
			reviewDAO.delete(reviewId);
			String message = "The review has been deleted successfully.";
			listAllReview(message);
		} else {
			String message = "Could you find review with ID " + reviewId
					+ ", or it might have been deleted by another admin";
			showMessageBackend(message, request, response);
		}
		
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
		forwardToPage(targetPage, request, response);
		
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
					
		forwardToPage("frontend/review_done.jsp", request, response);
	}
	
	public boolean checkOrderWithCustomerAndBook(Integer bookId) throws ServletException, IOException {
			BookDAO bookDao = new BookDAO();
			Book book = bookDao.get(bookId);
			System.out.println("book1= "+book.getBookId());
			Boolean flag =false;
			HttpSession session = request.getSession(); 				
			Customer customer = (Customer) session.getAttribute("loggedCustomer");
			if(customer == null) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}else {
				OrderDAO orderDAO = new OrderDAO();
				List<BookOrder> list = orderDAO.listByCutsomer(customer.getCustomerId());
				
				for(BookOrder bb:list) {
					Set<OrderDetail> details = bb.getOrderDetails();
					Iterator<OrderDetail> iterator = details.iterator();
					while(iterator.hasNext()) {
						OrderDetail orderDetail = (OrderDetail) iterator.next();
					System.out.println(" book2 = "+orderDetail.getBook().getBookId());
						if(orderDetail.getBook().getBookId().equals(book.getBookId())){
							flag = true;
							break;
						}
					}
				}
			}
			return flag;
		}
	public void showCheckoutForm() throws ServletException, IOException {
		forwardToPage("frontend/checkout.jsp", request, response);
	}
}
