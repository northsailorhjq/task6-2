package com.jikexueyuan.action;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jiekexueyuan.dao.impl.PoetriesDaoImpl;
import com.jikexueyuan.model.Poetries;
import com.opensymphony.xwork2.ActionSupport;

public class GetPeoByTitleAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() {
		ServletRequest req = ServletActionContext.getRequest();
		HttpServletRequest request=(HttpServletRequest) req;
		// 从表单获取title。
		String title = request.getParameter("title");
		PoetriesDaoImpl ps = new PoetriesDaoImpl();
		// 判断是否存在该诗。
		if (ps.queryPeoByTitle(title) != null) {
			// 如果存在，跳转到显示页面。
			Poetries p = ps.queryPeoByTitle(title);
			HttpSession session = request.getSession();
			session.setAttribute("p", p);
			return SUCCESS;
		} else {
			// 如果不存在，跳转失败页面。
			return ERROR;
		}

	}
}