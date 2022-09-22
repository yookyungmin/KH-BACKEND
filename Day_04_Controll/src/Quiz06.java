import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
//		System.out.println("=======구구단 출력 프로그램==");
//
//		
//		System.out.print("1~9단 중 선택>");
		//int input =Integer.parseInt(sc.nextLine());
		
//		for(int i = 1; i<=9; i++) {
//			
//			if(1<input&& input<10) {
//				System.out.println(input +"*"+i +"="+input*i);
//			}else {
//				System.out.println("범위를 벗어났습니다");
//				break;
//			}  //조건문 포함
//		}
		
//		int i = 1;
//		while(i<=9) {
//			System.out.println(input +"*"+i +"="+input*i);
//			i++;
//		}
		
		
//		int i = 1;
//		while(i<=9) {
//			System.out.println(input +"*"+i +"="+input*i);
//			i++;
//		}
		
	
		
//			if(1<input&& input<10) { //input 2~ 9 사이
//				int i = 0;
//				while(i<9){
//					i++;
//					System.out.println(input +"*"+i +"="+input*i);
//				}
//			}else {
//				System.out.println("범위를제대로 입력하세요");
//			}  //조건문 포함
		
		
//		while(true) {
//			System.out.println("=======구구단 출력 프로그램==");
//
//			System.out.println("종료를 원하면 0");
//			System.out.print("1~9단 중 선택>");
//		
//			int input =Integer.parseInt(sc.nextLine());
//			if(1<input&& input<10) { //input 2~ 9 사이
//				int i = 0;
//				while(i<9){
//					i++;
//					System.out.println(input +"*"+i +"="+input*i);
//				}
//				
//			}else if(input==0) {
//				break;
//			}
//			else {
//				System.out.println("범위를제대로 입력하세요");
//			}  //조건문 포함
//		}
		
//		abc : while(true){
//			System.out.println("=======구구단 출력 프로그램==");
//
//			System.out.println("종료를 원하면 0");
//			System.out.print("1~9단 중 선택>");
//			int input =Integer.parseInt(sc.nextLine());
//		for(int i = 1; i<=9; i++) {
//			
//			if(1<input&& input<10) {
//				System.out.println(input +"*"+i +"="+input*i);
//			}	else if(input ==0) {
//					break abc;
//				}
//					else {
//						System.out.println("범위를 벗어났습니다");
//				break;
//			}  //조건문 포함
//		}
//	}
		
		 while(true){
			System.out.println("=======구구단 출력 프로그램==");

			System.out.println("종료를 원하면 0");
			System.out.print("1~9단 중 선택>");
			int input =Integer.parseInt(sc.nextLine());
		
			
			if(1<input&& input<10) {
				for(int i = 1; i<=9; i++) {
				System.out.println(input +"*"+i +"="+input*i);
			}
			}else if(input ==0) {
					break;
				}
					else {
						System.out.println("범위를 벗어났습니다");
				break;
			}  //조건문 포함
		}
		
		
	}
}
///++ 0번 누르면 종료는 어떻게?
