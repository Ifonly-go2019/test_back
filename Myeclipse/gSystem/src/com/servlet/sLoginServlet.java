package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.studentBean;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.studentsDao;

public class sLoginServlet extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
	    String login=path+"/studentLogin.jsp";
	    String admins=path+"/studentsManagementPage.jsp";
        
	    HttpSession session=request.getSession();
	    String uNo=request.getParameter("uNo");
	    String uPwd=request.getParameter("uPwd");
	    
	    
	    
	    studentsDao sDao=new studentsDao();
	    studentBean student =sDao.checkLogin(uNo, uPwd);
	    

	    if(student==null){
		out.write("false");
		response.setHeader("refresh", "1,url="+login);
	     }else{
	     session.setAttribute("students", student);
		 out.write("success");
		response.setHeader("refresh", "1,url="+admins);
	    
	    
	    
	}

}
}
