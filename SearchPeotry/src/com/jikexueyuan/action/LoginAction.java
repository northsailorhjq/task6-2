package com.jikexueyuan.action;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jiekexueyuan.dao.impl.UserDaoImpl;
import com.jikexueyuan.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() {
		ServletRequest req = ServletActionContext.getRequest();
		HttpServletRequest request=(HttpServletRequest) req;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDaoImpl us = new UserDaoImpl();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		// 判断用户登录状态。
		if (us.IsUser(user)) {
			// 如果用户名及密码正确，跳转到主页面。
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

}
