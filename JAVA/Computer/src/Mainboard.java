
public class Mainboard {
   String strCPU;
   VideoCard vCard;


   
   public void setstrCPU(String strCPU) {
	   this.strCPU=strCPU;
   }
      
   public void setvCard(VideoCard vCard) {
	   this.vCard= vCard;//用一个接口承载传入的
   }
   
   public void run() {//全是对象
	   System.out.println(strCPU);
	   System.out.println(vCard.getName());
	   vCard.Display();
	   System
   }
}