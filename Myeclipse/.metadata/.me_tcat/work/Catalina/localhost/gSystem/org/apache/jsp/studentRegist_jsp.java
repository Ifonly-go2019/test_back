package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class studentRegist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<title>注册页面</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/regist.css\" />\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t<div id=\"show\">\r\n");
      out.write("\t\t\t\t<a>请填写注册信息</a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"drop\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.print(path );
      out.write("/servlet/StudentRegistServlet\" method=\"get\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<p>学号<p><input type=\"text\" name=\"sNo\">\r\n");
      out.write("\t\t\t\t\t\t<p>姓名</p><input type=\"text\" name=\"sName\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<p>密码</p><input type=\"password\" name=\"sPwd\">\r\n");
      out.write("\t\t\t\t\t\t<p>性别</p><input type=\"text\" name=\"sGender\">\r\n");
      out.write("\t\t\t\t\t\t<p>专业</p><input type=\"text\" name=\"sMajor\">\r\n");
      out.write("\t\t\t\t\t\t<p>系别</p><input type=\"text\" name=\"sDepart\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"点击注册\" id=\"button\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
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
