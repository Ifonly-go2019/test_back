package finaltest_interface_sw_001;

import java.util.Scanner;
/******start******/
interface comparable{
	int isLargerThan(person p);
}



/******end******/

class person implements comparable{
/******start******/
  private String name;
  private int age;
  public person(String name,int age) {
	  this.name=name;
	  this.age=age;
  }
public String getName() {
	return name;
}
public int getAge() {
	return age;
}

public int isLargerThan(person p) {
   return this.age-p.getAge();
}



}
/******end******/
public class demo {
	public static void main(String[] args) {
		person p1 = new person("����", 34);
		Scanner scanner = new Scanner(System.in);
		String inputName = scanner.next();
		int inputAge = Integer.parseInt(scanner.next());
		person p2 = new person(inputName, inputAge);
                System.out.print("output:");
		System.out.println("������"+p2.getName()+"��������"+p1.isLargerThan(p2));	}
	
	
}