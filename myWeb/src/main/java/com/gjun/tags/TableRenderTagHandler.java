package com.gjun.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TableRenderTagHandler extends BodyTagSupport{
	private List<String> data;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	@Override
	public int doEndTag() throws JspException {
		String title = this.bodyContent.getString();
		JspWriter out = this.bodyContent.getEnclosingWriter();
		try {
			out.println("<font size='6' colo='red'>"+title+"</font>");
			for(String content:data) {
				out.println("<font size='3' color='blue'>"+content+"</font>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}
	

}
