package test;

public class Actor {
	
	public String name;
	public String sex;
	public String job;
	public int age;
	
	
	public void performs(){
		System.out.println(name+"\t"+sex+"\t"+job+"\t"+age);
	}
	
	//������  û�з���ֵ ������������һ��
	public Actor(String name1,String sex1,String job1,int age1) {
		name=name1;
		sex=sex1;
		job=job1;
		age=age1;
		
	}
	  public Actor() {}//ʹ���˷��������� 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Actor actor1 = new Actor("������", "boy", "faker", 25);
          Actor actor2 = new Actor();	
          actor1.performs();
        		 
         
	}

}
