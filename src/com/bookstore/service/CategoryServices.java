package com.bookstore.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;



public class CategoryServices {
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CategoryServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		categoryDAO = new CategoryDAO();

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
		
		String Name = request.getParameter("categoryname");
		
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
		int ID = Integer.parseInt(categoryId);
		System.out.println("categoryId=="+categoryId);
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
		int categoryId = Integer.parseInt(request.getParameter("id"));
		BookDAO bookdao = new BookDAO();
		long numOfBooks = bookdao.countBycategory(categoryId);
		String msg;
		if(numOfBooks>0) {
			msg = "Could not delete a category with (ID: %d) because it currently contains some books.";
			msg = String.format(msg,numOfBooks);
		}else {
				categoryDAO.delete(categoryId);
			 msg = "The category with ID " +categoryId+" has been delete successfully!";
		}
		
		listCategory(msg);
	}


	
}
