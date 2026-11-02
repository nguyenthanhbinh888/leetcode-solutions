package D2_11_2026;


import java.util.Arrays;
import java.util.Scanner;

public class Leetcode462 {

    public static int minMoves2(int[] nums) {

        // Bước 1: Sắp xếp mảng
        Arrays.sort(nums);

        // Bước 2: Tìm trung vị
        int median = nums[nums.length / 2];

        // Bước 3: Tính tổng số bước
        int result = 0;

        for (int num : nums) {
            result += Math.abs(num - median);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Nhap cac phan tu:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = minMoves2(nums);

        System.out.println("So buoc it nhat: " + result);

        sc.close();
    }
}

