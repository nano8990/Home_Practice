import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ForPractice {
	public static void main(String[] args) {

		System.out.print("전체 학생 수를 입력하세요. ");
		Scanner s = new Scanner(System.in);
		int total_Student = 0;
		while (true) {
			try {
				total_Student = Integer.parseInt(s.nextLine());
				break;
			} catch (NumberFormatException e) {
				s = new Scanner(System.in);
				System.out.println("숫자만 입력해주세요.");
			}
		}
		int score_People;
		double sum_Score = 0;
		int[] score_Student = new int[total_Student];
		int[] rank_Student = new int[total_Student];
		for (int i = 0; i < total_Student; i++) {
			System.out.printf("%d번째 학생의 성적을 입력하세요. ", (i + 1));
			while (true) {
				try {
					score_People = Integer.parseInt(s.nextLine());
					break;
				} catch (NumberFormatException e) {
					s = new Scanner(System.in);
					System.out.println("숫자만 입력해주세요.");
				}
			}
			score_Student[i] = score_People;
			sum_Score += score_Student[i];
		}
		for (int i = 0; i < total_Student; i++) {
			rank_Student[i] = 1;
			for (int j = 0; j < total_Student; j++) {
				if (score_Student[i] < score_Student[j]) {
					rank_Student[i]++;
				}
			}
		}
		System.out.println("\r\n전체 학생의 성적 총합 : " + sum_Score);
		System.out.println("성적 평균 : " + (sum_Score / total_Student));
		Arrays.sort(score_Student);
		Arrays.sort(rank_Student);
		for (int i = 0; i<total_Student;i++) {
			System.out.print(rank_Student[i] + "등 : ");
			System.out.println(score_Student[total_Student-i-1]+"점");
			
		}
	}

}