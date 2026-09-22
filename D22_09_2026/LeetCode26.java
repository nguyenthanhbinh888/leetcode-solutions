package D22_09_2026;

import java.util.Arrays;

public class LeetCode26 {

    public static int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int k = removeDuplicates(nums);

        System.out.println("k = " + k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
