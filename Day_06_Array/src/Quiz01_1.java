import java.util.Scanner;

public class Quiz01_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[3];
		int[] kors = new int[3];
		int[] engs = new int[3];
				
		
	
		for(int i = 0; i<names.length; i++) {
			System.out.print((i+1)+"번째 학생 이름 = >");
			names[i] = sc.nextLine();
			System.out.print(names[i]+" 학생 국어:");
			kors[i] = Integer.parseInt(sc.nextLine());
			System.out.print(names[i]+" 학생 영어:");
			engs[i] = Integer.parseInt(sc.nextLine());
		}  //이름 국어 영어 점수 넣기
		
		System.out.println("이름\t국어\t영어\t합계\t평균");
		
		for(int i =0; i<names.length; i++) {
			int sum = kors[i]+engs[i];
			double avg = sum/2.0;
			
			System.out.println(names[i]+"\t"+kors[i]+"\t"+engs[i]+"\t"+sum+"\t"+avg);
		}
		
	
	
	}
}
