package test;

import java.util.Scanner;

/** ��װ�İ汾
 *��װ���ǽ����Ժͷ������ű���ķ�������
 *���ض�������Ժ�ʵ��ϸ�ڣ������⹫���ӿڣ������ڳ��������ԵĶ�ȡ�ͷ��ʼ���
 *��װ���Խ������ϵ�ȱ��
 *��������ڷ����������ж�
 *
 *
 */

public class CircleV3 {
	
	    private double radius;
	    /** Բ�İ뾶*/
	    private double perimeter;
	    /** Բ���ܳ�*/
	    private double area;
	    /** Բ�����*/
		
	    
	    public void show() {
	    	
	    	System.out.println("Բ���ܳ�"+this.getPerimeter()+"\t"+"\n"+"Բ�����"+this.getArea());
	    }
	    
	    public CircleV3() {
	
		}//�Լ����ɵ�Ĭ���޲������췽��
	    public CircleV3(double radius) {
			
			//this.radius = radius;
			this.setRadius(radius);//�����Ѿ���������װ����
		}//���ɵĴ������Ĺ��췽��








		public double getRadius() {
			return radius;
		}
	
		public void setRadius(double radius) {
			//this->��ָ�루С���ޣ�
			if(radius<=0) {//����ͨ����װ�Դ�������Խ��м򵥵���֤
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
	    	System.out.println("������Բ�İ뾶��");
	    	double radius= input.nextDouble();
	    	CircleV3 circle = new CircleV3(radius);
	    	circle.show();
			
		}

	

	
	

}
