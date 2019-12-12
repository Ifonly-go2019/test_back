package org.apache.jsp.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import tools.*;
import Dao.*;
import javaBean.studentBean;
import Dao.Admindao;
import Dao.classDao;
import javaBean.gradeBean;

public final class SinsertGrade_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>录入成绩</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
  
   System.out.println("1");
    String sName = MyTools.toChinese( request.getParameter("sName"));
    String sNo = MyTools.toChinese(request.getParameter("sNo")) ;
    String sClasses = MyTools.toChinese( request.getParameter("sClasses"));
    String grade = MyTools.toChinese( request.getParameter("grade"));
    String cId = MyTools.toChinese( request.getParameter("cId"));
    
    gradeBean gb = new gradeBean();
    gb.setsId(sNo);
    gb.setcId(cId);
    gb.setClasses(sClasses);
    gb.setGrade(grade);
    
    
    GradeDao gdao =new GradeDao();
    int flag=0;
    
    flag=gdao.adduser(gb);
    if (flag>0){
        out.println(sNo+"号学生"+cId+"课程成绩已成功添加");
    }else {
      
        out.println("<h1></h1>");
        out.println(sNo+"号学生"+cId+"课程成绩添加失败");
    }

      out.write("\r\n");
      out.write("<a href=\"FinsertGrade.jsp\">返回</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("！");
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
