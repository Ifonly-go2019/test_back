package sw_interface_normal_2;

import java.util.Scanner;

import java.util.Scanner;

/******start******/
interface Painter{
	void paint(String paintName);
	void practice();
	
}
class Student implements Painter{
	private String name;
	public Student(String name) {
		this.name=name;
	}
	
	public void paint(String paintName) {
	System.out.println(name+"���ڻ�"+paintName);
	}
	
	public void practice() {
		System.out.println(name+"������ϰ����");
	}
	
}
/******end******/
public class main {
	public static void main(String[] args) {
                System.out.println("������ѧ�����ҵ������������������ƣ��Կո�ֿ�");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String paintName = scanner.next();
		System.out.println("output:");
		Painter student = new Student(name);
		student.practice();
		student.paint(paintName);
		scanner.close();
	}

}
