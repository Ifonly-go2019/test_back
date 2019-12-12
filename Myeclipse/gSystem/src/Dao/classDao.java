package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBean.*;

import DB.DateBaseconnect;

public class classDao {

	 public int adduser(classBean ub){
	    	int flag=0;
	    	Connection con=null;	
			PreparedStatement pstmt=null;
	    	DateBaseconnect db =new DateBaseconnect();
	    	con=db.getConnection();
	    	String sql="insert into class values(?,?)";
             
	        try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ub.getcNo());
				pstmt.setString(2, ub.getcName());
				
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
	 
	 public  static List<classBean> findall(String sql)throws SQLException {
		 Connection con=null;	
		 PreparedStatement pstmt=null;
		 Statement st=null;
		 ResultSet rs=null;
	 	 
		 DateBaseconnect db =new DateBaseconnect();
	 	
	 	
		 List<classBean> newsList=new ArrayList<classBean>();
		
		 try {
			con=db.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				classBean cd=new classBean();
				cd.setcNo(rs.getString("cNo"));
				cd.setcName(rs.getString("cName"));
				newsList.add(cd);
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
	 
	 
		 
	 public int upDate(classBean ad){
		 	    int flag=0;
			    Statement state=null;
			    Connection con=null;	
				PreparedStatement pstmt=null;

				String sql="update class set cNo=?,cName=? where cNo=?";
				
				
				DateBaseconnect db =new DateBaseconnect();
		 	    con=db.getConnection();
		 	     
		 	 try {
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, ad.getcNoc());
					pstmt.setString(2, ad.getcName());
					pstmt.setString(3, ad.getcNo());
					flag=pstmt.executeUpdate();
				    System.out.println(ad.getcNoc());
					
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
