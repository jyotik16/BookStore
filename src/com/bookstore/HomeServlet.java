package com.bookstore;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;


@WebServlet(urlPatterns="")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	 
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			CategoryDAO categoryDAO = new CategoryDAO(entityManager);
			BookDAO bookDAO = new BookDAO(entityManager);
			Book book =new Book();
			
			List<Category> listcategory = categoryDAO.listAll();
			List<Book> listNewbooks = bookDAO.listNewBook();
			
			req.setAttribute("listcategory",listcategory);
			req.setAttribute("listNewbooks",listNewbooks);
			
			RequestDispatcher rd = req.getRequestDispatcher("frontend/index.jsp");
			rd.forward(req, resp);
		}


}
