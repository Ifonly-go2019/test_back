package tools;

import java.io.UnsupportedEncodingException;


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
	
	
}
