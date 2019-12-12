package en_sw_p3_f001_hard;

import java.util.Scanner;
/******start******/
interface Convertor{
	
	 double convert();
}

class Thermometer implements Convertor{
	private double  temperature;//������λ�����϶�
	
	/**���������췽��*/
	public Thermometer(double temperature){
		this.temperature=temperature;
	}

    
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}


	public double convert() {
    	return getTemperature()*1.8+32;//�����϶Ȼ���Ϊ���϶�
	}
	
}



/******end******/
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a temperature value,The unit of measurement is degrees Celsius:");
		double temperature = scanner.nextDouble();
		Thermometer thermometer = new Thermometer(temperature);
		System.out.println(thermometer instanceof Convertor);
                System.out.println("Current Temperature is:"+thermometer.getTemperature()+"��  or "+thermometer.convert()+"�H");
		thermometer.setTemperature(40.1);
		System.out.println("Current Temperature is:"+thermometer.getTemperature()+"��  or "+thermometer.convert()+"�H");
		scanner.close();
	}
}