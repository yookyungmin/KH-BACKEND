import java.util.Scanner;

public class ExceptionHandler {

	public static void main(String[] args) {

		int num= 0;
		
		Scanner sc = new Scanner(System.in);
		while(true) {  //while문으니 try밖으로 쓰기
			System.out.println("숫자 입력:");
			try {  //에러가 발생할것 같은곳을 둘러싼다
				num = Integer.parseInt(sc.nextLine());
				System.out.println("정상입력 되었습니다");
				break;
			}catch (Exception e) {
				System.out.println("숫자를 입력해야 합니다");
			
			}
		}
		System.out.println("사용자가 입력한 수는 :"+num);    //unreachable code 14번에 break; 넣어주기   //7번의 num
	}

}

//ctril +i 전체 자동들여쓰기
