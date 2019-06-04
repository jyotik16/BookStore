package com.bookstore.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.dao.UsersDAO;
import com.bookstore.entity.Users;
import static com.bookstore.service.CommonUtitlity.*;
public class UserServices{
	private UsersDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		userDAO = new UsersDAO();
	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUsers  = userDAO.listAll();
		request.setAttribute("listUsers", listUsers);
		if (message != null) {
			request.setAttribute("message", message);
		}
		forwardToPage("user_list.jsp", message, request, response);
	}

	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		Users exitUser = userDAO.findByEmail(email);
		String message = null;
		if (exitUser != null) {
			request.setAttribute("message", email + " already exits!New User is not created.");			
			forwardToPage("message.jsp", message, request, response);
		} else {
			Users newuser = new Users(email, fullname, password);
			userDAO.create(newuser);
		}

	}

	public void editUser() throws ServletException, IOException {
				
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId );

		String destPage = "user_form.jsp";
		
		if (user == null) {
			destPage = "message.jsp";
			String errorMessage = "Could not find user with ID " + userId;
			request.setAttribute("message", errorMessage);
		} else {
			request.setAttribute("user", user);			
		}
		forwardToPage(destPage, request, response);
		
	}

	public void updateUser() throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int id = Integer.parseInt(userId);
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		System.out.println(email+" "+password);
		
		Users userById = userDAO.get(id);
		Users usersByEmail = userDAO.findByEmail(email);
		if(usersByEmail!=null && usersByEmail.getUserid()!=userById.getUserid()) {
			String msg ="Could not update user! This "+email+" email already exits";
			request.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			rd.forward(request, response);
			
		}else {
			Users updateuser = new Users(id,email,fullname,password);
			userDAO.update(updateuser);
			String msg = "user has been update successfully!";
			listUser(msg);
		}
		
	}

	public void delete_user() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		String message = null;
		Users user= userDAO.get(userId);
		if (user == null) {
			message = "Could not find user with ID " + userId
					+ ", or it might have been deleted by another admin";			
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);			
		} else {
			message = "User has been deleted successfully";
			userDAO.delete(userId);
			listUser(message);
		}	
	}
	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean loginresult = userDAO.checkLogin(email, password);
		if(loginresult) {
			System.out.println("User is authenticated");
			request.getSession().setAttribute("useremail", email);
			RequestDispatcher rd = request.getRequestDispatcher("admin_index.jsp");
			rd.forward(request, response);
			
		}else {
			System.out.println("Login failed!");
			request.setAttribute("message","Login failed!");
			RequestDispatcher rd = request.getRequestDispatcher("admin_login.jsp");
			rd.forward(request, response);
			
			
		}
		
	}
}
