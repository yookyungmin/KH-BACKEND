import java.util.Scanner;

public class Calcu3 {
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      int sum = 0;
      int num1 = 0;
      int num2 = 0;
      
      while(true) {
         System.out.println("=== 계산기 프로그램 ===\r\n");
         System.out.print("연산자 입력 (+,-,*,/) : ");
         String calc = sc.nextLine();
         
         
         if(calc.equals("q")) {
            System.out.println("\r\n계산기 프로그램을 종료합니다.");
            System.exit(0); 

         } else if(!calc.equals("+")&&!calc.equals("-")&&!calc.equals("*")&&!calc.equals("/")) {
            System.out.println("\r\n연산자를 잘못 입력 하셨습니다. 다시 입력해주세요.\r\n");
            continue;
         }
         
         
         
         System.out.print("첫 번째 숫자 입력 : ");
         num1 = Integer.parseInt(sc.nextLine());
         System.out.print("두 번째 숫자 입력 : ");
         num2 = Integer.parseInt(sc.nextLine());
            
         if(calc.equals("+")) {
            sum = num1 + num2;
            System.out.println("\r\n====== 결  과 ======\r\n");
            System.out.println(num1 + " + " + num2 + " = " + sum + "\r\n");
            
         } else if(calc.equals("-")) {
            sum = num1 - num2;
            System.out.println("\r\n====== 결  과 ======\r\n");
            System.out.println(num1 + " - " + num2 + " = " + sum + "\r\n");
            
         } else if(calc.equals("*")) {
            sum = num1 * num2;
            System.out.println("\r\n====== 결  과 ======\r\n");
            System.out.println(num1 + " * " + num2 + " = " + sum + "\r\n");
            
         } else if(calc.equals("/")) {
            sum = num1 / num2;
            System.out.println("\r\n====== 결  과 ======\r\n");
            System.out.println(num1 + " / " + num2 + " = " + sum + "\r\n");
            
         }

         
      }
      
      
   }
}