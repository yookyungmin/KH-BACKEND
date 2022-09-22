import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("이름을 입력하세요");
//		String name = sc.nextLine();
//		System.out.print("국어 점수를 입력하세요=>");
//		Double kor = Double.parseDouble(sc.nextLine());
//		System.out.print("영어 점수를 입력하세요=>");
//		Double eng = Double.parseDouble(sc.nextLine());
//		System.out.print("수학 점수를 입력하세요=>");
//		Double math = Double.parseDouble(sc.nextLine());
//
//		Double total = kor+eng+math; // 합계
//		double avg = total/3.00; //평균
//		
//		System.out.println("===============");
//		System.out.println("이름=>"+name);
//		System.out.println("===============");
//		System.out.println("국어 점수="+kor+" 점 입니다");
//		System.out.println("영어 점수="+eng+" 점 입니다");
//		System.out.println("수학 점수="+math+" 점 입니다");
//		
//		System.out.println("=============");
//		System.out.println("합계=>" +total+" 점 입니다");
//		System.out.println("평균 =>"+(Math.round(avg*100)/100.0) +" 점 입니다");
//		System.out.println("=================");
//		
		
		
		System.out.println("========================");
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("========================");
		System.out.print("국어 : ");
		//Double kor = Double.parseDouble(sc.nextLine());
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 : ");
		//Double eng = Double.parseDouble(sc.nextLine());
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 : ");
		//Double math = Double.parseDouble(sc.nextLine());
		int math = Integer.parseInt(sc.nextLine());
		float avg = (float)(kor+eng+math)/3;
		
		System.out.println("========================");
		System.out.println("합계= ");
		System.out.println("합계 = "+(kor+eng+math));
		System.out.println("평균 = "+avg);
		System.out.println("평균 = "+String.format("%.2f", avg)); //소수점 뒷자리 뒤까지 반올림
		System.out.println("평균 =>"+(Math.round(avg*100)/100.00) +" 점 입니다");
		
		System.out.println("========================");
		
	}

}
