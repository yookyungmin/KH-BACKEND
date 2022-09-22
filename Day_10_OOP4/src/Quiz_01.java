import java.util.Calendar;

public class Quiz_01 {

	public static void main(String[] args) {
		
		Calc c = new Calc();
		
		System.out.println(c.plus(10,20)); //30  //인스턴스 메서드
		System.out.println(Calc.minus(30,20)); //10 //스태틱 메서드
		System.out.println(c.mply(5,3)); //15 //인스턴스 메서드
		System.out.println(Calc.divide(10,2)); //5 //스태틱 메서드
		
		
	}

}
