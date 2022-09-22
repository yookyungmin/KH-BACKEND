
public class Exam_02 {

	public static void main(String[] args) {
		
		char[] carr = {'A', 'F', 'Z'};
		
		char[] carr2 = new char[] {'a', 'b', 'c'};
		//String 형 배열 2칸짜리 만들고 "Hello" "Array"담아보세요
		String[] s = {"Hello", "Array"};

		String[] s1 = new String[] {"happy", "java"};
		
		//int 형 배열 arr3 을 100칸짜리 만들고 100~1 역순으로 담아보세요
		int[] arr3 = new int[100];
		
		for(int i =0; i<arr3.length; i++) {
			arr3[i]= 100-i; //값넣기
			}
			System.out.println(arr3[99]); // 1
			System.out.println(arr3[0]);  //100
	
			//char 형 배열 arr4를 26칸 만들고 A-Z 또는 Z-A까지 담아보세요
		char[] arr4 = new char[26];
		for(int i = 0; i<arr4.length; i++) {
			arr4[i] = (char)('A'+i);  //값넣기
		
		}
		System.out.println(arr4[0]);
		System.out.println(arr4[25]);
	}
		
	}


