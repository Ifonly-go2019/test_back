package test;
/*
 * 接口
 */
interface Sport {
	   void run();
	public abstract  void jump();//两者是一样的
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
