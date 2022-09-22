
public class Exam_01 {

	public static void main(String[] args) throws Exception{// 나도 모른다 예외 전가
		//unhandled exception 코드에 문제가 있을 수 있다, 예외전가, 처리 필요
		System.out.print("한글자를 입력하세요>");
		int input = System.in.read(); 
		System.out.println("입력하신 문자는"+ input + "입니다");
		
		
		System.out.print("한글자를 입력하세요>");
		int input2 = System.in.read(); 
		System.out.println("입력하신 문자는"+ input2 + "입니다"); // /r
		
		System.out.print("한글자를 입력하세요>");
		int input3 = System.in.read(); 
		System.out.println("입력하신 문자는"+ input3 + "입니다"); // /n
		
		System.out.print("한글자를 입력하세요>");  //buffer 에 데이터가 없어서 새로 입력 가능
		int input4 = System.in.read(); 
		System.out.println("입력하신 문자는"+ input4 + "입니다");
		
			System.out.println("입력하신 문자의 아스키코드 10진수는"+input);
	}

}
