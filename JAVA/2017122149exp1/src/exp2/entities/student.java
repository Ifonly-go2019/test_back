package exp2.entities;
public class student {
  private String name;
  private String id;
  private int credit;
  
  
  private int creditForGraduation;

 
  
  
  
  /** ���췽��  һ�ִ����� ��һ�ֲ�������*/ 
  public student() {}
  public student(int creditForGraduation) {
 	 this.creditForGraduation=creditForGraduation;
 }

  
  
  
  public int getCreditForGraduation() {
 	return creditForGraduation;
 }
    public void setCreditForGraduation(int creditForGraduation) {
 	   if(creditForGraduation<10) {//�ж������ֵ 
 		   System.out.println("��λͬѧδ��ȡ��ҵ������ѧ��");
 	   }
 	   else
 		   System.out.println("��ҵ����ѧ��Ϊ10��");
 	this.creditForGraduation = creditForGraduation;
 }
     /** ������*/
  public void setCredit(int Credit ) {
	this.credit = Credit;
 } 
 public void setName(String Name) {
	this.name=Name;
}
 public void setId(String Id) {
	 this.id=Id;
 }
 
 public String getName() {
	 return name;
 }
 public String getId() {
	 return id;
 }
 public int getCredit() {
	 return  credit;
 }
 
 public void rate(int s) {
System.out.println("������"+this.getName()+"\t"+"ѧ��:"+this.getId()+"\n"+"ѧ��:"+this.getCredit());
	  System.out.println("�ɼ��ȼ���");    
		// TODO Auto-generated method stub
		String x;
		if(s>=6&&s<9) {
			x="�ϸ�";
			System.out.println(""+x);
		}
		else if(s>9) {
			x="��";
			System.out.println(""+x);
		}
		else {
			x="���ϸ�";
			System.out.println(""+x);
		}
		
	}

 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        student st=new student();
        st.setName("����");
        st.setId("001");
        st.setCredit(10);
        st.rate(st.getCredit());
        st.setCreditForGraduation(10);
       
               
	}

}	
