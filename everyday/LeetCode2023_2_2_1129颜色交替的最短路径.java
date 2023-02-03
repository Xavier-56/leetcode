package everyday;

import java.util.*;

public class LeetCode2023_2_2_1129颜色交替的最短路径 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] es = new List[2][n];
        for (int i = 0; i < n; i++) {
            es[0][i] = new ArrayList();
            es[1][i] = new ArrayList();
        }

        for (int[] r : redEdges) es[0][r[0]].add(r[1]);
        for (int[] b : blueEdges) es[1][b[0]].add(b[1]);

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;

        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});

        boolean[][] visited = new boolean[2][n];
        int dis = 1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] pos = q.poll();
                for (int next : es[pos[1]][pos[0]]) {
                    if (visited[pos[1] ^ 1][next]) continue;
                    visited[pos[1] ^ 1][next] = true;
                    if (ans[next] == -1) ans[next] = dis;
                    q.offer(new int[]{next, pos[1] ^ 1});
                }
            }
            dis++;
        }
        return ans;
    }
}
