package com.villins.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BlogFilter implements Filter{
	
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	
	// ① 不需要登录即可访问的URI资源
	private static final String[] INHERENT_ESCAPE_URIS = { "/login.jsp", "about.jsp" };

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
