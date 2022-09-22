package midlevel;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_02 {

	public static void main(String[] args) {
		//어떠한 클래스를 만들어도 Object를 상속하는건 피해갈수 없다
		Object o;
		o = new Scanner(System.in);
		
		o = 100;
		o= new Exam_02();
		
		System.out.println("ArrayList 예제");
		ArrayList arr = new ArrayList();
		
		arr.add("Hello");
		
		arr.add("World");
		arr.add("Collection");
		arr.add(new Integer(100));
		arr.add(100);
		arr.remove(0);
		((String)arr.get(0)).length(); // 다운캐스팅으로 length으로 사용
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		arr.add(1,"Hello");
		arr.add(new Scanner(System.in));
		arr.add(new Exam_02());
		//Object의 자손
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(3));
		System.out.println(arr.size());  //배열 전체 사이즈가 아닌 요소의 사이즈
	}

}
