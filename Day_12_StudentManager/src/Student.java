//dto
 class Student {
	 private int gra; //학년
	private String name;
	private int id;  //학번
	private int math;
	private int kor;
	private int eng;


	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int gra, int id, String name, int math, int kor, int eng) {
		this.gra = gra;
		this.name = name;
		this.id = id;
		this.math = math;
		this.kor = kor;
		this.eng = eng;
	}


	public int getGra() {
		return gra;
	}
	public void setGra(int gra) {
		this.gra = gra;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
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
	
	public double getTotal() {
		return this.math+this.kor+this.eng;// 합계
	}
	
	public double getAvg(){
		return this.getTotal()/3.0; //평균
	}
	
	
	
}
