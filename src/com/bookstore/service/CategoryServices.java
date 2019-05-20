package com.bookstore.service;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;



public class CategoryServices {
	private CategoryDAO categoryDAO;
	protected EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CategoryServices(EntityManager entityManager ,HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		categoryDAO = new CategoryDAO(entityManager);

	}
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
		
	}
	public void listCategory(String msg) throws ServletException, IOException {
		List<Category> listcategory = categoryDAO.listAll();
		if (msg != null) {
			request.setAttribute("message", msg);
		}
		
		request.setAttribute("categoryList", listcategory);

		RequestDispatcher rd = request.getRequestDispatcher("category_list.jsp");
		rd.forward(request, response);
		
		
	}

	
	public void createCategory() throws ServletException, IOException {
		
		String Name = request.getParameter("Name");
		
		Category exitCategory = categoryDAO.findByName(Name);
		if (exitCategory != null) {
			request.setAttribute("message", "Could not created new Category because "+Name + " category already exits!.");
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			rd.forward(request, response);

		} else {
			Category newcategory = new Category(Name);
			categoryDAO.create(newcategory);
		}
		
		
	}

	public void update_category() throws ServletException, IOException {
		String categoryId = request.getParameter("categoryId"); //hidden value
		System.out.println(categoryId);
		
		int ID = Integer.parseInt(categoryId);
		System.out.println(ID);
		String name = request.getParameter("Name");
				
		Category categoryById = categoryDAO.get(ID);
		Category categoryByName = categoryDAO.findByName(name);
		
		if(categoryByName!=null && categoryByName.getCategoryId()!=categoryById.getCategoryId()) {
			String msg ="Could not update category! This "+name+" category already exits!";
			request.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
			rd.forward(request,response);
			
		}else {
			categoryById.setName(name);
			categoryDAO.update(categoryById);
			String msg = "category has been updated successfully!";
			listCategory(msg);
		}
		
		
	}

	public void edit_category() throws ServletException, IOException {
		String s = request.getParameter("id");
		System.out.println(s);
		int ID = Integer.parseInt(s);
		Category editcategory = categoryDAO.get(ID);
		request.setAttribute("category",editcategory);
		RequestDispatcher rd = request.getRequestDispatcher("category_form.jsp");
		rd.forward(request, response);
		
	}
	public void delete_category() throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(ID);
		String msg = "category has been delete successfully!";
		listCategory(msg);
	}


	
}
