
public class Exam_01 {
	public static void main(String[] args) {
		//Bit -> 0,1  // 8Bit = 1Byte //1024Byte -> 1kbyte // 1024Kbyte-> 1MByte
		// 1024MByte -> 1GByte // 1024Gbyte -> 1TByte
		// 'A' = 65 'a' = 97
		//실수형은 정수형보다 무조건 크다
		
		//기본자료형
		byte a = 5; // 정수형으로 숫자만 저장가능  1byte 8bit  -128 ~ 127 1byte
 		short b= 32767;  //-32768 ~ 32767  2byte
		char c = 'A';//음수가 없음 65
		char cc = 65535;  //0~65535
		int d =  1000000000;//32bit 2의 32승 -21 억 ~ +21억 표현   4byte
		long e = 5005000000000L; //
		
		//실수형은 정수형보다 무조건 크다
		float f = 3.14f;
		double g= 5.12;
		//논리형
		boolean h = true; // false
		
		//참조자료형
		String i = "Hello"; // 참조자료형 //double형보다도 크다
		String j = "asdsadasdasdasdasdads";
		//i, j 주소를 저장 4byte
		
		System.out.println('c' -35);
		System.out.println('a'-1);  // 97-1
		System.out.println('B'+'C');
		System.out.println("A"+10);
	}
}
