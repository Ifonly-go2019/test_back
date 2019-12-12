package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.ws.Response;

import javeBean.useBean;

import DB.DateBaseconnect;

public class addUserDao {

        public int adduser(useBean ub){
        	int flag=0;
        	Connection con=null;	
    		PreparedStatement pstmt=null;
    		
        	DateBaseconnect db =new DateBaseconnect();
        	con=db.getConnection();
        	String sql="insert into users values(null,?,?,?)";
        	try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,ub.getuName());
				pstmt.setString(2, ub.getuPwd());
				pstmt.setString(3, ub.getuEmail());
			    flag=pstmt.executeUpdate();
			   
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			finally{
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						pstmt=null;
						e.printStackTrace();
					}
				}
				
				try {
					con.close();
				} catch (SQLException e) {
					con=null;
					e.printStackTrace();
				}
				
			}
        	
        	return  flag;
        }	
     
}
