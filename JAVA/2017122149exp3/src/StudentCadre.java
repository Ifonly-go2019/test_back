import exp2.entities.*;

public class StudentCadre extends student{
	 
	  private String headship;
	

  







         /** 方法区*/


    public String getHeadship() {
		return headship;
	}
	public void setHeadship(String headship) {
		this.headship = headship;
	}
   /** speech 方法的重载 */
   public void speech(String id) {
	   System.out.println("演讲之前首先谈谈自己:");
   }
   public void speech(String name,String headship ) {
	   
	   System.out.println("姓名"+'\t'+this.getName()+'\t'+'\n'+"职务"+'\t'+this.getHeadship());
	   
   }
   /** rate方法的覆盖*/
  public void show(double  credit) {
		// TODO Auto-generated method stub
		String x;
		if( super.getCredit()>=6&& super.getCredit()<=9.5) {
			x="合格";
			System.out.println(x);
		}
		else if( super.getCredit()>9.5) {
			x="优";
			System.out.println(x);
		}
		else {
			x="不合格";
			System.out.println(x);
		}
		
	}//rate方法调用的show已经被覆盖,实际上覆盖的是rate

   
   
/** studentcardre的构造方法*/
   
 public StudentCadre() { super();}//无参数
 public StudentCadre(String name,String id,int credit,String headship ) {
	 
	 super.setName(name);
	 super.setId(id);
	 super.setCredit(credit);
	setHeadship(headship);
	
 }//带参数构造方法








        public static void  main(String[]  args) {
		// TODO Auto-generated method stub
		StudentCadre st1= new StudentCadre("爽爽","2017122110",9,"心理委员");
		st1.speech(st1.getId());
		st1.speech(st1.getName(),st1.headship);
		st1.rate();
		st1.setCreditForGraduation(12);
    } 



}
