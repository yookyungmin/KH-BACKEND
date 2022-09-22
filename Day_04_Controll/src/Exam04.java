
public class Exam04 {

	public static void main(String[] args) {

		//break자신이 속한 반복문 {} 만 나감
		
		//이름붙은 반복문  break 레이블 브레이크
		int j = 0;
		
		
		abc : while(j<5) {
		for(int i = 1; i<=10; i++) {
			if(i==5) {
				break abc;
			}
			System.out.println(i);
		
		}
			j++;
			
		}
	}

}
