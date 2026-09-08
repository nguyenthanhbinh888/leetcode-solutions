import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class LeetCode1 {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // Nếu đã có phần bù trong map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Lưu giá trị hiện tại và vị trí của nó
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Nhap cac phan tu:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Nhap target: ");
        int target = scanner.nextInt();

        int[] result = twoSum(nums, target);

        System.out.println("Ket qua: " + Arrays.toString(result));

        scanner.close();
    }
}