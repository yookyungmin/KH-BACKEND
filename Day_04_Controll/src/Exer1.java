import java.util.Scanner;

public class Exer1 {

	public static void main(String[] args) {
			int score =0;
			
			char grade = ' ', opt = '0';
			
			System.out.print("점수를 입력해주세요");
			
			Scanner sc = new Scanner(System.in);
			
			score = Integer.parseInt(sc.nextLine());
			
			System.out.printf("당신의 점수는 %d입니다\n", score);
			
			if(score>=90) { //90점 이상이면 A학점
				grade = 'A';
				if(score>=98) {//98점 이상A학점에서도 98점이상이면  + A+
					opt = '+';
				}else if(score <94) {//90점 이상 94점 미만은 -
					opt = '-';
				}
			}else if(score >=80) { //80점 이상이면서
				grade = 'B';
				if(score>=88) { //80점이상이면서 88학점이상은 +
					opt = '+';
				} else if(score<84) {
					opt = '-';
				}
			}else { //나머지 학점은 C
				grade = 'C';
			}
			System.out.printf("당신의 학점은 %c%c입니다\n", grade, opt);
	}
	

}
