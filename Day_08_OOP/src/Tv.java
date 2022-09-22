
public class Tv {
		private int volume;
		private int channel;
		//private final Tv this;
		
		
		public Tv getThis() {
			return this;
		} // 자기자신 final이기떄문에 setter는 못만듬
		public int getVolume() {
			return volume;
		}
		public void setVolume(int volume) {
			this.volume = volume;
		}
		public int getChannel() {
			return channel;
		}
		public void setChannel(int channel) {
			this.channel = channel;
		}
		
		
		// alt + shift +s r (alt+a) (alt+r) 게터세터단축키
		
		//정보은닉
		//
		//public, /protected /pacakge 
		// private -같은 클래스 안에서만 ,, 
		// 사용자 입장 : 가져다가 쓰는 사람이 볼필요 없는 정보를 가려줌
		//개발자 입장 : 클래스(설계도) 안정성을 높일수 있다
		
		//지역변수는 스택메모리에 저장
		//멤버변수는 힙메모리에
		//this. 멤버변수와 지역변수의 구분하기 위해 사용
		
		//멤버변수에 private를 지정하면 다른 클래스에서 접근이 불가한데
		// 접근하기 위해서 게터 세터 메서들 사용, this. 을 사용하여 멤버변수와 지역변수를 구분
}