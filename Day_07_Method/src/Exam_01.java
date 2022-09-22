import java.util.Scanner;
import java.util.concurrent.ForkJoinTask;

import javax.naming.spi.DirStateFactory.Result;

public class Exam_01 {
	//반환타입 메서드명(선언부) { 구현부}
	//메서드 콜에 의해 전달되어지는 값을 받아 저장하는 변수 : 매개변수
	public static int plus(int num1, int num2) {  //plus의 영역
		//				int result = num1+ num2;
		//				return 	result;
		return num1+num2;
	}
	//2개의 정수를 인자값으로 받아 뺼셈한 결과를 반환하는 minus 메서드를 작성해보세요
	public static int minus(int num1, int num2) {
		return num1-num2;
	}
	//2개의 정수 인자값을 받아 곱셈
	long multiply(long num1, long num2) {
		return num1*num2;
	}
	/// 나누기메서드
	double divide(double num1, double num2) {
		return num1/(double)num2;
	}
	// 대소 비교 메서드
	int bigger(int num1, int num2) {

		if(num1>num2) {
			return num1;
		}else if(num1<num2) {
			return num2;
		}else {
			return 0;
		}

	}
	//"사과"라고 전달하면 "Apple"를 반환하고 "포도"라고 전달하면 "Grape"를 바놘하는 메서드
	//다른 단어전달되면 none


	public static String translate(String word) {
		if(word.equals("사과")) {
			return "Apple";
		}else if(word.equals("포도")) {
			return "Grape";
		}else {
			return "none";
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Exam_01 ex = new Exam_01();
		//				ex.plus(10, 5);

		System.out.println(Exam_01.plus(5, 6));//static이라 객체생성없이가능
		int a = plus(5, 9);
		System.out.println(a);
		//Method를 Call하며 전달하는 값을 인자값(argument) 

		int b = ex.bigger(5, 9);
		System.out.println(b);
		System.out.println(translate("사과"));

		String s = Exam_01.translate("포도");
		System.out.println(s);
		System.out.println(Exam_01.translate("사과"));

		int result = plus(50, 9)+15;

		System.out.println(result);
		String name = sc.nextLine()+plus(10, 2);


		int c = Integer.parseInt(sc.nextLine())+plus(20, 9);
		System.out.println(c);




	}



}
