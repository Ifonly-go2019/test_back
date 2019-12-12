package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DateBaseconnect;
import javaBean.LoginBean;

public class userDao {

	
	public boolean checkUser(LoginBean login){
		boolean flag=false;
		Connection con=null;
		Statement stmt=null;
		ResultSet rst=null;
		PreparedStatement pstmt=null;
		
		DateBaseconnect db =new DateBaseconnect();
		
		con=db.getConnection();
		String sql="select * from students where sName=? and sPassword=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,login.getName());
			pstmt.setString(2, login.getPassword());
			rst=pstmt.executeQuery();	
			if(rst.next()){
				flag=true;
				System.out.println("成功登录");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 if (flag==false){
			 System.out.println("用户名或者密码有误");
		 }
		
		return flag;
	}
	

      public static void main(String[] args) {
 	
	    LoginBean test =new LoginBean();
	    test.setName("张三");
	    test.setPassword("000000");
	    
	    userDao dao=new userDao();
	    dao.checkUser(test);
	    
	    
     }	
}