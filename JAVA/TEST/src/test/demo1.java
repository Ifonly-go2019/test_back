package test;



import java.util.Scanner;

class Employee{
	private String name;
	private double salary;
	public Employee(String name,double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
        /*
	 * 计算员工的年总收入，用月薪（salary）*月份数（month）
	 */
	public double calculateIncome(int month){
		return salary*month;
	}
}
/******start******/
class Manager extends Employee{
   private double bonus;
	public Manager(String name, double salary,double bonus) {
		super(name, salary);
		setName(name);
		setSalary(salary);
		setBonus(bonus);
	}
	
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double calculateIncome(int month){
		double s;
		s=getSalary()*month+getBonus();
		return s;
	}

	
	
}

/******end******/
public class demo1 {
    public static void main(String[] args) {
	System.out.println("请输入经理的姓名、月薪和奖金，以空格分开，月薪和奖金为实数形式");
	Scanner san = new Scanner(System.in);
	String name = san.next();
	double salary = san.nextDouble();
	double bonus = san.nextDouble();
	Employee manager  = new Manager(name,salary,bonus);
	System.out.println("output:经理"+manager.getName()+"的总收入是："+manager.calculateIncome(13));
	}
}
