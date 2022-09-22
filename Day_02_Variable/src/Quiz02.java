
public class Quiz02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//형변환이 필요없는것은?
		
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		
		
		
		b= (byte)i;
		ch= (char)b;
		short s = (short)ch;
		float f= (float)l;  //형변환 필요 없음
		i = (int)ch;  //형변환 필요없으  
	}

}
