package D2_11_2026;


import java.util.*;

public class Leetcode22 {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    public static void backtrack(
            List<String> result,
            StringBuilder current,
            int open,
            int close,
            int n) {

        // Đã tạo đủ 2*n ký tự
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Thêm dấu ngoặc mở
        if (open < n) {

            current.append('(');

            backtrack(result, current, open + 1, close, n);

            // Quay lui
            current.deleteCharAt(current.length() - 1);
        }

        // Thêm dấu ngoặc đóng
        if (close < open) {

            current.append(')');

            backtrack(result, current, open, close + 1, n);

            // Quay lui
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap n: ");
        int n = sc.nextInt();

        List<String> result = generateParenthesis(n);

        System.out.println("Cac chuoi ngoac hop le:");

        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}
