package changyan_test01;

import java.util.Scanner;

interface Car {
/******start******/
//1.在该接口中添加两个方法，分别为获取汽车的名称：String getName()和
//获取汽车的售价int getPrice()
 String getName();
 int getPrice();




/******end******/
}



/******start******/
//2.定义一个抽象类宝马汽车类BMW，让它实现接口Car里面的getName()方法，返回汽车的名称。
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
	//3.添加构造方法，完成成员变量name和price的初始化。
	
     public BMWAA(String name, int price) {
        this.name=name;
        this.price=price;
     }
     

        /******end******/
 }


/******start******/
//4.定义一个奇瑞QQ汽车类CheryQQ（非抽象类）实现接口Car，
//该类有两个成员变量name和price分别表示汽车的名称和汽车的价格。
//让该类实现接口Car里面的getName()方法和getPrice()方法分别返回汽车的名称和价格。
//编写该类的构造方法完成成员变量name和price的初始化。

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

		System.out.println("车型：" + car.getName() + " 单价：" + car.getPrice()); 

		// 增加卖出车售价的收入 

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

		  // 卖出一辆宝马A系 

		    aShop.sellCar(new BMWAA(name,Integer.parseInt(price))); 

		  // 卖出一辆奇瑞QQ 
		   
		    aShop.sellCar(new CheryQQ(name1,Integer.parseInt(price1))); 

		    System.out.println("总收入：" + aShop.getMoney()); 

		} 

	 } 


