import java.io.InterruptedIOException;

public class Exam05 {
		public static void main(String[] args) {
				//5만뺴고 다나옴
				//1~10 중
//			for(int i = 1; i<=10; i++) {
//					if(i==5) {
//						continue;  //생략하고 다음반복뮨
//					} 
//				System.out.println(i);
//			}
			
			for(int i =1; i<=10; i++) {
				if(i==5) {
					continue;
				}
				System.out.println(i);
			}
		}
}
