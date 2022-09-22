import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.css.ElementCSSInlineStyle;


public class Main {
	//VIEW와 control
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Manager manager = new Manager();



		while(true) {
			System.out.println("<<회원관리 시스템>>");
			System.out.println("1. 신규 정보 입력(학번/이름/국어/영어/수학");
			System.out.println("2. 학생 목록 출력(학번/이름/국어/영어/수학/합계/평균");
			System.out.println("3. 학생정보검색(이름으로 검색");
			System.out.println("4. 학생정보 삭제(학번으로 삭제)");
			System.out.println("5. 학생정보 수정(학번으로 수정)");
			System.out.println("6. 시스템 종료");
			System.out.println(">>>>>");

			int menu = Integer.parseInt(sc.nextLine());

			if(menu==1) {
				System.out.println("학년을 입력하세요(1freshman2junior)");
				int grade = Integer.parseInt(sc.nextLine());
				if(grade ==1) {
					try {
					System.out.println("학번을 입력하세요");
					int id = Integer.parseInt(sc.nextLine());
					System.out.println("이름을 입력하세요");
					String name = sc.nextLine();
					System.out.println("국어 점수를 입력하세요");
					int kor = Integer.parseInt(sc.nextLine());
					System.out.println("영어 점수를 입력하세요");
					int eng = Integer.parseInt(sc.nextLine());
					System.out.println("수학 점수를 입력하세요");
					int math = Integer.parseInt(sc.nextLine());

					manager.addMember(new Freshman(grade, id, name, math, kor, eng));
					continue;
				}catch (Exception e) {
					System.out.println("제대로 입력하세요");

				}
				}else if(grade==2) {
					try {
						System.out.println("학번을 입력하세요");
						int id = Integer.parseInt(sc.nextLine());
						System.out.println("이름을 입력하세요");
						String name = sc.nextLine();
						System.out.println("국어 점수를 입력하세요");
						int kor = Integer.parseInt(sc.nextLine());
						System.out.println("영어 점수를 입력하세요");
						int eng = Integer.parseInt(sc.nextLine());
						System.out.println("수학 점수를 입력하세요");
						int math = Integer.parseInt(sc.nextLine());

						manager.addMember(new Junior(grade, id, name, kor, eng, math));
						continue;
					}catch (Exception e) {
						System.out.println("제대로 입력하세요");

					}
				}else if(grade==3) {

				}else {
					System.out.println("번호를 1~3 입력해주세요");
				}




			}else if(menu==2) { //학생정보 모두 출력
				ArrayList<Student> mem= manager.getMembers();
				//ArrayList로 바로 접근이 안되기떄문에 getMembers사용
				System.out.println("학년\t학번\t이름\t국어\t영어\t수학\t합계\t평균");
				for(Student m:mem) {
					System.out.println(m.getGra()+"\t"+m.getId()+"\t"+m.getName()+"\t"+m.getKor()+"\t"+m.getEng()+"\t"+m.getEng()+"\t"+m.getTotal()+"\t"+m.getAvg());
				}

			}
			else if(menu==3) { //학생정보 이름으로 검색

				System.out.println("검색하실 이름을 입력하세요");
				String sname = sc.nextLine();
				ArrayList<Student> mem = manager.getSerachName();

				for(Student m : mem) {

					if(m.getName().equals(sname)) {
						System.out.println("학년\t학번\t이름\t국어\t영어\t수학\t합계\t평균");
						System.out.println(m.getGra()+"\t"+m.getId()+"\t"+m.getName()+"\t"+m.getKor()+"\t"+m.getEng()+"\t"+m.getEng()+"\t"+m.getTotal()+"\t"+m.getAvg());
					}
					else {
						System.out.println("검색된 정보가 없습니다");
						break;
					}

				}


			}else if(menu==4) { // 학생정보 학번으로 삭제
				System.out.println("삭제하실 학번을 입력하세요");
				int delId  = Integer.parseInt(sc.nextLine());
				manager.delStudent(delId);
				System.out.println("삭제 되었습니다");

				


		}else if(menu==5) {  //학생 정보 수정
			
			System.out.println("수정할 학생의 학년");
			int grade = Integer.parseInt(sc.nextLine());
			System.out.println("수정할 학생의 학번");
			int id = Integer.parseInt(sc.nextLine());
			System.out.print("국어:");
			int kor  =Integer.parseInt(sc.nextLine());
			System.out.print("영어 :");
			int eng  =Integer.parseInt(sc.nextLine());
			System.out.print("수학 :");
			int math  =Integer.parseInt(sc.nextLine());
			
			Student std = new Student(grade, id, null, math, kor, eng);
			manager.correcStudent(std);
		}else if(menu==6){
			System.out.println("시스템 종료하였습니다");
			System.exit(0);
		}
	}

}

}

