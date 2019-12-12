package 单例模式;

public class SingleModelTest {
	
	
	public static void main(String[] args) {
		SingleModel single1 = SingleModel.getInstance();
		System.out.println(single1.count);
		single1.count++;
		
		SingleModel single2 = SingleModel.getInstance();
		System.out.println(single2.count);//实际上这两个实例是同一个实例
         System.out.println(single1 == single2);	//判断两者是否为同一个实例 判断的是地址
	}
}
