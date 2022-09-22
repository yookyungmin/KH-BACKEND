import java.util.Scanner;



public class QuIz01 {

	public static void main(String[] args) {
		//이름 영어 국어 배열 각각만들어서
		Scanner sc = new Scanner(System.in);
	
		System.out.println("학생 수를 정하세요");
		int i = Integer.parseInt(sc.nextLine());
		
		String[] student = new String[i]; //학생길이
		int[] kor = new int[i];
		int[] eng = new int[i];
		

		for(int j = 0; j<student.length; j++) {

			System.out.print((j+1)+"번째 학생 이름 = >");
			student[j] = sc.nextLine();
			System.out.print(student[j]+" 학생 국어:");
			kor[j] = Integer.parseInt(sc.nextLine());
			System.out.print(student[j]+" 학생 영어:");
			eng[j] = Integer.parseInt(sc.nextLine());
		}
		System.out.println("이름\t국어\t영어\t합계\t평균");
		for(int j =0; j<student.length; j++ ) {
			int total = kor[j]+eng[j];  //합계
			double avg = total/2.0;//평균
			System.out.println(student[j]+"\t"+kor[j]+"\t"+eng[j]+"\t"+total+"\t"+avg);
		}
	}

}
