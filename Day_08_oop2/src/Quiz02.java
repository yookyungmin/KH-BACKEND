import java.util.Scanner;



public class Quiz02 {



	public static void main(String[] args) {



		Scanner sc = new Scanner(System.in);



		Student[] stds = new Student[10];

		int count = 0;









		while(true){

			System.out.println("<<학생 관리 프로그램>>");

			System.out.println("1. 신규 정보 입력");

			System.out.println("2. 학생 목록 출력");

			System.out.println("3. 프로그램 종료");

			System.out.print("선택");



			int menu = Integer.parseInt(sc.nextLine());



			if(menu == 1) {



				System.out.print("학생의 이름을 입력하세요 : ");

				String name = sc.nextLine();

				System.out.print("국어 점수를 입력하세요 : ");

				int kor = Integer.parseInt(sc.nextLine());

				System.out.print("영어 점수를 입력하세요 : ");

				int eng = Integer.parseInt(sc.nextLine());

				System.out.println("입력에 성공했습니다.");



				stds[count] = new Student(name,kor,eng);

				count++;



			}else if(menu == 2) {

				if(count == 0) {

					System.out.println("출력할 내용이 없습니다.");

				}else {

					System.out.println("이름\t국어\t영어\t합계\t평균");

					for(int i=0;i<count;i++) {

						System.out.print(stds[i].getName()+"\t");

						System.out.print(stds[i].getKor()+"\t");

						System.out.print(stds[i].getEng()+"\t");

						System.out.print(stds[i].getTotal()+"\t");

						System.out.println(stds[i].getAvg());

					}

				}

			}else if(menu == 3) {

				System.out.println("프로그램 종료");

				System.exit(0);

			}else {

				System.out.println("번호를 다시 확인해주세요");

			}

		}

	}



}