package sw_interface_normal;

import java.util.Scanner;
interface Singer{
/******start******/
 void show(String song);
 void practice();




/******end******/
}

/******start******/
class SuperStar implements Singer{
	private String name;
	public SuperStar(String name) {
		this.name=name;
		
}
	
	public String getName() {
		return name;
	}

	public void show(String song) {
	System.out.println(getName()+" is singing:"+song);
		
	}
	
	public void practice() {
	System.out.println(getName()+" is practicing:do re mi");
		
	}

}



/******end******/
public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String song = scanner.next();
		System.out.println("output:");
		Singer star = new SuperStar(name);
		star.practice();
		star.show(song);
		scanner.close();
	}
}





