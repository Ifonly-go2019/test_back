package changyan_test01;

import java.util.Scanner;

interface Car {
/******start******/
//1.�ڸýӿ�����������������ֱ�Ϊ��ȡ���������ƣ�String getName()��
//��ȡ�������ۼ�int getPrice()
 String getName();
 int getPrice();




/******end******/
}



/******start******/
//2.����һ�������౦��������BMW������ʵ�ֽӿ�Car�����getName()�������������������ơ�
abstract class BMW implements Car{
	
	
	public String getName() {
       	
		return getName();
	}

	@Override
	public int getPrice() {
		
		return getPrice();
	}
	
}
	

/******end******/



 class BMWAA extends BMW{
	 private String name;
		private int price;
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		
		return price;
	}
	
	/******start
	 * @param i 
	 * @param name2 ******/
	//3.��ӹ��췽������ɳ�Ա����name��price�ĳ�ʼ����
	
     public BMWAA(String name, int price) {
        this.name=name;
        this.price=price;
     }
     

        /******end******/
 }


/******start******/
//4.����һ������QQ������CheryQQ���ǳ����ࣩʵ�ֽӿ�Car��
//������������Ա����name��price�ֱ��ʾ���������ƺ������ļ۸�
//�ø���ʵ�ֽӿ�Car�����getName()������getPrice()�����ֱ𷵻����������ƺͼ۸�
//��д����Ĺ��췽����ɳ�Ա����name��price�ĳ�ʼ����

class CheryQQ extends BMW{
	private String name;
	private int price;
	   public CheryQQ(String name, int price) {
	        this.name=name;
	        this.price=price;
	     }
	     
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		
		return price;
	}
	
	
}
/******end******/

 public class Main{
	private int money =0;

	public void sellCar(Car car) { 

		System.out.println("���ͣ�" + car.getName() + " ���ۣ�" + car.getPrice()); 

		// �����������ۼ۵����� 

		money += car.getPrice(); 

		} 
	public int getMoney() { 

	     return money; 

	   } 

		 public static void main(String[] args) { 
			 Scanner san = new Scanner(System.in);
			 String name = san.next();
			 String price = san.next();
			 String name1 = san.next();
			 String price1 = san.next();

		    Main aShop = new Main (); 
                    System.out.println("Output:");

		  // ����һ������Aϵ 

		    aShop.sellCar(new BMWAA(name,Integer.parseInt(price))); 

		  // ����һ������QQ 
		   
		    aShop.sellCar(new CheryQQ(name1,Integer.parseInt(price1))); 

		    System.out.println("�����룺" + aShop.getMoney()); 

		} 

	 } 


