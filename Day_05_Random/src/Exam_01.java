
public class Exam_01 {

	public static void main(String[] args) {
		//구하려는 난수 최댓값y 53
		//구하려는 난 최솟값  x 37
		//((Y-x+1)+x)
		
		for(int i=0; i <100; i++) {
			double rand = (Math.random()*17)+37; //double형으로 나타남 0~1사이에 임의의 난수
			int a = (int)((Math.random()*17)+37);
			
			System.out.println((int)rand);
			System.out.print(a);
			//System.out.println((int)(rand*(53-37+1)+37));
		}
			
			

			

	}

}
