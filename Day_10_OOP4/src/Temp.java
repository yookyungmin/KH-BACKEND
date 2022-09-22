
public class Temp {
	public int a; 			//인스턴스 멤버변수  new 하지 않으면 메모리에 없음
	public static int b;  //클래스 멤버변수 , 스태틱 변수 // static 이 붙어 있으면 main이 실행되면서 함께 실행됨 
	//처음 접근한 순간 만들어진다, 언제 어디서나 만들어진다라고 생각가능
	//스태틱 변수는 데이터메모리에서 heap 메모리에저장으로 바뀜 자바8부터

	
	public void funcA() {
		a= 10;
		b=20;
	}
	
	public static void funcB() {
		//a=30;  //에러 스태틱 메서드는 인스턴스 변수에 접근불가  //스태틱 funcB 생성 시점에서는 a가 생성되지 않기 떄문에 why? 인스턴스 변수는 new 통해서 객체생성후 사용이 가능하기떄문에
			//non static
		b=40;
	}
}
