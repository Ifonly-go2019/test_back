package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javaBean.LoginBean;

public final class VIP_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String loginUrl =basePath+"login.jsp";
/*HttpSession session1 =request.getSession();
String VIP=(String)session1.getAttribute("VIP");*/
/** 可以直接使用 String VIP = (String) session.getAttribute("VIP")来调取loginServlet中的session对象VIP，
因为JSP中有伪对象的概念
*/

LoginBean login =(LoginBean) session.getAttribute("LoginUsers");

if(login.getName()==null){
	response.setHeader("refresh","0;URL="+loginUrl);
}else{

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>留言板</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"留言板\">\r\n");
      out.write("\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("            body{\r\n");
      out.write("              font-size:12px;\r\n");
      out.write("            }\r\n");
      out.write("            #main{\r\n");
      out.write("              width:100%;\r\n");
      out.write("              height:400px;\r\n");
      out.write("              display: flex;\r\n");
      out.write("\t\t\t  justify-content: space-around;\r\n");
      out.write("            }\t\r\n");
      out.write("\t\t\t#top1{\r\n");
      out.write("\t\t\t\twidth:600px;\r\n");
      out.write("\t\t\t\theight: 200px;\r\n");
      out.write("\t\t\t\tborder-color:1px solid rgba(60,60,60,0.5);\r\n");
      out.write("\t\t\t\tborder-radius:5px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#top2{\r\n");
      out.write("\t\t\t border-radius: 5px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#top3{\r\n");
      out.write("\t\t\t  float:left;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#留言板{\r\n");
      out.write("\t\t\t font-size:14px;\r\n");
      out.write("\t\t\t color:rgba(60,60,60,0.5);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("  </head>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("  <div id=\"main\">\r\n");
      out.write("  <form action=\"");
      out.print(path );
      out.write("/servlet/test2Servlet\" name=\"talking\" method=\"get\" id=\"top3\">\r\n");
      out.write("  \r\n");
      out.write("       <p id=\"留言板\">留言板：<p>\r\n");
      out.write("\t\t<textarea rows=\"20\" cols=\"20\" id=\"top1\" name=\"userSpeaking\"></textarea>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t标题：<input type=\"text\" name=\"tittle\">\r\n");
      out.write("               用户名:<input type=\"text\" name=\"Name\" id=\"top2\">\r\n");
      out.write("        <input type=\"submit\" value=\"上载\">\r\n");
      out.write("        </div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("     \r\n");
}
      out.write('>');
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
