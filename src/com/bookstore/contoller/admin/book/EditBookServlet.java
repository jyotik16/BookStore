package com.bookstore.contoller.admin.book;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.dao.BaseDAOTest;
import com.bookstore.service.BookServices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/edit_book")
public class EditBookServlet extends BaseServlet  {

	private static final long serialVersionUID = 8746317530616085059L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BookServices bookservices = new BookServices(entityManager, request, response);	
	bookservices.editBook();
	}
   
}
