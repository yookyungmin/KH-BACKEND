import java.util.ArrayList;

public class Manager {
	//데이터를 저장 관리
	private ArrayList<Player> play = new ArrayList();

	public void addPlayer(Player p) {  //선수추가
		play.add(p);
	}

	public ArrayList<Player> getPlayers(){  //선수 출력
		return play;
	}

	public ArrayList<Player> searchName(String name){  //선수정보검색
		ArrayList<Player> resulttt = new ArrayList();
		for(Player p:play) {
			if(p.getName().equals(name)){
				resulttt.add(p);
			}// 검색하고자 하는 이름이 선수와 같다면 찾아내고 result 배열에 저장
		}
		return resulttt;

	}
	

	public void delPlayer(String name) { //삭제 메서드
		for(Player p: play) {
			if(p.getName().equals(name)) {
				play.remove(p);
				break; //브레이크로 나가면 에러x
			}
		}
	}
	public void updatePlayer(Player ps) { //수정
		for(Player p: play ) {
			if(p.getName().equals(ps.getName())){{
				p.setDivision(ps.getDivision());
				p.setAge(ps.getAge());
				p.setPosition(ps.getPosition());
				p.setFee(ps.getFee());
				break;
			}
			}
		}
	}
}
