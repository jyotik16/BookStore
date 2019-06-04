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



@WebServlet("/list_best_selling_book")
public class ViewBestSellingBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ViewBestSellingBooks() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO bookDAO = new BookDAO();
		long count = bookDAO.count();
		//System.out.println("count = "+count);
		List<Book> listBestSellingBooks = bookDAO.listBestSellingBooks((int)count);
		
		request.setAttribute("listBestSellingBooks", listBestSellingBooks);
		
		String homepage = "frontend/list_best_selling_books.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}

}
