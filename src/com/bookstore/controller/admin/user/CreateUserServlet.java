package com.bookstore.controller.admin.user;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.service.UserServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullname =  request.getParameter("fullname");
		String pass = request.getParameter("password");
		
		//response.getWriter().println(pass);
		
		UserServices u = new UserServices(entityManager,request,response);
		u.createUser();
		
		u.listUser("New User Created Successfully!");
		
		
	}

	
	

}
