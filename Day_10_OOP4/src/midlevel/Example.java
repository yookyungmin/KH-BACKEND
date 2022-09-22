package midlevel;

//다형성 중요 

class A {
	public void funcA() {
		System.out.println("func A입니다");
	}
}

class B extends A{
	public void funcB() {
		System.out.println("func B입니다");
	}
	
	public void funcA() {
	System.out.println("func B입니다");
	} //오버라이딩
}

public class Example {

	
	public static void main(String[] args) {
		//다형성 
		//많은 형태를 가진 성질
		//다형성이 가능한이유 상속관계에서 B형 인스턴스에 A형 인스턴스가 포함되어 있기 떄문이다
		//상속관계에 놓여있는 주클래스 사이에서 상위 클래스(부모) 참조변수는 자신을 상속받는 하위클래스 인스턴스의
		//주소를 저장할수 있다.
		
		//상위클래스참조변수로 하위클래스 인스턴스 주소를 저장할수 있지만
		//사용할떈 참조변수의 자료형만큼만 사용가능, 
		//하지만 캐스팅으로 모든 기능 사용 가능
		
		
		//업캐스팅 자동으로 실행
		A a = new B(); //B형인스턴스가 A형 인스턴스에 왜 들어갈수 잇는가 //B가 자손으로 더 큰원에 작은 원A
		a.funcA();
		//다운캐스팅 무관하게 
		//funcA 가 클래스B에서 오버라이딩 되어 있다면 출력시 B클래스의 funcA출력
		
//		((B)a).funcB();  //다운 캐스팅
//		((B)a).funcA(); // 다운 캐스팅 A 인스턴스, B인스턴스 모두사용하려면
		
		
		
//		B b = new B();
//		 b.funcA();
//		 b.funcB();
//		B b=(B)a;
//		b.funcA();
//		b.funcB();
	}

}
