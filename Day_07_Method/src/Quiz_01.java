import java.util.concurrent.CountDownLatch;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Quiz_01 {


	//	public static int count(String a) {
	//		int sum=0;
	//		for(int i = 0; i<a.length(); i++) {
	//		if(a.contains("S")){
	//		sum++;
	//		}
	//		}
	//		return sum;
	//	}

	public static int countS(String str) {
		int count=0;

		if(str.contains("S")) { //S가 str에  포함 하면  
			for(int i = 0; i<str.length(); i++) {  
				char ch= str.charAt(i); // 인덱스 i=0부터 str.length() 동안
				if(ch=='S') {  //ch은 ==으로 비교 // ch 가 S면 카운트 1
					count++;
				}
			}
		}else {
			System.out.println("S를 포함하고 있지않습니다");
			
		}
		return count;
	} //대문자 S를 찾는 메서드
	
	
	public static int countChar(String from, char findThis) {
		int count=0;

		//S가 str에  포함 하면  
			for(int i = 0; i<from.length(); i++) {  
				char ch= from.charAt(i); // 인덱스 i=0부터 from.length() 동안
				if(ch==findThis) {  //ch은 ==으로 비교 // 찾으려는 알파벳이 잇으면 ++1;
					count++;
				}
			}
		return count;
	} //특정문자에서 특정 알파벳의 갯수를 는 메서드
	
//	public static int countCharr(String from, char findThis) {
//		String[] arr = from.split(findThis+"");
//		return f+arr.length-1;
//	}
	
	public static void main(String[] args) {
		String str = "ADasdAAAasdaszxc";
		String st = "SSsS";

		System.out.println("대문자 S의 갯수->"+countS(st));

		int count = countS(str);
		System.out.println("대문자의 S의 개수:"+ count);
		
		int cchar = countChar(str, 'A');  //범용성이 좋은 메서드
		System.out.println("특정 문자열의 특정 알파벳을 찾으라=>"+cchar);
	}

}
