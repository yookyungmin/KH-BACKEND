import java.util.Scanner;



public class Upgame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int com; //컴퓨터 난수
		int userm; //메뉴 선택
		int user; // 플레이어
		int count =0;//틀린횟수
		
		
		
		
		while(true) {
			
			System.out.println("========Game start ==============");
			System.out.println("1.Game start");
			System.out.println("2.Game store");
			System.out.println("3.end game");
			
			
			userm=Integer.parseInt(sc.nextLine());//메뉴 들어가기
		
			switch (userm) {
			case 1:
				com=(int)((Math.random()*100)+1); //1~100난수
			
			while(true) {
				System.out.println("<<<<<input number>>>");
				user= Integer.parseInt(sc.nextLine());//플레이어 숫자
				if(user>com) {
					System.out.println(">>>>Down<<<<<");
					count ++; //틀린 횟수 증가
				}else if(user<com) {
					System.out.println(">>>UP<<<<");
					count++;
				}else {
					System.out.println(">>>정답<<<");
					break;
				}
			}
				break;
			
			case 2:
				System.out.println("현재 최고 점수는 "+count+"입니다");
				break;
			case 3:
				System.out.println("게임을 종료 하였습니다");
				System.exit(0);
			}
			
		}

	}

}