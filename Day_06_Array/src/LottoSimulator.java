import java.util.Scanner;

public class LottoSimulator {

      public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         while(true) {
            System.out.println("1. 로또 번호 추천");
            System.out.println("2. 로또 수동 구매");
            System.out.println("3. 로또 자동 구매");
            System.out.println("0. 시뮬레이터 종료");
            System.out.print(">> ");

            int menu = Integer.parseInt(sc.nextLine());

            if(menu == 1) {

               int[] arr = new int[45];
               for(int i = 0;i < 45;i++) {arr[i] = i+1;}

               for(int i = 0;i < arr.length*10;i++) {
                  int x = (int)(Math.random()*45);
                  int y = (int)(Math.random()*45);
                  int tmp = arr[x];
                  arr[x] = arr[y];
                  arr[y] = tmp;
               }

               System.out.println("추천 번호는 ");
               for(int i = 0;i < 6;i++) {
                  System.out.print(arr[i] + " ");
               }
               System.out.println(" 번 입니다.");
               System.out.println("보너스 번호 추천 : " + arr[6]);

            }else if(menu == 2) {
               int[] arr = new int[45];
               for(int i = 0;i < 45;i++) {arr[i] = i+1;}
               for(int i = 0;i < arr.length*10;i++) { // 450번 곱해서 섞기
                  int x = (int)(Math.random()*45); // 난수
                  int y = (int)(Math.random()*45); // 난수
                  int tmp = arr[x];
                  arr[x] = arr[y];
                  arr[y] = tmp;
               } 
               
               // --------------------------------- 로또 번호 섞어놓는 작업

               //            System.out.print("당첨 번호 : ");
               //            for(int i = 0;i < 6;i++) {
               //               System.out.print(arr[i] + " ");
               //            }
               //            System.out.println();


               int[] player = new int[6];

               for(int i = 0;i < 5;i++) {
                  System.out.print((i+1) + " 번째 번호 선택 (1 ~ 45) : ");
                  player[i] = Integer.parseInt(sc.nextLine());
               }
               
               boolean bonusFlag = false;
               
              // --------------------------------- 사용자가 로또 번호를 선택하는 작업
               
               
               // 당첨 처리 로직            
               
               int count = 0;
               for(int i = 0;i < 6;i++) { // 6번 돌게
                  for(int j = 0;j < 6;j++) {  // 6번 돌게 / i = 0, j = 0,1,2,3,4,5 돌기 * 이걸 6번 반복
//                                                   i = 1, j = 0,1,2,3,4,5 돌기  ...
                     if(arr[i] == player[j]) {
                        count++; // 당첨을 찾을 때마다 카운트를 한다.
                     }
                  }
               }
               

               
               for(int i = 0;i < player.length;i++) {
                     if(player[i] == arr[6]) {
                        bonusFlag = true;
                     }
               }
               
            // --------------------------------- 몇 개가 맞았는지 확인하는 작업(이중 for문)
               
               
               
               
               if(count == 6) {
                  System.out.println("1등 당첨!!");
               }else if(count == 5 && bonusFlag) {
                  System.out.println("2등 당첨!!");
               }else if(count == 5) {
                  System.out.println("3등 당첨!!");
               }else if(count == 4) {
                  System.out.println("4등 당첨!!");
               }else if(count == 3) {
                  System.out.println("5등 당첨!!");
               }

            }else if(menu == 0) {
               System.out.println("시뮬레이터를 종료합니다.");
               System.exit(0);
            }else {
               System.out.println("메뉴 번호를 확인해주세요.");
            }
         }


      }
   }