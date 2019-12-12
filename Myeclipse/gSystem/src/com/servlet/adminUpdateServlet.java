package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.adminBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.MyTools;
import Dao.Admindao;

public class adminUpdateServlet extends HttpServlet {

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
		String looking=path+"/lookingadmins.jsp";
		String index=path+"/index.jsp";
		String s="成功修改";
		String f="未能修改";
	    String uNo = MyTools.toChinese(request.getParameter("uNo"));
	    String uPwd =MyTools.toChinese(request.getParameter("uPwd"));
	    String uInumber = MyTools.toChinese(request.getParameter("uInumber"));
		
		
	    adminBean admin = new adminBean();
	    admin.setuNo(uNo);
	    admin.setuPwd(uPwd);
	    admin.setuInumber(uInumber);
	    
	    
	    
	      int flag=0;
		 Admindao aDao= new Admindao();
		   flag=aDao.upDate(admin);
		   if(flag>0){
		    	response.setHeader("refresh", "1,url="+looking);
		    	out.write(s);
		    }else{
		    	response.setHeader("refresh", "1,url="+looking);
		    	out.write(f);
		    }
	}

}
