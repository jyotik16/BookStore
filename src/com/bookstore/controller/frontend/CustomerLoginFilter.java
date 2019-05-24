package com.bookstore.controller.frontend;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {

    public CustomerLoginFilter() {
        
    }
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest  = (HttpServletRequest) request;
		HttpSession session = httprequest.getSession(false);
		String path =httprequest.getRequestURI().substring(httprequest.getContextPath().length());
		
		if(path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
			}
		boolean loggedin = ((session!=null) && (session.getAttribute("loggedCustomer") !=null));
		System.out.println("path "+path);
		System.out.println("loggedIn "+loggedin);
		
		if(!loggedin && path.startsWith("/view_profile")) {
			RequestDispatcher rd = httprequest.getRequestDispatcher("frontend/loginPage.jsp");
			rd.forward(request, response);
		}else {
			
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
