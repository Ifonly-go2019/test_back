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

public class GradeDao {

	
	 public int adduser(gradeBean ub){
	    	int flag=0;
	    	Connection con=null;	
			PreparedStatement pstmt=null;
	    	DateBaseconnect db =new DateBaseconnect();
	    	con=db.getConnection();
	    	String sql="insert into grade (sId,cId,grade,sClasses)values(?,?,?,?)";

	        try {
	        
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ub.getsId());
				pstmt.setString(2, ub.getcId());
				pstmt.setString(3,ub.getGrade());
				pstmt.setString(4,ub.getClasses());
				
				System.out.println(ub.getsId());
				System.out.println(ub.getGrade());
				System.out.println(ub.getcId());
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
	 
	 
	 public  static List<gradeBean> findall(String sql)throws SQLException {
		 Connection con=null;	
		 PreparedStatement pstmt=null;
		 Statement st=null;
		 ResultSet rs=null;
	 	 
		 DateBaseconnect db =new DateBaseconnect();
	 	
	 	
		 List<gradeBean> newsList=new ArrayList<gradeBean>();
		
		 try {
			con=db.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				gradeBean cd=new gradeBean();
				cd.setsId(rs.getString("sId"));
				cd.setcId(rs.getString("cId"));
				cd.setGrade(rs.getString("grade"));
				cd.setClasses(rs.getString("sClasses"));
				cd.setgId(rs.getString("gId"));
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
	 
	 
	 
	 public  static List<inGradeBean> findGrade(String sClasse)throws SQLException {
		 Connection con=null;	
		 PreparedStatement pstmt=null;
		 Statement st=null;
		 ResultSet rs=null;
		 String	sql =null;
		 if( sClasse ==null){
			sql = "SELECT sName,sNo,sMajor,grade,cId FROM students LEFT JOIN grade ON sid=sno";
			}else{
				sql = "SELECT sName,sNo,sMajor,grade,cId FROM students LEFT JOIN grade ON sid=sno where sMajor like '%" +sClasse + "%'";
			}
		 DateBaseconnect db =new DateBaseconnect();
	 	
	 	
		 List<inGradeBean> newsList=new ArrayList<inGradeBean>();
		
		 try {
			con=db.getConnection();
			st = con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				inGradeBean cd=new inGradeBean();
			
				
				cd.setsNo(rs.getString("sNo"));
				cd.setsName(rs.getString("sName"));
				cd.setsClasses(rs.getString("sMajor"));
				cd.setGrade(rs.getString("grade"));
				cd.setcId(rs.getString("cId"));
				
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
	 
	 
	 
	 public int upDate(gradeBean cd){
		 	int flag=0;
			    Statement state=null;
			    Connection con=null;	
				PreparedStatement pstmt=null;

				String sql="update grade set sId=?,cId=?,grade=?,sClasses=? where gId=? ";
				
				
				DateBaseconnect db =new DateBaseconnect();
		 	    con=db.getConnection();
		 	 
		 	 try {
		 		   
					pstmt=con.prepareStatement(sql);
				
					pstmt.setString(1, cd.getsId());
					pstmt.setString(2, cd.getcId());
					pstmt.setString(3, cd.getGrade());
					pstmt.setString(4, cd.getClasses());
					
					pstmt.setString(5, cd.getgId());
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
