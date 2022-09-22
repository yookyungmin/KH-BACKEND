
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Server {
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(25000);

		System.out.println("클라이언트의 연결을 대기 중입니다..");
		Socket sock = server.accept();

		System.out.println(sock.getInetAddress() + " 로 부터 연결 확인!");

		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = sock.getInputStream();
		String[] str = new String[] {
				"이 세상에 열정없이 이루어진 위대한것은 없다",
				"작은 기회로부터 종종 위대한 업적이 시작된다",
				"성공이란 열정을 잃지 않고 실패를 거듭할 수 있는 능력이다."
		};
		DataInputStream dis = new DataInputStream(is);
		int[] lottoNum= new int[45];
		for(int i = 0; i<lottoNum.length; i++) {
			lottoNum[i]=i+1;
		}
		while (true) {
			if (dis.readUTF().equals("date")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String date = sdf.format(System.currentTimeMillis());
				dos.writeUTF(date);
				dos.flush();
			} else if(dis.readUTF().equals("wiseword")){

				dos.writeUTF(str[(int)(Math.random()*3)]);
				//				System.out.println(str[rand.nextInt(3)]);
				dos.flush();


			}else if(dis.readUTF().equals("lotto")){
				for(int i = 0; i<lottoNum.length*10; i++) {
					int x= (int)(Math.random()*45);
					int y= (int)(Math.random()*45);
					int tmp = lottoNum[x];
					lottoNum[x]=lottoNum[y];
					lottoNum[y]=tmp;
				}
				dos.writeUTF(lottoNum[0]+" "+lottoNum[1]+" "+lottoNum[2]+" "+lottoNum[3]+" "+lottoNum[4]+" "+lottoNum[5]);
				dos.flush();
			}else {
				dos.writeUTF("그런 명령은 없습니다.");
				dos.flush();
			}


		}
	}
}