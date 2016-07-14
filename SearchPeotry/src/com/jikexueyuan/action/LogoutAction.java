package com.jikexueyuan.action;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	public String execute() {
		ServletRequest req = ServletActionContext.getRequest();
		HttpServletRequest request=(HttpServletRequest) req;
		HttpSession session=request.getSession();
		session.invalidate();
		return SUCCESS;
	}
}