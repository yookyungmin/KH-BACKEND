
public class Exam_05 {

	public static void main(String[] args) {
		
//		
//		//1~5난수
//		System.out.println((int)((Math.random()*5)+1));
//		//1~5난수
//		System.out.println((int)((Math.random()*5)+1));
//		//1~5난수
//		System.out.println((int)((Math.random()*5)+1));
		
		
		int[] card = new int[] {1, 2,3,4,5};
		
		for(int i = 0; i<card.length*1; i++) {
			
			
			int x = (int)(Math.random()*5);
			int y = (int)(Math.random()*5);
			
			int tmp = card[x];
			card[x]=card[y];
			card[y]=tmp;
			
		}
		
		
		System.out.println(card[0]+":"+card[1]+":"+card[2]);
	
	}

}
