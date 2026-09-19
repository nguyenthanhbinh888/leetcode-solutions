import java.util.Scanner;

public class LeetCode3870 {

    public static int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }

        return n - 999;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = scanner.nextInt();

        int result = countCommas(n);

        System.out.println("Số dấu phẩy: " + result);

        scanner.close();
    }
}