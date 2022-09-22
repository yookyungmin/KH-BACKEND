import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번쨰 숫자 입력");
		int num1= Integer.parseInt(sc.nextLine());
		System.out.println("두번쨰 숫자 입력");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("=====결과 ==============");
		
		if(num1>num2) {//첫번쨰 수가 더 큰 경우
			System.out.println("첫번쨰 입력한 "+num1+" 값이 더 크다");
		}else if(num1==num2) { //첫번쨰 두번째 같은 경우
			System.out.println("입력한 두 값이 같다");
		}
		else {// 두번쨰가 더큰 경우
			System.out.println("두번쨰 입력한 값 "+num2+"이 더 크다");
		}

	}

}
