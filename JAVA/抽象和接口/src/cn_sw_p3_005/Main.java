package cn_sw_p3_005;

import java.util.Scanner;
/**
 * 定义一个名为Convertor的接口，该接口表示一个换算器，支持各种数据之间的换算，比如英尺换算为米，磅换算为公斤等；
 * 为Convertor接口定义两个换算系数常量，一个表示英尺换算为米的换算系数：1英尺 = 0.305米；一个表示磅换算为公斤的换算系数：1磅 = 0.454公斤；
 * 为Convertor接口定义一个方法，方法签名为：double convert(double input)，该方法表示换算操作，将输入的input数据换算为相应的数据。
 * 
 *
 */
/******start******/
interface Convertor{
	double m=0.305;//1英尺 = 0.305米
	double p=0.454;//1磅 = 0.454公斤
	double convert(double input);//换算操作
}





/******end******/
/**
 * 定义一个重量换算器类：WeightConvertor，该类实现了Convertor接口，实现该接口中的convert方法，将用户输入的单位为磅的重量数据换算为单位为公斤的数据。
 */
/******start******/
class WeightConvertor implements Convertor{


	public double convert(double input) {
		
		return input*p;
	}
	
	
}







/******end******/

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Convertor convertor = new WeightConvertor();
		System.out.println("请输入一个表示重量的数值，单位为磅：");
		double input = scanner.nextDouble();
		System.out.println("output:");
		System.out.println(input+"磅等于"+convertor.convert(input)+"公斤");
		scanner.close();
	}
}