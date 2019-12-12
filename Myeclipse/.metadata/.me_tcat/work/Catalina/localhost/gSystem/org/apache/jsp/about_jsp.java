package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<title>留言</title>\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\tbody{\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t/* \tli{\r\n");
      out.write("\t\t\t\tlist-style: none;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t} */\r\n");
      out.write("\t\t\t#warring{\r\n");
      out.write("\t\t\t\tfont-size: 12px;\r\n");
      out.write("\t\t\t\tcolor: red;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#btnSent{\r\n");
      out.write("\t\t\tflex: left;\r\n");
      out.write("\t\t\twidth: 100px;\r\n");
      out.write("\t\t\theight: 30px;\r\n");
      out.write("\t\t\tborder-width: 0px;\r\n");
      out.write("\t\t\tborder-radius: 3px;\r\n");
      out.write("\t\t\tbackground: #1E90FF;\r\n");
      out.write("\t\t\tcursor: pointer;\r\n");
      out.write("\t\t\toutline: none;\r\n");
      out.write("\t\t\tfont-family: Microsoft YaHei;\r\n");
      out.write("\t\t\tcolor: white;\r\n");
      out.write("\t\t\tfont-size: 17px;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#listMeg li{\r\n");
      out.write("\t\t\t\tfont-size: 14px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#textkey{\r\n");
      out.write("\t\t\t\twidth: 300px;\r\n");
      out.write("\t\t\t\theight: 25px;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"main\">\r\n");
      out.write("\t\t\t\t<input type=\"text\"  id=\"textkey\" value=\"\" >\r\n");
      out.write("\t\t\t\t<input type=\"button\"  id=\"btnSent\" value=\"发布\" >\r\n");
      out.write("\t\t\t\t<span id=\"warring\"></span>\r\n");
      out.write("\t\t\t\t<ul id=\"listMeg\">\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</body>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction Appendzero(obj)\r\n");
      out.write("    {\r\n");
      out.write("        if(obj<10) return \"0\" +\"\"+ obj;\r\n");
      out.write("        else return obj;\r\n");
      out.write("   }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"btnSent\").onclick=function(){\r\n");
      out.write("\t\t\tvar textkeyValue =document.getElementById(\"textkey\").value;\r\n");
      out.write("\t\t\tif(textkeyValue.length==0){\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"warring\").innerText=\"请输入要发布的留言!!!!\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"warring\").innerText=\"\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar li=document.createElement(\"li\");\r\n");
      out.write("\t\t\t\tvar listMeg_List=document.getElementById(\"listMeg\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(listMeg_List.children.length==0){\r\n");
      out.write("\t\t\t\tlistMeg_List.appendChild(li);\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tlistMeg_List.insertBefore(li,listMeg_List.children[0]);\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar dataNow =new Date();\r\n");
      out.write("\t\t\t\tvar y=dataNow.getFullYear();\r\n");
      out.write("\t\t\t\tvar mo=dataNow.getMonth();\r\n");
      out.write("\t\t\t\tvar d=dataNow.getDay();\r\n");
      out.write("\t\t\t\tvar h=dataNow.getHours();\r\n");
      out.write("\t\t\t\tvar m=dataNow.getMinutes();\r\n");
      out.write("\t\t\t\tvar s=dataNow.getSeconds();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar ymd=[y,Appendzero(mo),Appendzero(d)].join(\"-\");\r\n");
      out.write("\t\t\t\tvar time=[h,Appendzero(m),Appendzero(s)].join(\":\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar kg=\"&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;\"\r\n");
      out.write("\t\t\t\tvar sn=\"------------------------------------------------------------\"\r\n");
      out.write("\t\t\t    li.innerHTML=textkeyValue+\"<br><br>\"+kg+\r\n");
      out.write("\t\t\t\tymd+\"&nbsp\"+time+\"<input type='button'  id='btnDel' value='删除' class='del' >\"+\"<br>\"+sn;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar btnDel=li.getElementsByTagName(\"input\")[0];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tbtnDel.onclick=function(){\r\n");
      out.write("\t\t\t\t\talert(\"要删除吗？\");\r\n");
      out.write("\t\t\t\t\tvar delLi=this.parentNode;\r\n");
      out.write("\t\t\t\t\tlistMeg_List.removeChild(delLi);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t  document.getElementById(\"textkey\").value=\"\"; \t\r\n");
      out.write("\t\t};\r\n");
      out.write("\t</script>\r\n");
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
