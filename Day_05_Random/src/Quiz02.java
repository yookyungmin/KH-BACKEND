import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

		//동전 앞뒤 맞추기
		//숫자를 입력하세요 (1. 앞면/ 2. 뒷면) : 1
		//맞췄습니다
		
		//----->restart
		//숫자를 입력해주세요(1.앞면 /2. 뒷면 :1 
		//땡 틀렸습니다
		
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			System.out.println("숫자를 입력하세요 1. 앞면 / 2 뒷면 /3. 종료");
			int input = Integer.parseInt(sc.nextLine());
			int coin = (int)((Math.random()*2)+1);
			
			if(input==1||input==2) {
				if(input==coin) {
					System.out.println("맞췄습니다");
				
				}else if(!(input==coin)) {
					System.out.println("틀렸습니다");
				}
			}else if(input == 3) {
				System.out.println("게임 종료를 하였습니다");
				break;
			}
			
			else {
				System.out.println("수를 다시 입력하세요");
			}
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
//		while(true) {
//		System.out.println("=======동전 앞뒤 맞추기 =========");
//		System.out.print("숫자를 입력하세요 (1.앞면 /2. 뒷면 /3. 종료) =>");
//		int coin = (int)((Math.random()*2)+1); //난수 동전 앞뒤
//		
//		int input = Integer.parseInt(sc.nextLine()); //플레이어 찍기 결정
//		if(input==1||input==2) {
//			if(input==coin) {
//				System.out.println("맞췄습니다");
//			}else if(!(input==coin)){
//				System.out.println("땡! 틀렸습니다");
//			}
//		}else if(input ==3 ) {
//				System.out.println("게임을 종료 했습니다");
//				break;
//		}
//			else {
//			System.out.println("제대로 입력해주세요");
//		}
//		
//		
//		}
	}

}
