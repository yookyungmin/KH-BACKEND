import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Temp {

	public static void main(String[] args) throws Exception {
	
		//epch time- 1970년 1월 1일 0시  부터 현재까지 흐른시간을 초값으로(또는 밀리초) 표현한 값
		System.out.println(System.currentTimeMillis());  //timestamp
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //timestamp의 값을 사람이 알아볼수 있는 시간으로 변환
		String date = sdf.format(System.currentTimeMillis());
		System.out.println(date);
	
		Date result= sdf.parse("1990/12/25 14:00:00");
		System.out.println("1990/12/25 14:00:00 시간의 timestamp 값:");
		System.out.println(result.getTime());
		
		System.out.println(sdf.format(result.getTime())); 
	}

}
