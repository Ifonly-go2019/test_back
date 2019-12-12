package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class adminView_005flookingstudents_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>adminView</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/adminView.css\"/>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"main\">\r\n");
      out.write("\t\t\t<div class=\"top\">\r\n");
      out.write("\t\t\t\t<div class=\"topMenue\">\r\n");
      out.write("\t\t\t\t\t<div class=\"topMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"index.jsp\">返回首页</a></li>\r\n");
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
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">添加管理员</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">删除管理员</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>成绩管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">成绩录入</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">成绩查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">成绩修改</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">成绩删除</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>课程管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">课程录入</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">课程查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">课程修改</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">课程删除</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"leftMenue_show\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"leftUl\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>考试管理</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">考试查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">考试发布</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">考试修改</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"\">补考申请</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t<div class=\"show\">\r\n");
      out.write("\t\t\t\t<div class=\"show_continent\">\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"first_th\">管理员账号</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"second_th\">密码</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"third_th\">邀请码</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"frouth_th\">功能</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>单行点点点显示</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>据说Chrome34+支持响应式图片，就是直接</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>纯css表格table隔行显示不同颜色_百度经验很多时候为了使得html页面表格比较好看,需要设置不同颜都</td>\r\n");
      out.write("                                <td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
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
