package test;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.*;
public class datatest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  Connection conn=null;
	      java.sql.Statement stmt=null;
	      ResultSet rst=null;
	      
	      String url="jdbc:mysql://localhost:3306/electivesdb?useUnicode=true&characterEncoding=utf8";
	      String user="root";
	      String password="642795004";
		
	      try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("�ɹ�����");
			stmt =conn.createStatement();
			String sql ="select * from students";
			rst=stmt.executeQuery(sql);
			while(rst.next()){
				System.out.println(rst.getString("sName"));	
			}
	          }
	        catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.print("��¼ʧ��1");
		    } 
	        catch (SQLException e) {
			e.printStackTrace();
			System.out.print("��¼ʧ��2");
		    }	
	    }


}
