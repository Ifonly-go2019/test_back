package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javaBean.*;
import Dao.*;
import tools.MyTools;

public final class insertGrade_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<title>adminView</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/changeStudents.css\"/>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/studentsView.css\" />\r\n");
      out.write("\t \r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"main\">\r\n");
      out.write("\t\t\t<div class=\"top\">\r\n");
      out.write("\t\t\t\t<div class=\"topMenue\">\r\n");
      out.write("\t\t\t\t\t<div class=\"topMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"index.jsp\">首页</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"superAdminManagementpage.jsp\">管理页面</a></li>\r\n");
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
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingadmins.jsp\">管理员管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingStudents.jsp\">学生管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>成绩管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"insertGrade.jsp\">成绩录入</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingGrade.jsp\">成绩查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"changeGrade.jsp\">成绩修改</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>课程管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"insertClasses.jsp\">课程录入</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"lookingClasses.jsp\">课程查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t    <li><a href=\"changeClasses.jsp\">课程修改</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t<div class=\"show\">\r\n");
      out.write("\t\t\t\t<div class=\"show_continent\">\r\n");
      out.write("\t\t\t\t      <div id=\"show\" style=\"top:-20px;left:200px; height:30px;width:300px; opcity:0.5\">\r\n");
      out.write("\t\t\t\t      \t\r\n");
      out.write("\t\t\t\t      <form action=\"insertGrade.jsp\" class=\"searchButton\">\r\n");
      out.write("\t\t\t\t\t   <input type=\"text\" name=\"sClasses\"  placeholder=\"请输入班级\" >\r\n");
      out.write("\t\t\t\t\t   <input type=\"submit\" value=\"查询\" >\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t     </div>\r\n");
      out.write("\t\t\t\t     <table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t    <th  style=\"width:120px;\">姓名</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th >学号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th >班级</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th >成绩</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th >课程编号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th style=\"width=60px;\">功能</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t     ");

						GradeDao gd=new GradeDao();
						String sClasse= MyTools.toChinese( request.getParameter("sClasses"));
						String sql=null;
						
						List<inGradeBean> newlist= gd.findGrade(sClasse);
						for(inGradeBean admin:newlist){
							out.println("<tr>");
							out.println("<td>"+"<input type=text id=inputsName    name=sName  value="+admin.getsName()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputsNo      name=sNo    value="+admin.getsNo()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputClasses  name=sClasses value="+admin.getsClasses()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputGrade    name=grade  value="+admin.getGrade()+">"+" </td>");
							out.println("<td>"+"<input type=text id=inputId       name=cId    value="+admin.getcId()+">"+"</td>");
							out.println("<td>"+"<input type=button value=录入 onclick=submit()>"+"</td>");
							out.println("<a id=url ></a>");
							out.println("</tr>");
							/*out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">修改|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  删除</a></td></tr>");*/
						}
					  
						/**for(inGradeBean admin:newlist){
							out.println("<tr>");
							out.println("<td id=inputsName    name=sName>"+admin.getsName()+"</td>");
							out.println("<td>"+"<input type=text id=inputsNo      name=sNo    value="+admin.getsNo()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputClasses  name=sClasses value="+admin.getsClasses()+">"+"</td>");
							out.println("<td>"+"<input type=text id=inputGrade    name=grade  value="+admin.getGrade()+">"+" </td>");
							out.println("<td>"+"<input type=text id=inputId       name=cId    value="+admin.getcId()+">"+"</td>");
							out.println("<td><a id=linkTo href= >录入</a></td>");
							out.println("</tr>");
							/*out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">修改|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  删除</a></td></tr>");*/
						/*}**/
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t     \r\n");
      out.write("\t\t\t\t     \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bottom\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("    \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write(" <script src=\"http://localhost:8080/gSystem/js/jQuery/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("   function submit(){\r\n");
      out.write("var sName = document.getElementById('inputsName').value;\r\n");
      out.write("var sNo = document.getElementById('inputsNo').value;\r\n");
      out.write("\r\n");
      out.write("var sClasses = document.getElementById('inputClasses').value;\r\n");
      out.write("var grade = document.getElementById('inputGrade').value;\r\n");
      out.write("var cId = document.getElementById('inputId').value;\r\n");
      out.write("console.log(sName);\r\n");
      out.write("document.getElementById(\"url\").innerHTML = '<a href=\"SinsertGrade.jsp?sName='+sName+'&sClasses='+sClasses+'&cId='+cId+'&grade='+grade+'&sNo='+sNo+'\">提交</a>';\r\n");
      out.write("alert(document.getElementById(\"url\").innerHTML);\r\n");
      out.write("}\r\n");
      out.write("</script>");
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
