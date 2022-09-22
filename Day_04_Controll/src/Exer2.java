import java.util.Scanner;



public class Exer2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		

		//int ans1;

		System.out.println("친구들이 말하는 나는?");

		System.out.println("1.활발하다./2.소극적이다.");

		System.out.println(">>");

		int ans1 = Integer.parseInt(sc.nextLine());

		//ans1 = sc.nextInt();

		

		if(ans1==1) {

			System.out.println("당신의 MBTI 첫번째는 E 입니다.");

		}else if(ans1==2){

			System.out.println("당신의 MBTI 첫번쨰는 I 입니다.");

		}else {

			System.out.println("숫자를 잘못입력했습니다.");

		}

		

		

		//int ans2;

		System.out.println("숙제가 많이 생기면 ?");

		System.out.println("1.재빠르게 처리한다./2.미래의 나한테 맡긴다.");

		System.out.println(">>");

		int ans2 = Integer.parseInt(sc.nextLine());

		//ans2 = sc.nextInt();

		if(ans2==1) {

			System.out.println("당신의 MBTI 두번째는 S 입니다.");

		}else if(ans2==2){

			System.out.println("당신의 MBTI 두번쨰는 N 입니다.");

		}else {

			System.out.println("숫자를 잘못입력했습니다.");

		}

		//int ans3;

		System.out.println("친구가 아프면 ?");

		System.out.println("1.왜아픈지 물어본다./2.어떻게하면 낫는지 알려준다.");

		System.out.println(">>");

		int ans3 = Integer.parseInt(sc.nextLine());

		//ans3 = sc.nextInt();

		if(ans3==1) {

			System.out.println("당신의 MBTI 세번째는 F 입니다.");

		}else if(ans3==2){

			System.out.println("당신의 MBTI 세번쨰는 T 입니다.");

		}else {

			System.out.println("숫자를 잘못입력했습니다.");

		

		}System.out.println("여행을 갈때 계획을 성실하게 짠다 ?");

		System.out.println("1.맞다./2.아니다.");

		System.out.println(">>");

		

		int ans4 = Integer.parseInt(sc.nextLine());

		//ans3 = sc.nextInt();

		if(ans4==1) {

			System.out.println("당신의 MBTI 세번째는 J 입니다.");

		}else if(ans4==2){

			System.out.println("당신의 MBTI 세번쨰는 TP 입니다.");

		}else {

			System.out.println("숫자를 잘못입력했습니다.");

	}

}

}