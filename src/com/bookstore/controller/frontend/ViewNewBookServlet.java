package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;



@WebServlet("/list_new_book")
public class ViewNewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewNewBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO bookDAO = new BookDAO();
		int count = (int) bookDAO.count();
		System.out.println("count = "+count);
		List<Book> listNewBooks = bookDAO.listNewBooks((int)count);
		
		request.setAttribute("listNewBooks", listNewBooks);
		
		String homepage = "frontend/list_new_books.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}

}
