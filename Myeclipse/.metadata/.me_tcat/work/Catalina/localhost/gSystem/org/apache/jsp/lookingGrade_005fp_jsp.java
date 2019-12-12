package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javaBean.*;
import DB.*;
import com.servlet.*;
import Dao.Admindao;
import Dao.GradeDao;

public final class lookingGrade_005fp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=gb2312");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write('\r');
      out.write('\n');
 
  studentBean student=(studentBean)session.getAttribute("students");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<title>studentsView</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/adminView.css\"/>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"main\">\r\n");
      out.write("\t\t\t<div class=\"top\">\r\n");
      out.write("\t\t\t\t<div class=\"topMenue\">\r\n");
      out.write("\t\t\t\t\t<div class=\"topMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"index.jsp\">首页</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"studentsManagementPage.jsp\">管理页面</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">刷新</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"left\">\r\n");
      out.write("\t\t\t\t<div class=\"leftMenue\">\r\n");
      out.write("\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t<ul class=\"leftUl\">\t\r\n");
      out.write("\t\t\t\t<h2>权限管理</h2>\r\n");
      out.write("\t\t       <li><a href=\"lookingStudents_personal.jsp\">学生管理</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t    <div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t<h2>成绩管理</h2>\r\n");
      out.write("\t\t\t\t");

				  out.println("<li>");
				  out.println("<a href=lookingGrade_p.jsp?sId="+student.getsNo()+">成绩查询</a>");
				  out.println("</li>");
				 
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>课程管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingClasses_p.jsp\">课程查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t<div class=\"show\">\r\n");
      out.write("\t\t\t\t<div class=\"show_continent\">\r\n");
      out.write("\t\t\t\t\t<form action=\"lookingGrade_p.jsp\" class=\"searchButton\">\r\n");
      out.write("\t\t\t\t\t   <input type=\"text\" name=\"sId\"  placeholder=\"请输入学号查询\" >\r\n");
      out.write("\t\t\t\t\t   <input type=\"submit\" value=\"查询\" >\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"first_th\">学号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"second_th\">课程编号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"third_th\">成绩</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"frouth_th\">班级</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"fiveth_th style=\"width=60px;\"\">功能</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t");

						GradeDao gd=new GradeDao();
						String sNo=request.getParameter("sId");
						String sql=null;
						if( sNo==null){
						 sql="select * from grade";
						}else{
							sql = "select * from grade where sId like '%" + sNo + "%'";
						}
						List<gradeBean> newlist= gd.findall(sql);
						for(gradeBean admin:newlist){
							out.println("<tr>");
							out.println("<td>"+admin.getsId()+"</td>");
							out.println("<td>"+admin.getcId()+"</td>");
							out.println("<td>"+admin.getGrade()+"</td>");
							out.println("<td>"+admin.getClasses()+"</td>");
							out.println("<td>权限不足</td>");
							/*out.println("<td><a href=changeGrade.jsp?sId="+admin.getsId()+"&cId="+admin.getcId()+"&grade="+admin.getGrade()+"&sclasses="+admin.getClasses()+">修改</a><a href=deleateGrade.jsp?sId="+admin.getsId()+"&cId="+admin.getcId()+">|  删除</a></td>");*/
							out.println("</tr>");
							/*out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">修改|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  删除</a></td></tr>");*/
						}
					  
						
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bottom\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
