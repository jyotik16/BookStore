package com.bookstore.service;
import static com.bookstore.service.CommonUtitlity.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Customer;

public class CustomerServices {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerDAO customerDAO;
	
	public CustomerServices( HttpServletRequest request,HttpServletResponse response) {
		super();
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
		forwardToPage("customer_list.jsp", message, request, response);
	}

	public void create_customer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByemail(email);
		
		if (existCustomer != null) {
			String message = "Could not create new customer: the email "
					+ email + " is already registered by another customer.";
			listCustomers(message);
			
		} else {
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);
			customerDAO.create(newCustomer);
			
			String message = "New customer has been created successfully.";
			listCustomers(message);
			
		}
		
	}

	public void edit_customer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);
		if (customer == null) {
			String message = "Could not find customer with ID " + customerId;
			showMessageBackend(message, request, response);
		} else {
			request.setAttribute("customer", customer);		
			forwardToPage("customer_form.jsp", request, response);			
		}	
		
	}

	public void update_customer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("customerID"));
		String email = request.getParameter("email");
		Customer customerByEmail = customerDAO.findByemail(email);
		String message = null;
		
		if (customerByEmail != null && customerByEmail.getCustomerId() != customerId) {
			message = "Could not update the customer ID " + customerId
					+ "because there's an existing customer having the same email.";
			
		} else {
			
			Customer customerById = customerDAO.get(customerId);
			updateCustomerFieldsFromForm(customerById);
			
			customerDAO.update(customerById);
			
			message = "The customer has been updated successfully.";
		}
		
		listCustomers(message);
	}
	
	private void updateCustomerFieldsFromForm(Customer customer) {
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
		
		if(email!=null && !email.equals("")) {
		customer.setEmail(email);
		}
		if(Password!=null && !Password.equals("")) {
			customer.setPassword(Password);
			}
		customer.setFullname(Fullname);
		customer.setZipcode(Zipcode);
		customer.setPhone(Phoneno);
			
	}
	
	public void delete_customer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);
		
		if (customer != null) {
			ReviewDAO reviewDAO = new ReviewDAO();
			long reviewCount = reviewDAO.countByCustomer(customerId);
			
			if (reviewCount > 0) {
				String message = "Could not delete customer with ID " + customerId
						+ " because he/she posted reviews for books.";
				showMessageBackend(message, request, response);
			} else {
				OrderDAO orderDAO = new OrderDAO();
				long orderCount = orderDAO.countByCustomer(customerId);
				
			if (orderCount > 0) {
					String message = "Could not delete customer with ID " + customerId 
							+ " because he/she placed orders.";
					showMessageBackend(message, request, response);
			} else {
					customerDAO.delete(customerId);			
					String message = "The customer has been deleted successfully.";
					listCustomers(message);
				}
			}
		} else {
			String message = "Could not find customer with ID " + customerId + ", "
					+ "or it has been deleted by another admin";
			showMessageBackend(message, request, response);
		}
	}

	public void register_customer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByemail(email);
		//System.out.println(" --->"+exitcustomer.getEmail());
		String message = "";
		
		if (existCustomer != null) {
			message = "Could not register. The email "
					+ email + " is already registered by another customer.";
		} else {
			
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);			
			customerDAO.create(newCustomer);
			
			message = "You have registered successfully! Thank you.<br/>"
					+ "<a href='login'>Click here</a> to login";			
		}
		
		showMessageFrontend(message, request, response);
	
		
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
			String message = "Login failed. Please check your email and password.";
			request.setAttribute("message", message);
			showLogin();
		}else {
			
			HttpSession session = request.getSession();
			session.setAttribute("loggedCustomer", customer);
			Object objRedirectURL = session.getAttribute("redirectURL");
			
			if(objRedirectURL!=null) {
				String redirectURL = (String) objRedirectURL;
				session.removeAttribute("redirectURL");
				response.sendRedirect(redirectURL);
			}else {
					
			showCustomerProfile();
			}
		}		
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		forwardToPage("frontend/customer_profile.jsp", request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		forwardToPage("frontend/edit_profile.jsp", request, response);
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromForm(customer);
		customerDAO.update(customer);
		
		showCustomerProfile();
	}
}
