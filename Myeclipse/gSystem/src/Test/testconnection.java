package Test;

import java.sql.Connection;

import DB.DateBaseconnect;

public class testconnection {
	
	
	public Connection test(){
		
		Connection con =null;
		DateBaseconnect db =new DateBaseconnect();
		con=db.getConnection();
		return con;
	}
	

   
	public static void main(String[] args) {
		

	}

	
}
