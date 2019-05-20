package com.bookstore.contoller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.service.BookServices;

@WebServlet("/admin/list_books")
public class ListBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
    public ListBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	BookServices bookservices = new BookServices(entityManager, request, response);
	bookservices.listBooks();
	
	}

	

}
