

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception {



		DataInputStream dis=null;
		DataOutputStream dos=null;

		try {  
			Socket client = new Socket("localhost", 25000);
			InputStream is = client.getInputStream();
			dis = new DataInputStream(is);

			OutputStream ds = client.getOutputStream();
			dos = new DataOutputStream(ds);   //try with resource () 안에 넣어줄 문장 close할 객체

			while (true) {
				dos.writeUTF(JOptionPane.showInputDialog("전송할 메세지를 입력해주세요"));
				dos.flush();

				System.out.println("결과 : " + dis.readUTF());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("서버와의 연결이 해제 되었습니다");
			try {
			dis.close();
			dos.close();
			}catch (Exception e2) {
				e.printStackTrace();
			}
			}
	}
}
//try() {} catch{}  //()안에 close가 필요한 자원들을 넣는것 try with resources
//try with resource 이후에 finally를 안쓰게됨