package ch_sw_p3_f002_hard;

import java.util.Scanner;
/******start******/
 interface Sortable {
	public void sort();	
}
class ScoreTable implements Sortable{
	private String courseName;
	private float[] scores= new float[4] ;
	
	/**带参数构造方法 */
	public ScoreTable(String courseName,float[] scores) {
		this.courseName=courseName;
		this.scores=scores;
	}
	public ScoreTable() {}

	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public float[] getScores() {
		return scores;
	}
	public void setScores(float[] scores) {
		this.scores = scores;
	}
	
	
	
	public void sort() {
	  
     for (int i = 0; i<scores.length; i++){
          for (int j = i+1; j<scores.length; j++){
              if(scores[i]>scores[j]){
                  float temp = scores[i];
                  scores[i] = scores[j];
                  scores[j] = temp;
              }
          }
      }	
}




/******end******/
	public class Main {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("输入一门课程名称与4个课程成绩数据，比如:C语言 76.7 89.5 56.0 82.1");
			String courseName = scanner.next();
			float[] scores = {scanner.nextFloat(),scanner.nextFloat(),scanner.nextFloat(),scanner.nextFloat()};
			Sortable sortable = new ScoreTable(courseName, scores);
			ScoreTable scoreTable = (ScoreTable)sortable;
			scoreTable.sort();
			System.out.println("课程:"+scoreTable.getCourseName()+"的成绩单如下:");
			for (float score : scoreTable.getScores()) {
				System.out.print(score+ " ");
			}
			scanner.close();
		}
	}

