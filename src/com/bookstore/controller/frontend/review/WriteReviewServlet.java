package com.bookstore.controller.frontend.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.OrderServices;
import com.bookstore.service.ReviewServices;


@WebServlet("/write_review")
public class WriteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteReviewServlet() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServices review = new ReviewServices(request, response);

		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		boolean result = review.checkOrderWithCustomerAndBook(bookId);
		if (result) {
			review.showReviewForm();
		} else {
			String message = "You are not authorized to review this book.";
			request.setAttribute("message", message);
			String targetPage = "frontend/message.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(targetPage);
			rd.forward(request, response);
		}
		 
	
		
	}

}
