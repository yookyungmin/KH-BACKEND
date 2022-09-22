
public class Exam_02 {

	public static void main(String[] args) {
		
			short a = 0;
			byte b= 10;
			
			a=b;
			
			System.out.println(10/3);
			System.out.println(10/3.0);
			System.out.println((double)10/3);
			
			int sum = 98;
			
			System.out.println("당신의 총점은 = "+sum +"점");
			//프로모션 활용 사례
			
			byte c = 0;
			short s = 100;  //
			
			c=(byte)s; //명시적 형변환, 강제 형변환  ~128 ~127 범위에서만 문제없이 출력됨
			System.out.println(c);
			
			
			

	}

}
