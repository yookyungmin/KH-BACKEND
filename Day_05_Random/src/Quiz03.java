import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.plaf.synth.SynthScrollPaneUI;

public class Quiz03 {

	public static void main(String[] args) {
	//가위바위보 가위1 바위2 보3 
		
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
		System.out.println("====가위 바위 보 게임=====");
		System.out.print("숫자를 선택하세요(1. 가위/2.바위/3.보/4.종료)==>");
		int com = (int)((Math.random()*3)+1); // 1~3 가위 바위 보
		int user = Integer.parseInt(sc.nextLine());
		
		
		if(user==1) {
			System.out.println("=======결과=======");
			System.out.println("당신은 가위를 냈습니다");
			if(com==1) {
				
				System.out.println("컴퓨터는 가위를 냈습니다");
				System.out.println("===========");
				System.out.println("플레이어랑 비겼습니다");
			}else if(com==2) {
				System.out.println("컴퓨터가 바위를 냈습니다");
				System.out.println("==========");
				System.out.println("플레이어가 졌습니다");
			}else {
				System.out.println("컴퓨터가 보를 냈습니다");
				System.out.println("==========");
				System.out.println("플레이어가 이겼습니다");
			}
		}
			if(user ==2) {
				System.out.println("=========결과========");
				System.out.println("당신은 바위를 냈습니다");
				if(com==2) {
					System.out.println("컴퓨터가 바위를 냈습니다");
					System.out.println("=============");
					System.out.println("플레이어랑 비겼습니다");
				}else if(com==1) {
					System.out.println("컴퓨터가 가위를 냈습니다");
					System.out.println("=================");
					System.out.println("플레이어가 이겼습니다");
				}else {
					System.out.println("컴퓨터가 보를 냈습니다");
					System.out.println("==================");
					System.out.println("플레이가 졌습니다");
				}
			}
			if(user==3) {
				System.out.println("=========결과========");
				System.out.println("당신은 보를 냈습니다");
				if(com==1) {
					System.out.println("컴퓨터가 가위를 냈습니다");
					System.out.println("================");
					System.out.println("플레이어가 졌습니다");
				}else if(com==2) {
					System.out.println("컴퓨터가 바위를 냈습니다");
					System.out.println("============");
					System.out.println("플레이어가 이겼습니다");
				}
					else {
						System.out.println("컴퓨터가 보를 냈습니다");
						System.out.println("=====================");
						System.out.println("플레이어랑 비겼습니다");
					}
				
			}else if(user==4) {
				System.out.println("게임을 종료하였습니다");
				break;
			}
			else {
				System.out.println("메뉴를 다시 입력해주세요");
			}
			
		}//while문의끝
	} 
	}
