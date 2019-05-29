package com.bookstore.controller.frontend.shoppingcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view_cart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShoppingCartServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object cartObject  = request.getSession().getAttribute("cart");
		
		if(cartObject ==null) {
			ShoppingCart shoppingcart =  new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingcart);
			
		}
		
		String cartPage = "frontend/shopping_cart.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(cartPage);
		rd.forward(request, response);
		
	}

}
