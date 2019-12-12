package exp2.entities;
public class student {
  private String name;
  private String id;
  private int credit;
  
  
  private int creditForGraduation;

 
  
  
  
  /** 构造方法  一种带参数 另一种不带参数*/ 
  public student() {}
  public student(int creditForGraduation) {
 	 this.creditForGraduation=creditForGraduation;
 }

  
  
  
  public int getCreditForGraduation() {
 	return creditForGraduation;
 }
    public void setCreditForGraduation(int creditForGraduation) {
 	   if(creditForGraduation<10) {//判断输入的值 
 		   System.out.println("这位同学未获取毕业所需总学分");
 	   }
 	   else
 		   System.out.println("毕业所需学分为10分");
 	this.creditForGraduation = creditForGraduation;
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
 
 public void rate(int s) {
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

 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        student st=new student();
        st.setName("张三");
        st.setId("001");
        st.setCredit(10);
        st.rate(st.getCredit());
        st.setCreditForGraduation(10);
       
               
	}

}	
