package com.ravi.basic.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		
		
		fc.doFilter(req, res);
		
		
		
	}

}
