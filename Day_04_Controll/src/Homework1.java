import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Homework1 {
	public static void main(String[] args) {
		//심리테스트 만들기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("====심리 테스트======");
		System.out.println("샤워 습관으로 알아보는 나의 연애 스타일");
		
		System.out.println("1. 머리부터 감는다.");
		System.out.println("2. 세수부터 한다.");
		System.out.println("3. 몸부터 닦는다.");
		System.out.println("4. 이를 닦는다");
			
		
		System.out.println("당신의 샤워 습관은?=>");
		int input = Integer.parseInt(sc.nextLine());

		if(1<=input&&input<=4) {
			if(input==1) {
			System.out.println("머리부터 감는 당신!");
			System.out.println("당신은 주변 사람들이 하자는대로 이끌려 다니는 스타일.");
			System.out.println("이런 성격은 이성을 만날때도 마찬가지이며, 이성에게 휘둘리는 편, 감정표현 잘하는것이 중요.");
			
			}else if(input==2) {
				System.out.println("세수부터 하는 당신!");
				System.out.println("당신은 순수한 마음을 갖고 있으며, 이성에게 헌신적이고 순종적");
				System.out.println("배려를 잘하고 받는 것보다 베푸는것이 먼저 당신, 상처 받지 않는 것이 필요함");
			}else if(input==3) {
				System.out.println("몸부터 닦는 당신!!");
				System.out.println("겉모습을 굉장히 중요하게 여기는 사람이며, 이성을 볼때도 패션감각, 얼굴등을 중요시 함");
			}
			else if(input==4){
				System.out.println("이부터 닦는 당신!!");
				System.out.println("지적 호기심이 높으며 매사에 신중한 스타일");
				System.out.println("시작이 어려울수 있구나, 상대방에 대해 많은것을 발견하고 싶어하는 경향이 있음.");
			}
		}else {
			System.out.println("번호를 다시 입력하세요");
			
		}
	
	}
}
