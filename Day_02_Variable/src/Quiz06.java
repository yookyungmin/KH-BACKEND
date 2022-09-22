import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {
	
			Scanner sc = new Scanner(System.in);
		System.out.println("1~100사이 값을 입력하세요");
		int input = sc.nextInt();
	
		
		if(input%2==0) {
			System.out.println("입력한 값은 짝수 입니다");
			
		}else if(input%2==1) {
			System.out.println("입력한 값을 홀수 입니다.");
		}
	}

}
