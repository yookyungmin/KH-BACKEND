
public class Main {

	public static void main(String[] args) {//시작위치
		/*Monitor mon; <= stack에만 저장
		 * 
		 * new Monitor();  <= heap메모리에 저장
		*/
		Monitor mon = new Monitor();  //객체 , 인스턴스 생성
		//참조자료형 가변적이다, new가 있어야 힙메모리에 저장
		// new 램 힙메모리에 저장, 주소를 반환해서 mon에저장 시켜주는 역할
		//힙메모리 안에 인스턴스 안에 변수가 만들어짐
	
	
			Tv tv = new Tv();
			tv.setVolume(2);
			//tv.channelDown();
			
			System.out.println(tv.getVolume());
			
			System.out.println(tv);
			System.out.println(tv.getThis().getThis().getThis());  //위아래같은 주소가같음 //체인잉 기법
	
			mon.setBrand("Samsung");
			mon.setPrice(100);
			mon.setWeight(29.5);  //셋팅
			
			System.out.println(mon.getBrand());
			System.out.println(mon.getPrice());
			System.out.println(mon.getWeight()); //겟 불러오기
	
			Monitor mo = new Monitor("sam", 500, 15);  //생성자 호출
			System.out.println(mo.getBrand());
			
	}

}
