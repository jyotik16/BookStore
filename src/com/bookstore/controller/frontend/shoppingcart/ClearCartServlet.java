package com.bookstore.controller.frontend.shoppingcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.entity.Book;

@WebServlet("/clear_cart")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClearCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShoppingCart shoppingcart = (ShoppingCart) request.getSession().getAttribute("cart");
		shoppingcart.clear();
		
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
	}

}
