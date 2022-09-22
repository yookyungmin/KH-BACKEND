package midlevel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

//Design Pattern MVC1 //미완성형, VIEW와 CONTROL이 묶임,  MODEL 따로
//MODEL VIEW CONTROL
	
	//다형성 적용 main
	
	//VIEW와 CONTROL로 구성
	public static void main(String[] args) {
		
		//우리가 만든 회원관리 시스템의 3가지 치명적인 문제점
		//1. 코드 중복도가 높다. -> 상속 문법으로 해결
		//2, 코드 결합도가 높다(a가 바뀌면 b도 바뀌어야 한다) -> 다형성 문법으로 해결
		//3. 데이터 저장소 문제 - >Collection으로 해결
		Scanner sc = new Scanner(System.in); //VIEW
		Manager3 manager3 = new Manager3();//매니저 인스턴스생성 실버클래스의 배열10칸 기억
		
		while(true) {
		System.out.println("<<< 회원관리 시스템>>");
		System.out.println("1.신규 회원등록");
		System.out.println("2.회원 정보출력");//VIEW
		
		int menu = Integer.parseInt(sc.nextLine());

		
		if(menu==1) {
//			Silver s =new Silver(1001, "Tom", 1000);
//			manager.addMember(s);
			manager3.addMember(new Silver(1001, "Alice", 1000));
			manager3.addMember(new Silver(1002, "TOM", 2000));
			manager3.addMember(new Silver(1003, "Json",3000));

			manager3.addMember(new Gold(1004, "Mike", 4000));
			manager3.addMember(new Gold(1005, "Elsa", 4000));
			manager3.addMember(new Ruby(1006, "John", 3500));
			
		}else if(menu==2) {  //출력 파트
			ArrayList<Member> members = manager3.getMembers();
			System.out.println("아이디\t이름\t포인트\t보너스");
//			for(int i = 0; i<members.size(); i++) {
//				 System.out.println(
//	                     ( members.get(i)).getId()+"\t"+  //다운캐스팅으로 주지 않으면 꺼낸게 object형이기 떄문에 getid를 쓸수 없다
//	                           ( members.get(i)).getName()+"\t"+
//	                           (members.get(i)).getPoint()+"\t"+
//	                           (members.get(i)).getBonus()
//	                     );
//			}
			
				 //Foreach 문으로 변경 , 향상된 for문
			//: 을 기준으로 뒤에 배열을 넣어주고 앞에 자료형과 이름을 입력해 주면 해당 이름으로 넣어준 배열의 인덱스를 순회하며 처리할 수 있다. 
			//members의 모든 인덱스를 m이라는 이름으로 순회하고 
			for(Member m : members) {
					 System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getPoint()+"\t"+m.getBonus());
				 }
				
			
		
		}
	}
	}
}
