package midlevel;

import java.util.ArrayList;

//MVC의 M, MODEL 파트
//데이서 다루는 작업
//출력에 관한건 안들어가는게 좋다





//컬렉션 배운 후 데이터 저장소 문제 해결
public class Manager3 {

	private ArrayList<Member> members = new ArrayList();
	
//	private int index = 0;
	
	
	public void addMember(Member m) { //회원 저장 //리턴 필요x //참조형 매개변수 //멤버형 변수, 실버 골드 자손

		members.add(m);// 0123~9 저장할떄마다 인덱스 증가  
	} //오버로딩 필요없이 다형성으로 한개로만 작성가능
	
	
	
	public  ArrayList<Member> getMembers() { //참조형 반환타입 
		return members; //배열의 주소 리턴
	}
	
	
	
//	public int getIndex() {
//		return index; //for문돌면서 출력하기 위헤서 인덱스가 private이라 게터메서드로 
//	}



	
	
	
	
}
