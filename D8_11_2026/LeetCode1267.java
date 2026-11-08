package D8_11_2026;
public class LeetCode1267 {
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 &&
                    (row[i] > 1 || col[j] > 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0},
            {1, 1}
        };

        System.out.println(countServers(grid));
    }
}
