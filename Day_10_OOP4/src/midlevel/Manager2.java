package midlevel;


//MVC의 M, MODEL 파트
//데이서 다루는 작업
//출력에 관한건 안들어가는게 좋다



//다형성 배운후 코드 결합도 해결
//1 멤버형 객체배열로 바꾸고 메서드들도 오버로딩 생략
//앞으로 등급이 늘어나도 손델 필요가 없다 why? 멤버의 자손들이기 떄문이다.
public class Manager2 {

	private Member[] members = new Member[10]; //Member는 추상클래스인데 어떻게 만들어졌는가? 멤버형 변수를 10개를 만든거지, 인스턴스를 만든게 아니기 떄문이다
	//1. 배열을 사용하면 사이즈를 명시할수 없다.
	private int index = 0;
	
	
	public void addMember(Member m) { //회원 저장 //리턴 필요x //참조형 매개변수 //멤버형 변수, 실버 골드 자손

		members[this.index++] = m;// 0123~9 저장할떄마다 인덱스 증가  
	} //오버로딩 필요없이 다형성으로 한개로만 작성가능
	
	
	
	public Member[] getMembers() { //참조형 반환타입 
		return members;  //배열의 주소 리턴
	}
	
	
	
	public int getIndex() {
		return index; //for문돌면서 출력하기 위헤서 인덱스가 private이라 게터메서드로 
	}
	
	
}
