package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaBean.studentBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.MyTools;
import Dao.studentsDao;

public class insertSrudentsServlert extends HttpServlet {

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
		String regist=path+"/insertStudent.jsp";
		String index=path+"/index.jsp";
		String uNo = MyTools.toChinese(request.getParameter("sNo"));
	    String uName = MyTools.toChinese(request.getParameter("sName"));
	    String uPwd =MyTools.toChinese(request.getParameter("sPwd"));
	    String uGender=MyTools.toChinese(request.getParameter("sGender"));
	    String uMajor=MyTools.toChinese(request.getParameter("sMajor"));
	    String uDepart=MyTools.toChinese(request.getParameter("sDepart"));
	    String s="成功添加";
	    String f="未能添加";
	    
	    
	   studentBean student=new studentBean();
	   student.setsNo(uNo);
	   student.setsName(uName);
	   student.setsPwd(uPwd);
	   student.setsGender(uGender);
	   student.setsMajor(uMajor);
	   student.setsDepart(uDepart);
	   
	   int flag=0;
	   studentsDao sDao= new studentsDao();
	   flag=sDao.adduser(student);
       
	   if(flag>0){
	    	response.setHeader("refresh", "1,url="+regist);
	    	out.write(s);
	    }else{
	    	response.setHeader("refresh", "1,url="+regist);
	    	out.write(f);
	    }
	       
	}

}
