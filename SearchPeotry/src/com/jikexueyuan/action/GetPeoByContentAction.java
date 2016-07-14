package com.jikexueyuan.action;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jiekexueyuan.dao.impl.PoetriesDaoImpl;
import com.jikexueyuan.model.Poetries;
import com.opensymphony.xwork2.ActionSupport;

public class GetPeoByContentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() {
		ServletRequest req = ServletActionContext.getRequest();
		HttpServletRequest request=(HttpServletRequest) req;
		// 从表单获取content。
		String content = request.getParameter("content");
		// 查询结果添加到集合当中。
		PoetriesDaoImpl ps = new PoetriesDaoImpl();
		List<Poetries> poetries = ps.queryPoetryByContent(content);
		HttpSession session = request.getSession();
		// 添加session，传递值到显示页面。
		session.setAttribute("poetries", poetries);
		return SUCCESS;
	}
}