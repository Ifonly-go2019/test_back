package com.experiment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.MyTools;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

public class test3 extends HttpServlet {

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
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String loginURL=basePath+"GoodsInput.jsp";
		String userName=MyTools.toChinese(request.getParameter("Name"));
		System.out.println(userName);
		PrintWriter out = response.getWriter();
		
		
		response.setHeader("Refresh", "0;url="+loginURL);
		HttpSession session=request.getSession();
		session.setAttribute("VIPname", userName);
	    out.println("ÄúÒÑ½øÈë"+userName);
	}

}
