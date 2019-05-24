package com.bookstore.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.Customer;

public class CustomerServices {

	private BookDAO bookDAO;	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerDAO customerDAO;
	
	public CustomerServices( HttpServletRequest request,HttpServletResponse response) {
		super();
		bookDAO = new BookDAO();
		this.customerDAO = new CustomerDAO();
		this.request = request;
		this.response = response;
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
			
		}
	public void listCustomers(String message) throws ServletException, IOException {
		
		List<Customer> listcustomer = customerDAO.listAll();
		request.setAttribute("listcustomer", listcustomer);
		if(message!=null) {
			request.setAttribute("message", message);
		}
		RequestDispatcher rd = request.getRequestDispatcher("customer_list.jsp");
		rd.forward(request, response);			
		}

	public void create_customer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer exitcustomer = customerDAO.findByemail(email);
		
		if(exitcustomer!=null) {
			String msg = "Could not create new customer because customer with this " +email+
					" already registered by another customer.";
			listCustomers(msg);
		}else {
			Customer newcustomer = new Customer();
			updateCustomerFieldsForm(newcustomer);
			customerDAO.create(newcustomer);
			listCustomers("New customer has been created successfully!");
			
		}
		
	}

	public void edit_customer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);
		request.setAttribute("customer", customer);
		//System.out.println("customer id ="+customerId);
		
		RequestDispatcher rd = request.getRequestDispatcher("customer_form.jsp");
		rd.forward(request, response);	
		
	}

	public void update_customer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("customerID"));
		String email = request.getParameter("email");
		Customer customerByEmail = customerDAO.findByemail(email);
		String msg;
		
		if(customerByEmail!=null && customerByEmail.getCustomerId()!=customerId) {
			msg = "Could not update customer becuase there 's another customer having the same email.";
			
		}else {						
			Customer customerById = customerDAO.get(customerId);
			updateCustomerFieldsForm(customerById);
			customerDAO.update(customerById);
			msg = "customer has been updated successfully!";
		}
		listCustomers(msg);
	}
	
	private void updateCustomerFieldsForm(Customer customer) {
		String email = request.getParameter("email");
		String Fullname = request.getParameter("fullname");
		String Phoneno = request.getParameter("phoneno");
		String address = request.getParameter("address");
		String Password = request.getParameter("password");
		String City = request.getParameter("city");
		String Country = request.getParameter("country");
		String Zipcode = request.getParameter("zipcode");
		
		customer.setAddress(address);
		customer.setCity(City);
		customer.setCountry(Country);
		customer.setEmail(email);
		customer.setFullname(Fullname);
		customer.setZipcode(Zipcode);
		customer.setPhone(Phoneno);
		customer.setPassword(Password);
		
	}
	
	public void delete_customer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		customerDAO.delete(customerId);
		
		listCustomers("The customers has been deleted successfully!");
	}

	public void register_customer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer exitcustomer = customerDAO.findByemail(email);
		//System.out.println(" --->"+exitcustomer.getEmail());
				String msg =null;
		if(exitcustomer!=null) {
			 msg = "Could not register. This " +email+
					" is already registered by another customer.";
			
		}else {
			
			Customer newcustomer = new Customer();
			updateCustomerFieldsForm(newcustomer);
			customerDAO.create(newcustomer);
			msg = "You have registered successfully. Thankyou!"+" <a href='login'> Click here </a> to login";
			
		}	
		request.setAttribute("message",msg);
		RequestDispatcher rd = request.getRequestDispatcher("frontend/message.jsp");
		rd.forward(request, response);
		
	}

	
	public void showLogin() throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("frontend/loginPage.jsp");
		rd.forward(request, response);
		
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerDAO.checkLogin(email, password);
		if(customer==null) {
			String msg = "Invalid email and password!";
			request.setAttribute("message", msg);
			showLogin();
		}else {
			request.getSession().setAttribute("loggedCustomer", customer);			
			showCustomerProfile();
		}		
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		System.out.println("profile...");
		RequestDispatcher rd = request.getRequestDispatcher("frontend/customer_profile.jsp");
		rd.forward(request, response);
	}
}
