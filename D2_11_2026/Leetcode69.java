package D2_11_2026;


import java.util.Scanner;

public class Leetcode69 {

    public static int mySqrt(int x) {

        int left = 0;
        int right = x;
        int result = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Kiểm tra mid có phải căn bậc hai hợp lệ không
            if (mid <= x / Math.max(mid, 1)) {

                result = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap x: ");
        int x = sc.nextInt();

        System.out.println("Can bac hai nguyen: " + mySqrt(x));

        sc.close();
    }
}
