package exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) {
		
		FileReader fileReader=null;
		
		try {	
			//����Ҫ��ȡ�������ļ����ļ����� file

		File file = new File("d:\\data.txt");
		//����Ҫ��ȡ���ݵ�������
		 fileReader = new FileReader(file);
		//���������ж�ȡһ���ַ���
		int c = fileReader.read();
		//�ж��Ƿ��ȡ���ļ������������ȡ���ļ������᷵��-1
		while (c!=-1) {
			//�����ȡ������ַ�
			System.out.println((char)c);
			//�ٶ�ȡ��һ���ַ�
			c = fileReader.read();
		}
	}
	 catch (FileNotFoundException e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	catch(IOException c)
	{
		c.printStackTrace();
	}
		//���ж�ȡ��Ϻ󣬹ر�fileReader����Ҫ�󲻹�ǰ���Ƿ��׳��쳣��
		//������Ҫִ�йرղ�����
finally {
	

	
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
} 
	}
}
