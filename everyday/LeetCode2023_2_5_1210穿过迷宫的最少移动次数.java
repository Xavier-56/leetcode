package everyday;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode2023_2_5_1210穿过迷宫的最少移动次数 {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        dist[0][0][0] = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], status = arr[2];
            if (status == 0) {
                if (y + 2 < n && dist[x][y + 1][0] == -1 && grid[x][y + 2] == 0) {
                    dist[x][y + 1][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y + 1, 0});
                }
                if (x + 1 < n && dist[x + 1][y][0] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x + 1][y][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x + 1, y, 0});
                }
                if (x + 1 < n && y + 1 < n && dist[x][y][1] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][1] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y, 1});
                }
            } else {
                if (y + 1 < n && dist[x][y + 1][1] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y + 1][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y + 1, 1});
                }
                if (x + 2 < n && dist[x + 1][y][1] == -1 && grid[x + 2][y] == 0) {
                    dist[x + 1][y][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x + 1, y, 1});
                }
                if (x + 1 < n && y + 1 < n && dist[x][y][0] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][0] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y, 0});
                }
            }
        }
        return dist[n - 1][n - 2][0];
    }
}
