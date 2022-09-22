import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Calcu5 {
	
//	private static int valid(Scanner sc, int num1) {
//		while(true) {
//			try {
//			System.out.print("숫자 입력=>");
//			
//				num1= Integer.parseInt(sc.nextLine());  
//				break; //써야함
//			}catch (Exception e) {
//				System.out.println("숫자만을 입력하세요");
//			}
//
//		}
//		return num1;
//	}
	
	public static int validNum(String msg) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		try {
			System.out.println(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
		}catch (Exception e) {
			System.out.println("숫자를 입력하세요");
		}
	}
	}  //매개변수가 있꼬 출력문을 메서드안에 넣기
	
	public static int validnum() {
		Scanner sc = new Scanner(System.in);
		while(true) {
		try {
			
		int num = Integer.parseInt(sc.nextLine());
		return num;
		}catch (Exception e) {
			System.out.println("숫자를 입력하세요");
		}
	}
	}  //매개변수가 없는 경우 출력문을 메인에서 출력하게끔
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//계산기프로그램
		//연산자 입력(+,-,*,/,q) : +  //다른 버튼 입력시 연산자가 잘못 되었씁니다
		//첫번쨰 숫자입력 : 100
		//두번쨰 숫자 입력 :15
		//====결과====
		//100+15 = 115


		Scanner sc = new Scanner(System.in);

		String pl = "+";
		String mi = "-";
		String mul = "*";
		String div = "/";
		String q = "Q";

		int num1 =0;  //첫번쨰 숫자
		int num2 = 0; // 두번쪠 숫자  //try-catch떄문에 바깥에다 생성


		while(true){
			System.out.println("연산자를 입력(+,-,*,/,Q) ==>");
			String input = sc.nextLine();

			if(input.equals(q)) {
				System.out.println("사용을 종료하겠습니다");
				System.exit(0);
			}
			else if(input.equals(pl)||input.endsWith(mi)||input.equals(mul)||input.equals(div)||input.equals(q)){
//
////				System.out.println("첫번째 수");
//				num1 = validNum();  //매개변수가 없는 경우
				
				
				num1 = validNum("첫번째 수");
				num2 =  validNum("두번째 수");  //인자값대로 출력
//				System.out.println("두번째 수");
//				num2 = validNum();
				
//				while(true) {
//
//					System.out.print("두번쨰 숫자를 입력 =>");
//					try { 
//						num2= Integer.parseInt(sc.nextLine());
//						break; //while문을 벗어나서 코드 진행
//					}catch (Exception e) {
//						System.out.println("숫자만을 입력하세요");
//					
//					}
//				}
				
				if(input.equals(pl)) {
					System.out.println("========결과========");
					System.out.println(num1+"+"+num2+"="+(num1+num2));
				}else if(input.equals(mi)) {
					System.out.println("==========결과========");
					System.out.println(num1+"-"+num2+"="+(num1-num2));
				}else if(input.equals(mul)) {
					System.out.println("========결과========");
					System.out.println(num1+"*"+num2+"="+(num1*num2));
				}else if(input.equals(div)) {
					try {
					System.out.println("=============결과===========");
					System.out.println(num1+" / "+ num2+ " = "+(double)(num1/num2));
					}catch (ArithmeticException e) {
						System.out.println("0으로 나눌수 없습니다");
						continue;
					}
					}


			}
			else {
				System.out.println("메뉴를 제대로 입력하세요");
			}
		}
	}


}
