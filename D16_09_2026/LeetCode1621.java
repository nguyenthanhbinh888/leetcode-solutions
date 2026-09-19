import java.util.Scanner;

public class LeetCode1621 {

    static final long MOD = 1_000_000_007L;

    public static int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int K = 2 * k;

        long[][] dp = new long[N + 1][K + 1];

        // C(i, 0) = 1
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        // Pascal Triangle
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= Math.min(i, K); j++) {
                dp[i][j] =
                    (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        return (int) dp[N][K];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap n: ");
        int n = sc.nextInt();

        System.out.print("Nhap k: ");
        int k = sc.nextInt();

        int result = numberOfSets(n, k);

        System.out.println("Ket qua: " + result);

        sc.close();
    }
}