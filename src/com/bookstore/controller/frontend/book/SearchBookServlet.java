package com.bookstore.controller.frontend.book;


import com.bookstore.service.BookServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SearchBookServlet() {
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookservices = new BookServices( request, response);
		bookservices.search();
		
	}

}
