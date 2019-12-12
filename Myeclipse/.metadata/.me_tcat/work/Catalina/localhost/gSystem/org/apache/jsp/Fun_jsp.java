package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class Fun_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<title></title>\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\t*{\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tpadding: 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tbody{\r\n");
      out.write("\t\t\t\tbackground-color: azure;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#wrap{\r\n");
      out.write("\t\t\t\twidth: 500px;\r\n");
      out.write("\t\t\t\theight: 500px;\r\n");
      out.write("\t\t\t\tmargin: 0 auto;\r\n");
      out.write("\t\t\t\tborder: 1px solid black;\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#ball1{\r\n");
      out.write("\t\t\t\twidth: 100px;\r\n");
      out.write("\t\t\t\theight: 100px;\r\n");
      out.write("\t\t\t\tbackground: #FF0000;\r\n");
      out.write("\t\t\t    position: absolute;\t\r\n");
      out.write("\t\t\t\ttop: 300px;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#ball2{\r\n");
      out.write("\t\t\t\twidth: 100px;\r\n");
      out.write("\t\t\t\theight: 100px;\r\n");
      out.write("\t\t\t\tbackground: #1E90FF;\r\n");
      out.write("\t\t\t    position: absolute;\r\n");
      out.write("\t\t\t\tbottom: 300px;\r\n");
      out.write("\t\t\t\tright: 0px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div id=\"wrap\">\r\n");
      out.write("\t\t\t<div id=\"ball1\"></div>\r\n");
      out.write("\t\t\t<div id=\"ball2\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tvar warp=document.getElementById(\"wrap\");\r\n");
      out.write("\t\t\tvar ball1=document.getElementById(\"ball1\");\r\n");
      out.write("\t\t\tvar ball2=document.getElementById(\"ball2\");\r\n");
      out.write("\t\t\t// \r\n");
      out.write("\t\t\tvar speedx1=5;\r\n");
      out.write("\t\t\tvar speedx2=-3;\r\n");
      out.write("\t\t\tvar speedy1=2;\r\n");
      out.write("\t\t\tvar speedy2=-5;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tsetInterval(function(){\r\n");
      out.write("\t\t\t\tball1.style.left=ball1.offsetLeft+speedx1+\"px\";\r\n");
      out.write("\t\t\t\tball2.style.left=ball2.offsetLeft+speedx2+\"px\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tball1.style.top=ball1.offsetTop+speedy1+\"px\";\r\n");
      out.write("\t\t\t\tball2.style.top=ball2.offsetTop+speedy2+\"px\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/*用于判断两个方块是否到达边界*/\r\n");
      out.write("\t\t\t\tif(ball1.offsetLeft+ball1.offsetWidth>=warp.offsetWidth-2||ball1.offsetLeft<=0){\r\n");
      out.write("\t\t\t\t\tspeedx1*=-1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(ball2.offsetLeft+ball2.offsetWidth>=warp.offsetWidth-2||ball2.offsetLeft<=0){\r\n");
      out.write("\t\t\t\t\tspeedx2*=-1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(ball1.offsetTop+ball1.offsetHeight>=warp.offsetHeight-2||ball1.offsetTop<=0){\r\n");
      out.write("\t\t\t\t\tspeedy1*=-1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(ball2.offsetTop+ball2.offsetHeight>=warp.offsetHeight-2||ball2.offsetTop<=0){\r\n");
      out.write("\t\t\t\t\tspeedy2*=-1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/*用于判断两方块相撞时*/\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(ball1.offsetLeft>ball2.offsetLeft){                   /*ball1在ball12的左边*/\r\n");
      out.write("\t\t\t\t\tif(ball1.offsetLeft-ball2.offsetLeft<ball1.offsetWidth){    /*ball1与ball2的相交*/\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t// -------------------------------判断开始\r\n");
      out.write("\t\t\t\t\tif(ball1.offsetTop<ball2.offsetTop){\t/*ball1在ball2的上边*/\r\n");
      out.write("\t\t\t\t\tif(ball2.offsetTop-ball1.offsetTop<=ball1.offsetHeight){\r\n");
      out.write("\t\t\t\t\t\tspeedx1*=-1;\r\n");
      out.write("\t\t\t\t\t\tspeedx2*=-1;\r\n");
      out.write("\t\t\t\t\t\tspeedy1*=-1;\r\n");
      out.write("\t\t\t\t\t\tspeedy2*=-1;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}else if(ball1.offsetTop>ball2.offsetTop){\r\n");
      out.write("\t\t\t\t\tif(ball1.offsetTop-ball2.offsetTop<=ball2.offsetHeight){\r\n");
      out.write("\t\t\t\t\t\tspeedx1*=-1;\r\n");
      out.write("\t\t\t\t\t\tspeedx2*=-1;\r\n");
      out.write("\t\t\t\t\t\tspeedy1*=-1;\r\n");
      out.write("\t\t\t\t\t\tspeedy2*=-1;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t// ----------------------------------------判断结束\r\n");
      out.write("\t\t\t\t\t}\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(ball1.offsetLeft<ball2.offsetLeft){\r\n");
      out.write("\t\t\t\t\t\tif(ball2.offsetLeft-ball1.offsetLeft<ball1.offsetWidth){\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t// -------------------------------判断开始\r\n");
      out.write("\t\t\t\t\t\tif(ball1.offsetTop<ball2.offsetTop){\t\r\n");
      out.write("\t\t\t\t\t\tif(ball2.offsetTop-ball1.offsetTop<=ball1.offsetHeight){\r\n");
      out.write("\t\t\t\t\t\t\tspeedx1*=-1;\r\n");
      out.write("\t\t\t\t\t\t\tspeedx2*=-1;\r\n");
      out.write("\t\t\t\t\t\t\tspeedy1*=-1;\r\n");
      out.write("\t\t\t\t\t\t\tspeedy2*=-1;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}else if(ball1.offsetTop>ball2.offsetTop){\r\n");
      out.write("\t\t\t\t\t\tif(ball1.offsetTop-ball2.offsetTop<=ball2.offsetHeight){\r\n");
      out.write("\t\t\t\t\t\t\tspeedx1*=-1;\r\n");
      out.write("\t\t\t\t\t\t\tspeedx2*=-1;\r\n");
      out.write("\t\t\t\t\t\t\tspeedy1*=-1;\r\n");
      out.write("\t\t\t\t\t\t\tspeedy2*=-1;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},20)\r\n");
      out.write("\t\t</script>\r\n");
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
