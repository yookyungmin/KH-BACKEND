package midlevel;

abstract public class Member {  //추상클래스 객체생성x

	private int id;
	private String name;
	private int point;


	public Member() {}  //기본생성자 있어야 //있어야지 자손클래스에서 오류가 안남

	public Member(int id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	abstract public double  getBonus(); //추상메서드
		//보너스 
	
	

	
}
