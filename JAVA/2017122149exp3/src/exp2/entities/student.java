package exp2.entities;
public class student {
  private String name;
  private String id;
  public int credit;
  static int creditForGraduation;
  
 
  
  
  
  /** ���췽��  һ�ִ����� ��һ�ֲ�������*/ 
  public student() {}
  public student(String name,String id,int credit,int creditForGraduation) {
	     setName(name);
		 setId(id);
		 setCredit(credit);
		 //setCreditForGraduation(creditForGraduation)
 	
 }

  
  
  
  public static int getCreditForGraduation() {
 	return creditForGraduation;
 }
    public static void setCreditForGraduation(int creditForGraduation) {
 	 
 	      student.creditForGraduation = creditForGraduation;
 	      System.out.println("ѧ���ɲ������ҵ����ѧ��Ϊ"+creditForGraduation);
 }
  public static void modifyCreditForGraduation() {
	  
	setCreditForGraduation(creditForGraduation);
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
 
 public void show(int s) {
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
   public void rate() {
	   show(credit);
   }
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        student st=new student();
        st.setName("����");
        st.setId("001");
        st.setCredit(10);
        st.rate();
        st.setCreditForGraduation(10);
       
               
	}
}