package com.bookstore.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;
import static com.bookstore.service.CommonUtitlity.*;


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
	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);	
		
		forwardToPage("category_list.jsp",message, request, response);
		
		
	}

	public void createCategory() throws ServletException, IOException {
		
		String name = request.getParameter("categoryname");		
		Category existCategory = categoryDAO.findByName(name);
		//System.out.println(" category name ="+existCategory.getName());
		if (existCategory != null) {
			String message = "Could not create category."
					+ " A category with name " + name + " already exists.";
			request.setAttribute("message", message);
			showMessageBackend(message, request, response);
		} else {
			Category newCategory = new Category(name);
			categoryDAO.create(newCategory);
			String message = "New category created successfully.";
			listCategory(message);
		}
		
		
	}

	public void update_category() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println("categoryId ="+categoryId);
		String categoryName = request.getParameter("categoryname");
				
		Category categoryById = categoryDAO.get(categoryId);
		System.out.println(" CATEGORY->"+categoryById.getName());
		Category categoryByName = categoryDAO.findByName(categoryName);
		
		if (categoryByName != null && categoryById!=null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {
			String message = "Could not update category."
					+ " A category with name " + categoryName + " already exists.";
			request.setAttribute("message", message);
			showMessageBackend(message, request, response);			
		} else {
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			String message = "Category has been updated successfully";
			listCategory(message);
		}
		
		
	}

	public void edit_category() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		
		if (category != null) {
			request.setAttribute("category", category);
			forwardToPage("category_form.jsp", request, response);
		} else {
			String message = "Could not find category with ID " + categoryId;
			request.setAttribute("message", message);
			showMessageBackend(message, request, response);
		}
		
	}
	public void delete_category() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		String message = null;
		if (category == null) {
			message = "Could not find category with ID " + categoryId + ", or it might have been deleted";
			request.setAttribute("message", message);
			showMessageBackend(message, request, response);
			return;
		}
		BookDAO bookdao = new BookDAO();
		long numOfBooks = bookdao.countByCategory(categoryId);
		
		if(numOfBooks>0) {
			message = "Could not delete a category with (ID: %d) because it currently contains some books.";
			message = String.format(message,numOfBooks);
		}else {
				
			message = "The category with ID " +categoryId+" has been delete successfully!";
			 categoryDAO.delete(categoryId);
		}
		
		listCategory(message);
	}


	
}
