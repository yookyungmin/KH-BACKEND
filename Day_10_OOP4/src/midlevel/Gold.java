package midlevel;

//클래스 간의 관계
// HAS -A 포함관계 -> A HAS A B ~ 가지고 있다
// IS -A 상속관계  - > A IS A B  ~이다
//GOLD IS A [] , SILVER IS A [] ~ 이다 상속사용
//Tiger is a []
//Bear is a [] 


public class Gold extends Member{ //골드 클래스가 멤버클래스를 확장한다. //
		
	
		public Gold() {//super();
			}  //기본생성자  
	
		public Gold(int id, String name, int point) {
			super(id, name, point);
		}
	
		public double getBonus() {
			return this.getPoint()*0.03;		}
	}
