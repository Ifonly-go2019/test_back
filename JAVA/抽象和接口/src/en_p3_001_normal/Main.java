package en_p3_001_normal;

import java.util.Scanner;

/******start******/
interface behaviors{
	void eat()
}



/******end******/

public class Main {
	public static void main(String[] args) {
		Scanner san = new Scanner(System.in);
		String type = san.next();
		
		if (type.equals("p")) {
			Person person = new SouthPerson();
			person.eat();
		} else if (type.equals("s")) {
			SouthPerson southPerson = new SouthPerson();
			southPerson.work();
		} else {}
	}
}