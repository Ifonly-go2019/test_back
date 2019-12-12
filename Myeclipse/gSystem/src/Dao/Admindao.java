package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBean.adminBean;
import javaBean.studentBean;

import DB.DateBaseconnect;

public class Admindao {
            
	
	 public int adduser(adminBean ub){
	    	int flag=0;
	    	Connection con=null;	
			PreparedStatement pstmt=null;
	    	DateBaseconnect db =new DateBaseconnect();
	    	con=db.getConnection();
	    	String sql="insert into admins values(?,?,?)";

	        try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ub.getuNo());
				pstmt.setString(2, ub.getuPwd());
				pstmt.setString(3,ub.getuInumber());
				
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
	 
	 
	 public adminBean checkLogin(String uNo, String uPwd ){
		    adminBean admin=null;
		    
		    Statement state=null;
		    ResultSet rs=null;
		    Connection con=null;	
			PreparedStatement pstmt=null;
		    String sql="select * from admins where aNo='"+uNo+"'";
			
			DateBaseconnect db =new DateBaseconnect();
	    	con=db.getConnection();
	    	
	    	try {
				state=con.createStatement();
				rs=state.executeQuery(sql);
			
			if(rs.next()){
				
				if(rs.getString("aPwd").equals(uPwd)){
					
					admin=new adminBean();
					admin.setuNo(rs.getString("aNo"));
					admin.setuPwd(rs.getString("aPwd"));	
				}
				
			}		
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				if(state!=null){
					try {
						state.close();
					} catch (SQLException e) {
						state=null;
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
		 
		 return admin;	 
		 
	 }
	 
 public  static List<adminBean> findall(String sql)throws SQLException {
	 Connection con=null;	
	 PreparedStatement pstmt=null;
	 Statement st=null;
	 ResultSet rs=null;
 	 
	 DateBaseconnect db =new DateBaseconnect();
 	
 	
	 List<adminBean> newsList=new ArrayList<adminBean>();
	
	 try {
		con=db.getConnection();
		st = con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()){
			adminBean admin=new adminBean();
			admin.setuNo(rs.getString("aNo"));
			admin.setuPwd(rs.getString("aPwd"));
			admin.setuInumber(rs.getString("aInumber"));
			newsList.add(admin);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally{
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				st=null;
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
		 return newsList;
	 
 }
	 
	 
 public int upDate(adminBean ad){
 	int flag=0;
	    Statement state=null;
	    Connection con=null;	
		PreparedStatement pstmt=null;

		String sql="update admins set aNo=?,aPwd=?,aInumber=? where aNo=?";
		
		
		DateBaseconnect db =new DateBaseconnect();
 	    con=db.getConnection();
 	 
 	 try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ad.getuNo());
			pstmt.setString(2, ad.getuPwd());
			pstmt.setString(3, ad.getuInumber());
			pstmt.setString(4, ad.getuNo());
			
			
			flag=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
    		if(pstmt!=null){
    			try {
    				pstmt.close();
    			} catch (SQLException e){
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
		 
 	return flag;
 }
 
 
 public int deleate(String sql){
 	   int flag=0;
 	  Statement state=null;
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    DateBaseconnect db =new DateBaseconnect();
	    con=db.getConnection();
	     
	    try {
			pstmt=con.prepareStatement(sql);
			flag=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
    		if(pstmt!=null){
    			try {
    				pstmt.close();
    			} catch (SQLException e){
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
 	
 	return flag;
 }
}
