import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LeetCode898 {

    public static int subarrayBitwiseORs(int[] arr) {

        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();

        for (int num : arr) {

            Set<Integer> next = new HashSet<>();

            // Subarray mới chỉ chứa num
            next.add(num);

            // Nối num vào các subarray trước đó
            for (int x : cur) {
                next.add(x | num);
            }

            cur = next;

            // Thêm tất cả kết quả OR vào res
            res.addAll(cur);
        }

        return res.size();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Nhap cac phan tu:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = subarrayBitwiseORs(arr);

        System.out.println("Ket qua: " + result);

        scanner.close();
    }
}