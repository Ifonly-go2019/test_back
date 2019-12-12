package en_sw_p3_f003;

import java.util.Scanner;

class Course{
	private String name;//�γ�����
	private String student; //ѧ������
	private double examScore; //��ѧ�����ſγ̳ɼ�
	public Course(String name, String student, double examScore) {
		super();
		this.name = name;
		this.student = student;
		this.examScore = examScore;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setExamScore(double examScore) {
		this.examScore = examScore;
	}
	
	public double getExamScore() {
		return examScore;
	}
	//һ��γ̵Ŀ��Գɼ��������ճɼ�
	public double getFinalScore(){
		return examScore;
	}
}
/******start******/
class  PracticeCourse  extends Course{
     private double proportion;
     private double practiceScore;
     
     /** �������췽��*/
	public PracticeCourse(String name, String student, double examScore,double practiceScore, double proportion) {
		super(name, student, examScore);
		this.proportion=proportion;
		this.practiceScore=practiceScore;
	}


	public double getProportion() {
		return proportion;
	}
    public void setProportion(double proportion) {
		this.proportion = proportion;
	}
	public double getPracticeScore() {
		return practiceScore;
	}
	public void setPracticeScore(double practiceScore) {
		this.practiceScore = practiceScore;
	}
	
	public double getFinalScore(){
		return getExamScore()*proportion+practiceScore*(1-proportion);
	}
}











/******end******/
public class Main {
	public static void main(String[] args) {
		System.out.println("Enter courseName, studentName,examScore,practiceScore and Proportion:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String student = scanner.next();
		double examScore = scanner.nextDouble();
		double practiceScore = scanner.nextDouble();
		double proportion = scanner.nextDouble();
		PracticeCourse c1 = new PracticeCourse(name, student, examScore, practiceScore, proportion);
		System.out.println(c1 instanceof Course);
		System.out.println(c1.getStudent()+"�ġ�"+c1.getName()+"���γ̵����ճɼ��ǣ�"+c1.getFinalScore());
		c1.setStudent("Jack");
		c1.setExamScore(100);
		c1.setPracticeScore(80);
		c1.setProportion(0.5);
		System.out.println(c1.getStudent()+"�ġ�"+c1.getName()+"���γ̵����ճɼ��ǣ�"+c1.getFinalScore());
		scanner.close();
	}
}