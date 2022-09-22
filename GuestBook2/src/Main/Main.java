package Main;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import DAO.GuestDao;
import Dto.GuestDTO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		try {
//			Class.forName("oracle.jdbc.drive.OracleDriver");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			System.exit(0);
//		} //DBCP하면 지워야됨


		Scanner sc = new Scanner(System.in);
		GuestDao dao = GuestDao.getInstance(); //싱글톤 패턴 적용 전


		while(true) {
			System.out.println("방명록 프로그램");
			System.out.println("1. 글 남기기");
			System.out.println("2. 글 목록보기");
			System.out.println("3. 글 삭제하기(글 번호로 삭제)");
			System.out.println("4. 글 수정하기(글 번호로 수정)");
			System.out.println("5. 글 검색하기(작성자로 검색)");
			System.out.println("0 프로그램 종료");

			int menu = Integer.parseInt(sc.nextLine());

			if(menu==1) {  //글남기기
				System.out.println("작성자 : ");
				String writer = sc.nextLine();

				System.out.println("메시지 : ");
				String contents = sc.nextLine();

				try {
					int result = dao.insert(new GuestDTO(0, writer, contents, null));
					if(result >0) {
						System.out.println("입력완료");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); // 에러 원인 출력
					System.out.println("문제 발생 관리자 문의 하시오");
				}


			}else if(menu==2) {// 글 목록 모두 출력
				try {
					List<GuestDTO> result = dao.selectAll();
					for(GuestDTO dto : result) {
						System.out.println(dto.getSeq()+"\t"+dto.getWriter()+dto.getContents()+"\t"+dto.getWrite_date());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("문제가 발생하였습니다");
				}

			}else if(menu==3) {  //삭제 글번호  dto 필요x
				System.out.println("삭제할 번호를 입력하세요");
				int delSeq = Integer.parseInt(sc.nextLine());

				try {
					if(dao.isSeqExist(delSeq)) {  //존재여부 확인 후 로직 진행
						int result = dao.delete(delSeq);
						if(result>0) {
							System.out.println("삭제 완료");
						}else {
							System.out.println("삭제 대상이 존재 하지 않습니다");
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생했습니다 관리자에게 문의하세요");
				}

			}else if(menu==4) { // 수정
				System.out.println("수정할 글의 번호 : ");
				int upseq = Integer.parseInt(sc.nextLine());

				try {
					if(dao.isSeqExist(upseq)){
						System.out.println("수정할 작성자");
						String writer = sc.nextLine();

						System.out.println("수정할 메시지");
						String contents = sc.nextLine();

						int result = dao.update(new GuestDTO(upseq, writer, contents, null));
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생하였습니다");
				}



			}else if(menu==5) { //검색
				System.out.println("검색할 작성자 입력");
				String swriter = sc.nextLine();
				
				
				try {
				if(dao.isWriterExist(swriter)){
				dao.serach(swriter);
				}else {
					System.out.println("검색한 작성자가 없습니다");
				}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("문제가 발생하였습니다");
				}
				
				
				

			}else if(menu==0) {
				System.out.println("종료 하였습니다");
				System.exit(0);
			}else {
				System.out.println("메뉴를 다시 입력 해주세요");
			}
		}



	}

}
