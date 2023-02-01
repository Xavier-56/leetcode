package everyday;

public class LeetCode2023_1_31_2319判断矩阵是否是一个X矩阵 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j || i + j == n - 1) && grid[i][j] == 0) {
                    return false;
                } else if (i != j && i + j != n - 1 && grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
