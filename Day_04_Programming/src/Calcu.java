import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Calcu {

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
		
		if(input.equals(q)) {   //코드 순서가 여기가 맞음
			System.out.println("프로그램 종료");
			break;
			
		}if(input.equals(pl)) {
		}else if(input.equals(mi)) {
	
		}else if(input.equals(mul)) {
			
		}else if (input.equals(div)) {
		
		}
		else {
			System.out.println("연산자 잘못 입력하셨습니다");
			continue;
		}
		System.out.print("첫번쨰 숫자 입력=>");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번쨰 숫자 입력=>");
		int num2 = Integer.parseInt(sc.nextLine());
		
		
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
		
	
		
		
		}
	}

