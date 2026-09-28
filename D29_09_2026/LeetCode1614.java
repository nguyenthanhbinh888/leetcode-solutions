package D29_09_2026;

import java.util.Scanner;

public class LeetCode1614 {
    public static int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine();

        int result = maxDepth(s);

        System.out.println("Maximum Nesting Depth: " + result);

        sc.close();
    }
}