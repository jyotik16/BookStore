package com.bookstore.controller.frontend.shoppingcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.entity.Book;

@WebServlet("/remove_from_cart")
public class RemovefromCartervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RemovefromCartervlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		Object cartObj = request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingcart =(ShoppingCart) cartObj;
		
		shoppingcart.removeItem(new Book(bookId));
		
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
	}

}
