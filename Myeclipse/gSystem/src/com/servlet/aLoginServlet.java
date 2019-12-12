package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.adminBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Admindao;

public class aLoginServlet extends HttpServlet {

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
      String login=path+"/adminLogin.jsp";
      String admins=path+"/superAdminManagementpage.jsp";

      String uNo=request.getParameter("uNo");
      String uPwd=request.getParameter("uPwd");
      Admindao aDao = new Admindao();
      adminBean admin=aDao.checkLogin(uNo, uPwd);

    if(admin==null){
	out.write("µÇÂ¼Ê§°Ü");
	response.setHeader("refresh", "1,url="+login);
     }else{
	out.write("µÇÂ¼³É¹¦");
	response.setHeader("refresh", "1,url="+admins);
	
     }


	}
	
}
