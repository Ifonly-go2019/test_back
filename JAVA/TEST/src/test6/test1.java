package test6;

import java.util.Scanner; 
class Member {
	private String name;//��Ա����
	private float points;//��Ա����
	public Member(String name) {
		super();
		this.name = name;
		points = 100;//��ʼ����Ϊ100
	}
	public String getName() {
		return name;
	}
	public float getPoints() {
		return points;
	}
	
	public void setPoints(float points) {
		this.points = points;
	}
	

	public void print() {
		System.out.println("��Ա��"+getName()+"�Ļ���Ϊ��"+points);
	}
}
/******start******/
class VIP extends Member{
	

	private float bonusPoints;
	
	public VIP(String name,float bonusPoints) {
		super(name);
		this.bonusPoints=bonusPoints;
	}
	
	public float getBonusPoints() {
		return bonusPoints;
	}

	/** ����*/
	public void calPoints(float cost){
		float s;
		s=cost+getBonusPoints();
		setPoints(s);
}
	public void print() {
		System.out.println("VIP��Ա��"+getName()+"�Ļ���Ϊ��"+getPoints());
	}
	
}












/******end******/
public class test1 {
    public static void main(String[] args) {
	System.out.println("������VIP��Ա�����������������Լ����ѽ��Կո�ֿ����������ֺ����ѽ��Ϊʵ����ʽ");
	Scanner san = new Scanner(System.in);
	String name = san.next();
	float bonusPoints = san.nextFloat();
	float cost = san.nextFloat();
	VIP vip = new VIP(name, bonusPoints);
	vip.calPoints(cost);
	System.out.println("output:");
	vip.print();
	vip.calPoints(800);
	vip.print();
    }
}