import javax.net.ssl.CertPathTrustManagerParameters;

public class Exam_04 {

	public static void main(String[] args) {
		
		int[] arr = new int[] {10,20};
		System.out.println(arr[0]+ ":"+arr[1]);
		int tmp;
		tmp= arr[0];
		arr[0]= arr[1];
		arr[1]= tmp;
		System.out.println(arr[0]+ ":"+arr[1]);

	}

}
