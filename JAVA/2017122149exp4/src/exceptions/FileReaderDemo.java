package exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) {
		
		FileReader fileReader=null;
		
		try {	
			//创建要读取的数据文件的文件对象 file

		File file = new File("d:\\data.txt");
		//创建要读取数据的输入流
		 fileReader = new FileReader(file);
		//从输入流中读取一个字符；
		int c = fileReader.read();
		//判断是否读取到文件结束，如果读取到文件的最后会返回-1
		while (c!=-1) {
			//输出读取的这个字符
			System.out.println((char)c);
			//再读取下一个字符
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
		//所有读取完毕后，关闭fileReader对象，要求不管前面是否抛出异常，
		//都必须要执行关闭操作。
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
