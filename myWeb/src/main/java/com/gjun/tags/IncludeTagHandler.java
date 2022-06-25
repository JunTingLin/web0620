package com.gjun.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IncludeTagHandler extends BodyTagSupport {
	private String who;
	private BodyContent bodyContent;

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

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
	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public void setBodyContent(BodyContent b) {
		this.bodyContent=b;
	}
	
	
}
