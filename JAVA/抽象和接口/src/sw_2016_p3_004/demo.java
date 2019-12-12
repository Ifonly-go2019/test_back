package sw_2016_p3_004;
import java.util.Scanner;
/******start******/
interface Power{
	 
	void providePower();
}
class ACPower implements Power{
    private String name;
	
    public ACPower(String name) {
    	this.name=name;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void providePower() {
		
		System.out.println(getName()+"���������");
	}
	
}
class DCPower implements Power{
	private String name;
	 public DCPower(String name) {
	    	this.name=name;
	    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void providePower() {
		System.out.println(getName()+"���ֱ����");
	}

	
	
}
/******end******/



public class demo{
	public static void main(String[] args) {
		System.out.println("������һ�ֽ�����Դ��ֱ����Դ�����ƣ��Կո�ֿ�");
		Scanner scanner = new Scanner(System.in);
		String acPowerName = scanner.next();
		String dcPowerName = scanner.next();
		System.out.println("output:");
		Power power = new ACPower(acPowerName);
		power.providePower();
		power = new DCPower(dcPowerName);
		power.providePower();
}
}