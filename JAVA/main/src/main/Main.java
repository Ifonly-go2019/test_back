package main;
 class Airth{
	 int divide(int a,int b) {
	   try { 
		   return a/b;
	   }
	   catch (Exception e){
		   System.out.print("an exception happen\n");
	   }
	   return 0;
	 }	   
	
}
 

 
 
 public class Main {
	public static void main(String[] args) {
		Airth airth=new Airth();
		int resurt =airth.divide(5, 0);
		System.out.println(""+resurt);
		
		
	}

}
