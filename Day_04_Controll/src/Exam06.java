
public class Exam06 {

	public static void main(String[] args) {


		for(int i = 0; i<=10; i++) {
			if(i==2 || i==5) {continue;}
			System.out.println("i="+i);
			if(i==8) {
				break;
			}  //0134678 // 8까지출력되고 break;
		}
	}

}

