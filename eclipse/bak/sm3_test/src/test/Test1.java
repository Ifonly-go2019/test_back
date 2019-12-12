package test;


import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;
public class Test1 {
	
	


	
	public  ArrayList<Integer[]> toReade_data() {
		// 使用ArrayList来存储每行读取到的字符串
		ArrayList<Integer[]> arrayList = new ArrayList<>();
		
		try {
			
			FileReader fr = new FileReader("E:\\data\\data_1.txt");
			
			BufferedReader bf = new BufferedReader(fr);
			
			
			//File f=new File("E:/data/data_1.txt");
			//FileInputStream bf=new FileInputStream(fr);

			String str;
			
			// 按行读取字符串
			while ((str = bf.readLine()) != null) {
				//System.out.println(str);
				char[] sp = new char[]{32};
				String strings[] = str.split(new String(sp));
				Integer[] num = new Integer[strings.length];
				for (int i = 0; i < strings.length; i++) {
					//System.out.println(strings[i]);
					Integer a;
					a = Integer.parseInt(strings[i],16);
					num[i]=a;
				}
				
				arrayList.add(num);
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对ArrayList中存储的字符串进行处理
//		int length = arrayList.size();
//		int[] array = new int[length];
//		for (int i = 0; i < length; i++) {
//			String s = arrayList.get(i);
//			array[i] = Integer.parseInt(s);
//		}
		// 返回数组
		return arrayList;

	}
	
	
public byte[][] initdata(){
	ArrayList<Integer[]> arrayList=toReade_data();
	//r.initdata(arrayList);
	//Class x= arrayList.getClass();
	//int a = arrayList.size();
	//System.out.println(Arrays.toString(b));
	Integer[][] arr = new Integer[100][32];
	byte[][] arrByte = new byte[100][32];
	int temp;
	for(int i = 0;i<100;i++) {
		for(int j =0;j<32;j++) {
			Integer[] integerArray = Arrays.copyOfRange(arrayList.get(i), 0, 32, Integer[].class);
			arr[i][j] = integerArray[j];
			temp = arr[i][j];
			arrByte[i][j] = (byte)temp;
		}
		
	}
	System.out.println(arrByte[0][0]);
	
	
	
	
 return 	arrByte;
}	
	


	
	public static <T> void main(String[] args) {    
		byte[] data =null;
		Test1 r= new Test1();
		r.initdata();
	
	}		
}

