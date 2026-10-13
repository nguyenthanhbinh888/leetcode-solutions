package D12_10_2026.D14_10_2026;

public class Leetcode58 {
    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        // Bỏ qua dấu cách ở cuối chuỗi
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;

        // Đếm ký tự của từ cuối cùng
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World";

        int result = lengthOfLastWord(s);

        System.out.println("Length of last word: " + result);
    }
}
