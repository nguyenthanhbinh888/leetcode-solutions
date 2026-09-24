package D24_09_2026;
import java.util.Arrays;

public class Leetcode3550 {

    public static int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int n = nums[i];
            int sum = 0;

            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 6};

        int result = smallestIndex(nums);

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("Result = " + result);
    }
}