package test;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadTxt {
	
	
	
	
	public byte[][] initarr() throws Exception{
		ArrayList<String> csvList = getCsv();
		byte[][] arr = new byte[csvList.size()][];
		for (int i = 0; i < csvList.size(); i++) {
			String[] split = csvList.get(i).split(" ");
			byte[] lineArr = new byte[split.length];
			for (int j = 0; j < split.length; j++) {
				int parseInt = Integer.parseInt(split[j]);
				
				lineArr[j] = (byte)parseInt;
			}
			arr[i] = lineArr;
		}
//		System.out.println(arr[1][2]);
		byte h = (byte)0xab;
//		System.out.println(h);
		
		
		return arr;
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception{
//		ArrayList<String> csvList = getCsv();
//		System.out.println(csvList.size());
//		����һ��2λ���飬2λ��������  csvList.size ��һλ���飬Ȼ��һλ����û�и�ֵ
//		byte[][] arr = new byte[csvList.size()][];
//		for (int i = 0; i < csvList.size(); i++) {
//			String[] split = csvList.get(i).split(" ");
//			byte[] lineArr = new byte[split.length];
//			for (int j = 0; j < split.length; j++) {
//				int parseInt = Integer.parseInt(split[j]);
//				
//				lineArr[j] = (byte)parseInt;
//			}
//			arr[i] = lineArr;
//		}
//		System.out.println(arr[1][2]);
//		byte h = (byte)0xab;
//		System.out.println(h);
//		
		byte[][] arr = null;
		ReadTxt RT=new ReadTxt();
		arr=RT.initarr();
		System.out.println(arr[0][0]);
		
	}
	public static ArrayList<String> getCsv() throws Exception{
		FileReader fr = new FileReader("E:\\data\\data.txt");
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