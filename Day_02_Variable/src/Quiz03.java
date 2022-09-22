
public class Quiz03 {

	public static void main(String[] args) {
		int i1= 10;
		int i2 = 20;
		float f1 = 3.14f;
		char c1 ='A';
		char c2 = 'B';
		
		System.out.println("결과 : " + i1+i2);
		System.out.println("결과 : "+ (i1+i2));
		System.out.println("결과 : "+ i1+f1);
		System.out.println("결과 : " +(i1+f1));
		System.out.println("결과 : " + f1+c1);
		System.out.println("결과 : "+(f1+c1));
		System.out.println("결과 : " +c1+c2);
		System.out.println("결과 : "+(c1+c2));
		//문자열+ 되면 문자열로 인지 , () 써서 계산해서 출력
		//곱셉은 문자열 있어도 없어도 바로 곱셉 계산
		
		System.out.println("==");
		System.out.println(i1+i2);
		System.out.println("결과="+i1*i2);

		System.out.println("i");
	}

}
