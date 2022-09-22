import java.util.ArrayList;
import java.util.Scanner;

//model 데이터를 저장 처리 하는공간
public class Manager {
	private ArrayList<Student> members = new ArrayList();

	public void addMember(Student m) { // 학생 등록
		members.add(m); 
	}

	public ArrayList<Student> getMembers() { // 학생 출력
		return members;
	}

	public ArrayList<Student> getSerachName() {  //검색
		return members;
	}

	public void delStudent(int delId) {   //삭제 

//		for (int i = 0; i < members.size(); i++) {
//		
//			if (members.get(i).getId() == delId) {
//				members.remove(i);
//				break;
//			}
//		}  //내가 짠 삭제 코드
		for(Student std : members) {
			if(std.getId()==delId) {
				members.remove(std);
				break;
			} //강사님 코드
		}
		
	}
	
	public void correcStudent(Student s) { //수정
		for(Student std : members) {
			if(std.getGra()==s.getGra()) {
				if(std.getId()==s.getId()) {
				std.setKor(s.getKor());
				std.setEng(s.getEng());
				std.setMath(s.getMath());
				break;
				}
				
			}
		}
		
	}
	
}
