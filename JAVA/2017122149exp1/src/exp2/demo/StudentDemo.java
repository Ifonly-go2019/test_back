package exp2.demo;

import exp2.entities.student;

public class StudentDemo {
	  
	  
	  public static void main(String[] args) {
			// TODO Auto-generated method stub
		  student st1=new student();
		  student st2=new student(); 
	        st1.setName("张三");
	        st1.setId("2017122140");;
	        st1.setCredit(10);
	        st1.rate(st1.getCredit());
	        
	        
	       st2.setName("李四");
	       st2.setId("2017122141");
	       st2.setCredit(5);
	       st2.rate(st2.getCredit());
		} 
}
