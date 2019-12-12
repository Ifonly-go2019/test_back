package test;
import java.util.Scanner; 
public class Circle {
    public double radius;
    /** 圆的半径*/
    public double perimeter;
    /** 圆的周长*/
    public double area;
    /** 圆的面积*/
     
    public void inputRadius() {
    	Scanner input  = new Scanner(System.in);
    	System.out.println("请输入圆的半径：");
    	radius= input.nextDouble();
    	input.close();
    }
    public void showPremiter() {
    	if(radius <= 0) {
    		inputRadius();//无输入则强制用户再输入一次
    	}
     perimeter=2*Math.PI*radius;    	
     System.out.println("周长是"+perimeter);
    }
    public void showArea() {
      /** area= Math.PI*radius*radius;  我的写法 */
      area=Math.PI*Math.pow(radius, 2);
      /** 教程写法*/
      
    	System.out.println("面积是"+area);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle circle = new Circle();
		 circle.inputRadius();
		 circle.showPremiter();
		 circle.showArea();

	}

}

