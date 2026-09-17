public class LeetCode835 {

    public static int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;

        // Dịch img1 theo mọi hướng
        for (int dx = -(n - 1); dx <= n - 1; dx++) {
            for (int dy = -(n - 1); dy <= n - 1; dy++) {

                int count = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int x = i + dx;
                        int y = j + dy;

                        // Kiểm tra vị trí sau khi dịch còn nằm trong ảnh
                        if (x >= 0 && x < n &&
                            y >= 0 && y < n) {

                            if (img1[i][j] == 1 &&
                                img2[x][y] == 1) {
                                count++;
                            }
                        }
                    }
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] img1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };

        int[][] img2 = {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        };

        int result = largestOverlap(img1, img2);

        System.out.println("Kết quả: " + result);
    }
}