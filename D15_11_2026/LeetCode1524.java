package D15_11_2026;


import java.util.Scanner;

public class LeetCode1524 {

    public static int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        long even = 1;
        long odd = 0;
        long prefix = 0;
        long ans = 0;

        for (int x : arr) {
            prefix += x;

            if (prefix % 2 == 0) {
                ans = (ans + odd) % MOD;
                even++;
            } else {
                ans = (ans + even) % MOD;
                odd++;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(numOfSubarrays(arr));

        sc.close();
    }
}
