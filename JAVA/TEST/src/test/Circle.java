package test;
import java.util.Scanner; 
public class Circle {
    public double radius;
    /** Բ�İ뾶*/
    public double perimeter;
    /** Բ���ܳ�*/
    public double area;
    /** Բ�����*/
     
    public void inputRadius() {
    	Scanner input  = new Scanner(System.in);
    	System.out.println("������Բ�İ뾶��");
    	radius= input.nextDouble();
    	input.close();
    }
    public void showPremiter() {
    	if(radius <= 0) {
    		inputRadius();//��������ǿ���û�������һ��
    	}
     perimeter=2*Math.PI*radius;    	
     System.out.println("�ܳ���"+perimeter);
    }
    public void showArea() {
      /** area= Math.PI*radius*radius;  �ҵ�д�� */
      area=Math.PI*Math.pow(radius, 2);
      /** �̳�д��*/
      
    	System.out.println("�����"+area);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle circle = new Circle();
		 circle.inputRadius();
		 circle.showPremiter();
		 circle.showArea();

	}

}

