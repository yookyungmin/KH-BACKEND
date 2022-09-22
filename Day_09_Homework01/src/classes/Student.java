package classes;


public class Student {

	private String name;
	private int kor;
	private int eng;
	//동일한 타입을 가져야하는 제약이 없다
	
	
	

	public Student() {}  //기본 생성자

	public Student(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getKor() {
		return kor;
	}



	public void setKor(int kor) {
		this.kor = kor;
	}



	public int getEng() {
		return eng;
	}



	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
	public int getTotal() {
		return this.kor+this.eng;  
	}
	
	public	double getAvg() {
		return getTotal()/2.0;  //getTotal()/2; 은 getTotal은 int 반환 / 2 int 반환 에서 getAvg double 반환이라 뒤에 .0이 붙지만 평균이 소수점첫쨰자리가 .0이 아닌경우에도 .0으로 나옴
	}

	@Override
	public String toString() {
		return "Student [name=" + name+ ", kor=" + kor + ", eng=" + eng + "]";
	}

}
