import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Calcu4 {

	public static void main(String[] args) {
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
		
		
		while(true) {
		System.out.println("========계산기 프로그램=======");
		System.out.println("연산자 입력 (+,-,*,/,Q)=>");
		String input = sc.nextLine();
		
		if(input.equals("Q")) {
			System.out.println("계산기를 종료 합니다");
			System.exit(0);
		}else if(input.equals(pl)||input.equals(mul)||input.equals(mi)||input.equals(div)||input.equals(q)) {
			//else if{ 안에 로직을짬
		
//		else if(!input.equals(pl)&&!input.equals(mi)&&!input.equals(mul)&&!input.equals(div)&&!input.equals(q)) {
//			System.out.println("연산자 잘못 입력하셨습니다");  //잘못 입력 했다면
//			continue;  //반복문 흐름을 처음으로 올린다.
//		}
		System.out.print("첫번쨰 숫자 입력=>");
		double num1 = Double.parseDouble(sc.nextLine());
		System.out.print("두번쨰 숫자 입력=>");
		double num2 = Double.parseDouble(sc.nextLine());
		
		
		if(input.equals(pl)) {
			System.out.println("=============결과 ==========");
			System.out.println(num1+" + "+num2 +" = "+(num1+num2));
		
		}else if(input.equals(mi)) {
			System.out.println("=============결과===========");
			System.out.println(num1+" - " +num2 + " = "+(num1-num2));
		}else if(input.equals(mul)) {
			System.out.println("=============결과===========");
			System.out.println(num1+" * "+num2+" = "+(num1*num2));
		}else if(input.equals(div)) {
			System.out.println("=============결과===========");
			System.out.println(num1+" / "+ num2+ " = "+(double)(num1/num2));
		}
			
		}
		else {  
			System.out.println("연산자를 잘못 입력하셨습니다");
			continue;
		}
		}
	
		
		
		}
	}

//import java.util.Scanner;
//
//public class Calcu4 {
//   public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//
//      while(true) {
//         System.out.println("=== 계산기 프로그램 ===");
//
//         System.out.print("연산자 입력 (+,-,*,/,q[종료]) : ");
//         String oper = sc.nextLine();
//         
//         if(oper.equals("q")) { // q를 눌렀을 경우
//            System.out.println("계산기를 종료합니다.");
//            System.exit(0);
//         }else if(oper.equals("+") || oper.equals("-") || 
//                oper.equals("*") || oper.equals("/")) {
//            
//            System.out.print("첫 번째 수 : ");
//            int num1 = Integer.parseInt(sc.nextLine());
//
//            System.out.print("두 번째 수 : ");
//            int num2 = Integer.parseInt(sc.nextLine());
//
//            System.out.println("=== 결 과 ===");
//
//            if(oper.equals("+")) {
//               System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
//            }else if(oper.equals("-")) {
//               System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
//            }else if(oper.equals("*")) {
//               System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
//            }else if(oper.equals("/")) {
//               System.out.println(num1 + " / " + num2 + " = " + ((double)num1/num2));
//            }
//         }else {
//            System.out.println("연산자를 다시 확인해주세요.");
//         }
//         
//         
//         
////         else if(!oper.equals("+") && !oper.equals("-") &&
////                !oper.equals("*") && !oper.equals("/")) { // 연산자가 아닌 다른 무언가를 입력했을 경우
////            System.out.println("연산자를 다시 확인해주세요.");
////            continue;
////         }
//
//         
//      }
//   }
//}