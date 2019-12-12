package test5;

import java.util.Scanner;

abstract class Shape{
	private String name;
	public Shape(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
         /*
	 * 计算图形的面积
	 */
	public abstract double calculateArea();
	
}
/******start******/
class Circle extends Shape{
    private double radius;
  
    
   /** 带参数的构造方法*/     
	public Circle(String name,double radius) {
		super(name);
		setName(name);
		setRadius(radius);
		
	}

   public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//@Override
	public double calculateArea() {
		double s;
		s=Math.PI*getRadius()*getRadius();
		return s;
	}

	
}









/******end******/
public class shapedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入圆形的名称与半径，以空格分开，半径为实数形式");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		double radius = scanner.nextDouble();
		Shape circle = new Circle(name, radius);
		System.out.println("output:圆形"+circle.getName()+"的面积是："+circle.calculateArea());
	}

}