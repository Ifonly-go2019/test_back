package test;

import java.util.Scanner;
class employee{
	private String name;
	public employee(String name) {
		super();
		this.name = name;
	
	}
	public String getName() {
		return name;
	}
	public String work(){
		return "一般工作";
	}
        
	
}
/******start******/
class manager extends employee{
      String duty;
      
      /** 构造方法*/
	 public manager(String name,String duty) {
		super(name);
		setDuty(duty);
		
	}

	  public String getDuty() {
		 
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	/** work方法的覆盖*/
	public String work() {
        String s;
        s="经理"+getName()+"的主要职责是:"+getDuty();
		return s ;
    }
	
} 

/******end******/
public class demo {
	public static void main(String[] args) {
		System.out.println("请输入经理的姓名和职责，以空格分开");
		Scanner san = new Scanner(System.in);
		String name = san.next();
		String duty = san.next();
		employee manager  = new manager(name,duty);
		System.out.println("output:"+manager.work());
	}
}

