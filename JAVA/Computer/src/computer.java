
public class computer {

	  public static void main(String[] args) {
		  Gigabyte gigabyte=new Gigabyte();
		  Mainboard mainboard=new Mainboard();
		  mainboard.setstrCPU("i5 cpu");
		  mainboard.setvCard(gigabyte);
		  
		  mainboard.run();
	  }
}
