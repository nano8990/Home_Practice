import java.util.Random;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 4000000; i++) {
			int userChoice = r.nextInt(6) + 1;
			int comChoice = r.nextInt(6) + 1;
			System.out.println("컴퓨터의 주사위는 " + comChoice + "입니다.");
			System.out.println("Enter를 눌러주세요");
			String dice = scan.nextLine();
			if (userChoice == comChoice) {
				System.out.println("무승부");
			} else if (userChoice > comChoice) {
				System.out.println("승리");
			} else if (comChoice > userChoice) {
				System.out.println("패배");
			}
		}
	}
}