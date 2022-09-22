import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

//model
public class Manager2 {
	private ArrayList<Student> members = new ArrayList();

	public void addMember(Student m) { // 학생 등록
		members.add(m);
	}

	public ArrayList<Student> getMembers() { // 학생 출력
		return members;
	}

	public ArrayList<Student> searchName(String name) { //검색기능
		
		ArrayList<Student> result = new ArrayList<>();
		for(Student m : members) {
			if(m.getName().equals(name)) {  //검색하고자 하는 이름이 index학생의 이름과 같다면
				//찾아낸 학생을 result 배열에 저장하는코드
				result.add(m);
			}
		}
		return result;
	}

	public void delStudent(int id) { //삭제

		for(Student std : members) { //향상된for문
			
			if(std.getId()==id) {
				members.remove(std);
				break; //브레이크로 나가면 에러x
			}
		}
//		for(int i = 0; i<members.size(); i++) { //for문 삭제
//			if(members.get(i).getId()==id) {
//				members.remove(i);
//			}
//		}
	}
	
	public void updateById(Student s) { //수정
		for(Student std: members) {
			if(std.getId()==s.getId()){
				std.setKor(s.getKor());
				std.setEng(s.getEng());
				std.setMath(s.getMath());
				break;
			}
		}
	}
	
}
