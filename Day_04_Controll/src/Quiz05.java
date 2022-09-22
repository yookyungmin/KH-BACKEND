import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
	
		
	//메시지를 몇번 출력하시겠씁니까? 7 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메시지를 몇번 출력 하시겠습니까?");

		int input = Integer.parseInt(sc.nextLine());  //입력받고
		
		
//		int i = 1;
//		while(i<=input) {  //입력받은 수동안 반복
//			System.out.println("Hello world");
//			i++;
//		}
		
		for(int i = 1; i<=input; i++) {
			System.out.println("hello world");
		}
	
		
	}

}
