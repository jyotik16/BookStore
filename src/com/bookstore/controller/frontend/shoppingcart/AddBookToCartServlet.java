package com.bookstore.controller.frontend.shoppingcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;


@WebServlet("/add_to_cart")
public class AddBookToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public AddBookToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		Object cartObj = request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingcart =null;
		if(cartObj!=null && cartObj instanceof ShoppingCart) {
			 shoppingcart = (ShoppingCart) cartObj;
		}else {
			shoppingcart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingcart);
			
		}
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		
		shoppingcart.addItem(book);
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
		
	}

}
