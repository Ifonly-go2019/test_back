package test;
/*
 * �ӿ�
 */
interface Sport {
	   void run();
	public abstract  void jump();//������һ����
}

public class Athlete implements Sport{

	@Override
	public void run() {
		// TODO Auto-generated method stub
         System.out.println("run");		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("jump");
	}
	
	


public static void main(String[] args) {
	Athlete zhangsan=new Athlete();
	zhangsan.run();
	zhangsan.jump();
}
}
