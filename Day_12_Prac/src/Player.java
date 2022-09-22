
public class Player {
	private int division; //등급 1 아마추어 2 프로
	private int age;//나이
	private String name; // 이름
	private String position; // 포지션
	private int fee; //이적료 단위 1m 유로 한화 13억
	
	public Player() {}
	public Player(int division, int age, String name, String position, int fee) {
		super();
		this.division = division;
		this.age = age;
		this.name = name;
		this.position = position;
		this.fee = fee;
	}
	
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
