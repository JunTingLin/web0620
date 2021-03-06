package com.gjun.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encoding;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		req.setCharacterEncoding("UTF-8");
		System.out.println("有人來了...");
		req.setCharacterEncoding(this.encoding);
		resp.setCharacterEncoding(this.encoding);
		chain.doFilter(req, resp);
		System.out.println("有人要回去了");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		System.out.println("編碼攔截器活過來了...");
		this.encoding = filterConfig.getInitParameter("encoding");
	}
	
}
