import java.util.Scanner;

public class Netflix {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		Movie[] m = new Movie[2];
		int count =0;
		
		while(true) {
			System.out.println("1.신규영화 등록");
			System.out.println("2.영화목록 출력");
			System.out.println("3.영화 검색(제목으로 검색)");
			System.out.println("4.프로그램 종료");
			System.out.println("선택====>");
			
			int menu = Integer.parseInt(sc.nextLine());
			
			if(menu==1) {
						System.out.print("영화 이름을 입력하세요=>");
						String name = sc.nextLine();
						System.out.print("장르를 입력하세요=>");
						String genre = sc.nextLine();
						System.out.print("평점을 입력하세요=>");
						double score = Double.parseDouble(sc.nextLine());
						m[count]= new Movie(name, genre, score);
						System.out.println("등록 되었습니다");
						count++;
			}else if(menu==2) {
				if(count ==0) {
					System.out.println("출력할 내용이 없습니다");
				}else {
					for(int i=0; i<count; i++) {
						System.out.println("제목\t장르\t평점");
					System.out.println(m[i].getName()+"\t"+m[i].getGenre()+"\t"+m[i].getScore());
					}
				}
			}else if(menu==3) {  
				if(count>0) {
				System.out.println("검색할 영화를 입력하세요");
				String mname = sc.nextLine();
				for(int i=0; i<count;i++) {
					if(m[i].getName().equals(mname)) { //contains를 쓰면 포함한단어나옴
						System.out.println("제목\t장르\t평점");
						System.out.println(m[i].getName()+"\t"+m[i].getGenre()+"\t"+m[i].getScore());
					}else {
						System.out.println("검색 된 정보가 없습니다");
					}
				}
				}else {
						System.out.println("등록되어 있는 영화가 없습니다");
					}
				
				
				
			}else if(menu==4){
				System.out.println("프로그램 종료");
				System.exit(0);
			}else {
				System.out.println("1~4번 제대로입력하세요");
			}
		}
	}

}
