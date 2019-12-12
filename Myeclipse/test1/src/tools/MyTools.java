package tools;

import java.beans.Statement;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyTools {

	public static String toChinese(String str){
		if(str==null){
			str="";
		}
		String str1="";
		
		try {
			str1= new String(str.getBytes("ISO-8859-1"),("GB2312"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str1;
	}
	
	 
	
	
	public static String  DateFormat(Date d){
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str =f.format(d);
		
		return str;
		
	}
	
	
	
}
