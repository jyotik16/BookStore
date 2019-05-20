package com.bookstore.contoller.admin.book;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.service.BookServices; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/delete_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10,//10KB
		maxFileSize = 1024* 300,//300KB
		maxRequestSize = 1024*1024//1MB
		)
public class DeleteBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookservices = new BookServices(entityManager,request,response);
		bookservices.deleteBook();
		
	}

}
