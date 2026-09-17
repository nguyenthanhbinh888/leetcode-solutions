package D17_08_2026;
import java.util.Arrays;

public class LeetCode1477 {

    public static int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = 1000000000;

        int[] dp = new int[n];

        Arrays.fill(dp, INF);

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int len = right - left + 1;

                if (left > 0 && dp[left - 1] != INF) {

                    ans = Math.min(
                        ans,
                        len + dp[left - 1]
                    );
                }

                if (right == 0) {

                    dp[right] = len;

                } else {

                    dp[right] = Math.min(
                        dp[right - 1],
                        len
                    );
                }

            } else {

                if (right > 0) {
                    dp[right] = dp[right - 1];
                }

            }
        }

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 4, 3};
        int target = 3;

        int result = minSumOfLengths(arr, target);

        System.out.println("Ket qua: " + result);
    }
}