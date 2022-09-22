
public class Quiz04 {

	public static void main(String[] args) {
		//3-1 1325 와 9327 메모리 저장하고 두수를 곱한결과를 출력

		int num1 = 1325;
		int num2= 9327;
		
		
		
		System.out.println(num1*num2);
		System.out.println("저장하고 두수를 곱한 값= "+num1*num2);
		//3-2 100억과 5000을 더하여 메모리에 저장하고 출력
		
//		long c = 10000000000L;
//		long d = c+ 5000;
		long result  = 10000000000L+5000;
		System.out.println("2번 문제답"+result);
		//3-3  'A'와  'B'를 메모리에 저장하고 화면에 출력
		char ch1 = 'A';
		
		char ch2 ='B';
		System.out.println("'A'의 값=="+(int)ch1+"\n'B'의 값="+(int)ch2);
		System.out.println("3번문제답="+ch1+ch2);
		System.out.println(ch1+ch2);
	}

}
