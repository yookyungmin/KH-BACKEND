import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		int balance =0; //소지금

		int menu; //메뉴
		int bet; //베팅금액
		int dep; //입금금액
		int tmp;//배팅 2배 금액을 담을 변수





		while(true) {
			System.out.println("<<경마게임에 오신것을 환영합니다>>");
			System.out.println("1.게임시작");
			System.out.println("2.잔액충전");
			System.out.println("3.잔액조회");
			System.out.println("4.게임종료");
			System.out.print("메뉴를 선택해주세요\n==>");

			menu = Integer.parseInt(sc.nextLine());

			if(menu==1) { //게임시작
				System.out.println("게임을 시작합니다");
				System.out.println("1.우승경력이 많지만 은퇴를 앞둔 말");
				System.out.println("2.이번달 성적이 제일 좋은 말");
				System.out.println("3.최근 떠오르는 신예인 말");
				System.out.println("배팅하고싶은 말을 선택해주세요=>>");
				int pwin = Integer.parseInt(sc.nextLine()); //플레이어 우승말
				System.out.println("얼마를 배팅 하시겠습니까?=>>"); 
				bet = Integer.parseInt(sc.nextLine()); //배팅 금액
				if(balance>=bet) { //소지금이 배팅금액과 같거나 많으 게임시작
					int cwin =(int)((Math.random()*3)+1); //랜덤 우승말
					if(pwin==cwin) {
						System.out.println(pwin+"번 말이 우승하였습니다");
						System.out.println("배팅에 성공하였습니다!!");
						tmp=bet*2; // 배팅 2배금액을 담을 변수
						System.out.println("배팅한 금액의 2배인"+tmp+"원을 획득 하였습니다!!");
						balance+=tmp; //소지금 +배팅 두배 금액
						System.out.println("남은 소지금은"+balance+"원 입니다"); //소지금 +배팅 두배 금액
					}else if(!(pwin==cwin)) {
						System.out.println(cwin+"번 말이 우승 하였습니다");
						System.out.println("배팅에 실패 하였습니다");
						System.out.println("배팅한 금액인 "+bet+"원을 모두 잃었습니다");
						balance-=bet; //소지금-배팅금액
						System.out.println("남은 소지금은"+balance+"원 입니다");// 소지금 -배팅 두배 금액

					}
				} else if(balance<bet) { //배팅금이 소지금보다 적으면
					System.out.println("잔액이 부족합니다");
					System.out.println("잔액을 충전하고 오세요");
				}

			}else if(menu==2) {// 잔액 충전
				System.out.print("얼마를 충전하시겠습니까?==>");

				dep = Integer.parseInt(sc.nextLine()); //입금금액
				balance+=dep;  
				System.out.println(dep+"원이 충전되었습니다");


			}
			else if(menu==3) { //잔액 조회
				System.out.println("현재 잔액은 "+balance+" 원 입니다");

			}else if(menu==4) { //게임 종료
				System.out.println("게임을 종료하였습니다");
				System.exit(0);


			}else { //1 ~4번 외의 번호 입력
				System.out.println("1~4번 범위 안에서 제대로 입력하세요");
			}



		}

	}

}
