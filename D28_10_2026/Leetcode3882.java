package D28_10_2026;


class Leetcode3882 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MAX_XOR = 1024;

        boolean[][][] dp =
                new boolean[m][n][MAX_XOR];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int value = grid[i][j];

                if (i > 0) {
                    for (int x = 0; x < MAX_XOR; x++) {
                        if (dp[i - 1][j][x]) {
                            dp[i][j][x ^ value] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int x = 0; x < MAX_XOR; x++) {
                        if (dp[i][j - 1][x]) {
                            dp[i][j][x ^ value] = true;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < MAX_XOR; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
