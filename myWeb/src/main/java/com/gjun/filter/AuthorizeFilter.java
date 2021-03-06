package com.gjun.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

/**
 * Servlet Filter implementation class AuthorizeFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, urlPatterns = { "/acct/*" })
public class AuthorizeFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthorizeFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String errMsg = null ;
		boolean isValid = false;
		Cookie[] cookies = req.getCookies();
		if(cookies==null) {
			errMsg="前端無任何cookies!";
		}else {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("cred")) {

					HttpSession session = req.getSession(false); //假如get不到，不須幫我建新的
					HttpSession testSession =req.getSession(true);
					testSession.setAttribute("deliberate", "為了讓後端有其他session，故意在多建造一個");
					if(session==null) {
						errMsg="session為空";
					}else {
						Object obj = session.getAttribute("cred");
						if(obj!=null) {
							if(cookie.getValue().equals(obj.toString())) {
								isValid=true;
								break;
							}else {
								errMsg="前後端值對不上，偽造身分憑證....";
							}
						}else {
							errMsg="後端session getAttribute為空";
						}
					}
					
				}
			}
			
		}
		System.out.println("isValid="+isValid);
		if(isValid) {
			chain.doFilter(req, resp);
		}else {
			resp.sendError(401, errMsg);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
