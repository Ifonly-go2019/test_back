package Dao;


	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javabean.product;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;

import datebase.dbutil;
	/**
	 * ����Ҫ��ʵ������ķ�������ɶ�product��Ĳ�����
	 * ��ʵ������ķ���ʱ����Ҫ�õ�DBUtils�ṩ�ķ�����ȡConnection�Լ��ر���Դ
	 * ����product���Զ���Productʵ����
	 * @param <Product>
	 */
	public class proDao<Product> {
		private dbutil dbUtils = new dbutil();
		/**
		 * Ҫ��ʵ�ִ�product���в�ѯ�����е���Ʒ��Ϣ������װΪProduct���󼯺Ϸ���
		 * @return ��ѯ����Product���󼯺�
		 */
		public List<Product> findAll(){
			
		  /******start******/
			dbutil db =new dbutil();
			ResultSet resultSet = basicQuery(sql, id);
			User user = null;
			try {
				while (resultSet.next()) {
					product product = new product();
					product.setId(resultSet.getInt(1)) ;
					product.setName(resultSet.getString("name"));
					product.setIntroduce(resultSet.getString("introduce"));
					product.setPrice(resultSet.getString("price"));
					product.setStock(resultSet.getString("stock"));
				}
				return product;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} finally {
				db.close(r);
			}


			
			return null;
	/******end******/
		}
		/**
		 * Ҫ��ʵ�ָ���id��product����ɾ������Ӧ����Ʒ��Ϣ��Ҫ����Ԥ����preparedStatementʵ��
		 * @param id Ҫɾ������Ʒid
		 * @return ����ɾ��������
		 */
		public int deleteById(int id){
		  /******start******/
			int clows=0;
			boolean flag=false;
			Connection con=null;	
    		PreparedStatement pstmt=null;
           dbutil db= new dbutil();
           con=db.getConnection();
           String sql="delete from  product where id=?";
		
           try {
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1,id);
			clows=pstmt.executeUpdate();
			
				
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		db.close(con, pstmt, null);
           
           return clows;
           

	/******end******/
		}
	}