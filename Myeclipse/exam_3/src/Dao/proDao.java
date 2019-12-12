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
	 * 本题要求实现下面的方法以完成对product表的操作；
	 * 在实现下面的方法时，需要用到DBUtils提供的方法获取Connection以及关闭资源
	 * 根据product表自定义Product实体类
	 * @param <Product>
	 */
	public class proDao<Product> {
		private dbutil dbUtils = new dbutil();
		/**
		 * 要求实现从product表中查询出所有的商品信息，并封装为Product对象集合返回
		 * @return 查询到的Product对象集合
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
		 * 要求实现根据id从product表中删除出对应的商品信息，要求用预编译preparedStatement实现
		 * @param id 要删除的商品id
		 * @return 返回删除的行数
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