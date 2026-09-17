import java.util.Stack;

public class LeetCode20 {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Dấu mở
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            // Dấu đóng
            else {

                // Stack rỗng -> không có dấu mở
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Kiểm tra cặp ngoặc
                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        // Stack phải rỗng
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "({[]})";

        boolean result = isValid(s);

        System.out.println(result);
    }
}