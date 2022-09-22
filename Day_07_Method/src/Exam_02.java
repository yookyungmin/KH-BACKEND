
public class Exam_02 {

	public static void main(String[] args) {

		String str = "Hello world";
		int length = str.length(); //str의 길이
		System.out.println(length);
		
		char a = str.charAt(6); // w출력
		int b = str.charAt(1);  //e의 int값
		System.out.println(str.charAt(3)); //인덱스의 문자열
		System.out.println(a);
		System.out.println(b);

		
		//boolean result = str.startsWith("He");
		System.out.println("He로 시작"+str.startsWith("He")); //인자값 "He" 로 시작하면 true // perfix 가장 앞에 나오는 문장 접두사
		//return값이 boolean이면 메서드 뒤에 의문문으로 생각 starsWith 시작하니?
	
		
		System.out.println("d로 끝?"+str.endsWith("d")); //특정 문자열로 끝나는지 확인 //suffix 접미사
	
		System.out.println("H를 포함하냐?"+str.contains("H"));
		System.out.println("Equals : "+str.equals("Hello"));
		System.out.println(str.concat("자바"));
		
		
		
		int s = str.indexOf("H");
		System.out.println(s);
		System.out.println(str.indexOf("w"));  //몇번쨰 자리에 있는지
		
		
		
		String[] arr = str.split(" ");  //split 문자열을 배열로 잘름
		//System.out.println(arr[0]);
		
		for(String i :arr) {
			System.out.println(i);
		}
	}

}
