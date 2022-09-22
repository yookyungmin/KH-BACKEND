
public class Quiz01 {

	public static void main(String[] args) {
		
		//구하려는 난수 최댓값 Y
		//구하려는 난수 최솟값 X
		// (Y-X+1)+X
		
		//사용자가 원하는 랜덤범위의 값추출(10분)
		
		System.out.print("0~9 까지의 랜덤수=>");
		int ran =(int)((Math.random()*10));
		System.out.println(ran);
		
		System.out.print("1~10 까지의 랜덤 수=>");
		int ran1 =(int)((Math.random()*10)+1);
		System.out.println(ran1);
		
		System.out.print("20~35 까지의 랜덤수=>");
		int ran2= (int)((Math.random()*16)+20);
		System.out.println(ran2);
		
		System.out.print("0 또는 1=>");
		int ran3  =(int)((Math.random()*2));
		System.out.println(ran3);
		
	}

}
