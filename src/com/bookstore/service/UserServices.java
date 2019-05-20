package com.bookstore.service;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.dao.UsersDAO;
import com.bookstore.entity.Users;

public class UserServices{
	private UsersDAO userDAO;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		userDAO = new UsersDAO(entityManager);

	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String msg) throws ServletException, IOException {
		List<Users> list = userDAO.listAll();
		if (msg != null) {
			request.setAttribute("message", msg);
		}
		request.setAttribute("usersList", list);

		RequestDispatcher rd = request.getRequestDispatcher("user_list.jsp");
		rd.forward(request, response);

	}

	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		Users exitUser = userDAO.findByEmail(email);
		if (exitUser != null) {
			request.setAttribute("message", email + " already exits!New User is not created.");
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			rd.forward(request, response);

		} else {
			Users newuser = new Users(email, fullname, password);
			userDAO.create(newuser);
		}

	}

	public void editUser() throws ServletException, IOException {
				
		String s = request.getParameter("id");
		//System.out.println(s);
		int ID = Integer.valueOf(s);
		Users edituser = userDAO.get(ID);
		request.setAttribute("user",edituser);
		RequestDispatcher rd = request.getRequestDispatcher("user_form.jsp");
		rd.forward(request, response);
	
		
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
		int Id = Integer.parseInt(request.getParameter("id"));
		userDAO.delete(Id);
		String msg = "user has been delete successfully!";
		listUser(msg);
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
