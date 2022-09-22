import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Calcu2 {

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
		
		if(input.equals(q)) {
			System.out.println("프로그램 종료");
			System.exit(0);
			
		}
		else if(!input.equals(pl)&&!input.equals(mi)&&!input.equals(mul)&&!input.equals(div)&&!input.equals(q)) {
			System.out.println("연산자 잘못 입력 했습니다");  
			continue;  
		}
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
			System.out.println(num1+" / "+ num2+ " = "+(num1/num2));
		}
		
		}
		
	
		
		
		}
	}

