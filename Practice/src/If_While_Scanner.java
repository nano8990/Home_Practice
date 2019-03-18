import java.util.Random;
import java.util.Scanner;

public class If_While_Scanner {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("당신은 컴퓨터와 가위바위보 3판 2선승제를 실시할 것입니다.");
		int userPoint = 0;			// 유저의 승점 카운트
		int computerPoint = 0;		// 컴퓨터의 승점 카운트
		int roundCount = 1;			// 현재 몇 번째 대결인지 안내
		int tieCount = 0;			// 무승부 카운트
		int userValue = 0;			// 가위, 바위, 보를 각각 0, 1, 2에 대입하여 계산하기 위한 장치
		String foulGame = "";		// 반칙 여부 확인
		
		while ((userPoint < 2) && (computerPoint < 2)) {						// 유저와 컴퓨터의 승점 카운트가 2보다 작은 동안 반복
			if (tieCount == 0) {												// 무승부가 아닐 경우
				System.out.printf("%d번째 대결 시작! ", roundCount);						// 대결 시작 메시지를 출력
				if (roundCount >= 2) {												// 2라운드 이상의 경우
					System.out.printf("현재 %d승 %d패", userPoint, computerPoint);		// 스코어 확인
				}
			} else {															// 무승부일 경우
				System.out.print("재경기 시작!");										// 재경기 시작 메시지를 출력
				tieCount--;															// 무승부 카운트 초기화
			}
			System.out.println("\r\nrock, paper, scissors 중 하나를 입력하십시오.");
			Scanner s = new Scanner(System.in);									// 변수 s에 스캐너 지정
			String userEnter = s.nextLine();									// 변수 userEnter에 입력되는 문자를 대입
			System.out.print("\r\n가위! ");										// 가위! 바위! 보! 메시지를 1초 간격으로 출력
			Thread.sleep(1000);
			System.out.print("바위! ");
			Thread.sleep(1000);
			System.out.println("보!\r\n");
			switch (userEnter) {												// 유저가 입력한 값이
			case "scissors":														// 가위일 경우
				userValue = 0;														// 유저값을 0으로 설정
				System.out.print("당신의 선택은 가위!");
				break;
			case "rock":															// 바위일 경우
				userValue = 1;														// 유저값을 1로 설정
				System.out.print("당신의 선택은 바위!");
				break;
			case "paper":															// 보일 경우
				userValue = 2;														// 유저값을 2로 설정
				System.out.print("당신의 선택은 보!");
				break;
			case "":																// 아무 것도 입력하지 않았을 경우
				foulGame = "nothing";												// 반칙여부에 nothing 대입
				System.out.print("당신은 아무 것도 내지 않았다!");	
				break;
			default:																// 이외의 값을 입력했을 경우
				foulGame = "strange";												// 반칙여부에 strange 대입
				System.out.print("당신은 아무도 알아볼 수 없는 이상한 모양을 냈다!");
				break;
			}
			Thread.sleep(1000);
			Random r = new Random();											// 변수 r에 랜덤 지정
			int computerEnter = r.nextInt(3);									// computerEnter 변수에 0이상 3미만의 정수 대입
			switch (computerEnter) {											// 컴퓨터가 입력한 값이
			case 0:																	// 0(가위)일 경우
				System.out.println(" / 상대방의 선택은 가위!");
				break;
			case 1:																	// 1(바위)일 경우
				System.out.println(" / 상대방의 선택은 바위!");
				break;
			case 2:																	// 2(보)일 경우
				System.out.println(" / 상대방의 선택은 보!");
				break;
			}
			Thread.sleep(1000);
			int resultGame = userValue - computerEnter;							// 유저값과 컴퓨터 입력값의 차이를 비교하여 승패 도출
			if (foulGame.equals("strange")) {									// 반칙여부가 확인될 경우
				System.out.println("반칙패!\r\n");									// 반칙패 메시지 출력
				computerPoint++;													// 컴퓨터의 승리로 처리
				roundCount++;														// 라운드 증가
				foulGame = "";														// 반칙여부 초기화
			} else if (foulGame.equals("nothing")) {							// 반칙여부가 확인될 경우
				System.out.println("안 내면 진 거!!\r\n");								// 반칙패 메시지 출력
				computerPoint++;													// 컴퓨터의 승리로 처리
				roundCount++;														// 라운드 증가
				foulGame = "";														// 반칙여부 초기화
			} else if (resultGame == 0) {										// 같은 값이 나와서 무승부일 경우
				System.out.println("무승부!\r\n");									// 무승부 메시지 츌력
				tieCount++;															// 무승부 카운트 증가
			} else if ((resultGame == 1) || (resultGame == -2)) {				// 승리의 경우 수가 나올 경우
				System.out.println("승리!\r\n");										// 승리 메시지 출력
				userPoint++;														// 유저 승점 증가
				roundCount++;														// 라운드 증가
			} else if ((resultGame == -1) || (resultGame == 2)) {				// 패배의 경우 수가 나올 경우
				System.out.println("패배!\r\n");										// 패배 메시지 출력
				computerPoint++;													// 컴퓨터 승점 증가
				roundCount++;														// 라운드 증가
			}
			Thread.sleep(1000);
		}																		// 반복문 끝
		System.out.println("승부 종료!\r\n");
		Thread.sleep(1000);
		System.out.print("정산중");												// 정산중 메시지를 띄우고 1초마다 .을 찍음
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}
		Thread.sleep(1000);
		System.out.printf("\r\n\r\n%d승 %d패로 당신이 ", userPoint, computerPoint);
		if (userPoint >= 2) {													// 승패 여부에 따라 메시지 차등 출력
			System.out.println("이겼습니다!");
		} else {
			System.out.println("졌습니다.");
		}
	}
}