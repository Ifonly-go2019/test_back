package exceptions;

	import java.util.Scanner;
public class UncheckedExceptionExp {
private static int op1 = 325;//被除数

public static int division(int op1, int op2) {
	int result=Integer.MIN_VALUE;
	
	try {
		result=op1/op2;
	} catch (Exception e) {
// TODO: handle exception
		System.err.println("输入有误除数不能为0。");
		
	}
	return result;
}

public static void main(String[] args) {
	System.out.println("请输入除数：");
	Scanner scanner = new Scanner(System.in);
	int op2 = scanner.nextInt();
	int result = division(op1, op2);
	System.out.println(""+result);
}
}

