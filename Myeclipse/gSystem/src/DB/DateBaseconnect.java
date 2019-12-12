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
		this.url = "jdbc:mysql://localhost:3306/gradesystem?useUnicode=true&characterEncoding=utf8";
		this.user = "root";
		this.pwd = "642795004";
	}
	
	public Connection getConnection(){
		Connection con=null;
		Statement stmt=null;
		ResultSet rst=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		return con;
	}


}
