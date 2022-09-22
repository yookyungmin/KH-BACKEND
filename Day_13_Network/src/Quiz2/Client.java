package Quiz2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
   public static void main(String[] args) throws Exception{
      
      Socket client = new Socket("192.168.150.28", 23000);  //연결 담당 소켓
      
      InputStream is = client.getInputStream();
      OutputStream os = client.getOutputStream();

      
      DataOutputStream dos = new DataOutputStream(client.getOutputStream());
      //출력
      DataInputStream dis = new DataInputStream(client.getInputStream());
      //입력
      dos.writeUTF(JOptionPane.showInputDialog("nnnnnnnn")); 
      dos.flush();
      
      dos.writeUTF(JOptionPane.showInputDialog("password :")); 
      dos.flush();
      //버퍼를 비워주는 메서드
    
      String result = dis.readUTF();
      System.out.println(result);
    
     
      
   }
}