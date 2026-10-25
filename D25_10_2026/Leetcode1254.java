package D25_10_2026;


public class Leetcode1254 {
    private static int rows;
    private static int cols;

    public static int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        // Loai bo cac vung dat cham bien
        for (int i = 0; i < rows; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            dfs(grid, 0, j);
            dfs(grid, rows - 1, j);
        }

        int count = 0;

        // Dem cac dao kin
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= rows ||
            c < 0 || c >= cols ||
            grid[r][c] == 1) {
            return;
        }

        grid[r][c] = 1;

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
        };

        System.out.println(closedIsland(grid));
    }
}
