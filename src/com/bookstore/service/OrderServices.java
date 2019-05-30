package com.bookstore.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.frontend.shoppingcart.ShoppingCart;
import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;

public class OrderServices {

	private OrderDAO orderDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public OrderServices( HttpServletRequest request, HttpServletResponse response) {
		super();
		this.orderDAO = new OrderDAO();
		this.request = request;
		this.response = response;
	}
	
	public void listAllOrders() throws ServletException, IOException {
		List<BookOrder> listOrder = orderDAO.listAll();
		
		request.setAttribute("listOrder", listOrder);
		
		String orderPage= "order_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(orderPage);
		rd.forward(request, response);
	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		BookOrder bookorder = orderDAO.get(orderId);
		
		request.setAttribute("order",bookorder);
		String orderPage= "order_detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(orderPage);
		rd.forward(request, response);
	}

	public void showCheckoutForm() throws ServletException, IOException {
		String orderPage= "frontend/checkout.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(orderPage);
		rd.forward(request, response);
		
	}

	public void placeOrder() throws ServletException, IOException {
		String recipientname = request.getParameter("recipientName");
		String recipientphone = request.getParameter("recipientPhone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String paymentMethod = request.getParameter("paymentMethod"); 
		
		System.out.println("recipientname ="+recipientname+" recipientphone="+recipientphone+" address="+address+" city="+city+""
				+ "zipcode="+zipcode+" country="+" paymentMethod="+paymentMethod);
				
		BookOrder order = new BookOrder();
		order.setRecipientName(recipientname);
		order.setRecipientPhone(recipientphone);
		String Address = address +" "+city+" "+zipcode+" "+country;
		order.setShippingAddress(Address);
		order.setPaymentMethod(paymentMethod);
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		order.setCustomer(customer);
		
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		Map<Book,Integer> items = cart.getItems();
		Iterator<Book> iterator = items.keySet().iterator();
		Set<OrderDetail> orderdetails = new HashSet<>();
		
		while(iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = items.get(book);
			float subtotal = quantity*book.getPrice();
			OrderDetail detail = new OrderDetail();
			detail.setBook(book);
			detail.setBookOrder(order);
			detail.setQuantity(quantity);
			detail.setSubtotal(subtotal);
			orderdetails.add(detail);
		}
		order.setOrderDetails(orderdetails);
		order.setTotal(cart.getAmount());
		
		orderDAO.create(order);
		cart.clear();
		String message="Thankyou! Your order has been received successfully.We will deliver your Books within a few days.";
		request.setAttribute("message",message);
		String orderPage= "frontend/message.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(orderPage);
		rd.forward(request, response);
		
	}
}
