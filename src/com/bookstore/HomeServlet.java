package com.bookstore;

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



@WebServlet(urlPatterns="")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			BookDAO bookDAO = new BookDAO();
					
			List<Book> listNewbooks = bookDAO.listNewBook();
			
			req.setAttribute("listNewbooks",listNewbooks);
			
			RequestDispatcher rd = req.getRequestDispatcher("frontend/index.jsp");
			rd.forward(req, resp);
		}


}
