import java.util.Scanner;

public class LeetCode14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong chuoi: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strs = new String[n];

        System.out.println("Nhap cac chuoi:");

        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        String result = longestCommonPrefix(strs);

        System.out.println("Tien to chung dai nhat: " + result);

        scanner.close();
    }
}