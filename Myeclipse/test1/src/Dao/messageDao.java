package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javaBean.VipBean;

import DB.DateBaseconnect;

public class messageDao {

	 public boolean adduser(VipBean vip){
     	boolean flag=false;
     	Connection con=null;	
 		PreparedStatement pstmt=null;
 		int rs=0;
     	DateBaseconnect db =new DateBaseconnect();
     	con=db.getConnection();
     	String sql="insert into tMessage values(null,?,?,?,?)";
     	try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,vip.getName());
				pstmt.setString(2, vip.getTittle());
				pstmt.setString(3, vip.getUserSpeaking());
				pstmt.setString(4, vip.getVipTime());
			   rs=  pstmt.executeUpdate();
			   if(rs>0){
				   flag=true;
			   }
			   
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
				if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					con=null;
					e.printStackTrace();
				}
				
			}
			}
     	
     	return  flag;
     }	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
