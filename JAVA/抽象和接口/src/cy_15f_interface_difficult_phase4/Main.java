package cy_15f_interface_difficult_phase4;

import java.util.Scanner;
/******start******/
interface canobtainperformance_score{
	float ObtainPerformance_score();
}
class traincourse implements canobtainperformance_score{

	private String trainname;
	private int train_num;
	
	
	public traincourse(String trainname,int train_num) {
		this.trainname=trainname;
		this.train_num=train_num;
	}
	
	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public int getTrain_num() {
		return train_num;
	}

	public void setTrain_num(int train_num) {
		this.train_num = train_num;
	}

	public float ObtainPerformance_score() {
	      float i=0;     
		if(getTrain_num()>=20) {
	        	 i=1;
	   }
		return i;
	}
	
}
class project implements canobtainperformance_score{
	private String name;
	private int degree;
    
	
	//构造函数
	public project(String name, int degree) {
		
		this.name = name;
		this.degree = degree;
	}
    


	public String getName() {
		return name;
	}
	public int getDegree() {
		return degree;
	}



	public float ObtainPerformance_score() {
		if(getDegree()>2) {
		return 1;
		}
		return 0;
	}
	
}
class engineer {
	private String name;
	
	
	public engineer(String name) {
		this.name=name;
	}
	
	public boolean obtainBonus(canobtainperformance_score cps) {
		if(cps.ObtainPerformance_score()>0) {
			return true; }
		else 
			return false;
	}
}


	/******end******/
	
	public class Main{
	public static void main(String [] arg){
		 System.out.println("output:");
		 Scanner san = new Scanner(System.in);
		 String ename = san.next();
		 String projectname = san.next();
		 String trainname = san.next();
		 int train_num = san.nextInt();
		 int degree = san.nextInt();
		
		 engineer e = new engineer(ename);
		canobtainperformance_score p = new project(projectname,degree);
		canobtainperformance_score tc = new traincourse(trainname,train_num);
		if(e.obtainBonus(tc)){
			System.out.println(ename+"获取培训课绩效工资");
		}
		if(e.obtainBonus(p)){
			System.out.println(ename+"获取项目绩效工资");
		}
         if(!e.obtainBonus(tc)&&!e.obtainBonus(p)){
			System.out.println(ename+"没有获取任何绩效工资");
		}
		
		san.close();
	
	}
	}



