import java.util.Scanner;

public class Scanner_Close2 {
	public static void main(String[] args) {	
		Scanner k = new Scanner(System.in);
		int age = k.nextInt();
		System.out.println(age);
		k.close();

}
}
