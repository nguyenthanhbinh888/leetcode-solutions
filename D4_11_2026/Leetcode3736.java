package D4_11_2026;


import java.util.Scanner;

public class Leetcode3736 {

    public static int minMoves(int[] nums) {
        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int ans = 0;

        for (int num : nums) {
            ans += max - num;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(minMoves(nums));

        sc.close();
    }
}
