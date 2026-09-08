import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeetCode13 {

    public static int romanToInt(String s) {

        Map<Character, Integer> roman = new HashMap<>();

        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int curr = roman.get(s.charAt(i));

            int next = 0;

            if (i + 1 < n) {
                next = roman.get(s.charAt(i + 1));
            }

            if (curr < next) {
                total -= curr;
            } else {
                total += curr;
            }
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so La Ma: ");
        String s = scanner.nextLine();

        int result = romanToInt(s);

        System.out.println("Gia tri so nguyen: " + result);

        scanner.close();
    }
}