import java.util.Scanner;



public class Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


		//<<학생 관리 프로그램>>
		//1. 신규 정보 입력
		//2. 학생목록 출력
		//3. 프로그램 종료

		//1번 선택시
		//학생의 이름, 국어, 영어 점수를 입력 받아 Student 인스턴스로 생성 후
		//Student형 배열에 저장
		//2. 배열에 저장되어 있는 모든 학생 정보를 이름/국어/영어/합계/평균 순으로 모두 출력
		//배열에 한명의 정보도 저장 되어 있지 않을시 "출력할 내용이 없습니다"라고안내.


	//	int cs; //입력할 학생의 수
//		System.out.println("입력하실 학생의 수를 입력하세요");
//		cs = Integer.parseInt(sc.nextLine());
//		Student[] st = new Student[cs];
		Scanner sc = new Scanner(System.in);
		Student[] st = new Student[10];
//		for (int i = 0; i<st.length; i++) {
//
//			st[i] = new Student();
//		}
		int count=0;  //등록후 증가할 인덱스 
		
		while(true) {

			System.out.println("<<학생 관리 프로그램>>");
			System.out.println("1. 신규정보 입력");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 프로그램 종료");
			System.out.println("선택 ==>");
			int menu = Integer.parseInt(sc.nextLine());

			if(menu==1) {
	
//				for(int j = 0; j<st.length; j++) {
//				
//					System.out.print("학생 이름을 입력하세요=>");
//					String name = sc.nextLine();
//					System.out.print(name+"의 국어 점수를 입력하세요==>");
//					int kor = Integer.parseInt(sc.nextLine());
//					System.out.print(name+"의 영어 점수를 입력하세요==>");
//					int eng = Integer.parseInt(sc.nextLine());
//					st[j] = new Student(name, kor, eng);
//					System.out.println("등록이 완료 되었습니다");
//				}		
				
					
					System.out.print("학생 이름을 입력하세요=>");
					String name = sc.nextLine();
					System.out.print(name+"의 국어 점수를 입력하세요==>");
					int kor = Integer.parseInt(sc.nextLine());
					System.out.print(name+"의 영어 점수를 입력하세요==>");
					int eng = Integer.parseInt(sc.nextLine());
					//st[count] = new Student(name, kor, eng);
					//count++;
					st[count++] = new Student(name, kor, eng);
					System.out.println("등록이 완료 되었습니다");
//				for(int j =0; j<st.length; j++) {
//					System.out.println("학생 이름");
//					st[j].setName(sc.nextLine());
//					System.out.println("국어 성적");
//					st[j].setKor(Integer.parseInt(sc.nextLine()));
//					System.out.println("영어 성적");
//					st[j].setKor(Integer.parseInt(sc.nextLine()));
//					 System.out.println("등록완료");
//				} //안됨
			
			
			}else if(menu ==2) { //학생 정보 출력
				if(count==0) {
					System.out.println("출력할 정보가 없습니다");
				}else {
					System.out.println("이름\t국어\t영어\t합계\t평균");
					for(int j=0; j<count; j++) {
						System.out.println(st[j].getName()+"\t"+st[j].getKor()+"\t"+st[j].getEng()+"\t"+st[j].getTotal()+"\t"+st[j].getAvg());
					}
				
				}
			}else if (menu ==3) {
				System.out.println("프로그램 종료");
				System.exit(0);

			}else {
				System.out.println("1~3번호를 입력하세요");
			}

		}


	}

}
