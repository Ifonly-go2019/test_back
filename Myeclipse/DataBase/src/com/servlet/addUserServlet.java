package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.addUserDao;

import javeBean.useBean;

import tools.MyTools;

public class addUserServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
		String regist=path+"/regist.jsp";
		String uName = MyTools.toChinese(request.getParameter("uName"));
		String uPwd = MyTools.toChinese(request.getParameter("uPwd"));
		String uEmail = MyTools.toChinese(request.getParameter("uEmail"));
	    String s="³É¹¦×¢²á";
	    String f="Î´ÄÜ×¢²á";
	    
	    useBean usebean =new useBean();
	    usebean.setuName(uName);
	    usebean.setuPwd(uPwd);
	    usebean.setuEmail(uEmail);
	    
	    int flag=0;
	    addUserDao ado = new addUserDao();
	    flag=ado.adduser(usebean);
	    
	    if(flag>0){
	    	response.setHeader("refresh", "3,url="+regist);
	    	out.write(s);
	    }else{
	    	response.setHeader("refresh", "3,url="+regist);
	    	out.write(f);
	    }
	}

}
