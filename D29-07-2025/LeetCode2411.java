import java.util.Arrays;
import java.util.Scanner;

public class LeetCode2411 {

    public static int[] smallestSubarrays(int[] nums) {

        int n = nums.length;

        int[] res = new int[n];

        // lastSeen[b] = vị trí gần nhất bên phải
        // mà bit b xuất hiện
        int[] lastSeen = new int[32];

        Arrays.fill(lastSeen, -1);

        // Duyệt từ phải sang trái
        for (int i = n - 1; i >= 0; i--) {

            // Kiểm tra 32 bit của nums[i]
            for (int b = 0; b < 32; b++) {

                // Nếu bit b của nums[i] = 1
                if (((nums[i] >>> b) & 1) == 1) {
                    lastSeen[b] = i;
                }
            }

            int furthest = i;

            // Tìm vị trí xa nhất cần đi tới
            for (int b = 0; b < 32; b++) {

                if (lastSeen[b] != -1) {
                    furthest = Math.max(
                            furthest,
                            lastSeen[b]
                    );
                }
            }

            // Độ dài subarray
            res[i] = furthest - i + 1;
        }

        return res;
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

        int[] result = smallestSubarrays(nums);

        System.out.println(
                "Ket qua: " + Arrays.toString(result)
        );

        scanner.close();
    }
}