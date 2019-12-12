package test6;

import java.util.Scanner; 
class Member {
	private String name;//会员名称
	private float points;//会员积分
	public Member(String name) {
		super();
		this.name = name;
		points = 100;//初始积分为100
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
		System.out.println("会员："+getName()+"的积分为："+points);
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

	/** 覆盖*/
	public void calPoints(float cost){
		float s;
		s=cost+getBonusPoints();
		setPoints(s);
}
	public void print() {
		System.out.println("VIP会员："+getName()+"的积分为："+getPoints());
	}
	
}












/******end******/
public class test1 {
    public static void main(String[] args) {
	System.out.println("请输入VIP会员的姓名、奖励积分以及消费金额，以空格分开，奖励积分和消费金额为实数形式");
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