package en_sw_p3_003;

import java.util.Scanner;

/******start******/
//design interface AreaCalculator
interface AreaCalculator{
	double getArea();
}
/******end******/
/******start******/
//design class Rectangle implements interface  AreaCalculator
class Rectangle implements AreaCalculator{
	private double height;
	private double length;

	 public Rectangle(double height,double length) {
		 this.height=height;
		 this.length=length;
	 }

	
	public double getArea() {
		
		return height*length;
	}	 
}
/******end******/
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the height and length:");
		double height = scanner.nextDouble();
		double length = scanner.nextDouble();
		AreaCalculator areaCalculator = new Rectangle(height, length);
		System.out.printf("The area is:%.4f",areaCalculator.getArea());
		scanner.close();
	}
}