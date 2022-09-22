import javax.swing.AbstractAction;
import javax.swing.plaf.synth.SynthDesktopPaneUI;

public class Exam_01 {

	public static void main(String[] args) {
		
		System.out.println("스트링배열 예제");
		String[] arr = new String[10];
		
		arr[0]="Hello";
		arr[1]="world";
		arr[2]="Collection";
		
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = null; //삭제코드
		
		arr[2] = arr[1];
		arr[1]= "hello";  //arr[1] 에 hello넣기
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr.length);
	}

}

