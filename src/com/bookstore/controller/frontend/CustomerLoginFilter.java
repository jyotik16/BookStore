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
	private static final String[] loginRequriedURLs = {
			"/view_profile" , "/edit_profile" , "/update_profile"
	};
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
		String requesturl = httprequest.getRequestURL().toString();
		
		System.out.println("requestURL "+requesturl);
		System.out.println("path "+path);		
		System.out.println("loggedIn "+loggedin);
		
		if(!loggedin && isLoginReqiredURL(requesturl)) {
			RequestDispatcher rd = httprequest.getRequestDispatcher("frontend/loginPage.jsp");
			rd.forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
		
	}
	private boolean isLoginReqiredURL (String requesturl) {
		for(String loginURL:loginRequriedURLs) {
			if(requesturl.contains(loginURL)) {
				return true;
			}
		}
		return false;
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}