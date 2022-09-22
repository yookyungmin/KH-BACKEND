import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			
			System.out.println("1~100 사이 입력을 하시오");
			int input = Integer.parseInt(sc.nextLine());
			
			if(1<=input&&input<=100) {  // 1~100 범위 안에서
				if(input%2==0){ //
					System.out.println("입력한 값은 짝수입니다");
					
				}else if(input%2==1) {
					System.out.println("입력한 값은 홀수입니다");
				}
			
			}else {
				System.out.println("범위를 벗어났습니다");
			}
			

	}

}
