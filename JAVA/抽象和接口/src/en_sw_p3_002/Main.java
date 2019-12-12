package en_sw_p3_002;

import java.util.Scanner;
/******start******/
//design interface AreaCalculator
interface AreaCalculator {
	double getArea();
}



/******end******/
/******start******/
//design class Circle implements interface  AreaCalculator
class Circle implements AreaCalculator{
	private double  radius;
	
    public Circle(double radius) {
    	this.radius=radius;
    }
    
    
	public double getRadius() {
		return radius;
	}


	public double getArea() {
          return Math.PI*getRadius()*getRadius();
		}
	
	
}






/******end******/
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the radius:");
		double radius = scanner.nextDouble();
		AreaCalculator areaCalculator = new Circle(radius);
		System.out.printf("The area is:%.4f",areaCalculator.getArea());
		scanner.close();
	}
}