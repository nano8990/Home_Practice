import java.util.Random;
import java.util.Scanner;

public class If_While_Scanner2 {
	public static void main(String[] args) throws InterruptedException {
		// 유저 세팅값 설정
		int playOff = 4;				// 승리 조건
		double insistProbability = 60;	// 우기기 확률(%)
		// 변수 선언
		System.out.printf("당신은 컴퓨터와 가위바위보 %d판 %d선승제를 실시할 것입니다.", (2 * playOff) - 1, playOff);
		int userPoint = 0;				// 유저의 승점 카운트
		int computerPoint = 0;			// 컴퓨터의 승점 카운트
		int roundCount = 1;				// 현재 몇 번째 대결인지 안내
		int tieCount = 0;				// 무승부 카운트
		int userValue = 0;				// 가위, 바위, 보를 각각 0, 1, 2에 대입하여 계산하기 위한 장치
		String foulGame = "";			// 반칙 여부 확인
		double insistProbability2 = insistProbability;
		double randomWin = 0;				// 우기기 발동 시 승리 변수
		double randomTie = 0;				// 우기기 발동 시 무승부 변수
		int randomCount = 0;			// 우기기 발동 여부 기록
		if (playOff < 1) {				// 유저 세팅값에서 승리 조건 오류 조정
			playOff = 1;
		}
		// 가위바위보 게임 시작
		while ((userPoint < playOff) && (computerPoint < playOff)) {			// 유저와 컴퓨터의 승점 카운트가 2보다 작은 동안 반복
			if (tieCount == 0) {												// 무승부가 아닐 경우
				System.out.printf("\r\n%d번째 대결 시작!", roundCount);				// 대결 시작 메시지를 출력
			} else {															// 무승부일 경우
				System.out.print("\r\n재경기 시작!");									// 재경기 시작 메시지를 출력
				tieCount--;															// 무승부 카운트 초기화
			}
			if (roundCount >= 2) {												// 라운드가 진행되었을 경우
				System.out.printf(" 현재 %d승 %d패", userPoint, computerPoint);			// 현재 스코어 안내
			}
			System.out.println("\r\nrock, paper, scissors 중 하나를 입력하십시오.");
			Scanner s = new Scanner(System.in);									// s에 시스템에 입력되는 스캐너를 지정
			String userEnter = s.nextLine();									// userEnter에 입력되는 문자를 대입 (nextLine을 해야 공백 인식)
			System.out.print("\r\n안");
			Thread.sleep(400);
			System.out.print(" 내");
			Thread.sleep(200);
			System.out.print("면");
			Thread.sleep(200);
			System.out.print(" 진");
			Thread.sleep(400);
			System.out.print(" 거");
			Thread.sleep(400);
			System.out.print(" 가위!");
			Thread.sleep(400);
			System.out.print(" 바위!");
			Thread.sleep(400);
			System.out.println(" 보!");
			Thread.sleep(1000);
			System.out.println("");
			switch (userEnter) {											// 유저가 입력한 값이
			case "가위":													// 가위일 경우
				userValue = 0;													// 유저값을 0으로 설정
				System.out.print("당신의 선택은 \"가위\"!");
				break;
			case "rock":														// 바위일 경우
				userValue = 1;													// 유저값을 1로 설정
				System.out.print("당신의 선택은 \"바위\"!");
				break;
			case "paper":														// 보일 경우
				userValue = 2;													// 유저값을 2로 설정
				System.out.print("당신의 선택은 \"보\"!");
				break;
			case "":														// 아무 것도 입력하지 않았을 경우
				foulGame = "nothing";											// 반칙여부에 nothing 대입
				System.out.print("당신은 아무 것도 내지 않았다!");	
				break;
			default:														// 이외의 값을 입력했을 경우
				foulGame = "strange";											// 반칙여부에 strange 대입
				System.out.print("당신은 아무도 알아볼 수 없는 이상한 모양을 냈다!");
				break;
			}
			Random r = new Random();										// 변수 r에 랜덤 지정
			int computerEnter = r.nextInt(3);								// computerEnter 변수에 0이상 3미만의 정수 대입 [0(가위), 1(바위), 2(보)]
			System.out.print(" / 상대방의 선택은 ");
			switch (computerEnter) {										// 컴퓨터가 입력한 값이
			case 0:																// 0(가위)일 경우
				System.out.println("\"가위\"!");
				break;
			case 1:																// 1(바위)일 경우
				System.out.println("\"바위\"!");
				break;
			case 2:																// 2(보)일 경우
				System.out.println("\"보\"!");
				break;
			}
			Thread.sleep(1000);
			int resultGame = userValue - computerEnter;						// 유저값과 컴퓨터 입력값의 차이를 비교하여 승패 도출
			if (foulGame.equals("strange")) {								// 반칙여부가 확인될 경우
				while (foulGame.equals("strange")) {
					Random r2 = new Random();									// 변수 r2(자신의 우기기 여부)에 랜덤 지정
					randomWin = r2.nextInt(100);								// randomWin에 0 이상 100 미만의 정수 대입
					if (randomWin <= insistProbability2 - 1) {					// 우기기 확률 만큼 우기기 발동
						randomCount++;
						System.out.println("그러자!");
						Thread.sleep(1000);
						System.out.print("당신은 사실 ");
						switch (computerEnter) {							// 상대방의 경우의 수에 따라 자신이 이기는 결과로 우기기
						case 0:
							System.out.print("\"바위\"");
							userValue = 1;
							break;
						case 1:
							System.out.print("\"보\"");
							userValue = 2;
							break;
						case 2:
							System.out.print("\"가위\"");
							userValue = 0;
							break;
						}
						insistProbability2 -= 5;								// 우기기가 진행됨에 따라 5%씩 우기기 확률 감소
						System.out.println("를 냈다고 우기기 시작하였다!");
						Thread.sleep(1000);
						Random r3 = new Random();								// 변수 r3(상대방의 우기기 여부)에 랜덤 지정
						randomWin = r3.nextInt(100);							// randomWin에 0 이상 100 미만의 정수 대입
						if (randomWin <= insistProbability2 - 1) {			// 우기기 확률 만큼 우기기 발동
							System.out.println("그러나!");
							Thread.sleep(1000);
							System.out.print("상대방도 자신이 ");
							switch (userValue) {								// 자신의 경우의 수에 따라 상대방이 이기는 결과로 우기기
							case 0:
								System.out.print("\"바위\"");
								computerEnter = 1;
								break;
							case 1:
								System.out.print("\"보\"");
								computerEnter = 2;
								break;
							case 2:
								System.out.print("\"가위\"");
								computerEnter = 0;
								break;
							}
							insistProbability2 -= 5;
							System.out.println("를 냈다고 우기기 시작하였다!");
							Thread.sleep(1000);
						} else {											// 상대방의 우기기가 발동되지 않았을 경우
							Random r4 = new Random();							// 변수 r4(무승부 여부)에 랜덤 지정
							randomWin = r4.nextInt(100);						// randomWin에 0 이상 100 미만의 정수 대입
							if (randomWin <= 99 - (insistProbability2 - 1)) {	// 무승부 발동(우기기 확률이 낮을 수록 높게 설정)
								System.out.println("음... 애매하다!");
								Thread.sleep(1000);
								System.out.println("무승부!");
								tieCount++;
								roundCount--;
							} else {											// 무승부 여부가 판별되지 않으면 우기기 성공으로 승리
								System.out.println("우기기 성공!");
								Thread.sleep(1000);
								System.out.println("치사하게 승리!");
								userPoint++;
							}
							foulGame = "";
							randomCount = 0;
						}
					} else { 											// 우기기가 발동되지 않았을 경우
						if (randomCount >= 1) {								// 우기기가 진행되었는지 여부 판별
							Random r4 = new Random();						// 변수 r4(무승부 여부)에 랜덤 지정
							randomWin = r4.nextInt(100);					// randomWin에 0 이상 100 미만의 정수 대입
							if (randomWin <= 99 - insistProbability2) {		// 무승부 발동(우기기 확률이 낮을 수록 높게 설정)
								System.out.println("음... 애매하다!");
								Thread.sleep(1000);
								System.out.println("무승부!");
								tieCount++;
								roundCount--;
							} else {										// 무승부 여부가 판별되지 않으면 우기기 실패로 패배
								System.out.println("우기기 실패...");
								Thread.sleep(1000);
								System.out.println("패배!");
								computerPoint++;
							}
						} else {										// 우기기가 한 번도 발동되지 않을 경우
							System.out.println("반칙패!");					// 반칙패 메시지 출력
							computerPoint++;
						}
						insistProbability2 = insistProbability;			// 우기기 확률 초기화
						foulGame = "";
						randomCount = 0;
					}
				}
			} else if (foulGame.equals("nothing")) {							// 반칙여부가 확인될 경우
				System.out.println("안 내면 진 거!!");									// 반칙패 메시지 출력
				computerPoint++;													// 컴퓨터의 승리로 처리
				foulGame = "";														// 반칙여부 초기화
			} else if (resultGame == 0) {										// 같은 값이 나와서 무승부일 경우
				System.out.println("무승부!");										// 무승부 메시지 츌력
				tieCount++;															// 무승부 카운트 증가
				roundCount--;
			} else if ((resultGame == 1) || (resultGame == -2)) {				// 승리의 경우 수가 나올 경우
				System.out.println("승리!");											// 승리 메시지 출력
				userPoint++;														// 유저 승점 증가
			} else if ((resultGame == -1) || (resultGame == 2)) {				// 패배의 경우 수가 나올 경우
				System.out.println("패배!");											// 패배 메시지 출력
				computerPoint++;													// 컴퓨터 승점 증가
			}
			roundCount++;
			Thread.sleep(1000);
		}																		// 반복문 끝
		System.out.println("\r\n승부 종료!");
		Thread.sleep(1000);
		System.out.print("\r\n정산중");												// 정산중 메시지를 띄우고 1초마다 .을 찍음
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}
		Thread.sleep(1000);
		System.out.printf("\r\n\r\n%d승 %d패로 당신이 ", userPoint, computerPoint);
		if (userPoint >= playOff) {													// 승패 여부에 따라 메시지 차등 출력
			System.out.println("이겼습니다!");
		} else {
			System.out.println("졌습니다.");
		}
	}
}