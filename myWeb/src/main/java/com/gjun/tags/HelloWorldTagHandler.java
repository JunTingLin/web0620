package com.gjun.tags;



import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloWorldTagHandler implements Tag{

	private PageContext pageContext;
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.println("<font size='7' color='red'>再見!!</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.println("<font size='7' color='red'>您好!!</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext=pageContext;
		
	}

	@Override
	public void setParent(Tag t) {
		// TODO Auto-generated method stub
		
	}
	
}
