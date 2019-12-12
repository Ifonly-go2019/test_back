package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.gradeBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GradeDao;
import Dao.classDao;

import tools.MyTools;

public class gradeUpdateServlet extends HttpServlet {

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
		String sId = MyTools.toChinese(request.getParameter("sId"));
		String cId = MyTools.toChinese(request.getParameter("cId"));
		String grade = MyTools.toChinese(request.getParameter("grade"));
		String sclasses = MyTools.toChinese(request.getParameter("sclasses"));
		String gId = MyTools.toChinese(request.getParameter("gId"));
		
		
		String path = request.getContextPath();
		String insert=path+"/changeGrade.jsp";
		
		
		gradeBean gd =new gradeBean();
		
		gd.setsId(sId);
		gd.setcId(cId);
		gd.setGrade(grade);
		gd.setClasses(sclasses);
		gd.setgId(gId);
		
		 
		 int flag=0;
		 GradeDao gDao= new GradeDao();
		 flag=gDao.upDate(gd);
	       
		   if(flag>0){
		    	response.setHeader("refresh", "1,url="+insert);
		    	out.write("成功导入");
		    }else{
		    	response.setHeader("refresh", "1,url="+insert);
		    	out.write("导入失败");
		    }	
		   
	}
		
		

}
