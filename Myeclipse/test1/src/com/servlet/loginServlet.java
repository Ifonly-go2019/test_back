package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.userDao;

import tools.MyTools;

public class loginServlet extends HttpServlet {

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
		String username=MyTools.toChinese(request.getParameter("Name")) ;
		String password=MyTools.toChinese(request.getParameter("Password")) ;
		
		LoginBean login = new LoginBean();
		login.setName(username);
		login.setPassword(password);
		
		boolean flag=false;
		userDao userdao =new userDao();
		flag=userdao.checkUser(login);
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		String loginURL=basePath+"login.jsp";
		String vipURl=basePath+"VIP.jsp";
		
		if (username==null||password==null||username.equals("")){
			response.setHeader("Refresh", "0;url="+loginURL);
		}else if(flag==true){
			HttpSession session =request.getSession();
			session.setAttribute("LoginUsers",login);			
			response.setHeader("Refresh", "1;url="+vipURl);
			out.println("欢迎进入会员留言界面"+"\n"+username);
		}else{
			response.setHeader("Refresh", "3;url="+loginURL);
			out.println("输入的密码或用户名有误");
		}
		
	}

}
