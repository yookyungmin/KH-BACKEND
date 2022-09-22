import java.io.File;
import java.io.IOException;
import java.security.ProtectionDomain;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

import javax.sound.midi.MidiChannel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.plaf.synth.SynthScrollPaneUI;
import javax.xml.validation.SchemaFactoryConfigurationError;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

public class Quiz02 {

	public static void main(String[] args) throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException, FTPListParseException {


		FTPClient client = new FTPClient();

		//192.168.150.11
		//File file = new File("d:/downloadfol/다운성공.txt");
		//client.download("secret.jpg", new File("d:/downloadfol/test3.jpg"));

		Scanner sc = new Scanner(System.in);

		while(true) {
			String ip="";
			int port;
			System.out.println("FTP CLIENT Program");
			System.out.println("1.Connect FTP SERVER");
			System.out.println("2.Exit Program");
			System.out.print(">>>");
			int input = Integer.parseInt(sc.nextLine());

			if(input==1) {
				a:while(true) {

					try {
						System.out.println("input url");
						System.out.print(">>> ");
						ip = sc.nextLine();
					}
					catch (Exception e) {
						System.out.println("다시 입력해주세요");
						continue;
					}
					while(true) {
						try {
							System.out.println("input port");
							System.out.print(">>>>");
							port = Integer.parseInt(sc.nextLine());
							break a; // url port 다 맞다면 abc:while벗어나기
						}catch (Exception e) {
							System.out.println("다시 입력해주세요");
						}
					}
				}
				client.connect(ip, port);
				System.out.println("FTP SERVER IS CONNECTED");
				while(true) {
					System.out.println("input id:");
					String id = sc.nextLine();
					System.out.println("input password:");
					String pwd = sc.nextLine();
					try {
						client.login(id, pwd);
						break;
					}catch (Exception e) {
						System.out.println("id와 pwd다시 확인해주세요");
						continue;
					}

				}
				b:while(true) {
					System.out.println("Login success");
					System.out.println("1.Upload File");
					System.out.println("2.Dowload File");
					System.out.println("3.Disconnect FTP SERVER");
					System.out.println("4.Delete File");
					int menu2 = Integer.parseInt(sc.nextLine());
					if(menu2==1) {
						while(true) {
							System.out.println("업로드 파일명 입력해주세요");
							String upfile = sc.nextLine();
							try {
								client.upload(new java.io.File(upfile));
								System.out.println("파일 업로드에 성공하셨씁니다");
								break b; //성공하면 b:while문 나가기
							}catch (Exception e) {
								System.out.println("파일 이름을 다시 확인해주세요");
							}
						}
					} else if(menu2 == 2) {
						System.out.println("다음 목록 중 선택하세요");
						for(int i = 0; i<client.listNames().length; i++) {
							System.out.println(client.listNames()[i]+"\t");
							String sfile = sc.nextLine(); //파일 선택
							System.out.println("다운로드 받을 경로를 입력해주세요");
							String place = sc.nextLine();
							try {
								client.download(sfile, new File(place));
								break b; //성공하면 b:while문 나가기
							}catch (Exception e) {
								System.out.println("파일 이름과 경로 다시 입력해주세요");
							}
						}
					}else if(menu2==3) {
						System.out.println("프로그램을 종료합니다");
						System.exit(0);
					}else {
						System.out.println("번호를 다시 확인해주세요");
					}

				}



			}else if(input==2) {
				System.out.println("시스템 종료");
				System.exit(0);
			}else {
				System.out.println("번호를 다시 확인해주세요");
			}
		}
	}

}


//				if(iip.equals(ip)&&iport==port) {
//
//					client.connect(ip, port);  //ip port 연결
//
//					System.out.println("FTP SERVER IS CONNECTED");
//					System.out.println("input id:");
//					String iuname = sc.nextLine();
//					String ipwd = sc.nextLine();
//
//					if(iuname.equals(uname)&&ipwd.equals(pwd)) {
//						client.login(uname, pwd); //id, pwd 연결
//						System.out.println("Login success");
//						System.out.println("1.Upload File");
//						System.out.println("2.Dowload File");
//						System.out.println("3.Disconnect FTP SERVER");
//						System.out.println("4.Delete File");
//					}
//
//
//				}else {
//					System.out.println("url이 틀렸씁니다");