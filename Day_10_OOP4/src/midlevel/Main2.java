package midlevel;

import java.util.Scanner;

public class Main2 {

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
		Manager2 manager2 = new Manager2();//매니저 인스턴스생성 실버클래스의 배열10칸 기억
		
		while(true) {
		System.out.println("<<< 회원관리 시스템>>");
		System.out.println("1.신규 회원등록");
		System.out.println("2.회원 정보출력");//VIEW
		
		int menu = Integer.parseInt(sc.nextLine());

		
		if(menu==1) {
//			Silver s =new Silver(1001, "Tom", 1000);
//			manager.addMember(s);
			manager2.addMember(new Silver(1001, "Alice", 1000));
			manager2.addMember(new Silver(1002, "TOM", 2000));
			manager2.addMember(new Silver(1003, "Json",3000));

			manager2.addMember(new Gold(1004, "Mike", 4000));
			manager2.addMember(new Gold(1005, "Elsa", 4000));
			manager2.addMember(new Ruby(1006, "John", 3500));
			
		}else if(menu==2) {  //출력 파트
			Member[] members = manager2.getMembers();
			System.out.println("아이디\t이름\t포인트\t보너스");
			for(int i = 0; i<manager2.getIndex(); i++) {
				System.out.println(members[i].getId()+"\t"+members[i].getName()+"\t"+
									members[i].getPoint()+"\t"+
									members[i].getBonus()); 
				//get메서드가 조상클래스인 member의 메서드라 다운캐스팅 필요없이 사용
				//멤버의 getBonus는 추상메서드지만 오버라이딩 되어있어서 실버, 골드로 찾아감
		
				/*
				 * if(members
				 */
				} 
			
		
		}
	}
	}
}
