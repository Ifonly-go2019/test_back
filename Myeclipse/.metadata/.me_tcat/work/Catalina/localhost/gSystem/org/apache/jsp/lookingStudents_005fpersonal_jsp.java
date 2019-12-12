package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javaBean.*;
import DB.*;
import com.servlet.*;
import tools.*;
import Dao.Admindao;
import Dao.studentsDao;

public final class lookingStudents_005fpersonal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
  studentBean students=(studentBean)session.getAttribute("students");


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<title>studentsView</title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/studentsView.css\" />\r\n");
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
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>权限管理</h2>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingStudents_personal.jsp\">学生管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>成绩管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingGrade_p.jsp\">成绩查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>课程管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingClasses_p.jsp\">课程查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t<div class=\"show\">\r\n");
      out.write("\t\t\t\t<div class=\"show_continent\">\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"first_th\">学号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"second_th\">姓名</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"third_th\">密码</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"frouth_th\">性别</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"five_th\">专业</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"sixth_th\">学院</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"seventh_th\">功能</th>\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t");

						    studentsDao sdo=new studentsDao();
							String sNo=students.getsNo();
							String sql=null;
							if(sNo==null){
								sql="select * from students";
							}else{
						        sql="select * from students where sNo like '%" + sNo + "%'";
							}
						List<studentBean> newlist= sdo.findall(sql);
					   
						for(studentBean student:newlist){
							out.println("<tr><td>"+student.getsNo()+"</td><td>"+student.getsName()+"</td><td>"
									+student.getsPwd()+"</td><td>"+student.getsGender()+"</td><td>"+student.getsMajor()
									+"</td><td>"+student.getsDepart()+
									"</td><td><a href=changeStudents_p.jsp?sNo="+student.getsNo()+"&sName="+student.getsName()+"&sPwd="+student.getsPwd()+"&sGender="+student.getsGender()+"&sMajor="+student.getsMajor()+"&sDepart="+student.getsDepart()+">修改|</a><a href=deleateStudents.jsp?sNo="+student.getsNo()+">删除</a></td></tr>");
						}
						
      out.write("\t\r\n");
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
