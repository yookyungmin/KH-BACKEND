import java.util.Scanner;
import java.util.Set;

import javax.xml.stream.events.StartDocument;

public class Exam_01 {

//	public static void stdregister(Scanner sc) {
//		System.out.println("학생 입력");
//		Student stu = Student();
//	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//변수 -> 배열->구조체->클래스
//		
//		Student std = new Student();
//	
//		std.setEng(50);
//		std.setKor(50);
//		std.setName("Tom");
//		
//		System.out.println(std.toString());
//		
		
		
		
//	
		
//	
		
		
//		Student std1= new Student("Tom", 50, 80);
//		Student std2= new Student("Jane", 30, 80);
//		Student std3= new Student("Alex", 20, 90); //생성자로 값넣고 출력
//		System.out.println("이름\t국어\t영어");
//		System.out.println(std1.getName()+"\t"+std1.getKor()+"\t"+std1.getEng());
//		System.out.println(std2.getName()+"\t"+std2.getKor()+"\t"+std2.getEng());
//		System.out.println(std3);
		
		while(true) {
			System.out.println("학생 수를 입력하세요");
			int i = Integer.parseInt(sc.nextLine());
			Student[] st = new Student[i];
			System.out.println("성적표입니다");
		for(int j = 0; j<st.length; j++) {
			System.out.print("이름==>");
			String name = sc.nextLine();
			System.out.print("국어 점수==>");
			int kor = Integer.parseInt(sc.nextLine());
			System.out.print("영어 점수==>");
			int eng = Integer.parseInt(sc.nextLine());
			
			st[j] = new Student(name, kor, eng);
		}
		System.out.println("이름\t국어\t영어\t합계\t평균");
		for(int j = 0; j<st.length; j++) {
			int total = st[j].getKor()+st[j].getEng();
			double avg = total/2.0;//평균
			System.out.println(st[j].getName()+"\t"+st[j].getKor()+"\t"+st[j].getEng()+"\t"+total+"\t"+avg);
		}
		
//		
//		st[1]= new Student("Jane", 50, 60);
//		st[2]= new Student("Martin", 70, 60);
//		for(int j = 0; j<st.length; j++) {
//				System.out.println((j+1)+"번째 학생은"+st[j]);
//		 
////			System.out.println(st.toString());
//		}
		
//		for(int j = 0; j<st.length; j++) {
//			System.out.println((j+1)+"번째 학생은 =>");
//			st[j]=Integer.parseInt()
//		}
		
		}
		}
		
}
