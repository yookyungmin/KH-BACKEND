import java.util.Scanner;import java.util.concurrent.ScheduledExecutorService;

public class Exam_03 {
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			String str = sc.nextLine();
			int num = Integer.parseInt(str);  //괄호안에 들어가는 값을 Int형으로 변경
			
			int a = Integer.parseInt(sc.nextLine());
			System.out.println(num+10);
		}
}
