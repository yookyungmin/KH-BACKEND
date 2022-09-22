package midlevel;

//실버 클래스
public class Silver extends Member {
//silver 인스턴스안에 멤버인스턴스도 포함

	public Silver(int id, String name, int point) {
		//super(); //묵시적으로 항상존재,
		super(id, name, point);  //조상 생성자 호출 super  //첫줄에만 사용가능
		//main에서 실버로 받았다가 실버에서 멤버로 가는 그림
		//Member 클래스의 변수가 private이라서 super로접근
		} 
//	public Silver(int id) {
//		super(1000, "jackson", 3);
//	} // super() 안에 값이 변수로 되어 있으면 자손 클래스 생성자 매개변수안에 변수로 지정해줘야 오류 안남
	public double getBonus() {
		return this.getPoint()*0.02;  //오버라이딩
	}
	// 추상클래스를 상속받으면 에러 두가지 해결법
	//1 실버 클래스 앞에 abstract 붙이기 
	//2 추상 메서드 오버라이딩, 임플리먼츠
	//추상메서드를 오버라이딩, 임플리먼츠 안하면 자손 클래스 앞에 abstract붙여야함
}
