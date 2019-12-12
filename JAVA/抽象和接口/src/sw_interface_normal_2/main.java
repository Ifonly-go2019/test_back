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
	System.out.println(name+"正在画"+paintName);
	}
	
	public void practice() {
		System.out.println(name+"正在练习素描");
	}
	
}
/******end******/
public class main {
	public static void main(String[] args) {
                System.out.println("请输入学生画家的姓名与所作画的名称，以空格分开");
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
