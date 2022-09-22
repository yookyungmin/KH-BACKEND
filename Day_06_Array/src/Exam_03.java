import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		int[] arr = new int[4];
		
		for(int i =0; i<arr.length; i++) {
			System.out.print((i+1)+" 번째 값");
			arr[i]= Integer.parseInt(sc.nextLine()); //스캐너문 값넣기
		
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.println((i+1)+"번째 값: "+arr[i]);
		}

	}

}
