package sw_2016_f_002;

import java.util.Scanner;

class Item{
	private String name;
	private float price;
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Item(String name, float price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}
        //������Ʒ���ܼ۸�
	public float calTotal(){
		return price*count;
	}
        //�����Ʒ���ܼ۸�
	public void print() {
		System.out.println(count+"��"+name+"��Ʒ ,�ܼ�:"+calTotal());
	}
}
/******start******/
class DiscountItem extends Item{
	private float discount;
	
	public DiscountItem(String name, float price, int count,float discount) {
		super(name, price, count);
		this.discount=discount;
	}

	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	  //������Ʒ���ܼ۸�
		public float calTotal(){
		return getPrice()*getCount()*getDiscount();	
		}
	   
	
} 










/******end******/
public class demo {
public static void main(String[] args) {
	System.out.println("������һ����Ʒ�����ơ����ۡ������Լ��ۿۣ��ۿ�Ϊ0-1.0֮�������������֮���Կո�ֿ�");
	Scanner scanner = new Scanner(System.in);
	String name = scanner.next();
	float price = scanner.nextFloat();
	int count = scanner.nextInt();
	float discount = scanner.nextFloat();
	System.out.println("output:");
	Item item = new Item(name, price, count);
	item.print();
	System.out.println("������!");
	item = new DiscountItem(name, price, count, discount);
	item.print();
	scanner.close();
	}
}