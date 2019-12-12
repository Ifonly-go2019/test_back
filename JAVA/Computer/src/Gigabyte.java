
public class Gigabyte implements VideoCard {

	 String name;
	 
	public void Display() {
		// TODO Auto-generated method stub
          System.out.println("Gigabyte's videocard  is running");
	}

	public Gigabyte(String name) {
		super();
		this.name = "Gigabyte's videocard is ";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
