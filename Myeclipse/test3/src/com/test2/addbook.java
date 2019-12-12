package com.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.MyTools;

public class addbook extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        String bookName =MyTools.toChinese(request.getParameter("bookNAME")); 
        String publisher=MyTools.toChinese( request.getParameter("publisher"));
        
        HttpSession session= request.getSession();
        session.setAttribute("bookName", bookName);
        HttpSession session2= request.getSession();
        session.setAttribute("publisher", publisher);
        
        response.setHeader("refresh", "0;URL="+"showbooks.jsp");
        
	}

}
