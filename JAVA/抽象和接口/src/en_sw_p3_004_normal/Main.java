package en_sw_p3_004_normal;
import java.util.Scanner;

class Vehicle{
	private String model; //汽车型号
	private double fuelTankCapacity;    //汽车油箱容量
	public Vehicle(String model,double fuelTankCapacity) {
		super();
		this.model = model;
		this.fuelTankCapacity = fuelTankCapacity;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getFuelTankCapacity() {
		return fuelTankCapacity;
	}
	public void setFuelTankCapacity(double fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}
       //计算油耗：油箱容量/这箱油能跑的总里程*100即为每100公里的油耗
	public double fuelConsumption(double fuelMileages){
		return fuelTankCapacity/fuelMileages*100;
	}
	
	
}
/******start******/

class HybridVehicle extends Vehicle{
	private double electricPower,kmOfPerKWh;
	
	public HybridVehicle(String model, double fuelTankCapacity) {
		super(model, fuelTankCapacity);
		// TODO Auto-generated constructor stub
	}

	public HybridVehicle(String model, double fuelTankCapacity, double electricPower, double kmOfPerKWh) {
		super(model, fuelTankCapacity);
		this.electricPower = electricPower;
		this.kmOfPerKWh = kmOfPerKWh;
	}
	public double fuelConsumption(double fuelMileages){
		return getFuelTankCapacity()/(fuelMileages+electricPower*kmOfPerKWh)*100;
	}

	public double getElectricPower() {
		return electricPower;
	}

	public void setElectricPower(double electricPower) {
		this.electricPower = electricPower;
	}

	public double getKmOfPerKWh() {
		return kmOfPerKWh;
	}

	public void setKmOfPerKWh(double kmOfPerKWh) {
		this.kmOfPerKWh = kmOfPerKWh;
	}
	
}










/******end******/
public class Main{
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("BMW 320", 50.0);
		System.out.printf(vehicle.getModel()+" fuel consumption is :%.3f",vehicle.fuelConsumption(550));
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter hybridVehicle's model, fuelTankCapacity, electricPower and kmOfPerKWh:");
		String model = scanner.next();
		double fuelTankCapacity = scanner.nextDouble();
		double electricPower = scanner.nextDouble();
		double kmOfPerKWh = scanner.nextDouble();
		Vehicle vehicle2 = new HybridVehicle(model,fuelTankCapacity,electricPower,kmOfPerKWh);
		System.out.printf(vehicle2.getModel()+" fuel consumption is :%.3f",vehicle2.fuelConsumption(550));
		System.out.println();
		HybridVehicle hybridVehicle = new HybridVehicle("Tesla x", 10);
		hybridVehicle.setElectricPower(100);
		hybridVehicle.setKmOfPerKWh(10);
		System.out.printf(hybridVehicle.getModel()+" fuel consumption is :%.3f",hybridVehicle.fuelConsumption(550));
		scanner.close();
	}
}