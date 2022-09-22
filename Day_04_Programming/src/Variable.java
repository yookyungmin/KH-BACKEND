
public class Variable {

	public static void main(String[] args) {
		//변수의종류
		//[{지역변수 // 매개변수}]  // 정적변수 // 멤버변수
	
		int a = 10; // 메소드 안에 있으니 지역변수     //메인 메서드이기 떄문에 b로 하면 가 지역 나 지역에 못씀 
		
		{//가 지역
			int b = 10; // { } 안에서만 생존 지역변수
			System.out.println(b);
		}
		
		
		{  //나지역
		int  b= 20; 
		System.out.println(b);
		}
		
		}

}
