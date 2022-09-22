import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번쨰 숫자 입력");
		int a= sc.nextInt();
		System.out.println("두번쨰 숫자 입력");
		int b = sc.nextInt();
		
		System.out.println("결과 =======");
		
		if(a>b) {
			System.out.println("첫번쨰 입력한 값이 더 크다");
		}else {
			System.out.println("두번쨰 입력한 값이 더 크다");
		}

	}

}
