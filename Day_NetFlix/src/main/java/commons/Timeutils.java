package commons;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timeutils {
	public  static Timestamp stringToTimestamp(String dateString) {
		
		Timestamp launch_date = null;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 try{
		 Date temp_date = sdf.parse(date); // 포맷 = 타임스탬프 형식을 날자 형식으로  ,, 2022-10-13 형식을-> parse timestamp로
		 Timestamp launch_date =new Timestamp(temp_date.getTime()); //타임스탬프 값을 long형으로
		 }catch(ParseException e1){
		 		e1.printStackTrace();
		 } 
		 		 */   //자바에서 날짜입력넣기
	}
}
