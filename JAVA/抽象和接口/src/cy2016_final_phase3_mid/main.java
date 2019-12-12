package cy2016_final_phase3_mid;

import java.util.Scanner;
/******start******/
interface averageable{
	float calcAverage(course c);
	
}




/******end******/

class course implements averageable{
/******start******/
 private String name;
 private  int score;
 
 
 public course(String name,int score) {
	 this.name=name;
	 this.score=score;
 }
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}

public float calcAverage(course c2) {
	double s=(getScore()+c2.getScore())*0.5;
	return  (float) s;
}
 










}
/******end******/
public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputName1 = scanner.next();
		int inputScore1 = Integer.parseInt(scanner.next());
		String inputName2 = scanner.next();
		int inputScore2 = Integer.parseInt(scanner.next());
		course c1 = new course(inputName1, inputScore1);
		course c2 = new course(inputName2, inputScore2);
		float r = c1.calcAverage(c2);
                System.out.print("output:");
		System.out.println("张三的"+c1.getName()+"与"+c2.getName()+"的成绩的平均值为："+r);	}
	
	
}
