package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DateBaseconnect {
	String url;
	String user;
	String pwd;
	
	public DateBaseconnect() {
		super();
		this.url = "jdbc:mysql://localhost:3306/electivesdb?useUnicode=true&characterEncoding=utf8";
		this.user = "root";
		this.pwd = "642795004";
	}
	public DateBaseconnect(String url, String user, String pwd){
		this.url=url;
		this.user=user;
		this.pwd=pwd;
	}
	
	
	public Connection getConnection(String type1,String type2){
		Connection con=null;
		Statement stmt=null;
		ResultSet rst=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("成功连接");
			stmt =con.createStatement();
			String sql =type1;
			rst=stmt.executeQuery(sql);
			while(rst.next()){
				System.out.println(rst.getString(type2));	
			}
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
	public Connection getConnection(){
		Connection con=null;
		Statement stmt=null;
		ResultSet rst=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("成功连接");
			
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	public static void main(String[] args) {
		  
	      String url="jdbc:mysql://localhost:3306/electivesdb?useUnicode=true&characterEncoding=utf8";
	      String user="root";
	      String pwd="642795004";
		  String sql="select * from students";
		  String field="sName";
		
		DateBaseconnect db =new DateBaseconnect(url,user,pwd);
		db.getConnection(sql,field);

	
	
	}

}
