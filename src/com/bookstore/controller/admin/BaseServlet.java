package com.bookstore.controller.admin;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	@Override
	public void destroy() {
		entityManager.close();
		entityManagerFactory.close();
		
	}
	@Override
	public void init() throws ServletException {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
	}
	

}
