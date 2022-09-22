
public class Monitor{
	private String brand = "LG";
	private int price = 1000;
	private double weight=27.5; //기본값, //무게  
	//멤버변수, 멤버필드


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;  
		}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	void powerOn(){}

	void power0ff(){}
	
	void volumeUp(){}
	void volumeDown(){}  //멤버메서드, 메서드 {} 안에 만들어지는것은 지역변수

	public Monitor() {}  //기본 생성자
	public Monitor(String brand, int price, double weight) {
		this.brand = brand;
		this.price = price;
		this.weight = weight;
		System.out.println("모니터 생성자 실행 됨");
		
	}	
	//contructor 생성자
	/*
	 *1. 생성자 메서드의 이름은 클래스 이름과 동일해야 한다.
	 *2. 생성자 메서드는 return 값을 가지지 않는다.
	 *3. 생성자 메서드는 콜 시점은 개발자가 지정할수 없다(콜 되는 시점이 정해져잇다) 
	 * 인스턴스가 생성될때 호출된다
	 * 인스턴스 생성시점 초기값 셋팅
	 * 매개변수가 다른 오버로딩 가능
	 *
	 */
	
	//nested class 클래스 안에 클래스를만듬 내부클래스?

}