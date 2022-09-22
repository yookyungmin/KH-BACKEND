package Quiz2;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(23000);
		
		while(true) {
		Socket client = server.accept();
		System.out.println(client.getInetAddress()+"로 부터 연결");
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		String msg = dis.readUTF();
		System.out.println(client.getInetAddress() +"님의 메시지"+msg);
		}
	}
}
