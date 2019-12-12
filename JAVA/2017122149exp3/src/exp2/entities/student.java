package exp2.entities;
public class student {
  private String name;
  private String id;
  public int credit;
  static int creditForGraduation;
  
 
  
  
  
  /** 构造方法  一种带参数 另一种不带参数*/ 
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
 	      System.out.println("学生干部必须毕业所需学分为"+creditForGraduation);
 }
  public static void modifyCreditForGraduation() {
	  
	setCreditForGraduation(creditForGraduation);
  }

 
    
    
    /** 方法区*/
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
	 System.out.println("姓名："+this.getName()+"\t"+"学号:"+this.getId()+"\n"+"学分:"+this.getCredit());
	 	  System.out.println("成绩等级：");    
	 		// TODO Auto-generated method stub
	 		String x;
	 		if(s>=6&&s<9) {
	 			x="合格";
	 			System.out.println(""+x);
	 		}
	 		else if(s>9) {
	 			x="优";
	 			System.out.println(""+x);
	 		}
	 		else {
	 			x="不合格";
	 			System.out.println(""+x);
	 		}
	 		
	 	}
   public void rate() {
	   show(credit);
   }
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        student st=new student();
        st.setName("张三");
        st.setId("001");
        st.setCredit(10);
        st.rate();
        st.setCreditForGraduation(10);
       
               
	}
}