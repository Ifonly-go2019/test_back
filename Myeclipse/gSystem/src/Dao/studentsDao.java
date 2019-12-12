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

import javax.xml.ws.Response;

import tools.MyTools;
import javaBean.*;

import DB.DateBaseconnect;

public class studentsDao {

        public int adduser(studentBean ub){
        	int flag=0;
        	Connection con=null;	
    		PreparedStatement pstmt=null;
    		
        	DateBaseconnect db =new DateBaseconnect();
        	con=db.getConnection();
        	String sql="insert into students values(?,?,?,?,?,?)";

            try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ub.getsNo());
				pstmt.setString(2, ub.getsName());
				pstmt.setString(3,ub.getsPwd());
				pstmt.setString(4,ub.getsGender());
				pstmt.setString(5,ub.getsMajor());
				pstmt.setString(6,ub.getsDepart());
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
        
        
        public studentBean checkLogin(String uNo, String uPwd ){
		    studentBean student=null;
		    
		    Statement state=null;
		    ResultSet rs=null;
		    Connection con=null;	
			PreparedStatement pstmt=null;
		    String sql="select * from students where sNo='"+uNo+"'";
			DateBaseconnect db =new DateBaseconnect();
	    	con=db.getConnection();
	    	try {
				state=con.createStatement();
				rs=state.executeQuery(sql);
				
			if(rs.next()){
				
				if(rs.getString("sPwd").equals(uPwd)){
				
					student=new studentBean();
					student.setsNo(rs.getString("sNo"));
					student.setsName(rs.getString("sName"));
					student.setsPwd(rs.getString("sPwd"));	
					student.setsGender("sGender");
					student.setsMajor("sMajor");
					student.setsDepart("sDepart");
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
		 
		 return student;
		 
		 
		 
	 }
        
        public  static List<studentBean> findall(String sql)throws SQLException {
       	 Connection con=null;	
       	 PreparedStatement pstmt=null;
       	 Statement st=null;
       	 ResultSet rs=null;
        	 
       	 DateBaseconnect db =new DateBaseconnect();	
       	 List<studentBean> newsList=new ArrayList<studentBean>();
       	
       	 try {
       		con=db.getConnection();
       		st = con.createStatement();
       		rs=st.executeQuery(sql);
       		while(rs.next()){
       			studentBean student=new studentBean();
       			student.setsNo(rs.getString("sNo"));
       			student.setsName(rs.getString("sName"));
       			student.setsPwd(rs.getString("sPwd"));
       			student.setsGender(rs.getString("sGender"));
       			student.setsMajor(rs.getString("sMajor"));
       			student.setsDepart(rs.getString("sDepart"));
       			
       			newsList.add(student);
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
        
        
        
        
        public int upDate(studentBean st){
        	int flag=0;
 		    Statement state=null;
 		    Connection con=null;	
 			PreparedStatement pstmt=null;
        	System.out.println(st.getsNo());
// 			String sql="update students set sNo='"+st.getsNo()+"',sName='"+st.getsName()+"',sPwd="+st.getsPwd()+",sGender='"+st.getsGender()+"',sMajor='"+st.getsMajor()+" where sNo='"+st.getsNo()+"'";
 			String sq="update students set sNo='"+st.getsNo()+"',sName='"+st.getsName() +"',sPwd='"+st.getsPwd() +"',sGender='"+st.getsGender() +"',sMajor='"+st.getsMajor()+"',sDepart='"+st.getsDepart()+"' where sNO='"+st.getsNo()+"' " ;
 			String sql="update students set sNo=?,sName=?,sPwd=?,sGender=?,sMajor=?,sDepart=? where sNo=?";
 			
 			
 			DateBaseconnect db =new DateBaseconnect();
        	 con=db.getConnection();
        	 System.out.println(st.getsName());
        	 try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, st.getsNo());
				pstmt.setString(2,  st.getsName());
				pstmt.setString(3,  st.getsPwd());
				pstmt.setString(4, st.getsGender());
				pstmt.setString(5, st.getsMajor());
				pstmt.setString(6, st.getsDepart());
				pstmt.setString(7,  st.getsNo());
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
