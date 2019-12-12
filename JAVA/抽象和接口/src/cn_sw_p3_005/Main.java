package cn_sw_p3_005;

import java.util.Scanner;
/**
 * ����һ����ΪConvertor�Ľӿڣ��ýӿڱ�ʾһ����������֧�ָ�������֮��Ļ��㣬����Ӣ�߻���Ϊ�ף�������Ϊ����ȣ�
 * ΪConvertor�ӿڶ�����������ϵ��������һ����ʾӢ�߻���Ϊ�׵Ļ���ϵ����1Ӣ�� = 0.305�ף�һ����ʾ������Ϊ����Ļ���ϵ����1�� = 0.454���
 * ΪConvertor�ӿڶ���һ������������ǩ��Ϊ��double convert(double input)���÷�����ʾ����������������input���ݻ���Ϊ��Ӧ�����ݡ�
 * 
 *
 */
/******start******/
interface Convertor{
	double m=0.305;//1Ӣ�� = 0.305��
	double p=0.454;//1�� = 0.454����
	double convert(double input);//�������
}





/******end******/
/**
 * ����һ�������������ࣺWeightConvertor������ʵ����Convertor�ӿڣ�ʵ�ָýӿ��е�convert���������û�����ĵ�λΪ�����������ݻ���Ϊ��λΪ��������ݡ�
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
		System.out.println("������һ����ʾ��������ֵ����λΪ����");
		double input = scanner.nextDouble();
		System.out.println("output:");
		System.out.println(input+"������"+convertor.convert(input)+"����");
		scanner.close();
	}
}