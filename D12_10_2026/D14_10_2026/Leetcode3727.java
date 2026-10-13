package D12_10_2026.D14_10_2026;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even = 0;
        long odd = 0;

        for (int x : nums) {
            long square = 1L * x * x;

            long newOdd = Math.max(odd, even + square);
            long newEven = Math.max(even, odd - square);

            odd = newOdd;
            even = newEven;
        }

        return odd;
    }
}

public class Leetcode3727 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3};

        System.out.println(solution.maxAlternatingSum(nums));
    }
}
