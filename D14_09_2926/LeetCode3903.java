package D14_09_2926;
import java.util.Scanner;

public class  LeetCode3903 {

    public static int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        // Tạo mảng lưu min từ vị trí i đến cuối
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Max từ đầu mảng đến vị trí hiện tại
        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Nhập các phần tử:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Nhập k: ");
        int k = sc.nextInt();

        int result = firstStableIndex(nums, k);

        System.out.println("Smallest stable index: " + result);

        sc.close();
    }
}