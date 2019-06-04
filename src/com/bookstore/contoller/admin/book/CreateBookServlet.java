package com.bookstore.contoller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.service.BookServices;

/**
 * Servlet implementation class CreateNewBookServlet
 */
@WebServlet("/admin/create_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10,//10KB
		maxFileSize = 1024* 300,//300KB
		maxRequestSize = 1024*1024//1MB
		)
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookServices bookservices = new BookServices(request,response);
		bookservices.createBook();
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookServices bookservices = new BookServices(request,response);
		bookservices.createBook();
		
	}

}
