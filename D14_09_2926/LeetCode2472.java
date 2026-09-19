package D14_09_2926;
import java.util.Scanner;

public class LeetCode2472 {

    public static int maxPalindromes(String s, int k) {

        int n = s.length();

        // dp[i] = số palindrome tối đa trong s[0...i-1]
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Không chọn palindrome kết thúc tại i - 1
            dp[i] = dp[i - 1];

            // Kiểm tra palindrome có độ dài k
            if (i >= k && isPalindrome(s, i - k, i - 1)) {
                dp[i] = Math.max(dp[i], dp[i - k] + 1);
            }

            // Kiểm tra palindrome có độ dài k + 1
            if (i >= k + 1 && isPalindrome(s, i - k - 1, i - 1)) {
                dp[i] = Math.max(dp[i], dp[i - k - 1] + 1);
            }
        }

        return dp[n];
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi s: ");
        String s = sc.nextLine();

        System.out.print("Nhap k: ");
        int k = sc.nextInt();

        int result = maxPalindromes(s, k);

        System.out.println("Maximum number of non-overlapping palindromes: " + result);

        sc.close();
    }
}