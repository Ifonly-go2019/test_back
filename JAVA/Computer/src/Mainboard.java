
public class Mainboard {
   String strCPU;
   VideoCard vCard;


   
   public void setstrCPU(String strCPU) {
	   this.strCPU=strCPU;
   }
      
   public void setvCard(VideoCard vCard) {
	   this.vCard= vCard;//��һ���ӿڳ��ش����
   }
   
   public void run() {//ȫ�Ƕ���
	   System.out.println(strCPU);
	   System.out.println(vCard.getName());
	   vCard.Display();
	   System
   }
}