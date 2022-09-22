import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollPaneUI;

public class ATM {

	public static void main(String[] args) {

		// ATM 시뮬레이터
		//1. 잔액조회 2. 입금하기 3. 출금하기 4. 종료하기

		Scanner sc = new Scanner(System.in); //굳이 While문 안에 넣을필요 없음
		int sum = 0; // 총 잔액 //while문으로 들어가면 안됨계속 총잔액이 초기화됨
		int depo; //입금
		int withdraw;  //출금

		//출력
		while(true) {

			System.out.println("****ATM 시뮬레이터******");	
			System.out.println("1.잔액조회");
			System.out.println("2.입금하기");
			System.out.println("3.출금하기");
			System.out.println("4.종료하기");	
			System.out.println("===>>");
			int input = Integer.parseInt(sc.nextLine());
			if(input==1) {
				System.out.println("현재 잔액은 "+sum+"원 입니다");
			}
			if(input==2) {
				while(true) {
					System.out.println("입금 금액을 입력하세요");
					try {
					depo = Integer.parseInt(sc.nextLine());
					if(depo>0) {
						sum+= depo;  //잔액+ 입금
						System.out.println("입금 하신 금액은"+depo+"원 입니다");
						System.out.println("보유잔액은 "+ sum+"원 입니다");
						break;
					}else {
						System.out.println("1원 이상 금액을 입력하세요");
					}
					}catch (Exception e) {
						System.out.println("숫자를 입력해주세요");
					}
					}
			}
			if(input==3) {
				System.out.println("출금하실 금액을 입력 해주세요");
				withdraw = Integer.parseInt(sc.nextLine());
				if(withdraw<=sum) {
					sum-=withdraw;
					System.out.println("출금하신 금액은"+withdraw +"원 입니다");
					System.out.println("출금 하였습니다 남은 금액은"+sum+"원 입니다");
				}else {
					System.out.println("잔고 부족입니다 남아 있는 금액은" +sum+"원 입니다");
				}
			}

			if(input==4) {
				System.out.println("서비스를 종료하였습니다");
				break;
			}else {
				System.out.println("메뉴를 다시 확인해주세요");
			}
		}

	}

}
