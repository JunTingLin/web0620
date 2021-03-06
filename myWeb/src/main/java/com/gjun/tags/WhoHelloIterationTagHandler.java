package com.gjun.tags;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class WhoHelloIterationTagHandler extends TagSupport {
	private String who;
	private String information;
	private int count = 1;
	// 打招呼的次數
	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public int doAfterBody() throws JspException {
		if (this.count <= this.counter) {
			JspWriter out = this.pageContext.getOut();
			String msg = String.format("<font size='7' color='red'>%s 說...%s</font><br/>", who, information);
			try {
				out.println(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			return EVAL_BODY_AGAIN; 
		}else {
			return EVAL_PAGE;
		}
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

}
