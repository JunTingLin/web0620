package com.gjun.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class MyBodyTagHandler implements BodyTag{
	private PageContext pageContext;
	private Tag parent;
	private BodyContent bodyContent;
	
	@Override
	public int doAfterBody() throws JspException {
		JspWriter innerWriter = this.bodyContent.getEnclosingWriter();
		String sourceBody = this.bodyContent.getString();
		String msg=String.format("<font size='7'>我是Body內容...%s</font>",sourceBody);
		try {
			innerWriter.print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.println("<font size='4'>開頭標籤處理</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public Tag getParent() {
		return this.parent;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pc) {
		this.pageContext=pc;
		
	}

	@Override
	public void setParent(Tag parent) {
		this.parent=parent;
		
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
		
	}

}
