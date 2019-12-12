package x2014002;
/******start******/
import java.util.Scanner;


/******end******/
interface CalculateInterface {
	public static final float PI = 3.1415f;
	public float getArea();
	
}
/******start******/
class Circle implements CalculateInterface{
	private float r;
	public Circle(float r) {
		this.r=r;
	}
	
	public float getArea() {
		
		return (float)Math.PI*r*r;
	}
	
}
class Rectangle implements CalculateInterface{
	private float w;
	private float l;
	public Rectangle(float w,float l) {
		this.w=w;
		this.l=l;
	}
	
	public float getArea() {
	
		return w*l;
	}
	
	
}







/******end******/
public class demo{
	public static void main(String[] args) {
		Scanner san = new Scanner(System.in);
		float r = san.nextFloat();
		float w = san.nextFloat();
		float l = san.nextFloat();
		CalculateInterface circle = new Circle(r);
		CalculateInterface rectangle = new Rectangle(w, l);
		System.out.println("Output:");
		System.out.println("圆的面积是："+circle.getArea());
		System.out.println("矩形的面积是："+rectangle.getArea());

	}
}