package D20_09_2026;

import java.util.Scanner;

public class LeetCode3498 {

    public static int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = 26 - (s.charAt(i) - 'a');
            int position = i + 1;

            sum += value * position;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String s = scanner.nextLine();

        int result = reverseDegree(s);

        System.out.println("Reverse Degree = " + result);

        scanner.close();
    }
}