
public class Quiz04 {

	public static void main(String[] args) {
	
		//1~100 까지 5의 배수일때 짝, 나머지 숫자 출력
//		int i = 1;
//		
//		while(i<=100) {
//			
//			if(i%5==0) {
//			System.out.println("=짝!");  //5의 배수일땐
//			}else {
//				System.out.println(i);
//			}
//			i++;
//		}
		
		
		
//		for(int i = 1; i<=100; i++) {
//			if(i%5==0) {
//				System.out.println("짝!!");
//			}else {
//				System.out.println(i);
//			}  
//		}  ///for문 기준
		
		
		for(int i =1; i<=100; i++) {
			if(i%5==0) {
				System.out.println("짝");
			}
			else {
				System.out.println(i);
			}
		}

	}

}
