package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class regist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title></title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\tbody{\r\n");
      out.write("\t\t\t\tbackground-color: #7FFFD4;\r\n");
      out.write("\t\t\t\tdisplay: flex;\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.top{\r\n");
      out.write("\t\t\tfont-size: 20px;\r\n");
      out.write("\t\t\tcolor: brown;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.top form{\r\n");
      out.write("\t\t\tfont-size: 12px;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#button{\r\n");
      out.write("\t\t\tflex: left;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"top\">\r\n");
      out.write("           <p>请填写注册信息</p>\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t   <form  action=\"");
      out.print(path );
      out.write("/servlet/addUserServlet\" method=\"get\">\r\n");
      out.write("\t\t\t\t   \r\n");
      out.write("\t\t\t\t   <div >\r\n");
      out.write("\t\t\t\t\t   <p>昵称<p><input  type=\"text\" name=\"uName\">\r\n");
      out.write("\t\t\t\t\t   <p>密码</p><input type=\"password\" name=\"uPwd\">\r\n");
      out.write("\t\t\t\t\t   <p>密保邮箱</p><input type=\"email\" name=\"uEmail\">\r\n");
      out.write("\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t   </div>\r\n");
      out.write("\t\t\t\t   <input type=\"submit\" value=\"点击注册\" id=\"button\">\r\n");
      out.write("\t\t\t   </form>\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t     </div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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