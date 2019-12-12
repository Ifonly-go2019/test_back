package test1;


import java.util.Scanner;


class Employee{
	private String name;
	private double monthlySalary;
	public Employee(String name, double monthlySalary) {
		super();
		this.name = name;
		this.monthlySalary = monthlySalary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
       //计算总收入 =  月薪 * 计薪月份数
	public double totalIncome(int months){
		return monthlySalary * months;
	}
}
/******start******/
class Manager extends Employee{
	private double bonus;
	/** 带参数的构造方法*/
	public Manager(String name, double monthlySalary,double bonus) {
		super(name, monthlySalary);
     	setBonus(bonus);
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double totalIncome(int months){
		return getMonthlySalary() * months+getBonus();
	}
	
}









/******end******/
public class Main1 {
	public static void main(String[] args) {
		Employee employee = new Employee("Tom", 5500.0f);
		System.out.println("Employee:"+employee.getName()+"的月薪是:"+employee.getMonthlySalary()+",总收入为："+employee.totalIncome(15));
		Employee manager = new Manager("Jerry", 8000.0f, 20000.0f);
		System.out.println("Manager:"+manager.getName()+"的月薪是:"+manager.getMonthlySalary()+",总收入为："+manager.totalIncome(18));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a manager's name, monthlySalary and bonus:");
		String name = scanner.next();
		double monthlySalary = scanner.nextDouble();
		double bonus = scanner.nextDouble();
		Manager manager2 = new Manager(name, monthlySalary, bonus);
		manager2.setBonus(50000);
		System.out.println("Manager:"+manager2.getName()+"的月薪是:"+manager2.getMonthlySalary()+",奖金是:"+manager2.getBonus()+",总收入为："+manager2.totalIncome(18));
		scanner.close();
	}
}