import java.lang.*; //생략가능 //노란줄 경고, 왜필요하죠? 경고

/*
 * 코드
 * {
 * 		BSD방식
 * }
 * 
 * 코드{
 * 
 * 		k&r방식  
 * }
 * 코드
 * 		{
 *  		GNU방식
 * 		}	
 */
public class Exam_01 
{//파일명과 똑같이
	public static void main(String[] args)//초기 실행위치 , 프로그램의 시작점 
	{
		System.out.println("Hello World");
		System.out.println("나는 조성태야");
		System.out.println("150");
		System.out.println(10);
		System.out.println('A'+" 문자");
		System.out.println('김');
		System.out.println("A 문자열");
		System.out.println(3.14);
		System.out.println(150+150);
		System.out.println('A'+10); // 'A' = 65 유니코드로 인코딩
		System.out.println("A"+10);  
		System.out.println("150"+150+"문자열+숫자=문자열");//문자열+숫자 = 문자열
		
		//자바에서 문자열을 표현할때는 ""를 사용한다  ""는 주소 형태로 인식
		//자바에서 문자를 표현할떄는 ''를 사용한다.  ''는 숫자로인식
		//자바에서 숫자를 표현할때는 Quote를 사용하지 않는다.
		
		System.out.println("===========");
		String name = "jAVA"+"  chip";
		String a = "프라푸치노";
		String c = name+a;
		char b = 'A';
		char bb = 'b';
		char cc = 'ㄱ';
		char ccc = '나';
		
		int g = 15;
		
		System.out.println(name+a); //문자열+문자열 = 문자열
		System.out.println(name+b);//문자열 +문자 = 문자열
		System.out.println(c);
		System.out.println(b+g);  //문자+숫자 = 숫자
		System.out.println(b+bb);// 문자+문자 = 숫자 
		System.out.println(a+b); //문자열+문자 = 문자열
		System.out.println(cc+ccc); // 한글도 숫자로 나옴
			
		
		//
		
		
		
	}
}


