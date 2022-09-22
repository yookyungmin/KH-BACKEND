import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class Quiz05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//up & down 게임
		
		Scanner sc = new Scanner(System.in);
		
		
		int userm; //메뉴 진입
		int count=0;; //횟수
		int com; //com
		int user;// 사용자
		
		
		while(true){
			
		System.out.println("=====game start=======");
		System.out.println("1.Game start");
		System.out.println("2. Game store");
		System.out.println("3. End game");
		
		
		userm = Integer.parseInt(sc.nextLine());//메뉴 선택

		switch (userm) {
	
		case 1:
			com =(int)((Math.random()*100)+1); //while문 밖에서 돌아야 함 안에서 돌면 계속 바뀜

			while(true) {
			
				System.out.println("<<<input number>>>");
				user=Integer.parseInt(sc.nextLine()); //플레이어 숫자
				if(user>com) {
					System.out.println("<<Down>>");
					count++;
				}else if(user<com) {
					System.out.println("<<UP>>");
					count ++;
				}else {
					System.out.println("정답입니다");
					break;
				}
			
			}
			break;
		case 2:
			 System.out.println("현재 최고 점수는"+count+"점 입니다");
			 break;
		case 3:
			System.out.println("시스템을 종료 하겠습니다");
			System.exit(0);
		}
			

		
		
		}
		}
	}

