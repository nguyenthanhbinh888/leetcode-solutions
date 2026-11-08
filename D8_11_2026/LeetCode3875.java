package D8_11_2026;


public class LeetCode3875 {

    public static boolean uniformArray(int[] nums) {
        int even = 0;
        int odd = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return even == 0 || odd == 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(uniformArray(nums));
    }
}
