package D12_10_2026.D14_10_2026;


import java.util.Arrays;

public class Leetcode66 {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Duyệt từ chữ số cuối cùng về đầu
        for (int i = n - 1; i >= 0; i--) {

            // Nếu chữ số nhỏ hơn 9, tăng lên 1 rồi trả về
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // Nếu bằng 9, đổi thành 0 và tiếp tục
            digits[i] = 0;
        }

        // Trường hợp tất cả chữ số đều là 9
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 9};

        int[] result = plusOne(digits);

        System.out.println(Arrays.toString(result));
    }
}
