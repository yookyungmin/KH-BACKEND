import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Main {
	//view controller


	public static void printPlayers(ArrayList<Player> p) {  //출력 메서드
		System.out.println("등급\t나이\t이름\t\t포지션\t이적료(m)");
		for(Player ps:p) {
			System.out.println(ps.getDivision()+"\t"+
					ps.getAge()+"\t"+
					ps.getName()+"\t"+
					ps.getPosition()+"\t"+
					ps.getFee());
		}
	}
	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		Manager manager = new Manager();

		while(true) {
			System.out.println("선수 관리 시스템");
			System.out.println("1.신규 선수 입력(등급, 나이, 이름, 포지션, 이적료)");
			System.out.println("2.선수 목록 출력(등급, 나이, 이름, 포지션, 이적료)");
			System.out.println("3.선수 검색(이름으로 검색)");
			System.out.println("4.선수 정보 삭제(이름으로 삭제)");
			System.out.println("5.선수 정보 수정(이름으로 수정");
			System.out.println("6. 시스템 종료");
			System.out.println(">>>>>>>>>>>>>>");

			int menu = Integer.parseInt(sc.nextLine());


			if(menu==1) {
				System.out.println("등급을 입력하세요 1. 아마추어 2. 프로");
				int div = Integer.parseInt(sc.nextLine()); // 아마추어 프로 선택
				if(div==1) {
					try {
						System.out.println("나이를 입력하세요");
						int age = Integer.parseInt(sc.nextLine());
						System.out.println("이름을 입력하세요");
						String name = sc.nextLine();
						System.out.println("포지션을 입력 하세요");
						String posi= sc.nextLine();
						System.out.println("이적료를 입력하세요 m 단위(1m 유로,13억)");
						int fee = Integer.parseInt(sc.nextLine());

						manager.addPlayer(new Amateur(div, age, name, posi, fee) );
						continue;
					}catch (Exception e) {
						System.out.println("제대로 입력하세요");
					}
				}else if(div==2) {
					try {
						System.out.println("나이를 입력하세요");
						int age = Integer.parseInt(sc.nextLine());
						System.out.println("이름을 입력하세요");
						String name = sc.nextLine();
						System.out.println("포지션을 입력 하세요");
						String posi= sc.nextLine();
						System.out.println("이적료를 입력하세요 m 단위(1m 유로,13억)");
						int fee = Integer.parseInt(sc.nextLine());
						manager.addPlayer(new Pro(div, age, name, posi, fee) );
					continue;
					}catch (Exception e) {
						System.out.println("제대로 입력하세요");					}
				}else {
					System.out.println("번호를 1~3 입력해주세요");
				}
			}else if(menu==2) {    //선수정보 모두 출력
				ArrayList<Player> play= manager.getPlayers();
				//ArrayList로 바로 접근이 안되기떄문에 getMembers사용
				printPlayers(play);


			}else if(menu==3) { //선수 정보검색 이름으로 검색
				System.out.println("검색하실 이름을 입력하세요");
				String Sname = sc.nextLine();
				ArrayList<Player> pla = manager.searchName(Sname);
				
				
				if(pla.size()==0) {
					System.out.println(Sname+"선수가 존재하지 않습니다");
				}else {
					printPlayers(pla);
				}
			}else if(menu==4) { //선수 삭제 이름으로검색
				System.out.println("삭제할 선수의 이름을 입력하세요");
				String delNmae = sc.nextLine();
				manager.delPlayer(delNmae);
				
			}else if(menu==5) {  //선수 수정 이름으로 검색
				System.out.println("수정할 선수의 이름:");
				String name = sc.nextLine();
				System.out.println("등급:");
				int div = Integer.parseInt(sc.nextLine());
				System.out.println("나이");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("포지션:");
				String posi = sc.nextLine();
				System.out.println("이적료");
				int fee = Integer.parseInt(sc.nextLine());
			
				Player p = new Player(div,age,name,posi,fee);
				
				manager.updatePlayer(p);
			}else if(menu==6) {
				System.out.println("시스템을 종료하였습니다");
				System.exit(0);
			}
		}

	}
}
