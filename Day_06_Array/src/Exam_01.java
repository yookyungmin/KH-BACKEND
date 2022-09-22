import java.io.InterruptedIOException;

public class Exam_01 {
//배열
	public static void main(String[] args) {
		int[] arr; //배열은 참조자료형 참조형은  stack에 주소저장 heap에 값저장 
		//주소를 저장할수 있는 변수
		 //배열의 주소를 저장할 변수를 만듬
		
		//new 키워드는 heap 메모리를 사용하겠다는 문법
		
		int[] arr2 = new int[4]; // 4개의 배열 첨자, 인덱스 [0][1][2][3] , 인덱스의 각 크기는 4byte 
		//  arr2 stack에만들어짐 new int[] heap 메모리에 만들어짐
		//메모리 stack에 주소, 각 인덱스가 heap 메모리에 들어감
		
		//stack에 변수를 만들었는데 아무값을 안만들면 쓰레기값이 들어가는데 heap메모리에는 아무것도 안넣으면 숫자 0이 들어감
		//다차원의 배열은 포렌식, 2d rpg 만들때 쓰임 웹개발에선 잘 안쓰임
		
		// Offset: 기준점으로부터 얼마만큼 떨어졌는가?
		// 
		
		//double[] arr3 = new double[1000000000];  //Java heap space 힙메모리 과다사용
		arr2[0]= 1;
		arr2[2] = 10;
		arr2[1] =10;
		arr2[3] = 1000;
		//arr2[4]=10000; ArrayindexOutof bounds
			System.out.println(arr2[1]);
			System.out.println(arr2[2]);
			
			System.out.println("배열의 크기"+arr2.length);
			for(int i=0;  i<arr2.length;  i++) {
				System.out.println(arr2[i]);
			}
	}

}
