package test3;
import java.util.Scanner;

class Shape {
	private String name;
	public Shape(String name) {
		this.name = name;
	}
	public double getArea() {
		return 0.0;
	}
	public double getPerimeter(){
		return 0.0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
/******start******/
class Triangle extends Shape{

	private double side1=1.0;
	private double side2=1.0;
	private double side3=1.0;
	
	   
		public Triangle(String name,double side1,double side2,double side3) {
		super(name);
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
		
		}
	
		public Triangle() {
			super("test");
		}







		public double getArea() {
			double s,area;
			s=(side1+side2+side3)/2;
			area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
			return area;
		}
		public double getPerimeter(){
			return side1+side2+side3;
		}
		public String toString() {
			String s;
			s= "Triangle"+getName()+":side1="+side1+"side2="+side2+"side3="+side3+"area="+getArea()+"Perimeter="+getPerimeter();
			return s;
	
		}
	
}





/******end******/

public class test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a triangle's name, side1, side2, side3:");
		String name = scanner.next();
		double side1 = scanner.nextDouble();
		double side2 = scanner.nextDouble();
		double side3 = scanner.nextDouble();
		Shape triangle1 = new Triangle();
		Shape triangle2 = new Triangle(name, side1, side2, side3);
		System.out.println(triangle1.toString());
		System.out.println(triangle2.toString());
		scanner.close();
	}
}