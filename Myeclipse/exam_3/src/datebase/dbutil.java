package datebase;

	import java.sql.Connection;
import java.sql.DriverManager;
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class dbutil {
		//����JDBC �����������������ݿ�URL���������ݿ��û����Լ�����ȳ���(5��)
		//���磺private final String Driver = "xxxx";
	        //��д����1
		/******start******/
		String url;
		String user;
		String pwd;
		
		
	/******end******/
		/**
		 * �ڹ��췽����ע������ ��5�֣�
		 */
		public dbutil(){
		    //��д����2
	          /******start******/
			super();
			this.url = "jdbc:mysql://222.18.158.30:3306/jspexam?useUnicode=true&characterEncoding=utf8";
			this.user = "student";
			this.pwd = "123456";
	  /******end******/
		}
		/**
		 * ��ȡ�����ݿ�����Ӷ���5�֣�
		 * @return Connection����
		 */
		public Connection getConnection() {
			//��д����3
	          /******start******/
			Connection con=null;
			Statement stmt=null;
			ResultSet rst=null;
             try {
				Class.forName("com.mysql.jdbc.Driver") ;
				con = DriverManager.getConnection(url,user,pwd);
				System.out.println("�ɹ�����");
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
               
               
	 
            return con;
	  /******end******/
	        }
	         /**
		 * �ر���Դ��5�֣�
		 * @param connection ���Ӷ���
		 * @param stmt ��������
		 * @param rs ���������
		 */
		public void close(Connection connection,Statement stmt,ResultSet rs){
			//��д����4
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
