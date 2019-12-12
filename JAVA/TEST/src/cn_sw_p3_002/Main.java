package cn_sw_p3_002;

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
class VIPCustomer extends Customer{
     private double credit;
	public VIPCustomer(String id,double credit) {
		super(id);
		this.credit=credit;
	}
	
	public double getCredit() {
		return credit;
	}

	public double payAmount(double consumptionAmount){
		double s=0.0;
		if(credit>=consumptionAmount){
			credit=getCredit()-consumptionAmount;
			return s;
		}
		else {
			s=consumptionAmount-credit;
			credit=Math.floor(s);
			return s;
		}
	}
	
	
	
}






/******end******/
public class Main{
	public static void main(String[] args) {
		Customer customer = new VIPCustomer("001",100.0);
		System.out.println("�ͻ���"+customer.getId()+"����������78.5Ԫ��ʵ��֧��"+customer.payAmount(78.7)+"Ԫ");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("������vip�ͻ���ţ���ʼ���ѻ��ּ��������ѽ�");
		String id = scanner.next();
		double credit = scanner.nextDouble();
		double consumption = scanner.nextDouble();
		VIPCustomer vip = new VIPCustomer(id, credit);
		System.out.println("output:");
		System.out.println("VIP�ͻ���"+vip.getId()+"����������"+consumption+"Ԫ��ʵ��֧��"+vip.payAmount(consumption)+"Ԫ��ʣ����֣�"+vip.getCredit());
		scanner.close();
	}
}