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
		return "һ�㹤��";
	}
        
	
}
/******start******/
class manager extends employee{
      String duty;
      
      /** ���췽��*/
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
	
	/** work�����ĸ���*/
	public String work() {
        String s;
        s="����"+getName()+"����Ҫְ����:"+getDuty();
		return s ;
    }
	
} 

/******end******/
public class demo {
	public static void main(String[] args) {
		System.out.println("�����뾭���������ְ���Կո�ֿ�");
		Scanner san = new Scanner(System.in);
		String name = san.next();
		String duty = san.next();
		employee manager  = new manager(name,duty);
		System.out.println("output:"+manager.work());
	}
}

