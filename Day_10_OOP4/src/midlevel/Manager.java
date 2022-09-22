package midlevel;


//MVC의 M, MODEL 파트
//데이서 다루는 작업
//출력에 관한건 안들어가는게 좋다


public class Manager {

	private Silver[] silverMembers = new Silver[10]; //실버형 변수들의 집합
	private Gold[] goldMembers = new Gold[10]; //
	private int silverIndex=0;
	private int goldIndex=0;  //인덱스가 실버형, 골드형 따로
	
	
	public void addMember(Silver s) { //회원 저장 //리턴 필요x //참조형 매개변수

		silverMembers[this.silverIndex++] = s;// 0123~10 저장할떄마다 인덱스 증가
	}
	
	public void addMember(Gold g) { //addMember오버로드
		goldMembers[this.goldIndex++]=g;
	}  
	
	public Silver[] getSilverMembers() { //Silver참조형 반환타입 
		return silverMembers;  //출력을 모델파트에서 하면 비효율적이라 
	}
	
	public Gold[] getGoldMembers() {  
		return goldMembers; // 변수가 이미 배열로 되어있으니까 배열인 변수를 반환한거죠
	}
	
	
	public int getSilverIndex() {
		return silverIndex; //for문돌면서 출력하기 위헤서 인덱스가 private이라 게터메서드로 
	}
	
	public int getGoldIndex() {
		return goldIndex;
	}
	
}
