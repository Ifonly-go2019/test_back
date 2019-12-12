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
	 * ����Ա�����������룬����н��salary��*�·�����month��
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
	System.out.println("�����뾭�����������н�ͽ����Կո�ֿ�����н�ͽ���Ϊʵ����ʽ");
	Scanner san = new Scanner(System.in);
	String name = san.next();
	double salary = san.nextDouble();
	double bonus = san.nextDouble();
	Employee manager  = new Manager(name,salary,bonus);
	System.out.println("output:����"+manager.getName()+"���������ǣ�"+manager.calculateIncome(13));
	}
}
