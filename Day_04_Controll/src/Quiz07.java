import java.util.Scanner;

public class Quiz07 {
	public static void main(String[] args) {
		//선택적
		//1~n까지의 합구하기 n입력 100 1~100까지의 합은 5050
		System.out.println("===1~n 까지의 합 구하기===");
		System.out.println("수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int num = Integer.parseInt(sc.nextLine());
		for(int i = 1; i<=num; i++) {
			sum+=i;
		}
			System.out.println(sum);
	}
}
