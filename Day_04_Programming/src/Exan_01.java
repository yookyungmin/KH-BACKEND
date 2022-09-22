import java.util.Scanner;

public class Exan_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Apple을 입력하세요");
		String msg = sc.nextLine();  //참조자료형은 변수안에 주소가 들어있다
		String s = "Apple";
		if(msg.equals(s)) {  //== 쓰면 주소를 가지고 비교를 하기떄문에 x
			System.out.println("정답입니다");
		}else {
			System.out.println("Apple을 써주세요");
		}
	}

}
