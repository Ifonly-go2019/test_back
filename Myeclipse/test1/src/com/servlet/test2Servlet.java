package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javaBean.VipBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.messageDao;

import tools.MyTools;

public class test2Servlet extends HttpServlet {

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
		 String path = request.getContextPath();
		 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
		 boolean flag=false;
		
		 String name =MyTools.toChinese( request.getParameter("Name"));
         String speaking =MyTools.toChinese(request.getParameter("userSpeaking")) ;
         String tittle =MyTools.toChinese( request.getParameter("tittle"));
		 String VipTime=MyTools.DateFormat(new Date()); 
         
         response.setContentType("text/html;charset=gb2312");
		 PrintWriter out = response.getWriter();
		
		 VipBean vip =new VipBean();
		 vip.setName(name);
		 vip.setTittle(tittle);
		 vip.setUserSpeaking(speaking);
		 vip.setVipTime(VipTime);
		
		   messageDao md=new messageDao();
		    flag =md.adduser(vip);
		    System.out.println(flag);
		   if(flag){
			   System.out.println("≤Â»Î≥…π¶");
			    HttpSession session=request.getSession();
				 session.setAttribute("VipUsers", vip);	
				 response.sendRedirect(basePath+"ShowVip.jsp");
				
		   }
	
	}

}
