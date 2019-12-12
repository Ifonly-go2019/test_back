package en_sw_p3_f001_hard;

import java.util.Scanner;
/******start******/
interface Convertor{
	
	 double convert();
}

class Thermometer implements Convertor{
	private double  temperature;//计量单位是摄氏度
	
	/**带参数构造方法*/
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
    	return getTemperature()*1.8+32;//将摄氏度换算为华氏度
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
                System.out.println("Current Temperature is:"+thermometer.getTemperature()+"℃  or "+thermometer.convert()+"℉");
		thermometer.setTemperature(40.1);
		System.out.println("Current Temperature is:"+thermometer.getTemperature()+"℃  or "+thermometer.convert()+"℉");
		scanner.close();
	}
}