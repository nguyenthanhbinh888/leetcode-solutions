package D21_09_2026;

import java.util.Arrays;

public class LeetCode3524 {

    public static long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int mod = num % k;

            long[] newDp = new long[k];

            // Subarray chỉ gồm num
            newDp[mod] = 1;

            // Nối num vào các subarray trước đó
            for (int i = 0; i < k; i++) {
                int newMod = (int) ((long) i * mod % k);
                newDp[newMod] += dp[i];
            }

            // Cộng vào kết quả
            for (int i = 0; i < k; i++) {
                result[i] += newDp[i];
            }

            dp = newDp;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;

        long[] result = resultArray(nums, k);

        System.out.println(Arrays.toString(result));
    }
}