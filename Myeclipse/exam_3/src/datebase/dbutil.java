package datebase;

	import java.sql.Connection;
import java.sql.DriverManager;
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class dbutil {
		//定义JDBC 驱动类名、连接数据库URL、连接数据库用户名以及密码等常量(5分)
		//例如：private final String Driver = "xxxx";
	        //编写代码1
		/******start******/
		String url;
		String user;
		String pwd;
		
		
	/******end******/
		/**
		 * 在构造方法中注册驱动 （5分）
		 */
		public dbutil(){
		    //编写代码2
	          /******start******/
			super();
			this.url = "jdbc:mysql://222.18.158.30:3306/jspexam?useUnicode=true&characterEncoding=utf8";
			this.user = "student";
			this.pwd = "123456";
	  /******end******/
		}
		/**
		 * 获取与数据库的连接对象（5分）
		 * @return Connection对象
		 */
		public Connection getConnection() {
			//编写代码3
	          /******start******/
			Connection con=null;
			Statement stmt=null;
			ResultSet rst=null;
             try {
				Class.forName("com.mysql.jdbc.Driver") ;
				con = DriverManager.getConnection(url,user,pwd);
				System.out.println("成功连接");
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
               
               
	 
            return con;
	  /******end******/
	        }
	         /**
		 * 关闭资源（5分）
		 * @param connection 连接对象
		 * @param stmt 声明对象
		 * @param rs 结果集对象
		 */
		public void close(Connection connection,Statement stmt,ResultSet rs){
			//编写代码4
	          /******start******/
           if(stmt!=null)
           { 
        	   try {
				stmt.close();
			} catch (SQLException e) {
				stmt=null;
				e.printStackTrace();
			}
        	   
           }
			if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				connection=null;
				e.printStackTrace();
			} 
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					rs=null;
					e.printStackTrace();
				}
			}
			
			

	  /******end******/
		}
	}
