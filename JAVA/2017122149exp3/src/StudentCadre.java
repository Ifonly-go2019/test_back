import exp2.entities.*;

public class StudentCadre extends student{
	 
	  private String headship;
	

  







         /** ������*/


    public String getHeadship() {
		return headship;
	}
	public void setHeadship(String headship) {
		this.headship = headship;
	}
   /** speech ���������� */
   public void speech(String id) {
	   System.out.println("�ݽ�֮ǰ����̸̸�Լ�:");
   }
   public void speech(String name,String headship ) {
	   
	   System.out.println("����"+'\t'+this.getName()+'\t'+'\n'+"ְ��"+'\t'+this.getHeadship());
	   
   }
   /** rate�����ĸ���*/
  public void show(double  credit) {
		// TODO Auto-generated method stub
		String x;
		if( super.getCredit()>=6&& super.getCredit()<=9.5) {
			x="�ϸ�";
			System.out.println(x);
		}
		else if( super.getCredit()>9.5) {
			x="��";
			System.out.println(x);
		}
		else {
			x="���ϸ�";
			System.out.println(x);
		}
		
	}//rate�������õ�show�Ѿ�������,ʵ���ϸ��ǵ���rate

   
   
/** studentcardre�Ĺ��췽��*/
   
 public StudentCadre() { super();}//�޲���
 public StudentCadre(String name,String id,int credit,String headship ) {
	 
	 super.setName(name);
	 super.setId(id);
	 super.setCredit(credit);
	setHeadship(headship);
	
 }//���������췽��








        public static void  main(String[]  args) {
		// TODO Auto-generated method stub
		StudentCadre st1= new StudentCadre("ˬˬ","2017122110",9,"����ίԱ");
		st1.speech(st1.getId());
		st1.speech(st1.getName(),st1.headship);
		st1.rate();
		st1.setCreditForGraduation(12);
    } 



}
