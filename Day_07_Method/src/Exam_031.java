
public class Exam_031 {
	
	public static void func(int num) {  //매개변수의 성질은 지역변수와 동일
		num = 20;
		
		//리턴값을 두개 리턴 하려면?
	}  //20은 지역변수로 {} 벗어나면 소멸

	
	public static void func() {//call by name 
		
	}
	public static void func(int[] s) { //참조형 매개변수
		s[0] = 100;
		s[1] = 200;
	}
	
	public static void main(String[] args) {
		int i = 10;
		func(i);  //call by value 기본자료형을 넘긴 경우, 값에 의한 호출  //값 유지
		//main stack 의 i
		
		func();//call by name 인자가 없이 호출 이름에 의한 호출
		
		int[] arr = new int[] {10,20}; // arr에는 배열의 주소가 들어있꼬 10,20은 heap메모리에 들어감
	
		
		func(arr);//call by reference
		//참조에 의한 호출 // 값이 메서드를 거치면서 값이 바뀜
		
		//배열, 문자열은 참조형
		System.out.println(i);  //메인 메서드의 10 출력 //call by value
		
		System.out.println(arr[0]);  //call by reference
	}

}
//call by name  메서드 호출시 인자없이 호출
//기본형 매개변수는 값이 메서드를 거쳐도 값이 변하지 않는다 call by value
//참조형 매개변수는 메서드를 거치면 값이 변한다 같은 주소를 가르키고 있기 떄문에 //call by reference
//참조형 배열, 문자열은 참조형

//Integer.parse