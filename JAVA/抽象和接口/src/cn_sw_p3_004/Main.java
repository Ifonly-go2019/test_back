package cn_sw_p3_004;

import java.util.Scanner;
/**
 * ����һ����ΪConvertor�Ľӿڣ��ýӿڱ�ʾһ����������֧�ָ�������֮��Ļ��㣬����Ӣ�߻���Ϊ�ף�������Ϊ����ȣ�
 * ΪConvertor�ӿڶ�����������ϵ��������һ����ʾӢ�߻���Ϊ�׵Ļ���ϵ����1Ӣ�� = 0.305�ף�һ����ʾ������Ϊ����Ļ���ϵ����1�� = 0.454���
 * ΪConvertor�ӿڶ���һ������������ǩ��Ϊ��double convert(double input)���÷�����ʾ����������������input���ݻ���Ϊ��Ӧ�����ݡ�
  */
/******start******/
interface Convertor{
	double yingchi=0.305;
	double bang=0.454;
	double convert(double input);
} 
/******end******/

/**
 * ����һ�����Ȼ������ࣺLengthConvertor������ʵ����Convertor�ӿڣ�ʵ�ָýӿ��е�convert���������û�����ĵ�λΪӢ�ߵĳ������ݻ���Ϊ��λΪ�׵ĳ������ݡ�
 *
 */
/******start******/
class LengthConvertor implements Convertor{
	public double convert(double input) {
		return input*yingchi;
   }	
}
/******end******/

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Convertor convertor = new LengthConvertor();
		System.out.println("������һ��������ֵ����λΪӢ�ߣ�");
		double input = scanner.nextDouble();
		System.out.println("output:");
		System.out.println(input+"Ӣ�ߵ���"+convertor.convert(input)+"��");
		scanner.close();
	}
}