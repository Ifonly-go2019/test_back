package en_2017_sw_p3_002;

import java.util.Scanner;

//inteface Colorable
/******start******/
interface Colorable{
	void howToColor(String color);
}






/******end******/

//class Square
/******start******/
class Square implements Colorable{
    private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void howToColor(String color) {
	    System.out.println("Color all four sides to paint "+getColor()+"The"+getColor()+" is the color");
		
	}
	
}





/******end******/
public class Main {
  public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a color:");
		String color = scanner.next();
		Colorable colorSquare = new Square();
		colorSquare.howToColor(color);
		scanner.close();
	}
}