
public class Exam_011 {



   public static int plus(int num1, int num2) {  
	   
	  /*
	   * Method란?
인수를 전달 받아 일련의 작업을 수행한 뒤 그 결과를 반환하는 코드
코드를 기능별로 분할 관리하여 가독성을 높이고 에러 검출에 용이
코드 재사용으로 인해 개발 및 유지 보수시간을 단축

c언어에선 function
	   */
	   
      // 덧셈을 담당하는 직원(함수 function 펑션) / 메서드 / plus의 원래 자리
      // public static 객체
      
      int result = num1 + num2;
      return result; // 메서드의 기능을 끝내고 값을 돌려보내라.
   }
      
//      return num1 + num2; // 값을 돌려보내야함. 위와 표현 동일
//
//                        메서드 콜에 의해 전달되어지는 값을 받아 저장하는 변수 : 매개변수
//                        int num1, int num2 = 매개 변수이다. 소괄호 안이라서 지역 변수가 아님
//                        파라미터가 전달되어서 매개변수로 들어간다.
//                        메서드 기준 왼쪽 : 리턴 데이터 타입(int) 
//                        메서드 기준 오른쪽 : 매개변수
//                        메서드 안쪽은 실행하고자하는 코드

   
   public static void main(String[] args) { // 메인은 프로그램 시작점 / 본격적 코드는 main에 담지않음. 코드 밖에 짬
                                 // 메인 사장님
//      System.out.println(10 + 5);
//      
//      plus(10,5) // 덧셈이 필요할 때 직원을 부름 / 메서드를 콜한다. 메서드콜
//               // 제어문옆에 붙어있는 소괄호만 아니라면 메서드콜 전부 가능
//      
//      plus() // 전달할 값 없으면
//      plus(10,5) // 전달할 값 있으면 / Method 를 Call 하며 전달하는 값을 인자값(argument 아규먼트) = 10,5
//      
//      
//      15 // 코드상에서 plus(10,5)로 보이긴함
//         // 복귀하면 plus(10,5)를 지우고 15만 남김 
      
      int result = plus(10,5); // 그래서 자료형이 아니라 int 형이다. 
      // 코드흐름이 위로, 위에서 계산하고 리턴, 원래 자리에, 그리고 result 에 값이 저장 끝
      
      System.out.println(result);
      System.out.println(plus(5,6));
      
      
//      System.out.println(); 메서드
//      sc.nextLine(); 메서드
      
   }
}

