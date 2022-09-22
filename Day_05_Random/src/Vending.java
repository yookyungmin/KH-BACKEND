import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Vending {
	public static void main(String[] args) {
		
		//자판기 
		//콜라 1000 2 사이다 3 매실차 [0] 소지품 확인
		Scanner sc = new Scanner(System.in);
		//int balance = 3000;  //초기소지금
				int coke =0;// 코크갯수
				int co=1000;  //콜라 금액
				
				int cidar=0; // 사이다
				int ci = 800; //사이다 금액
				
				int plum=0; //매실
				int pl= 1500; //매실 금액
				
				System.out.println("초기 소지금");
				int balance = Integer.parseInt(sc.nextLine());
				
				while(true) {
					System.out.println("====자판기 시뮬레이터====");
					System.out.println("1. 콜라(1000) 2. 사이다(800) 3.메실차(1500) 9.되돌아가기 [0.소지품 확인]");
					System.out.println("구매하실 항목을 입력해주세요");
					int input= Integer.parseInt(sc.nextLine()); //
					
					if(input==1) {
						if(balance>=co) {
						System.out.println("콜라를 구매 했습니다");
						System.out.println("콜라+1");
						System.out.println("소지금"+"-"+co);
						coke++;
						balance-=co;
						System.out.println("남아 있는 금액은"+balance+"원 입니다");
						
					}else {
						System.out.println("잔고 부족입니다");
					}
				}else if(input==2) {
					if(balance>=cidar) {
						System.out.println("사이다를 구매 했습니다");
						System.out.println("사이다+1");
						System.out.println("소지금"+"-"+ci);
						cidar++;
						balance-=ci;
						System.out.println("남아있는 금액은 "+balance+"원 입니다");
					}else {
						System.out.println("잔고부족입니다");
					}
					
				}else if(input==3) {
					if(balance>=plum) {
						System.out.println("매실을 구매 했습니다");
						System.out.println("매실+1");
						plum++;
						balance-=pl;
						System.out.println("남아있는 금액은"+balance+"원 입니다");
					}
				}else if(input==0) {
					System.out.println("===소지품 목록====");
					System.out.println("소지금 :"+balance+"원");
					System.out.println("콜라 :"+coke +" 개");
					System.out.println("사이다 :"+cidar +" 개");
					System.out.println("메실차 :"+plum +" 개");
				}else if(input==9) {
					System.out.println("구매를 종료 하였습니다");
					System.exit(0); //시스템종료
					//break; // 반복문을 벗어나겠다
				}
	}
	}
}

