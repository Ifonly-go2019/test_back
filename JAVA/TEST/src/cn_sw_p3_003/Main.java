package cn_sw_p3_003;

import java.util.Scanner;
class Customer {
         //�ͻ����id
	private String id;
	public Customer(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
      //����ͻ�����������Ҫʵ��֧���ķ��ã�������ͨ�ͻ������ѽ����ǿͻ�ʵ����Ҫ֧���Ľ��
	public double payAmount(double consumptionAmount){
		return consumptionAmount;
	}
	
}
/******start******/
class DiscountCustomer extends  Customer{
     private double discount;
     
	public DiscountCustomer(String id,double discount) {
		super(id);
		this.discount=discount;
	}
	
	public double getDiscount() {
		return discount;
	}

	public double payAmount(double consumptionAmount){
       return getDiscount()*consumptionAmount;
	
	}
	
}







/******end******/
public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������ۿۿͻ���ţ��ۿ�ϵ�����������ѽ�");
		String id = scanner.next();
		double discount = scanner.nextDouble();
		double consumption = scanner.nextDouble();
		Customer customer = new DiscountCustomer(id, discount);
		System.out.println("output:");
		System.out.println("�ۿۿͻ���"+customer.getId()+"����������"+consumption+"Ԫ��ʵ��֧��"+customer.payAmount(consumption)+"Ԫ");
		scanner.close();
	}
}