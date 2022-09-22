import java.io.File;
import java.io.IOException;
import java.security.ProtectionDomain;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.plaf.synth.SynthScrollPaneUI;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

public class Quiz01 {

	public static void main(String[] args) throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException {

		String ip="192.168.150.11";
		int port=21;
		FTPClient client = new FTPClient();
		String uname="java";
		String pwd="0111";

		//File file = new File("d:/downloadfol/다운성공.txt");
		//client.download("secret.jpg", new File("d:/downloadfol/test3.jpg"));

		Scanner sc = new Scanner(System.in);
		String iip; //입력ip
		int iport; ///입력 포트

		while(true) {
			System.out.println("FTP CLIENT Program");
			System.out.println("1.Connect FTP SERVER");
			System.out.println("2.Exit Program");
			System.out.print(">>>");
			int input = Integer.parseInt(sc.nextLine());

			if(input==1) {
				System.out.println("input url");
				System.out.print(">>> ");
				iip = sc.nextLine();
				System.out.println("input port");
				System.out.print(">>>>");
				iport = Integer.parseInt(sc.nextLine());

				if(iip.equals(ip)&&iport==port) {

					client.connect(ip, port);  //ip port 연결

					System.out.println("FTP SERVER IS CONNECTED");
					System.out.println("input id:");
					String iuname = sc.nextLine();
					System.out.println("input password:");
					String ipwd = sc.nextLine();

					if(iuname.equals(uname)&&ipwd.equals(pwd)) {
						client.login(uname, pwd); //id, pwd 연결
						System.out.println("Login success");
						System.out.println("1.Upload File");
						System.out.println("2.Dowload File");
						System.out.println("3.Disconnect FTP SERVER");
						System.out.println("4.Delete File");
					}


				}else {
					System.out.println("url이 틀렸씁니다");
				}
			}
		}

	}

}
