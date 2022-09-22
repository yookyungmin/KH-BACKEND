import java.util.Scanner;

public class Exam_031 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열 길이를 지정하세요");
		int i = Integer.parseInt(sc.nextLine());
		
		int[] arr = new int[i];  //위에 입력한 대로 배열의 길이지정 
		
	
		for(int j =0; j<arr.length; j++) {
			System.out.print((j+1)+" 번째 값");
			arr[j] = Integer.parseInt(sc.nextLine()); //위에 입력한길이대로 값 입력
			}
		
		for(int j = 0; j<arr.length; j++) {
		System.out.println((j+1)+"번쨰 값"+arr[j]); //값 출력
	}
	}	

}
