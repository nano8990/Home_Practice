import java.util.Random;
import java.util.Scanner;

public class If_While_Scanner {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����� ��ǻ�Ϳ� ���������� 3�� 2�������� �ǽ��� ���Դϴ�.");
		int userPoint = 0;			// ������ ���� ī��Ʈ
		int computerPoint = 0;		// ��ǻ���� ���� ī��Ʈ
		int roundCount = 1;			// ���� �� ��° ������� �ȳ�
		int tieCount = 0;			// ���º� ī��Ʈ
		int userValue = 0;			// ����, ����, ���� ���� 0, 1, 2�� �����Ͽ� ����ϱ� ���� ��ġ
		String foulGame = "";		// ��Ģ ���� Ȯ��
		
		while ((userPoint < 2) && (computerPoint < 2)) {						// ������ ��ǻ���� ���� ī��Ʈ�� 2���� ���� ���� �ݺ�
			if (tieCount == 0) {												// ���ºΰ� �ƴ� ���
				System.out.printf("%d��° ��� ����! ", roundCount);						// ��� ���� �޽����� ���
				if (roundCount >= 2) {												// 2���� �̻��� ���
					System.out.printf("���� %d�� %d��", userPoint, computerPoint);		// ���ھ� Ȯ��
				}
			} else {															// ���º��� ���
				System.out.print("���� ����!");										// ���� ���� �޽����� ���
				tieCount--;															// ���º� ī��Ʈ �ʱ�ȭ
			}
			System.out.println("\r\nrock, paper, scissors �� �ϳ��� �Է��Ͻʽÿ�.");
			Scanner s = new Scanner(System.in);									// ���� s�� ��ĳ�� ����
			String userEnter = s.nextLine();									// ���� userEnter�� �ԷµǴ� ���ڸ� ����
			System.out.print("\r\n����! ");										// ����! ����! ��! �޽����� 1�� �������� ���
			Thread.sleep(1000);
			System.out.print("����! ");
			Thread.sleep(1000);
			System.out.println("��!\r\n");
			switch (userEnter) {												// ������ �Է��� ����
			case "scissors":														// ������ ���
				userValue = 0;														// �������� 0���� ����
				System.out.print("����� ������ ����!");
				break;
			case "rock":															// ������ ���
				userValue = 1;														// �������� 1�� ����
				System.out.print("����� ������ ����!");
				break;
			case "paper":															// ���� ���
				userValue = 2;														// �������� 2�� ����
				System.out.print("����� ������ ��!");
				break;
			case "":																// �ƹ� �͵� �Է����� �ʾ��� ���
				foulGame = "nothing";												// ��Ģ���ο� nothing ����
				System.out.print("����� �ƹ� �͵� ���� �ʾҴ�!");	
				break;
			default:																// �̿��� ���� �Է����� ���
				foulGame = "strange";												// ��Ģ���ο� strange ����
				System.out.print("����� �ƹ��� �˾ƺ� �� ���� �̻��� ����� �´�!");
				break;
			}
			Thread.sleep(1000);
			Random r = new Random();											// ���� r�� ���� ����
			int computerEnter = r.nextInt(3);									// computerEnter ������ 0�̻� 3�̸��� ���� ����
			switch (computerEnter) {											// ��ǻ�Ͱ� �Է��� ����
			case 0:																	// 0(����)�� ���
				System.out.println(" / ������ ������ ����!");
				break;
			case 1:																	// 1(����)�� ���
				System.out.println(" / ������ ������ ����!");
				break;
			case 2:																	// 2(��)�� ���
				System.out.println(" / ������ ������ ��!");
				break;
			}
			Thread.sleep(1000);
			int resultGame = userValue - computerEnter;							// �������� ��ǻ�� �Է°��� ���̸� ���Ͽ� ���� ����
			if (foulGame.equals("strange")) {									// ��Ģ���ΰ� Ȯ�ε� ���
				System.out.println("��Ģ��!\r\n");									// ��Ģ�� �޽��� ���
				computerPoint++;													// ��ǻ���� �¸��� ó��
				roundCount++;														// ���� ����
				foulGame = "";														// ��Ģ���� �ʱ�ȭ
			} else if (foulGame.equals("nothing")) {							// ��Ģ���ΰ� Ȯ�ε� ���
				System.out.println("�� ���� �� ��!!\r\n");								// ��Ģ�� �޽��� ���
				computerPoint++;													// ��ǻ���� �¸��� ó��
				roundCount++;														// ���� ����
				foulGame = "";														// ��Ģ���� �ʱ�ȭ
			} else if (resultGame == 0) {										// ���� ���� ���ͼ� ���º��� ���
				System.out.println("���º�!\r\n");									// ���º� �޽��� ����
				tieCount++;															// ���º� ī��Ʈ ����
			} else if ((resultGame == 1) || (resultGame == -2)) {				// �¸��� ��� ���� ���� ���
				System.out.println("�¸�!\r\n");										// �¸� �޽��� ���
				userPoint++;														// ���� ���� ����
				roundCount++;														// ���� ����
			} else if ((resultGame == -1) || (resultGame == 2)) {				// �й��� ��� ���� ���� ���
				System.out.println("�й�!\r\n");										// �й� �޽��� ���
				computerPoint++;													// ��ǻ�� ���� ����
				roundCount++;														// ���� ����
			}
			Thread.sleep(1000);
		}																		// �ݺ��� ��
		System.out.println("�º� ����!\r\n");
		Thread.sleep(1000);
		System.out.print("������");												// ������ �޽����� ���� 1�ʸ��� .�� ����
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.print(".");
		}
		Thread.sleep(1000);
		System.out.printf("\r\n\r\n%d�� %d�з� ����� ", userPoint, computerPoint);
		if (userPoint >= 2) {													// ���� ���ο� ���� �޽��� ���� ���
			System.out.println("�̰���ϴ�!");
		} else {
			System.out.println("�����ϴ�.");
		}
	}
}