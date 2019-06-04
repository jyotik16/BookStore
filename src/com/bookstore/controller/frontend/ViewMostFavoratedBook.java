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


@WebServlet("/list_most_favorated_book")
public class ViewMostFavoratedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewMostFavoratedBook() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO bookDAO = new BookDAO();
		int count = (int) bookDAO.count();
		System.out.println("count = "+count);
		List<Book> listMostFavoredBooks = bookDAO.listMostFavoredBooks(count);
		
		request.setAttribute("listMostFavoredBooks", listMostFavoredBooks);
		
		String homepage = "frontend/list_most_favorated_book.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}

}
