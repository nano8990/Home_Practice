import java.util.Scanner;

public class ScannerNextIntProblem {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = 0;
        String str;

        System.out.print("num 입력> ");
//        num = scan.nextInt();
//        scan.nextLine();
        try {
            num = Integer.parseInt(scan.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("잘못 입력함!");
        }

        System.out.print("str 입력> ");
        str = scan.nextLine();

        System.out.println();
        System.out.println("num : " + num);
        System.out.println("str : " + str);
        scan.close();
    }
}