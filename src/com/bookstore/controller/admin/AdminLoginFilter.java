package com.bookstore.controller.admin;

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

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter");
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpSession session = httprequest.getSession(false);
		boolean loggedIn = (session!=null) && session.getAttribute("useremail") != null;
		String loginURI = httprequest.getContextPath()+"/admin/admin_login";
		System.out.println(loginURI);
		boolean loginRequest = httprequest.getRequestURI().equals(loginURI);
		boolean loginPage = httprequest.getRequestURI().endsWith("admin_login.jsp");
		if(loggedIn &&( loginRequest || loginPage)) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/");
			rd.forward(request, response);
				
		}else if(loggedIn || loginRequest) {
			System.out.println("user logged in..");
			chain.doFilter(request, response);
		}
		else {
			System.out.println("user not logged in..");
			RequestDispatcher rd = request.getRequestDispatcher("admin_login.jsp");
			rd.forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
