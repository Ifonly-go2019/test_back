package test;

import java.util.Scanner;

/** 封装的版本
 *封装就是将属性和方法分门别类的放在类中
 *隐藏对象的属性和实现细节，仅对外公开接口，控制在程序中属性的读取和访问级别
 *封装可以解决设计上的缺陷
 *例如可以在方法上增设判断
 *
 *
 */

public class CircleV3 {
	
	    private double radius;
	    /** 圆的半径*/
	    private double perimeter;
	    /** 圆的周长*/
	    private double area;
	    /** 圆的面积*/
		
	    
	    public void show() {
	    	
	    	System.out.println("圆的周长"+this.getPerimeter()+"\t"+"\n"+"圆的面积"+this.getArea());
	    }
	    
	    public CircleV3() {
	
		}//自己生成的默认无参数构造方法
	    public CircleV3(double radius) {
			
			//this.radius = radius;
			this.setRadius(radius);//下面已经将方法封装好了
		}//生成的带参数的构造方法








		public double getRadius() {
			return radius;
		}
	
		public void setRadius(double radius) {
			//this->自指针（小名朕）
			if(radius<=0) {//可以通过封装对传入的属性进行简单的验证
				radius=1;
			}
			this.radius = radius;
		}
		
        
		public double getPerimeter() {
			 perimeter=2*Math.PI*radius;
			return perimeter;
		}
		public double getArea() {
			area=Math.PI*Math.pow(radius, 2);
			return area;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Scanner input  = new Scanner(System.in);
	    	System.out.println("请输入圆的半径：");
	    	double radius= input.nextDouble();
	    	CircleV3 circle = new CircleV3(radius);
	    	circle.show();
			
		}

	

	
	

}
