import java.util.Scanner;

public class Test2 {
   public static void main(String[] args) {
   
      Scanner sc = new Scanner(System.in);
      
      int com = (int)((Math.random()*3)+1); // 말 3개에 난수 설정하여 당첨 출력 1~3

      int money = 0;
      int add = 0;
      int bet = 0;
      int player = 0;
      
      /*   
      money 초기소지금
      add 잔액충전
      bet 베팅
      
      com 난수
      player 말선택
      */
      
      start : while(true) {
         
         System.out.println("<<< 경마게임에 오신 것을 환영합니다. >>>\r\n");
         System.out.println("1. 게임시작");
         System.out.println("2. 잔액충전");
         System.out.println("3. 잔액조회");
         System.out.println("4. 게임종료\r\n");
         System.out.println("메뉴를 선택해주세요.");
         System.out.print(">> ");
         int menu = Integer.parseInt(sc.nextLine());
         
         
         if(menu == 4) {         //4. 게임 종료
            System.out.println("게임이 종료되었습니다.");
            System.exit(0);
            
         } else if(menu == 3) {   //3. 잔액조회
            System.out.println("현재 잔액은 : " + money + "원입니다.\r\n");
            
         } else if(menu == 2) {   //2. 잔액충전
            System.out.print("얼마를 충전하시겠습까 ? ");
            add = Integer.parseInt(sc.nextLine());
            System.out.println(add + "원이 충전되었습니다.\r\n");
            // 총 금액 = 금액 + 충전
            money = money + add;
                  
         } else if(menu == 1) {   //1. 게임시작 
            
            System.out.println("-- 경마게임이 시작되었습니다. --\r\n");
            
            System.out.println("1. 우승 경력이 많지만 은퇴를 앞둔 말");
            System.out.println("2. 이번달 성적이 제일 좋은 말");   
            System.out.println("3. 최근 떠오르는 신예인 말\r\n");
            
            while(true) {
               System.out.print("배팅 하고 싶은 말을 선택해주세요. >> ");
               player = Integer.parseInt(sc.nextLine());
               
               if(player == 1 || player == 2 || player == 3) {
                  System.out.print("얼마를 배팅 하시겠습까 ? : ");
                  bet = Integer.parseInt(sc.nextLine());
                  
                  if(money < bet) {
                     System.out.println("잔액이 부족합니다.");
                     System.out.println("현재 잔액은 : " + money + "원 입니다.\r\n");
                     continue start;
                  } else {
                     break;
                  }
                  
               } else {
                  System.out.println("잘못 입력하셨습니다. 옳바른 숫자를 입력해주세요.\r\n");
                  continue;
               }
            }
            
            // 배팅 끝나자마자 경마 결과 출력
            System.out.println(com + "번 말이 우승하였습니다.");
                  
            if(player == com) {
               //배팅 성공하면
               System.out.println("배팅에 성공하였습니다..!");
               System.out.println("배팅한 금액의 2배인 " + bet*2 + "원을 획득하였습니다.");
               money = money + (bet*2);
            } else {
               //배팅 실패하면
               System.out.println("배팅에 실패하였습니다...^^");
               System.out.println("배팅한 금액인 " + bet + "원을 모두 잃으셨습니다.");
               money = money - bet;
            }
            
            
         } else {
            System.out.println("잘못 입력하셨습니다. 옳바른 숫자를 입력해주세요.\r\n");
         }         
         
      }
   
   }
}