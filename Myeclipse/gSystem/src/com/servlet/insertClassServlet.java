package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javaBean.classBean;
import javaBean.gradeBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.MyTools;
import Dao.GradeDao;
import Dao.classDao;

public class insertClassServlet extends HttpServlet {

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
		 String cNo = MyTools.toChinese(request.getParameter("cNo"));
		 String cName = MyTools.toChinese(request.getParameter("cName"));
		
		 
		 String path = request.getContextPath();
		 String insert=path+"/insertClasses.jsp";
		 String admins=path+"/superAdminManagementpage.jsp";
		 
		 
		 classBean cb =new classBean();
		 cb.setcNo(cNo);
		 cb.setcName(cName);
		 
		 
		 
		 int flag=0;
		 classDao cDao= new classDao();
		 flag=cDao.adduser(cb);
	       
		   if(flag>0){
		    	response.setHeader("refresh", "1,url="+insert);
		    	out.write("成功导入");
		    }else{
		    	response.setHeader("refresh", "1,url="+insert);
		    	out.write("导入失败");
		    }
	}

}
