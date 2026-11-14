package D14_11_2026;


import java.util.*;

public class Leetcode3364 {

    public static int minimumSumSubarray(
            List<Integer> nums, int l, int r) {

        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n && j - i + 1 <= r; j++) {
                sum += nums.get(j);

                int length = j - i + 1;

                if (length >= l && sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(3, -2, 1, 4);

        int l = 2;
        int r = 3;

        int result = minimumSumSubarray(nums, l, r);

        System.out.println("Result: " + result);
    }
}
