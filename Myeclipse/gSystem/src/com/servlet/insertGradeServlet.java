package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.gradeBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Admindao;
import Dao.GradeDao;

import tools.MyTools;

public class insertGradeServlet extends HttpServlet {

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
		 String uNo = MyTools.toChinese(request.getParameter("sNo"));
		 String cNo = MyTools.toChinese(request.getParameter("cNo"));
		 String grade = MyTools.toChinese(request.getParameter("grade"));
		 String sclass = MyTools.toChinese(request.getParameter("class"));
		 
		 String path = request.getContextPath();
		 String insert=path+"/insertGrade.jsp";
		 String admins=path+"/superAdminManagementpage.jsp";
		 
		 
		 gradeBean gd =new gradeBean();
		 gd.setsId(uNo);
		 gd.setcId(cNo);
		 gd.setGrade(grade);
		 gd.setClasses(sclass);
		 
		 
		 int flag=0;
		GradeDao gDao= new GradeDao();
		   flag=gDao.adduser(gd);
	       
		   if(flag>0){
		    	response.setHeader("refresh", "1,url="+insert);
		    	out.write("成功导入");
		    }else{
		    	response.setHeader("refresh", "1,url="+admins);
		    	out.write("导入失败");
		    }
	    
		 
	}

}
