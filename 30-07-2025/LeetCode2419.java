import java.util.Scanner;

public class LeetCode2419 {

    public static int longestSubarray(int[] nums) {

        int maxVal = nums[0];

        // Tìm giá trị lớn nhất trong mảng
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int maxLen = 0;
        int curLen = 0;

        // Tìm đoạn liên tiếp dài nhất gồm các số = maxVal
        for (int num : nums) {

            if (num == maxVal) {
                curLen++;

                if (curLen > maxLen) {
                    maxLen = curLen;
                }

            } else {
                curLen = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Nhap cac phan tu:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = longestSubarray(nums);

        System.out.println("Ket qua: " + result);

        scanner.close();
    }
}