package everyday;

public class LeetCode2023_2_17_1139最大的以1为边界的正方形 {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] left = new int[n + 1][m + 1];
        int[][] up = new int[n + 1][m + 1];
        int maxBorder = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    int border = Math.min(left[i][j],up[i][j]);
                    while (left[i - border + 1][j] < border || up[i][j - border + 1] < border){
                        border--;
                    }
                    maxBorder = Math.max(border,maxBorder);
                }
            }
        }
        return (int) Math.pow(maxBorder,2);
    }
}
