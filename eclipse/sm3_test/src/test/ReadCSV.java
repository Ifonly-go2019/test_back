package test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReadCSV {
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
//		ArrayList<String> csvList = getCsv();

//		float[][] arr = new float[csvList.size()][];
//		for (int i = 0; i < csvList.size(); i++) {
//			String[] split = csvList.get(i).split(" ");
//			float[] lineArr = new float[split.length];
//			for (int j = 0; j < split.length; j++) {
//				lineArr[j] = Float.parseFloat(split[j]);
//			}
//			arr[i] = lineArr;
//		}
//		
//		System.out.println(arr[0][1]);
//		String h = "48.496529";
//		float parseFloat = Float.parseFloat(h);
//		System.out.println(parseFloat);
	}
	
	
	
	
	
	public float[][] initTrace() throws Exception{
		ArrayList<String> csvList = getCsv();
//		����һ��2λ���飬2λ��������  csvList.size ��һλ���飬Ȼ��һλ����û�и�ֵ
		float[][] arr = new float[csvList.size()][];
		for (int i = 0; i < csvList.size(); i++) {
			String[] split = csvList.get(i).split(" ");
			float[] lineArr = new float[split.length];
			for (int j = 0; j < split.length; j++) {
				lineArr[j] = Float.parseFloat(split[j]);
			}
			arr[i] = lineArr;
		}
		
		return arr;
	}
	
	
	
	public static ArrayList<String> getCsv() throws Exception{
		FileReader fr = new FileReader("E:\\data\\traces.csv");
		BufferedReader bf = new BufferedReader(fr);
		ArrayList<String> arrayList = new ArrayList<String>();
		String str;
		// ���ж�ȡ�ַ���
		while ((str = bf.readLine()) != null) {
			arrayList.add(str);
		}
		bf.close();
		fr.close();
		return arrayList;
	}
}