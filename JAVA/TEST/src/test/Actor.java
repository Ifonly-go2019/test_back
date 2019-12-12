package test;

public class Actor {
	
	public String name;
	public String sex;
	public String job;
	public int age;
	
	
	public void performs(){
		System.out.println(name+"\t"+sex+"\t"+job+"\t"+age);
	}
	
	//构造器  没有返回值 方法名和类名一致
	public Actor(String name1,String sex1,String job1,int age1) {
		name=name1;
		sex=sex1;
		job=job1;
		age=age1;
		
	}
	  public Actor() {}//使用了方法的重载 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Actor actor1 = new Actor("王境泽", "boy", "faker", 25);
          Actor actor2 = new Actor();	
          actor1.performs();
        		 
         
	}

}
