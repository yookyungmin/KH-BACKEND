package midlevel;

public class ExampleFor {

	public static void main(String[] args) {
		
			int[] arr = new int[] {5,4,1,3,2};
			
			
			for(int i = 0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
			
			//collection 하나이상의 변수를 묵어서 사용하는 자료형태
			for(int s : arr ) { //향상된for문 컬렉션을 대상으로만 동작하는 for문 ex배열에서 //범위조정불가
				System.out.println(s);
			}
			
			String[] arr1 = new String[] {"Hello", "New", "For"};
			
			for(String str : arr1) {
				System.out.println(str);
			}
			
//			for(int i = 0; i<arr1.length; i++){
//				System.out.println(arr1[i]);
//			}
//			System.out.println(arr[0]);
//			System.out.println(arr[1]);
//			System.out.println(arr[2]);
//			

	}

}
