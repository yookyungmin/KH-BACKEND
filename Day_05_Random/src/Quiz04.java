import java.util.Scanner;

public class Quiz04 {
	
	public static int MyRand(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}
	public static void func() {
		System.out.println("Hello");
		//void 반환타입은 리턴이 필요없다
	}
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		
		while(true) {
		System.out.println("====가위 바위 보 게임=====");
		System.out.print("숫자를 선택하세요(1. 가위/2.바위/3.보/4.종료)==>");
		int com = MyRand(1,3); // 1~3 가위 바위 보
		int user = Integer.parseInt(sc.nextLine());  //플레이어
		
		
		System.out.println("==========결과==========");
		
		switch (user) {
		case 1:
			System.out.println("플레이어는 가위를 냈습니다");
			break;
			
		case 2:
			System.out.println("플레이어는 바위를 냈습니다");
			break;

		case 3:
			System.out.println("플레이어는 보를 냈습니다");
			break;
		
		}
		switch (com) {
		case 1:
			System.out.println("컴퓨터는 가위를 냈습니다");
			break;
		case 2:
			System.out.println("컴퓨터는 바위를 냈습니다");
			break;
	
		case 3:
			System.out.println("컴퓨터는 보를 냈습니다");
			break;
	
		}
		
		System.out.println("==============");

		if(user==com) //비김
		{
			System.out.println("비겼습니다");
		} else if((user==1&&com==3)||
				(user==2&&com==1)||
				(user==3&&com==2)) { //플레이어가 승리한경우
			System.out.println("플레이어가 승리했습니다");
		}else {//플레이어가 패배한 경우
			System.out.println("플레이어가 졌습니다");
			
			}
	}
	}

	
}
