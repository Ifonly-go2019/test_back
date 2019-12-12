package en_p3_001_easy_xx;

import java.util.Scanner;

/******start******/
interface features{
	void openDoor(); 
	void closeDoor();
}
class RealDoor implements features{
   
	
	public void openDoor() {
	System.out.println("openDoor");	
		
	}

	@Override
	public void closeDoor() {
		System.out.println("closeDoor");	
		
	}
	public void theftproof(){
		System.out.println("theftproof");	
	}
     public void waterproof(){
	System.out.println("waterproof");	
	}
   public void bulletproof(){
	System.out.println("bulletproof");	
}
	
}

/******end******/

public class Main {
	public static void main(String args[]) {
		Scanner san = new Scanner(System.in);
		String type = san.next();
		
		RealDoor d = new RealDoor();
		
		switch(type){
        	default:
        		break;
        	case "o":
        		d.openDoor();
          		break;
       		case "c":
        		d.closeDoor();
            		break;
       		case "t":
        		d.theftproof();
            		break;
        	case "w":
        		d.waterproof();
            		break;
       		case "b":
        		d.bulletproof();
            		break;
		}
	}
}