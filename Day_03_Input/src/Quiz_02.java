import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두 정수를 입력 받아 덧셈한 결과를 출력하는 프로그램을 작성하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력하세요=>");
		int num1 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());
		//Long num2 = Long.parsLong(sc.nextLine());
		
		//Double num3 = Double.parseDouble(sc.nextLine());
		int total = num1 + num2;
		System.out.println("두 정수의 합="+total);
		
		
		
	}

}
