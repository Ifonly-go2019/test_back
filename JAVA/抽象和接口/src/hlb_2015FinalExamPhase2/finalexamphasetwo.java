package hlb_2015FinalExamPhase2;

import java.util.Scanner;
class animal{
	public String animalName;
	public animal(String name)
	{
		animalName = name;
	}
	public String getAnimalName()
	{
		return animalName;
	}
	public void dosomething()
	{
		System.out.println(getAnimalName()+",dosomething1");
	}
}

interface perform{
	void performSomething();
}

/******start******/
class cat  extends animal {
	
	private String myability;
	
	public cat(String name,String myability) {
		super(name);
		this.myability=myability;
	}
	
	public void dosomething()
	{
		System.out.println(this.animalName+",dosomething2");
	}
	public void performSomething() {
		System.out.println("it has:"+myability);
		
	}
	
	
	
}









/******end******/
public class finalexamphasetwo {

	public static void main(String[] args) {
		//���´���Ӽ��̽�������
		Scanner san = new Scanner(System.in);
		String catname = san.next();
		String ability = san.next();
		//ʵ��������cat����
		animal cat1 = new cat(catname+"1",ability);
		cat cat2 = new cat(catname+"2",ability);
		System.out.println("Output:");
		cat1.dosomething();			
		cat2.dosomething();
		//���ڴ˴�ѡ��cat1����cat2������performSomething����
		/******start******/
         cat2.performSomething();
                
                /******end******/	
   }

}